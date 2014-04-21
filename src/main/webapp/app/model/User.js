Ext.define("Desktop.model.User",
{
  extend : "Ext.data.Model",
  uses : [ "Desktop.model.Role" ],
  fields : [ {
    name : "email",
    type : "string"
  }, {
    name : "name",
    type : "string"
  }, {
    name : "firstName",
    type : "string"
  }, {
    name : "locale",
    type : "string"
  }, {
    name : "enabled",
    type : "boolean"
  }, {
    name : "lastLoginDescription",
    type : "string",
    persist : false
  } ],
  associations : [ {
    type : "hasMany",
    model : "Desktop.model.Role",
    associationKey : "roles",
    foreignKey : "user_id",
    name : "roles"
  } ],
  proxy : {
    type : "direct",
    api : {
      read : "userService.read",
      destroy : "userService.destroy"
    },
    reader : {
      root : "records"
    }
  }
});