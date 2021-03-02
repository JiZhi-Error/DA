package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.g;
import com.tencent.mm.plugin.appbrand.jsapi.file.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

abstract class e<T extends g> extends d {
    static final ThreadPoolExecutor lUJ = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());
    private final T lUI;

    public e(T t) {
        this.lUI = t;
        this.lUI.lUM = this;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, final JSONObject jSONObject, final int i2) {
        lUJ.submit(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.file.e.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(128848);
                if (!fVar.isRunning()) {
                    AppMethodBeat.o(128848);
                    return;
                }
                try {
                    i.a e2 = e.this.lUI.e(fVar, jSONObject);
                    fVar.i(i2, e.this.a(fVar, e2.errMsg, e2.values));
                    AppMethodBeat.o(128848);
                } catch (Throwable th) {
                    Log.printErrStackTrace("Luggage.BaseNFSApiAsync", th, "%s.invoke, appId=%s, callbackId=%d", e.this.lUI.getClass().getName(), fVar.getAppId(), Integer.valueOf(i2));
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.file.e.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            throw th;
                        }
                    });
                    fVar.i(i2, e.this.h("fail:internal error", null));
                    AppMethodBeat.o(128848);
                }
            }
        });
    }
}
