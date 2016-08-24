package com.weihuagu.cilisou;

import java.util.ArrayList;
import java.util.List;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class CiliAdapter extends BaseAdapter implements View.OnClickListener{
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
          
             viewHolder.title = (TextView) view.findViewById(R.id.title);
             viewHolder.magnetbutton=(MagnetButton)view.findViewById(R.id.magnet);
             viewHolder.thunterbutton=(ThunderButton)view.findViewById(R.id.thunder);
             view.setTag(viewHolder);
         } else {
             viewHolder = (ViewHolder) view.getTag();
         }
		 CiliInfo cili=this.ciliList.get(position);
		 String cilititle=cili.getTitle();
		 String magnetlink=cili.getMagnet();
		 String thunderlink=cili.getThunder();
		 if(cilititle!=null){
			 viewHolder.title.setText(cilititle);
		 }
		 if(magnetlink!=null){
			 viewHolder.magnetbutton.setLink(magnetlink);
		     viewHolder.magnetbutton.setOnClickListener(this);
		 }
		 if(thunderlink!=null){
			 viewHolder.thunterbutton.setLink(thunderlink);
		     viewHolder.thunterbutton.setOnClickListener(this);
		 }
		return view;
	}
	
	
	private  class ViewHolder {
		TextView title;
		CiliButton magnetbutton;
		CiliButton thunterbutton;
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		CiliButton button=(CiliButton)v;
		String link=button.getLink();
		ClipboardManager clip = (ClipboardManager)this.mContext.getSystemService(Context.CLIPBOARD_SERVICE);
		clip.setText(link); // 复制
		Toast toast=Toast.makeText(this.mContext, "链接已经复制到剪贴版", Toast.LENGTH_SHORT); 
		if(clip.getText()!=null)
		  toast.show();  
		if(button.linktype()=="magnet"){
			Toast magnetsource=Toast.makeText(this.mContext, "磁力链接不行的化，试试迅雷链接", Toast.LENGTH_SHORT);     
			magnetsource.show();
		}else{
			Toast thundersource=Toast.makeText(this.mContext, "迅雷链接不行的化，试试磁力链接", Toast.LENGTH_SHORT);     
			thundersource.show();
		}
		
		
	}

}
