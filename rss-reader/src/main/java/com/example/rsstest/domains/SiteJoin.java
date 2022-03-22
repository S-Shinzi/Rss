package com.example.rsstest.domains;

public class SiteJoin {
	
	//select sites.id, sites.name, sites.uq_rss_link, sites.type_id, site_types.type from sites inner join site_types on sites.type_id = site_types.id;
	
	private int id;
	private String name;
	private String rss_link;
	private int type_id;
	private String type;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
