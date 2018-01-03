/*
 * Created By WeihuaGu (email:weihuagu_work@163.com)
 * Copyright (c) 2018
 * All right reserved.
 */

package com.weihuagu.cilisou;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 18-1-3.
 */
public class TorrentkittySearch implements ISearch{
    public String baseurl="https://www.torrentkitty.tv/search/";
    private List<CiliInfo> sumlist=null;
    public int pagenum=1;


    public int getPageNum(String key) {
        String keyword = key;
        int maxnum=-1;
        try {
            String pageUrl = this.baseurl + URLEncoder.encode(keyword, "UTF-8");
            Document doc = Jsoup.connect(pageUrl)
                    .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:47.0) Gecko/20100101 Firefox/47.0")
                    .timeout(10000)
                    .get();
            String title = doc.title();
            Elements pagealink = doc.select("div.pagination").select("a");
            for (Element link : pagealink){
                String tmpnum=link.text();
                System.out.println(tmpnum);
                int num=Integer.parseInt(tmpnum);
                if (num>=maxnum)
                    maxnum=num;

            }
                return maxnum;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }


    }

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
            String keyword=key;
            String pageUrl=this.baseurl+ URLEncoder.encode(keyword, "UTF-8")+"/"+pagenum;
            Document doc = Jsoup.connect(pageUrl)
                    .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:47.0) Gecko/20100101 Firefox/47.0")
                    .timeout(10000)
                    .get();
            String title = doc.title();
            Elements table = doc.select("table#archiveResult");
            Elements urls=table.select("a[href^=magnet]");
            if(urls.isEmpty()==true)
                System.out.println("search null");

            List<CiliInfo> ciliList = new ArrayList<CiliInfo>();
            CiliInfo ciliInfo;
            for (Element url : urls) {
                ciliInfo=new CiliInfo();
                String itemtitle=url.attr("title");
                ciliInfo.setTitle(itemtitle);
                String itemmagnet=url.attr("href");
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
