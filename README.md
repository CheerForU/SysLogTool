# SysLogTool
syslog是日志发送和接收的一种协议，可以使用syslog协议实现自己的应用，将日志通过syslog协议从日志生产者发送到日志消费者，消费者保存日志信息，提供日志查询和管理。
实现了SysLogTool工具，SysLogUtil为单例模式，同时只向一个host发送日志若需向多个host发日志，new SysLogToolImpl实例即可。
使用方法：初始化SysLog工具，可使用默认值或设置参数（协议，主机地址，端口号，字符集，设施类型）。
