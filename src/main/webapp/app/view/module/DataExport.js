Ext.define('Desktop.view.module.DataExport', {
	extend: 'Ext.window.Window',
	requires: [
	           ],
	controller: 'Desktop.controller.DataExport',
	title: i18n.dataexport,
	width: 400,
	height: 90,
	iconCls: 'dataexport-icon',
	layout: 'fit',
	
	initComponent: function() {
		var me = this;
		me.border = false;
		
		// The data store containing the list of states
		var functions = Ext.create('Ext.data.Store', {
		    fields: ['fun', 'name'],
		    data : [
		        {"fun":"FN1", "name":"Classi alunni indirizzi"}
		    ]
		});
		
		me.items = [{
			xtype:'form',
			itemId:'dataexportForm',
			layout: {
	        	type: 'vbox',
	        	align: 'left'
	        },
			defaults: {
	        	width:370
	        },
			items:[{
				xtype:'combo',
				margin: '4 4 4 4',
				itemId:'toExport',
				fieldLabel: i18n.dataexport_export_selection,
			    store: functions,
			    queryMode: 'local',
			    displayField: 'name',
			    valueField: 'fun'
			}]
		}];
		
		me.buttons = [{
			itemId : 'btnExport',
			text: i18n.dataexport_btn_export
		},{
			itemId : 'btnClose',
		    text : i18n.dataexport_btn_close
		}];
		this.callParent(arguments);
	}

});