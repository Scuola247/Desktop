Ext.define("Desktop.model.FirmaClasseDocente",
{
  extend : "Ext.data.Model",
  fields : [ {
    name : "giorno",
    type : "date",
    dateFormat : "c"
  }, {
    name : "ora",
    type : "date",
    dateFormat : "c"
  } ],
  proxy : {
    type : "direct",
    directFn : "docenteService.listFirmaClasseDocente",
    reader : {
      root : "records"
    }
  }
});