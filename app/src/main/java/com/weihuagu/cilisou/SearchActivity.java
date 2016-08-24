package com.weihuagu.cilisou;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

public class SearchActivity extends Activity implements AsyncResponse{
	private String keyword=null;
	private List<CiliInfo> ciliList=new ArrayList<CiliInfo>();
	private CiliAdapter mAdapter=null;
	private ListView cililistview=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		this.getIntentData();
		this.initUiResouces();
		this.getCiliList(this.keyword);
	}
	public void getIntentData(){
		Intent intent=getIntent();
	    this.keyword=intent.getStringExtra("searchkey");
	    Toast toast=Toast.makeText(this, "搜索需要一定时间，请耐心等待"+this.keyword, Toast.LENGTH_SHORT); 
		toast.show();    
     }
	
	public void initUiResouces(){
		this.cililistview=(ListView)findViewById(R.id.cililist);
		
	}
	public void getCiliList(String keyword){
		SearchTask mtask = new SearchTask();
		mtask.setOnAsyncResponse(this);
		mtask.execute(keyword);
		
	}
	@Override
	public void onDataReceivedSuccess(List<CiliInfo> cililist) {
		// TODO Auto-generated method stub
		if(cililist!=null){
			for(int i=0;i<cililist.size();i++){
				if(cililist.get(i)!=null){
				this.ciliList.add(cililist.get(i));
				}
					
			}
			//load adapter
			
			this.mAdapter=new CiliAdapter();
			this.mAdapter.setContext(getBaseContext());
			this.mAdapter.addCiliList(this.ciliList);
			this.cililistview.setAdapter(this.mAdapter);
	   }
		
	}
	@Override
	public void onDataReceivedFailed() {
		// TODO Auto-generated method stub
		Toast toast=Toast.makeText(this, "接受数据失败了", Toast.LENGTH_SHORT); 
		toast.show();     
	}
}
