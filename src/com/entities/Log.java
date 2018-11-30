package com.entities;

import java.sql.Timestamp;

public class Log {
	
	private int id;
	private int idLogType;
	private int idPlatform;
	private int statusCode;
	private String description;
	private String module;
	private String url;
	private long date;
	private String messageFormat;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLogType() {
		return idLogType;
	}
	public void setLogType(int idLogType) {
		this.idLogType = idLogType;
	}
	public int getCode() {
		return this.statusCode;
	}
	public void setCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPlatform() {
		return this.idPlatform;
	}
	public void setPlatform(int idPlatform) {
		this.idPlatform = idPlatform;
	}
	public String getModule() {
		return this.module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public long getDate() {
		return this.date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessageFormat() {
		return messageFormat;
	}

	public void setMessageFormat(String messageFormat) {
		this.messageFormat = messageFormat;
	}
}
