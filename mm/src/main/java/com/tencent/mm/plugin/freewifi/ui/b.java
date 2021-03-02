package com.tencent.mm.plugin.freewifi.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class b {
    private static String TAG = "MicroMsg.FreeWifi.FreeWifiGetLocation";
    private boolean isRunning;
    private com.tencent.mm.modelgeo.b wRR;
    private b.a wRS;
    private MMHandler wRT;

    public interface a {
        void V(float f2, float f3);
    }

    /* synthetic */ b(byte b2) {
        this();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.freewifi.ui.b$b  reason: collision with other inner class name */
    public static class C1372b {
        private static b wRW = new b((byte) 0);

        static {
            AppMethodBeat.i(25054);
            AppMethodBeat.o(25054);
        }
    }

    private b() {
        this.wRR = null;
        this.wRS = null;
        this.wRT = null;
        this.isRunning = false;
    }

    public static b dOb() {
        AppMethodBeat.i(25055);
        b bVar = C1372b.wRW;
        AppMethodBeat.o(25055);
        return bVar;
    }

    public final void a(final a aVar) {
        AppMethodBeat.i(25056);
        if (this.isRunning) {
            AppMethodBeat.o(25056);
            return;
        }
        this.isRunning = true;
        this.wRR = d.bca();
        if (this.wRR == null) {
            Log.e(TAG, "doGeoLocation fail, iGetLocation is null");
            AppMethodBeat.o(25056);
            return;
        }
        if (this.wRS == null) {
            this.wRS = new b.a() {
                /* class com.tencent.mm.plugin.freewifi.ui.b.AnonymousClass1 */

                @Override // com.tencent.mm.modelgeo.b.a
                public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
                    AppMethodBeat.i(25052);
                    if (!z) {
                        AppMethodBeat.o(25052);
                        return true;
                    }
                    Log.v(b.TAG, "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2), Double.valueOf(d2), Double.valueOf(d3));
                    if (b.this.wRR != null) {
                        b.this.wRR.c(b.this.wRS);
                    }
                    if (b.this.wRS == null) {
                        Log.w(b.TAG, "already callback");
                        AppMethodBeat.o(25052);
                        return false;
                    }
                    b.this.wRS = null;
                    aVar.V(f2, f3);
                    AppMethodBeat.o(25052);
                    return false;
                }
            };
        }
        if (this.wRT == null) {
            this.wRT = new MMHandler(Looper.myLooper());
        }
        this.wRT.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.freewifi.ui.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(25053);
                b.this.isRunning = false;
                if (b.this.wRR != null) {
                    b.this.wRR.c(b.this.wRS);
                }
                if (b.this.wRS == null) {
                    Log.w(b.TAG, "already callback");
                    AppMethodBeat.o(25053);
                    return;
                }
                b.this.wRS = null;
                AppMethodBeat.o(25053);
            }
        }, 20000);
        this.wRR.a(this.wRS);
        AppMethodBeat.o(25056);
    }
}
