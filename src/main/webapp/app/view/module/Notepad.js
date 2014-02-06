Ext.define('Desktop.view.module.Notepad', {
	extend: 'Ext.window.Window',
	controller: 'Desktop.controller.module.NotepadController',

	title: i18n.notepad,
	width: 600,
	height: 400,
	iconCls: 'notepad-icon',
	bodyBorder: true,
	layout: 'fit',
	border: false,

	initComponent: function() {
		this.items = [ {

			xtype: 'htmleditor',
			id: 'notepad-editor',
			value: [ 
			        i18n.notepad_example_text, 
			        i18n.notepad_example_try 
			].join('')
		} ];

		this.callParent(arguments);

	}

});
