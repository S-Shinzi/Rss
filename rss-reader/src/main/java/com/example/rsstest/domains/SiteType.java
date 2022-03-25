package com.example.rsstest.domains;

import java.sql.Date;

public class SiteType {
	
	private int id;
	private String type;
	private Date created_at;
	private Date updated_at;
	
	public SiteType(int id, String type, Date created_at, Date updated_at) {
		this.id = id;
		this.type = type;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Date getCreated_at() {
		return created_at;
	}
	
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
	public Date getUpdated_at() {
		return updated_at;
	}
	
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	
}
