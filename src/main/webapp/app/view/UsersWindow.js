Ext.define('Desktop.view.UsersWindow', {
	extend: 'Ext.window.Window',
	requires: [ 'Desktop.view.UsersGrid', 'Desktop.view.UserEdit' ],
	controller: 'Desktop.controller.User',
	stateId: 'Desktop.view.UsersWindow',
	title: i18n.user,
	width: 1070,
	height: 500,
	iconCls: 'users-icon',

	layout: {
		type: 'border'
	},

	defaults: {
		split: true
	},

	initComponent: function() {
		this.items = [ Ext.create('Desktop.view.UsersGrid', {
			itemId: 'grid',
			region: 'center',
			store: this.getController().store
		}), Ext.create('Desktop.view.UserEdit', {
			itemId: 'form',
			hidden: true,
			region: 'east'
		}) ];

		this.callParent(arguments);
	}

});
