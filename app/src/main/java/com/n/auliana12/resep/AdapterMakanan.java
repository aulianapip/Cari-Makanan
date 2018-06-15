package com.n.auliana12.resep;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class AdapterMakanan extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<DataResep> data= Collections.emptyList();
    DataResep current;
    int currentPos=0;


    public AdapterMakanan(Context context, List<DataResep> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_resep, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        final DataResep s = data.get(position);
        MyHolder myHolder = (MyHolder) holder;
        DataResep current = data.get(position);
        myHolder.textMakanan.setText(current.namaMakanan);

        myHolder.textUsia.setText("Usia: " + current.usia);
        myHolder.textMakanan.setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
        myHolder.textUsia.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

        myHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick() {
                openDetailActivity(s.getName(), s.getBahan(),s.getResep(), s.getUsia());
            }
        });
    }

    private void openDetailActivity(String name,String bahan,String resep,String usia)
    {
        Intent i=new Intent(context, DetailActivity.class);
        //PACK DATA
        i.putExtra("NAME_KEY",name);
        i.putExtra("BAHAN_KEY",bahan);
        i.putExtra("RESEP_KEY",resep);
        i.putExtra("USIA_KEY",usia);


        context.startActivity(i);
    }




    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textMakanan;
        TextView textUsia;
        TextView textBahan;
        ItemClickListener itemClickListener;


        public MyHolder(View itemView) {
            super(itemView);
            textMakanan= (TextView) itemView.findViewById(R.id.textMakanan);

            textUsia = (TextView) itemView.findViewById(R.id.textUsia);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick();
        }

        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener=itemClickListener;
        }





    }

}
