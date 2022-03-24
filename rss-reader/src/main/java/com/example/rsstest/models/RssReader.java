package com.example.rsstest.models;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

@Service
public class RssReader {
	
	@Autowired
	GetRedirect getredirect;
	
	public SyndFeed readRss(String url) {
		
		SyndFeed feed = null;
		
		try {
			CloseableHttpClient client1 = HttpClients.createMinimal();
		    HttpUriRequest method1 = new HttpGet(url);
		    CloseableHttpResponse response1 = client1.execute(method1);
		    InputStream stream1 = response1.getEntity().getContent();
		    SyndFeedInput input = new SyndFeedInput();
		    
		    try {
		    	feed = input.build(new XmlReader(stream1));
		    } catch (FeedException e1) {
		    	//redirect
		    	url = getredirect.GetUrl(url);
		    	
		    	CloseableHttpClient client2 = HttpClients.createMinimal();
			    HttpUriRequest method2 = new HttpGet(url);
			    CloseableHttpResponse response2 = client2.execute(method2);
			    InputStream stream2 = response2.getEntity().getContent();
			    
			    try {
			    	feed = input.build(new XmlReader(stream2));
			    } catch (FeedException e2) {
			    	//unicode
			    	e2.printStackTrace();
			    }
			    
			    stream2.close();
			    response2.close();
			    client2.close();
			    
		    }
		    
		    stream1.close();
		    response1.close();
		    client1.close();
		    
		} catch (IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		//System.out.println(url);
		return feed;
	}
}