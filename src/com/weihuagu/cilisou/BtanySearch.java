package com.weihuagu.cilisou;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import android.util.Log;

public class BtanySearch implements ISearch {
	public int pagenum=6;
	public String baseurl="http://www.btany.com/search/";
    private List<CiliInfo> sumlist=null;
   
	@Override
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
			String keyword=key+"-first-asc-"+pagenum;
        	String pageUrl=this.baseurl+URLEncoder.encode(keyword, "UTF-8");
            Document doc = Jsoup.connect(pageUrl)
            		.userAgent("Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:47.0) Gecko/20100101 Firefox/47.0") 
                    .timeout(10000)
                    .get();
            String title = doc.title();
            Elements urls = doc.select("div.search-item");
            if(urls.isEmpty()==true)
            	System.out.println("search null");
            
            List<CiliInfo> ciliList = new ArrayList<CiliInfo>();
            CiliInfo ciliInfo;
            for (Element url : urls) {
               ciliInfo=new CiliInfo();
               String itemtitle=url.select("div.item-title").select("a").text();
               ciliInfo.setTitle(itemtitle);
               String itemmagnet=url.select("div.item-bar").select("a.download[href^=magnet]").attr("href");
               ciliInfo.setMagnet(itemmagnet);
               String itemthender=url.select("div.item-bar").select("a.download[href^=thunder]").attr("href");
               ciliInfo.setThunder(itemthender);
                ciliList.add(ciliInfo);
            }
            return ciliList;
            
            }catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
		
	}
	

}
