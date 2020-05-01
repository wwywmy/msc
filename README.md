# msc
msc微服务示例代码


# 连接mysql提示The server time zone value xxx错误 
show variables like '%time_zone%';

set global time_zone='+8:00';

或者

C:\ProgramData\MySQL\MySQL Server 5.7

my.ini

default-time-zone='+8:00'
