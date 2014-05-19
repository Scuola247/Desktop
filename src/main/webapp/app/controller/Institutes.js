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
//			beforeedit: 'onBeforeEditGrid',
			celldblclick: 'onInstitutesGridCellDBLClick'
		},
		institutesPanel: true,
		idIstitutoInsertField: true,
		createInstitutePanel: true,
		instituteForm: true,
		instituteImageForm: true,
		instituteLogo: {
			change: 'onChangeInstituteLogo'
		},
		instituteLogoPreview: true,
		institutesLogoName: true,
		searchInstituteToggleButton: {
			toggle: 'onToggleSearch'
		},
//		editInstituteToggleButton: {
//			toggle: 'onToggleEditInstitute'
//		},
		addInstituteButton: {
			click: 'onClickAdd'
		},
		printInstituteButton: {
			click: 'onClickPrintInstituteButton'
		},
		insertNewInstituteButton: {
			click: 'onClickInsertNewInstituteButton'
		},
		closeInsertNewInstituteButton: {
			click: 'onClickCloseInsertNewInstituteButton'
		}
	},

	onClickPrintInstituteButton: function(){
		var value = this.getInstituteDescriptionFilter().getValue();
		if (!Ext.isEmpty(value)){
			var url = app_context_path + "/print/institute/" + value;
			window.open(url, "prova");
		}
		else{
			Ext.Msg.show({
            	title:i18n.institutes_info,
            	buttons: Ext.Msg.OK,
            	msg: i18n.institutes_set_filter,
            	icon: Ext.MessageBox.INFO
            });
		}
	},
	
	onClickAdd: function(){
		this.setNewInstituteFormMode(false);
		this.getInstitutesPanel().hide();
		this.getCreateInstitutePanel().show();
		
		/*
		var institutesCearionWindow = Ext.create('Desktop.view.module.InstitutesCreationWindow', {
			itemId: 'institutesCreationWindow',
			opener: this
		});
		
		institutesCearionWindow.show();
		*/
		
		/*
		this.getInstitutesGrid().addingNewInstitute = true;
		this.getInstitutesGrid().rowEditing.cancelEdit();
        // Create a model instance
        var rec = new Desktop.model.Institutes({
        	istituto : '',
        	descrizione : '', 
        	codice_meccanografico : '', 
        	mnemonico: '', 
        	esempio : true
        });
        this.getEditInstituteToggleButton().toggle(true);
        var store = this.getInstitutesGrid().getStore();
        store.suspendAutoSync();
        store.insert(0, rec);
        this.getInstitutesGrid().rowEditing.startEdit(0, 1);
        */
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
		this.getInstitutesGrid().getStore().proxy.addListener('exception', function ( element, response, operation, eOpts ){
    		if (!response.result.success){
    			Desktop.ux.window.Notification.error(i18n.error, response.result.message);
    			var gridStore = this.getInstitutesGrid().getStore();
    			if (response.method == "upd"){
        			var removedRecords = gridStore.getRemovedRecords();
        			for(var i = 0; i < removedRecords.length; i++){
        				var record = removedRecords[i];
        				gridStore.insert(record.index, record);
        			}
    			}
    			else{
    				gridStore.rejectChanges();
    			}
			}
    	}, this);
	},

	doGridRefresh: function(desc) {
		this.getInstitutesGrid().getStore().load(
					{
						params:{description:desc}
					}
				);
	},
	
//	onToggleEditInstitute: function (item, pressed, eOpts){
//    	if (pressed){
////    		   this.getInstitutesGrid().down('[action=deleteAction]').show();
//////    		this.getInstitutesGrid().cellEditing.enable();
////    		this.getInstitutesGrid().rowEditing.enable();
//    		
//    		var lastSelected = this.getInstitutesGrid().getSelectionModel().getLastSelected();
//    		if (lastSelected){
//    			//this.getInstitutesGrid().rowEditing.startEdit(lastSelected, 0);
//    			//TODO:..... populateNewInstituteForms();
//    		}
//    	}
//    	else{
////    		this.getInstitutesGrid().down('[action=deleteAction]').hide();
//////    		this.getInstitutesGrid().cellEditing.disable();
////    		this.getInstitutesGrid().rowEditing.disable();
////    		this.getInstitutesGrid().rowEditing.cancelEdit();
//    	}
//    },
	
    onClickInstitutesSearch: function() {
    	this.doGridRefresh(this.getInstituteDescriptionFilter().getValue());
    },
    
