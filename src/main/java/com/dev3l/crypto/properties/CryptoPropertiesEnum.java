package com.dev3l.crypto.properties;

public enum CryptoPropertiesEnum {
	//@formatter:off
	PBKDF2_ALGORITHM("crypto.dev3l.pbkdf2.algorithm"),
	PBKDF2_ITERATIONS("crypto.dev3l.pbkdf2.iterations"),
	PBKDF2_SALT_BYTE_SIZE("crypto.dev3l.pbkdf2.salt.byte_size"),
	PBKDF2_HASH_BYTE_SIZE("crypto.dev3l.pbkdf2.hash.byte_size");
	//@formatter:on

	private final java.lang.String literal;

	private CryptoPropertiesEnum(final String literal) {
		this.literal = literal;
	}

	public final String getLiteral() {
		return literal;
	}
}
