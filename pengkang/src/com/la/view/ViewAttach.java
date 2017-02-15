package com.la.view;

import org.springframework.web.multipart.MultipartFile;

public class ViewAttach {
	private MultipartFile attach;
	
	public MultipartFile getAttach() {
		return attach;
	}

	public void setAttach(MultipartFile attach) {
		this.attach = attach;
	}	
}
