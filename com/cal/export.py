# -*- coding:UTF-8 -*-

from distutils import command
import sys
from xml.etree import ElementTree

from com.utls.pro_env import PROJECT_CONF_DIR
from com.utls.sqoop import SqoopUtil


#其中dt为昨天的日期，将由调度模块传入
def resolve_conf(dt):
    #获得配置文件名
    conf_file = PROJECT_CONF_DIR + "export.xml"
    #解析配置文件
    xml_tree = ElementTree.parse(conf_file);
    #获得task元素
    tasks = xml_tree.findall('./task')
    
    
    for task in tasks:
        #获得表名集合
        tables = task.findall('./table')
        
        #保存待执行的Sqoop命令的集合
        cmds = []
        #迭代表名集合，解析表配置文件
        for i in range(len(tables)):
            #表名
            table_name = tables[i].text
            #表配置文件名
            table_conf_name = PROJECT_CONF_DIR + table_name + ".xml"
            #解析表配置文件
            xmlTree = ElementTree.parse(table_conf_name)
            
            
            #获取sqoop-shell节点
            sqoopNodes = xmlTree.findall("./sqoop-shell")
            #获取sqoop命令类型
            sqoop_cmd_type = sqoopNodes[0].attrib["type"]
            #获取元素
            praNodes = sqoopNodes[0].findall("./param")
            #保存param的信息的字典
            cmap = {}
            
            for i in range(len(praNodes)):
                #获取key属性的值
                key = praNodes[i].attrib["key"]
                #获得paran标签的值
                value = praNodes[i].text
                #保存到字典里
                cmap[key] = value
                
                #首先组装成sqoop命令头
                command = "sqoop " + " " + sqoop_cmd_type
                
                #迭代将param的信息拼装成字符串
                for key in cmap.keys() :
                    value = cmap[key]
                    if(value == None or value == "" or value == " ") :
                         value = ""
                    if(key == "export-dir"):
                        value = value.replace("$dt", dt)
                     #拼装成命令
                    command += " --" + key + " " + value
             #将命令加入待执行命令集合
            cmds.append(command)
             
    return cmds
#Python模块的入口：main函数
if __name__ == '__main__':
#     #使用调度模块传入的两个参数，第一个为可执行的type,第二个为日期
#     #导出模块还未测试
#     hqls = resolve_conf(sys.argv[0],sys.argv[1])
#     for hql in hqls:
#         HiveUtil.execute_shell(hql) 
    dt = '20171026'
    cmds = resolve_conf(dt)
    for i in range(len(cmds)):
        cmd = cmds[i]
        print(cmd)
        SqoopUtil.execute_shell(cmd)
    
   
                 
                 
                 
                 
                 
            
            
            
            
            
            