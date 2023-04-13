package es.tuespiral.soterocars.utils.mail;

import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {
	@Override
	public void send(Message msg) {
		String from = msg.getFromAddress();
		String to = msg.getToAddress();
		System.out.println("Se envía un mensaje de "+from+" a "+to);
	}
	
	@Override
	public boolean validateAddress(String address) {
		return address.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
	}

	@Override
	public Message buildMessageOf(String emailFrom, String emailTo, String header, String content) {
		return new MessageImpl(emailFrom, emailTo, header, content);
	}
}
