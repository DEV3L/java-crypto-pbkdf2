package com.dev3l.crypto;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dev3l.crypto.properties.CryptoPropertiesBean;
import com.dev3l.crypto.properties.CryptoPropertiesSingleton;

public class Pbkdf2Encrypter {
	private static final Logger logger = LogManager.getLogger();

	private Pbkdf2Encrypter() {
	}

	/**
	 * @param password
	 * @param salt Hex encoded bytes
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String encrypt(final String password, final String salt) throws FileNotFoundException {
		if (StringUtils.isEmpty(password) || StringUtils.isEmpty(salt)) {
			return null;
		}

		String encryptedHash = null;

		try {
			encryptedHash = Hex.encodeHexString(encrypt(password.toCharArray(), Hex.decodeHex(salt.toCharArray())));
		} catch (DecoderException | NoSuchAlgorithmException | InvalidKeySpecException e) {
			logger.error(e.getMessage(), e);
		}

		return encryptedHash;
	}

	private static byte[] encrypt(final char[] password, final byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException,
			FileNotFoundException {
		final CryptoPropertiesBean cryptoPropertiesBean = CryptoPropertiesSingleton.getCryptoPropertiesBeanInstance();

		final PBEKeySpec pBEKeySpec = new PBEKeySpec(password, salt, cryptoPropertiesBean.getPbkdf2Iterations(),
				cryptoPropertiesBean.getPbkdf2HashByteSize() * 8);
		final SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(cryptoPropertiesBean.getPbkdf2Algorithm());

		return secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
	}
}
