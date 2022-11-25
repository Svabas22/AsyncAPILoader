package com.example.asyncapiloader;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static ArrayList<NeoClass> getNearestNEOS(InputStream stream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
        String line = "";
        String data = "";
        ArrayList<NeoClass> al = null;
        while(line != null){
            line = bufferedReader.readLine();
            data = data + line;
        }

        try {
            if(!data.isEmpty()) {
                JSONObject object = new JSONObject(data);
                JSONArray dataList = object.getJSONArray("data");
                al = new ArrayList<NeoClass>();

                for (int i = 0; i < dataList.length(); ++i) {
                    JSONArray dataObj = dataList.getJSONArray(i);
                    al.add(new NeoClass(dataObj.getString(0),dataObj.getString(1),dataObj.getString(2),dataObj.getString(3),dataObj.getString(4),dataObj.getString(5),dataObj.getString(6),dataObj.getString(7),dataObj.getString(8),dataObj.getString(9),dataObj.getString(10)));
                    //al.add(row);
                    //al.add(dataObj.getString(i));

                }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return al;
    }
}
