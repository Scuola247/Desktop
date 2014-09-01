Ext.define("Desktop.model.Topic",
{
  extend : "Ext.data.Model",
  fields : [ {
    name : "rv",
    type : "int"
  }, {
    name : "argomento",
    type : "int"
  }, {
    name : "materia",
    type : "int"
  }, {
    name : "descrizione",
    type : "string"
  }, {
    name : "anno_corso",
    type : "int"
  }, {
    name : "indirizzo_scolastico",
    type : "int"
  } ],
  proxy : {
    type : "direct",
    api : {
      read : "topicsService.sel",
      destroy : "topicsService.del"
    },
    reader : {
      root : "records"
    }
  }
});