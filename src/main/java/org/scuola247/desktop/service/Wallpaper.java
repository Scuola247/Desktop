package org.scuola247.desktop.service;

import ch.rasc.extclassgenerator.Model;

@Model(value = "Desktop.model.Wallpaper", readMethod = "wallpaperService.read")
public class Wallpaper {

	private final String text;

	private final String img;

	private final Integer width;

	private final Integer height;

	public Wallpaper(String text, String img, Integer width, Integer height) {
		this.text = text;
		this.img = img;
		this.width = width;
		this.height = height;
	}

	public String getText() {
		return text;
	}

	public String getImg() {
		return img;
	}

	public Integer getWidth() {
		return width;
	}

	public Integer getHeight() {
		return height;
	}

}
