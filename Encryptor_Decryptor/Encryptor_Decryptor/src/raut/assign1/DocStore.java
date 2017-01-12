/**
* Student Id: W1186663
* Course: COEN275
* Assignment 1
* Date Of Submission : 2016-04-13
* 
* The DocStore program defines methods to save the document and to
* get the document in encrypted and decrypted forms.
* 
* @author  Naina Raut
* @version 1.0
* @since   2016-04-11 
*/
package raut.assign1;

import java.util.Arrays;

public class DocStore implements Cloneable {

	private Document[] store;
	private final int capacity = 10;
	private EncryptorDecryptor encryptor;
	private int index = 0;
	
	/**
	 * Constructor to initialize the encryptor object
	 * @param encryptor
	 */
	public DocStore(Encryptor encryptor){
		this.encryptor = (EncryptorDecryptor) encryptor;
		store = new Document[capacity];
	}
	
	/**
	 * Save the document in the encrypted form in the store array
	 * @param document
	 */
	public void saveDoc(Document document){
		if(index < store.length){
			document.setContent(encryptor.encrypt(document.getContent()));
			store[index] = document;
			index++;
		}
		else{
			store = Arrays.copyOf(store, store.length + capacity);
			document.setContent(encryptor.encrypt(document.getContent()));
			store[index] = document;
			index++;
		}
	}
	
	/**
	 * Get the document from the store array based on the entered document Id
	 * @param id
	 * @return document in encrypted form
	 */
	public Document getDoc(String id){
		//search the store with the id and return the specific document in encrypted format
		for(int i = 0;i<index;i++){
			if(store[i].getDocumentId() == id){
				return store[i];
			}	
		}
		System.out.println("Invalid Id "+id);
		return null;
	}
	
	/**
	 * Get the document from the store array based on the entered document Id 
	 * and document key(offset)
	 * @param id
	 * @param key
	 * @return document in decrypted form
	 */
	public Document getDoc(String id, int key){
		//search the store with the id and key and return the specific document in decrypted format
		for(int i = 0;i<index;i++){
			if(store[i].getDocumentId() == id){
				encryptor = new EncryptorDecryptor(key);
				String decryptedContent = encryptor.decrypt(store[i].getContent());
				Document dec = new Document(id,decryptedContent);
				return dec;
			}	
		}
		System.out.println("Invalid Id "+id);
		return null;
	}
}
