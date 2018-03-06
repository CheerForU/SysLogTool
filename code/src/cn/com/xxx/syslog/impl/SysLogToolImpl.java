package cn.com.xxx.syslog.impl;

import org.productivity.java.syslog4j.Syslog;
import org.productivity.java.syslog4j.SyslogConfigIF;
import org.productivity.java.syslog4j.SyslogIF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.xxx.syslog.api.SysLogTool;

public class SysLogToolImpl implements SysLogTool
{
    SyslogIF syslog = null;
    SyslogConfigIF config = null;
    private static Logger LOGGER = LoggerFactory.getLogger(SysLogTool.class);

    /**
     * 使用默认参数初始化SysLog工具
     * (协议：udp，主机地址：127.0.0.1，端口号：514，字符集：utf-8，设施:用户)
     */
    @Override
    public void init()
    {
        if (null != syslog || null != config)
        {
            LOGGER.info("SysLogTool had been inited.");
            return;
        }
        syslog = Syslog.getInstance(SysLogTool.DEFAULT_PROTOCOL);
        syslog.getConfig().setHost(SysLogTool.DEFAULT_HOST);
        syslog.getConfig().setPort(SysLogTool.DEFAULT_PORT);
        syslog.getConfig().setCharSet(SysLogTool.DEFAULT_CHARSET);
        syslog.getConfig().setFacility(SysLogTool.DEFAULT_FACILITY);
    }

    /**
     * 初始化SysLog工具,设施类型使用默认值-用户
     * @param protocol 使用协议
     * @param host 主机地址
     * @param port 端口号
     * @param charset 字符集
     */
    @Override
    public void init(final String protocol, final String host, final int port,
            final String charset)
    {
        if (null != syslog || null != config)
        {
            LOGGER.info("SysLogTool had been inited.");
            return;
        }
        syslog = Syslog.getInstance(protocol);
        syslog.getConfig().setHost(host);
        syslog.getConfig().setPort(port);
        syslog.getConfig().setCharSet(charset);
        syslog.getConfig().setFacility(SysLogTool.DEFAULT_FACILITY);
    }

    /**
     * 初始化SysLog工具
     * @param protocol 使用协议
     * @param host 主机地址
     * @param port 端口号
     * @param charset 字符集
     * @param facility 设施类型
     */
    @Override
    public void init(final String protocol, final String host, final int port,
            final String charset, final int facility)
    {
        if (null != syslog || null != config)
        {
            LOGGER.info("SysLogTool had been inited.");
            return;
        }
        syslog = Syslog.getInstance(protocol);
        config = syslog.getConfig();
        config.setHost(host);
        config.setPort(port);
        config.setCharSet(charset);
        config.setFacility(facility);
    }

    /**
     * 销毁 SysLog工具
     */
    @Override
    public void destroy()
    {
        if (null == syslog)
        {
            LOGGER.info("SysLogTool had been destroyed.");
            return;
        }
        syslog.shutdown();
        Syslog.destroyInstance("udp");
        Syslog.destroyInstance("tcp");
        Syslog.initialize();
        config = null;
        syslog = null;
    }

    /**
     * 发送日志消息
     * @param level 消息等级
     * @param content 消息内容
     */
    @Override
    public void log(final int level, final String content)
    {
        try
        {
            syslog.log(level, content);
            syslog.flush();
        }
        catch (final Exception e)
        {
            LOGGER.error(e.toString());
        }
    }

    /**
     * 获取使用协议
     * @return 使用协议
     */
    @Override
    public String getProtocol()
    {
        return syslog.getProtocol();
    }

    /**
     * 获取主机地址
     * @return 主机地址
     */
    @Override
    public String getHost()
    {
        return config.getHost();
    }

    /**
     * 获取端口
     * @return 端口
     */
    @Override
    public int getPort()
    {
        return config.getPort();
    }

    /**
     * 获取使用字符集
     * @return 字符集
     */
    @Override
    public String getCharset()
    {
        return config.getCharSet();
    }

    /**
     * 获取发送设施类型
     * @return 设施类型
     */
    @Override
    public int getFacility()
    {
        return config.getFacility();
    }

}