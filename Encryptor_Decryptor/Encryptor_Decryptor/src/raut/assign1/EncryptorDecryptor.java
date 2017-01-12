/**
* Student Id: W1186663
* Course: COEN275
* Assignment 1
* Date Of Submission : 2016-04-13
* 
* The DocStore program implements Encryptor interface which
* encrypt and decrypt a string of characters using a 
* shift cipher algorithm
* 
* @author  Naina Raut
* @version 1.0
* @since   2016-04-11 
*/
package raut.assign1;

public class EncryptorDecryptor implements Encryptor{
	private final String allowableChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-.!,";
	private final int offset;
	
	public EncryptorDecryptor(int offset){
		if(offset < 0 || offset > 66){
			throw new IllegalArgumentException("Invalid offset value");
		}
		this.offset = offset;
	}
	
	@Override
	public String encrypt(String plainText) {
		// TODO Auto-generated method stub
		return shiftEncrypt(plainText);
	}

	@Override
	public String decrypt(String plainText) {
		// TODO Auto-generated method stub
		return shiftDecrypt(plainText);
	}

	/**
	 * Shift Encrypt Algorithm to encrypt the given input plain text
	 * @param plainText
	 * @return the encrypted text
	 */
	private String shiftEncrypt(String plainText) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(plainText);
		int total_no_of_allowableCharacters = allowableChars.length();
		int encryptedCharacterIndex;
		
		for(int i=0;i<plainText.length();i++){
			if(allowableChars.indexOf(plainText.charAt(i)) > -1){
				int positionalChar = allowableChars.indexOf(plainText.charAt(i));
				encryptedCharacterIndex = (positionalChar + offset) % total_no_of_allowableCharacters;
				sb.setCharAt(i, allowableChars.charAt(encryptedCharacterIndex));
			}
		}
		return sb.toString();
	}
	
	/**
	 * Shift Decrypt Algorithm to decrypt the given input plain text
	 * @param plainText
	 * @return the decrypted text
	 */
	private String shiftDecrypt(String plainText) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(plainText);
		int total_no_of_allowableCharacters = allowableChars.length();
		int decryptedCharacterIndex = 0;
		
		for(int i=0;i<plainText.length();i++){
			if(allowableChars.indexOf(plainText.charAt(i)) > -1){
				int positionalChar = allowableChars.indexOf(plainText.charAt(i));
				if(positionalChar < offset){
					decryptedCharacterIndex = total_no_of_allowableCharacters + (positionalChar - offset);
				}
				else{
					decryptedCharacterIndex = (positionalChar - offset) % total_no_of_allowableCharacters;
				}
				sb.setCharAt(i, allowableChars.charAt(decryptedCharacterIndex));
			}
		}
		return sb.toString();
	}
}
