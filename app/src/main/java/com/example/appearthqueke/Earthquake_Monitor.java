package com.example.appearthqueke;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appearthqueke.databinding.ActivityEarthquakeMonitorBinding;

public class Earthquake_Monitor extends AppCompatActivity {
    public static final String EARTHQUAKE_KEY = "earthquake";
    ActivityEarthquakeMonitorBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEarthquakeMonitorBinding.inflate((getLayoutInflater()));
        setContentView(binding.getRoot());
        Bundle extras = getIntent().getExtras();
        Earthquake earthquake = extras.getParcelable(EARTHQUAKE_KEY);
        binding.txtMagnitud.setText(String.valueOf(earthquake.getMagnitude()));
        binding.txtLatitud.setText("Latitude: "+String.valueOf(earthquake.getLatitude())+"° N");
        binding.txtLongitud.setText("Longitude: "+String.valueOf(earthquake.getLatitude())+"° W");
        binding.txtLugar.setText(earthquake.getPlace());
        binding.txtTiempo.setText(String.valueOf(earthquake.getTime()));
    }
}