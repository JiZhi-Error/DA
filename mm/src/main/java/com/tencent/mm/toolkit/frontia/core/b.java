package com.tencent.mm.toolkit.frontia.core;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;

public abstract class b<P> {
    protected int OvS = -2233;
    protected StringBuffer OvT = new StringBuffer(String.valueOf(this.mState));
    protected boolean OvU = true;
    public final Bundle mExtras = new Bundle();
    private final byte[] mLock = new byte[0];
    protected int mState = -1;

    public final b gGh() {
        synchronized (this.mLock) {
            this.mState = 0;
        }
        return blD(AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    public final b blD(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.OvT.append(" --> ").append(str);
        }
        return this;
    }

    public final void gGi() {
        this.OvU = true;
    }
}
