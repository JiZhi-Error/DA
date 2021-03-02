package com.tencent.luggage.bridge;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class r {
    private n csQ;

    r(n nVar) {
        this.csQ = nVar;
    }

    @JavascriptInterface
    public final String send(String str, boolean z) {
        AppMethodBeat.i(140346);
        String i2 = this.csQ.i(str, z);
        AppMethodBeat.o(140346);
        return i2;
    }
}
