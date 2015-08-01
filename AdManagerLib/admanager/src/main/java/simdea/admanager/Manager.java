package simdea.admanager;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.zip.Inflater;

/**
 * Created by carlospeixoto on 31/07/15.
 */
public class Manager extends View{

    private final static String TAG="AdManagerLib";
    AdView mAdView;
    AdRequest adRequest;

    public Manager(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.google_adview, null);

        mAdView = (AdView) v.findViewById(R.id.adView);

        createGoogleAdview();


    }


    private void createGoogleAdview(){
        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(adlistener);
    }

    private AdListener adlistener = new AdListener() {
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
    };
}
