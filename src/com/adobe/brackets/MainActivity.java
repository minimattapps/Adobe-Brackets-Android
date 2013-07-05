package com.adobe.brackets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.Menu;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends Activity {

	BracketsBrowser myBrowser;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		myBrowser = (BracketsBrowser)findViewById(R.id.webView1);
		myBrowser.initKeys();
		myBrowser.getSettings().setJavaScriptEnabled(true);
		myBrowser.getSettings().setDomStorageEnabled(true);
		myBrowser.addJavascriptInterface(new WebAppInterface(this), "Android");
		myBrowser.loadUrl("file:///android_asset/src/index.html");
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
       
	}
	


	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public class WebAppInterface {
	    Context mContext;

	    /** Instantiate the interface and set the context */
	    WebAppInterface(Context c) {
	        mContext = c;
	    }

	    /** Show a toast from the web page */
	    @JavascriptInterface
	    public void showToast(String toast) {
	        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
	    }
	    
	    @JavascriptInterface
	    public String ListFiles(String path) {
	    	File sd = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Brackets" + path);
            sd.mkdirs();
            //gets a list of the files
	   
            File[] sdDirList = sd.listFiles();
            String result = "";
            for (int i = 0; i < sdDirList.length;i++){
            	if (i == 0){
            		result = sdDirList[i].getName();
            	} else {
            		result = result + "," + sdDirList[i].getName();
            	}
            }
	        return result;
	    }
	    
	    @JavascriptInterface
	    public String Stat(String path) {
	    	File sd = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Brackets" + path);
	    	if (sd.exists()){
	    	return String.valueOf(sd.isFile()) + ":" + String.valueOf(sd.isDirectory()) + ":" + String.valueOf(sd.lastModified());
	    	}
	    	return "ERROR";
	    }
	    
	    @JavascriptInterface
	    public void CreateDirectory(String path) {
	    	

	    	File sd = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Brackets" + path);
	    	sd.mkdir();
	    
	    }
	    
	    @JavascriptInterface
	    public void Rename(String oldPath,String newPath) {
	    	
	    	File oldfile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Brackets" + oldPath);
	    	File newfile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Brackets" + newPath);
            oldfile.renameTo(newfile);
	    
	    }
	    
	    @JavascriptInterface
	    public void WriteFile(String path,String data) {
	    	
	    	if (data == null){
	    		data = "";
	    	}
	    	 try {
	 	    	File sd = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Brackets" + path);
	 	    	
	    		 FileWriter filewriter = new FileWriter(sd);
	             BufferedWriter out = new BufferedWriter(filewriter);
	          
	                 out.write(data);
	           
	          
	             out.close();
	    	    }
	    	    catch (IOException e) {
	    	        Log.e("Exception", "File write failed: " + e.toString());
	    	    } 
	    }
	    
	    @JavascriptInterface
	    public String ReadFile(String path) {
	    	File sd = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Brackets" + path);
	    	try {
				FileInputStream fin = new FileInputStream(sd);
				BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
			    StringBuilder sb = new StringBuilder();
			    String line = null;
			    while ((line = reader.readLine()) != null) {
			      sb.append(line).append("\n");
			    }
			    return sb.toString();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return "";
	    }
	    
	    
	}

}


