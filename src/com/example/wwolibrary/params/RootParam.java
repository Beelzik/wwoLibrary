package com.example.wwolibrary.params;

import java.lang.reflect.Field;
import java.net.URLEncoder;

import android.util.Log;

class RootParams{
	public String getQueryString(Class  cls ) throws Exception{
	
		Field[] fields=cls.getFields();
		StringBuilder builder=null;
		for (Field field : fields) {
			Object fildObject=field.get(this);
				if(fildObject!=null){
				if(builder==null){
					Log.d("myLogs","builder==null");
					builder=new StringBuilder();
					builder=builder.append("?");
					builder.append(URLEncoder.encode(field.getName(),"UTF-8"));
					builder.append("=");
					builder.append(URLEncoder.encode(fildObject.toString(),"UTF-8"));
				}else{
					Log.d("myLogs","builder!=null");
					builder=builder.append("&");
					builder.append(URLEncoder.encode(field.getName(),"UTF-8"));
					builder.append("=");
					builder.append(URLEncoder.encode(fildObject.toString(),"UTF-8"));
				}
				}
			
		}
		return builder.toString();
	}
	}
