Ext.define("Desktop.model.ValutazioneAlunno",
{
  extend : "Ext.data.Model",
  fields : [ {
    name : "alunno",
    type : "int"
  }, {
    name : "foto_miniatura",
    type : "string"
  }, {
    name : "cognome",
    type : "string"
  }, {
    name : "nome",
    type : "string"
  } ],
  proxy : {
    type : "direct",
    directFn : "valutazioniService.listValutazioniByClasse",
    reader : {
      root : "records"
    }
  }
});