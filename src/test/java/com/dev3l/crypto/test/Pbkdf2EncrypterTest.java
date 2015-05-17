package com.dev3l.crypto.test;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import com.dev3l.crypto.Pbkdf2Encrypter;
import com.dev3l.crypto.RandomSaltGenerator;

public class Pbkdf2EncrypterTest {
	private static final int TEST_COUNT_SIZE = 10;
	private final String password = "super_secret";

	@Test
	public void encryptTestEqualHashes() throws FileNotFoundException {
		final String salt = RandomSaltGenerator.createSalt();

		for (int i = 0; i < TEST_COUNT_SIZE; i++) {
			Assert.assertEquals(Pbkdf2Encrypter.encrypt(password, salt), Pbkdf2Encrypter.encrypt(password, salt));
		}
	}

	@Test
	public void encryptTestNonEqualHashes() throws FileNotFoundException {
		for (int i = 0; i < TEST_COUNT_SIZE; i++) {
			final String firstSalt = RandomSaltGenerator.createSalt();
			final String secondSalt = RandomSaltGenerator.createSalt();

			Assert.assertNotEquals(Pbkdf2Encrypter.encrypt(password, firstSalt), Pbkdf2Encrypter.encrypt(password, secondSalt));
		}
	}

	@Test
	public void encryptTestNullSalt() throws FileNotFoundException {
		Assert.assertNull(Pbkdf2Encrypter.encrypt(password, null));
	}

	@Test
	public void encryptTestNullPassword() throws FileNotFoundException {
		Assert.assertNull(Pbkdf2Encrypter.encrypt(null, "salt"));
	}

	@Test
	public void encryptTestNullPasswordNullSalt() throws FileNotFoundException {
		Assert.assertNull(Pbkdf2Encrypter.encrypt(null, null));
	}
}
