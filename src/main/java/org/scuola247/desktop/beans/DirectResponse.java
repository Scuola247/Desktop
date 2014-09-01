package org.scuola247.desktop.beans;

import java.io.Serializable;

public class DirectResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean ok;

	private DirectResponsePayload payload;
	
	private String errorCode;
	
	private String errorMessage;
	
	private String errorDetail;
	
	private String errorHint;

	public DirectResponse(){
		super();
	}
	
	public DirectResponse(boolean ok, String code, DirectResponsePayload payload, String errorMessage, String errorDetail, String errorHint) {
		this();
		this.ok = ok;
		
		this.payload = payload;
		
		this.errorCode = code;
		this.errorMessage = errorMessage;
		this.errorDetail = errorDetail;
		this.errorHint = errorHint;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public DirectResponsePayload getPayload() {
		return payload;
	}

	public void setPayload(DirectResponsePayload payload) {
		this.payload = payload;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}

	public String getErrorHint() {
		return errorHint;
	}

	public void setErrorHint(String errorHint) {
		this.errorHint = errorHint;
	}

	
	
}
