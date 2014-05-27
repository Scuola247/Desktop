Ext.define('Desktop.view.contextmenu.EditDelete', {
	extend: 'Ext.menu.Menu',
	controller: 'Desktop.controller.EditDelete',
	
	alias: 'widget.editdelete',
	
	items: [ {
		text: 'Modifica',
		itemId: 'itemModifica',
		minWindows: 1
	}, '-', {
		text: 'Elimina',
		itemId: 'itemElimina',
		minWindows: 1
	} ]
});