package com.example.adinda.iklanadmob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    AdView adView;
    Button btnfullscreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adView  = (AdView) findViewById(R.id.adView);
        MobileAds.initialize(getApplicationContext(),getString(R.string.banner_home_footer));
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        btnfullscreen  = (Button) findViewById(R.id.btn_fullscreen_ad);
        btnfullscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(getApplicationContext(), FullscreenAds.class);
                startActivity(a);
            }
        });


    }

    @Override
    protected void onPause() {
        if (adView != null){
            adView.pause();

        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adView != null){
            adView.resume();

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (adView != null);
        adView.destroy();
    }
}
