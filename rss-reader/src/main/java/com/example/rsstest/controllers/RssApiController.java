package com.example.rsstest.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.rsstest.domains.RssModel;
import com.example.rsstest.domains.SiteJoin;
import com.example.rsstest.mappers.SiteJoinMapper;
import com.example.rsstest.models.RssStoreMap;

@Controller
public class RssApiController {
	
	private final SiteJoinMapper siteJoinMapper;
	
	@Autowired
	public RssApiController(SiteJoinMapper siteJoinMapper) {
		this.siteJoinMapper = siteJoinMapper;
	}
	
	@Autowired
	private RssStoreMap rssStoreMap;

	@GetMapping("/api/rss")
	@ResponseBody
	public Map<String, List<RssModel>> returnRss(){
		List<SiteJoin> sites = siteJoinMapper.all();
		Map<String, List<RssModel>> map = rssStoreMap.SiteMap(sites);
		return map;
	}
}