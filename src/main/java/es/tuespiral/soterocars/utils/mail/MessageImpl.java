package es.tuespiral.soterocars.utils.mail;

import lombok.AllArgsConstructor;
import lombok.NonNull;


@AllArgsConstructor
public class MessageImpl implements Message {
	@NonNull
	private String fromAddress, toAddress, header, content;

	@Override
	public String getFromAddress() {
		return fromAddress;
	}

	@Override
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	@Override
	public String getToAddress() {
		return toAddress;
	}

	@Override
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	@Override
	public String getHeader() {
		return header;
	}

	@Override
	public void setHeader(String header) {
		this.header = header;
	}

	@Override
	public String getContent() {
		return content;
	}

	@Override
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
