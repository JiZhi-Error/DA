package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class ay extends MutableContextWrapper {
    public ay(Context context) {
        super(context);
    }

    @JavascriptInterface
    public float getPixelRatio() {
        AppMethodBeat.i(147442);
        float f2 = getResources().getDisplayMetrics().density;
        AppMethodBeat.o(147442);
        return f2;
    }

    @JavascriptInterface
    public float getWidth() {
        AppMethodBeat.i(147443);
        float ceil = (float) Math.ceil((double) (((float) getResources().getDisplayMetrics().widthPixels) / getPixelRatio()));
        AppMethodBeat.o(147443);
        return ceil;
    }
}
