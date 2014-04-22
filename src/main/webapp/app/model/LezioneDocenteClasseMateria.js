Ext.define("Desktop.model.LezioneDocenteClasseMateria",
{
  extend : "Ext.data.Model",
  fields : [ {
    name : "supplenza",
    type : "boolean"
  }, {
    name : "giorno",
    type : "date",
    dateFormat : "c"
  }, {
    name : "dalle",
    type : "date",
    dateFormat : "c"
  }, {
    name : "alle",
    type : "date",
    dateFormat : "c"
  }, {
    name : "descrizione",
    type : "string"
  } ],
  proxy : {
    type : "direct",
    directFn : "docenteService.listLezioneDocenteClasseMateria",
    reader : {
      root : "records"
    }
  }
});