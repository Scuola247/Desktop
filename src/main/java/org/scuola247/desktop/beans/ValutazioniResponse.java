package org.scuola247.desktop.beans;

public class ValutazioniResponse extends DirectResponsePayload {
	private Long rv;
	
	private Long valutazione;

	public ValutazioniResponse(Long rv, Long valutazione) {
		super();
		this.rv = rv;
		this.valutazione = valutazione;
	}

	public Long getRv() {
		return rv;
	}

	public void setRv(Long rv) {
		this.rv = rv;
	}

	public Long getValutazione() {
		return valutazione;
	}

	public void setValutazione(Long valutazione) {
		this.valutazione = valutazione;
	}
	
	

}
