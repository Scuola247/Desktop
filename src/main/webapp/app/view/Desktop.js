Ext.define('Desktop.view.Desktop', {
	extend: 'Ext.panel.Panel',
	controller: 'Desktop.controller.Desktop',
	requires: [ 'Desktop.view.WindowBar', 'Desktop.view.Wallpaper', 'Desktop.store.DesktopStore', 'Desktop.view.TopBar', 'Desktop.view.module.OnlineUsers',
			'Desktop.view.module.Notepad', 'Desktop.view.module.TabWindow', 'Desktop.view.module.GridWindow', 'Desktop.view.module.EducationSubjects', 'Desktop.view.module.SystemStatus',
			'Desktop.view.UsersWindow', 'Desktop.view.LoggingEventsWindow', 'Desktop.view.AccessLogWindow', 'Desktop.view.ConfigurationWindow' ],

	border: false,
	html: '&#160;',
	layout: 'fit',

	contextMenu: Ext.create('Ext.menu.Menu', {
		items: [ {
			text: i18n.desktop_closeall,
			action: 'closeall',
			minWindows: 1
		}, '-', {
			text: i18n.desktop_minimizeall,
			action: 'minimizeall',
			minWindows: 1
		}, '-', {
			text: i18n.desktop_tile,
			action: 'tile',
			minWindows: 2
		}, {
			text: i18n.desktop_cascade,
			action: 'cascade',
			minWindows: 2
		}, {
			text: i18n.desktop_fithorizontal,
			action: 'fithorizontal',
			minWindows: 1
		}, {
			text: i18n.desktop_fitvertical,
			action: 'fitvertical',
			minWindows: 1
		} ]
	}),

	initComponent: function() {
		this.dockedItems = [ Ext.create('Desktop.view.WindowBar', {
			dock: 'bottom'
		}), Ext.create('Desktop.view.TopBar', {
			dock: 'top'
		}) ];

		this.wallpaper = Ext.create('Desktop.view.Wallpaper');

		this.items = [
				this.wallpaper,
				{
					xtype: 'dataview',
					itemId: 'shortcutView',
					overItemCls: 'view-over',
					itemSelector: 'div.desktop-shortcut',
					trackOver: true,
					store: Ext.create('Desktop.store.DesktopStore'),
					style: {
						position: 'absolute'
					},
					tpl: [ '<tpl for=".">', '<div class="desktop-shortcut" id="{name}-shortcut">', '<div class="desktop-shortcut-icon {iconCls}-shortcut">',
							'<img src="', Ext.BLANK_IMAGE_URL, '" title="{name}">', '</div>', '<span class="desktop-shortcut-text">{name}</span>', '</div>',
							'</tpl>', '<div class="x-clear"></div>' ]
				} ];

		this.callParent(arguments);
	}
});