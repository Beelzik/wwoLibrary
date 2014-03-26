package com.example.wwolibrary.LocaleWwoData;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.wwolibrary.params.LocaleWeatherParam;


public class Data{


	public CurrentCondition current_condition=null;
	public NearestArea nearest_area=null;
	public Weather weather[]=null;
	public Request request;
	
	public CurrentCondition getCurrent_condition() {
		return current_condition;
	}

	public NearestArea getNearest_area() {
		return nearest_area;
	}

	public Weather[] getWeather() {
		return weather;
	}

	public Request getRequest() {
		return request;
	}

	public Data(JSONObject data,LocaleWeatherParam param) throws Exception {
		
		current_condition=new CurrentCondition(data.getJSONArray("current_condition"));
		request=new Request(data.getJSONArray("request"));
		
		if(param.getFx().equalsIgnoreCase("yes")){
			weather=new Weather[param.getNumOfDays()];
			JSONArray array=data.getJSONArray("weather");
			for (int i = 0; i < weather.length; i++) {
				JSONObject object=array.getJSONObject(i);
				weather[i]=new Weather(object);
			}
			
		}
		
		if (param.getIncludelocation().equalsIgnoreCase("yes")) {
			nearest_area=new NearestArea(data.getJSONArray("nearest_area"));
		}
		
		
	}
	
	public Data() {
		request=new Request();
	}
	
	public Data(CurrentCondition current_condition, NearestArea nearest_area,
	Weather weather[],Request request){
		this.current_condition=current_condition;
		this.nearest_area=nearest_area;
		this.weather=weather;
		this.request=request;
	}
	
	public class CurrentCondition{

		int cloudcover;
		 int humidity;
		 String observation_time;
		 double precipMM;
		 int pressure;
		 int temp_C;
		 int temp_F;
		 int visibility;
		 int weatherCode;
		 String weatherDesc;
		 String weatherIconUrl;
		 String winddir16Point;
		 int winddirDegree;
		 int windspeedMiles;
		 int windspeedKmph;
		 
		 
		 public CurrentCondition(JSONArray arrayCurrentCondition) throws Exception {
			 JSONObject cc=arrayCurrentCondition.getJSONObject(0);
			 
			 cloudcover=cc.getInt("cloudcover");
			 humidity=cc.getInt("humidity");
			 observation_time=cc.getString("observation_time");
			 precipMM=cc.getDouble("precipMM");
			 pressure=cc.getInt("pressure");
			 temp_C=cc.getInt("temp_C");
			 temp_F=cc.getInt("temp_F");
			 visibility=cc.getInt("visibility");
			 weatherCode=cc.getInt("weatherCode");
			 
			 JSONArray  array=cc.getJSONArray("weatherDesc");
			 JSONObject object=array.getJSONObject(0);
			 
			 weatherDesc=object.getString("value");
			 
			 array=cc.getJSONArray("weatherIconUrl");
			 object=array.getJSONObject(0);
			 
			 weatherIconUrl=object.getString("value");
			 winddir16Point=cc.getString("winddir16Point");
			 winddirDegree=cc.getInt("winddirDegree");
			 windspeedMiles=cc.getInt("windspeedMiles");
			 windspeedKmph=cc.getInt("windspeedKmph");
		}
		 
		 @Override
		public String toString() {
			 String str="cloudcover: "+cloudcover+
			 "\nhumidity: "+humidity+
			 "\nobservation_time: "+ observation_time+
			 "\nprecipMM: "+precipMM+
			 "\npressure: "+pressure+
			 "\ntemp_C: "+temp_C+
			 "\ntemp_F: "+temp_F+
			 "\nvisibility: "+visibility+
			 "\nweatherCode: "+weatherCode+
			 "\nweatherDesc: "+weatherDesc+
			 "\nweatherIconUrl: "+weatherIconUrl+
			 "\nwinddir16Point: "+winddir16Point+
			"\nwinddirDegree: "+winddirDegree+
			 "\nwindspeedMiles: "+windspeedMiles+
			 "\nwindspeedKmph: "+windspeedKmph;
			return str;
		}
		 
		 public int getCloudcover() {
				return cloudcover;
			}

			public int getHumidity() {
				return humidity;
			}

			public String getObservation_time() {
				return observation_time;
			}

			public double getPrecipMM() {
				return precipMM;
			}

			public int getPressure() {
				return pressure;
			}

			public int getTemp_C() {
				return temp_C;
			}

			public int getTemp_F() {
				return temp_F;
			}

			public int getVisibility() {
				return visibility;
			}

			public int getWeatherCode() {
				return weatherCode;
			}

			public String getWeatherDesc() {
				return weatherDesc;
			}

