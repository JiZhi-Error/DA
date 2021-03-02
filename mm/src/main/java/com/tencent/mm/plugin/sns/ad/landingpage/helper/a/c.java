package com.tencent.mm.plugin.sns.ad.landingpage.helper.a;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class c implements b.AbstractC0452b, b {
    private a Dul;
    private String Dum;
    private long cqY;
    d yNv = d.bca();

    public static b a(a aVar, String str, long j2) {
        c cVar;
        AppMethodBeat.i(202024);
        if (j2 <= 0) {
            AppMethodBeat.o(202024);
            return null;
        }
        try {
            cVar = new c(aVar, str, j2);
        } catch (Throwable th) {
            Log.e("GeoServerRequester", "there is something wrong in makeRequester");
            cVar = null;
        }
        AppMethodBeat.o(202024);
        return cVar;
    }

    private c(a aVar, String str, long j2) {
        AppMethodBeat.i(202025);
        this.cqY = j2;
        this.Dul = aVar;
        this.Dum = str;
        AppMethodBeat.o(202025);
    }

    @Override // com.tencent.mm.modelgeo.b.a
    public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
        return false;
    }

    @Override // com.tencent.mm.modelgeo.b.AbstractC0452b
    public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3, Bundle bundle) {
        AppMethodBeat.i(202027);
        Log.i("GeoServerRequester", "the onGetLocation is called, the longitude is ".concat(String.valueOf(f2)));
        try {
            if (Looper.myLooper() != null) {
                this.yNv.c(this);
            } else {
                new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ad.landingpage.helper.a.c.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(202023);
                        try {
                            c.this.yNv.c(c.this);
                            AppMethodBeat.o(202023);
                        } catch (Throwable th) {
                            AppMethodBeat.o(202023);
                        }
                    }
                });
            }
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("result", z);
            bundle2.putDouble("latitude", (double) f3);
            bundle2.putDouble("longitude", (double) f2);
            bundle2.putDouble("speed", d2);
            bundle2.putDouble("accuracy", d3);
            if (this.Dul != null) {
                this.Dul.CLIENT_CALL(this.Dum, Long.valueOf(this.cqY), bundle2);
            }
        } catch (Throwable th) {
            Log.e("GeoServerRequester", "there is something wrong in onGetLocation");
        }
        AppMethodBeat.o(202027);
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b
    public final void request(String str) {
        AppMethodBeat.i(202026);
        try {
            if ("GCJ02".equalsIgnoreCase(str)) {
                this.yNv.b(this, false);
                AppMethodBeat.o(202026);
                return;
            }
            this.yNv.a((b.a) this, false);
            AppMethodBeat.o(202026);
        } catch (Throwable th) {
            Log.e("GeoServerRequester", "there is something wrong in request");
            AppMethodBeat.o(202026);
        }
    }
}
