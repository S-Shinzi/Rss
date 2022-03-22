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
    // 4xx �� 5xx �ł���O���������Ȃ��̂Œ���
    HttpURLConnection con = (HttpURLConnection) new URL(srcUrl).openConnection();
    con.setRequestMethod("GET");
    con.setInstanceFollowRedirects(false); // �����Ń��_�C���N�g���Ȃ��ݒ�
    con.connect();
    // HTTP ���X�|���X���� Location �w�b�_���擾
    String location = con.getHeaderField("location");
    con.disconnect();
    return location;
  }
}