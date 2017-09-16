package com.cbn.ins.core.dao.databse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;
/**
 * 用来解密配置中的密文(重点配置，在这里扩展用户名的解密) setUsername(name)
 * 方法对应xml中的一个property属性，password默认加密不需要重写， 还可以加密url 重写setUrl(url)
 */
@SuppressWarnings("serial")
public class DecryptDruidSource extends DruidDataSource {
	private static final Logger logger = LoggerFactory.getLogger(DecryptDruidSource.class);
	@Override
	public void setUsername(String username) {
		try {
			username = ConfigTools.decrypt(username);
		} catch (Exception e) {
			logger.error("setUsername error:",e);
		}
		super.setUsername(username);
	}
}
