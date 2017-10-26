# -*- coding:UTF-8 -*-
import commands

from com.utls.pro_env import SQOOP_PATH


class SqoopUtil(object):
    '''
    sqoop operation
    '''
    def _init_(self):
        pass
    @staticmethod
    def execute_shell(shell,sqoop_path=SQOOP_PATH) :
        #将传入的shell命令执行
        print(sqoop_path)
        print(shell)
        status,output = commands.getstatusoutput(SQOOP_PATH + shell)
        if status != 0:
            return None
        else:
            print "success"
            
        output = str(output).split("\n")
        return output
        