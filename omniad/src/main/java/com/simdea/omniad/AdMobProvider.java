package com.simdea.omniad;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class AdMobProvider extends AbstractAdProvider {

    private Context mContext;
    private AdView mAdView;

    private String publisherId;
    private AdSize size;
    private String testingDevice;

    public AdMobProvider(Context context, String publisherId) {
        this(publisherId, AdSize.BANNER);
        mContext = context;
        MobileAds.initialize(mContext, publisherId);
    }

    public AdMobProvider(String publisherId, String testingMode) {
        this(publisherId, AdSize.BANNER);
        testingDevice = testingMode;
    }

    public AdMobProvider(String publisherId, AdSize size) {
        this.publisherId = publisherId;
        this.size = size;
    }

    @Override
    public void tryLoadAd(Activity actv, LinearLayout layout) {
        Log.d("Ads", "loading AdMob");
        mAdView = new AdView(mContext);
        mAdView.setAdListener(new AdListener() {

        });
        layout.addView(mAdView);
        AdRequest.Builder builder = new AdRequest.Builder();
        if (testingDevice != null)
            builder.addTestDevice(testingDevice);
        AdRequest request = builder.build();
        mAdView.loadAd(request);
    }

    @Override
    public void stop() {
        if (mAdView != null) {
            Log.d("Ads", "stopin AdMob");
        }
    }
}
