Ext.define("Desktop.model.Institutes",
{
  extend : "Ext.data.Model",
  fields : [ {
    name : "rv",
    type : "number"
  }, {
    name : "istituto",
    type : "number"
  }, {
    name : "descrizione",
    type : "string"
  }, {
    name : "codice_meccanografico",
    type : "string"
  }, {
    name : "mnemonico",
    type : "string"
  }, {
    name : "esempio",
    type : "boolean"
  } ],
  proxy : {
    type : "direct",
    api : {
    	create  : "institutesService.ins",
        read    : "institutesService.sel",
        update  : "institutesService.upd",
        destroy : "institutesService.del"
    },
    /*directFn : "institutesService.read",*/
    reader : {
    	root : "records"
    }
  }
});