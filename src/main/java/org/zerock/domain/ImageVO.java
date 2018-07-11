package org.zerock.domain;

import java.util.Date;

public class ImageVO {

	
	private String uhome;	
	private String imageName;
	
	
	public String getUhome() {
		return uhome;
	}
	public void setUhome(String uhome) {
		this.uhome = uhome;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	
	@Override
	public String toString() {
		return "ImageVO [uhome=" + uhome + ", imageName=" + imageName + "]";
	}
	
	
	
	
	
	
}
