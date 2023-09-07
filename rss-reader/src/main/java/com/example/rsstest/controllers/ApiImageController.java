package com.example.rsstest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.rsstest.domains.ImageModel;
import com.example.rsstest.domains.Site;
import com.example.rsstest.mappers.SiteMapper;
import com.example.rsstest.models.ImageScraping;

@Controller
public class ApiImageController {
	
	private final SiteMapper siteMapper;
	
	@Autowired
	public ApiImageController(SiteMapper siteMapper) {
		this.siteMapper = siteMapper;
	}
	
	@Autowired
	private ImageScraping imageScraping;
	
	@GetMapping("/api/image")
	@ResponseBody
	public List<ImageModel> returnImage(@RequestParam String url) {
		List<Site> sites = siteMapper.all();
		List<ImageModel> images = imageScraping.returnImages(url, sites);
		return images;
	}
}
