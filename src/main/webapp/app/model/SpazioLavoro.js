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
    type : "int",
    useNull : true
  }, {
    name : "materia",
    type : "int",
    useNull : true
  }, {
    name : "docente",
    type : "int",
    useNull : true
  }, {
    name : "famigliare",
    type : "int",
    useNull : true
  }, {
    name : "alunno",
    type : "int",
    useNull : true
  }, {
    name : "spazio_lavoro_default",
    type : "boolean"
  } ],
  proxy : {
    type : "direct",
    api : {
      read : "spazioLavoroService.list",
      create : "spazioLavoroService.ins",
      update : "spazioLavoroService.upd",
      destroy : "spazioLavoroService.del"
    },
    reader : {
      root : "records"
    }
  }
});