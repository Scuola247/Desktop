Ext.define('Desktop.view.module.Institutes', {
	extend: 'Ext.window.Window',
	requires: ['Desktop.view.module.InstitutesGridPanel'],
	controller: 'Desktop.controller.Institutes',

	title: i18n.institutes,
	width: 840,
	height: 560,
	iconCls: 'institutes-icon',
	layout: 'fit',

	initComponent: function() {
		var institutesGrid = Ext.create('Desktop.view.module.InstitutesGridPanel', {
			itemId: 'institutesGrid',
			region:'center'
		});
		var institutesPanel = Ext.create('Ext.panel.Panel', {
			itemId: 'institutesPanel',
			layout: 'border',
			hidden: false,
			items:[
			      {
			    	  region: 'north',
			    	  xtype: 'form',
			    	  layout: 'hbox',
			    	  hidden: true,
			    	  itemId: 'institutesSearchForm',
			    	  fieldDefaults: {
			    		  labelAlign: 'left',
			    		  labelWidth: 100,
			    		  margin: "4 4 4 4"
			    	  },
			    	  items: [{
			    		  itemId:'instituteDescriptionFilter',
			    		  xtype: 'textfield',
			    		  fieldLabel: i18n.institutes_search_desc
			    	  }],
			    	  buttons: ['->', {
			    		  itemId: 'institutesSearchButton',
			    		  text: i18n.institutes_search_button
			    	  }]

			      },
			      institutesGrid
			      ],
			tbar: [
		             {
		            	 text: i18n.institutes_search,
		            	 itemId: 'searchInstituteToggleButton',
		            	 enableToggle: true,
		            	 pressed: false,
		            	 iconCls: 'find-icon'
		             },/*{
		            	 text: i18n.institutes_edit,
		            	 itemId: 'editInstituteToggleButton',
		            	 enableToggle: true,
		            	 pressed: false,
		            	 iconCls: 'pageedit-icon'
		             },*/{
		            	 text: i18n.institutes_add,
		            	 itemId: 'addInstituteButton',
		            	 iconCls: 'add-icon'
		             },{
		            	 text: i18n.institutes_print,
		            	 itemId: 'printInstituteButton',
		            	 iconCls: 'print-icon'
		             }
	             ]


		});
		var createInstitutePanel = Ext.create('Ext.panel.Panel', {
			itemId: 'createInstitutePanel',
			hidden: true,
			items: [
			        {
			        	xtype: 'form',
			        	itemId:'instituteForm',
			        	bodyPadding: '10 10 0 10',
			        	width:500,
			        	//height:130,
			        	border:false,
			        	defaults: {
			        		xtype: 'textfield',
			        		width: 300
			        	},
			        	items: [
			        	        {
			        	        	readOnly:true,
			        	        	xtype:'hidden',
			        	        	name:'rv'
			        	        },
			        	        {
			        	        	readOnly:true,
			        	        	name:'istituto',
			        	        	fieldLabel: i18n.institutes_institute_field,
			        	        	itemId:'idIstitutoInsertField'
			        	        },
			        	        {
			        	        	allowBlank: false,
			        	        	minLength: 1,
			        	        	fieldLabel: i18n.institutes_description,
			        	        	name:'descrizione'
			        	        },
			        	        {
			        	        	allowBlank: false,
			        	        	minLength: 1,
			        	        	fieldLabel: i18n.institutes_meccanografico,
			        	        	name:'codice_meccanografico'
			        	        },
			        	        {
			        	        	allowBlank: false,
			        	        	minLength: 1,
			        	        	fieldLabel: i18n.institutes_mnem,
			        	        	name:'mnemonico'
			        	        	
			        	        },
			        	        {
			        	        	xtype: 'checkbox',
			        	        	cls: 'x-grid-checkheader-editor',
			        	        	fieldLabel: i18n.institutes_example,
			        	        	name:'esempio'
			        	        }
			        	        ],
			        	        api: {
			        	        	submit: 'instituteController.createNewInstitute'
			        	        }
			        },
			        {
			        	xtype: 'form',
			        	fileUpload: true,
			        	itemId:'instituteImageForm',
			        	bodyPadding: '0 10 10 10',
			        	width:500,
			        	//height:350,
			        	border:false,
			        	defaults: {
			        		xtype: 'textfield',
			        		width: 300
			        	},
			        	items: [
			        	        {
			        	        	xtype: 'filefield',
			        	        	fieldLabel: i18n.institutes_logo,
			        	        	name:'instituteLogo',
			        	        	itemId:'instituteLogo',
			        	        	buttonOnly:true,
			        	        	buttonText: '',
			        	        	buttonConfig: {
			        	        		iconCls: 'upload-icon'
			        	        	},
			        	        	listeners:{
			        	        		afterrender:function(cmp){
			        	        			cmp.fileInputEl.set({
			        	        				accept:'image/jpeg' // or w/e type
			        	        			});
			        	        		}
			        	        	}
			        	        },
			        	        {
			        	        	fieldLabel:i18n.institutes_creation_logoName,
			        	        	xtype:'textareafield',
			        	        	readOnly: true,
			        	        	itemId:'institutesLogoName'
			        	        },
			        	        {
			        	        	xtype: 'container',
			        	        	itemId: 'previewContainer',
			        	        	padding: '0 0 0 105',
			        	        	items:[{
				        	        	xtype: 'image',
				        	        	itemId:'instituteLogoPreview',
//				        	        	maxHeight:300,
//				        	        	maxWidth:300,
				        	        	src:''
			        	        	}]
			        	        }
			        	        
			        	        ],
			        	        api: {
			        	        	submit: 'instituteController.uploadInstituteImage'
			        	        }
			        }

			        ],
			        buttons: [{
			        	text: i18n.institutes_creation_form_insert_button,
			        	itemId: 'insertNewInstituteButton',
			        	/*disabled: true*/
			        },
			        {
			        	text: i18n.institutes_creation_form_cancel_button,
			        	itemId: 'closeInsertNewInstituteButton',
			        }
			        ]
		});


		var centerContainer = Ext.create('Ext.container.Container', {
			region: 'center',
			layout: {
				type: 'fit'
			},
			items:[institutesPanel, createInstitutePanel]
		});

		this.items = [centerContainer];

		this.callParent(arguments);

	}

});
