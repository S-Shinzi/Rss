package com.example.rsstest.domains;

import java.sql.Date;

public class Site {
	
	//select * from sites;
	
	private int id;
	private String name;
	private String rss_link;
	private int type_id;
	private Date created_at;
	private Date updated_at;
	
	public Site(int id, String name, String rss_link, int type_id, Date created_at, Date updated_at) {
		this.id = id;
		this.name = name;
		this.rss_link = rss_link;
		this.type_id = type_id;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRss_link() {
		return rss_link;
	}
	
	public void setRss_link(String rss_link) {
		this.rss_link = rss_link;
	}
	
	public int getType_id() {
		return type_id;
	}
	
	public void setType_id(int type_id) {
		this.type_id = type_id;
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
