package com.example.rsstest.models;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rsstest.domains.Parse;
import com.example.rsstest.domains.Site;
import com.example.rsstest.mappers.ParseMapper;

@Service
public class UrlToEx {
	
	private final ParseMapper parseMapper;
	
	@Autowired
	public UrlToEx(ParseMapper parseMapper) {
		this.parseMapper = parseMapper;
	}
	
	public List<Parse> returnParses(String url, List<Site> sites) throws URISyntaxException {
		URI serchUrl = new URI(url);
		int siteId = 0;
		
		for (int i=0; i<sites.size(); i++) {
			URI dbUrl = new URI(sites.get(i).getRss_link());
			if(serchUrl.getHost().equals(dbUrl.getHost())) {
				siteId = sites.get(i).getId();
				break;
			}
		}
		
		List<Parse> parses = parseMapper.getParses(siteId);;
		return parses;
	}
}
