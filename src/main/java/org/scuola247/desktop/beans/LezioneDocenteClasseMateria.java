package org.scuola247.desktop.beans;

import java.util.Date;

import org.joda.time.DateTime;

import ch.rasc.edsutil.jackson.ISO8601DateTimeSerializer;
import ch.rasc.extclassgenerator.Model;
import ch.rasc.extclassgenerator.ModelField;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Model(value = "Desktop.model.LezioneDocenteClasseMateria", readMethod = "docenteService.listLezioneDocenteClasseMateria", paging = true)
public class LezioneDocenteClasseMateria {
	
	private boolean supplenza;
	
	@ModelField(dateFormat = "c")
	private DateTime giorno;
	
	@ModelField(dateFormat = "c")
	private DateTime dalle;
	
	@ModelField(dateFormat = "c")
	private DateTime alle;
	
	private String descrizione;
	
	public LezioneDocenteClasseMateria(boolean supplenza, Date giorno, Date dalle, Date alle, String descrizione) {
		super();
		this.supplenza = supplenza;
		this.giorno = new DateTime(giorno);
		this.dalle = new DateTime(dalle);
		this.alle = new DateTime(alle);
		this.descrizione = descrizione;
	}

	public boolean isSupplenza() {
		return supplenza;
	}

	public void setSupplenza(boolean supplenza) {
		this.supplenza = supplenza;
	}

	@JsonSerialize(using = ISO8601DateTimeSerializer.class)	
	public DateTime getGiorno() {
		return giorno;
	}

	public void setGiorno(DateTime giorno) {
		this.giorno = giorno;
	}

	@JsonSerialize(using = ISO8601DateTimeSerializer.class)
	public DateTime getDalle() {
		return dalle;
	}

	public void setDalle(DateTime dalle) {
		this.dalle = dalle;
	}
	
	@JsonSerialize(using = ISO8601DateTimeSerializer.class)
	public DateTime getAlle() {
		return alle;
	}

	public void setAlle(DateTime alle) {
		this.alle = alle;
	}
	
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}