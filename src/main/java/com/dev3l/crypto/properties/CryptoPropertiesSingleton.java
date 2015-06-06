package com.dev3l.crypto.properties;

import java.io.FileNotFoundException;
import java.net.URL;

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

	public static final CryptoPropertiesBean getCryptoPropertiesBeanInstance() throws FileNotFoundException {
		if ((propertiesConfiguration == null)
				|| ((propertiesConfiguration.getFile() != null) && (fileModified != propertiesConfiguration.getFile().lastModified()))) {
			final URL propertiesFilePath = getPropertiesFilePath();

			try {
				propertiesConfiguration = new PropertiesConfiguration(propertiesFilePath);
			} catch (final ConfigurationException e) {
				logger.error(e.getMessage(), e);
				return null;
			}

			propertiesConfiguration.setReloadingStrategy(new FileChangedReloadingStrategy());

			if (propertiesConfiguration.getFile() != null) {
				fileModified = propertiesConfiguration.getFile().lastModified();
			}

			cryptoPropertiesBean = CryptoPropertiesFactory.createCryptoPropertiesBeanFromPropertiesFile(propertiesConfiguration);
			logger.info("Crpto properties loaded:\n" + cryptoPropertiesBean);
		}

		return cryptoPropertiesBean;
	}

	private static URL getPropertiesFilePath() throws FileNotFoundException {
		URL propertiesFilePath = CryptoPropertiesSingleton.class.getClassLoader().getResource(CRYPTO_CONFIGURATION_PROPERTIES_FILE);

		if (propertiesFilePath == null) {
			propertiesFilePath = CryptoPropertiesSingleton.class.getResource(CRYPTO_CONFIGURATION_PROPERTIES_FILE);

			if (propertiesFilePath == null) {
				throw new FileNotFoundException("Config resource " + CRYPTO_CONFIGURATION_PROPERTIES_FILE
						+ " was not found on the classpath.");
			}
		}

		return propertiesFilePath;
	}
}
