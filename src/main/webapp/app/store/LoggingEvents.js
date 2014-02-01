Ext.define('Desktop.store.LoggingEvents', {
	extend: 'Ext.data.Store',
	model: 'Desktop.model.LoggingEvent',
	autoLoad: false,
	remoteSort: true,
	remoteFilter: true,
	pageSize: 20,
	sorters: [ {
		property: 'dateTime',
		direction: 'DESC'
	} ]
});