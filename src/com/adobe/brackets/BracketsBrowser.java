package com.adobe.brackets;

import android.content.Context;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.webkit.WebView;

public class BracketsBrowser extends WebView {

	public BracketsBrowser(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public BracketsBrowser(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public BracketsBrowser(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	
	
	public void initKeys(){
		this.setOnKeyListener(new KeyListen());
		
	}

	
	
	 
	   
	    


	
	

	

}
