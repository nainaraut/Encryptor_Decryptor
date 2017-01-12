# Encryptor_Decryptor
Document Encryptor/ Decryptor System

In this Java program called DocSafe, Document objects  (with a document  id and the contents) can be stored in an object of type DocStore. 
When a document is stored in a DocStore, the document’s contents are encrypted, using an Encryptor object (with a specific key) associated 
with DocStore. A document can be retrieved from a DocStore using a document Id and optionally a key. When the document is retrieved using 
the correct key, document contents are decrypted and returned. 
When the document is retrieved without a key, document contents in the encrypted form are returned.
