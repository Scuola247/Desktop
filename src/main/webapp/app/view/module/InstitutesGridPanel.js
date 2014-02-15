Ext.define('Desktop.view.module.InstitutesGridPanel', {
    extend: 'Ext.grid.Panel',
    
    requires: [
        'Ext.selection.CellModel',
        'Ext.grid.*',
        'Ext.data.*',
        'Ext.util.*',
        'Ext.form.*',
        'Desktop.model.Institutes',
        'Desktop.store.Institutes'
    ],
    xtype: 'cell-editing',
   
    initComponent: function() {
        this.cellEditing = new Ext.grid.plugin.CellEditing({
            clicksToEdit: 1
        });
        
        var store = Ext.create('Desktop.store.Institutes');
        var columns = [{
	        	text : i18n.institutes_institute , 
	        	dataIndex: 'istituto',
        		xtype: 'numbercolumn',
        		format: '0',
	        	/*
	        	editor: {
	        		xtype: 'numberfield',
                    allowBlank: false
                }
                */
	    	}, {
	    		text : i18n.institutes_description ,
	    		dataIndex: 'descrizione',
	    		editor: {
                    allowBlank: false
                }
	    	}, {
	    		text : i18n.institutes_code ,
	    		dataIndex: 'codice_meccanografico',
	    		editor: {
                    allowBlank: false
                }
	    	}, {
	    		text : i18n.institutes_mnem ,
	    		dataIndex: 'mnemonico',
	    		editor: {
                    allowBlank: false
                }
	    	}, {
	    		xtype: 'checkcolumn',
	    		text : i18n.institutes_example ,
	    		dataIndex: 'esempio'
	    	}, {
                xtype: 'actioncolumn',
                width: 30,
                sortable: false,
                menuDisabled: true,
                items: [{
                	id: 'deleteInstitute', 
                	iconCls: 'remove',
                    tooltip: i18n.institutes_delete,
                    scope: this,
                    handler: this.onRemoveClick
                }]
            }
	    	
        ];
        Ext.apply(this, {
            width: 680,
            height: 350,
            plugins: [this.cellEditing],
            store: store,
            columns: columns,
            selModel: {
                selType: 'cellmodel'
            }
        });
        
        this.callParent();
    },

    onRemoveClick: function(grid, rowIndex){		//TODO: andra fatto il bind da controller
        //this.getStore().removeAt(rowIndex);
    	var sm = grid.getSelectionModel();
    	this.getStore().remove(sm.getSelection());
		if (this.getStore().getCount() > 0) {
			sm.select(0);
		}
    }
    
})