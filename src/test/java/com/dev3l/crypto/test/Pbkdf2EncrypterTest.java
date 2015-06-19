package com.dev3l.crypto.test;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import com.dev3l.crypto.Pbkdf2Encrypter;
import com.dev3l.crypto.RandomSaltGenerator;

public class Pbkdf2EncrypterTest {
	private static final int TEST_COUNT_SIZE = 10;
	private final String password = "super_secret";

	private final RandomSaltGenerator randomSaltGenerator = new RandomSaltGenerator();
	private final Pbkdf2Encrypter pbkdf2Encrypter = new Pbkdf2Encrypter();

	@Test
	public void encryptTestEqualHashes() throws FileNotFoundException {
		final String salt = randomSaltGenerator.createSalt();

		for (int i = 0; i < TEST_COUNT_SIZE; i++) {
			Assert.assertEquals(pbkdf2Encrypter.encrypt(password, salt), pbkdf2Encrypter.encrypt(password, salt));
		}
	}

	@Test
	public void encryptTestNonEqualHashes() throws FileNotFoundException {
		for (int i = 0; i < TEST_COUNT_SIZE; i++) {
			final String firstSalt = randomSaltGenerator.createSalt();
			final String secondSalt = randomSaltGenerator.createSalt();

			Assert.assertNotEquals(pbkdf2Encrypter.encrypt(password, firstSalt), pbkdf2Encrypter.encrypt(password, secondSalt));
		}
	}

	@Test
	public void encryptTestNullSalt() throws FileNotFoundException {
		Assert.assertNull(pbkdf2Encrypter.encrypt(password, null));
	}

	@Test
	public void encryptTestNullPassword() throws FileNotFoundException {
		Assert.assertNull(pbkdf2Encrypter.encrypt(null, "salt"));
	}

	@Test
	public void encryptTestNullPasswordNullSalt() throws FileNotFoundException {
		Assert.assertNull(pbkdf2Encrypter.encrypt(null, null));
	}
}
