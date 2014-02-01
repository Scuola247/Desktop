Ext.define('Desktop.controller.module.NotepadController', {
	extend: 'Deft.mvc.ViewController',
	inject: [ 'messageBus' ],

	config: {
		messageBus: null
	},

	init: function() {
		Ext.logInfo('init Desktop.controller.module.NotepadController');
		this.getMessageBus().fireEvent('refresh', {
			someData: 'from notepad'
		});
	}

});