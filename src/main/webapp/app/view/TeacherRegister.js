Ext.define('Desktop.view.TeacherRegister', {
	extend: 'Ext.window.Window',
	requires: [
	           'Ext.tab.Panel',
	           'Ext.grid.*',
	           'Ext.selection.CellModel',
	           'Ext.ux.grid.FiltersFeature',
	           'Desktop.model.GrigliaValutazioneColonna',
	           'Desktop.store.GrigliaValutazioneColonne',
	           'Desktop.model.GrigliaValutazioneRiga',
	           'Desktop.store.GrigliaValutazioneRighe',
	           'Desktop.store.Voti',
	           'Desktop.model.Voto',
	           'Desktop.model.AlunnoEx',
	           'Desktop.store.AlunniEx',
	           'Desktop.model.FirmaClasseDocente',
	           'Desktop.store.FirmeClasseDocente',
	           'Desktop.model.LezioneDocenteClasseMateria',
	           'Desktop.store.LezioniDocenteClasseMateria',
	           'Desktop.model.TipoVoto',
	           'Desktop.store.TipiVoto',
	           'Desktop.model.Argomento',
	           'Desktop.store.Argomenti',
	           'Desktop.model.Metrica',
	           'Desktop.store.Metriche'
	           ],
	controller: 'Desktop.controller.TeacherRegister',
	title: i18n.teacher_register_title,
	width: 840,
	height: 560,
	iconCls: 'teacher_register-icon',
	layout: 'fit',
	
	initComponent: function() {
		var me = this;
		me.border = false;
		
		var grigliaValutazioneRigheStore = Ext.create('Desktop.store.GrigliaValutazioneRighe');
		var alunniEXStore = Ext.create('Desktop.store.AlunniEx');
		var firmeClasseDocenteStore = Ext.create('Desktop.store.FirmeClasseDocente');
		var lezioniDocenteClasseMateriaStore = Ext.create('Desktop.store.LezioniDocenteClasseMateria');
		
		var tipiVotoStore = Ext.create('Desktop.store.TipiVoto');
		var argomentiStore = Ext.create('Desktop.store.Argomenti');
		var metricheStore = Ext.create('Desktop.store.Metriche');
		
		var judgmentGridEditor = Ext.create('Ext.grid.plugin.CellEditing',{clicksToEdit:1});
		//filtri
	    // configure whether filter query is encoded or not (initially)
	    var judgmentGridFiltersEncode = false;
	    
	    // configure whether filtering is performed locally or remotely (initially)
	    var judgmentGridFiltersLocal = true;
		
		var judgmentGridFilters = {
		        ftype: 'filters',
		        // encode and local configuration options defined previously for easier reuse
		        encode: judgmentGridFiltersEncode, // json encode the filter query
		        local: judgmentGridFiltersLocal,   // defaults to false (remote filtering)

		        // Filters are most naturally placed in the column definition, but can also be
		        // added here.
		        filters: [{
		        	type:'list',
		        	dataIndex: 'cognome'
		        },{
		        	type:'list',
		        	dataIndex: 'nome'
		        },{
		        	type:'list',
		        	dataIndex: 'assenze'
		        },{
		        	type:'list',
		        	dataIndex: 'ritardi'
		        },{
		        	type:'list',
		        	dataIndex: 'uscite'
		        },{
		        	type:'list',
		        	dataIndex: 'fuori_classe'
		        },{
		        	type:'list',
		        	dataIndex: 'note'
		        },{
		        	type:'list',
		        	dataIndex: 'mancanze'
		        },{
		        	type:'list',
		        	dataIndex: 'condotta'
		        }]
		    };
		var judgmentGridColumns = [{
			text:i18n.teacher_register_judgment_photo,
			lockable : false,
			sealedColumns:true,
			hideable:false,
			resizable: false,
			sortable: false,
			locked : true,
			width: 48,
			dataIndex: 'alunno',
			align: 'center',
			renderer: function(value, metaData, record, rowIndex, colIndex, store) {
				return '<img src="' + app_context_path + "/images/person/" + value + '" width="34px"/>';
			}
		},{
			text:i18n.teacher_register_judgment_surname,
			hideable:false,
			lockable : false,
			sealedColumns:true,
			locked : true,
			dataIndex: 'cognome',
			width:120
		},{
			text:'Nome',
			hideable:false,
			lockable : false,
			sealedColumns:true,
			locked : true,
			dataIndex: 'nome',
			width:120
		},{
			text:'A',
			hideable:false,
			resizable: false,
			lockable : false,
			locked : true,
			dataIndex: 'assenze',
			align:'center',
			tooltip: 'Assenze',
			width:35
		},{
			text:'R',
			hideable:false,
			resizable: false,
			lockable : false,
			locked : true,
			dataIndex: 'ritardi',
			align:'center',
			tooltip: 'Ritardi',
			width:35
		},{
			text:'U',
			hideable:false,
			resizable: false,
			lockable : false,
			locked : true,
			dataIndex: 'uscite',
			align:'center',
			tooltip: 'Uscite',
			width:35
		},{
			text:'F',
			hideable:false,
			resizable: false,
			lockable : false,
			locked : true,
			dataIndex: 'fuori_classe',
			align:'center',
			tooltip: 'Fuori classe',
			width:35
		},{
			text:'N',
			hideable:false,
			resizable: false,
			lockable : false,
			locked : true,
			dataIndex: 'note',
			align:'center',
			tooltip: 'Note disciplinari personali',
			width:35
		},{
			text:'M',
			hideable:false,
			resizable: false,
			lockable : false,
			locked : true,
			dataIndex: 'mancanze',
			align:'center',
			tooltip: 'Mancanze didattiche',
			width:35
		},{
			text:'C',
			hideable:false,
			resizable: false,
			lockable : false,
			locked : true,
			dataIndex: 'condotta',
			align:'center',
			tooltip: 'Voto di condotta',
			width:35
		}];
		
		for (var i = 1; i <= 200; i++){
			judgmentGridColumns.push({
				text:'',
				dataIndex:'vo_' + i,
				width:40,
				align:'center',
				hideable:false,
				lockable:false,
				hidden: true,
				tdCls: 'judgmentGridColumn'
			});
		}
	
		
		
		
		var judgmentContainer = Ext.create('Ext.panel.Panel', {
			title:i18n.teacher_register_judgment,
			border:false,
			header:false,
			layout: {
				type: 'fit'
			},
			items:[{
				//title:i18n.teacher_register_judgment,
				xtype:'gridpanel',
				itemId:'judgmentGrid',
				cls:'judgmentGrid',
				store: grigliaValutazioneRigheStore,
				columnLines:true,
				enableColumnMove:false,
				columns:judgmentGridColumns,
				features:[judgmentGridFilters],
				plugins:[judgmentGridEditor],
				tbar: [
				       {
				    	   xtype: 'button', 
				    	   text: i18n.teacher_register_judgment_add,
				    	   itemId: 'addJudgmentButton',
				    	   iconCls: 'add-icon'
				       }
				]
			},{
				xtype:'panel',
				itemId:'judgmentGridAddPanel',
				hidden: true,
				items:[{
					xtype: 'form',
					itemId:'judgmentGridAddForm',
					bodyPadding: '10 10 0 10',
					border:false,
					defaults: {
		        		xtype: 'combobox',
		        		width: 400
		        	},
		        	items: [{
		        		itemId: 'judgmentGridAddFormTipoVoto',
		        		fieldLabel:'Tipo voto',
		        		name:'tipo_voto',
		        		editable:false,
		        		queryMode: 'local',
		        		displayField: 'descrizione',
		        		valueField:'tipo_voto',
		        		store:tipiVotoStore,
		        		allowBlank: false
		        	},{
		        		itemId: 'judgmentGridAddFormArgomento',
		        		fieldLabel:'Argomento',
		        		name:'argomento',
		        		editable:false,
		        		queryMode: 'local',
		        		displayField: 'descrizione',
		        		valueField:'argomento',
		        		store:argomentiStore,
		        		allowBlank: false
		        	},{
		        		itemId: 'judgmentGridAddFormMetrica',
		        		fieldLabel:'Metrica',
		        		name:'metrica',
		        		editable:false,
		        		queryMode: 'local',
		        		displayField: 'descrizione',
		        		valueField:'metrica',
		        		store:metricheStore,
		        		allowBlank: false
		        	},{
		        		xtype: 'datefield',
		        		itemId: 'judgmentGridAddFormGiorno',
		        		fieldLabel:'Giorno',
		        		name:'giorno',
		        		disabledDays:  [0],
		        		allowBlank: false,
		        		maxValue: new Date()
		        	}
		        	]
				}],
	        	buttons: [{
	        		text:'Inserisci',
	        		itemId: 'addJudgmentConfirmButton'
	        	},{
	        		text:'Annulla',
	        		itemId: 'addJudgmentCancelButton'
	        	}]
			},{
				xtype:'panel',
				itemId:'judgmentGridEditPanel',
				hidden: true,
				items:[{
					xtype: 'form',
					itemId:'judgmentGridEditForm',
					bodyPadding: '10 10 0 10',
					border:false,
					defaults: {
		        		xtype: 'combobox',
		        		width: 400
		        	},
		        	items: [{
						xtype: 'hidden',
						itemId: 'judgmentGridEditFormValutazione'
					},{
		        		xtype: 'hidden',
		        		itemId: 'judgmentGridEditFormRV'
		        	},{
		        		xtype: 'textfield',
		        		fieldLabel:'Giudizio',
		        		itemId: 'judgmentGridEditFormGiudizio'
		        	},{
		        		xtype: 'checkbox',
		        		fieldLabel:'Privato',
		        		itemId: 'judgmentGridEditFormPrivato'
		        	},{
		        		xtype: 'checkbox',
		        		fieldLabel:'Nota',
		        		itemId: 'judgmentGridEditFormNota'
		        	}
		        	]
				}],
				buttons: [{
	        		text:'Inserisci',
	        		itemId: 'judgmentGridEditConfirmButton'
	        	},{
	        		text:'Annulla',
	        		itemId: 'judgmentGridEditCancelButton'
	        	}]
			}]
		});
		
		
		
		
		me.items = [{
			xtype:'tabpanel',
			itemId:'teacherRegisterTabPanel',
			items:[judgmentContainer,{
				//studenti
				title:i18n.teacher_register_student,
				xtype:'gridpanel',
				itemId:'studentsGrid',
				store: alunniEXStore,
				columns: [
					{
						header: i18n.teacher_register_student_photo,
						hideable:false,
						width: 40,
						resizable: false,
						dataIndex: 'foto_miniatura',
						sortable: false,
						align: 'center',
						renderer: function(value, metaData, record, rowIndex, colIndex, store) {
							return '<img src="data:image/png;base64,' + value + '" width="30px" height=40px/>';
						}
					},{
						header: i18n.teacher_register_student_surname,
						hideable:false,
						dataIndex: 'cognome',
						width:120
					},{
						header: i18n.teacher_register_student_name,
						hideable:false,
						dataIndex: 'nome',
						width:120
					},{
						header: i18n.teacher_register_student_sex,
						hideable:false,
						dataIndex: 'sesso',
						width:45,
						align:'center'
					},{
						xtype:'datecolumn',
						format:'d-m-Y',
						header: i18n.teacher_register_student_birth_date,
						hideable:false,
						dataIndex: 'nato',
						width:80
					},{
						header: i18n.teacher_register_student_birth_city,
						hideable:false,
						dataIndex: 'comune_nascita_descrizione',
						width:150
					},{
						header: i18n.teacher_register_student_cf,
						hideable:false,
						dataIndex: 'codice_fiscale',
						width:150
					},{
						header: i18n.teacher_register_student_absence,
						hideable:false,
						dataIndex: 'assenze',
						width:60,
						align:'center'
					},{
						header: i18n.teacher_register_student_not_justified_absence,
						hideable:false,
						dataIndex: 'assenze_non_giustificate',
						width:130,
						align:'center'
					},{
						header: i18n.teacher_register_student_delay,
						hideable:false,
						dataIndex: 'ritardi',
						width:60,
						align:'center'
					},{
						header: i18n.teacher_register_student_not_justified_delay,
						hideable:false,
						dataIndex: 'ritardi_non_giustificati',
						width:150,
						align:'center'
					},{
						header: i18n.teacher_register_student_exit,
						hideable:false,
						dataIndex: 'uscite',
						width:60,
						align:'center'
					},{
						header: i18n.teacher_register_student_not_justified_exit,
						hideable:false,
						dataIndex: 'uscite_non_giustificate',
						width:150,
						align:'center'
					},{
						header: i18n.teacher_register_student_outside_class,
						hideable:false,
						dataIndex: 'fuori_classi',
						width:90,
						align:'center'
					},{
						header: i18n.teacher_register_student_note,
						hideable:false,
						dataIndex: 'note',
						width:60,
						align:'center'
					}
				]
			},{
				//firme
				title:i18n.teacher_register_signatures,
				xtype:'gridpanel',
				itemId:'signaturesGrid',
				store: firmeClasseDocenteStore,
				columns: [
					{
						xtype:'datecolumn',
						format:'l d F Y',
						align:'right',
						header: i18n.teacher_register_signatures_data,
						hideable:false,
						dataIndex: 'giorno',
						width: 170
					},{
						xtype:'datecolumn',
						format:'H:i',
						header: i18n.teacher_register_signatures_time,
						hideable:false,
						dataIndex: 'ora',
						flex: 1
					}
				]
			},{
				//lezioni
				title:i18n.teacher_register_lessons,
				xtype:'gridpanel',
				itemId:'lessonsGrid',
				store: lezioniDocenteClasseMateriaStore,
				columns: [
				    {
						xtype:'datecolumn',
						format:'l d F Y',
						align:'right',
						header: i18n.teacher_register_lessons_data,
						hideable:false,
						dataIndex: 'giorno',
						width:170
					},{
						xtype:'datecolumn',
						format:'H:i',
						header: i18n.teacher_register_lessons_period_start,
						hideable:false,
						dataIndex: 'dalle',
						width:45
					},{
						xtype:'datecolumn',
						format:'H:i',
						header: i18n.teacher_register_lessons_period_end,
						hideable:false,
						dataIndex: 'alle',
						width:45
					},{
				    	xtype: 'checkcolumn',
				    	header: i18n.teacher_register_lessons_substitution,
				    	hideable:false,
				    	dataIndex: 'supplenza',
				    	disabled:true,
				    	width:70
				    },{
						header: i18n.teacher_register_lessons_desc,
						hideable:false,
						dataIndex: 'descrizione',
						flex: 1
					}
				]
			},{
				//note
				title:i18n.teacher_register_notes,
				xtype:'gridpanel',
				itemId:'notesGrid',
				columns: [
					{
						xtype:'datecolumn',
						format:'d-m-Y',
						header: i18n.teacher_register_notes_period_data,
						hideable:false,
						dataIndex: 'data'
					},{
						xtype:'datecolumn',
						format:'H:i',
						header: i18n.teacher_register_notes_period_start,
						hideable:false,
						dataIndex: 'dalle',
						width:45
					},{
						xtype:'datecolumn',
						format:'H:i',
						header: i18n.teacher_register_notes_period_end,
						hideable:false,
						dataIndex: 'alle',
						width:45
					},{
//						xtype: 'templatecolumn',
						header: i18n.teacher_register_notes_student,
						hideable:false,
						dataIndex: 'alunno'
							//tpl: '{firstname} {lastname}'
					},{
						xtype: 'checkcolumn',
						header: i18n.teacher_register_notes_disciplinary,
						hideable:false,
						disabled:true,
						dataIndex: 'disciplinare'
					},{
						xtype: 'checkcolumn',
						header: i18n.teacher_register_notes_private,
						hideable:false,
						disabled:true,
						dataIndex: 'privata'
					},{
						header: i18n.teacher_register_notes_note,
						hideable:false,
						dataIndex: 'nota',
						flex: 1
					}
				]
			},{
				//note personali
				title:i18n.teacher_register_personal_notes,
				xtype:'gridpanel',
				itemId:'personalNotesGrid',
				tbar: [
				       {
				    	   xtype: 'button', 
				    	   text: i18n.teacher_register_personal_notes_add,
				    	   itemId: 'addPersonalNoteButton',
				    	   iconCls: 'add-icon'
				       }
				],
				columns: [
					{
						header: i18n.teacher_register_personal_notes_period_data,
						hideable:false,
						dataIndex: 'data'
					},{
						xtype:'datecolumn',
						format:'H:i',
						header: i18n.teacher_register_personal_notes_period_start,
						hideable:false,
						dataIndex: 'dalle',
						width:45
					},{
						xtype:'datecolumn',
						format:'H:i',
						header: i18n.teacher_register_personal_notes_period_end,
						hideable:false,
						dataIndex: 'alle',
						width:45
					},{
						header: i18n.teacher_register_personal_notes_student,
						hideable:false,
						dataIndex: 'alunno'
					},{
						xtype: 'checkcolumn',
						header: i18n.teacher_register_personal_notes_disciplinary,
						hideable:false,
						disabled:true,
						dataIndex: 'disciplinare'
					},{
						xtype: 'checkcolumn',
						header: i18n.teacher_register_personal_notes_private,
						hideable:false,
						disabled:true,
						dataIndex: 'privata'
					},{
						header: i18n.teacher_register_personal_notes_note,
						hideable:false,
						dataIndex: 'nota',
						flex: 1
					}
				]
			},{
				//orario
				//TODO: tipo Data view con immagine e due descrizioni
				title:i18n.teacher_register_schedule,
				xtype:'gridpanel',
				itemId:'scheduleGrid',
				tbar: [
				       {
				    	   xtype: 'combobox',
				    	   fieldLabel: i18n.teacher_register_schedule_week,
				    	   itemId: 'scheduleGridWeek'
				       }
				],
				columns: [
					{
						header: i18n.teacher_register_schedule_start,
						hideable:false,
						dataIndex: 'periodo_dalle'
					},{
						header: i18n.teacher_register_schedule_end,
						hideable:false,
						dataIndex: 'periodo_alle'
					},{
						header: i18n.teacher_register_schedule_simultaneous,
						hideable:false,
						dataIndex: 'compresenza'
					},{
						header: i18n.teacher_register_schedule_monday,
						hideable:false,
						dataIndex: 'lun'
					},{
						header: i18n.teacher_register_schedule_tuesday,
						hideable:false,
						dataIndex: 'mar'
					},{
						header: i18n.teacher_register_schedule_wednesday,
						hideable:false,
						dataIndex: 'mer'
					},{
						header: i18n.teacher_register_schedule_thursday,
						hideable:false,
						dataIndex: 'gio'
					},{
						header: i18n.teacher_register_schedule_friday,
						hideable:false,
						dataIndex: 'ven'
					},{
						header: i18n.teacher_register_schedule_saturday,
						hideable:false,
						dataIndex: 'sab'
					}
				]
			},{
				//orario personale
				//TODO: solo descrizione con sfondo verde nelle celle valorizzate
				title:i18n.teacher_register_personal_schedule,
				xtype:'gridpanel',
				itemId:'personalScheduleGrid',
				tbar: [
				       {
				    	   xtype: 'combobox',
				    	   fieldLabel: i18n.teacher_register_personal_schedule_week,
				    	   itemId: 'personalScheduleGridWeek'
				       }
				],
				columns: [
					{
						header: i18n.teacher_register_personal_schedule_start,
						hideable:false,
						dataIndex: 'periodo_dalle'
					},{
						header: i18n.teacher_register_personal_schedule_end,
						hideable:false,
						dataIndex: 'periodo_alle'
					},{
						header: i18n.teacher_register_personal_schedule_simultaneous,
						hideable:false,
						dataIndex: 'compresenza'
					},{
						header: i18n.teacher_register_personal_schedule_monday,
						hideable:false,
						dataIndex: 'lun'
					},{
						header: i18n.teacher_register_personal_schedule_tuesday,
						hideable:false,
						dataIndex: 'mar'
					},{
						header: i18n.teacher_register_personal_schedule_wednesday,
						hideable:false,
						dataIndex: 'mer'
					},{
						header: i18n.teacher_register_personal_schedule_thursday,
						hideable:false,
						dataIndex: 'gio'
					},{
						header: i18n.teacher_register_personal_schedule_friday,
						hideable:false,
						dataIndex: 'ven'
					},{
						header: i18n.teacher_register_personal_schedule_saturday,
						hideable:false,
						dataIndex: 'sab'
					}
				]
			},{
				//statistiche
				title:i18n.teacher_register_stats
			}]
		}];
		
		
		this.callParent(arguments);
	}

});