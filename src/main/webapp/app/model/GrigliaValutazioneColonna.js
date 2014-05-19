Ext.define("Desktop.model.GrigliaValutazioneColonna",
{
  extend : "Ext.data.Model",
  fields : [ {
    name : "giorno",
    type : "date",
    dateFormat : "c"
  }, {
    name : "tipo_voto",
    type : "int"
  }, {
    name : "tipo_voto_descrizione",
    type : "string"
  }, {
    name : "argomento",
    type : "int"
  }, {
    name : "argomento_descrizione",
    type : "string"
  }, {
    name : "metrica",
    type : "int"
  }, {
    name : "metrica_descrizione",
    type : "string"
  } ],
  proxy : {
    type : "direct",
    directFn : "valutazioniService.griglia_valutazioni_colonne_by_classe_docente_materia",
    reader : {
      root : "records"
    }
  }
});