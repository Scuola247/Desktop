Ext.define('Desktop.view.module.Institutes', {
	extend: 'Ext.window.Window',
	requires: ['Desktop.view.module.InstitutesPanel'],
	controller: 'Desktop.controller.Institutes',

	title: i18n.institutes,
	width: 840,
	height: 560,
	iconCls: 'institutes-icon',
	layout: 'fit',

	initComponent: function() {
		this.items = Ext.create('Desktop.view.module.InstitutesPanel', {
			itemId: 'grid'
		});

		this.callParent(arguments);

	}

});
