package simdea.admanager.listeners;

import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdListener;

/**
 * Created by carlospeixoto on 10/08/15.
 */
public class GoogleAdListener extends AdListener {

    private final static String TAG="GoogleAdListener";
    @Override
    public void onAdClosed() {
        Log.e(TAG, "onAdClosed");
        super.onAdClosed();
    }

    @Override
    public void onAdFailedToLoad(int errorCode) {

        Log.e(TAG, "onAdFailedToLoad");
        super.onAdFailedToLoad(errorCode);
    }

    @Override
    public void onAdLeftApplication() {

        Log.e(TAG, "onAdLeftApplication");
        super.onAdLeftApplication();
    }

    @Override
    public void onAdOpened() {

        Log.e(TAG, "onAdOpened");
        super.onAdOpened();
    }

    @Override
    public void onAdLoaded() {

        Log.e(TAG, "onAdLoaded");

        super.onAdLoaded();
    }
}
