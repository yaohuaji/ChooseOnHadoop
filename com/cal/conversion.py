import os
import sys
from xml.etree.ElementTree import ElementTree

from com.utls.hive import HiveUtil
from com.utls.pro_env import PROJECT_CONF_DIR, HADOOP_PATH, PROJECT_LIB_DIR


def resolve_conf():
    #配置文件的地址
    confFile = PROJECT_CONF_DIR + "conversion.xml"
    #解析XML
    xmlTree = ElementTree.parse(confFile)
    #得到pras元素
    eles = xmlTree.findall('./pras')
    pras = eles[0]
     #用来保存漏斗的URL集合
    urls = []
    for pra in pras.getchildren():
        if pra.tag == 'url':
             url = pra.text.strip()
             if url != None or url != '':
                print url
                urls.append(url)
     #检查参数的有效性
    if len(urls) == 0:
        raise Exception('参数不全')
    return urls

#从clickstream_log表中提取数据到conversion_input表中
def extract_data(start,end):
    hql = "insert into table conversion_input partition (dt = ' " + start + "-" + end + "') \
    select url,uuid,sessionId,csvp from clickstream_log where dt >= " + start + "and dt <= " + end
    
    HiveUtil.execute_shell(hql)

def count_urls(start,end,urls):
    #MapReduce的输入路径，为sales_input表的hdfs地址
    input = "/user/warehouse/conversion_input/dt=" + start + "-" + end
    #MapReduce的输出路径，可以任意指定 
    output = "/user/temp/conversion"
    #删除上一次作业输出路径
    os.system(HADOOP_PATH + "hadoop dfs -rmr " + output)
    #将表示漏斗的正则表达式拼接成一个字段串，作为参数传递给MapReduce作业
    urlstr = ""
    for i in range(len(urls)):
        if(i == len(urls) -1):
            urlstr += urls[i]
        else:
            urlstr += urls[i] + " "
    #拼装成shell命令
    shell = HADOOP_PATH + "hadoop jar " + PROJECT_LIB_DIR + "conversion.jar " + "com.conversion.mapreduce.Driver" + input + " " + output
    + " " + urlstr
    
    #执行命令
    os.system(shell)

#将MapReduce作业的输出结果加载进中间结果表并进行汇总得到最后的结果表    
def get_result(start,end,output):
    #最终结果表的分区
    dt = start + "-" + end
    #删除作业成功的标志性文件
    shell = HADOOP_PATH + "hadoop dfs -rm " + output + "/_SUCCESS"
    os.system(shell)
    
    #删除作业的日志文件
    shell = HADOOP_PATH + "hadoop dfs -rmr " + output + "/_logs"
    os.system(shell)
    
    #将临时结果加载到中间结果表
    hql = "load data inpath '" + output + "' overwrite into table conversion_middle_result partition (dt = " + dt +")"
    HiveUtil.execute_shell(hql)
    
    
    #对中间结果进行汇总并写入最后结果表
    hql = "insert into table conversion_result partition (dt='" + start + "-" + end + "') select process,count(process),count(distinct(uuid)),process from conversion_middle_result where dt = " + dt + " group by process"
    HiveUtil.execute_shell(hql)
    
if __name__ == '__main__':
    #统计时间范围的开始的时间
    start = sys.argv[1]
    #统计时间范围的结束时间
    end = sys.argv[2]
    
    #解析配置文件
    urls = resolve_conf()
    #提取所需数据
    extract_data(start, end)
    #通过MapReduce作业进行统计
    count_urls(start, end, urls)
    #对中间结果进行汇总并得到最后的结果表
    get_result(start, end)
    
    
    
    
    
    
    
    
    