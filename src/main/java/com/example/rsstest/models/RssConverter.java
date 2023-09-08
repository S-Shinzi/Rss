package com.example.rsstest.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rsstest.domains.RssModel;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;

@Service
public class RssConverter {
	
	public List<RssModel> rssModel(SyndFeed feed){
		List<RssModel> rssList = new  ArrayList<RssModel>();
		
		if(feed == null) {
		}else {
			for (int i = 0; i < feed.getEntries().size(); i++) {
				SyndEntry entry = feed.getEntries().get(i);
				
				String title = entry.getTitle();
				String description = entry.getDescription().getValue();
				String link = entry.getLink();
				
				RssModel model = new RssModel(title, description, link);
				rssList.add(model);
			}
		}
		return rssList;
	}
}