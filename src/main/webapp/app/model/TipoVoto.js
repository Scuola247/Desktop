Ext.define("Desktop.model.TipoVoto",
{
  extend : "Ext.data.Model",
  fields : [ {
    name : "rv",
    type : "int"
  }, {
    name : "tipo_voto",
    type : "int"
  }, {
    name : "descrizione",
    type : "string"
  } ],
  proxy : {
    type : "direct",
    directFn : "tipiVoto.ByMateria",
    reader : {
      root : "records"
    }
  }
});