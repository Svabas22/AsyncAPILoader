package com.example.asyncapiloader;

import com.example.asyncapiloader.Constants;
import com.example.asyncapiloader.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView result;
    Button exec, info;
    ActivityMainBinding binding;
    ArrayList<NeoClass> resultList;
    NeoAdapter adapter;
    TextView prompt;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.result = findViewById(R.id.result);
        this.exec = findViewById(R.id.btnExecute);
        this.info = findViewById(R.id.btnInfo);
        this.prompt = findViewById(R.id.prompt);

        resultList = new ArrayList<NeoClass>();


        exec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();

            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Info.class);
                MainActivity.this.startActivity(intent);
            }
        });

    }

    private void getData() {
        pd = new ProgressDialog(MainActivity.this);
        pd.setMessage("Loading....");
        pd.show();
        Runnable getDataAndDisplayRunnable = new Runnable() {
            @Override
            public void run() {

                try {
                    resultList = DataLoader.getDataFromApi(Constants.NEO_API_URL);
                    Runnable updateUIRunnable = new Runnable() {
                        @Override
                        public void run() {

                            pd.dismiss();

                            adapter = new NeoAdapter(MainActivity.this, resultList);
                            GridLayoutManager manager = new GridLayoutManager(MainActivity.this, 1);
                            manager.isAutoMeasureEnabled();
                            result.setAdapter(adapter);
                            result.setLayoutManager(manager);
                            adapter.notifyDataSetChanged();
                        }
                    };
                    runOnUiThread(updateUIRunnable);
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "Some error occurred!!", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(getDataAndDisplayRunnable);
        thread.start();


    }
}