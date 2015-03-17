package com.dev3l.crypto;

import org.junit.Assert;
import org.junit.Test;

public class RandomSaltGeneratorTest {
	private static final int TEST_COUNT_SIZE = 10000;

	@Test
	public void saltCreationTest() {
		final String salt = RandomSaltGenerator.createSalt();

		for (int i = 0; i < TEST_COUNT_SIZE; i++) {
			Assert.assertNotEquals(salt, RandomSaltGenerator.createSalt());
		}

		for (int i = 0; i < TEST_COUNT_SIZE; i++) {
			Assert.assertNotEquals(RandomSaltGenerator.createSalt(), RandomSaltGenerator.createSalt());
		}
	}
}
