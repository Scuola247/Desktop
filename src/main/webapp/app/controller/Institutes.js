Ext.define('Desktop.controller.Institutes', {
	extend: 'Deft.mvc.ViewController',
	requires: ['Desktop.store.Institutes'], 

	control: {
		view: {
			show: 'onShow'
		},
		instituteDescriptionFilter: true,
		institutesSearchForm: true,
		institutesSearchButton: {
			click: 'onClickInstitutesSearch'
		},
		institutesGrid: {
			beforeedit: 'onBeforeEditGrid'
		},
		searchInstituteToggleButton: {
			toggle: 'onToggleSearch'
		},
		editInstituteToggleButton: {
			toggle: 'onToggleEditInstitute'
		},
		addInstituteButton: {
			click: 'onClickAdd'
		}
	},

	onClickAdd: function(){
        // Create a model instance
        var rec = new Desktop.model.Institutes({
        	istituto : '',
        	descrizione : '', 
        	codice_meccanografico : '', 
        	mnemonico: '', 
        	esempio : true
        });
        
        this.getInstitutesGrid().getStore().insert(0, rec);
        this.getInstitutesGrid().cellEditing.startEditByPosition({
            row: 0, 
            column: 0
        });
    },
    
    onToggleSearch: function(item, pressed, eOpts){
    	if (pressed){
    		this.getInstitutesSearchForm().show();
    	}
    	else{
    		this.getInstitutesSearchForm().hide();
    	}
    },
	
	onShow: function() {
		// caricamento della griglia this.doGridRefresh();
	},

	doGridRefresh: function(desc) {
		this.getInstitutesGrid().getStore().load(
					{
						params:{description:desc}
					}
				);
	},
	
	onToggleEditInstitute: function (item, pressed, eOpts){
    	if (pressed){
    		this.getInstitutesGrid().cellEditing.enable();
    	}
    	else{
    		this.getInstitutesGrid().cellEditing.disable();
    	}
    },
	
    onClickInstitutesSearch: function() {
    	this.doGridRefresh(this.getInstituteDescriptionFilter().getValue());
    },
    
	onBeforeEditGrid: function() {
		if (!this.getEditInstituteToggleButton().pressed){
			return false;
		}
	}
});