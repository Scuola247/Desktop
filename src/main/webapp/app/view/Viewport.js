Ext.define('Desktop.view.Viewport', {
	extend: 'Ext.Viewport',
	requires: ['Desktop.view.Desktop'],
	layout: 'fit',
	
	initComponent: function() {
		this.items = [ Ext.create('Desktop.view.Desktop') ];
		this.callParent(arguments);
	}

});