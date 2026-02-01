package com.example.intencje;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class ThirdActivity extends AppCompatActivity implements LocationListener {

    LocationManager Lokalizacja;
    Button przyciskStart, przyciskStop;
    TextView poleWspolrzednych;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        przyciskStart = findViewById(R.id.przyciskStart);
        przyciskStop = findViewById(R.id.przyciskStop);
        poleWspolrzednych = findViewById(R.id.poleWspolrzednych);

        Lokalizacja = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        przyciskStop.setEnabled(false);

        przyciskStart.setOnClickListener(v -> {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            }


            Lokalizacja.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);


            przyciskStart.setEnabled(false);
            przyciskStop.setEnabled(true);
            poleWspolrzednych.setText("Szukanie lokalizacji...");
        });

        przyciskStop.setOnClickListener(v -> {

            Lokalizacja.removeUpdates(this);


            przyciskStart.setEnabled(true);
            przyciskStop.setEnabled(false);
            poleWspolrzednych.setText("Lokalizacja zatrzymana.");
        });
    }

    @Override
    public void onLocationChanged(Location location) {
        poleWspolrzednych.setText(
                "Szerokość geograficzna: " + location.getLatitude() +
                        "\nDługość geograficzna: " + location.getLongitude()
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Lokalizacja.removeUpdates(this);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) { }

    @Override
    public void onProviderEnabled(String provider) { }

    @Override
    public void onProviderDisabled(String provider) { }
}
