Ext.define('Desktop.controller.Institutes', {
	extend: 'Deft.mvc.ViewController',

	control: {
		view: {
			show: 'onShow'
		},
		grid: true,
		addPlantButton: {
			click: 'onAddClick'
		}
	},

	onAddClick: function(){
        // Create a model instance
        var rec = new Desktop.model.Institutes({
        	istituto : 'pippo',
        	descrizione : 'pippo desc', 
        	codice_meccanografico : 'pip', 
        	mnemonico: 'pipp', 
        	esempio : true
        });
        
        this.getGrid().getStore().insert(0, rec);
        this.getGrid().cellEditing.startEditByPosition({
            row: 0, 
            column: 0
        });
    },
	
	onShow: function() {
		this.doGridRefresh();
	},

	doGridRefresh: function() {
		this.getGrid().getStore().load();
	}

});