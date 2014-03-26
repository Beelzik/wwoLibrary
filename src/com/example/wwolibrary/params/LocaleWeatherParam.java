package com.example.wwolibrary.params;


public class LocaleWeatherParam extends RootParams{
		
		public final String q;
		public final String key;
		public  String format;
		public  String extra ;
		public Integer num_of_days;
		public String date;
		public String fx;
		public String cc;
		public String includelocation;
		public  String show_comments;
		public  String callback;
		
	public LocaleWeatherParam(Builder builder) {
		this.q=builder.q;
		this.key=builder.key;
		this.format=builder.format;
		this.extra=builder.extra;
		this.num_of_days=builder.num_of_days;
		this.date=builder.date;
		this.fx=builder.fx;
		this.cc=builder.cc;
		this.includelocation=builder.includelocation;
		this.show_comments=builder.show_comments;
		this.callback=builder.callback;	
	}
	
	public int getNumOfDays(){
		return num_of_days;
	}
	
	public String getIncludelocation(){
		return includelocation;
	}
	
	public String getFx(){
		return fx;
	}
		public static class Builder{
			
			private final String q;
			private  final String key;
			String format="JSON";
			String extra ;
			Integer num_of_days=1;
			String date;
			String fx="yes";
			String cc;
			String includelocation="yes";
			String show_comments="no";
			String callback;
			
			public Builder(String q,String key) {
				this.q=q;
				this.key=key;
			}
			
			public Builder setFormat(String format){
				this.format=format;
				return this;
				
			}
			public Builder  setExtra (String extra){
				this.extra=extra;
				return this;
			}
			public Builder  setNum_of_days(int num_of_days){
				this.num_of_days=num_of_days;
				return this;
			}
			public Builder setDate(String  date){
				this.date= date;
				return this;
			}
			public Builder setFx(String fx){
				this.fx=fx;
				return this;
			}
			public Builder  setCc(String cc){
				this.cc=cc;
				return this;
			}
			public Builder setIncludelocation(String includelocation){
				this.includelocation=includelocation;
				return this;
			}
			public Builder setShow_comments(String show_comments){
				this.show_comments=show_comments;
				return this;
			}
			public Builder setCallback(String callback){
				this.callback=callback;
				return this;
			}
			
			public LocaleWeatherParam build(){
				return new LocaleWeatherParam(this);
			}
			
			
		}
		
	
	}

