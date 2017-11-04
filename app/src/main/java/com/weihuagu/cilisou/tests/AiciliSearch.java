/*
 * Created By WeihuaGu (email:weihuagu_work@163.com)
 * Copyright (c) 2017
 * All right reserved.
 */

package com.weihuagu.cilisou.tests;

import com.weihuagu.cilisou.CiliInfo;
import com.weihuagu.cilisou.ISearch;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17-11-4.
 */
public class AiciliSearch implements ISearch {
    public int pagenum=1;
    public String baseurl="http://www.2cili.com/search/";
    private List<CiliInfo> sumlist=null;


    public List<CiliInfo> getSearch(String key) {
        // TODO Auto-generated method stub
        List<CiliInfo> templist=null;
        sumlist=new ArrayList<CiliInfo>();
        for(int i=1;i<=this.pagenum;i++){
            templist=getSearch(key,i);
            if(templist!=null){
                for(int j=0;j<templist.size();j++){
                    sumlist.add(templist.get(j));
                }
            }

        }
        return sumlist;
    }

    public List<CiliInfo> getSearch(String key,int pagenum){
        try {
            String keyword=key+"_ctime_"+pagenum+".html";
            String pageUrl=this.baseurl+ URLEncoder.encode(keyword, "UTF-8");
            Document doc = Jsoup.connect(pageUrl)
                    .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:47.0) Gecko/20100101 Firefox/47.0")
                    .timeout(10000)
                    .get();
            String title = doc.title();
            Elements urls = doc.select("li.media");
            if(urls.isEmpty()==true)
                System.out.println("search null");

            List<CiliInfo> ciliList = new ArrayList<CiliInfo>();
            CiliInfo ciliInfo;
            for (Element url : urls) {
                ciliInfo=new CiliInfo();
                String itemtitle=url.select("h4").select("a.title").text();
                ciliInfo.setTitle(itemtitle);
                String itemmagnet=url.select("span.glyphicon").select("a[href^=magnet]").attr("href");
                ciliInfo.setMagnet(itemmagnet);
               // String itemthender=url.select("div.item-bar").select("a.download[href^=thunder]").attr("href");
                //ciliInfo.setThunder(itemthender);
                ciliList.add(ciliInfo);
            }
            return ciliList;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}
