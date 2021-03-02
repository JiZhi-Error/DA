package com.tencent.mm.plugin.appbrand.launching.e;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.w;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class d extends a {
    private static final Map<String, d> mZi = new ConcurrentHashMap();
    private final WeakReference<Context> mContextRef;
    private final String mZj;
    private final String mZk;

    static {
        AppMethodBeat.i(47452);
        AppMethodBeat.o(47452);
    }

    public static d acl(String str) {
        AppMethodBeat.i(47448);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(47448);
            return null;
        }
        d remove = mZi.remove(str);
        AppMethodBeat.o(47448);
        return remove;
    }

    d(Context context, String str, boolean z) {
        AppMethodBeat.i(47449);
        this.mZj = str;
        this.mZk = context.getClass().getName();
        this.mContextRef = new WeakReference<>(context);
        this.mYV = z;
        mZi.put(str, this);
        new a(str).startTimer(TimeUnit.SECONDS.toMillis(300));
        AppMethodBeat.o(47449);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.launching.e.a
    public final void c(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(47450);
        super.c(appBrandInitConfigWC, appBrandStatObject);
        if (appBrandInitConfigWC != null) {
            w wVar = w.nHZ;
            w.i(appBrandInitConfigWC);
        }
        AppMethodBeat.o(47450);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.launching.e.a
    public final Context bOf() {
        AppMethodBeat.i(47451);
        Context context = this.mContextRef.get();
        AppMethodBeat.o(47451);
        return context;
    }

    static final class a extends MTimerHandler {
        a(final String str) {
            super(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.appbrand.launching.e.d.a.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(47446);
                    d acl = d.acl(str);
                    if (acl != null) {
                        acl.bOc();
                    }
                    AppMethodBeat.o(47446);
                    return false;
                }
            }, false);
            AppMethodBeat.i(47447);
            AppMethodBeat.o(47447);
        }
    }
}
