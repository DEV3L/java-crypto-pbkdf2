package com.dev3l.crypto.properties;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.configuration.PropertiesConfiguration;

public class CryptoPropertiesFactory {
	public static CryptoPropertiesBean createCryptoPropertiesBeanFromPropertiesFile(final PropertiesConfiguration propertiesConfiguration) {
		final CryptoPropertiesBean cryptoPropertiesBean = new CryptoPropertiesBean();

		if (propertiesConfiguration == null) {
			return cryptoPropertiesBean;
		}

		setPbkdf2PropertiesOnCryptoPropertiesBean(propertiesConfiguration, cryptoPropertiesBean);
		setPropertiesMapOnCryptoPropertiesBean(propertiesConfiguration, cryptoPropertiesBean);

		return cryptoPropertiesBean;
	}

	/**
	 * @param propertiesConfiguration
	 * @param cryptoPropertiesBean
	 */
	private static final void setPbkdf2PropertiesOnCryptoPropertiesBean(final PropertiesConfiguration propertiesConfiguration,
			final CryptoPropertiesBean cryptoPropertiesBean) {
		cryptoPropertiesBean.setPbkdf2Algorithm(propertiesConfiguration.getString(CryptoPropertiesEnum.PBKDF2_ALGORITHM.getLiteral()));
		cryptoPropertiesBean.setPbkdf2HashByteSize(propertiesConfiguration.getInteger(
				CryptoPropertiesEnum.PBKDF2_HASH_BYTE_SIZE.getLiteral(), null));
		cryptoPropertiesBean.setPbkdf2Iterations(propertiesConfiguration.getInteger(CryptoPropertiesEnum.PBKDF2_ITERATIONS.getLiteral(),
				null));
		cryptoPropertiesBean.setPbkdf2SaltByteSize(propertiesConfiguration.getInteger(
				CryptoPropertiesEnum.PBKDF2_SALT_BYTE_SIZE.getLiteral(), null));
	}

	/**
	 * @param propertiesConfiguration
	 * @param cryptoPropertiesBean
	 */
	private static final void setPropertiesMapOnCryptoPropertiesBean(final PropertiesConfiguration propertiesConfiguration,
			final CryptoPropertiesBean cryptoPropertiesBean) {
		final Iterator<String> propertiesKeys = propertiesConfiguration.getKeys();
		final Map<String, String> propertiesMap = new HashMap<String, String>();

		while (propertiesKeys.hasNext()) {
			final String key = propertiesKeys.next();
			propertiesMap.put(key, propertiesConfiguration.getString(key));
		}

		cryptoPropertiesBean.setPropertiesMap(propertiesMap);
	}
}
