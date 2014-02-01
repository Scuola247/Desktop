package org.scuola247.desktop.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ch.rasc.edsutil.entity.AbstractPersistable;
import ch.rasc.extclassgenerator.Model;

@Entity
@Model(value = "Desktop.model.Role", readMethod = "userService.readRoles")
public class Role extends AbstractPersistable {

	@NotNull
	@Size(max = 50)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}