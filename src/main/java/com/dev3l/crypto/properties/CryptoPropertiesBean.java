package com.dev3l.crypto.properties;

import java.util.Map;

public class CryptoPropertiesBean {
	private String pbkdf2Algorithm;
	private Integer pbkdf2Iterations;
	private Integer pbkdf2SaltByteSize;
	private Integer pbkdf2HashByteSize;

	private Map<String, String> propertiesMap;

	public CryptoPropertiesBean() {
	}

	/**
	 * @return the pbkdf2Algorithm
	 */
	public final String getPbkdf2Algorithm() {
		return pbkdf2Algorithm;
	}

	/**
	 * @param pbkdf2Algorithm the pbkdf2Algorithm to set
	 */
	public final void setPbkdf2Algorithm(final String pbkdf2Algorithm) {
		this.pbkdf2Algorithm = pbkdf2Algorithm;
	}

	/**
	 * @return the pbkdf2Iterations
	 */
	public final Integer getPbkdf2Iterations() {
		return pbkdf2Iterations;
	}

	/**
	 * @param pbkdf2Iterations the pbkdf2Iterations to set
	 */
	public final void setPbkdf2Iterations(final Integer pbkdf2Iterations) {
		this.pbkdf2Iterations = pbkdf2Iterations;
	}

	/**
	 * @return the pbkdf2SaltByteSize
	 */
	public final Integer getPbkdf2SaltByteSize() {
		return pbkdf2SaltByteSize;
	}

	/**
	 * @param pbkdf2SaltByteSize the pbkdf2SaltByteSize to set
	 */
	public final void setPbkdf2SaltByteSize(final Integer pbkdf2SaltByteSize) {
		this.pbkdf2SaltByteSize = pbkdf2SaltByteSize;
	}

	/**
	 * @return the pbkdf2HashByteSize
	 */
	public final Integer getPbkdf2HashByteSize() {
		return pbkdf2HashByteSize;
	}

	/**
	 * @param pbkdf2HashByteSize the pbkdf2HashByteSize to set
	 */
	public final void setPbkdf2HashByteSize(final Integer pbkdf2HashByteSize) {
		this.pbkdf2HashByteSize = pbkdf2HashByteSize;
	}

	/**
	 * @return the propertiesMap
	 */
	public final Map<String, String> getPropertiesMap() {
		return propertiesMap;
	}

	/**
	 * @param propertiesMap the propertiesMap to set
	 */
	public final void setPropertiesMap(final Map<String, String> propertiesMap) {
		this.propertiesMap = propertiesMap;
	}
}
