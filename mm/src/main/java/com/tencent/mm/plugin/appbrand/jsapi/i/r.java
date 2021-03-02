package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class r {
    long lXp = 0;
    i.a lXq;

    public final void W(final AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(138211);
        Log.i("MicroMsg.LbsBlinkHelper", "startBlinkSubTitle");
        m.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.i.r.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(138207);
                if (r.this.lXq != null) {
                    r.this.lXq.dismiss();
                }
                r.this.lXq = a.C0775a.ah(appBrandRuntime).a(a.b.LBS);
                r.this.lXp = System.currentTimeMillis();
                AppMethodBeat.o(138207);
            }
        });
        AppMethodBeat.o(138211);
    }

    public final void bGG() {
        AppMethodBeat.i(138212);
        Log.i("MicroMsg.LbsBlinkHelper", "stopBlinkSubTitle");
        m.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.i.r.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(138209);
                if (r.this.lXq == null) {
                    AppMethodBeat.o(138209);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis() - r.this.lXp;
                if (currentTimeMillis < 3000) {
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.i.r.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(138208);
                            r.this.lXq.dismiss();
                            AppMethodBeat.o(138208);
                        }
                    }, 3000 - currentTimeMillis);
                    AppMethodBeat.o(138209);
                    return;
                }
                r.this.lXq.dismiss();
                AppMethodBeat.o(138209);
            }
        });
        AppMethodBeat.o(138212);
    }

    public final void bGH() {
        AppMethodBeat.i(138213);
        Log.i("MicroMsg.LbsBlinkHelper", "stopBlinkSubTitleImmediately");
        m.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.i.r.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(138210);
                if (r.this.lXq == null) {
                    AppMethodBeat.o(138210);
                    return;
                }
                r.this.lXq.dismiss();
                AppMethodBeat.o(138210);
            }
        });
        AppMethodBeat.o(138213);
    }
}
