package com.example.rsstest.domains;

import java.time.LocalDateTime;

public class Site {
	
	private int id;
	private String name;
	private String rss_link;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
	//select * from sites;
	public Site(int id, String name, String rss_link, LocalDateTime created_at, LocalDateTime updated_at) {
		this.id = id;
		this.name = name;
		this.rss_link = rss_link;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	//update
	public Site(int id, String name, String rss_link) {
		this.id = id;
		this.name = name;
		this.rss_link = rss_link;
	}
	
	//insert
	public Site(String name, String rss_link) {
		this.name = name;
		this.rss_link = rss_link;
	}
	
	//remove
	public Site(int id) {
		this.id = id;
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

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

}
