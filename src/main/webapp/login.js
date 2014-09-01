Ext.onReady(function() {
	Ext.QuickTips.init();

	var login;
	
	function submitForm() {
		var form = login.getForm();
		if (form.isValid()) {
			form.submit();
		}
	}
	
	var buttonsList = [];
	/* */ if (isDevelopment){
		buttonsList.push ({
			text: i18n.login_withuser,
			handler: function() {
				var form = this.up('form').getForm();
				form.setValues({
					username: 'alunno@scuola247.it',
					password: 'Voti-9999'
				});
				form.submit();
			}
		});
		buttonsList.push ({
			text: 'login famigliare',
			handler: function() {
				var form = this.up('form').getForm();
				form.setValues({
					username: 'famigliare@scuola247.it',
					password: 'Voti-9999'
				});
				form.submit();
			}
		});
		buttonsList.push ({
			text: 'login docente',
			handler: function() {
				var form = this.up('form').getForm();
				form.setValues({
					username: 'docente@scuola247.it',
					password: 'Voti-9999'
				});
				form.submit();
			}
		});
		buttonsList.push ({
			text: 'login impiegato',
			handler: function() {
				var form = this.up('form').getForm();
				form.setValues({
					username: 'impiegato@scuola247.it',
					password: 'Voti-9999'
				});
				form.submit();
			}
		});
		buttonsList.push ({
			text: 'login dirigente',
			handler: function() {
				var form = this.up('form').getForm();
				form.setValues({
					username: 'dirigente@scuola247.it',
					password: 'Voti-9999'
				});
				form.submit();
			}
		});
		buttonsList.push ({
			text: i18n.login_withadmin,
			handler: function() {
				var form = this.up('form').getForm();
				form.setValues({
					username: 'manager@scuola247.it',
					password: 'Voti-9999'
				});
				form.submit();
			}
		}); 
	} 
	/* */
	buttonsList.push ({
		text: i18n.login,
		handler: function() {
			submitForm();
		}
	});
	
	login = Ext.create('Ext.form.Panel', {
		frame: true,
		title: 'Scuola247 Login',
		url: 'login.html',
/*		width: 380,*/
		width: (isDevelopment)?720:380,
		icon: 'resources/images/key.png',

		standardSubmit: true,

		defaults: {
			anchor: '100%'
		},

		defaultType: 'textfield',

		fieldDefaults: {
			msgTarget: 'side'
		},

		items: [ {
			fieldLabel: i18n.user_email,
			name: 'username',
			allowBlank: false,
			blankText: i18n.login_username_is_mandatory,
			listeners: {
				specialkey: function(field, e) {
					if (e.getKey() === e.ENTER) {
						submitForm();
					}
				}
			}
		}, {
			fieldLabel: i18n.user_password,
			name: 'password',
			inputType: 'password',
			allowBlank: false,
			blankText: i18n.login_password_is_mandatory,
			listeners: {
				specialkey: function(field, e) {
					if (e.getKey() === e.ENTER) {
						submitForm();
					}
				}
			}
		}/*, {
			fieldLabel: i18n.login_rememberme,
			name: 'remember-me',
			xtype: 'checkbox'
		} */],

		buttons: buttonsList
	});

	Ext.create('Ext.container.Viewport', {
		layout: 'fit',
		renderTo: Ext.getBody(),

		items: [ {
			xtype: 'panel',
			border: false,
			style: 'background-color: white',
			layout: {
				type: 'vbox',
				align: 'center',
				pack: 'center'
			},
			items: login,
			dockedItems: [ {
				dock: 'top',
				xtype: 'toolbar',
				items: [ {
					xtype: 'image',
					src: app_context_path + '/resources/images/favicon32.png',
					margin: '2px 10px 2px 5px',
					width: 32,
					height: 32
				}, {
					xtype: 'label',
					text: 'Scuola247 Desktop',
					cls: 'appLabel',
					padding: '5 0 0 0',
					height: 30
				} ]
			} ]
		} ]
	});

	login.getForm().findField('username').focus();

});