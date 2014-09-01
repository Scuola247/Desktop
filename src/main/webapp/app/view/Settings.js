Ext.define('Desktop.view.Settings', {
	extend: 'Ext.window.Window',
	controller: 'Desktop.controller.Settings',
	requires: [ 'Desktop.ux.colorpicker.ColorPicker', 'Desktop.ux.colorpicker.ColorPickerField' ],
	stateId: 'Desktop.view.Settings',
	stateful: true,
	layout: 'fit',
	title: i18n.settings,
	modal: true,
	width: 700,
	height: 600,
	minWidth: 500, 
	minHeight: 300,
	border: false,
	constrain: true,
	icon: app_context_path + '/resources/images/settings-icon.png',

	initComponent: function() {

		this.preview = Ext.create('Desktop.view.Wallpaper', {
			itemId: 'previewWallpaper'
		});

		this.buttons = [ {
			text: i18n.save,
			itemId: 'okButton'
		}, {
			text: i18n.cancel,
			itemId: 'cancelButton'
		} ];

		this.items = Ext.create('Ext.tab.Panel', {

			items: [ Ext.create('Ext.panel.Panel', {
				title: i18n.settings_desktopbackground,
				layout: 'border',
				items: [ {
					xtype: 'panel',
					region: 'west',
					layout: 'fit',
					title: i18n.settings_backgroundimage,
					width: 150,
					items: [ {
						itemId: 'wallpaperDataview',
						xtype: 'dataview',
						store: Ext.create('Desktop.store.WallpaperStore'),
						itemSelector: 'div.settings-wallpaper-item',
						selectedItemCls: 'settings-wallpaper-item-selected',
						overItemCls: 'view-over',
						trackOver: true,
						autoScroll: true,
						tpl: [ '<tpl for=".">', '<div class="settings-wallpaper-item">', '{text}', '</div>', '</tpl>' ]
					} ]
				}, {
					xtype: 'panel',
					title: i18n.settings_preview,
					region: 'center',
					layout: 'fit',
					items: [ this.preview ]
				}, {
					xtype: 'container',
					region: 'south',
					layout: {
						type: 'vbox'
					},
					defaults: {
						margin: 5
					},
					items: [ {
						xtype: 'ux.colorpickerfield',
						itemId: 'backgroundColor',
						fieldLabel: i18n.settings_backgroundcolor
					}, {
						xtype: 'radiogroup',
						itemId: 'picturepos',
						fieldLabel: i18n.settings_pictureposition,
						labelAlign: 'left',
						labelWidth: 128,
						width: '100%',
						items: [ {
							boxLabel: i18n.settings_center,
							name: 'pos',
							inputValue: 'center'
						}, {
							boxLabel: i18n.settings_tile,
							name: 'pos',
							inputValue: 'tile'
						}, {
							boxLabel: i18n.settings_resize,
							name: 'pos',
							inputValue: 'fit'
						}, {
							boxLabel: i18n.settings_stretch,
							name: 'pos',
							inputValue: 'stretch'
						} ]
					} ]
				} ]
			}), Ext.create('Ext.form.Panel', {
				title: i18n.settings_userinformation,
				itemId: 'userSettingsPanel',
				defaultType: 'textfield',
				paramsAsHash: true,
				api: {
					load: userService.userFormSettingsLoad,
					submit: userService.userFormSettingsPost
				},
				fieldDefaults: {
					msgTarget: 'side'
				},
				bodyPadding: 10,
				items: [ {
					xtype: 'combobox',
					fieldLabel: i18n.user_language,
					name: 'locale',
					store: Ext.create('Ext.data.ArrayStore', {
						fields: [ 'code', 'language' ],
						data: [ [ 'it', i18n.user_language_italian ], [ 'de', i18n.user_language_german ], [ 'en', i18n.user_language_english ] ]
					}),
					valueField: 'code',
					displayField: 'language',
					queryMode: 'local',
					emptyText: i18n.user_selectlanguage,
					allowBlank: false,
					forceSelection: true,
					anchor: '50%'
				}, {
					xtype: 'button',
					itemId: 'resetWindowPosButton',
					text: i18n.settings_resetall,
					anchor: '50%'
				}]
			}), Ext.create('Ext.form.Panel', {
				title: i18n.settings_change_password,
				itemId: 'changePasswordSettingsPanel',
				defaultType: 'textfield',
				defaults: {
					anchor: '100%'
				},
				paramsAsHash: true,
				api: {
					submit: userService.updatePassword
				},
				fieldDefaults: {
					msgTarget: 'side'
				},
				bodyPadding: 10,
				items: [ {
					name: 'passwordHash',
					fieldLabel: i18n.user_password,
					inputType: 'password',
					itemId: 'pass'
				}, {
					name: 'password-confirm',
					fieldLabel: i18n.user_confirmpassword,
					vtype: 'password',
					inputType: 'password',
					initialPassField: 'pass'
				}]
			}) ]

		});

		this.callParent();
	}
});
