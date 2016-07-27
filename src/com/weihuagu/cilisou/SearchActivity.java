package com.weihuagu.cilisou;

import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SearchActivity extends Activity implements AsyncResponse{
	private String keyword=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		this.initUiResouces();
	}
	public void getIntentData(){
		Intent intent=getIntent();
	    this.keyword=intent.getStringExtra("searchkey");
     }
	
	public void initUiResouces(){
		
	}
	public void getCiliList(String keyword){
		SearchTask mtask = new SearchTask();
		mtask.setOnAsyncResponse(this);
		mtask.execute(keyword);
		
	}
	@Override
	public void onDataReceivedSuccess(List<CiliInfo> cililist) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onDataReceivedFailed() {
		// TODO Auto-generated method stub
		
	}

}
