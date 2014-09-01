package org.scuola247.desktop.beans;

public class SpazioLavoroResponse extends DirectResponsePayload {
	private Long code;

	public SpazioLavoroResponse(Long code) {
		super();
		this.code = code;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long user) {
		this.code = user;
	}
	
	
}
