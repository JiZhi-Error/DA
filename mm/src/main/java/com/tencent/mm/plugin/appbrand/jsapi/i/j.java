package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.s;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class j extends h<s> {
    private static final int CTRL_INDEX = 586;
    private static final String NAME = "enableLocationUpdateBackground";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.h, com.tencent.mm.plugin.appbrand.jsapi.i.a
    public /* synthetic */ void d(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(138198);
        b(sVar, jSONObject, i2);
        AppMethodBeat.o(138198);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.h
    public final /* synthetic */ s r(s sVar) {
        AppMethodBeat.i(138197);
        t tVar = new t(sVar);
        AppMethodBeat.o(138197);
        return tVar;
    }

    public void b(final s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(138196);
        super.d(sVar, jSONObject, i2);
        if (!(this.lXb instanceof t)) {
            Log.w("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "state manager not RuntimeLocationUpdateStateManagerWxa");
            sVar.i(i2, h("fail:system error", null));
            AppMethodBeat.o(138196);
            return;
        }
        final t tVar = (t) this.lXb;
        r rVar = tVar.lXi;
        if (rVar != null) {
            rVar.bGH();
        }
        if (rVar == null || !tVar.lXu) {
            rVar = new r();
        }
        tVar.lXi = rVar;
        rVar.W(sVar.getRuntime());
        tVar.lXv = new s.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.i.j.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.s.a
            public final void ZO(String str) {
                AppMethodBeat.i(138194);
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1562453447:
                        if (str.equals("StateNotListening")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1514425717:
                        if (str.equals("StateSuspend")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1073716042:
                        if (str.equals("StateListening")) {
                            c2 = 0;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "STATE_LISTENING, start blink");
                        if (tVar.lXi != null) {
                            tVar.lXi.W(sVar.getRuntime());
                            AppMethodBeat.o(138194);
                            return;
                        }
                        break;
                    case 1:
                        Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "STATE_NOT_LISTENING, stop blink");
                        if (tVar.lXi != null) {
                            tVar.lXi.bGG();
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(138194);
            }
        };
        c.a aVar = tVar.lXA;
        if (aVar != null) {
            sVar.getRuntime().kAH.b(aVar);
        }
        if (aVar == null || !tVar.lXu) {
            aVar = new c.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.i.j.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.a.c.a
                public final void a(String str, b bVar) {
                    AppMethodBeat.i(138195);
                    if (bVar == b.DESTROYED) {
                        Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.DESTROYED, uninit");
                        tVar.quit();
                        AppMethodBeat.o(138195);
                    } else if (bVar == b.SUSPEND) {
                        Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.SUSPEND, suspendListening");
                        tVar.bGI();
                        AppMethodBeat.o(138195);
                    } else if (bVar == b.kQH) {
                        Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.FOREGROUND, resumeListening");
                        tVar.bGJ();
                        AppMethodBeat.o(138195);
                    } else {
                        if (bVar == b.BACKGROUND) {
                            if (!tVar.lXu) {
                                Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.BACKGROUND, stopListening");
                                tVar.stopListening();
                                AppMethodBeat.o(138195);
                                return;
                            }
                            Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdateBackgroundWxa", "AppRunningState.BACKGROUND, do nothing");
                        }
                        AppMethodBeat.o(138195);
                    }
                }
            };
        }
        sVar.getRuntime().kAH.a(aVar);
        tVar.lXA = aVar;
        tVar.lXu = true;
        AppMethodBeat.o(138196);
    }
}
