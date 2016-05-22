[![Build Status](https://travis-ci.org/DEV3L/java-crypto-pbkdf2.png)](https://travis-ci.org/DEV3L/java-crypto-pbkdf2)

# java-crypto-pbkdf2
Java PBKDF2 Encryption Utility - PBKDF2WithHmacSHA1

*Java hashing implementation of pbkdf2 for secure storage of passwords.*


### Project Highlights:
* Native Java API
  * Encryption algorithm: PBKDF2WithHmacSHA1
* Iterations configurable through properties file
  * Default salt size:  64
  * Default key length: 256
* Random salt generation using java.security.SecureRandom
* JUnit Test Coverage (Example Usage)
* Simple API:
  * RandomSaltGenerator.createSalt() -> returns  [Hex encoded] String
  * Pbkdf2Encrypter.encrypt(password, salt) -> returns  [Hex encoded] String

## Eclipse Project Setup (Requires Maven)
 * git clone the project
 * From the project directory
  * mvn eclipse:eclipse
 * From within Eclipse workspace, import as existing project
