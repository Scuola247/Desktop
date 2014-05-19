Ext.define("Desktop.model.Voto",
{
  extend : "Ext.data.Model",
  fields : [ {
    name : "rv",
    type : "int"
  }, {
    name : "voto",
    type : "int"
  }, {
    name : "metrica",
    type : "int"
  }, {
    name : "descrizione",
    type : "string"
  }, {
    name : "mnemonico",
    type : "string"
  }, {
    name : "millesimi",
    type : "int"
  } ],
  proxy : {
    type : "direct",
    directFn : "voti.ByMetrica",
    reader : {
      root : "records"
    }
  }
});