package org.scuola247.desktop.entity;

import ch.rasc.extclassgenerator.Model;

@Model(value = "Desktop.model.Role", readMethod = "userService.readRoles")
public class Role {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}