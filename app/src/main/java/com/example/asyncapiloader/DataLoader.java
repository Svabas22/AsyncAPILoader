package com.example.asyncapiloader;

import android.util.Log;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    public static ArrayList<NeoClass> getDataFromApi(String apiCode) throws IOException {
        InputStream apiContentStream = null;
        ArrayList<NeoClass> result;
        try {
            URL url = new URL(Constants.NEO_API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            result = Parser.getNearestNEOS(conn.getInputStream());


        }
        finally {
            if (apiContentStream != null) {
                apiContentStream.close();
            }
        }
        return result;
    }

}
