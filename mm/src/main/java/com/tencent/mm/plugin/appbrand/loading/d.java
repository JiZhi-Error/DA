package com.tencent.mm.plugin.appbrand.loading;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentRunnable;", "Ljava/lang/Runnable;", FirebaseAnalytics.b.INDEX, "", "TAG", "", "(ILjava/lang/String;)V", "getTAG", "()Ljava/lang/String;", "getIndex", "()I", "run", "", "plugin-appbrand-integration_release"})
public final class d implements Runnable {
    private final String TAG;
    private final int index;

    public d(int i2, String str) {
        p.h(str, "TAG");
        AppMethodBeat.i(50840);
        this.index = i2;
        this.TAG = str;
        AppMethodBeat.o(50840);
    }

    public final void run() {
        AppMethodBeat.i(50839);
        if (c.mZY.yr(this.index)) {
            Log.w(this.TAG, "timeout, fallback to legacy logic");
        }
        AppMethodBeat.o(50839);
    }
}
