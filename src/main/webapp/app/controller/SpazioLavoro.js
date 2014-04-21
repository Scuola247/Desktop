Ext.define('Desktop.controller.SpazioLavoro', {
	extend: 'Deft.mvc.ViewController',
	mixins: ['Deft.mixin.Injectable'],
	inject: ['spaziLavoroStore', 'sharedStorage'],
	observe: {
		sharedStorage: {
			spazioLavoroChanged: 'onChangeSpazioLavoroCorrente'
		}
	},
	
	config: {
		spaziLavoroStore: null,
		sharedStorage: null,
		loaded: false
	},
	control: {	
		view: {
			show: 'onShow',
			hide: 'onHide'
		},
		workspaceDefinitionForm:true,
		workspaceManagementForm:true,
		istituto:{
			change: 'onIstitutoChange'
		},
		anno_scolastico:{
			change: 'onAnnoScolasticoChange'
		},
		classe:{
			change: 'onClasseChange'
		},
		materia:{
			change: 'onMateriaChange'
		},
		docente:{
			change: 'onDocenteChange'
		},
		famigliare:{
			change: 'onFamigliareChange'
		},
		alunno:{
			change: 'onAlunnoChange'
		},
		nomePerPreferito:true,
		availableWorkspaces:true,
		deleteWorkspaceButton: {
			click: 'onDeleteWorkspaceButtonClick'
		},
		addWorkspaceToBookmarksButton: {
			click: 'onAddWorkspaceToBookmarksButtonClick'
		},
		applyWorkspaceButton:{
			click:'onApplyWorkspaceButton'
		},
		cancelAddWorkspaceToBookmarksButton: {
			click: 'onCancelButtonClick'
		},
		cancelDeleteWorkspaceButton: {
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
			
			var storeAnniScolastici = Ext.create('Desktop.store.AnniScolastici');
			
			var storeClassi = Ext.create('Desktop.store.Classi');
			
			var storeMaterie = Ext.create('Desktop.store.Materie');
			
			var storeDocentiIstituto = Ext.create('Desktop.store.DocentiIstituto');
			
			var storeFamigliari = Ext.create('Desktop.store.FamigliariClasse');
			
			var storeAlunniClasse = Ext.create('Desktop.store.AlunniClasse');
			
			var store = this.getSpaziLavoroStore();
			
			store.proxy.addListener('exception', function ( element, response, operation, eOpts ){
				Desktop.ux.window.Notification.error(i18n.error, response.result.message);
				store.rejectChanges();
	    	}, this);
			
			this.getIstituto().bindStore(storeIstituti);
			this.getAnno_scolastico().bindStore(storeAnniScolastici);
			this.getClasse().bindStore(storeClassi);
			this.getMateria().bindStore(storeMaterie);
			this.getDocente().bindStore(storeDocentiIstituto);
			this.getFamigliare().bindStore(storeFamigliari);
			this.getAlunno().bindStore(storeAlunniClasse);
	
			this.getAvailableWorkspaces().bindStore(store);
			
			storeIstituti.load({});
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
		this.getAvailableWorkspaces().clearValue();
	},
	
	onDeleteWorkspaceButtonClick: function(){
		var me = this;
		var sharedStorage = this.getSharedStorage();
		var combo = this.getAvailableWorkspaces();
		var store = combo.getStore();
		var spazioDiLavoro = combo.getValue();
		var record = combo.findRecordByValue(spazioDiLavoro);
		if (store.getCount() > 1){
			this.getSpaziLavoroStore().remove(record);
			combo.clearValue();
			
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
		if (this.getWorkspaceDefinitionForm().isValid() && this.getIstituto().isValid()){
			var nuovoSpazioDiLavoro = this.buildSpazioLavoro();
			nuovoSpazioDiLavoro.set("spazio_lavoro", "-1");
			this.getSharedStorage().changeSpazioLavoro(nuovoSpazioDiLavoro);
			
			this.getView().close();
		}
	},
	
	onAddWorkspaceToBookmarksButtonClick: function() {
		var me = this;
		
		if (this.getWorkspaceDefinitionForm().isValid() && this.getIstituto().isValid()){
			var nuovoSpazioDiLavoro = this.buildSpazioLavoro();
			
			this.getSpaziLavoroStore().add(nuovoSpazioDiLavoro);
		}
	},
	
	onCancelButtonClick: function() {
		this.getView().close();
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
				if (Ext.isNumeric(response.result)){
					this.getSharedStorage().persona = parseInt(response.result);
					
					var comboClasse = this.getClasse();
					var comboFamigliare = this.getFamigliare();
					var comboAlunno = this.getAlunno();
					comboClasse.clearValue();
					comboFamigliare.clearValue();
					comboAlunno.clearValue();
					
					comboAnnoScolastico.getStore().load({
						params:{institute: newValue}
					});

					comboMateria.getStore().load({
						params:{institute: newValue}
					});
					
					comboDocente.getStore().load({
						params:{institute: newValue}
					});
					
					this.updateNomePerPreferito();
					this.getView().setLoading(false);
				}
				else{
					//response.result è il messaggio di errore
					Ext.Msg.show({
						title:i18n.workspace_selection_error,
						buttons: Ext.Msg.OK,
						msg: response.result,
						icon: Ext.MessageBox.ERROR
					});
					this.getView().setLoading(response.result);
				}
			}, this);
		}
		else{
			this.getNomePerPreferito().reset();
		}
	},
	
	onAnnoScolasticoChange: function ( combo, newValue, oldValue, eOpts ){
		if (!Ext.isEmpty(newValue)){
			var comboClasse = this.getClasse();
			comboClasse.clearValue();
			comboClasse.getStore().load({
				params:{anno_scolastico: newValue}
			});
			
			var comboFamigliare = this.getFamigliare();
			var comboAlunno = this.getAlunno();
			
			comboFamigliare.clearValue();
			comboAlunno.clearValue();
			
			this.updateNomePerPreferito();
		}
	},
	
	onClasseChange: function ( combo, newValue, oldValue, eOpts ){
		if (!Ext.isEmpty(newValue)){
			var comboFamigliare = this.getFamigliare();
			var comboAlunno = this.getAlunno();
			
			comboFamigliare.clearValue();
			comboAlunno.clearValue();
			
			var classe = this.getClasse().getValue();
			
			comboFamigliare.getStore().load({
				params:{
					classe:classe
				}
			});
			
			comboAlunno.getStore().load({
				params:{
					classe:classe
				}
			});
			
			this.updateNomePerPreferito();
		}
	},
	
	onMateriaChange: function ( combo, newValue, oldValue, eOpts ){
		if (!Ext.isEmpty(newValue)){
			this.updateNomePerPreferito();
		}
	},
	
	onDocenteChange:function ( combo, newValue, oldValue, eOpts ){
		if (!Ext.isEmpty(newValue)){
			this.updateNomePerPreferito();
		}
	},
	
	onFamigliareChange:function ( combo, newValue, oldValue, eOpts ){
		if (!Ext.isEmpty(newValue)){
			this.updateNomePerPreferito();
		}
	},
	
	onAlunnoChange:function ( combo, newValue, oldValue, eOpts ){
		if (!Ext.isEmpty(newValue)){
			this.updateNomePerPreferito();
		}
	},
	
	onChangeSpazioLavoroCorrente: function (){
		var spazio_lavoro = this.getSharedStorage().sl_spazio_lavoro;
		if (this.getLoaded() && spazio_lavoro != -1){
			this.clearFiltri();
		}
	},
	
	updateNomePerPreferito : function (){
		var descIstituto = this.getIstituto().getValue();
		var annoScolastico = this.getAnno_scolastico().getValue();
		var classe = this.getClasse().getValue();
		var materia = this.getMateria().getValue();
		var docente = this.getDocente().getValue();
		var famigliare = this.getFamigliare().getValue();
		var alunno = this.getAlunno().getValue();

		var descrizione = this.getIstituto().findRecordByValue(descIstituto).get("descrizione");
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
		
		this.getNomePerPreferito().setValue(descrizione);
	}
});