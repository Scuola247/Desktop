Ext.define('Desktop.controller.TeacherRegister', {
	extend: 'Deft.mvc.ViewController',
	inject: ['sharedStorage'],
	requires: [], 

	config: {
		sharedStorage: null,
		descrizione: null,
		storeGrigliaValutazioneColonne: null,
		istituto: null,
		classe: null,
		docente: null,
		materia: null,
		voti: null,
		alunno: null,
		isUpdating: false,
		selectedRow: null,
		selectedCol: null,
		editRow: null,
		editCol: null,
//		selectedRV: null,
//		selectedValutazione: null,
		selectedMetrica: null,
		selectedTipoVoto: null,
		selectedArgomento: null,
		selectedData: null
	},
	
	control: {
		view: {
			show: 'onShow',
			contextmenu: {
				fn: 'preventContextMenu',
				element: 'el',
				preventDefault: true
			}
		},
		
		teacherRegisterTabPanel: {
			tabchange: 'onTeacherRegisterTabPanelChange'
		},
		judgmentGrid: {
			select: 'onJudgmentGridSelect',
			cellclick: 'onJudgmentGridCellClick',
			cellkeydown: 'onJudgmentGridCellKeydown',
			validateedit : 'onJudgmentGridValidateEdit',
			cellcontextmenu: 'onGridContextmenu'
		},
		judgmentGridAddPanel:true,
		judgmentGridAddForm:true,
		judgmentGridAddFormTipoVoto:{
			blur: 'judgmentGridAddFormTipoVotoBlur'
		},
		judgmentGridAddFormArgomento:{
			blur: 'judgmentGridAddFormArgomentoBlur'
		},
		judgmentGridAddFormMetrica:{
			blur: 'judgmentGridAddFormMetricaBlur'
		},
		judgmentGridAddFormGiorno:true,
		addJudgmentConfirmButton:{
			click : 'addJudgmentConfirmButtonClick'
		},
		addJudgmentCancelButton:{
			click : 'addJudgmentCancelButtonClick'
		},
		judgmentGridEditPanel:true,
		judgmentGridEditForm:true,
		judgmentGridEditFormValutazione:true,
		judgmentGridEditFormRV: true,
		judgmentGridEditFormGiudizio: true,
		judgmentGridEditFormPrivata: true,
		judgmentGridEditFormNota: true,
		judgmentGridEditConfirmButton:{
			click : 'judgmentGridEditConfirmButtonClick'
		},
		judgmentGridEditCancelButton:{
			click : 'judgmentGridEditCancelButtonClick'
		},
		addJudgmentButton:{
			click: 'onAddJudgmentButtonClick'
		},
		showJudgmentGridDetails:{
			toggle: 'onToggleShowJudgmentGridDetails'
		},
		studentsGrid: true,
		signaturesGrid: true,
		lessonsGrid: true,
		addPersonalNoteButton:{
			click : 'onClickAddPersonalNoteButton'
		},
		scheduleGridWeek:{
			change : 'onChangeScheduleGridWeek'
		},
		personalScheduleGridWeek:{
			change : 'onChangePersonalScheduleGridWeek'
		}
		
	},
	
	onGridContextmenu: function(grid, td, cellIndex, record, tr, rowIndex, e, eOpts) {
		e.preventDefault();
		
		this.setEditRow(rowIndex);
		this.setEditCol(cellIndex);
		this.setSelectedCol(cellIndex);
		
		var valutazione = record.get("va_" + (cellIndex + 1));
		if(grid.getHeaderByCell(td).dataIndex.search('vo_') !== -1 && !Ext.isEmpty(valutazione)){
	        var contextMenu = Ext.widget('editdelete');
	        
	        var rv = record.get("rv_" + (cellIndex + 1));
			
			contextMenu.utils = {
					scope: this,
					data:{
						rv: rv,
						val: valutazione,
						row: rowIndex,
						col: cellIndex + 1,
						store: grid.getStore()
					},
					onModificaClick: this.onModificaClick,
					onEliminaClick: this.onEliminaClick
			},
			
	 		contextMenu.showAt(e.getXY());
		}
	},
	
	preventContextMenu: function(e, t, eOpts ){
		e.preventDefault();
	},
	
	onShow: function() {
		var view = this.getView();

		this.getJudgmentGridAddFormGiorno().setDisabled(true);
		
		var sharedStorage = this.getSharedStorage();
		this.setDescrizione(sharedStorage.sl_descrizione);
		this.setIstituto(sharedStorage.sl_istituto);
		this.setClasse(sharedStorage.sl_classe);
		this.setDocente(sharedStorage.sl_docente);
		this.setMateria(sharedStorage.sl_materia);
		
		if (Ext.isEmpty(this.getClasse()) || this.getClasse() == 0){
			Desktop.ux.window.Notification.info(i18n.important, i18n.workspace_required_class);
			view.destroy();
		}
		else{
			if (Ext.isEmpty(this.getDocente()) || this.getDocente() == 0){
				Desktop.ux.window.Notification.info(i18n.important, i18n.workspace_required_teacher);
				view.destroy();
			}
			else{
				if (Ext.isEmpty(this.getMateria()) || this.getMateria() == 0){
					Desktop.ux.window.Notification.info(i18n.important, i18n.workspace_required_subject);
					view.destroy();
				}
				else{
					// ho tutto il necessario preparo la finistra
					view.setTitle(i18n.teacher_register_title + " - " + this.getDescrizione());
					
					var storeGrigliaValutazioneColonne = Ext.create('Desktop.store.GrigliaValutazioneColonne');
					this.setStoreGrigliaValutazioneColonne(storeGrigliaValutazioneColonne);	//mantengo il riferimento
					storeGrigliaValutazioneColonne.load({
						params:{
							classe:this.getClasse(),
							docente:this.getDocente(),
							materia:this.getMateria()
						},
						callback: function(records, operation, success) {
					        // the operation object
					        // contains all of the details of the load operation
							if (success){
								var columns = this.getJudgmentGrid().columns;
								
								var voti = new Ext.util.MixedCollection(); 
								this.setVoti(voti);
								
								for (var i = 0; i < records.length; i++){
									var record = records[i];
									var metrica = record.get('metrica');
									this.preloadVotiMetrica(metrica);
									/*
									var storeVoti = voti.get(metrica);
									if (storeVoti == null){
										storeVoti = Ext.create('Desktop.store.Voti');
										storeVoti.getProxy().isSynchronous = true;
										storeVoti.load({
											params:{
												metrica: metrica
											}
										});
										voti.add(metrica, storeVoti);
									}
									*/
								}
								
								for (var i = 0; i < records.length; i++){
									var record = records[i];
									var colonna = columns[i + 10];

									this.getJudgmentGrid().headerCt.down('gridcolumn[dataIndex=vo_' + (i + 1) + ']').renderer = function (value, metaData, record, rowIndex, colIndex, store, view, returnHtml){
										if (!Ext.isEmpty(value)){
											var colonne = storeGrigliaValutazioneColonne;
											var colonna = colonne.getAt(colIndex);
											
											var votiMetrica = voti.get(colonna.get('metrica'));
											
											var voto = votiMetrica.getAt(votiMetrica.findExact('voto', value));
											
											var millesimi = voto.get('millesimi');
											var color = "#FF0000";
											if (millesimi < 101){
												color = "#FF0000";
											} else if (millesimi < 201){
												color = "#FF0000";
											} else if (millesimi < 301){
												color = "#FF0000";
											} else if (millesimi < 401){
												color = "#FF8000";
											} else if (millesimi < 501){
												color = "#FF8000";
											} else if (millesimi < 601){
												color = "#4B8A08";
											} else if (millesimi < 701){
												color = "#4B8A08";
											} else if (millesimi < 801){
												color = "#4B8A08";
											} else if (millesimi < 901){
												color = "#0174DF";
											} else {
												color = "#0404B4";
											}
											
											metaData.style = 'color:' + color;
											
											return voto.get('mnemonico');
										}
										else {
											return '';
										}
									};
									
									this.creaColonna(colonna, record);
								}
								
								this.getJudgmentGrid().doLayout();
								
								this.getJudgmentGrid().getStore().load({
																			params: {
																				classe:this.getClasse(),
																				docente:this.getDocente(),
																				materia:this.getMateria()
																			}
								});

							}
							else{
								//TODO: messaggio di errore?
							}
						},
						scope:this
					});
					
					this.getStudentsGrid().getStore().load({
																params: {
																	classe:this.getClasse()
																}
					});
					this.getSignaturesGrid().getStore().load({
																params: {
																	classe:this.getClasse(),
																	docente:this.getDocente()
																}
					});
					this.getLessonsGrid().getStore().load({
																params: {
																	classe:this.getClasse(),
																	docente:this.getDocente(),
																	materia:this.getMateria()
																}
					});
					this.getJudgmentGridAddFormTipoVoto().getStore().load({
																params: {
																	materia:this.getMateria()
																}
					});
					this.getJudgmentGridAddFormArgomento().getStore().load({
																params: {
																	classe:this.getClasse(),
																	materia:this.getMateria()
																}
					});
					this.getJudgmentGridAddFormMetrica().getStore().load({
																params: {
																	istituto:this.getIstituto()
																}
					});
					
				}
			}
		}
	},
	onJudgmentGridValidateEdit: function ( editor, e, eOpts ){
		this.setEditRow(e.rowIdx);
		this.setEditCol(e.colIdx);
		
		var voto = e.value;
		if (!this.getIsUpdating() && !Ext.isEmpty(voto)){
			this.setIsUpdating(true);
			var judgmentGridStore = this.getJudgmentGrid().getStore();
			var indexRow = this.getEditRow();
			var indexCol = this.getEditCol() + 1;
			
			var record = judgmentGridStore.getAt(indexRow);
			var rv = record.get("rv_" + indexCol);
			var valutazione = record.get("va_" + indexCol);
			var vo = record.get("vo_" + indexCol);
			if (voto == -1){
				var colonne = this.getStoreGrigliaValutazioneColonne();
				var selectedCol = this.getSelectedCol();
				var colonna = colonne.getAt(selectedCol);
				
				var votiMetrica = this.getVoti().get(colonna.get('metrica'));
				
				var voto_descrizione = votiMetrica.getAt(votiMetrica.findExact('voto', vo)).get('mnemonico');
				
				var indexRow = this.getEditRow();
				var indexCol = this.getEditCol() + 1;
				
			
				
				Ext.Msg.confirm("Cancellazione voto", Ext.String.format("Confermare cancellazione voto {0}", voto_descrizione), function(btn, text){
		    	    if (btn == 'yes'){
						this.setEditRow(indexRow);
						this.setEditCol(selectedCol);
						
						valutazioniService.valutazioni_del(
								rv,  
								valutazione
								, function(provider, response) {
							   // process response
								if (!Ext.isEmpty(response.result)){
									if (!response.result.ok){
										//response.result è il messaggio di errore
										Ext.Msg.show({
						                	title:i18n.teacher_register_error,
						                	buttons: Ext.Msg.OK,
						                	msg: Desktop.ux.util.ExceptionDecoder.decode(response.result),
						                	icon: Ext.MessageBox.ERROR
						                });
									}
									else{
										var record = judgmentGridStore.getAt(indexRow);
										record.set("rv_" + indexCol, null);
										record.set("va_" + indexCol, null);
										record.set("vo_" + indexCol, null);
										
//											this.setSelectedRV(null);
//											this.setSelectedValutazione(null);
										
										judgmentGridStore.commitChanges();
										this.setEditRow(null);
										this.setEditCol(null);
									}
								}
								this.setIsUpdating(false);
							}, this);
		    	    }
		    	    else{
//		    	    	var judgmentGridStore = this.getJudgmentGrid().getStore();
//		    	    	
//		    	    	var record = judgmentGridStore.getAt(indexRow);
//		    	    	record.set("vo_" + indexCol, vo);
//		    	    	
//		    	    	judgmentGridStore.commitChanges();

		    	    }
		    	}, this);
			}
			else{
	//			var rv = this.getSelectedRV();
	//			var valutazione = this.getSelectedValutazione();
				
				var classe = this.getClasse();
				var alunno = this.getAlunno();
				var metrica = this.getSelectedMetrica();
				var materia = this.getMateria();
				var tipo_voto = this.getSelectedTipoVoto();
				var argomento = this.getSelectedArgomento();
				var docente = this.getDocente();
				var data = this.getSelectedData();
			
				valutazioniService.valutazioni_ins(
						rv,  
						valutazione, 
						classe,
					    alunno,
					    materia,
					    tipo_voto,
					    argomento,
					    voto,
					    "",
					    false,
					    docente,
					    data
						, function(provider, response) {
					   // process response
						if (!Ext.isEmpty(response.result)){
							if (!response.result.ok){
								//response.result è il messaggio di errore
								var view = this.getView();
								Ext.Msg.show({
				                	title:i18n.teacher_register_error,
				                	buttons: Ext.Msg.OK,
				                	msg:Desktop.ux.util.ExceptionDecoder.decode(response.result),
				                	icon: Ext.MessageBox.ERROR,
				                	fn:function(){
				                		view.destroy();
				                	}
				                });
							}
							else{
								
								record.set("rv_" + indexCol, response.result.payload.rv);
								record.set("va_" + indexCol, response.result.payload.valutazione);
								
								judgmentGridStore.commitChanges();
								this.setEditRow(null);
								this.setEditCol(null);
							}
						}
						this.setIsUpdating(false);
					}, this);
			}
		}
	},
	judgmentGridAddFormTipoVotoBlur: function ( field, The, eOpts ){
		this.updateJudgmentGridAddFormGiorno();
	}, 
	judgmentGridAddFormArgomentoBlur: function ( field, The, eOpts ){
		this.updateJudgmentGridAddFormGiorno();
	},
	judgmentGridAddFormMetricaBlur: function ( field, The, eOpts ){
		this.updateJudgmentGridAddFormGiorno();
	},
	onAddJudgmentButtonClick:function (){
		this.getJudgmentGrid().hide();
		this.getJudgmentGridAddFormMetrica().reset();
		this.getJudgmentGridAddFormGiorno().reset();
		this.getJudgmentGridAddFormGiorno().setDisabled(true);
		this.getJudgmentGridAddPanel().show();
	},
	
	addJudgmentConfirmButtonClick:function ( button, e, eOpts ){

		var judgmentGridAddForm = this.getJudgmentGridAddForm();
		if (judgmentGridAddForm.isValid()){
			var storeGrigliaValutazioneColonne = this.getStoreGrigliaValutazioneColonne();
			var newColumn = Ext.create('Desktop.model.GrigliaValutazioneColonna');
			
			var judgmentGridAddFormTipoVoto = this.getJudgmentGridAddFormTipoVoto();
			var judgmentGridAddFormArgomento = this.getJudgmentGridAddFormArgomento();
			var judgmentGridAddFormMetrica = this.getJudgmentGridAddFormMetrica();
			var judgmentGridAddFormGiorno = this.getJudgmentGridAddFormGiorno();
		
			var tipo_voto = judgmentGridAddFormTipoVoto.getValue();
			var tipo_voto_descrizione = judgmentGridAddFormTipoVoto.findRecordByValue(tipo_voto).get('descrizione');
			
			var argomento = judgmentGridAddFormArgomento.getValue();
			var argomento_descrizione = (argomento == null)?"":judgmentGridAddFormArgomento.findRecordByValue(argomento).get('descrizione');
			
			var metrica = judgmentGridAddFormMetrica.getValue();
			var metrica_descrizione = judgmentGridAddFormMetrica.findRecordByValue(metrica).get('descrizione');
			
			newColumn.set('giorno', judgmentGridAddFormGiorno.getValue());
			newColumn.set('tipo_voto', tipo_voto);
			newColumn.set('tipo_voto_descrizione', tipo_voto_descrizione);
			newColumn.set('argomento', argomento);
			newColumn.set('argomento_descrizione', argomento_descrizione);
			newColumn.set('metrica', metrica);
			newColumn.set('metrica_descrizione', metrica_descrizione);
			var indiceColonna = storeGrigliaValutazioneColonne.getCount();
			storeGrigliaValutazioneColonne.add(newColumn);
			
			var columns = this.getJudgmentGrid().columns;
			var colonna = columns[indiceColonna + 10];
			
			this.preloadVotiMetrica(metrica);

			var voti = this.getVoti();
			this.getJudgmentGrid().headerCt.down('gridcolumn[dataIndex=vo_' + (indiceColonna + 1) + ']').renderer = function (value, metaData, record, rowIndex, colIndex, store, view, returnHtml){
				if (!Ext.isEmpty(value)){
					var colonne = storeGrigliaValutazioneColonne;
					var colonna = colonne.getAt(colIndex);
					
					var votiMetrica = voti.get(colonna.get('metrica'));
					
					var voto = votiMetrica.getAt(votiMetrica.findExact('voto', value));
					
					var millesimi = voto.get('millesimi');
					var color = "#FF0000";
					if (millesimi < 101){
						color = "#FF0000";
					} else if (millesimi < 201){
						color = "#FF0000";
					} else if (millesimi < 301){
						color = "#FF0000";
					} else if (millesimi < 401){
						color = "#FF8000";
					} else if (millesimi < 501){
						color = "#FF8000";
					} else if (millesimi < 601){
						color = "#4B8A08";
					} else if (millesimi < 701){
						color = "#4B8A08";
					} else if (millesimi < 801){
						color = "#4B8A08";
					} else if (millesimi < 901){
						color = "#0174DF";
					} else {
						color = "#0404B4";
					}
					
					metaData.style = 'color:' + color;
					
					return voto.get('mnemonico');
				}
				else {
					return '';
				}
			};
			
			this.creaColonna(colonna, newColumn);
			
			this.getJudgmentGridAddPanel().hide();
			this.getJudgmentGrid().show();
			
			this.getJudgmentGridAddFormGiorno().reset();	
		}
		else{
			Ext.Msg.show({
            	title:i18n.teacher_register_error,
            	buttons: Ext.Msg.OK,
            	msg: "Data valutazione obbligatoria",
            	icon: Ext.MessageBox.ERROR
            });
		}
	},
	addJudgmentCancelButtonClick:function ( button, e, eOpts ){
		this.getJudgmentGridAddPanel().hide();
		this.getJudgmentGrid().show();
		this.getJudgmentGridAddFormGiorno().reset();
	},
	onJudgmentGridSelect: function( grid, record, index, eOpts ){
		this.setSelectedRow(index);
	},
	updateSelectionData: function(rowIndex, cellIndex, record){
		this.setSelectedRow(rowIndex);
		this.setSelectedCol(cellIndex);
		this.setAlunno(record.get("alunno"));
		var indexColonna = cellIndex + 1;
//		this.setSelectedRV(record.get("rv_" + indexColonna));
//		this.setSelectedValutazione(record.get("va_" + indexColonna));
		var storeGrigliaValutazioneColonne = this.getStoreGrigliaValutazioneColonne();
		var colonna = storeGrigliaValutazioneColonne.getAt(cellIndex);
		this.setSelectedMetrica(colonna.get('metrica'));
		this.setSelectedData(colonna.get('giorno'));
		this.setSelectedTipoVoto(colonna.get('tipo_voto'));
		this.setSelectedArgomento(colonna.get('argomento'));
	},
	onJudgmentGridCellClick: function( grid, td, cellIndex, record, tr, rowIndex, e, eOpts ){
		this.updateSelectionData(rowIndex, cellIndex, record);
	},
	onJudgmentGridCellKeydown: function ( grid, td, cellIndex, record, tr, rowIndex, e, eOpts ){
		this.updateSelectionData(rowIndex, cellIndex, record);
		if (e.getKey() == Ext.EventObject.ENTER){

			//....
			/*			
			var indexColonna = cellIndex + 1;
			var valutazione = record.get("va_" + indexColonna);
			if (!Ext.isEmpty(valutazione)){
				valutazioniService.valutazioni_sel(valutazione, function(provider, response) {
				   // process response
					if (!Ext.isEmpty(response.result) && response.result.status == 'OK'){
						this.getJudgmentGridEditFormValutazione().setValue(valutazione);
						this.getJudgmentGridEditFormRV().setValue(response.result.rv);
						this.getJudgmentGridEditFormGiudizio().setValue(response.result.giudizio);
						this.getJudgmentGridEditFormPrivata().setValue(response.result.privata);
						this.getJudgmentGridEditFormNota().setValue(response.result.nota);
						
						this.getJudgmentGrid().hide();
						this.getJudgmentGridEditPanel().show();
					}
					else{
						Ext.Msg.show({
		                	title:i18n.teacher_register_error,
		                	buttons: Ext.Msg.OK,
		                	msg: response.result.status,
		                	icon: Ext.MessageBox.ERROR
		                });
					}
				}, this);
				
			}
			*/
		}
	},
	judgmentGridEditConfirmButtonClick: function ( button, e, eOpts ){
	
		var valutazione = this.getJudgmentGridEditFormValutazione().getValue();
		var rv = this.getJudgmentGridEditFormRV().getValue();
		var giudizio = this.getJudgmentGridEditFormGiudizio().getValue();
		var privata = this.getJudgmentGridEditFormPrivata().getValue();
		var nota = this.getJudgmentGridEditFormNota().getValue();
		
		valutazioniService.valutazioni_upd(rv, valutazione, giudizio, privata, nota, function(provider, response) {
			   // process response
				if (!Ext.isEmpty(response.result) && response.result.status == 'OK'){
					
					if (!this.getIsUpdating()){
						this.setIsUpdating(true);
						var judgmentGridStore = this.getJudgmentGrid().getStore();
						var indexRow = this.getEditRow();
						var indexCol = this.getEditCol() + 1;
						
						var record = judgmentGridStore.getAt(indexRow);

						record.set("rv_" + indexCol, response.result.rv);
											
						judgmentGridStore.commitChanges();
						this.setEditRow(null);
						this.setEditCol(null);

						this.setIsUpdating(false);
					}
					
//					this.getJudgmentGrid().hide();
//					this.getJudgmentGridEditPanel().show();
				}
				else{
					Ext.Msg.show({
	                	title:i18n.teacher_register_error,
	                	buttons: Ext.Msg.OK,
	                	msg: response.result.status,
	                	icon: Ext.MessageBox.ERROR
	                });
				}
			}, this);
		
		
		this.getJudgmentGridEditPanel().hide();
		this.getJudgmentGrid().show();
		
	},
	judgmentGridEditCancelButtonClick: function ( button, e, eOpts ){
		this.getJudgmentGridEditPanel().hide();
		this.getJudgmentGrid().show();
		//TODO: clear del form
	},
	onTeacherRegisterTabPanelChange: function ( tabPanel, newCard, oldCard, eOpts ) {
		// do nothing
	},
	onClickAddPersonalNoteButton: function (){
		alert("Inserisci nuova nota");
	},
	onChangeScheduleGridWeek:  function ( combo, newValue, oldValue, eOpts ){
		
	},
	onChangePersonalScheduleGridWeek: function ( combo, newValue, oldValue, eOpts ){
		
	},
	updateJudgmentGridAddFormGiorno: function (){
		var judgmentGridAddFormTipoVoto = this.getJudgmentGridAddFormTipoVoto();
		var judgmentGridAddFormArgomento = this.getJudgmentGridAddFormArgomento();
		var judgmentGridAddFormMetrica = this.getJudgmentGridAddFormMetrica();
		
		var isSelectionValid = judgmentGridAddFormTipoVoto.isValid() && judgmentGridAddFormArgomento.isValid() && judgmentGridAddFormMetrica.isValid();
		var judgmentGridAddFormGiorno = this.getJudgmentGridAddFormGiorno();
		judgmentGridAddFormGiorno.setDisabled(!isSelectionValid);
		if (isSelectionValid){
			var storeGrigliaValutazioneColonne = this.getStoreGrigliaValutazioneColonne();
			var count = storeGrigliaValutazioneColonne.getCount();
			var date = [];
			var tipo_voto = judgmentGridAddFormTipoVoto.getValue();
			var argomento = judgmentGridAddFormArgomento.getValue();
			var metrica = judgmentGridAddFormMetrica.getValue();
			for (var i = 0; i < count; i++){
				var colonna = storeGrigliaValutazioneColonne.getAt(i);
				if (tipo_voto == colonna.get('tipo_voto') && argomento == colonna.get('argomento') && metrica == colonna.get('metrica')){
					date.push(Ext.Date.format(colonna.get('giorno'), "d/m/Y"));
				}
			}
			judgmentGridAddFormGiorno.setMinValue(null);
			judgmentGridAddFormGiorno.setMaxValue(new Date());
			judgmentGridAddFormGiorno.setDisabledDates((date.length > 0) ? date : ["!.*"]);
		}
		else{
			judgmentGridAddFormGiorno.setMinValue(null);
			judgmentGridAddFormGiorno.setMaxValue(new Date());
			judgmentGridAddFormGiorno.setDisabledDates(["!.*"]);
			judgmentGridAddFormGiorno.reset();
		}
	},
	preloadVotiMetrica: function (metrica){
		var voti = this.getVoti();
		var storeVoti = voti.get(metrica);
		if (storeVoti == null){
			storeVoti = Ext.create('Desktop.store.Voti');
			storeVoti.getProxy().isSynchronous = true;
			storeVoti.load({
				params:{
					metrica: metrica
				}
			});
			voti.add(metrica, storeVoti);
		}
	},
	creaColonna: function (colonna, record){
		var voti = this.getVoti();
		colonna.setText(Ext.Date.format(record.get('giorno'), 'D<br/>d-m'));
		
		new Ext.ToolTip({
            id: 'tooltip1-' + colonna.id,
            dismissDelay: 60000,
            target: colonna.id,
            html: "tipo: <b>" + record.get('tipo_voto_descrizione') + "</b><br/>" + 
                  "argomento: <b>"  + record.get('argomento_descrizione') + "</b><br/>" + 
                  "metrica: <b>" + record.get('metrica_descrizione') + "</b>"
		});
		var metrica = record.get('metrica');
		var storeVoti = voti.get(metrica);
		var editor = Ext.create('Ext.form.ComboBox', {
		    store: storeVoti,
		    queryMode: 'local',
		    displayField: 'mnemonico',
		    valueField: 'voto',
		    editable: false,
		    forceSelection: true
		});
		
		colonna.setEditor(editor);
		colonna.setVisible(true);
	},
	onModificaClick: function(data){
		var valutazione = data.val;
		if (!Ext.isEmpty(valutazione)){
			valutazioniService.valutazioni_sel(valutazione, function(provider, response) {
			   // process response
				if (!Ext.isEmpty(response.result) && response.result.status == 'OK'){
					
					this.getJudgmentGridEditFormValutazione().setValue(valutazione);
					this.getJudgmentGridEditFormRV().setValue(response.result.rv);
					this.getJudgmentGridEditFormGiudizio().setValue(response.result.giudizio);
					this.getJudgmentGridEditFormPrivata().setValue(response.result.privata);
					this.getJudgmentGridEditFormNota().setValue(response.result.nota);
					
					this.getJudgmentGrid().hide();
					this.getJudgmentGridEditPanel().show();
				}
				else{
					Ext.Msg.show({
	                	title:i18n.teacher_register_error,
	                	buttons: Ext.Msg.OK,
	                	msg: response.result.status,
	                	icon: Ext.MessageBox.ERROR
	                });
				}
			}, this);
			
		}
	},
	onEliminaClick: function(data){
		var judgmentGridStore = data.store;
		var indexRow = this.getEditRow();
		var indexCol = this.getEditCol() + 1;
		var record = judgmentGridStore.getAt(indexRow);
		var vo = record.get("vo_" + indexCol);
		
		var colonne = this.getStoreGrigliaValutazioneColonne();
		var selectedCol = this.getSelectedCol();
		var colonna = colonne.getAt(selectedCol);
		
		var votiMetrica = this.getVoti().get(colonna.get('metrica'));
		
		var voto_descrizione = votiMetrica.getAt(votiMetrica.findExact('voto', vo)).get('mnemonico');
		
		Ext.Msg.confirm("Cancellazione voto", Ext.String.format("Confermare cancellazione voto {0}", voto_descrizione), function(btn, text){
		    if (btn == 'yes'){
				valutazioniService.valutazioni_del(
						data.rv,  
						data.val,
						function(provider, response) {
					   // process response
						if (!Ext.isEmpty(response.result)){
							if (!response.result.ok){
								//response.result è il messaggio di errore
								Ext.Msg.show({
				                	title:i18n.teacher_register_error,
				                	buttons: Ext.Msg.OK,
				                	msg: Desktop.ux.util.ExceptionDecoder.decode(response.result),
				                	icon: Ext.MessageBox.ERROR
				                });
							}
							else{
								var record = judgmentGridStore.getAt(data.row);
								var indexCol = data.col;
								record.set("rv_" + indexCol, null);
								record.set("va_" + indexCol, null);
								record.set("vo_" + indexCol, null);
								
								judgmentGridStore.commitChanges();
		
							}
						}
					}, this);
		    }
		});
	},
	onToggleShowJudgmentGridDetails: function(item, pressed, eOpts){
		var columns = this.getJudgmentGrid().columns;
		this.getJudgmentGrid().suspendEvents(true);
		columns[0].setVisible(pressed);
		columns[3].setVisible(pressed);
		columns[4].setVisible(pressed);
		columns[5].setVisible(pressed);
		columns[6].setVisible(pressed);
		columns[7].setVisible(pressed);
		columns[8].setVisible(pressed);
		columns[9].setVisible(pressed);
		this.getJudgmentGrid().resumeEvents();
	}
});