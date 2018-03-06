package cn.com.xxx.syslog.api;

import org.productivity.java.syslog4j.SyslogConfigIF;

public interface SysLogTool
{
    public static final String PROTOCOL_UDP = SyslogConfigIF.UDP;
    public static final String PROTOCOL_TCP = SyslogConfigIF.TCP;
    public static final String PROTOCOL_UNIX_SYSLOG = SyslogConfigIF.UNIX_SYSLOG;

    public static final String DEFAULT_PROTOCOL = PROTOCOL_UDP;
    public static final String DEFAULT_CHARSET = "utf8";
    public static final int DEFAULT_PORT = 514;
    public static final String DEFAULT_HOST = "127.0.0.1";
    public static final int DEFAULT_FACILITY = SyslogConfigIF.FACILITY_USER;

    public static final int error = 3;
    public static final int warn = 4;
    public static final int info = 6;
    public static final int debug = 7;

    /**
     * 使用默认参数初始化SysLog工具
     * (协议：udp，主机地址：127.0.0.1，端口号：514，字符集：utf-8，设施:用户)
     */
    public void init();

    /**
     * 初始化SysLog工具,设施类型使用默认值-用户
     * @param protocol 使用协议
     * @param host 主机地址
     * @param port 端口号
     * @param charset 字符集
     */
    public void init(String protocol, String host, int port, String charset);

    /**
     * 初始化SysLog工具
     * @param protocol 使用协议
     * @param host 主机地址
     * @param port 端口号
     * @param charset 字符集
     * @param facility 设施类型
     */
    public void init(String protocol, String host, int port, String charset, int facility);

    /**
     * 销毁 SysLog工具
     */
    public void destroy();

    /**
     * 发送日志消息
     * @param level 消息等级
     * @param content 消息内容
     */
    public void log(int level, final String content);

    /**
     * 获取使用协议
     * @return 使用协议
     */
    public String getProtocol();

    /**
     * 获取主机地址
     * @return 主机地址
     */
    public String getHost();

    /**
     * 获取端口
     * @return 端口
     */
    public int getPort();

    /**
     * 获取使用字符集
     * @return 字符集
     */
    public String getCharset();

    /**
     * 获取发送设施类型
     * @return 设施类型
     */
    public int getFacility();
}