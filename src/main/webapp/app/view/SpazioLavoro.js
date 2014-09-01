Ext.define('Desktop.view.SpazioLavoro', {
	extend: 'Ext.window.Window',
	controller: 'Desktop.controller.SpazioLavoro',
	requires: [
	           'Ext.form.*',
	           'Desktop.model.SpazioLavoro',
	           'Desktop.store.SpaziLavoro',
	           'Desktop.model.Institutes',
	           'Desktop.store.Institutes',
	           'Desktop.model.AnnoScolastico',
	           'Desktop.store.AnniScolastici',
	           'Desktop.model.Materia',
	           'Desktop.store.Materie',
	           'Desktop.model.Classe',
	           'Desktop.store.Classi',
	           'Desktop.model.DocenteIstituto',
	           'Desktop.store.DocentiIstituto',
	           'Desktop.model.FamigliareClasse',
	           'Desktop.store.FamigliariClasse',
	           'Desktop.model.AlunnoClasse',
	           'Desktop.store.AlunniClasse',
	           'Desktop.view.module.SpazioLavoroGridPanel'
	           ],
	layout: 'fit',
	title: i18n.workspace,
	width: 840,
	height: 560,
	modal: true,
	border: false,
	constrain: true,
	icon: app_context_path + '/resources/icons/star_yellow.png',
	closeAction:'hide',

	initComponent: function() {
		var me = this;

		var workspaceGridPanel = Ext.create('Desktop.view.module.SpazioLavoroGridPanel', {
			itemId: 'workspaceGridPanel',
			region:'center'
		});
		
		var workspacePanel = Ext.create('Ext.panel.Panel', {
			itemId: 'workspacePanel',
			layout: 'border',
			hidden: false,
			items:[
			       workspaceGridPanel
			   ],
			tbar: [
		             {
		            	 text: i18n.workspace_add,
		            	 itemId: 'addWorkspeceButton',
		            	 iconCls: 'add-icon'
		             }
	           ]
		});
		
		var workspaceDefinitionForm = Ext.create('Ext.form.Panel', {
			title:i18n.workspace_definition,
			itemId:'workspaceDefinitionForm',
			layout: {
	        	type: 'vbox',
	        	align: 'left'
	        },
	        margin: '2 2 2 2',
			padding: '2 2 2 2',
			defaultType: 'combobox',
	        defaults: {
	        	width:400
	        },
			items:[{
		        	fieldLabel: i18n.workspace_institute,
		        	queryMode: 'local',
		        	allowBlank: false,
		        	forceSelection: true,
		        	editable: false,
			        displayField: 'descrizione',
			        valueField: 'istituto',
		        	itemId: 'istituto',
		        	name: 'istituto'
		        },{
		            fieldLabel: i18n.workspace_year,
		            queryMode: 'local',
		            allowBlank: false,
		            forceSelection: true,
		            editable: false,
		            displayField: 'descrizione',
			        valueField: 'anno_scolastico',
		            itemId: 'anno_scolastico',
		            name: 'anno_scolastico'
		        },{
		        	fieldLabel: i18n.workspace_class,
		        	queryMode: 'local',
		        	//allowBlank: false,
		        	//forceSelection: true,
		        	editable: false,
		        	displayField: 'descrizione',
			        valueField: 'classe',
		        	itemId: 'classe',
		        	name:'classe'
		        },{
		            fieldLabel: i18n.workspace_subject,
		            queryMode: 'local',
		            //allowBlank: false,
		            //forceSelection: true,
		            editable: false,
		            displayField: 'descrizione',
			        valueField: 'materia',
		            itemId: 'materia',
		            name: 'materia'
		        },{
		        	fieldLabel: i18n.workspace_teacher,
		            queryMode: 'local',
		            //allowBlank: false,
		            //forceSelection: true,
		            editable: false,
		            listConfig: {
		                getInnerTpl: function() {
		                    var tpl = '<div>'+
		                              '<tpl if="foto_miniatura != \'\'"><img src="data:image/png;base64,{foto_miniatura}" style="width:11px; height:15px; align:left;"></tpl>&nbsp;&nbsp;'+
		                              '{cognome} {nome}</div>';
		                    return tpl;
		                }
		            },
		            displayField: 'nome_cognome',
			        valueField: 'docente',
		            itemId: 'docente',
		            name: 'docente'
		        },{
		        	fieldLabel: i18n.workspace_family,
		            queryMode: 'local',
		            //allowBlank: false,
		            //forceSelection: true,
		            editable: false,
		            listConfig: {
		                getInnerTpl: function() {
		                    var tpl = '<div>'+
		                              '<tpl if="foto_miniatura != \'\'"><img src="data:image/png;base64,{foto_miniatura}" style="width:11px; height:15px; align:left;"></tpl>&nbsp;&nbsp;'+
		                              '{cognome} {nome}</div>';
		                    return tpl;
		                }
		            },
		            displayField: 'nome_cognome',
			        valueField: 'famigliare',
		            itemId: 'famigliare',
		            name: 'famigliare'
		        },{
		        	fieldLabel: i18n.workspace_student,
		            queryMode: 'local',
		            //allowBlank: false,
		            //forceSelection: true,
		            editable: false,
		            listConfig: {
		                getInnerTpl: function() {
		                    var tpl = '<div>'+
		                              '<tpl if="foto_miniatura != \'\'"><img src="data:image/png;base64,{foto_miniatura}" style="width:11px; height:15px; align:left;"></tpl>&nbsp;&nbsp;'+
		                              '{cognome} {nome}</div>';
		                    return tpl;
		                }
		            },
		            displayField: 'nome_cognome',
			        valueField: 'alunno',
		            itemId: 'alunno',
		            name: 'alunno'
		        },{
		        	xtype:'textfield',
		        	fieldLabel: i18n.workspace_bookmark_name,
		        	allowBlank: false,
		        	itemId:'nomePerPreferito',
		        	name: 'nomePerPreferito',
	        		maxLength:1000
		        }
			],
			buttons: [
				{
					width: 120,
					itemId: 'cancelAddWorkspaceToBookmarksButton',
					text: i18n.workspace_cancel_add_to_bookmarks
				},
				{
					width: 120,
					itemId: 'addWorkspaceToBookmarksButton',
					text: i18n.workspace_add_to_bookmarks
				},
				{
					width: 120,
					itemId: 'applyWorkspaceButton',
					text: i18n.workspace_apply
				}
			]
		});
		
		
		
		
		var centerContainer = Ext.create('Ext.container.Container', {
			region: 'center',
			layout: {
				type: 'fit'
			},
			items:[workspacePanel, workspaceDefinitionForm]
		});

		this.items = [centerContainer];
		
		me.callParent(arguments);
	}
});
