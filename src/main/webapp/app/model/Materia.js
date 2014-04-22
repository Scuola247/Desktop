Ext.define("Desktop.model.Materia",
{
  extend : "Ext.data.Model",
  fields : [ {
    name : "rv",
    type : "int"
  }, {
    name : "materia",
    type : "int"
  }, {
    name : "istituto",
    type : "int"
  }, {
    name : "descrizione",
    type : "string"
  } ],
  proxy : {
    type : "direct",
    directFn : "materiaService.list",
    reader : {
      root : "records"
    }
  }
});