package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.m;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class h extends c {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "join1v1VoIPChat";
    private static String TAG = "MicroMsg.OpenVoice.JsApiJoin1v1VoIPChat";

    public h() {
        AppMethodBeat.i(226936);
        c.aem(NAME);
        AppMethodBeat.o(226936);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.openvoice.c, com.tencent.mm.plugin.appbrand.jsapi.openvoice.i
    public final void a(final com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject, final int i2) {
        int i3;
        AppMethodBeat.i(226937);
        if (jSONObject == null) {
            cVar.i(i2, h("fail:data is null or nil", null));
            AppMethodBeat.o(226937);
            return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.c cVar2 = (com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.c) cVar.getRuntime().aw(com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.c.class);
        if (cVar2 != null) {
            String bMg = cVar2.bMg();
            if (!Util.isNullOrNil(bMg)) {
                Log.e(TAG, "can not join voip chat now, message:%s", bMg);
                HashMap hashMap = new HashMap();
                b(hashMap, ee(-10086, -7));
                cVar.i(i2, n(String.format("fail: %d, %d, can not join voip chat now", -10086, -7), hashMap));
                AppMethodBeat.o(226937);
                return;
            }
        }
        this.mAppId = cVar.getAppId();
        b(cVar);
        final String appId = cVar.getAppId();
        Log.i(TAG, "hy: appId:" + appId + ", data:" + jSONObject.toString());
        try {
            long j2 = jSONObject.getLong("roomId");
            Log.i(TAG, "hy:roomId:".concat(String.valueOf(j2)));
            int optInt = jSONObject.optInt("roomType", 2);
            int optInt2 = jSONObject.optInt("lifespan", LocalCache.TIME_DAY);
            String optString = jSONObject.optString("sessionKey", "");
            String optString2 = jSONObject.optString("privateData", "");
            JSONObject jSONObject2 = jSONObject.getJSONObject("muteConfig");
            final boolean optBoolean = jSONObject2.optBoolean("muteMicrophone");
            final boolean optBoolean2 = jSONObject2.optBoolean("muteEarphone");
            final boolean optBoolean3 = jSONObject.optBoolean("handsFree", false);
            this.mjV = 0;
            this.mjU = Util.currentTicks();
            if (cVar.getRuntime() == null || !cVar.getRuntime().NA()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            hl(false);
            q qVar = q.INSTANCE;
            AnonymousClass1 r4 = new b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.h.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b
                @SuppressLint({"DefaultLocale"})
                public final /* synthetic */ void a(int i2, int i3, String str, ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> arrayList) {
                    AppMethodBeat.i(226931);
                    ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> arrayList2 = arrayList;
                    long ticksToNow = Util.ticksToNow(h.this.mjU);
                    Log.i(h.TAG, "hy: join result result %d, %d, %s, %s, using %d ms", Integer.valueOf(i2), Integer.valueOf(i3), str, arrayList2, Long.valueOf(ticksToNow));
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(16092, h.this.mAppId, Integer.valueOf(i3), Long.valueOf(ticksToNow));
                    if (i2 == 0 && i3 == 0) {
                        h.this.mjU = Util.currentTicks();
                        h.this.hl(!optBoolean);
                        q.INSTANCE.a(optBoolean2, (b<String>) null);
                        q.INSTANCE.b(optBoolean, (b<String>) null);
                        q.INSTANCE.c(optBoolean3, (b<String>) null);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.n(935, 0, 1);
                        Map<String, ? extends Object> F = h.F(arrayList2);
                        h.b(F, h.ee(i2, i3));
                        cVar.i(i2, h.this.n("ok", F));
                        if (!h.this.mjT) {
                            h.this.mjT = true;
                            cVar.a(h.this.mjS);
                        }
                        h.this.mjW = true;
                        AppMethodBeat.o(226931);
                        return;
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(935, 1, 1);
                    HashMap hashMap = new HashMap();
                    h.b(hashMap, h.ee(i2, i3));
                    cVar.i(i2, h.this.n(String.format("fail: %d, %d, %s, %d", Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(q.INSTANCE.qtF)), hashMap));
                    h.this.mjW = false;
                    AppMethodBeat.o(226931);
                }
            };
            AnonymousClass2 r17 = new b<q.a>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.h.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b
                public final /* synthetic */ void a(int i2, int i3, String str, q.a aVar) {
                    AppMethodBeat.i(226932);
                    q.a aVar2 = aVar;
                    long ticksToNow = Util.ticksToNow(h.this.mjU);
                    Log.i(h.TAG, "hy: on call interrupted! %d, %d, %s, %s, in room for %d ms", Integer.valueOf(i2), Integer.valueOf(i3), str, aVar2, Long.valueOf(ticksToNow));
                    if (!(cVar.getRuntime() == null || cVar.getRuntime().kAH == null)) {
                        cVar.getRuntime().kAH.b(h.this.mjR);
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(16094, h.this.mAppId, Integer.valueOf(aVar2.cND), Long.valueOf(ticksToNow), Integer.valueOf(h.this.mjV));
                    q.aaC(appId);
                    h.this.mjW = false;
                    if (aVar2 == q.a.ReasonManual) {
                        Log.i(h.TAG, "hy: manually exit, ignore");
                        AppMethodBeat.o(226932);
                        return;
                    }
                    if (aVar2 == q.a.ReasonDevice) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.n(935, 4, 1);
                    }
                    if (aVar2 == q.a.ReasonSessionUpdateFailed) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.n(935, 5, 1);
                    }
                    if (aVar2 == q.a.ReasonUnknown) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.n(935, 6, 1);
                    }
                    if (aVar2 == q.a.ReasonInterrupted) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.n(935, 7, 1);
                    }
                    ((l) h.this.mjN.g(cVar)).a(aVar2);
                    AppMethodBeat.o(226932);
                }
            };
            AnonymousClass3 r18 = new b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.h.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b
                public final /* synthetic */ void a(int i2, int i3, String str, ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> arrayList) {
                    AppMethodBeat.i(226933);
                    ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> arrayList2 = arrayList;
                    Log.i(h.TAG, "hy: on room member changed! %s", arrayList2);
                    if (arrayList2 != null) {
                        h.this.mjV = Math.max(h.this.mjV, arrayList2.size());
                        Log.d(h.TAG, "hy: max room member changed to %d", Integer.valueOf(h.this.mjV));
                    }
                    Map<String, Object> F = h.F(arrayList2);
                    F.put("errCode", 0);
                    ((m) h.this.mjO.g(cVar)).R(F);
                    AppMethodBeat.o(226933);
                }
            };
            AnonymousClass4 r19 = new b<HashMap<String, LinkedList>>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.h.AnonymousClass4 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b
                public final /* synthetic */ void a(int i2, int i3, String str, HashMap<String, LinkedList> hashMap) {
                    AppMethodBeat.i(226934);
                    HashMap<String, LinkedList> hashMap2 = hashMap;
                    Log.i(h.TAG, "hy: on room video member changed!");
                    if (hashMap2 != null) {
                        Map<String, Object> e2 = h.e(hashMap2);
                        e2.put("errCode", 0);
                        ((o) h.this.mjP.g(cVar)).R(e2);
                    }
                    AppMethodBeat.o(226934);
                }
            };
            AnonymousClass5 r20 = new b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.h.AnonymousClass5 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b
                public final /* synthetic */ void a(int i2, int i3, String str, ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> arrayList) {
                    AppMethodBeat.i(226935);
                    ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> arrayList2 = arrayList;
                    Log.i(h.TAG, "hy: on talk member changed! %s", arrayList2);
                    Map<String, Object> F = h.F(arrayList2);
                    F.put("errCode", 0);
                    ((n) h.this.mjQ.g(cVar)).R(F);
                    AppMethodBeat.o(226935);
                }
            };
            m.czc();
            Log.i("MicroMsg.OpenVoice.OpenVoiceService", "jd: trigger join room. %s, %s, %d, %d, %d", appId, "wx766655dab8fe851b", Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(optInt));
            qVar.aj(new Runnable(appId, "wx766655dab8fe851b", i3, optInt, optString2, j2, optString, optInt2, r4, r17, r18, r19, r20) {
                /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass23 */
                final /* synthetic */ String kFU;
                final /* synthetic */ String quA;
                final /* synthetic */ int quB;
                final /* synthetic */ String qum;
                final /* synthetic */ int qup;
                final /* synthetic */ int quq;
                final /* synthetic */ String quu;
                final /* synthetic */ b quv;
                final /* synthetic */ b quw;
                final /* synthetic */ b qux;
                final /* synthetic */ b quy;
                final /* synthetic */ b quz;
                final /* synthetic */ long val$roomId;

                {
                    this.kFU = r5;
                    this.qum = r6;
                    this.qup = r7;
                    this.quq = r8;
                    this.quu = r9;
                    this.val$roomId = r10;
                    this.quA = r12;
                    this.quB = r13;
                    this.quv = r14;
                    this.quw = r15;
                    this.qux = r16;
                    this.quy = r17;
                    this.quz = r18;
                }

                public final void run() {
                    AppMethodBeat.i(186764);
                    q.this.qtC = true;
                    q.a(q.this, this.kFU, this.qum, "", "", 0, this.qup, this.quq, 480, 640, "", this.quu, this.val$roomId, this.quA, this.quB, this.quv, this.quw, this.qux, this.quy, this.quz);
                    AppMethodBeat.o(186764);
                }
            });
            Log.i(TAG, "hy: JsApiJoin1v1VoIPChat callbackId:".concat(String.valueOf(i2)));
            AppMethodBeat.o(226937);
        } catch (JSONException e2) {
            Log.printErrStackTrace(TAG, e2, "handle join voip 1v1 data exception", new Object[0]);
            cVar.i(i2, h("fail: param error!", null));
            this.mjW = false;
            AppMethodBeat.o(226937);
        }
    }
}
