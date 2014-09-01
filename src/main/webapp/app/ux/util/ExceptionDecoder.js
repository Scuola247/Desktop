Ext.define('Desktop.ux.util.ExceptionDecoder', {
	statics: {
		decode: function(ex) {
			var decodedMessage = "";
			decodedMessage += "<b>Errore:</b> " + ex.errorCode + "<br/>";
			decodedMessage += "<b>Messaggio:</b> " + ex.errorMessage + "<br/>";
			decodedMessage += "<b>Dettaglio:</b> " + ex.errorDetail + "<br/>";
			decodedMessage += "<b>Suggerimento:</b> " + ex.errorHint;
			return decodedMessage;
		}
	},

	initComponent: function() {
		var me = this;

		me.callParent(arguments);
	}
});