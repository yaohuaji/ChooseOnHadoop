# -*- coding:UTF-8 -*-
#解析配置文件
import sys
from xml.etree import ElementTree

from com.utls.hive import HiveUtil
from com.utls.pro_env import PROJECT_CONF_DIR


def resolve_conf(type,dt):
    #获得配置文件名
    confFile = PROJECT_CONF_DIR + "hivejob.xml"
    #解析配置文件
    xmlTree = ElementTree.parse(confFile)
    #Job元素
    jobs = xmlTree.findall('./Job')
    
    #用来保存hql
    hqls = []
    #遍历Job的子元素，获得所需参数
    for job in jobs:
        if job.attrib["type"] == type:
            for hql in job.getchildren():
                #获得hql标签的值去掉两头的空字符
                hql =  hql.text.strip()
                
                #检查hql的有效性，无效则抛出异常
                if len(hql) == 0 or hql == "" or hql == None:
                    raise Exception('参数有误，停止运行')
                else:
                    hql = hql.replace("\$dt",dt)
                    hqls.append(hql)
    return hqls


if  __name__ == '__main__':
    #使用调度模块传入的两个参数，第一个为可执行的type,第二个为日期
    hqls = resolve_conf("analysis","1")
    
    for hql in hqls:
        print(hql)
        HiveUtil.execute_shell(hql)



