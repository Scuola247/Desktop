Ext.define("Desktop.model.Argomento",
{
  extend : "Ext.data.Model",
  fields : [ {
    name : "rv",
    type : "int"
  }, {
    name : "argomento",
    type : "int"
  }, {
    name : "descrizione",
    type : "string"
  } ],
  proxy : {
    type : "direct",
    directFn : "argomenti.ByMateriaClasse",
    reader : {
      root : "records"
    }
  }
});