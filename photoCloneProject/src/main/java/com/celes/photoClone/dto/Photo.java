package com.celes.photoClone.dto;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Photo {
private String id;

@NotEmpty
private String fileName;

private String contentType;

public String getContentType() {
	return contentType;
}
public void setContentType(String contentType) {
	this.contentType = contentType;
}
private byte[] data;

@JsonIgnore
public byte[] getData() {
	return data;
}
public void setData(byte[] data) {
	this.data = data;
}
public Photo() {
	
}
public Photo(String id, String fileName) {
	super();
	this.id = id;
	this.fileName = fileName;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}

}
