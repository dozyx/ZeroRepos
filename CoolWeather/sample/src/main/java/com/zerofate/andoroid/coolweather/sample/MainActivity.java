package com.zerofate.andoroid.coolweather.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String json = "{\"daily_forecast\":[{\"date\":\"2016-08-08\",\"cond\":{\"txt_d\":\"阵雨\"},"
//                + "\"tmp\":{\"max\":\"34\",\"min\":\"27\"}},{\"date\":\"2016-08-09\","
//                + "\"cond\":{\"txt_d\":\"多云\"},\"tmp\":{\"max\":\"35\",\"min\":\"29\"}}]}";
//        Gson gson = new Gson();
//        Forecast forecast = gson.fromJson(json,Forecast.class);
//        Log.d(TAG,"forecast second date == " + forecast.list.get(1).tmp.maxTmp);
        Gson gson = new Gson();
        Forecast forecast = new Forecast();
        forecast.list = new ArrayList<>();
        forecast.list.add(new DailyForecast("2016-08-08","阵雨","34","27"));
        forecast.list.add(new DailyForecast("2016-08-09","多云","35","29"));
        String json = gson.toJson(forecast);
        Log.d(TAG,"json == " + json.toString());

/*        JSONObject forcastObject = new JSONObject();
        JSONArray forecasts = new JSONArray();
        JSONObject forecast1 = new JSONObject();
        try {
            forecast1.put("date", "2016-08-08");
            JSONObject condObject = new JSONObject();
            condObject.put("txt_d", "阵雨");
            forecast1.put("cond", condObject);
            JSONObject tmpObject = new JSONObject();
            tmpObject.put("max", "34");
            tmpObject.put("min", "27");
            forecast1.put("tmp", tmpObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject forecast2 = new JSONObject();
        try {
            forecast2.put("date", "2016-08-09");
            JSONObject condObject = new JSONObject();
            condObject.put("txt_d", "多云");
            forecast2.put("cond", condObject);
            JSONObject tmpObject = new JSONObject();
            tmpObject.put("max", "35");
            tmpObject.put("min", "29");
            forecast2.put("tmp", tmpObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        forecasts.put(forecast1);
        forecasts.put(forecast2);
        try {
            forcastObject.put("daily_forecast",forecasts);
            Log.d(TAG,"json string == " + forcastObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            parse(forcastObject.toString(4));
        } catch (JSONException e) {
            e.printStackTrace();
        }*/


    }
    private void parse(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("daily_forecast");
            JSONObject firstObjectOfArray = jsonArray.getJSONObject(0);
            Log.d(TAG,"date == " + firstObjectOfArray.getString("date"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
