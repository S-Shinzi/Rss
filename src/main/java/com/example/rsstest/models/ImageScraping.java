package com.example.rsstest.models;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rsstest.domains.ImageModel;
import com.example.rsstest.domains.Site;


@Service
public class ImageScraping {
	
	@Autowired
	private UrlToEx urlToEx;
	
	public List<ImageModel> returnImages(String url, List<Site> sites) {
		
		org.jsoup.nodes.Document document = null;
		
		List<ImageModel> imageModel = new ArrayList<ImageModel>();

		try {
			CloseableHttpClient client = HttpClients.createMinimal();
			HttpUriRequest method = new HttpGet(url);
			CloseableHttpResponse response = client.execute(method);
			document = Jsoup.parse(EntityUtils.toString(response.getEntity(), "UTF-8"));
			
			response.close();
			client.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			for (int i=0; i<urlToEx.returnParses(url, sites).size(); i++) {
				org.jsoup.select.Elements elements = document.select(urlToEx.returnParses(url, sites).get(i).getElement_parse());	
				int imageCount = 0;
				
				for (Element element : elements) {
					ImageModel model = new ImageModel(element.attr(urlToEx.returnParses(url, sites).get(i).getAttribute_parse()));
					
					if (imageCount > 3) {
						break;
					}
					if (model.getUrl() == "") {
						imageCount++;
						continue;
					}
					imageModel.add(model);
				}
			}
		} catch (URISyntaxException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		return imageModel;
	}
}
