package org.scuola247.desktop.beans;

import java.util.Date;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ch.rasc.edsutil.jackson.ISO8601DateTimeSerializer;
import ch.rasc.extclassgenerator.Model;
import ch.rasc.extclassgenerator.ModelField;

@Model(value = "Desktop.model.AnnoScolastico", readMethod="annoScolasticoService.sel", paging=true)
public class AnnoScolastico {
	
	@ModelField
	private Long rv;
	
	@ModelField
	private Long anno_scolastico;
	
	@ModelField
	private Long istituto;
	
	@ModelField
	private String descrizione;

	@ModelField(dateFormat = "c")
	private DateTime inizio;

	@ModelField(dateFormat = "c")
	private DateTime fine;

	@ModelField(dateFormat = "c")
	private DateTime inizio_lezioni;
	
	@ModelField(dateFormat = "c")
	private DateTime fine_lezioni;
	
	public AnnoScolastico() {
		
	}
	
	public AnnoScolastico(Long rv, Long anno_scolastico, Long istituto,	String descrizione, Date inizio, Date fine, Date inizio_lezioni, Date fine_lezioni) {
		this(rv, anno_scolastico, istituto,
				descrizione, new DateTime(inizio.getTime()), new DateTime(fine.getTime()),
				new DateTime(inizio_lezioni.getTime()), new DateTime(fine_lezioni.getTime()));
	}
	
	public AnnoScolastico(Long rv, Long anno_scolastico, Long istituto,
			String descrizione, DateTime inizio, DateTime fine,
			DateTime inizio_lezioni, DateTime fine_lezioni) {
		super();
		this.rv = rv;
		this.anno_scolastico = anno_scolastico;
		this.istituto = istituto;
		this.descrizione = descrizione;
		this.inizio = inizio;
		this.fine = fine;
		this.inizio_lezioni = inizio_lezioni;
		this.fine_lezioni = fine_lezioni;
	}



	public Long getRv() {
		return rv;
	}

	public void setRv(Long rv) {
		this.rv = rv;
	}

	public Long getAnno_scolastico() {
		return anno_scolastico;
	}

	public void setAnno_scolastico(Long anno_scolastico) {
		this.anno_scolastico = anno_scolastico;
	}

	public Long getIstituto() {
		return istituto;
	}

	public void setIstituto(Long istituto) {
		this.istituto = istituto;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@JsonSerialize(using = ISO8601DateTimeSerializer.class)
	public DateTime getFine() {
		return fine;
	}

	public void setFine(DateTime fine) {
		this.fine = fine;
	}

	@JsonSerialize(using = ISO8601DateTimeSerializer.class)
	public DateTime getInizio() {
		return inizio;
	}

	public void setInizio(DateTime inizio) {
		this.inizio = inizio;
	}
	
	@JsonSerialize(using = ISO8601DateTimeSerializer.class)
	public DateTime getFine_lezioni() {
		return fine_lezioni;
	}

	public void setFine_lezioni(DateTime fine_lezioni) {
		this.fine_lezioni = fine_lezioni;
	}
	
	@JsonSerialize(using = ISO8601DateTimeSerializer.class)
	public DateTime getInizio_lezioni() {
		return inizio_lezioni;
	}

	public void setInizio_lezioni(DateTime inizio_lezioni) {
		this.inizio_lezioni = inizio_lezioni;
	}
	
}
