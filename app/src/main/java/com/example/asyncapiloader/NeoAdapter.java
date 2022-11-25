package com.example.asyncapiloader;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NeoAdapter extends RecyclerView.Adapter<NeoAdapter.ViewHolder> {

    Context ctx;
    ArrayList<NeoClass> list;

    public NeoAdapter(Context ctx, ArrayList<NeoClass> list){

        this.ctx = ctx;
        this.list = list;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View neoView = LayoutInflater.from(ctx.getApplicationContext()).inflate(R.layout.activity_neo, null, false);
        return new ViewHolder(neoView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NeoClass model = list.get(position);

        holder.name.setText(model.getDes());

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, neoDetails.class);
                intent.putExtra("des", model.getDes());
                intent.putExtra("orbitid", model.getOrbit_id());
                intent.putExtra("jd", model.getJd());
                intent.putExtra("cd", model.getCd());
                intent.putExtra("dist", model.getDist());
                intent.putExtra("distmin",model.getDist_min());
                intent.putExtra("distmax", model.getDist_max());
                intent.putExtra("vrel", model.getV_rel());
                intent.putExtra("vinf",model.getV_inf());
                intent.putExtra("tsigmaf", model.getT_sigma_f());
                intent.putExtra("h",model.getH());
                ctx.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        CardView card;


        public ViewHolder(@NonNull View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.neo_name);
            card = itemView.findViewById(R.id.neo_card);
        }
    }
}
