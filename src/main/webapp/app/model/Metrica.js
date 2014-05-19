Ext.define("Desktop.model.Metrica",
{
  extend : "Ext.data.Model",
  fields : [ {
    name : "rv",
    type : "int"
  }, {
    name : "metrica",
    type : "int"
  }, {
    name : "descrizione",
    type : "string"
  } ],
  proxy : {
    type : "direct",
    directFn : "metriche.ByIstituto",
    reader : {
      root : "records"
    }
  }
});