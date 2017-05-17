package com.zerofate.andoroid.coolweather.sample;

import com.google.gson.Gson;

/**
 * Created by zero on 2017/5/17.
 */

public class Test {
    public static void main(String[] args) {
        UserSimple userObject = new UserSimple(
                "Norman",
                "norman@futurestud.io",
                26,
                true);
        Gson gson = new Gson();
        String userJson = gson.toJson(userObject);
        System.out.println(userJson);

    }

}
