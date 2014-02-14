Ext.define('Desktop.view.module.InstitutesPanel', {
    extend: 'Ext.grid.Panel',
    
    requires: [
        'Ext.selection.CellModel',
        'Ext.grid.*',
        'Ext.data.*',
        'Ext.util.*',
        'Ext.form.*',
        'Desktop.model.Institutes'
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
	    	}, {
	    		text : i18n.institutes_description ,
	    		dataIndex: 'descrizione',
	    	}, {
	    		text : i18n.institutes_code ,
	    		dataIndex: 'codice_meccanografico',
	    	}, {
	    		text : i18n.institutes_mnem ,
	    		dataIndex: 'mnemonico',
	    	}, {
	    		text : i18n.institutes_example ,
	    		dataIndex: 'esempio'
	    	}, {
                xtype: 'actioncolumn',
                width: 30,
                sortable: false,
                menuDisabled: true,
                items: [{
                	id: 'deleteInstitute', 
                    icon: 'resources/icons/delete.png',
                    tooltip: i18n.institutes_delete,
                    scope: this
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
            },
            tbar: [{
                text: 'Add Plant',
                itemId: 'addPlantButton'
            }]
        });
        
        this.callParent();
        
//        this.on('afterlayout', this.loadStore, this, {
//            delay: 1,
//            single: true
//        });
//    },
//    
//    loadStore: function() {
//        this.getStore().load(/*{
//            // store loading is asynchronous, use a load listener or callback to handle results
//            callback: this.onStoreLoad
//        }*/);
//    },
    /*
    onStoreLoad: function(){
        Ext.Msg.show({
            title: 'Store Load Callback',
            msg: 'store was loaded, data available for processing',
            icon: Ext.Msg.INFO,
            buttons: Ext.Msg.OK
        });
        */
    },
    
    
//    
//    onRemoveClick: function(grid, rowIndex){
//        this.getStore().removeAt(rowIndex);
//    }
})