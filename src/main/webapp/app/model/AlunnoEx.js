Ext.define("Desktop.model.AlunnoEx",
{
  extend : "Ext.data.Model",
  fields : [ {
    name : "classe",
    type : "int"
  }, {
    name : "alunno",
    type : "int"
  }, {
    name : "foto_miniatura",
    type : "string"
  }, {
    name : "codice_fiscale",
    type : "string"
  }, {
    name : "nome",
    type : "string"
  }, {
    name : "cognome",
    type : "string"
  }, {
    name : "sesso",
    type : "string"
  }, {
    name : "nato",
    type : "date",
    dateFormat : "c"
  }, {
    name : "comune_nascita_descrizione",
    type : "string"
  }, {
    name : "assenze",
    type : "int"
  }, {
    name : "assenze_non_giustificate",
    type : "int"
  }, {
    name : "ritardi",
    type : "int"
  }, {
    name : "ritardi_non_giustificati",
    type : "int"
  }, {
    name : "uscite",
    type : "int"
  }, {
    name : "uscite_non_giustificate",
    type : "int"
  }, {
    name : "fuori_classi",
    type : "int"
  }, {
    name : "note",
    type : "int"
  } ],
  proxy : {
    type : "direct",
    directFn : "alunnoService.listClasseAlunniEx",
    reader : {
      root : "records"
    }
  }
});