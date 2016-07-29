package com.weihuagu.cilisou;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
    private Button search;
    private EditText input;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.initUiResouces();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		/**
		if (id== R.id.action_about){
			Intent startabout=new Intent(this,AboutActivity.class);
			startActivity(startabout);
			return true;
		}
		**/
		return super.onOptionsItemSelected(item);
	}
	public void initUiResouces(){
		this.search=(Button)findViewById(R.id.serach);
		this.input=(EditText)findViewById(R.id.input);
		
	}
	public void serachClick(View v){
		String value = this.input.getText().toString();  
        //trim() 表示输入前后空格  
        if(value == null || value.trim().equals("")){  
            this.input.setError("请输入内容！");  
            return;  
        }else
        {
    	Intent startsearch=new Intent(MainActivity.this,SearchActivity.class);
		startsearch.putExtra("searchkey",value );
		MainActivity.this.startActivity(startsearch);
        }
	}
}
