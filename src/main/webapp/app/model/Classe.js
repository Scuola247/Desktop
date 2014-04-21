Ext.define("Desktop.model.Classe",
{
  extend : "Ext.data.Model",
  fields : [ {
    name : "rv",
    type : "int"
  }, {
    name : "classe",
    type : "int"
  }, {
    name : "anno_scolastico",
    type : "int"
  }, {
    name : "indirizzo_scolastico",
    type : "int"
  }, {
    name : "sezione",
    type : "string"
  }, {
    name : "anno_corso",
    type : "int"
  }, {
    name : "descrizione",
    type : "string"
  }, {
    name : "plesso",
    type : "int"
  } ],
  proxy : {
    type : "direct",
    directFn : "classeService.list",
    reader : {
      root : "records"
    }
  }
});