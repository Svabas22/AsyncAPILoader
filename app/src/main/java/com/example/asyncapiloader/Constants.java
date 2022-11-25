package com.example.asyncapiloader;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Constants {
    static String date = new SimpleDateFormat("yyyy-MM", Locale.getDefault()).format(new Date());;

    public static final String NEO_API_URL = "https://ssd-api.jpl.nasa.gov/cad.api?dist-max=10LD&date-min="+ date +"-01&sort=dist";
    public static final String METEOLT_API_URL = "https://api.meteo.lt/v1/places/kaunas/forecasts/long-term";

}
