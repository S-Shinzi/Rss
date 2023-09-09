package com.example.rsstest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/api/db/add-sites")
	public String addSites(@RequestParam String name, @RequestParam String rss_link) {
		Site site = new Site(name, rss_link);
		siteMapper.add(site);
		return "redirect:/setting";
	}
	
	@PostMapping("/api/db/remove-sites")
	public String removeSites(@RequestParam int id) {
		Site site = new Site(id);
		siteMapper.remove(site);
		return "redirect:/setting";
	}
	
	@PostMapping("/api/db/update-sites")
	public String updateSites(@RequestParam int id, @RequestParam String name, @RequestParam String rss_link) {
		Site site = new Site(id, name, rss_link);
		siteMapper.update(site);
		return "redirect:/setting";
	}
	
}
