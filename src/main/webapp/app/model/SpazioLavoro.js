Ext.define("Desktop.model.SpazioLavoro",
{
  extend : "Ext.data.Model",
  fields : [ {
    name : "rv",
    type : "int"
  }, {
    name : "spazio_lavoro",
    type : "int"
  }, {
    name : "descrizione",
    type : "string"
  }, {
    name : "istituto",
    type : "int"
  }, {
    name : "anno_scolastico",
    type : "int"
  }, {
    name : "classe",
    type : "int"
  }, {
    name : "materia",
    type : "int"
  }, {
    name : "docente",
    type : "int"
  }, {
    name : "famigliare",
    type : "int"
  }, {
    name : "alunno",
    type : "int"
  }, {
    name : "spazio_lavoro_default",
    type : "boolean"
  } ],
  proxy : {
    type : "direct",
    api : {
      read : "spazioLavoroService.list",
      create : "spazioLavoroService.ins",
      destroy : "spazioLavoroService.del"
    },
    reader : {
      root : "records"
    }
  }
});