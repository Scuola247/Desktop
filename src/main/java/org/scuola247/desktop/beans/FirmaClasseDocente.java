package org.scuola247.desktop.beans;

import java.util.Date;

import org.joda.time.DateTime;

import ch.rasc.edsutil.jackson.ISO8601DateTimeSerializer;
import ch.rasc.extclassgenerator.Model;
import ch.rasc.extclassgenerator.ModelField;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Model(value = "Desktop.model.FirmaClasseDocente", readMethod = "docenteService.listFirmaClasseDocente", paging = true)
public class FirmaClasseDocente {
	@ModelField(dateFormat = "c")
	private DateTime giorno;
	
	@ModelField(dateFormat = "c")
	private DateTime ora;
	
	public FirmaClasseDocente(Date giorno, Date ora) {
		super();
		this.giorno = new DateTime(giorno);
		this.ora = new DateTime(ora);
	}

	@JsonSerialize(using = ISO8601DateTimeSerializer.class)	
	public DateTime getGiorno() {
		return giorno;
	}

	public void setGiorno(DateTime giorno) {
		this.giorno = giorno;
	}

	@JsonSerialize(using = ISO8601DateTimeSerializer.class)
	public DateTime getOra() {
		return ora;
	}

	public void setOra(DateTime ora) {
		this.ora = ora;
	}		
}