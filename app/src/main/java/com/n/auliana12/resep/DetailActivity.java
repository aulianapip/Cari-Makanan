package com.n.auliana12.resep;

/**
 * Created by auliana12 on 15/06/18.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.n.auliana12.resep.R;


public class DetailActivity extends AppCompatActivity {

    TextView namaMakanan,namaBahan,namaResep,labelUsia;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        namaMakanan= (TextView) findViewById(R.id.namaMakanan);
        namaBahan= (TextView) findViewById(R.id.namaBahan);
        namaResep= (TextView) findViewById(R.id.namaResep);
        labelUsia= (TextView) findViewById(R.id.Usia);


        //RECEIVE
        Intent i=this.getIntent();
        String name=i.getExtras().getString("NAME_KEY");
        String bahan=i.getExtras().getString("BAHAN_KEY");
        String resep=i.getExtras().getString("RESEP_KEY");
        String usia=i.getExtras().getString("USIA_KEY");


        //BIND
        namaMakanan.setText(name);
        namaBahan.setText(bahan);
        namaResep.setText(resep);
        labelUsia.setText(usia);

    }

}











