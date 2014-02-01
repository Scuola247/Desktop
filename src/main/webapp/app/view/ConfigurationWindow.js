Ext.define('Desktop.view.ConfigurationWindow', {
	extend: 'Ext.window.Window',
	requires: ['Desktop.view.ConfigurationEdit'],
	controller: 'Desktop.controller.Configuration',
	stateId: 'Desktop.view.ConfigurationWindow',

	title: i18n.configuration,
	width: 500,
	height: 480,
	iconCls: 'configuration-icon',

	layout: {
		type: 'fit'
	},

	initComponent: function() {
		this.items = Ext.create('Desktop.view.ConfigurationEdit', {
			itemId: 'configurationEditPanel'
		});		
		this.callParent(arguments);
	}

});
