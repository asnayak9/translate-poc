package com.shree.poc.vos;

public class TaxResponse {

	private String message;
	private Object data;
	private Object errorMessages;
	
	public TaxResponse() {}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(Object errorMessages) {
		this.errorMessages = errorMessages;
	}

	public static TaxResponse of(String message) {
		TaxResponse tr = new TaxResponse();
		tr.setMessage(message);
		return tr;
	}
	
	public static TaxResponse of(String message, Object data) {
		TaxResponse tr = new TaxResponse();
		tr.setMessage(message);
		tr.setData(data);
		return tr;
	}
	
	public static TaxResponse error(String errMessage) {
		TaxResponse tr = new TaxResponse();
		tr.setErrorMessages(errMessage);
		return tr;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TaxResponse [message=");
		builder.append(message);
		builder.append(", data=");
		builder.append(data);
		builder.append(", errorMessages=");
		builder.append(errorMessages);
		builder.append("]");
		return builder.toString();
	}
	
	
}
