package com.weihuagu.cilisou;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public abstract class CiliButton extends ImageButton {
    private String link;
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public CiliButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
	}
	public abstract String linktype();
		

}
