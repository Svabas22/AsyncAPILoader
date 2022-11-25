package com.example.asyncapiloader;

import com.example.asyncapiloader.Constants;
import com.example.asyncapiloader.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Context;
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
    private ListView result;
    private Button exec;
    ActivityMainBinding binding;
    ArrayList<NeoClass> resultList;
    ArrayAdapter<NeoClass> listAdapter;
    private TextView prompt;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.result = findViewById(R.id.result);
        this.exec = findViewById(R.id.btnExecute);
        this.prompt = findViewById(R.id.prompt);

        resultList = new ArrayList<NeoClass>();


        exec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
                Toast.makeText(getApplicationContext(), R.string.msg_loading_data, Toast.LENGTH_LONG).show();
                Log.d("kys", String.valueOf(resultList.size()));
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
                            Toast.makeText(getApplicationContext(), "Some error occurred!!", Toast.LENGTH_SHORT).show();
                            pd.dismiss();
                            Log.d("kys", resultList.get(3).getDes());
                            //listAdapter = new ArrayAdapter<NeoClass>(MainActivity.this, android.R.layout.simple_list_item_1, resultList);
                            //result.setAdapter(listAdapter);
                            //listAdapter.notifyDataSetChanged();
                        }
                    };
                    runOnUiThread(updateUIRunnable);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(getDataAndDisplayRunnable);
        thread.start();


    }
}