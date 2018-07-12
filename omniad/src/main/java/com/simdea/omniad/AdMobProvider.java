package com.simdea.omniad;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class AdMobProvider extends AbstractAdProvider {

    private Context mContext;
    private AdView mAdView;

    private String mPublisherId;
    private AdSize mSize;
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
        this.mPublisherId = publisherId;
        this.mSize = size;
    }

    @Override
    public void tryLoadAd(Context actv, RandomAdView layout) {
        Log.d("Ads", "loading AdMob");
        mAdView = new AdView(mContext);
        mAdView.setAdSize(mSize);
        mAdView.setAdUnitId(mPublisherId);
        mAdView.setAdListener(new AdListener() {
            public void onAdClosed() {
            }

            public void onAdFailedToLoad(int var1) {
                stop();
                onLoadFailed();
            }

            public void onAdLeftApplication() {
            }

            public void onAdOpened() {
            }

            public void onAdLoaded() {
            }

            public void onAdClicked() {
            }

            public void onAdImpression() {
            }
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
