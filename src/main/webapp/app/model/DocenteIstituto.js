Ext.define("Desktop.model.DocenteIstituto",
{
  extend : "Ext.data.Model",
  fields : [ {
    name : "docente",
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
    directFn : "docenteService.listDocenteIstituto",
    reader : {
      root : "records"
    }
  }
});