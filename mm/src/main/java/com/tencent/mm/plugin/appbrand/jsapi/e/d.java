package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.xeffect.FaceTracker;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d<s> {
    public static final int CTRL_INDEX = 863;
    public static final String NAME = "MicroMsg.aceProcessStop";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(226769);
        final s sVar2 = sVar;
        final a bGl = a.bGl();
        bGl.lTO.execute(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.e.d.AnonymousClass1 */

            public final void run() {
                a.EnumC0659a aVar;
                String str;
                AppMethodBeat.i(226768);
                if (a.lTL.lTN != null) {
                    FaceTracker faceTracker = a.lTL.lTN;
                    if (faceTracker.Rxd != 0) {
                        faceTracker.nDestroy(faceTracker.Rxd);
                    }
                    a.lTL.lTN = null;
                    aVar = a.EnumC0659a.ResultOK;
                } else {
                    aVar = a.EnumC0659a.ResultStopFail;
                }
                int a2 = a.a(aVar);
                HashMap hashMap = new HashMap(1);
                hashMap.put("errCode", Integer.valueOf(a2));
                if (aVar == a.EnumC0659a.ResultOK) {
                    str = "ok:stop ok";
                } else if (aVar == a.EnumC0659a.ResultStopFail) {
                    str = "fail:stop fail";
                } else {
                    str = "fail:undefine error";
                }
                sVar2.i(i2, d.this.n(str, hashMap));
                AppMethodBeat.o(226768);
            }
        });
        AppMethodBeat.o(226769);
    }
}
