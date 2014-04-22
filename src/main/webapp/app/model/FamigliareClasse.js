Ext.define("Desktop.model.FamigliareClasse",
{
  extend : "Ext.data.Model",
  fields : [ {
    name : "famigliare",
    type : "int"
  }, {
    name : "nome_cognome",
    type : "string"
  }, {
    name : "cognome",
    type : "string"
  }, {
    name : "nome",
    type : "string"
  }, {
    name : "codice_fiscale",
    type : "string"
  }, {
    name : "foto_miniatura",
    type : "string"
  } ],
  proxy : {
    type : "direct",
    directFn : "famigliareService.listFamigliariByRuoloClasse",
    reader : {
      root : "records"
    }
  }
});