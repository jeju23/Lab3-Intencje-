package com.example.intencje;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button przyciskPierwszy, przyciskDrugi, przyciskTrzeci;
    TextView poleAdresuUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        przyciskPierwszy = findViewById(R.id.przyciskPierwszy);
        przyciskDrugi = findViewById(R.id.przyciskDrugi);
        przyciskTrzeci = findViewById(R.id.przyciskTrzeci);
        poleAdresuUrl = findViewById(R.id.poleUrl);

        przyciskPierwszy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencjaJawna = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intencjaJawna);
            }
        });

        przyciskDrugi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String adres = poleAdresuUrl.getText().toString();
                Intent intencjaPrzegladarki =
                        new Intent(Intent.ACTION_VIEW, Uri.parse(adres));
                startActivity(intencjaPrzegladarki);
            }
        });

        przyciskTrzeci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencjaGps = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intencjaGps);
            }
        });
    }
}
