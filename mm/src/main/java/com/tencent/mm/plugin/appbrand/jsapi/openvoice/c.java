package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.m;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends i {
    public static final int CTRL_INDEX = 516;
    public static final String NAME = "joinVoIPChat";
    private static String TAG = "MicroMsg.OpenVoice.JsApiCloudVoiceJoinVoIPChat";
    protected String mAppId = "";
    protected l mjN = new l();
    protected m mjO = new m();
    protected o mjP = new o();
    protected n mjQ = new n();
    protected c.a mjR = null;
    protected p mjS = new p();
    protected volatile boolean mjT = false;
    protected long mjU = -1;
    protected int mjV = 0;
    protected boolean mjW = false;

    public c() {
        AppMethodBeat.i(46680);
        com.tencent.mm.plugin.appbrand.permission.c.aem(NAME);
        AppMethodBeat.o(46680);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.openvoice.i
    public void a(final com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46681);
        if (jSONObject == null) {
            cVar.i(i2, h("fail:data is null or nil", null));
            AppMethodBeat.o(46681);
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
                AppMethodBeat.o(46681);
                return;
            }
        }
        this.mAppId = cVar.getAppId();
        b(cVar);
        final String appId = cVar.getAppId();
        Log.i(TAG, "hy: appId:" + appId + ", params:" + jSONObject.toString());
        try {
            String string = jSONObject.getString("signature");
            String string2 = jSONObject.getString("nonceStr");
            String string3 = jSONObject.getString("groupId");
            int i3 = jSONObject.getInt("timeStamp");
            int optInt = jSONObject.optInt("roomType", 2);
            int optInt2 = jSONObject.optInt("maxWidth", 480);
            int optInt3 = jSONObject.optInt("maxHeight", 640);
            String optString = jSONObject.optString("privateData", "");
            JSONObject jSONObject2 = jSONObject.getJSONObject("muteConfig");
            final boolean optBoolean = jSONObject2.optBoolean("muteMicrophone");
            final boolean optBoolean2 = jSONObject2.optBoolean("muteEarphone");
            this.mjV = 0;
            this.mjU = Util.currentTicks();
            int i4 = (cVar.getRuntime() == null || !cVar.getRuntime().NA()) ? 1 : 0;
            hl(false);
            q qVar = q.INSTANCE;
            AnonymousClass1 r4 = new b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.c.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b
                @SuppressLint({"DefaultLocale"})
                public final /* synthetic */ void a(int i2, int i3, String str, ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> arrayList) {
                    AppMethodBeat.i(226921);
                    ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> arrayList2 = arrayList;
                    long ticksToNow = Util.ticksToNow(c.this.mjU);
                    Log.i(c.TAG, "hy: join result result %d, %d, %s, %s, using %d ms", Integer.valueOf(i2), Integer.valueOf(i3), str, arrayList2, Long.valueOf(ticksToNow));
                    h.INSTANCE.a(16092, c.this.mAppId, Integer.valueOf(i3), Long.valueOf(ticksToNow));
                    if (i2 == 0 && i3 == 0) {
                        c.this.mjU = Util.currentTicks();
                        c.this.hl(!optBoolean);
                        q.INSTANCE.a(optBoolean2, (b<String>) null);
                        q.INSTANCE.b(optBoolean, (b<String>) null);
                        h.INSTANCE.n(935, 0, 1);
                        Map<String, ? extends Object> F = c.F(arrayList2);
                        c.b(F, c.ee(i2, i3));
                        cVar.i(i2, c.this.n("ok", F));
                        c.this.mjW = true;
                        if (!c.this.mjT) {
                            c.this.mjT = true;
                            cVar.a(c.this.mjS);
                        }
                        AppMethodBeat.o(226921);
                        return;
                    }
                    h.INSTANCE.n(935, 1, 1);
                    HashMap hashMap = new HashMap();
                    c.b(hashMap, c.ee(i2, i3));
                    cVar.i(i2, c.this.n(String.format("fail: %d, %d, %s, %d", Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(q.INSTANCE.qtF)), hashMap));
                    c.this.mjW = false;
                    AppMethodBeat.o(226921);
                }
            };
            AnonymousClass2 r19 = new b<q.a>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.c.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b
                public final /* synthetic */ void a(int i2, int i3, String str, q.a aVar) {
                    AppMethodBeat.i(46676);
                    q.a aVar2 = aVar;
                    long ticksToNow = Util.ticksToNow(c.this.mjU);
                    Log.i(c.TAG, "hy: on call interrupted! %d, %d, %s, %s, in room for %d ms", Integer.valueOf(i2), Integer.valueOf(i3), str, aVar2, Long.valueOf(ticksToNow));
                    c.this.mjW = false;
                    if (!(cVar.getRuntime() == null || cVar.getRuntime().kAH == null)) {
                        cVar.getRuntime().kAH.b(c.this.mjR);
                    }
                    h.INSTANCE.a(16094, c.this.mAppId, Integer.valueOf(aVar2.cND), Long.valueOf(ticksToNow), Integer.valueOf(c.this.mjV));
                    q.aaC(appId);
                    if (aVar2 == q.a.ReasonManual) {
                        Log.i(c.TAG, "hy: manually exit, ignore");
                        AppMethodBeat.o(46676);
                        return;
                    }
                    if (aVar2 == q.a.ReasonDevice) {
                        h.INSTANCE.n(935, 4, 1);
                    }
                    if (aVar2 == q.a.ReasonSessionUpdateFailed) {
                        h.INSTANCE.n(935, 5, 1);
                    }
                    if (aVar2 == q.a.ReasonUnknown) {
                        h.INSTANCE.n(935, 6, 1);
                    }
                    if (aVar2 == q.a.ReasonInterrupted) {
                        h.INSTANCE.n(935, 7, 1);
                    }
                    ((l) c.this.mjN.g(cVar)).a(aVar2);
                    AppMethodBeat.o(46676);
                }
            };
            AnonymousClass3 r20 = new b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.c.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b
                public final /* synthetic */ void a(int i2, int i3, String str, ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> arrayList) {
                    AppMethodBeat.i(46677);
                    ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> arrayList2 = arrayList;
                    Log.i(c.TAG, "hy: on room member changed! %s", arrayList2);
                    if (arrayList2 != null) {
                        c.this.mjV = Math.max(c.this.mjV, arrayList2.size());
                        Log.d(c.TAG, "hy: max room member changed to %d", Integer.valueOf(c.this.mjV));
                    }
                    Map<String, Object> F = c.F(arrayList2);
                    F.put("errCode", 0);
                    ((m) c.this.mjO.g(cVar)).R(F);
                    AppMethodBeat.o(46677);
                }
            };
            AnonymousClass4 r21 = new b<HashMap<String, LinkedList>>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.c.AnonymousClass4 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b
                public final /* synthetic */ void a(int i2, int i3, String str, HashMap<String, LinkedList> hashMap) {
                    AppMethodBeat.i(46678);
                    HashMap<String, LinkedList> hashMap2 = hashMap;
                    Log.i(c.TAG, "hy: on room video member changed!");
                    if (hashMap2 != null) {
                        Map<String, Object> e2 = c.e(hashMap2);
                        e2.put("errCode", 0);
                        ((o) c.this.mjP.g(cVar)).R(e2);
                    }
                    AppMethodBeat.o(46678);
                }
            };
            AnonymousClass5 r22 = new b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.c.AnonymousClass5 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b
                public final /* synthetic */ void a(int i2, int i3, String str, ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> arrayList) {
                    AppMethodBeat.i(46679);
                    ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> arrayList2 = arrayList;
                    Log.i(c.TAG, "hy: on talk member changed! %s", arrayList2);
                    Map<String, Object> F = c.F(arrayList2);
                    F.put("errCode", 0);
                    ((n) c.this.mjQ.g(cVar)).R(F);
                    AppMethodBeat.o(46679);
                }
            };
            m.czc();
            Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger join room. %s, %s, %s, %d, %s", appId, string, string3, Integer.valueOf(i3), string2);
            qVar.aj(new Runnable(appId, "wx766655dab8fe851b", string, string3, i3, i4, optInt, optInt2, optInt3, string2, optString, r4, r19, r20, r21, r22) {
                /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass22 */
                final /* synthetic */ String kFU;
                final /* synthetic */ String lzM;
                final /* synthetic */ String qum;
                final /* synthetic */ String qun;
                final /* synthetic */ int quo;
                final /* synthetic */ int qup;
                final /* synthetic */ int quq;
                final /* synthetic */ int qur;
                final /* synthetic */ int qus;
                final /* synthetic */ String qut;
                final /* synthetic */ String quu;
                final /* synthetic */ b quv;
                final /* synthetic */ b quw;
                final /* synthetic */ b qux;
                final /* synthetic */ b quy;
                final /* synthetic */ b quz;

                {
                    this.kFU = r3;
                    this.qum = r4;
                    this.lzM = r5;
                    this.qun = r6;
                    this.quo = r7;
                    this.qup = r8;
                    this.quq = r9;
                    this.qur = r10;
                    this.qus = r11;
                    this.qut = r12;
                    this.quu = r13;
                    this.quv = r14;
                    this.quw = r15;
                    this.qux = r16;
                    this.quy = r17;
                    this.quz = r18;
                }

                public final void run() {
                    AppMethodBeat.i(186763);
                    q.this.qtC = false;
                    q.a(q.this, this.kFU, this.qum, this.lzM, this.qun, this.quo, this.qup, this.quq, this.qur, this.qus, this.qut, this.quu, -1, "", 0, this.quv, this.quw, this.qux, this.quy, this.quz);
                    AppMethodBeat.o(186763);
                }
            });
            Log.i(TAG, "hy: JsApiCloudVoiceJoinVoIPChat callbackId:".concat(String.valueOf(i2)));
            AppMethodBeat.o(46681);
        } catch (JSONException e2) {
            Log.printErrStackTrace(TAG, e2, "handle join voice voip data exception", new Object[0]);
            cVar.i(i2, h("fail: param error!", null));
            this.mjW = false;
            AppMethodBeat.o(46681);
        }
    }

    /* access modifiers changed from: protected */
    public final void b(final com.tencent.mm.plugin.appbrand.service.c cVar) {
        AppMethodBeat.i(226924);
        if (this.mjR == null) {
            this.mjR = new c.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.c.AnonymousClass6 */

                @Override // com.tencent.mm.plugin.appbrand.a.c.a
                public final void a(String str, com.tencent.mm.plugin.appbrand.a.b bVar) {
                    AppMethodBeat.i(226923);
                    Log.i(c.TAG, "hy: is1V1:%b, isIsVoIPTalking:%b", Boolean.valueOf(q.INSTANCE.qtC), Boolean.valueOf(q.INSTANCE.qtB));
                    if (bVar != com.tencent.mm.plugin.appbrand.a.b.DESTROYED || !c.this.mAppId.equals(str)) {
                        if (bVar == com.tencent.mm.plugin.appbrand.a.b.BACKGROUND && c.this.mAppId.equals(str)) {
                            if (c.this.mjW) {
                                q.aaB(c.this.mAppId);
                            }
                            c.this.mjW = false;
                        }
                        AppMethodBeat.o(226923);
                        return;
                    }
                    Log.i(c.TAG, "hy: appbrand change to destroy");
                    q.INSTANCE.a(new b<String>() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.c.AnonymousClass6.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                        @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b
                        public final /* synthetic */ void a(int i2, int i3, String str, String str2) {
                            AppMethodBeat.i(226922);
                            Log.i(c.TAG, "hy: appbrand change to destroy and exit room");
                            AppMethodBeat.o(226922);
                        }
                    }, q.a.ReasonWeappEnterBackground);
                    if (!(cVar.getRuntime() == null || cVar.getRuntime().kAH == null)) {
                        cVar.getRuntime().kAH.b(c.this.mjR);
                    }
                    q.aaC(str);
                    AppMethodBeat.o(226923);
                }
            };
        }
        if (!(cVar.getRuntime() == null || cVar.getRuntime().kAH == null)) {
            cVar.getRuntime().kAH.a(this.mjR);
        }
        AppMethodBeat.o(226924);
    }

    protected static Map<String, Object> F(ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> arrayList) {
        AppMethodBeat.i(226925);
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        if (!Util.isNullOrNil(arrayList)) {
            Iterator<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().openId);
            }
        }
        hashMap.put("openIdList", arrayList2);
        AppMethodBeat.o(226925);
        return hashMap;
    }

    protected static Map<String, Object> e(HashMap<String, LinkedList> hashMap) {
        AppMethodBeat.i(226926);
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, LinkedList> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            LinkedList value = entry.getValue();
            if (!(key == null || value == null)) {
                hashMap2.put(key, new ArrayList(value));
            }
        }
        AppMethodBeat.o(226926);
        return hashMap2;
    }

    protected static void b(Map<String, Object> map, int i2) {
        AppMethodBeat.i(226927);
        map.put("errCode", Integer.valueOf(i2));
        AppMethodBeat.o(226927);
    }

    protected static int ee(int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return 0;
        }
        if (i2 != -10086 && i2 != -10087) {
            return -1000;
        }
        switch (i3) {
            case -9:
                return -3;
            case -7:
                return -2;
            case -1:
                return -1;
            case 0:
                return 0;
            default:
                return -1000;
        }
    }
}
