package com.example.appearthqueke;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appearthqueke.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.eqRecyclear.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Earthquake> eqList = new ArrayList<>();
        eqList.add(new Earthquake("001","Carchi - Tulcan",5.0,5082022,1005,154.8));
        eqList.add(new Earthquake("002","Guayas - Guayaquil",5.0,5082022,1005,154.8));
        eqList.add(new Earthquake("003","Chimborazo - Alusi",5.0,5082022,1005,154.8));
        eqList.add(new Earthquake("004","Carchi - Tulcan",5.0,5082022,1005,154.8));
        eqList.add(new Earthquake("005","Carchi - Tulcan",5.0,5082022,1005,154.8));

        //modf
        EqAdapter adapter = new EqAdapter();
        adapter.setOnItemClickListener(earthquake -> {
            Toast.makeText(MainActivity.this, earthquake.getPlace(), Toast.LENGTH_SHORT).show();
            String id = earthquake.getId();
            String place = earthquake.getPlace();
            double magnitude = earthquake.getMagnitude();
            int tiempo = earthquake.getTime();
            double latitud = earthquake.getLatitude();
            double longitud = earthquake.getLongitude();
            abrirEarthquake_Monitor(id,place,magnitude,tiempo,latitud,longitud);
                }
        );


        binding.eqRecyclear.setAdapter(adapter);
        adapter.submitList(eqList);

        if (eqList.isEmpty()){
            binding.emptyView.setVisibility(View.VISIBLE);
        }else{
            binding.emptyView.setVisibility(View.GONE);
        }

    }
    private void abrirEarthquake_Monitor(String id, String place, double magnitude, int time, double latitud, double longitud) {
        Intent intent = new Intent(this, Earthquake_Monitor.class);
        Earthquake usuario = new Earthquake(id,place,magnitude,time, latitud,longitud);
        intent.putExtra(Earthquake_Monitor.EARTHQUAKE_KEY, usuario);
        startActivity(intent);
    }
}