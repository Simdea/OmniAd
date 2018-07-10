/*
 * Copyright (c) 2018. Simdea.
 */

package com.simdea.omniad;

import android.content.Context;

public abstract class AbstractAdProvider {
    protected IAdCallback callback;

    public abstract void tryLoadAd(Context actv, RandomAdView layout);

    public abstract void stop();

    protected void onLoadFailed() {
        if (callback != null)
            callback.onLoadFailed(this);
    }

    public void setCallbackListener(IAdCallback callbackListener) {
        callback = callbackListener;
    }
}