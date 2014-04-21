Ext.define('Desktop.view.module.InstitutesGridPanel', {
    extend: 'Ext.grid.Panel',
    
    requires: [
        /*'Ext.grid.plugin.RowEditing',*/ 
        'Ext.selection.CellModel',
        'Ext.grid.*',
        'Ext.data.*',
        'Ext.util.*',
        'Ext.form.*',
        'Desktop.model.Institutes',
        'Desktop.store.Institutes'
    ],
   
    initComponent: function() {
    	/*
        this.rowEditing = new Ext.grid.plugin.RowEditing({
            clicksToMoveEditor: 1,
            autoCancel: false
        });
        
        this.rowEditing.on ({
        					edit: function(editor, e) {
        						var store = this.getStore();
        						if (this.addingNewInstitute){
            						var record = store.getAt(0);
            						var sm = this.getSelectionModel();
            						this.getStore().remove(sm.getSelection());
            						store.resumeAutoSync();
            						store.insert(0, record);
        						}
        						this.addingNewInstitute = false;
        					},
							canceledit: function(editor, e) {
								if (this.addingNewInstitute){
									var sm = this.getSelectionModel();
									this.getStore().remove(sm.getSelection());
								}
								this.addingNewInstitute = false;
					        	this.getStore().resumeAutoSync();
					        },
					        scope: this
        });
        */
        var store = Ext.create('Desktop.store.Institutes');
        //store.on ('remove', this.onRemoveInstitute);
        
        var columns = [
            {
				header: i18n.institutes_logo,
				width: 205,
				resizable: false,
				dataIndex: 'istituto',
				sortable: true,
				align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return '<img src="' + app_context_path + "/images/institute_logo/" + value + '" width="30px" height=30px/>';
				}/*,
				editor: {
					xtype: 'filefield',
					allowBlank: false,
					buttonOnly: true,
					hideLabel: true
				}*/
            },{
	        	text : i18n.institutes_institute , 
	        	dataIndex: 'istituto',
        		xtype: 'numbercolumn',
        		format: '0'/*,
	        	editor: {
	        		xtype: 'numberfield',
                    allowBlank: false
                }
                */
	    	}, {
	    		text : i18n.institutes_description ,
	    		dataIndex: 'descrizione'/*,
	    		editor: {
                    allowBlank: false
                }*/
	    	}, {
	    		text : i18n.institutes_meccanografico ,
	    		dataIndex: 'codice_meccanografico'/*,
	    		editor: {
                    allowBlank: false
                }*/
	    	}, {
	    		text : i18n.institutes_mnem ,
	    		dataIndex: 'mnemonico'/*,
	    		editor: {
                    allowBlank: false
                }*/
	    	}, {
	    		xtype: 'checkcolumn',
	    		text : i18n.institutes_example,
	    		dataIndex: 'esempio',
	    		disabled:true/*,
	            editor: {
	                xtype: 'checkbox',
	                cls: 'x-grid-checkheader-editor'
	            }*/
	    	}, {
                xtype: 'actioncolumn',
                action: 'deleteAction',
                //hidden: true,
                width: 22,
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
        	//addingNewInstitute: false,
        	viewConfig: {
        		getRowClass:function ( record, index, rowParams, store ){
        			return "institutes-row";
        		}
        	},
            width: 680,
            height: 350,
            store: store,
            columns: columns,
            selModel: {
                //selType: 'cellmodel'
            	selType: 'rowmodel'
            }/*,
            plugins: [ this.rowEditing ]*/
        });
        
        this.callParent();
    },

    onRemoveClick: function(grid, rowIndex){
    	//this.rowEditing.cancelEdit();
    	
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
    /*,
    onRemoveInstitute: function ( store, record, index, isMove, eOpts ){
    	
    	Ext.Msg.show({
        	title:i18n.institutes_deleted,
        	buttons: Ext.Msg.OK,
        	msg: i18n.institutes_deleted,
        	icon: Ext.MessageBox.INFO
        });
    }
    */
});