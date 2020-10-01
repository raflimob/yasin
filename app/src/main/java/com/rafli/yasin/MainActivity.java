package com.rafli.yasin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    ImageView i1, i2, i3, i4;
    InterstitialAd mInterstialAd;
    FloatingActionButton w;
    private InterstitialAd interstitial;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        MobileAds.initialize(MainActivity.this, "ca-app-pub-1409435899101504~9991211109");

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        w = (FloatingActionButton) findViewById(R.id.ketentang);
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Tentang.class));
            }
        });

        AdRequest adRequests = new AdRequest.Builder().build();
        interstitial = new InterstitialAd(MainActivity.this);
        interstitial.setAdUnitId(getString(R.string.admob_id));
        interstitial.loadAd(adRequests);
        interstitial.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                display();
            }
        });

        i1 = (ImageView) findViewById(R.id.yasin);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Yasin.class));
                finish();
            }
        });
        i2 = (ImageView) findViewById(R.id.tahlil);
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Tahlil.class));
                finish();
            }
        });
        i3 = (ImageView) findViewById(R.id.asmaul);
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AsmaulHusna.class));
                finish();
            }
        });
        i4 = (ImageView) findViewById(R.id.isigos);
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, Istigosah.class));
                finish();
            }
        });

    }

    private void display() {
        if (interstitial.isLoaded()) {
            interstitial.show();
        }

    }

    private void initView() {
        adView = findViewById(R.id.adView);
    }
}
