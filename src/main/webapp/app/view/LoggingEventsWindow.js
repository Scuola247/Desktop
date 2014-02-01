Ext.define('Desktop.view.LoggingEventsWindow', {
	extend: 'Ext.window.Window',
	requires: ['Desktop.view.LoggingEventsGrid'],
	controller: 'Desktop.controller.LoggingEvent',
	stateId: 'Desktop.view.LoggingEventsWindow',
	title: i18n.logevents,
	width: 800,
	height: 600,
	iconCls: 'loggingevents-icon',
	layout: 'fit',

	initComponent: function() {
		this.items = Ext.create('Desktop.view.LoggingEventsGrid', {
			itemId: 'grid'
		});

		this.callParent(arguments);
	}

});
