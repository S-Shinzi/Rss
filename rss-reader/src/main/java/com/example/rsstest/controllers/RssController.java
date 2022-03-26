package com.example.rsstest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.rsstest.domains.SiteType;
import com.example.rsstest.mappers.SiteMapper;
import com.example.rsstest.mappers.SiteTypeMapper;

@Controller
public class RssController {
	
	private final SiteTypeMapper siteTypeMapper;
	
	@Autowired
	public RssController(SiteTypeMapper siteTypeMapper) {
		this.siteTypeMapper = siteTypeMapper;
	}

	@GetMapping("/rss-test")
	public String index() {
		return "rss-test";
	}
	
	@GetMapping("/setting")
	public String setting() {
		return "setting";
	}
	
	@PostMapping("/setting/type")
	public String addType(@RequestParam("type_name") String typeName) {
		SiteType siteType = new SiteType(typeName);
		siteTypeMapper.add(siteType);
		return "redirect:/setting";
	}
}