package org.scuola247.desktop.beans;

import java.util.Date;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ch.rasc.edsutil.jackson.ISO8601DateTimeSerializer;
import ch.rasc.extclassgenerator.Model;
import ch.rasc.extclassgenerator.ModelField;

@Model(value = "Desktop.model.GrigliaValutazioneColonna", readMethod = "valutazioniService.griglia_valutazioni_colonne_by_classe_docente_materia", paging = true)
public class GrigliaValutazioneColonna {
	

	@ModelField(dateFormat = "c")
	private DateTime giorno;
	
	@ModelField
	private long tipo_voto;
	
	@ModelField
	private String tipo_voto_descrizione;

	@ModelField
	private long argomento;
	
	@ModelField
	private String argomento_descrizione;
	
	@ModelField
	private long metrica;
	
	@ModelField
	private String metrica_descrizione;

	public GrigliaValutazioneColonna(Date giorno, long tipo_voto,
			String tipo_voto_descrizione, long argomento,
			String argomento_descrizione, long metrica,
			String metrica_descrizione) {
		super();
		this.giorno = new DateTime(giorno);
		this.tipo_voto = tipo_voto;
		this.tipo_voto_descrizione = tipo_voto_descrizione;
		this.argomento = argomento;
		this.argomento_descrizione = argomento_descrizione;
		this.metrica = metrica;
		this.metrica_descrizione = metrica_descrizione;
	}

	@JsonSerialize(using = ISO8601DateTimeSerializer.class)
	public DateTime getGiorno() {
		return giorno;
	}

	public void setGiorno(DateTime giorno) {
		this.giorno = giorno;
	}

	public long getTipo_voto() {
		return tipo_voto;
	}

	public void setTipo_voto(long tipo_voto) {
		this.tipo_voto = tipo_voto;
	}

	public String getTipo_voto_descrizione() {
		return tipo_voto_descrizione;
	}

	public void setTipo_voto_descrizione(String tipo_voto_descrizione) {
		this.tipo_voto_descrizione = tipo_voto_descrizione;
	}

	public long getArgomento() {
		return argomento;
	}

	public void setArgomento(long argomento) {
		this.argomento = argomento;
	}

	public String getArgomento_descrizione() {
		return argomento_descrizione;
	}

	public void setArgomento_descrizione(String argomento_descrizione) {
		this.argomento_descrizione = argomento_descrizione;
	}

	public long getMetrica() {
		return metrica;
	}

	public void setMetrica(long metrica) {
		this.metrica = metrica;
	}

	public String getMetrica_descrizione() {
		return metrica_descrizione;
	}

	public void setMetrica_descrizione(String metrica_descrizione) {
		this.metrica_descrizione = metrica_descrizione;
	}
	
}