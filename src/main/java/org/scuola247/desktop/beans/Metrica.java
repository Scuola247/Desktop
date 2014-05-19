package org.scuola247.desktop.beans;

import ch.rasc.extclassgenerator.Model;
import ch.rasc.extclassgenerator.ModelField;

@Model(value = "Desktop.model.Metrica", readMethod = "metriche.ByIstituto", paging = true)
public class Metrica {
	
	public Metrica(Long rv, Long metrica, String descrizione) {
		super();
		this.rv = rv;
		this.metrica = metrica;
		this.descrizione = descrizione;
	}

	@ModelField
	private Long rv;
	
	@ModelField
	private Long metrica;

	@ModelField
	private String descrizione;

	public Long getRv() {
		return rv;
	}

	public void setRv(Long rv) {
		this.rv = rv;
	}

	public Long getMetrica() {
		return metrica;
	}

	public void setMetrica(Long voto) {
		this.metrica = voto;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}