# -*- coding:UTF-8 -*-

import cmd
from distutils import command
from xml.etree import ElementTree

from com.utls.pro_env import PROJECT_CONF_DIR
from com.utls.sqoop import SqoopUtil


#其中dt为昨天的日期，将由调度模块传入
def resolve_conf(dt):
    #获得配置文件名
    conf_file = PROJECT_CONF_DIR + "import.xml"
    #解析配置文件
    xml_tree = ElementTree.parse(conf_file)
    #获得task元素
    tasks = xml_tree.findall('./task')
    
    
    for task in tasks:
        #获得导入类型，增量导入或者全量导入
        import_type = task.attrib["type"]
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
                command = "sqoop "  + sqoop_cmd_type
                #如果为全量导入
                if(import_type == "all"):
                    #query的查询条件为<dt
                    import_condition = " < '" + dt + "'"
                elif (import_type == "add"):
                    #query的查询条件为=dt
                    import_condition = "= '" + dt + "'"
                else:
                    raise Exception
                import_condition += " and \$CONDITIONS"
                #迭代将param的信息拼装成字符串
                for key in cmap.keys() :
                    value = cmap[key]
                    if(value == None or value == "" or value == " ") :
                         value = ""
                     #将query中的condititon换位查询条件
                    if(key == "query") :
                         value = value.replace('\$CONDITIONS',import_condition)
                         print(value)
                     # #将导入分区替换为传入的时间
                    if(key == "hive-partition-value") :
                        value = value.replace("\$dt",dt)
                     #拼装成命令
                    command += " --" + key + " " + value + " "
             #将命令加入待执行命令集合
            cmds.append(command)
             
    return cmds

#Python模块的入口：main函数
if __name__ == '__main__' :
    #调度模块将昨天的时间导入
#     dt = sys.argv[0]
    dt = '2017-10-28'
#     dt = "date_format(" + dt + ",'%Y-%c-%d')"
    #解析配置文件，获得sqoop命令集合
    cmds = resolve_conf(dt)
    #迭代集合，执行命令
    for i in range(len(cmds)) :
        cmd = cmds[i]
        print(cmd)
        #执行导入过程
        SqoopUtil.execute_shell(cmd)
        
   
                 
                 
                 
                 
                 
            
            
            
            
            
            