package es.tuespiral.soterocars.utils.mail;

public interface EmailService {
	void send(Message msg);
	boolean validateAddress(String address);
	Message buildMessageOf(String emailFrom, String emailTo, String header, String content);
	
}
