Ext.define('Desktop.view.module.ClassRegister', {
	extend: 'Ext.window.Window',
	requires: [
	           'Ext.tab.Panel',
	           'Ext.grid.*',
	           'Desktop.model.AlunnoEx',
	           'Desktop.store.AlunniEx',
	           'Desktop.model.FirmaClasseDocente',
	           'Desktop.store.FirmeClasseDocente',
	           'Desktop.model.LezioneDocenteClasseMateria',
	           'Desktop.store.LezioniDocenteClasseMateria'
	           ],
	controller: 'Desktop.controller.ClassRegister',
	title: i18n.class_register_title,
	width: 840,
	height: 560,
	iconCls: 'class_register-icon',
	layout: 'fit',
	
	initComponent: function() {
		var me = this;
		me.border = false;
		
		var alunniEXStore = Ext.create('Desktop.store.AlunniEx');
		var firmeClasseDocenteStore = Ext.create('Desktop.store.FirmeClasseDocente');
		var lezioniDocenteClasseMateriaStore = Ext.create('Desktop.store.LezioniDocenteClasseMateria');
		
		me.tbar = [{
			text: i18n.class_register_print,
			itemId: 'printRegisterButton',
			iconCls: 'print-icon'
		}];
		
		me.items = [{
			xtype:'tabpanel',
			itemId:'classRegisterTabPanel',
			items:[{
				//studenti
				title:i18n.class_register_student,
				xtype:'gridpanel',
				itemId:'studentsGrid',
				store: alunniEXStore,
				columns: [
					{
						header: i18n.class_register_student_photo,
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
						header: i18n.class_register_student_surname,
						hideable:false,
						dataIndex: 'cognome',
						width:120
					},{
						header: i18n.class_register_student_name,
						hideable:false,
						dataIndex: 'nome',
						width:120
					},{
						header: i18n.class_register_student_sex,
						hideable:false,
						dataIndex: 'sesso',
						width:45,
						align:'center'
					},{
						xtype:'datecolumn',
						format:'d-m-Y',
						header: i18n.class_register_student_birth_date,
						hideable:false,
						dataIndex: 'nato',
						width:80
					},{
						header: i18n.class_register_student_birth_city,
						hideable:false,
						dataIndex: 'comune_nascita_descrizione',
						width:150
					},{
						header: i18n.class_register_student_cf,
						hideable:false,
						dataIndex: 'codice_fiscale',
						width:150
					},{
						header: i18n.class_register_student_absence,
						hideable:false,
						dataIndex: 'assenze',
						width:60,
						align:'center'
					},{
						header: i18n.class_register_student_not_justified_absence,
						hideable:false,
						dataIndex: 'assenze_non_giustificate',
						width:130,
						align:'center'
					},{
						header: i18n.class_register_student_delay,
						hideable:false,
						dataIndex: 'ritardi',
						width:60,
						align:'center'
					},{
						header: i18n.class_register_student_not_justified_delay,
						hideable:false,
						dataIndex: 'ritardi_non_giustificati',
						width:150,
						align:'center'
					},{
						header: i18n.class_register_student_exit,
						hideable:false,
						dataIndex: 'uscite',
						width:60,
						align:'center'
					},{
						header: i18n.class_register_student_not_justified_exit,
						hideable:false,
						dataIndex: 'uscite_non_giustificate',
						width:150,
						align:'center'
					},{
						header: i18n.class_register_student_outside_class,
						hideable:false,
						dataIndex: 'fuori_classi',
						width:90,
						align:'center'
					},{
						header: i18n.class_register_student_note,
						hideable:false,
						dataIndex: 'note',
						width:60,
						align:'center'
					}
				]
			},{
				//docenti
				title:i18n.class_register_teachers,
				xtype:'gridpanel',
				itemId:'teachersGrid',
				columns: []
			},{
				//firme
				title:i18n.class_register_signatures,
				xtype:'gridpanel',
				itemId:'signaturesGrid',
				store: firmeClasseDocenteStore,
				columns: [
					{
						xtype:'datecolumn',
						format:'l d F Y',
						align:'right',
						header: i18n.class_register_signatures_data,
						hideable:false,
						dataIndex: 'giorno',
						width: 170
					},{
						xtype:'datecolumn',
						format:'H:i',
						header: i18n.class_register_signatures_time,
						hideable:false,
						dataIndex: 'ora',
						flex: 1
					}
				]
			},{
				//lezioni
				title:i18n.class_register_lessons,
				xtype:'gridpanel',
				itemId:'lessonsGrid',
				store: lezioniDocenteClasseMateriaStore,
				columns: [
				    {
						xtype:'datecolumn',
						format:'l d F Y',
						align:'right',
						header: i18n.class_register_lessons_data,
						hideable:false,
						dataIndex: 'giorno',
						width:170
					},{
						xtype:'datecolumn',
						format:'H:i',
						header: i18n.class_register_lessons_period_start,
						hideable:false,
						dataIndex: 'dalle',
						width:45
					},{
						xtype:'datecolumn',
						format:'H:i',
						header: i18n.class_register_lessons_period_end,
						hideable:false,
						dataIndex: 'alle',
						width:45
					},{
				    	xtype: 'checkcolumn',
				    	header: i18n.class_register_lessons_substitution,
				    	hideable:false,
				    	dataIndex: 'supplenza',
				    	disabled:true,
				    	width:70
				    },{
						header: i18n.class_register_lessons_desc,
						hideable:false,
						dataIndex: 'descrizione',
						flex: 1
					}
				]
			},{
				//note
				title:i18n.class_register_notes,
				xtype:'gridpanel',
				itemId:'notesGrid',
				columns: [
					{
						xtype:'datecolumn',
						format:'d-m-Y',
						header: i18n.class_register_notes_period_data,
						hideable:false,
						dataIndex: 'data'
					},{
						xtype:'datecolumn',
						format:'H:i',
						header: i18n.class_register_notes_period_start,
						hideable:false,
						dataIndex: 'dalle',
						width:45
					},{
						xtype:'datecolumn',
						format:'H:i',
						header: i18n.class_register_notes_period_end,
						hideable:false,
						dataIndex: 'alle',
						width:45
					},{
//						xtype: 'templatecolumn',
						header: i18n.class_register_notes_student,
						hideable:false,
						dataIndex: 'alunno'
							//tpl: '{firstname} {lastname}'
					},{
						xtype: 'checkcolumn',
						header: i18n.class_register_notes_disciplinary,
						hideable:false,
						disabled:true,
						dataIndex: 'disciplinare'
					},{
						xtype: 'checkcolumn',
						header: i18n.class_register_notes_private,
						hideable:false,
						disabled:true,
						dataIndex: 'privata'
					},{
						header: i18n.class_register_notes_note,
						hideable:false,
						dataIndex: 'nota',
						flex: 1
					}
				]
			},{
				//orario
				//TODO: tipo Data view con immagine e due descrizioni
				title:i18n.class_register_schedule,
				xtype:'gridpanel',
				itemId:'scheduleGrid',
				tbar: [
				       {
				    	   xtype: 'combobox',
				    	   fieldLabel: i18n.class_register_schedule_week,
				    	   itemId: 'scheduleGridWeek'
				       }
				],
				columns: [
					{
						header: i18n.class_register_schedule_start,
						hideable:false,
						dataIndex: 'periodo_dalle'
					},{
						header: i18n.class_register_schedule_end,
						hideable:false,
						dataIndex: 'periodo_alle'
					},{
						header: i18n.class_register_schedule_simultaneous,
						hideable:false,
						dataIndex: 'compresenza'
					},{
						header: i18n.class_register_schedule_monday,
						hideable:false,
						dataIndex: 'lun'
					},{
						header: i18n.class_register_schedule_tuesday,
						hideable:false,
						dataIndex: 'mar'
					},{
						header: i18n.class_register_schedule_wednesday,
						hideable:false,
						dataIndex: 'mer'
					},{
						header: i18n.class_register_schedule_thursday,
						hideable:false,
						dataIndex: 'gio'
					},{
						header: i18n.class_register_schedule_friday,
						hideable:false,
						dataIndex: 'ven'
					},{
						header: i18n.class_register_schedule_saturday,
						hideable:false,
						dataIndex: 'sab'
					}
				]
			},{
				//orario dei professori
				//TODO: solo descrizione con sfondo verde nelle celle valorizzate
				title:i18n.class_register_teachers_schedule,
				xtype:'gridpanel',
				itemId:'teachersScheduleGrid',
				tbar: [
				       {
				    	   xtype: 'combobox',
				    	   fieldLabel: i18n.class_register_teachers_schedule_week,
				    	   itemId: 'teachersScheduleGridWeek'
				       }
				],
				columns: [
					{
						header: i18n.class_register_teachers_schedule_start,
						hideable:false,
						dataIndex: 'periodo_dalle'
					},{
						header: i18n.class_register_teachers_schedule_end,
						hideable:false,
						dataIndex: 'periodo_alle'
					},{
						header: i18n.class_register_teachers_schedule_simultaneous,
						hideable:false,
						dataIndex: 'compresenza'
					},{
						header: i18n.class_register_teachers_schedule_monday,
						hideable:false,
						dataIndex: 'lun'
					},{
						header: i18n.class_register_teachers_schedule_tuesday,
						hideable:false,
						dataIndex: 'mar'
					},{
						header: i18n.class_register_teachers_schedule_wednesday,
						hideable:false,
						dataIndex: 'mer'
					},{
						header: i18n.class_register_teachers_schedule_thursday,
						hideable:false,
						dataIndex: 'gio'
					},{
						header: i18n.class_register_teachers_schedule_friday,
						hideable:false,
						dataIndex: 'ven'
					},{
						header: i18n.class_register_teachers_schedule_saturday,
						hideable:false,
						dataIndex: 'sab'
					}
				]
			},{
				//statistiche
				title:i18n.class_register_stats
			}]
		}];
		
		
		this.callParent(arguments);
	}

});