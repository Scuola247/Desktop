package org.scuola247.desktop.security;

public enum Lingue {
	IT(1), EN(2), DE(3);
	
	private int value;
	
	Lingue (int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
	
	public static Lingue fromString(int value) {
		for (Lingue b : Lingue.values()) {
			if (value == b.value) {
				return b;
			}
		}
		return null;
	}
}
