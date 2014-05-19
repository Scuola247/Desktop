package org.scuola247.desktop.beans;

import ch.rasc.extclassgenerator.Model;
import ch.rasc.extclassgenerator.ModelField;

@Model(value = "Desktop.model.TipoVoto", readMethod = "tipiVoto.ByMateria", paging = true)
public class TipoVoto {
	
	public TipoVoto(Long rv, Long tipo_voto, String descrizione) {
		super();
		this.rv = rv;
		this.tipo_voto = tipo_voto;
		this.descrizione = descrizione;
	}

	@ModelField
	private Long rv;
	
	@ModelField
	private Long tipo_voto;

	@ModelField
	private String descrizione;

	public Long getRv() {
		return rv;
	}

	public void setRv(Long rv) {
		this.rv = rv;
	}

	public Long getTipo_voto() {
		return tipo_voto;
	}

	public void setTipo_voto(Long tipo_voto) {
		this.tipo_voto = tipo_voto;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}