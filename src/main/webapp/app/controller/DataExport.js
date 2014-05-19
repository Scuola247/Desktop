Ext.define('Desktop.controller.DataExport', {
	extend: 'Deft.mvc.ViewController',
	mixins: ['Deft.mixin.Injectable'],
	inject: ['sharedStorage'],
	requires: [], 

	config: {
		sharedStorage: null,
		classe: null
	},
	
	control: {
		view: {
			show: 'onShow'
		},
		dataexportForm: true,
		toExport: true,
		btnExport: {
			click: 'onCLickBtnExport'
		},
		btnClose: {
			click: 'onClickBtnClose'
		}
	},
	
	onShow: function() {
		var view = this.getView();

		var sharedStorage = this.getSharedStorage();
		this.setClasse(sharedStorage.sl_classe);

		
		if (Ext.isEmpty(this.getClasse())){
			Desktop.ux.window.Notification.info(i18n.important, i18n.workspace_required_class);
			view.destroy();
		}
		else{
			//OK
		}
		
	},
	
	onCLickBtnExport: function() {
		var exportCombo = this.getToExport();
		var classe = this.getClasse();
		var exportComboValue = exportCombo.getSubmitValue();
		if (!Ext.isEmpty(exportComboValue)){
			var url = app_context_path + "/export/" + exportComboValue + "/" + classe + ".csv";
			window.open(url, i18n.dataexport);
		}
		else{
			Ext.Msg.show({
            	title:i18n.dataexport_info_message,
            	buttons: Ext.Msg.OK,
            	msg:i18n.dataexport_select_export,
            	icon: Ext.MessageBox.INFO
            });
		}
	},
	
	onClickBtnClose: function() {
		this.getView().close();
	}
});