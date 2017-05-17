package com.zerofate.andoroid.coolweather.sample;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by zero on 2017/5/16.
 */

public class Forecast {
    @SerializedName("daily_forecast")
    List<DailyForecast> list;
}
