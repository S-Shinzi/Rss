package com.example.rsstest.domains;

import java.time.LocalDateTime;

public class Parse {
	private int id;
	private int site_id;
	private String element_parse;
	private String attribute_parse;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
	public Parse(int id, int site_id, String element_parse, String attribute_parse, LocalDateTime created_at, LocalDateTime updated_at) {
		this.id = id;
		this.site_id = site_id;
		this.element_parse = element_parse;
		this.attribute_parse = attribute_parse;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	public Parse(int id2, int site_id2, String element_parse2, String attribute_parse2) {
		this.id = id2;
		this.site_id = site_id2;
		this.element_parse = element_parse2;
		this.attribute_parse = attribute_parse2;
	}
	
	public Parse(int site_id2, String element_parse2, String attribute_parse2) {
		this.site_id = site_id2;
		this.element_parse = element_parse2;
		this.attribute_parse = attribute_parse2;
	}

	public Parse(int id2) {
		this.id = id2;
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
