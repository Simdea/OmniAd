package com.simdea.omniad;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.Random;

public class RandomAdView extends FrameLayout implements IAdCallback {

    private Context mContext;
    private ArrayList<AbstractAdProvider> providers;
    private AbstractAdProvider current;
    private int currentIdx;
    private boolean isRandomOrder;
    private Random rnd;
    private boolean started;
    private boolean cycle;
    private int maxCycleDepth;
    private int cycleDepth;

    public RandomAdView(Context context) {
        super(context);
    }

    public RandomAdView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RandomAdView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RandomAdView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init() {
        providers = new ArrayList<>();
        rnd = new Random();
        started = false;
        cycle = false;
        maxCycleDepth = 100;
        cycleDepth = 0;
        isRandomOrder = false;
    }

    public void loadAds(Context ctx){
        if (!providers.isEmpty()){
            stop(false);
            started = true;
            mContext = ctx;
            Log.i("Ads", "lodaing ads");
            removeAllViews();
            if (isRandomOrder)
                currentIdx = rnd.nextInt(providers.size());
            else
                currentIdx = 0;
            loadCurrentProvider();
        }
    }

    private void loadCurrentProvider(){
        if (!started)
            return;
        int size = providers.size();
        if (size == 0)
            return;
        if (size > currentIdx) {
            current = providers.get(currentIdx);
            removeAllViews();
            current.tryLoadAd(mContext, this);
        } else{
            if (cycle) {
                cycleDepth ++;
                if (cycleDepth < maxCycleDepth) {
                    currentIdx = 0;
                    loadCurrentProvider();
                }
            }
        }
    }

    public void stop(boolean clearBanner){
        if (started){
            Log.i("Ads", "stopping ad provider");
            started = false;
            if (current != null) {
                current.stop();
                current = null;
            }
            if (clearBanner)
                removeAllViews();
        }
    }

    @Override
    public void onLoadFailed(AbstractAdProvider provider) {
        Log.i("Ads", "lodaing next provider");
        removeAllViews();
        if (isRandomOrder)
            currentIdx = rnd.nextInt(providers.size());
        else
            currentIdx++;
        loadCurrentProvider();
    }
}
