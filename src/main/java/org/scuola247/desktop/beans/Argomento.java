package org.scuola247.desktop.beans;

import ch.rasc.extclassgenerator.Model;
import ch.rasc.extclassgenerator.ModelField;

@Model(value = "Desktop.model.Argomento", 
       readMethod = "argomenti.ByMateriaClasse", 
       destroyMethod = "argomenti.del", 
       paging = true)

public class Argomento {
	
	public Argomento(Long rv, Long argomento, String descrizione) {
		super();
		this.rv = rv;
		this.argomento = argomento;
		this.descrizione = descrizione;
	}

	@ModelField
	private Long rv;
	
	@ModelField
	private Long argomento;

	@ModelField
	private String descrizione;

	public Long getRv() {
		return rv;
	}

	public void setRv(Long rv) {
		this.rv = rv;
	}

	public Long getArgomento() {
		return argomento;
	}

	public void setArgomento(Long voto) {
		this.argomento = voto;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}