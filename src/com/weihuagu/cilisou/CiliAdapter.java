package com.weihuagu.cilisou;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CiliAdapter extends BaseAdapter {
	private List<CiliInfo> ciliList=new ArrayList<CiliInfo>();
	private Context mContext;
	public void setContext(Context context){
    	this.mContext=context;
    }
	public void addCiliList(List<CiliInfo> cili) {
		for(int i=0;i<cili.size();i++){
        this.ciliList.add(cili.get(i));
		}
     }
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ciliList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return this.ciliList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View arg1, ViewGroup parent) {
		// TODO Auto-generated method stub
		 View view = arg1;
		 ViewHolder viewHolder;
		 if (arg1 == null) {
             view = LayoutInflater.from(mContext).inflate(R.layout.listview_row_item, parent, false);
             viewHolder = new ViewHolder();
            // viewHolder.iv_img = (MyImageView ) view.findViewById(R.id.img);
             viewHolder.title = (TextView) view.findViewById(R.id.title);
             view.setTag(viewHolder);
         } else {
             viewHolder = (ViewHolder) view.getTag();
         }
		 CiliInfo cili=this.ciliList.get(position);
		 String cilititle=cili.getMagnet();
		 if(cilititle!=null){
			 viewHolder.title.setText(cilititle);
		 }
		return view;
	}
	
	
	private  class ViewHolder {
		TextView title;
    }

}
