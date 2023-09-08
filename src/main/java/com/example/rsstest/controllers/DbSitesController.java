package com.example.rsstest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.rsstest.domains.Site;
import com.example.rsstest.mappers.SiteMapper;

@Controller
public class DbSitesController {
	
	private final SiteMapper siteMapper;
	
	@Autowired
	public DbSitesController(SiteMapper siteMapper) {
		this.siteMapper = siteMapper;
	}
	
	@GetMapping("/api/db/sites")
	@ResponseBody
	public List<Site> returnSites(){
		List<Site> sites = siteMapper.all();
		return sites;
	}
}
