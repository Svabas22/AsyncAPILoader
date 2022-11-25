package com.example.asyncapiloader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class neoDetails extends AppCompatActivity {

    TextView des,
            orbit_id,
            jd,
            cd,
            dist,
            dist_min,
            dist_max,
            v_rel,
            v_inf,
            t_sigma_f,
            h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neo_details);

        des = findViewById(R.id.details_des);
        orbit_id = findViewById(R.id.details_orbit_id);
        jd = findViewById(R.id.details_jd);
        cd = findViewById(R.id.details_cd);
        dist = findViewById(R.id.details_dist);
        dist_min = findViewById(R.id.details_dist_min);
        dist_max = findViewById(R.id.details_dist_max);
        v_rel = findViewById(R.id.details_v_rel);
        v_inf = findViewById(R.id.details_v_inf);
        t_sigma_f = findViewById(R.id.details_t_sigma_f);
        h = findViewById(R.id.details_h);

        des.setText(getIntent().getStringExtra("des"));
        orbit_id.setText(getIntent().getStringExtra("orbitid"));
        jd.setText(getIntent().getStringExtra("jd"));
        cd.setText(getIntent().getStringExtra("cd"));
        dist.setText(getIntent().getStringExtra("dist"));
        dist_min.setText(getIntent().getStringExtra("distmin"));
        dist_max.setText(getIntent().getStringExtra("distmax"));
        v_rel.setText(getIntent().getStringExtra("vrel"));
        v_inf.setText(getIntent().getStringExtra("vinf"));
        t_sigma_f.setText(getIntent().getStringExtra("tsigmaf"));
        h.setText(getIntent().getStringExtra("h"));

    }
}