package com.dev3l.crypto.properties.test;

import org.apache.commons.configuration.ConversionException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.Assert;
import org.junit.Test;

import com.dev3l.crypto.properties.CryptoPropertiesBean;
import com.dev3l.crypto.properties.CryptoPropertiesEnum;
import com.dev3l.crypto.properties.CryptoPropertiesFactory;

public class CryptoPropertiesFactoryTest {
	private static final String pbkdf2Algorithm = "not_null_1";
	private static final String nonIntegerValue = "not_integer_value";
	private static final String pbkdf2HashByteSize = "0";
	private static final String pbkdf2Iterations = "1";
	private static final String pbkdf2SaltByteSize = "2";

	@Test
	public void createCryptoPropertiesBeanFromNullPropertiesFile() {
		final CryptoPropertiesBean cryptoPropertiesBean = CryptoPropertiesFactory.createCryptoPropertiesBeanFromPropertiesFile(null);

		Assert.assertNotNull(cryptoPropertiesBean);
		Assert.assertNull(cryptoPropertiesBean.getPbkdf2Algorithm());
		Assert.assertNull(cryptoPropertiesBean.getPbkdf2HashByteSize());
		Assert.assertNull(cryptoPropertiesBean.getPbkdf2Iterations());
		Assert.assertNull(cryptoPropertiesBean.getPbkdf2SaltByteSize());
		Assert.assertNull(cryptoPropertiesBean.getPropertiesMap());
	}

	@Test
	public void createCryptoPropertiesBeanFromPropertiesFile() {
		final PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration();
		propertiesConfiguration.addProperty("test_property", "test_value");
		CryptoPropertiesBean cryptoPropertiesBean = CryptoPropertiesFactory
				.createCryptoPropertiesBeanFromPropertiesFile(propertiesConfiguration);

		Assert.assertNotNull(cryptoPropertiesBean);
		Assert.assertNull(cryptoPropertiesBean.getPbkdf2Algorithm());
		Assert.assertNull(cryptoPropertiesBean.getPbkdf2HashByteSize());
		Assert.assertNull(cryptoPropertiesBean.getPbkdf2Iterations());
		Assert.assertNull(cryptoPropertiesBean.getPbkdf2SaltByteSize());
		Assert.assertNotNull(cryptoPropertiesBean.getPropertiesMap());

		propertiesConfiguration.addProperty(CryptoPropertiesEnum.PBKDF2_ALGORITHM.getLiteral(), pbkdf2Algorithm);
		propertiesConfiguration.addProperty(CryptoPropertiesEnum.PBKDF2_HASH_BYTE_SIZE.getLiteral(), pbkdf2HashByteSize);
		propertiesConfiguration.addProperty(CryptoPropertiesEnum.PBKDF2_ITERATIONS.getLiteral(), pbkdf2Iterations);
		propertiesConfiguration.addProperty(CryptoPropertiesEnum.PBKDF2_SALT_BYTE_SIZE.getLiteral(), pbkdf2SaltByteSize);

		cryptoPropertiesBean = CryptoPropertiesFactory.createCryptoPropertiesBeanFromPropertiesFile(propertiesConfiguration);

		Assert.assertNotNull(cryptoPropertiesBean);
		Assert.assertEquals(cryptoPropertiesBean.getPbkdf2Algorithm(), pbkdf2Algorithm);
		Assert.assertEquals(cryptoPropertiesBean.getPbkdf2HashByteSize(), new Integer(pbkdf2HashByteSize));
		Assert.assertEquals(cryptoPropertiesBean.getPbkdf2Iterations(), new Integer(pbkdf2Iterations));
		Assert.assertEquals(cryptoPropertiesBean.getPbkdf2SaltByteSize(), new Integer(pbkdf2SaltByteSize));
		Assert.assertNotNull(cryptoPropertiesBean.getPropertiesMap());
	}

	@Test(expected = ConversionException.class)
	public void createCryptoPropertiesBeanFromPropertiesFileConversionExceptionPbkdf2HashByteSize() {
		final PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration();
		propertiesConfiguration.addProperty(CryptoPropertiesEnum.PBKDF2_HASH_BYTE_SIZE.getLiteral(), nonIntegerValue);
		CryptoPropertiesFactory.createCryptoPropertiesBeanFromPropertiesFile(propertiesConfiguration);
	}

	@Test(expected = ConversionException.class)
	public void createCryptoPropertiesBeanFromPropertiesFileConversionExceptionPbkdf2Iterations() {
		final PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration();
		propertiesConfiguration.addProperty(CryptoPropertiesEnum.PBKDF2_ITERATIONS.getLiteral(), nonIntegerValue);
		CryptoPropertiesFactory.createCryptoPropertiesBeanFromPropertiesFile(propertiesConfiguration);
	}

	@Test(expected = ConversionException.class)
	public void createCryptoPropertiesBeanFromPropertiesFileConversionExceptionPbkdf2SaltByteSize() {
		final PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration();
		propertiesConfiguration.addProperty(CryptoPropertiesEnum.PBKDF2_SALT_BYTE_SIZE.getLiteral(), nonIntegerValue);
		CryptoPropertiesFactory.createCryptoPropertiesBeanFromPropertiesFile(propertiesConfiguration);
	}
}
