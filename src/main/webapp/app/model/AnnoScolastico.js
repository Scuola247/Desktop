Ext.define("Desktop.model.AnnoScolastico",
{
  extend : "Ext.data.Model",
  fields : [ {
    name : "rv",
    type : "int"
  }, {
    name : "anno_scolastico",
    type : "int"
  }, {
    name : "istituto",
    type : "int"
  }, {
    name : "descrizione",
    type : "string"
  }, {
    name : "inizio",
    type : "date",
    dateFormat : "c"
  }, {
    name : "fine",
    type : "date",
    dateFormat : "c"
  }, {
    name : "inizio_lezioni",
    type : "date",
    dateFormat : "c"
  }, {
    name : "fine_lezioni",
    type : "date",
    dateFormat : "c"
  } ],
  proxy : {
    type : "direct",
    directFn : "annoScolasticoService.sel",
    reader : {
      root : "records"
    }
  }
});