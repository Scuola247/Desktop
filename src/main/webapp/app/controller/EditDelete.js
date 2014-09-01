Ext.define('Desktop.controller.EditDelete', {
	extend: 'Deft.mvc.ViewController',
	
	control: {
		view: {
			show: 'onShow'
		},
		itemModifica: {
			click: 'onModificaClick'
		},
		itemElimina: {
			click: 'onEliminaClick'
		}
	
	},
	
	onShow: function(){},
	
	onModificaClick: function (item, e, eOpts ){
		
		item.up('menu').utils.onModificaClick.call(item.up('menu').utils.scope, item.up('menu').utils.data);

	},
	
	onEliminaClick: function(item, e, eOpts ){
		
		item.up('menu').utils.onEliminaClick.call(item.up('menu').utils.scope, item.up('menu').utils.data);
		
		
	}
	
});