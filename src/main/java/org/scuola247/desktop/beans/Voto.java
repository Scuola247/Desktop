package org.scuola247.desktop.beans;

import ch.rasc.extclassgenerator.Model;
import ch.rasc.extclassgenerator.ModelField;

@Model(value = "Desktop.model.Voto", readMethod = "voti.ByMetrica", paging = true)
public class Voto {
	
	public Voto(Long rv, Long voto, Long metrica, String descrizione,
			String mnemonico, int millesimi) {
		super();
		this.rv = rv;
		this.voto = voto;
		this.metrica = metrica;
		this.descrizione = descrizione;
		this.mnemonico = mnemonico;
		this.millesimi = millesimi;
	}

	@ModelField
	private Long rv;
	
	@ModelField
	private Long voto;

	@ModelField
	private Long metrica;

	@ModelField
	private String descrizione;

	@ModelField
	private String mnemonico;

	@ModelField
	private int millesimi;

	public Long getRv() {
		return rv;
	}

	public void setRv(Long rv) {
		this.rv = rv;
	}

	public Long getVoto() {
		return voto;
	}

	public void setVoto(Long voto) {
		this.voto = voto;
	}

	public Long getMetrica() {
		return metrica;
	}

	public void setMetrica(Long metrica) {
		this.metrica = metrica;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getMnemonico() {
		return mnemonico;
	}

	public void setMnemonico(String mnemonico) {
		this.mnemonico = mnemonico;
	}

	public int getMillesimi() {
		return millesimi;
	}

	public void setMillesimi(int millesimi) {
		this.millesimi = millesimi;
	}

}