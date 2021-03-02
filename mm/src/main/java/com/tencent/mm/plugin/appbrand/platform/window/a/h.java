package com.tencent.mm.plugin.appbrand.platform.window.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Timer;
import java.util.TimerTask;

/* access modifiers changed from: package-private */
public final class h {
    int nFa = 0;
    a nFb = null;
    Timer nFc = null;

    /* access modifiers changed from: package-private */
    public interface a {
        void bTS();

        void bTT();
    }

    h() {
    }

    /* access modifiers changed from: package-private */
    public final void a(final a aVar) {
        AppMethodBeat.i(176742);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.platform.window.a.h.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(176740);
                h.a(h.this);
                h.this.nFb = aVar;
                h.this.nFc = new Timer();
                h.this.nFc.schedule(new TimerTask() {
                    /* class com.tencent.mm.plugin.appbrand.platform.window.a.h.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(176739);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.platform.window.a.h.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(176738);
                                Log.w("MicroMsg.AppBrandDeviceOrientationRetrier", "hy: still not cancelled, trigger retry");
                                h.this.nFa++;
                                if (h.this.nFa > 3) {
                                    if (h.this.nFb != null) {
                                        h.this.nFb.bTS();
                                    }
                                    h.this.nFc.cancel();
                                    AppMethodBeat.o(176738);
                                    return;
                                }
                                if (h.this.nFb != null) {
                                    h.this.nFb.bTT();
                                }
                                AppMethodBeat.o(176738);
                            }
                        });
                        AppMethodBeat.o(176739);
                    }
                }, 500, 500);
                AppMethodBeat.o(176740);
            }
        });
        AppMethodBeat.o(176742);
    }

    /* access modifiers changed from: package-private */
    public final void bTU() {
        AppMethodBeat.i(176743);
        Log.i("MicroMsg.AppBrandDeviceOrientationRetrier", "cancelTickTok");
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.platform.window.a.h.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(176741);
                Log.i("MicroMsg.AppBrandDeviceOrientationRetrier", "cancelTikTok reset");
                h.a(h.this);
                AppMethodBeat.o(176741);
            }
        });
        AppMethodBeat.o(176743);
    }

    static /* synthetic */ void a(h hVar) {
        AppMethodBeat.i(176744);
        if (hVar.nFc != null) {
            hVar.nFc.cancel();
        }
        hVar.nFa = 0;
        hVar.nFb = null;
        AppMethodBeat.o(176744);
    }
}
