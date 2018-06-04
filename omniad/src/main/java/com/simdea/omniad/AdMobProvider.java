package com.simdea.omniad;

import android.content.Context;

import com.google.android.gms.ads.MobileAds;

public class AdMobProvider {

    public void initialize(Context context, String appId) {
        MobileAds.initialize(context, appId);
    }
}
