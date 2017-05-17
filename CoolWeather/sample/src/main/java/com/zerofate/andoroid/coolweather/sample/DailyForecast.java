package com.zerofate.andoroid.coolweather.sample;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zero on 2017/5/18.
 */

public class DailyForecast {
    String date;
    Cond cond;
    Tmp tmp;

    public DailyForecast(String date, String condValue, String max, String min) {
        this.date = date;
        cond = new Cond();
        cond.text = condValue;
        tmp = new Tmp();
        tmp.maxTmp = max;
        tmp.minTmp = min;

    }

    public class Cond {
        @SerializedName("txt_d")
        String text;
    }

    public class Tmp {
        @SerializedName("max")
        String maxTmp;
        @SerializedName("min")
        String minTmp;
    }

}
