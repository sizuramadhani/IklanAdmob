package com.example.adinda.iklanadmob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class FullscreenAds extends AppCompatActivity {

    String TAG = FullscreenAds.class.getSimpleName();
    InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_ads);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));

        AdRequest adRequest = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Toast.makeText(FullscreenAds.this, "Ad is Failed to Load! error code:" +errorCode, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onAdLeftApplication() {
                Toast.makeText(FullscreenAds.this, "Ad is Left Aplication!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                Toast.makeText(FullscreenAds.this, "Ad is Opened!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLoaded() {
                if (interstitialAd.isLoaded()){
                    interstitialAd.show();

                }
            }
        });
    }
}
