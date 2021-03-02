package com.tencent.mm.plugin.appbrand.appusage.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.TimeUnit;

public final class c {
    private static float kWL = 0.0f;
    private static float kWM = 0.0f;
    private static volatile long kWN = 0;
    private boolean kWO = false;
    private a kWP;

    public interface a {
        void J(float f2, float f3);
    }

    public final void a(a aVar) {
        this.kWP = aVar;
    }

    public final boolean byE() {
        return this.kWP != null;
    }

    public static boolean byF() {
        boolean z;
        AppMethodBeat.i(44671);
        if (kWM == -85.0f || kWL == -1000.0f) {
            AppMethodBeat.o(44671);
            return false;
        }
        if (Util.nowMilliSecond() - kWN < 300000) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            AppMethodBeat.o(44671);
            return false;
        }
        AppMethodBeat.o(44671);
        return true;
    }

    public static float getLongitude() {
        return kWL;
    }

    public static float getLatitude() {
        return kWM;
    }

    public final void byG() {
        AppMethodBeat.i(44672);
        if (this.kWO) {
            AppMethodBeat.o(44672);
            return;
        }
        Log.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "startLocation");
        this.kWO = true;
        final PBool pBool = new PBool();
        final PBool pBool2 = new PBool();
        pBool.value = false;
        pBool2.value = false;
        new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.appbrand.appusage.a.c.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(44669);
                if (pBool2.value) {
                    AppMethodBeat.o(44669);
                } else {
                    pBool.value = true;
                    c.this.kWO = false;
                    Log.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onTimerExpired");
                    if (c.this.kWP != null) {
                        c.this.kWP.J(c.kWL, c.kWM);
                    }
                    AppMethodBeat.o(44669);
                }
                return false;
            }
        }, false).startTimer(TimeUnit.SECONDS.toMillis(20));
        d.bca().b((b.a) f.cP(new b.a() {
            /* class com.tencent.mm.plugin.appbrand.appusage.a.c.AnonymousClass2 */
            private int kWT = 0;

            @Override // com.tencent.mm.modelgeo.b.a
            public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
                AppMethodBeat.i(44670);
                f.bs(this);
                d.bca().c(this);
                int i3 = this.kWT + 1;
                this.kWT = i3;
                if (i3 > 1 || pBool.value) {
                    AppMethodBeat.o(44670);
                    return false;
                }
                pBool2.value = true;
                c.this.kWO = false;
                if (!z) {
                    Log.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onGetLocation, fail");
                    if (c.this.kWP != null) {
                        c.this.kWP.J(f2, f3);
                    }
                    AppMethodBeat.o(44670);
                    return false;
                }
                Log.i("MicroMsg.Recommend.AppBrandRecommendLocationGet", "onGetLocation, success");
                float unused = c.kWM = f3;
                float unused2 = c.kWL = f2;
                long unused3 = c.kWN = Util.nowMilliSecond();
                if (c.this.kWP != null) {
                    c.this.kWP.J(f2, f3);
                }
                AppMethodBeat.o(44670);
                return true;
            }
        }), false);
        AppMethodBeat.o(44672);
    }
}
