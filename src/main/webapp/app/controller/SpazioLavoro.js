Ext.define('Desktop.controller.SpazioLavoro', {
	extend: 'Deft.mvc.ViewController',
	inject: ['spaziLavoroStore', 'sharedStorage'],
	observe: {
		sharedStorage: {
			spazioLavoroChanged: 'onChangeSpazioLavoroCorrente'
		}
	},
	
	config: {
		spaziLavoroStore: null,
		storeIstituti: null,
		storeAnniScolastici: null,
		storeClassi: null,
		storeMaterie: null,
		storeDocentiIstituto: null,
		storeFamigliari: null,
		storeAlunniClasse: null,
		toSelectAnnoScolastico: null,
		toSelectClasse: null,
		toSelectMateria: null,
		toSelectDocente: null,
		toSelectFamigliare: null,
		toSelectAlunniClasse: null,
		toSetNomePerPreferito: null,
		sharedStorage: null,
		loaded: false,
		modify: false,
		modifyRecord: null
	},
	control: {	
		view: {
			show: 'onShow',
			hide: 'onHide'
		},
		workspaceGridPanel:{
			celldblclick: 'onWorkspaceGridPanelCellDBLClick'
		},
		workspaceActionColumn:{
			click: 'onActionColumnClick'
		},
		workspacePanel:true,
		addWorkspeceButton:{
			click: 'onClickAddWorkspace'
		},
		workspaceDefinitionForm:true,
		istituto:{
			change: 'onIstitutoChange'
		},
		anno_scolastico:{
			change: 'onAnnoScolasticoChange'
		},
		classe:{
			change: 'onClasseChange',
			specialkey: 'onClasseSpecialKey'
		},
		materia:{
			change: 'onMateriaChange',
			specialkey: 'onMateriaSpecialKey'
		},
		docente:{
			change: 'onDocenteChange',
			specialkey: 'onDocenteSpecialKey'
		},
		famigliare:{
			change: 'onFamigliareChange',
			specialkey: 'onFamigliareSpecialKey'
		},
		alunno:{
			change: 'onAlunnoChange',
			specialkey: 'onAlunnoSpecialKey'
		},
		nomePerPreferito:{
			focus: 'onNomePerPreferitoFocus',
			blur: 'onNomePerPreferitoBlur'
		},
		addWorkspaceToBookmarksButton: {
			click: 'onAddWorkspaceToBookmarksButtonClick'
		},
		applyWorkspaceButton:{
			click:'onApplyWorkspaceButton'
		},
		cancelAddWorkspaceToBookmarksButton: {
			click: 'onCancelButtonClick'
		}
	},
	
	onShow: function(){
		if (!this.getLoaded()){
			this.setLoaded(true);
			var storeIstituti = Ext.create('Desktop.store.Institutes');
			storeIstituti.setProxy(new Ext.data.proxy.Direct({
			    isSynchronous : true, 
			    directFn : "institutesService.list",
			    reader : {
			    	root : "records"
			    },
			    listeners: {
			    }
			  }));
			this.setStoreIstituti(storeIstituti);
			
			var storeAnniScolastici = Ext.create('Desktop.store.AnniScolastici');
			this.setStoreAnniScolastici(storeAnniScolastici);
			
			var storeClassi = Ext.create('Desktop.store.Classi');
			this.setStoreClassi(storeClassi);
			
			var storeMaterie = Ext.create('Desktop.store.Materie');
			this.setStoreMaterie(storeMaterie);
			
			var storeDocentiIstituto = Ext.create('Desktop.store.DocentiIstituto');
			this.setStoreDocentiIstituto(storeDocentiIstituto);
			
			var storeFamigliari = Ext.create('Desktop.store.FamigliariClasse');
			this.setStoreFamigliari(storeFamigliari);
			
			var storeAlunniClasse = Ext.create('Desktop.store.AlunniClasse');
			this.setStoreAlunniClasse(storeAlunniClasse);
			
			var store = this.getSpaziLavoroStore();
			
			store.proxy.addListener('exception', this.storeException, this);
			
			
			this.getIstituto().bindStore(storeIstituti);
			this.getAnno_scolastico().bindStore(storeAnniScolastici);
			this.getClasse().bindStore(storeClassi);
			this.getMateria().bindStore(storeMaterie);
			this.getDocente().bindStore(storeDocentiIstituto);
			this.getFamigliare().bindStore(storeFamigliari);
			this.getAlunno().bindStore(storeAlunniClasse);
	
			/*
			this.getAvailableWorkspaces().bindStore(store);
			*/
			
			this.getWorkspaceGridPanel().bindStore(store);
			
			storeIstituti.load({});
		}
	},
	
	storeException: function ( element, response, operation, eOpts ){
		Ext.Msg.show({
        	title:i18n.error,
        	buttons: Ext.Msg.OK,
        	msg: response.result.message,
        	icon: Ext.MessageBox.ERROR
        });
		store.rejectChanges();
	},
	
	syncFailure: function ( batch, eOpts ){
		Ext.Msg.show({
        	title:i18n.error,
        	buttons: Ext.Msg.OK,
        	msg: response.result.message,
        	icon: Ext.MessageBox.ERROR
        });
	},
	
	syncSuccess: function ( batch, eOpts ){
		if (!Ext.isEmpty(eOpts.operations.create)){
			//create
			Ext.Msg.show({
	        	title:i18n.successful,
	        	buttons: Ext.Msg.OK,
	        	msg: Ext.String.format(i18n.workspace_added, eOpts.operations.create[0].data.descrizione),
	        	icon: Ext.MessageBox.INFO
	        });
		}
		else if (!Ext.isEmpty(eOpts.operations.update)){
			//update
			Ext.Msg.show({
	        	title:i18n.successful,
	        	buttons: Ext.Msg.OK,
	        	msg: Ext.String.format(i18n.workspace_updated, eOpts.operations.update[0].data.descrizione),
	        	icon: Ext.MessageBox.INFO
	        });
		}
		else if (!Ext.isEmpty(eOpts.operations.destroy)){
			//destroy
			Ext.Msg.show({
	        	title:i18n.successful,
	        	buttons: Ext.Msg.OK,
	        	msg: Ext.String.format(i18n.workspace_deleted, eOpts.operations.destroy[0].data.descrizione),
	        	icon: Ext.MessageBox.INFO
	        });
		}
	},
	
	clearFiltri: function(){
		
		if (Ext.isObject(this.getIstituto())){
			this.getIstituto().clearValue();
			this.getAnno_scolastico().clearValue();
			this.getClasse().clearValue();
			this.getMateria().clearValue();
			this.getDocente().clearValue();
			this.getFamigliare().clearValue();
			this.getAlunno().clearValue();
		}
	},
	onHide: function(){
		var sharedStorage = this.getSharedStorage();
		//se lo spazio di lavoro selezionato è definito come preferito pulisco altrimenti mantengo
		if (sharedStorage.sl_spazio_lavoro != -1){
			this.clearFiltri();
		}
	},
	
	onActionColumnClick: function(grid, cell, rowIndex, columnIndex, event, workspace, row){
		var me = this;
		var sharedStorage = this.getSharedStorage();
		var store = grid.getStore();
		var record = store.getAt(rowIndex);
		if (store.getCount() > 1){
			var workspaceDesc = record.get("descrizione");
			Ext.Msg.confirm(i18n.workspace_delete_title, Ext.String.format(i18n.workspace_delete_selected, workspaceDesc), function(btn, text){
	    	    if (btn == 'yes'){
				
					this.getSpaziLavoroStore().remove(record);
					this.getSpaziLavoroStore().sync({
						success: this.syncSuccess,
						failure: this.syncFailure,
						scope: this
					});
					
					var nuovoSpazioDiLavoro = store.getAt(0);
					if (record.get("spazio_lavoro") == sharedStorage.sl_spazio_lavoro){
						sharedStorage.changeSpazioLavoro(nuovoSpazioDiLavoro);
						
						successTitleMsg = i18n.workspace_delete_title;
						successMsg = Ext.String.format(i18n.workspace_is_current_selected, record.get("descrizione"), nuovoSpazioDiLavoro.get("descrizione"));
						
						Ext.Msg.show({
			            	title:successTitleMsg,
			            	buttons: Ext.Msg.OK,
			            	msg: successMsg,
			            	icon: Ext.MessageBox.INFO
			            });
					}
	    	    }
			}, this);
		}
		else{
			successTitleMsg = i18n.workspace_delete_title;
			successMsg = Ext.String.format(i18n.workspace_is_last_available, record.get("descrizione"));
			
			Ext.Msg.show({
            	title:successTitleMsg,
            	buttons: Ext.Msg.OK,
            	msg: successMsg,
            	icon: Ext.MessageBox.INFO
            });
		}
	},
	
	buildSpazioLavoro: function() {
		var descrizione = this.getNomePerPreferito().getValue();
		var istituto = this.getIstituto().getValue();
		var anno_scolastico = this.getAnno_scolastico().getValue();
		var materia = this.getMateria().getValue();
		var classe = this.getClasse().getValue();
		var docente = this.getDocente().getValue();
		var famigliare = this.getFamigliare().getValue();
		var alunno = this.getAlunno().getValue();
		var nuovoSpazioDiLavoro = new Desktop.model.SpazioLavoro({
			    rv : 0,
			    spazio_lavoro : 0,
			    descrizione : descrizione,
			    istituto : istituto,
			    anno_scolastico : anno_scolastico,
			    classe : classe,
				materia : materia,
				docente : docente,
				famigliare : famigliare,
				alunno : alunno,
				spazio_lavoro_default : false
        });
		return nuovoSpazioDiLavoro;
	},
	
	onApplyWorkspaceButton: function() {
		if (this.getWorkspaceDefinitionForm().isValid() && 
				this.getIstituto().isValid() && 
				this.getAnno_scolastico().isValid() && 
				this.getClasse().isValid() && 
				this.getMateria().isValid() && 
				this.getDocente().isValid() && 
				this.getFamigliare().isValid() && 
				this.getAlunno().isValid() && 
				this.getNomePerPreferito().isValid()){
			var nuovoSpazioDiLavoro = this.buildSpazioLavoro();
			nuovoSpazioDiLavoro.set("spazio_lavoro", "-1");
			this.getSharedStorage().changeSpazioLavoro(nuovoSpazioDiLavoro);
			
			this.getView().close();
		}
	},
	
	onClickAddWorkspace: function() {
		var spazio_lavoro = this.getSharedStorage().sl_spazio_lavoro;
		if (this.getLoaded() && spazio_lavoro != -1){
			this.clearFiltri();
		}
		this.setNewWorkspeceFormMode(false);
		this.getWorkspacePanel().hide();
		this.getWorkspaceDefinitionForm().show();
	},
	
	onAddWorkspaceToBookmarksButtonClick: function() {
		if (this.getWorkspaceDefinitionForm().isValid() && 
				this.getIstituto().isValid() && 
				this.getAnno_scolastico().isValid() && 
				this.getClasse().isValid() && 
				this.getMateria().isValid() && 
				this.getDocente().isValid() && 
				this.getFamigliare().isValid() && 
				this.getAlunno().isValid() && 
				this.getNomePerPreferito().isValid()){
			var nuovoSpazioDiLavoro = this.buildSpazioLavoro();
			if (this.getModify()){
				//stiamo modificando un record
				var record = this.getModifyRecord();
				
				var classe = this.getClasse().getValue();// || 0;
				var materia = this.getMateria().getValue();// || 0;
				var docente = this.getDocente().getValue();// || 0;
				var famigliare = this.getFamigliare().getValue();// || 0;
				var alunno = this.getAlunno().getValue();// || 0;
				
				record.set("descrizione", this.getNomePerPreferito().getValue());
				record.set("istituto", this.getIstituto().getValue());
				record.set("anno_scolastico", this.getAnno_scolastico().getValue());

				record.set("classe", classe);
				record.set("materia", materia);
				record.set("docente", docente);
				record.set("famigliare", famigliare);
				record.set("alunno", alunno);
				
				this.getSpaziLavoroStore().sync({
					success: this.syncSuccess,
					failure: this.syncFailure,
					scope: this
				});
				
				this.setModifyRecord(null);
			}
			else{
				//stiamo inserendo un record
				this.getSpaziLavoroStore().add(nuovoSpazioDiLavoro);
				this.getSpaziLavoroStore().sync({
					success: this.syncSuccess,
					failure: this.syncFailure,
					scope: this
				});
			}

			this.getWorkspaceDefinitionForm().hide();
			this.getWorkspacePanel().show();
		}
	},
	
	onCancelButtonClick: function() {
		this.setNewWorkspeceFormMode(false);
		this.getWorkspaceDefinitionForm().hide();
		this.getWorkspacePanel().show();
	},
	
	onIstitutoChange: function ( combo, newValue, oldValue, eOpts ){
		var comboAnnoScolastico = this.getAnno_scolastico();
		comboAnnoScolastico.clearValue();
		var comboMateria = this.getMateria();
		comboMateria.clearValue();
		var comboDocente = this.getDocente();
		comboDocente.clearValue();

		
		if (!Ext.isEmpty(newValue)){
			this.getView().setLoading(true);
			spazioLavoroDefaultService.getSessionPersona(newValue, function(provider, response) {
	    		// process response
				if (response.result.ok){
					this.getSharedStorage().persona = response.result.payload.code;
					
					var comboClasse = this.getClasse();
					var comboFamigliare = this.getFamigliare();
					var comboAlunno = this.getAlunno();
					comboClasse.clearValue();
					comboFamigliare.clearValue();
					comboAlunno.clearValue();
					
					comboAnnoScolastico.getStore().load({
						params:{institute: newValue},
						callback: function(records, operation, success) {
					        if (success && !Ext.isEmpty(this.getToSelectAnnoScolastico())){
					        	var storeAnniScolastici = this.getStoreAnniScolastici();
								var annoScolasticoIndex = storeAnniScolastici.find("anno_scolastico", this.getToSelectAnnoScolastico());
								comboAnnoScolastico.setValue(storeAnniScolastici.getAt(annoScolasticoIndex), true);
					        	this.setToSelectAnnoScolastico(null);
					        }
					    },
					    scope: this
					});

					comboMateria.getStore().load({
						params:{institute: newValue},
						callback: function(records, operation, success) {
					        if (success && !Ext.isEmpty(this.getToSelectMateria())){
								var storeMaterie = this.getStoreMaterie();
								var materiaIndex = storeMaterie.find("materia", this.getToSelectMateria());
					        	comboMateria.setValue(storeMaterie.getAt(materiaIndex), true);
					        	this.setToSelectMateria(null);
					        }
					    },
					    scope: this
					});
					
					comboDocente.getStore().load({
						params:{institute: newValue},
						callback: function(records, operation, success) {
					        if (success && !Ext.isEmpty(this.getToSelectDocente())){
								var storeDocentiIstituto = this.getStoreDocentiIstituto();
								var docenteIndex = storeDocentiIstituto.find("docente", this.getToSelectDocente());
					        	comboDocente.setValue(storeDocentiIstituto.getAt(docenteIndex), true);
					        	this.setToSelectDocente(null);
					        }
					    },
					    scope: this
					});
					
					this.updateNomePerPreferito();
					this.getView().setLoading(false);
				}
				else{
					Ext.Msg.show({
						title:i18n.workspace_selection_error,
						buttons: Ext.Msg.OK,
						msg: Desktop.ux.util.ExceptionDecoder.decode(response.result),
						icon: Ext.MessageBox.ERROR
					});
					this.getView().setLoading(Desktop.ux.util.ExceptionDecoder.decode(response.result));
				}
			}, this);
		}
		else{
			this.getNomePerPreferito().reset();
		}
	},
	
	onAnnoScolasticoChange: function ( combo, newValue, oldValue, eOpts ){
		if (!Ext.isEmpty(newValue) && newValue != -1){
			var comboClasse = this.getClasse();
			comboClasse.clearValue();
			comboClasse.getStore().load({
				params:{anno_scolastico: newValue},
				callback: function(records, operation, success) {
			        if (success && !Ext.isEmpty(this.getToSelectClasse())){
						var storeClassi = this.getStoreClassi();
						var classeIndex = storeClassi.find("classe", this.getToSelectClasse());
						comboClasse.setValue(storeClassi.getAt(classeIndex), true);
			        	this.setToSelectClasse(null);
			        }
			    },
			    scope: this
			});
			
			var comboFamigliare = this.getFamigliare();
			var comboAlunno = this.getAlunno();
			
			comboFamigliare.clearValue();
			comboAlunno.clearValue();
			
			this.updateNomePerPreferito();
		}
	},
	
	onClasseChange: function ( combo, newValue, oldValue, eOpts ){
		if (!Ext.isEmpty(newValue) && newValue != -1){
			var comboFamigliare = this.getFamigliare();
			var comboAlunno = this.getAlunno();
			
			comboFamigliare.clearValue();
			comboAlunno.clearValue();
			
			var classe = this.getClasse().getValue();
			
			comboFamigliare.getStore().load({
				params:{
					classe:classe
				},
				callback: function(records, operation, success) {
			        if (success && !Ext.isEmpty(this.getToSelectFamigliare())){
						var storeFamigliari = this.getStoreFamigliari();
						var famigliareIndex = storeFamigliari.find("famigliare", this.getToSelectFamigliare());
						comboFamigliare.setValue(storeFamigliari.getAt(famigliareIndex), true);
			        	this.setToSelectFamigliare(null);
			        }
			    },
			    scope: this
			});
			
			comboAlunno.getStore().load({
				params:{
					classe:classe
				},
				callback: function(records, operation, success) {
			        if (success && !Ext.isEmpty(this.getToSelectAlunniClasse())){
			        	var storeAlunniClasse = this.getStoreAlunniClasse();
						var alunnoIndex = storeAlunniClasse.find("alunno", this.getToSelectAlunniClasse());
						comboAlunno.setValue(storeAlunniClasse.getAt(alunnoIndex), true);
			        	this.setToSelectAlunniClasse(null);
			        }
			    },
			    scope: this
			});
			
			this.updateNomePerPreferito();
		}
	},
	
	onMateriaChange: function ( combo, newValue, oldValue, eOpts ){
		if (!Ext.isEmpty(newValue) && newValue != -1){
			this.updateNomePerPreferito();
		}
	},
	
	onDocenteChange:function ( combo, newValue, oldValue, eOpts ){
		if (!Ext.isEmpty(newValue) && newValue != -1){
			this.updateNomePerPreferito();
		}
	},
	
	onFamigliareChange:function ( combo, newValue, oldValue, eOpts ){
		if (!Ext.isEmpty(newValue) && newValue != -1){
			this.updateNomePerPreferito();
		}
	},
	
	onAlunnoChange:function ( combo, newValue, oldValue, eOpts ){
		if (!Ext.isEmpty(newValue) && newValue != -1){
			this.updateNomePerPreferito();
		}
	},
	
	onClasseSpecialKey: function ( combo, e, eOpts ){
		if (e.getKey() == e.DELETE){
			combo.clearValue();
			this.updateNomePerPreferito();
		}
	},
	
	onMateriaSpecialKey: function ( combo, e, eOpts ){
		if (e.getKey() == e.DELETE){
			combo.clearValue();
			this.updateNomePerPreferito();
		}
	},
	
	onDocenteSpecialKey: function ( combo, e, eOpts ){
		if (e.getKey() == e.DELETE){
			combo.clearValue();
			this.updateNomePerPreferito();
		}
	},
	
	onFamigliareSpecialKey: function ( combo, e, eOpts ){
		if (e.getKey() == e.DELETE){
			combo.clearValue();
			this.updateNomePerPreferito();
		}
	},
	
	onAlunnoSpecialKey: function ( combo, e, eOpts ){
		if (e.getKey() == e.DELETE){
			combo.clearValue();
			this.updateNomePerPreferito();
		}
	},
	
	onNomePerPreferitoFocus: function ( field, The, eOpts ){
		var toSetNomePerPreferito = this.getToSetNomePerPreferito();
		if (Ext.isEmpty(toSetNomePerPreferito)){
			this.setToSetNomePerPreferito(field.getValue());
		}
	},
	
	onNomePerPreferitoBlur: function ( field, The, eOpts ){
		if (field.getValue().length == 0 || field.getValue() != this.getToSetNomePerPreferito()){
			this.setToSetNomePerPreferito(field.getValue());
		}
	},
	
	onChangeSpazioLavoroCorrente: function (){
		var spazio_lavoro = this.getSharedStorage().sl_spazio_lavoro;
		if (this.getLoaded() && spazio_lavoro != -1){
			this.clearFiltri();
		}
	},
	
	updateNomePerPreferito : function (){
		var descrizione = "";
		var toSetNomePerPreferito = this.getToSetNomePerPreferito();

		var descIstituto = this.getIstituto().getValue();
		var annoScolastico = this.getAnno_scolastico().getValue();
		var classe = this.getClasse().getValue();
		var materia = this.getMateria().getValue();
		var docente = this.getDocente().getValue();
		var famigliare = this.getFamigliare().getValue();
		var alunno = this.getAlunno().getValue();

		descrizione = this.getIstituto().findRecordByValue(descIstituto).get("descrizione");
		if (!Ext.isEmpty(annoScolastico)){
			descrizione += " - " + this.getAnno_scolastico().findRecordByValue(annoScolastico).get("descrizione");
		}
		if (!Ext.isEmpty(classe)){
			descrizione += " - " + this.getClasse().findRecordByValue(classe).get("descrizione");
		}
		if (!Ext.isEmpty(materia)){
			descrizione += " - " + this.getMateria().findRecordByValue(materia).get("descrizione");
		}
		if (!Ext.isEmpty(docente)){
			descrizione += " - " + this.getDocente().findRecordByValue(docente).get("nome_cognome");
		}
		if (!Ext.isEmpty(famigliare)){
			descrizione += " - " + this.getFamigliare().findRecordByValue(famigliare).get("nome_cognome");
		}
		if (!Ext.isEmpty(alunno)){
			descrizione += " - " + this.getAlunno().findRecordByValue(alunno).get("nome_cognome");
		}
		// ho calcolato la descrizione
		if (/*this.getModify() && */!Ext.isEmpty(toSetNomePerPreferito)){
			if (descrizione != toSetNomePerPreferito){
				descrizione = toSetNomePerPreferito;
			}
			else{
				if (Ext.isEmpty(this.getToSelectAnnoScolastico()) && Ext.isEmpty(this.getToSelectClasse()) && Ext.isEmpty(this.getToSelectMateria()) && Ext.isEmpty(this.getToSelectDocente()) && Ext.isEmpty(this.getToSelectFamigliare()) && Ext.isEmpty(this.getToSelectAlunniClasse())){
					this.setToSetNomePerPreferito(null); 
				}
			}
		}
		
		this.getNomePerPreferito().setValue(descrizione);
	},
	
	onWorkspaceGridPanelCellDBLClick: function ( institutesGrid, td, cellIndex, record, tr, rowIndex, e, eOpts ){
		this.clearFiltri();
		this.setNewWorkspeceFormMode(true, record);
		this.getWorkspacePanel().hide();
		this.getWorkspaceDefinitionForm().show();
	},
	
	setNewWorkspeceFormMode: function(modify, record){
		this.setModify(modify);
		
		if (modify){
			this.setModifyRecord(record);
			
			var valIstituto = record.get("istituto");
			var storeIstituti = this.getStoreIstituti();
			var istitutoIndex = storeIstituti.find("istituto", valIstituto);
			
			var valAnnoScolastico = record.get("anno_scolastico");
			this.setToSelectAnnoScolastico(valAnnoScolastico);
			
			var valClasse = record.get("classe");
			if (!Ext.isEmpty(valClasse)){
				this.setToSelectClasse(valClasse);
			}
			var valMateria = record.get("materia");
			if (!Ext.isEmpty(valMateria)){
				this.setToSelectMateria(valMateria);
			}
			var valDocente = record.get("docente");
			if (!Ext.isEmpty(valDocente)){
				this.setToSelectDocente(valDocente);
			}
			var valFamigliare = record.get("famigliare");
			if (!Ext.isEmpty(valFamigliare)){
				this.setToSelectFamigliare(valFamigliare);
			}
			var valAlunno = record.get("alunno");
			if (!Ext.isEmpty(valAlunno)){
				this.setToSelectAlunniClasse(valAlunno);
			}
			
			this.setToSetNomePerPreferito(record.get("descrizione"));
			var cmbIstituto = this.getIstituto();
			var istitutoCorrenteOldValue = cmbIstituto.getValue();
			var istitutoNewValue = storeIstituti.getAt(istitutoIndex);
			this.getIstituto().setValue(istitutoNewValue, true);
			if (istitutoCorrenteOldValue == istitutoNewValue.get("istituto")){
				//se l'istituto non cambia devo lanciare forzatamente una onChange per scatenare l'aggioramento a cascata delle varie combo
				cmbIstituto.fireEvent("change", cmbIstituto, istitutoNewValue.get("istituto"), istitutoCorrenteOldValue);
			}
		}
	}
});