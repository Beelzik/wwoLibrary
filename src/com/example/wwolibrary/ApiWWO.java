package com.example.wwolibrary;




import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class ApiWWO {

	
	public static final String API_KEY="fyr6gaqmee3pe4pc5fwk5mzw";
	
	String apiQuery;
	String key;
	
	
	private void setApiQuery(String query){
		apiQuery=query;
	}
	
	public void setKey(String key){
		this.key=key;
	}

	public String makeServiseCall(String url){
		Log.d("myLogs","url: "+url);
		try {
		String answer;
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpEntity httpEntity = null;
        HttpResponse httpResponse = null;
        
        HttpGet httpGet=new HttpGet(url);
        
			httpResponse=httpClient.execute(httpGet);
			httpEntity=httpResponse.getEntity();
			answer=EntityUtils.toString(httpEntity);
			
			Log.d("myLogs","answer: "+answer);
		return answer;	
		} catch (Exception e) {
		return null;
		}
	}

}
