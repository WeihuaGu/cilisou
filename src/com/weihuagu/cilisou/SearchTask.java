package com.weihuagu.cilisou;

import android.os.AsyncTask;

public class SearchTask extends AsyncTask<Integer, Void, String[]> {
	
	 public AsyncResponse asyncResponse;    
     public void setOnAsyncResponse(AsyncResponse asyncResponse)
     {
         this.asyncResponse = asyncResponse;
     }

	@Override
	protected String[] doInBackground(Integer ... kindtype) {
		// TODO Auto-generated method stub
	   
		return null;	
	}
	
	@Override
    protected void onPostExecute(String[] accouts) {          
        super.onPostExecute(accouts);       
        if (accouts != null)
        {               
            asyncResponse.onDataReceivedSuccess(accouts);//将结果传给回调接口中的函数
        }
        else {
            asyncResponse.onDataReceivedFailed();
        }

    }               

}
