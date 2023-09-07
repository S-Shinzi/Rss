package com.example.rsstest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.rsstest.domains.Parse;
import com.example.rsstest.mappers.ParseMapper;

@Controller
public class DbParsesController {
	private final ParseMapper parseMapper;
	
	@Autowired
	public DbParsesController(ParseMapper parseMapper) {
		this.parseMapper = parseMapper;
	}
	
	@GetMapping("/api/db/parses")
	@ResponseBody
	public List<Parse> returnParses(){
		List<Parse> parses = parseMapper.all();
		return parses;
	}
	
	@PostMapping("/api/db/add-parses")
	public String addParses(@RequestParam int site_id, @RequestParam String element_parse, @RequestParam String attribute_parse) {
		Parse parse = new Parse(site_id, element_parse, attribute_parse);
		parseMapper.add(parse);
		return "redirect:/setting";
	}
	
	@PostMapping("/api/db/remove-parses")
	public String removeParses(@RequestParam int id) {
		//System.out.println(id);
		Parse parse = new Parse(id);
		parseMapper.remove(parse);
		return "redirect:/setting";
	}
	
	@PostMapping("/api/db/update-parses")
	public String updateParses(@RequestParam int id, @RequestParam int site_id, @RequestParam String element_parse, @RequestParam String attribute_parse) {
		//System.out.println("id:" + id + " site_id:" + site_id + " element_parse:" + element_parse + " attribute_parse:" + attribute_parse);
		Parse parse = new Parse(id, site_id, element_parse, attribute_parse);
		parseMapper.update(parse);
		return "redirect:/setting";
	}
}
