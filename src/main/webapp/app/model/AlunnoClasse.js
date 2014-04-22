Ext.define("Desktop.model.AlunnoClasse",
{
  extend : "Ext.data.Model",
  fields : [ {
    name : "alunno",
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
    directFn : "alunnoService.listAlunniByRuoloClasse",
    reader : {
      root : "records"
    }
  }
});