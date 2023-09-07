package com.example.rsstest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RssController {

	@GetMapping("/rss-test")
	public String index() {
		return "rss-test";
	}
	
	@GetMapping("/setting")
	public String setting() {
		return "setting";
	}
	
	@GetMapping("/imageViewer")
	public String imageViewer() {
		return "imageViewer";
	}
	
	@GetMapping("/bookViewer")
	public String bookViewer() {
		return "bookViewer";
	}
}