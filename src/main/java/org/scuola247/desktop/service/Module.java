package org.scuola247.desktop.service;

import ch.rasc.extclassgenerator.Model;

@Model(value = "Desktop.model.Module", readMethod = "moduleService.read")
public class Module {

	private final String id;

	private final String name;

	private final String iconCls;

	private final boolean showOnDesktop;

	private final String menuPath;

	public Module(String id, String name, String iconCls, boolean showOnDesktop, String menuPath) {
		this.id = id;
		this.name = name;
		this.iconCls = iconCls;
		this.showOnDesktop = showOnDesktop;
		this.menuPath = menuPath;
	}

	public Module(String id, String name, String iconCls, boolean showOnDesktop) {
		this(id, name, iconCls, showOnDesktop, null);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getIconCls() {
		return iconCls;
	}

	public boolean isShowOnDesktop() {
		return showOnDesktop;
	}

	public String getMenuPath() {
		return menuPath;
	}

}
