Ext.define('Desktop.store.AccessLogs', {
	extend: 'Ext.data.Store',
	model: 'Desktop.model.AccessLog',
	autoLoad: false,
	remoteSort: true,
	remoteFilter: true,
	pageSize: 20,
	sorters: [ {
		property: 'logIn',
		direction: 'DESC'
	} ]
});