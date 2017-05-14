package com.zerofate.andoroid.coolweather.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.zerofate.andoroid.coolweather.db.City;
import com.zerofate.andoroid.coolweather.db.County;
import com.zerofate.andoroid.coolweather.db.Province;
import com.zerofate.andoroid.coolweather.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zero on 2017/5/14.
 */

public class Utility {
    public static Weather handleWeatherReponse(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent, Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }
    public static boolean handleProvinceResponse(String response) {
        if (TextUtils.isEmpty(response)) {
            return false;
        }
        try {
            JSONArray allProvinces = new JSONArray(response);
            for (int i = 0; i < allProvinces.length();i++){
                JSONObject provinceObject = allProvinces.getJSONObject(i);
                Province province = new Province();
                province.setProvinceName(provinceObject.getString("name"));
                province.setProvinceCode(provinceObject.getInt("id"));
                province.save();
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }public static boolean handleCityResponse(String response, int provinceId) {
        if (TextUtils.isEmpty(response)) {
            return false;
        }
        try {
            JSONArray allCities = new JSONArray(response);
            for (int i = 0; i < allCities.length();i++){
                JSONObject cityObject = allCities.getJSONObject(i);
                City city = new City();
                city.setCityName(cityObject.getString("name"));
                city.setCityCode(cityObject.getInt("id"));
                city.setProvinceId(provinceId);
                city.save();
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }public static boolean handleCountyResponse(String response,int cityId) {
        if (TextUtils.isEmpty(response)) {
            return false;
        }
        try {
            JSONArray allCounties = new JSONArray(response);
            for (int i = 0; i < allCounties.length();i++){
                JSONObject countyObject = allCounties.getJSONObject(i);
                County county = new County();
                county.setCountyName(countyObject.getString("name"));
                county.setWeatherId(countyObject.getString("weather_id"));
                county.setCityId(cityId);
                county.save();
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

}
