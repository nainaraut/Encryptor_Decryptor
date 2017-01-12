/**
* Student Id: W1186663
* Course: COEN275
* Assignment 1
* Date Of Submission : 2016-04-13
* 
* The Document program defines the documentId and content 
* of the document and their accessor methods
* 
* @author  Naina Raut
* @version 1.0
* @since   2016-04-11 
*/
package raut.assign1;

public class Document {

	private String documentId;
	private String content;
	
	/**
	 * Constructor to initialize the document Id and document content
	 * @param documentId
	 * @param content
	 */
	public Document(String documentId,String content){
		this.documentId = documentId;
		this.content = content;
	}
	
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getDocumentId() {
		return documentId;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
}
