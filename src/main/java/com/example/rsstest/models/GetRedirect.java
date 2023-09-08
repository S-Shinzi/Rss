package com.example.rsstest.models;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class GetRedirect {

  public String GetUrl(String srcUrl) throws IOException {

    // get redirect url
    String redirectUrl = getRedirectUrl(srcUrl);

    return redirectUrl;
  }

  // get redirect url
  public static String getRedirectUrl(String srcUrl) throws IOException {
    // 4xx や 5xx でも例外が発生しないので注意
    HttpURLConnection con = (HttpURLConnection) new URL(srcUrl).openConnection();
    con.setRequestMethod("GET");
    con.setInstanceFollowRedirects(false); // 自動でリダイレクトしない設定
    con.connect();
    // HTTP レスポンスから Location ヘッダを取得
    String location = con.getHeaderField("location");
    con.disconnect();
    return location;
  }
}