//	onBeforeEditGrid: function() {
//		if (!this.getEditInstituteToggleButton().pressed){
//			return false;
//		}
//	},
	
	onInstitutesGridCellDBLClick: function ( institutesGrid, td, cellIndex, record, tr, rowIndex, e, eOpts ){
		this.setNewInstituteFormMode(true, record);
		this.getInstitutesPanel().hide();
		this.getCreateInstitutePanel().show();
	},
    
	onChangeInstituteLogo: function(imageField, value, eOpts){
		var file = imageField.getEl().down('input[type=file]').dom.files[0];
		var reader = new FileReader();
		var previewArea = this.getInstituteLogoPreview();
		var logoName = this.getInstitutesLogoName();
		
		var fromPos = value.lastIndexOf("\\");
		if (fromPos == -1){
			fromPos = value.lastIndexOf("/");
		}
		if (fromPos != -1){
			logoName.setValue(value.substr(fromPos + 1));	
		}
		reader.onload = function (e) {
			previewArea.setSrc(e.target.result);
			previewArea.setSize(195, 195);
			//previewArea.doComponentLayout();
		};
		reader.readAsDataURL(file);
	},
    
	onClickInsertNewInstituteButton: function(){
		var form = this.getInstituteForm();
		if (form.isValid()) {
			form.submit({
				//waitMsg: 'Processing...',
				success: function(form, action) {
					var ansRv = action.result.rv;
					var ansInstituteId = action.result.instituteId;
					var instituteImageForm = this.getInstituteImageForm();
					if (instituteImageForm.isValid()) {
						instituteImageForm.submit({
							params: {
								rv: ansRv,
								instituteId: ansInstituteId
						    },
							success: function(form, action) {
								var successTitleMsg = "";
								var successMsg = "";
								if (this.isModify){
									successTitleMsg = i18n.institutes_update_done;
									successMsg = Ext.String.format(i18n.institutes_update_doneinfo, ansInstituteId);
								}
								else{
									successTitleMsg = i18n.institutes_creation_done;
									successMsg = Ext.String.format(i18n.institutes_creation_doneinfo, ansInstituteId);
								}
								Ext.Msg.show({
		                        	title:successTitleMsg,
		                        	buttons: Ext.Msg.OK,
		                        	msg: successMsg,
		                        	icon: Ext.MessageBox.INFO
		                        });
								this.doGridRefresh();
								this.clearNewInstituteForms();
								this.getCreateInstitutePanel().hide();
								this.getInstitutesPanel().show();
							},
		                    failure: function(form, action) {
		                    	var failureTitleMsg = "";
								if (this.isModify){
									failureTitleMsg = i18n.institutes_update_failed;
								}
								else{
									failureTitleMsg = i18n.institutes_creation_failed;
								}
		                        Ext.Msg.show({
		                        	title:failureTitleMsg,
		                        	buttons: Ext.Msg.OK,
		                        	msg: action.result.errorMessage,
		                        	icon: Ext.MessageBox.ERROR
		                        });
		                    },
							scope:this
						});
					}
				},
                failure: function(form, action) {
                	var failureTitleMsg = "";
					if (this.isModify){
						failureTitleMsg = i18n.institutes_update_failed;
					}
					else{
						failureTitleMsg = i18n.institutes_creation_failed;
					}
                	Ext.Msg.show({
                    	title:failureTitleMsg,
                    	buttons: Ext.Msg.OK,
                    	msg: action.result.errorMessage,
                    	icon: Ext.MessageBox.ERROR
                    });
                },
				scope:this
			});
		}
	},
	
	onClickCloseInsertNewInstituteButton: function(){
		this.clearNewInstituteForms();
		this.getCreateInstitutePanel().hide();
		this.getInstitutesPanel().show();
	},
	
	clearNewInstituteForms: function(){
		this.getInstituteForm().getForm().reset();
		this.getInstituteImageForm().getForm().reset();
		this.getInstituteLogoPreview().setSrc('');
	},
    
	populateNewInstituteForms: function(record){
		var form = this.getInstituteForm();
		form.loadRecord(record);
		var previewArea = this.getInstituteLogoPreview();
		previewArea.setSrc(app_context_path + "/images/institute_logo/" + record.get('istituto'));
		previewArea.setSize(195, 195);
	},
	
	setNewInstituteFormMode: function(modify, record){
		this.isModify = modify;
		this.getIdIstitutoInsertField().setVisible(modify);
		if (modify){
			this.populateNewInstituteForms(record);
		}
		this.getInsertNewInstituteButton().setText((modify) ? i18n.institutes_creation_form_update_button : i18n.institutes_creation_form_insert_button);
	},
	
	isModify: false
});