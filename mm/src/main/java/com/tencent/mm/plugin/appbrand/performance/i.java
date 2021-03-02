package com.tencent.mm.plugin.appbrand.performance;

import android.webkit.JavascriptInterface;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class i implements g {
    final String mAppId;

    public i(ag agVar) {
        AppMethodBeat.i(175049);
        this.mAppId = agVar.getAppId();
        AppMethodBeat.o(175049);
    }

    @Override // com.tencent.mm.plugin.appbrand.performance.g
    @JavascriptInterface
    public final void notifyLongTask(final long j2) {
        AppMethodBeat.i(175050);
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.performance.i.AnonymousClass1 */

            public final void run() {
                int i2;
                AppMethodBeat.i(175048);
                long j2 = j2;
                String str = i.this.mAppId;
                if (j2 <= 60) {
                    i2 = 1;
                } else if (j2 > 60 && j2 <= 80) {
                    i2 = 2;
                } else if (j2 > 80 && j2 <= 100) {
                    i2 = 3;
                } else if (j2 > 100 && j2 <= 300) {
                    i2 = 4;
                } else if (j2 > 300 && j2 <= 600) {
                    i2 = 5;
                } else if (j2 <= 600 || j2 > 1000) {
                    i2 = 7;
                } else {
                    i2 = 6;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1246, i2);
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1246, 0);
                String format = String.format("%d,%s", Long.valueOf(j2), str);
                a.nFX.a(18794, format);
                Log.v("MicroMsg.PageLongTaskReporterWC", "doReport %s", format);
                AppMethodBeat.o(175048);
            }
        }, "PageLongTaskReporter");
        AppMethodBeat.o(175050);
    }
}
