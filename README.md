# CryptoDev3l
Java PBKDF2 Encryption Utility - PBKDF2WithHmacSHA1

Java hashing implementation of pbkdf2 for secure storage of passwords.


## Some high level checkpoints of the project:
* Native Java API
** Encryption algorithm: PBKDF2WithHmacSHA1
* Iterations configurable through properties file
* Random salt generation using java.security.SecureRandom
* Simple API:
** RandomSaltGenerator.createSalt() -> returns  [Hex encoded] String
** Pbkdf2Encrypter.encrypt(password, salt) -> returns  [Hex encoded] String
* JUnit Test Coverage