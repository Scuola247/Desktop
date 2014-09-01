Ext.define('Desktop.view.module.SpazioLavoroGridPanel', {
    extend: 'Ext.grid.Panel',
    
    requires: [
        'Ext.selection.CellModel',
        'Ext.grid.*',
        'Ext.data.*',
        'Ext.util.*',
        'Ext.form.*',
        'Desktop.model.SpazioLavoro',
        'Desktop.store.SpaziLavoro'
    ],
   
    initComponent: function() {
        var store = Ext.create('Desktop.store.SpaziLavoro');
        
        var columns = [{
        		header: i18n.workspace_description,
        		dataIndex: 'descrizione',
        		width: 795
            },{
                xtype: 'actioncolumn',
                itemId: 'workspaceActionColumn',
                width: 22,
                sortable: false,
                menuDisabled: true,
                items: [{
                	id: 'deleteSpazioLavoro', 
                	iconCls: 'remove',
                    tooltip: i18n.workspace_delete,
                    scope: this,
                    /*handler: this.onRemoveClick*/
                }]
            }
	    	
        ];
        Ext.apply(this, {
//        	width: 680,
//            height: 350,
            store: store,
            columns: columns,
            selModel: {
            	selType: 'rowmodel'
            }
        });
        
        this.callParent();
    },

    /*
    onRemoveClick: function(grid, rowIndex){
    	var selectedRecord = grid.getStore().getAt(rowIndex);
    	var msg = Ext.String.format(i18n.institutes_confirm_delete_msg, selectedRecord.get('istituto'), selectedRecord.get('mnemonico'));
    	Ext.Msg.confirm(i18n.institutes_confirm_delete_title, msg, function(btn, text){
    	    if (btn == 'yes'){
    	    	var sm = this.getSelectionModel();
    	    	var currentSelection = sm.getSelection();
            	this.getStore().remove(currentSelection);
        		if (this.getStore().getCount() > 0) {
        			sm.select(0);
        		}
    	    }
    	}, this);
    }
    */
});