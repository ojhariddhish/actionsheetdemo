package com.movivation.actionsheetdemo;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class ActionSheetDemoActivity extends Activity {
	
	private static final String tag = "ActionSheetDemoActivity";
	private int width;
	private WindowManager.LayoutParams params;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        width = metrics.widthPixels;
        Log.i(tag, "Height : "+metrics.heightPixels+" Width : "+width);
        
        params = getWindow().getAttributes();
		params.width = width;
        
    }
    
    public void showActionSheet(View v) {
    	final Dialog myDialog = new Dialog(ActionSheetDemoActivity.this, R.style.CustomTheme);
		myDialog.setContentView(R.layout.actionsheet);

		TextView tvNewPhoto = (TextView) myDialog.findViewById(R.id.tvButtonExample);
		tvNewPhoto.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				myDialog.dismiss();
				Toast.makeText(getApplicationContext(), "ActionSheet Example Button Clicked", Toast.LENGTH_LONG).show();
			}
		});

		TextView tvCancel = (TextView) myDialog.findViewById(R.id.tvCancel);
		tvCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				myDialog.dismiss();
			}
		});

		myDialog.getWindow().getAttributes().width = width;
		Log.i(tag, "Action Sheet created");
		
		myDialog.show();
		myDialog.getWindow().setGravity(Gravity.BOTTOM);
    }
}