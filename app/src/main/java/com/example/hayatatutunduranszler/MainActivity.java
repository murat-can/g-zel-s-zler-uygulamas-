package com.example.hayatatutunduranszler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class MainActivity extends AppCompatActivity {
    Button destekbutonu;
    Button basla;
    Button paylas;
    Button hakkinda;
    private ProgressDialog LoadingBar;
    private InterstitialAd mInterstitialAd;
    RewardedVideoAd rewardedVideoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baslaButonuMetodu();
        VideoReklamMetodu();
        uygulamayipaylas();
        UygulamaHakkinda();
        geriButonumetodu();
    }

    private void geriButonumetodu() {
        MobileAds.initialize(this,"ca-app-pub-5714708973241718~7006881345");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5714708973241718/9790727282");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    private void UygulamaHakkinda() {
        hakkinda=findViewById(R.id.hakkinda);
        hakkinda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
            }
        });

    }
    private void baslaButonuMetodu() {
        basla=findViewById(R.id.basla);//

        basla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

    }
    private void VideoReklamMetodu() {
        LoadingBar=new ProgressDialog(this);

        destekbutonu=findViewById(R.id.destek);
        MobileAds.initialize(this,"ca-app-pub-5714708973241718~7006881345");
        rewardedVideoAd=MobileAds.getRewardedVideoAdInstance(this);
        rewardedVideoAd.loadAd("ca-app-pub-5714708973241718/6590387875",new AdRequest.Builder().build());
        destekbutonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                destekbutonu.setVisibility(View.INVISIBLE);
                LoadingBar.setTitle("Teşekkürler");
                LoadingBar.setMessage("Desteğiniz İçin Teşekkür Ederiz");

                LoadingBar.setCanceledOnTouchOutside(true);
                LoadingBar.show();


                rewardedVideoAd.isLoaded();
                rewardedVideoAd.show();

                if (rewardedVideoAd.isLoaded()){
                    rewardedVideoAd.show();
                    //  LoadingBar.dismiss();
                }
                /*if (LoadingBar.isShowing()) {
                    rewardedVideoAd.isLoaded();
                    rewardedVideoAd.show();
                }*/

            }
        });
        rewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            @Override
            public void onRewardedVideoAdLoaded() {
                //yüklendiğinde
                // Toast.makeText(getApplicationContext(), "Yüklendiğinde", Toast.LENGTH_LONG).show();
                LoadingBar.dismiss();
                destekbutonu.setVisibility(View.VISIBLE);

                /*rewardedVideoAd.isLoaded();
               rewardedVideoAd.show();*/

            }

            @Override
            public void onRewardedVideoAdOpened() {
                //ekranı tamamen kapladığında
                // Toast.makeText(getApplicationContext(), "ekranı kapladığında", Toast.LENGTH_LONG).show();
                LoadingBar.dismiss();

            }

            @Override
            public void onRewardedVideoStarted() {
                //video başladığında
                // Toast.makeText(getApplicationContext(), "video başladığında", Toast.LENGTH_LONG).show();
            }


            @Override
            public void onRewardedVideoAdClosed() {
                //reklam kapatıldığında
                rewardedVideoAd.loadAd("ca-app-pub-5714708973241718/6590387875",new AdRequest.Builder().build());
                //  Toast.makeText(getApplicationContext(), "reklam kapatıldığında", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onRewarded(RewardItem rewardItem) {
                //ödül verme işlemi

            }

            @Override
            public void onRewardedVideoAdLeftApplication() {
                //uygulamadan ayrıldığında
                //Toast.makeText(getApplicationContext(), "uygulamadan ayrıldığında", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int i) {
                //hata oluştuğunda
            }

            @Override
            public void onRewardedVideoCompleted() {
                //video tamamlandığında
                //Toast.makeText(getApplicationContext(), "video bittiğinde", Toast.LENGTH_LONG).show();
                LoadingBar.dismiss();
            }

        });


    }
    private void uygulamayipaylas() { {
        paylas=findViewById(R.id.paylas);
        paylas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id=com.musbet.hayatatutunduranszler");
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });

    }
    }


    @Override
    protected void onResume() {
        rewardedVideoAd.resume(this);
        super.onResume();
    }

    @Override
    protected void onPause() {
        rewardedVideoAd.pause(this);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        rewardedVideoAd.destroy(this);
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        mInterstitialAd.show();
        super.onBackPressed();
    }
}
