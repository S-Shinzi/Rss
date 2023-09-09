package com.example.rsstest.domains;

import java.time.LocalDateTime;

public class Parse {
	private int id;
	private int site_id;
	private String element_parse;
	private String attribute_parse;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
	//select * from parses;
	public Parse(int id, int site_id, String element_parse, String attribute_parse, LocalDateTime created_at, LocalDateTime updated_at) {
		this.id = id;
		this.site_id = site_id;
		this.element_parse = element_parse;
		this.attribute_parse = attribute_parse;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	//update
	public Parse(int id, int site_id, String element_parse, String attribute_parse) {
		this.id = id;
		this.site_id = site_id;
		this.element_parse = element_parse;
		this.attribute_parse = attribute_parse;
	}
	
	//insert
	public Parse(int site_id, String element_parse, String attribute_parse) {
		this.site_id = site_id;
		this.element_parse = element_parse;
		this.attribute_parse = attribute_parse;
	}

	//remove
	public Parse(int id) {
		this.id = id;
	}
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getSite_id() {
		return site_id;
	}
	
	public void setSite_id(int site_id) {
		this.site_id = site_id;
	}
	
	public String getElement_parse() {
		return element_parse;
	}
	
	public void setElement_parse(String element_parse) {
		this.element_parse = element_parse;
	}
	
	public String getAttribute_parse() {
		return attribute_parse;
	}
	
	public void setAttribute_parse(String attribute_parse) {
		this.attribute_parse = attribute_parse;
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
