package com.example.rsstest.models;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

@Service
public class RssReader {
	
	public SyndFeed readRss(String url) {
		
		SyndFeed feed = null;
		
		try {
			CloseableHttpClient client1 = HttpClients.createMinimal();
		    HttpUriRequest method1 = new HttpGet(url);
		    CloseableHttpResponse response1 = client1.execute(method1);
		    InputStream stream1 = response1.getEntity().getContent();
		    SyndFeedInput input = new SyndFeedInput();
		    
		    feed = input.build(new XmlReader(stream1));
			//feed = new SyndFeedInput().build(new XmlReader(new URL(url)));
		    
		    stream1.close();
		    response1.close();
		    client1.close();
		    
		} catch (IllegalArgumentException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		} catch (FeedException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}
		
		//System.out.println(url);
		return feed;
	}
}