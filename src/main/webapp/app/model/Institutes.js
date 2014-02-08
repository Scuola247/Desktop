Ext.define("Desktop.model.Institutes",
{
  extend : "Ext.data.Model",
  fields : [ 
	{
		name : "istituto",
		type : "int"
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
    directFn : "institutesService.read",
    reader : {
      root : "records"
    }
  }
});