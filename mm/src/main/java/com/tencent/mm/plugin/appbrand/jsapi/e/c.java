package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.xlabeffect.e;
import com.tencent.mm.xeffect.FaceTracker;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends d<s> {
    public static final int CTRL_INDEX = 862;
    public static final String NAME = "faceProcessInit";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(226767);
        final s sVar2 = sVar;
        final a bGl = a.bGl();
        bGl.lTO.execute(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.e.c.AnonymousClass1 */

            public final void run() {
                a.EnumC0659a aVar;
                String str;
                AppMethodBeat.i(226766);
                a aVar2 = bGl;
                if (a.lTL.lTN == null) {
                    a.lTL.lTM = e.JRF;
                    String glu = e.glu();
                    com.tencent.mm.plugin.xlabeffect.d.gls();
                    a.lTL.lTN = new FaceTracker(glu);
                    aVar2.lTM = null;
                    aVar = a.EnumC0659a.ResultOK;
                } else {
                    aVar = a.EnumC0659a.ResultInited;
                }
                int a2 = a.a(aVar);
                HashMap hashMap = new HashMap(1);
                hashMap.put("errCode", Integer.valueOf(a2));
                if (aVar == a.EnumC0659a.ResultOK) {
                    str = "ok:init ok";
                } else if (aVar == a.EnumC0659a.ResultInited) {
                    str = "fail: already init";
                } else if (aVar == a.EnumC0659a.ResultInitFail) {
                    str = "fail:init fail";
                } else {
                    str = "fail:undefine error";
                }
                sVar2.i(i2, c.this.n(str, hashMap));
                AppMethodBeat.o(226766);
            }
        });
        AppMethodBeat.o(226767);
    }
}
