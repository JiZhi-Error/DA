package com.tencent.mm.plugin.lite.b;

import com.tencent.f.h;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.List;

public final class b extends IListener<d> {
    private static long yEy = 0;
    private static long yEz = 0;

    public b() {
        AppMethodBeat.i(198851);
        this.__eventId = d.class.getName().hashCode();
        AppMethodBeat.o(198851);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(d dVar) {
        AppMethodBeat.i(198853);
        boolean a2 = a(dVar);
        AppMethodBeat.o(198853);
        return a2;
    }

    private boolean a(d dVar) {
        AppMethodBeat.i(198852);
        if (dVar.dBP.dBQ) {
            AppMethodBeat.o(198852);
        } else if (!g.aAc()) {
            Log.w("MicroMsg.AppLite.LiteAppCheckerListener", "callback fail. account not ready.");
            AppMethodBeat.o(198852);
        } else {
            if (yEy == 0) {
                yEy = ((Long) g.aAh().azQ().get(ar.a.USERINFO_LITE_APP_UPDATE_LAST_TIME_LONG, (Object) 0L)).longValue();
            }
            if (yEz == 0) {
                yEz = ((Long) g.aAh().azQ().get(ar.a.USERINFO_LITE_APP_CLEAN_LAST_TIME_LONG, (Object) 0L)).longValue();
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - yEy;
            if (j2 >= 43200000) {
                Log.i("MicroMsg.AppLite.LiteAppCheckerListener", "It's time to update lite app.");
                yEy = currentTimeMillis;
                g.aAh().azQ().set(ar.a.USERINFO_LITE_APP_UPDATE_LAST_TIME_LONG, Long.valueOf(currentTimeMillis));
                h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.plugin.lite.b.b.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(260033);
                        b.hVY();
                        AppMethodBeat.o(260033);
                    }
                });
            } else {
                Log.i("MicroMsg.AppLite.LiteAppCheckerListener", "It's not time to update lite app. please wait %d second", Long.valueOf((43200000 - j2) / 100));
            }
            if (currentTimeMillis - yEz >= Util.MILLSECONDS_OF_DAY) {
                Log.i("MicroMsg.AppLite.LiteAppCheckerListener", "It's time to clean lite app.");
                yEz = currentTimeMillis;
                g.aAh().azQ().set(ar.a.USERINFO_LITE_APP_CLEAN_LAST_TIME_LONG, Long.valueOf(currentTimeMillis));
                h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.plugin.lite.b.b.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(260034);
                        b.hVZ();
                        AppMethodBeat.o(260034);
                    }
                });
            } else {
                Log.i("MicroMsg.AppLite.LiteAppCheckerListener", "It's not time to clean lite app. please wait %d second", Long.valueOf((Util.MILLSECONDS_OF_DAY - j2) / 100));
            }
            AppMethodBeat.o(198852);
        }
        return false;
    }

    static /* synthetic */ boolean hVY() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(260035);
        f.ecC();
        List<WxaLiteAppInfo> ecD = f.ecD();
        if (ecD == null || ecD.isEmpty()) {
            z = false;
        } else {
            z = false;
            for (WxaLiteAppInfo wxaLiteAppInfo : ecD) {
                f.ecC().a(wxaLiteAppInfo.appId, null);
                if (wxaLiteAppInfo.appId.equalsIgnoreCase(LiteAppCenter.LITE_APP_BASE_LIB)) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                z = z2;
            }
        }
        if (!z) {
            f.ecC().ecF();
        }
        AppMethodBeat.o(260035);
        return false;
    }

    static /* synthetic */ boolean hVZ() {
        AppMethodBeat.i(260036);
        c.ecA();
        boolean ecB = c.ecB();
        AppMethodBeat.o(260036);
        return ecB;
    }
}
