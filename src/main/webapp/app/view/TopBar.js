Ext.define('Desktop.view.TopBar', {
	extend: 'Ext.toolbar.Toolbar',
	itemId: 'topBar',

	initComponent: function() {
		this.items = [ {
			xtype: 'image',
			src: app_context_path + "/resources/images/favicon32.png",
			margin: '2px 10px 2px 5px',
			width: 32,
			height: 32
		}, {
			xtype: 'button',
			text: i18n.application_menu,
			cls: 'appButton',
			height: 30,
			menu: {
				xtype: 'menu',
				itemId: 'applicationMenu'
			}
		}, '-', {
			xtype: 'label',
			text: '',
			cls: 'loggedOnLabel',
			itemId: 'loggedOnLabel'
		}, '->', {
			xtype: 'combo',
			editable: false,
			fieldLabel: i18n.workspace,
			itemId: 'spazioLavoroCombo',
			emptyText:'',
			width: 500,
			queryMode: 'local',
			valueField: 'spazio_lavoro',
			displayField: 'descrizione'
		}, {
			itemId:'spazioLavoroButton',
			icon: app_context_path + "/resources/icons/star_yellow.png"
		}
		/*, '-', {
			icon: app_context_path + '/resources/images/mail_write.png',
			text: i18n.feedback,
			itemId: 'feedbackButton'
		}*/, '-', {
			text: i18n.settings,
			itemId: 'topBarSettings',
			icon: app_context_path + '/resources/images/settings-icon.png'
		}, '-', {
			text: i18n.logout,
			icon: app_context_path + '/resources/images/logout.png',
			href: 'logout',
			hrefTarget: '_self'
		} ];

		this.callParent(arguments);

	}
});
