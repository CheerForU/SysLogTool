package cn.com.xxx.syslog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.xxx.syslog.api.SysLogTool;
import cn.com.xxx.syslog.impl.SysLogToolImpl;

/**
 * SysLogUtil为单例模式，同时只向一个host发送日志 若需向多个host发日志，new SysLogToolImpl实例即可。
 * 
 * @author zh
 * 
 */
public class SysLogUtil {
	private static Logger LOGGER = LoggerFactory.getLogger(SysLogTool.class);

	private static SysLogToolImpl sysLogToolImpl = null;

	/**
	 * 使用默认参数初始化SysLogUtil (协议：udp，主机地址：127.0.0.1，端口号：514，字符集：utf-8，设施:用户)
	 */
	public static void init() {
		if (null != sysLogToolImpl) {
			LOGGER.info("SysLogUtil had been inited.");
			return;
		}
		sysLogToolImpl = new SysLogToolImpl();
		sysLogToolImpl.init();
	}

	/**
	 * 设置参数初始化SysLogUtil，设施类型使用默认值-用户
	 * 
	 * @param protocol
	 *            使用协议
	 * @param host
	 *            主机地址
	 * @param port
	 *            端口号
	 * @param charset
	 *            字符集
	 */
	public static void init(final String protocol, final String host, final int port, final String charset) {
		if (null != sysLogToolImpl) {
			LOGGER.info("SysLogUtil had been inited.");
			return;
		}
		sysLogToolImpl = new SysLogToolImpl();
		sysLogToolImpl.init(protocol, host, port, charset);
	}

	/**
	 * 设置参数初始化SysLogUtil
	 * 
	 * @param protocol
	 *            使用协议
	 * @param host
	 *            主机地址
	 * @param port
	 *            端口号
	 * @param charset
	 *            字符集
	 * @param facility
	 *            设施类型
	 */
	public static void init(final String protocol, final String host, final int port, final String charset,
			final int facility) {
		if (null != sysLogToolImpl) {
			LOGGER.info("SysLogUtil had been inited.");
			return;
		}
		sysLogToolImpl = new SysLogToolImpl();
		sysLogToolImpl.init(protocol, host, port, charset, facility);
	}

	/**
	 * 销毁 SysLogUtil
	 */
	public static void destroy() {
		if (null == sysLogToolImpl) {
			LOGGER.info("SysLogTool had been destroyed.");
			return;
		}
		sysLogToolImpl.destroy();
		sysLogToolImpl = null;
	}

	/**
	 * 发送日志消息
	 * 
	 * @param level
	 *            消息等级
	 * @param content
	 *            消息内容
	 */
	public static void log(final int level, final String content) {
		if (null == sysLogToolImpl) {
			LOGGER.error("SysLogUtil has not been inited.");
			return;
		}
		sysLogToolImpl.log(level, content);
	}

	/**
	 * 发送error日志消息
	 * 
	 * @param level
	 *            消息等级
	 * @param content
	 *            消息内容
	 */
	public static void error(final String content) {
		if (null == sysLogToolImpl) {
			LOGGER.error("SysLogUtil has not been inited.");
			return;
		}
		sysLogToolImpl.log(SysLogTool.error, content);
	}

	/**
	 * 发送warn日志消息
	 * 
	 * @param level
	 *            消息等级
	 * @param content
	 *            消息内容
	 */
	public static void warn(final String content) {
		if (null == sysLogToolImpl) {
			LOGGER.error("SysLogUtil has not been inited.");
			return;
		}
		sysLogToolImpl.log(SysLogTool.warn, content);
	}

	/**
	 * 发送info日志消息
	 * 
	 * @param level
	 *            消息等级
	 * @param content
	 *            消息内容
	 */
	public static void info(final String content) {
		if (null == sysLogToolImpl) {
			LOGGER.error("SysLogUtil has not been inited.");
			return;
		}
		sysLogToolImpl.log(SysLogTool.info, content);
	}

	/**
	 * 发送debug日志消息
	 * 
	 * @param level
	 *            消息等级
	 * @param content
	 *            消息内容
	 */
	public static void debug(final String content) {
		if (null == sysLogToolImpl) {
			LOGGER.error("SysLogUtil has not been inited.");
			return;
		}
		sysLogToolImpl.log(SysLogTool.debug, content);
	}

	/**
	 * 获取SyslogToolImp实例
	 * 
	 * @return SysLogToolImpl实例
	 */
	public static SysLogToolImpl getSyslogToolImp() {
		return sysLogToolImpl;
	}

	/**
	 * 获取使用协议
	 * 
	 * @return 使用协议
	 */
	public static String getProtocol() {
		if (null == sysLogToolImpl) {
			LOGGER.error("SysLogUtil has not been inited.");
		}
		return sysLogToolImpl.getProtocol();
	}

	/**
	 * 获取主机地址
	 * 
	 * @return 主机地址
	 */
	public static String getHost() {
		if (null == sysLogToolImpl) {
			LOGGER.error("SysLogUtil has not been inited.");
		}
		return sysLogToolImpl.getHost();
	}

	/**
	 * 获取端口
	 * 
	 * @return 端口
	 */
	public static int getPort() {
		if (null == sysLogToolImpl) {
			LOGGER.error("SysLogUtil has not been inited.");
		}
		return sysLogToolImpl.getPort();
	}

	/**
	 * 获取使用字符集
	 * 
	 * @return 字符集
	 */
	public static String getCharset() {
		if (null == sysLogToolImpl) {
			LOGGER.error("SysLogUtil has not been inited.");
		}
		return sysLogToolImpl.getCharset();
	}

	/**
	 * 获取发送设施类型
	 * 
	 * @return 设施类型
	 */
	public static int getFacility() {
		if (null == sysLogToolImpl) {
			LOGGER.error("SysLogUtil has not been inited.");
		}
		return sysLogToolImpl.getFacility();
	}

}