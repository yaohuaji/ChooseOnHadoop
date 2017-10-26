import os
import sys

from com.utls.pro_env import HADOOP_HOME, PROJECT_LIB_DIR


if __name__ == '__main__':
    inputPath = "/tmp/apache_log/" + sys.argv[0]
    outputPath = "/user/hive/warehouse/clickstream_log/dt=" + sys.argv[0]
    shell = HADOOP_HOME + "hadoop jar" + PROJECT_LIB_DIR + "clickstream_etl.jar com.etl.mapreduce" + inputPath + " " + outputPath
    os.system(shell)