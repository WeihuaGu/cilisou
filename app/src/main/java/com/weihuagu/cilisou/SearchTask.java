package com.weihuagu.cilisou;

import java.util.List;

import android.os.AsyncTask;

import com.weihuagu.cilisou.tests.AiciliSearch;

public class SearchTask extends AsyncTask<String, Void, List<CiliInfo>> {
	
	 public AsyncResponse asyncResponse;    
     public void setOnAsyncResponse(AsyncResponse asyncResponse)
     {
         this.asyncResponse = asyncResponse;
     }

	@Override
	protected List<CiliInfo> doInBackground(String ... key) {
		// TODO Auto-generated method stub
	    String keyword = key[0];

        // BtanySearch search=new BtanySearch();
        AiciliSearch search=new AiciliSearch();
		List<CiliInfo> ciliList = search.getSearch(keyword);
		return ciliList;	
	}
	
	@Override
    protected void onPostExecute(List<CiliInfo> cililist) {          
        super.onPostExecute(cililist);       
        if (cililist != null)
        {               
            asyncResponse.onDataReceivedSuccess(cililist);//将结果传给回调接口中的函数
        }
        else {
            asyncResponse.onDataReceivedFailed();
        }

    }               

}
