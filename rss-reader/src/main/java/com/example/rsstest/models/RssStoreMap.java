package com.example.rsstest.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.rsstest.domains.RssModel;
import com.example.rsstest.domains.SiteJoin;

@Component
public class RssStoreMap {
	 
	@Autowired
	private RssConverter rssConverter;
	
	@Autowired
	private RssReader rssReader;

	public Map<String, List<RssModel>> SiteMap(List<SiteJoin> sites) {
		Map<String, List<RssModel>> siteMap = new HashMap<>();
		
		
		for (int i=0; i<sites.size(); i++) {
			//System.out.println(sites.get(i).getName());
			siteMap.put(sites.get(i).getName(), rssConverter.rssModel(rssReader.readRss(sites.get(i).getRss_link())));
		}
		return siteMap;
	}
}