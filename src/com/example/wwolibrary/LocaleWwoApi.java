package com.example.wwolibrary;

import org.json.JSONObject;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.wwolibrary.LocaleWwoData.Data;
import com.example.wwolibrary.params.LocaleWeatherParam;




public class LocaleWwoApi extends ApiWWO {
	
	final String FREE_WWO_API= "http://api.worldweatheronline.com/free/v1/weather.ashx";
	final int HANDLE_MSG_OK=1;
	final int HANDLE_MSG_ERROR=0;
	OnLocaleWWOListener onLocaleWWOListener;
	
	Handler handler=new Handler(){
		
		@Override
		public void handleMessage(Message msg) {
			Data data;
			switch(msg.what){
			case HANDLE_MSG_OK:
				Log.d("myLogs", "HANDLE_MSG_OK");
				data=(Data) msg.obj;
			onLocaleWWOListener.localeWWOListener(data.getCurrent_condition(),
						data.getNearest_area(), data.getRequest(), data.getWeather());
			break;
			case HANDLE_MSG_ERROR:
				Log.d("myLogs", "HANDLE_MSG_ERROR");
				data=new Data();
				onLocaleWWOListener.localeWWOListener(null,null,data.getRequest(),null);
				break;
			}
			super.handleMessage(msg);
		}
	};
	
	public void setOnLocaleWWOListener(OnLocaleWWOListener listener){
		onLocaleWWOListener=listener;
	}
	
	public void callApi(final LocaleWeatherParam param)  {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				String query="";
				try {
					query = param.getQueryString(LocaleWeatherParam.class);
				
				Log.d("myLogs","query: "+query);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					
				
				String url=FREE_WWO_API+query;
				String json;
				if(!(json=makeServiseCall(url)).equals(null)){
					JSONObject jsonObject=new JSONObject(json);
					JSONObject jsonData=jsonObject.getJSONObject("data");
					
					Log.d("myLogs", "jsonData: "+jsonData.toString());
					Data data=new Data(jsonData,param);	
					
					Message message=handler.obtainMessage(HANDLE_MSG_OK, data);
					handler.sendMessage(message);
					
				}
				} catch (Exception e) {
					e.printStackTrace();
					Message message=handler.obtainMessage(HANDLE_MSG_ERROR);
					handler.sendMessage(message);
					
				}
			}
		}).start();
		
	}

}
