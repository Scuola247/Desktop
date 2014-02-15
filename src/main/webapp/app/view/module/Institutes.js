Ext.define('Desktop.view.module.Institutes', {
	extend: 'Ext.window.Window',
	requires: ['Desktop.view.module.InstitutesGridPanel'],
	controller: 'Desktop.controller.Institutes',

	title: i18n.institutes,
	width: 840,
	height: 560,
	iconCls: 'institutes-icon',
	layout: 'border',

	initComponent: function() {
		var institutesGrid = Ext.create('Desktop.view.module.InstitutesGridPanel', {
			itemId: 'institutesGrid',
			region: 'center'
		});
		
		this.tbar = [
		{
            text: i18n.institutes_search,
            itemId: 'searchInstituteToggleButton',
			enableToggle: true,
			pressed: false
        },{
			text: i18n.institutes_edit,
			itemId: 'editInstituteToggleButton',
			enableToggle: true,
			pressed: false
		},{
            text: i18n.institutes_add,
            itemId: 'addInstituteButton',
            iconCls: 'add'
        }];
		this.items = [
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
		              ];

		this.callParent(arguments);

	}

});