			public String getWeatherIconUrl() {
				return weatherIconUrl;
			}

			public String getWinddir16Point() {
				return winddir16Point;
			}

			public int getWinddirDegree() {
				return winddirDegree;
			}

			public int getWindspeedMiles() {
				return windspeedMiles;
			}

			public int getWindspeedKmph() {
				return windspeedKmph;
			}
	}	

	public class NearestArea{
		
		String areaName;
		String country;
		double latitude;
		double longitude;
		long population;
		String region;
		String weatherUrl;
		
		public NearestArea(JSONArray arrayArea) throws Exception {
			JSONObject areaObj=arrayArea.getJSONObject(0);
			
			 JSONArray  array=areaObj.getJSONArray("areaName");
			 JSONObject object=array.getJSONObject(0);
			
			areaName=object.getString("value");
			
			array=areaObj.getJSONArray("country");
			object=array.getJSONObject(0);
			 
			country=object.getString("value");
			latitude=areaObj.getDouble("latitude");
			longitude=areaObj.getDouble("longitude");
			population=areaObj.getLong("population");
			
			array=areaObj.getJSONArray("region");
			object=array.getJSONObject(0);
			
			 region=object.getString("value");
			 
			array=areaObj.getJSONArray("weatherUrl");
			object=array.getJSONObject(0);
				
			weatherUrl=object.getString("value");
		}
		
		public String getAreaName() {
			return areaName;
		}

		public String getCountry() {
			return country;
		}

		public double getLatitude() {
			return latitude;
		}

		public double getLongitude() {
			return longitude;
		}

		public long getPopulation() {
			return population;
		}

		public String getRegion() {
			return region;
		}

		public String getWeatherUrl() {
			return weatherUrl;
		}

	}
	
public class Request{
		public boolean isConnect=false;
		String type;
		String query;
		
		public Request(JSONArray jsonArray) throws Exception {
			JSONObject reqObj=jsonArray.getJSONObject(0);
			type=reqObj.getString("type");
			query=reqObj.getString("query");
			isConnect=true;
		}

		public Request() {
		}
		
		public boolean isConnect() {
			return isConnect;
		}

		public String getType() {
			return type;
		}

		public String getQuery() {
			return query;
		}
	}

	
public class Weather{
		String date;
		Double precipMM;
	    int tempMaxC;
	    int tempMaxF;
	    int tempMinC;
	    int tempMinF;
	    int weatherCode;
	    String weatherDesc;
	    String weatherIconUrl;
	    String winddir16Point;
	    int winddirDegree;
	    String winddirection;
	    int windspeedKmph;
	    int windspeedMiles;
	    
	    
	    public Weather(JSONObject object) throws Exception {
	    	
	    	date=object.getString("date");
	    	precipMM=object.getDouble("precipMM");
	    	tempMaxC=object.getInt("tempMaxC");
	    	tempMaxF=object.getInt("tempMaxF");
	    	tempMinC=object.getInt("tempMinC");
	    	tempMinF=object.getInt("tempMinF");
	    	weatherCode=object.getInt("weatherCode");
	    	
	    	JSONArray  array=object.getJSONArray("weatherDesc");
			 JSONObject obj=array.getJSONObject(0);
			 
			 weatherDesc=obj.getString("value");
			 
			 array=object.getJSONArray("weatherIconUrl");
			 obj=array.getJSONObject(0);
			 
			 weatherIconUrl=obj.getString("value");
			 
			 winddir16Point=object.getString("winddir16Point");
			 winddirDegree=object.getInt("winddirDegree");
			 winddirection=object.getString("winddirection");
			 windspeedKmph=object.getInt("windspeedKmph");
			 windspeedMiles=object.getInt("windspeedMiles");
			 
		}
	    
		public String getDate() {
			return date;
		}


		public Double getPrecipMM() {
			return precipMM;
		}


		public int getTempMaxC() {
			return tempMaxC;
		}


		public int getTempMaxF() {
			return tempMaxF;
		}


		public int getTempMinC() {
			return tempMinC;
		}


		public int getTempMinF() {
			return tempMinF;
		}


		public int getWeatherCode() {
			return weatherCode;
		}


		public String getWeatherDesc() {
			return weatherDesc;
		}


		public String getWeatherIconUrl() {
			return weatherIconUrl;
		}


		public String getWinddir16Point() {
			return winddir16Point;
		}


		public int getWinddirDegree() {
			return winddirDegree;
		}


		public String getWinddirection() {
			return winddirection;
		}


		public int getWindspeedKmph() {
			return windspeedKmph;
		}


		public int getWindspeedMiles() {
			return windspeedMiles;
		}
	} 

}
