package com.example.InstantReport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

//<!---->android:value="ca-app-pub-9298246498286822~4434985444"

class MainActivity : AppCompatActivity() {

    private val tag: String = "Its working"

    private var mInterstitialAd: InterstitialAd? = null
    private final var TAG = "MainActivity"

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load banner ad

        MobileAds.initialize(this) {}

        mAdView = findViewById<AdView>(R.id.adView)
        val adRequest1 = AdRequest.Builder().build()
        mAdView.loadAd(adRequest1)


        // load an interstitial ad

        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d(TAG, adError?.message)
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d(TAG, "Ad was loaded.")
                mInterstitialAd = interstitialAd
            }
        })

        //END


        //INITIALIZE ADS

        MobileAds.initialize(this) {}

        //END

        Log.d(tag, "Hello")

        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener{

            //Set the FullScreenContentCallback

            mInterstitialAd?.fullScreenContentCallback = object: FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "Ad was dismissed.")
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                    Log.d(TAG, "Ad failed to show.")
                }

                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "Ad showed fullscreen content.")
                    mInterstitialAd = null;
                }
            }

            if (mInterstitialAd != null) {

                mInterstitialAd?.show(this)
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.")
            }

            val intent1 = Intent(this, record::class.java)
            startActivity(intent1)
        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener{

            if (mInterstitialAd != null) {
                mInterstitialAd?.show(this)
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.")
            }

            val intent2 = Intent(this, record::class.java)
            startActivity(intent2)
        }

        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener{

            if (mInterstitialAd != null) {
                mInterstitialAd?.show(this)
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.")
            }

            val intent3 = Intent(this, record::class.java)
            startActivity(intent3)
        }

        val button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener{

            if (mInterstitialAd != null) {
                mInterstitialAd?.show(this)
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.")
            }

            val intent3 = Intent(this, record::class.java)
            startActivity(intent3)
        }

    }
}