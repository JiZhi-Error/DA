package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.r.c;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class b {
    public a oza;

    /* access modifiers changed from: protected */
    public abstract View bIn();

    public final <T extends c> T aK(Class<T> cls) {
        Log.d("MicroMsg.AppBrandBottomPickerInvokeHandler", cls.getSimpleName());
        a jm = jm(true);
        this.oza = jm;
        if (jm == null) {
            return null;
        }
        try {
            jm.setPickerImpl(cls.getDeclaredConstructor(Context.class).newInstance(jm.getContext()));
            return (T) jm.getPicker();
        } catch (Exception e2) {
            return null;
        }
    }

    private a jm(boolean z) {
        n cW;
        if (this.oza != null) {
            return this.oza;
        }
        View bIn = bIn();
        if (bIn == null || (cW = n.cW(bIn)) == null) {
            return null;
        }
        a dj = a.dj(cW);
        if (dj != null || !z) {
            return dj;
        }
        a dR = dR(bIn.getContext());
        cW.n(dR, true);
        return dR;
    }

    public final <T extends c> T aL(Class<T> cls) {
        a jm = jm(false);
        if (jm == null || !cls.isInstance(jm.getPicker())) {
            return null;
        }
        return (T) jm.getPicker();
    }

    /* access modifiers changed from: protected */
    public a dR(Context context) {
        return new a(context);
    }
}
