Ext.define('Desktop.store.Users', {
	extend: 'Ext.data.Store',
	model: 'Desktop.model.User',
	autoLoad: false,
	remoteSort: true,
	remoteFilter: true,
	pageSize: 20,
	autoSync: false,
	sorters: [ {
		property: 'name',
		direction: 'ASC'
	} ]
});