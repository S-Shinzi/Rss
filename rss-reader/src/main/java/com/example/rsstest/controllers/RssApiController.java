package com.example.rsstest.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.rsstest.domains.RssModel;
import com.example.rsstest.domains.Site;
import com.example.rsstest.domains.SiteType;
import com.example.rsstest.mappers.SiteMapper;
import com.example.rsstest.mappers.SiteTypeMapper;
import com.example.rsstest.models.RssStoreMap;

@Controller
public class RssApiController {
	
	private final SiteMapper siteMapper;
	private final SiteTypeMapper siteTypeMapper;
	
	@Autowired
	public RssApiController(SiteMapper siteMapper, SiteTypeMapper siteTypeMapper) {
		this.siteMapper = siteMapper;
		this.siteTypeMapper = siteTypeMapper;
	}
	
	@Autowired
	private RssStoreMap rssStoreMap;

	@GetMapping("/api/rss")
	@ResponseBody
	public Map<String, List<RssModel>> returnRss(){
		List<Site> sites = siteMapper.all();
		Map<String, List<RssModel>> map = rssStoreMap.SiteMap(sites);
		return map;
	}
	
	@GetMapping("/api/sites")
	@ResponseBody
	public List<Site> returnSites(){
		List<Site> sites = siteMapper.all();
		return sites;
	}
	
	@GetMapping("/api/sitetypes")
	@ResponseBody
	public List<SiteType> returnSiteTypes(){
		List<SiteType> siteTypes = siteTypeMapper.all();
		return siteTypes;
	}
}