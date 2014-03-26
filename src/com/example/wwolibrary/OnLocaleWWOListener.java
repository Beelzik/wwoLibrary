package com.example.wwolibrary;

import com.example.wwolibrary.LocaleWwoData.Data.CurrentCondition;
import com.example.wwolibrary.LocaleWwoData.Data.NearestArea;
import com.example.wwolibrary.LocaleWwoData.Data.Request;
import com.example.wwolibrary.LocaleWwoData.Data.Weather;


public interface OnLocaleWWOListener {

	public void localeWWOListener(CurrentCondition cc, NearestArea nearestArea, Request request, Weather[] weather);
}
