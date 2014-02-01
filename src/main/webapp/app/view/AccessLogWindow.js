Ext.define('Desktop.view.AccessLogWindow', {
	extend: 'Ext.window.Window',
	requires: ['Desktop.view.AccessLogGrid'],
	controller: 'Desktop.controller.AccessLog',
	stateId: 'Desktop.view.AccessLogWindow',

	title: i18n.accesslog,
	width: 840,
	height: 560,
	iconCls: 'accesslog-icon',
	layout: 'fit',

	initComponent: function() {
		this.items = Ext.create('Desktop.view.AccessLogGrid', {
			itemId: 'grid'
		});

		this.callParent(arguments);
	}

});
