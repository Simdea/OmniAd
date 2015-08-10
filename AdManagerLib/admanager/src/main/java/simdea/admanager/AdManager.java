package simdea.admanager;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.jar.Attributes;
import java.util.zip.Inflater;

import simdea.admanager.listeners.GoogleAdListener;

/**
 * Created by carlospeixoto on 31/07/15.
 */
public class AdManager extends View{

    private final static String TAG="AdManagerLib";
    AdView mAdView;
    AdRequest adRequest;
    private RelativeLayout mParent;
    FrameLayout layout;
    View v;

    public AdManager(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = LayoutInflater.from(context);

        v = inflater.inflate(R.layout.google_adview, null);

        mAdView = (AdView) v.findViewById(R.id.adView);

        createGoogleAdview();

    }

    @Override
    public View getRootView() {
        return v;
    }

    private void createGoogleAdview(){
        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new GoogleAdListener());
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }


}
