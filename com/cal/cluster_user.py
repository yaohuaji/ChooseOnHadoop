#提取数据并作归一化

from com.utls.hive import HiveUtil
def prepare_normaliz(start_time,end_time):
    hql = "insert overwrite table user_dimension \
    select t1.CustomerId,t1.avg,t2.ordercount,t3.sessioncount from \
    (select CustomerId,avg(SubTotal) avg from Orders where dt <= " + start_time + " and dt >= " + end_time + " group by CustomerId) t1 join \
    (select CustomerId,count(PKId) ordercount from Orders where dt <= "  + start_time + " and dt >= " + end_time + " group by CustomerId) t2 on t1.CustomerId = t2.CustomerId \
    join (select userId,count(sessionId) sessioncount from clickstream_log where dt <= " + start_time + " and dt >= " + end_time + " group by userId) t3 on t1.CustomerId = t3.userId"
    HiveUtil.execute_shell(hql)
    
    hql = "insert overwrite table cluster_input select SubTotal,OrdersCount,SessionCount from user_dimension"
    HiveUtil.execute_shell(hql)
    
    #归一化
    hql = "insert overwrite table cluster_input \
    select (SubTotal - avg_SubTotal) / std_SubTotal,(OrdersCount - avg_OrdersCount) / std_OrdersCount,(SessionCount - avg_SessionCount) / std_SessionCount from cluster_input \
    join (select std(SubTotal) std_SubTotal,std(OrdersCount) std_OrdersCount,std(SessionCount) std_SessionCount from cluster_input) t1 on 1 = 1 \
    join (select avg(SubTotal) avg_SubTotal,avg(OrdersCount) avg_OrdersCount,avg(SessionCount) avg_SessionCount from cluster_input) t1 on 1 = 1 "
    HiveUtil.execute_shell(hql)
    