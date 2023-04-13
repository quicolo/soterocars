package es.tuespiral.soterocars.utils.mail;

public interface Message {

	String getFromAddress();

	void setFromAddress(String fromAddress);

	String getToAddress();

	void setToAddress(String toAddress);

	String getHeader();

	void setHeader(String header);

	String getContent();

	void setContent(String content);

}