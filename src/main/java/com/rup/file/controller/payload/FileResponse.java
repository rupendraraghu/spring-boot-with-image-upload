package com.rup.file.controller.payload;

public class FileResponse {

	String fileName;
	String message;

	public FileResponse() {
		// TODO Auto-generated constructor stub
	}

	public FileResponse(String fileName, String message) {
		super();
		this.fileName = fileName;
		this.message = message;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
