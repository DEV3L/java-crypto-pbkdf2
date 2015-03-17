package com.dev3l.crypto.properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CryptoPropertiesSingleton {
	private static final Logger logger = LogManager.getLogger();
	private static final String CRYPTO_CONFIGURATION_PROPERTIES_FILE = "crypto_configuration.properties";

	private static PropertiesConfiguration propertiesConfiguration = null;
	private static CryptoPropertiesBean cryptoPropertiesBean = null;
	private static long fileModified = 0l;

	private CryptoPropertiesSingleton() {
	}

	public static final CryptoPropertiesBean getCryptoPropertiesBeanInstance() {
		if ((propertiesConfiguration == null) || (fileModified != propertiesConfiguration.getFile().lastModified())) {
			try {
				propertiesConfiguration = new PropertiesConfiguration(CRYPTO_CONFIGURATION_PROPERTIES_FILE);
			} catch (final ConfigurationException e) {
				logger.error(e.getMessage(), e);
				return null;
			}

			propertiesConfiguration.setReloadingStrategy(new FileChangedReloadingStrategy());
			fileModified = propertiesConfiguration.getFile().lastModified();
			cryptoPropertiesBean = CryptoPropertiesFactory.createCryptoPropertiesBeanFromPropertiesFile(propertiesConfiguration);
		}

		return cryptoPropertiesBean;
	}
}
