package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.n;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.ae.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.s.k;
import com.tencent.mm.plugin.appbrand.s.l;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.plugin.appbrand.utils.y;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends b {
    public static final int CTRL_INDEX = 346;
    public static final String NAME = "createSocketTask";
    private static k.a mge;
    public static int mgg = 0;
    public static int mgh = 1;
    private k.c mgf;
    private int mgi = mgg;
    private boolean mgj = false;
    private boolean mgk = false;
    private final AtomicBoolean mgl = new AtomicBoolean(false);

    public static class a extends bc {
        public static final int CTRL_INDEX = 348;
        public static final String NAME = "onSocketTaskStateChange";
    }

    static /* synthetic */ void a(e eVar, f fVar, String str, String str2) {
        AppMethodBeat.i(207092);
        eVar.b(fVar, str, str2);
        AppMethodBeat.o(207092);
    }

    static /* synthetic */ JSONObject b(com.tencent.mm.plugin.appbrand.ae.e.f fVar) {
        AppMethodBeat.i(144217);
        JSONObject a2 = a(fVar);
        AppMethodBeat.o(144217);
        return a2;
    }

    public e(int i2, k.c cVar) {
        AppMethodBeat.i(144211);
        Log.i("MicroMsg.JsApiCreateSocketTask", "JsApiCreateSocketTask, programType:%d", Integer.valueOf(i2));
        this.mgi = i2;
        this.mgf = cVar;
        AppMethodBeat.o(144211);
    }

    public static void a(k.a aVar) {
        mge = aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String bjl() {
        AppMethodBeat.i(144212);
        StringBuilder sb = new StringBuilder();
        l.bPF();
        String sb2 = sb.append(l.bPw()).toString();
        AppMethodBeat.o(144212);
        return sb2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String auJ() {
        return "socketTaskId";
    }

    public static void a(f fVar, String str, b bVar, String str2, e eVar) {
        AppMethodBeat.i(207091);
        if (bVar == b.SUSPEND || bVar == b.DESTROYED) {
            d adh = l.bPF().adh(str);
            if (adh == null) {
                AppMethodBeat.o(207091);
                return;
            }
            adh.a(adh.aby(str2));
            HashMap hashMap = new HashMap();
            hashMap.put("reason", "interrupted");
            hashMap.put("socketTaskId", str2);
            hashMap.put("state", "close");
            new a().h(fVar).Zh(new JSONObject(hashMap).toString()).a(eVar.mgb.Zz(str2));
            eVar.mgb.remove(str2);
        }
        AppMethodBeat.o(207091);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final void a(final f fVar, JSONObject jSONObject, final String str) {
        AppMethodBeat.i(179501);
        if (!this.mgl.getAndSet(true)) {
            if (this.mgf != null) {
                this.mgj = this.mgf.Uw(fVar.getAppId());
                k.c cVar = this.mgf;
                fVar.getAppId();
                this.mgk = cVar.btz();
            }
            WcWss.bLo();
        }
        k adh = l.bPF().adh(fVar.getAppId());
        if (adh == null) {
            if (((this.mgi != mgg || !this.mgj) && (this.mgi != mgh || !this.mgk)) || (this.mgb.Zz(str) != null && !(this.mgb.Zz(str) instanceof i))) {
                Log.d("MicroMsg.JsApiCreateSocketTask", "hy: trigger use legacy ws");
                adh = new k((com.tencent.mm.plugin.appbrand.s.a) fVar.av(com.tencent.mm.plugin.appbrand.s.a.class));
            } else {
                adh = new com.tencent.mm.plugin.appbrand.jsapi.websocket.a((com.tencent.mm.plugin.appbrand.s.a) fVar.av(com.tencent.mm.plugin.appbrand.s.a.class));
            }
            l bPF = l.bPF();
            String appId = fVar.getAppId();
            if (!bPF.nhY.containsKey(appId)) {
                bPF.nhY.put(appId, adh);
            }
        }
        final boolean optBoolean = jSONObject.optBoolean("enableProfile", true);
        AnonymousClass1 r7 = new d.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.o.e.AnonymousClass1 */
            boolean mgm = false;

            @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a
            public final void a(h hVar, Map<String, Long> map) {
                AppMethodBeat.i(175385);
                if (e.mge != null) {
                    e.mge.a(fVar, str, e.this);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("socketTaskId", str);
                hashMap.put("state", WeChatBrands.Business.GROUP_OPEN);
                hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, e.b(hVar));
                if (map != null && map.size() > 0 && optBoolean) {
                    hashMap.put(Scopes.PROFILE, map);
                }
                new a().h(fVar).Zh(new JSONObject(hashMap).toString()).a(e.this.mgb.Zz(str));
                AppMethodBeat.o(175385);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a
            public final void a(com.tencent.mm.plugin.appbrand.ae.e.a aVar) {
                AppMethodBeat.i(144205);
                if (aVar == null || !((com.tencent.mm.plugin.appbrand.s.a) fVar.av(com.tencent.mm.plugin.appbrand.s.a.class)).cyp) {
                    AppMethodBeat.o(144205);
                    return;
                }
                n nVar = new n();
                nVar.dCn.dCo = "socket";
                nVar.dCn.dCq = e.b(aVar);
                nVar.dCn.dCp = str;
                EventCenter.instance.publish(nVar);
                AppMethodBeat.o(144205);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a
            public final void XT(String str) {
                AppMethodBeat.i(144206);
                if (this.mgm) {
                    Log.i("MicroMsg.JsApiCreateSocketTask", "onSocketError is true");
                    AppMethodBeat.o(144206);
                    return;
                }
                this.mgm = true;
                HashMap hashMap = new HashMap();
                hashMap.put("socketTaskId", str);
                hashMap.put("state", "error");
                hashMap.put("errMsg", str);
                new a().h(fVar).Zh(new JSONObject(hashMap).toString()).a(e.this.mgb.Zz(str));
                e.this.mgb.remove(str);
                if (e.this.mgj || e.this.mgk) {
                    ((com.tencent.mm.plugin.appbrand.w.a) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972, 2, 1, false);
                    AppMethodBeat.o(144206);
                    return;
                }
                ((com.tencent.mm.plugin.appbrand.w.a) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972, 1, 1, false);
                AppMethodBeat.o(144206);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a
            public final void aar(String str) {
                AppMethodBeat.i(144207);
                HashMap hashMap = new HashMap();
                hashMap.put("data", y.afI(str));
                hashMap.put("isBuffer", Boolean.FALSE);
                hashMap.put("socketTaskId", str);
                hashMap.put("state", "message");
                new a().h(fVar).Zh(new JSONObject(hashMap).toString()).a(e.this.mgb.Zz(str));
                AppMethodBeat.o(144207);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a
            public final void k(ByteBuffer byteBuffer) {
                AppMethodBeat.i(144208);
                HashMap hashMap = new HashMap();
                hashMap.put("socketTaskId", str);
                hashMap.put("data", byteBuffer);
                hashMap.put("isBuffer", Boolean.TRUE);
                hashMap.put("state", "message");
                x.b a2 = x.a(fVar.getJsRuntime(), hashMap, (x.a) fVar.av(x.a.class));
                if (a2 == x.b.OK) {
                    new a().h(fVar).Zh(new JSONObject(hashMap).toString()).a(e.this.mgb.Zz(str));
                    AppMethodBeat.o(144208);
                    return;
                }
                if (a2 == x.b.FAIL_SIZE_EXCEED_LIMIT) {
                    x.m(fVar, a.NAME);
                }
                AppMethodBeat.o(144208);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a
            public final void ae(int i2, String str) {
                AppMethodBeat.i(144209);
                if (e.mge != null) {
                    e.mge.d(fVar, str);
                }
                HashMap hashMap = new HashMap();
                if (j.b(fVar.getAppState())) {
                    hashMap.put("reason", "interrupted");
                } else if (!Util.isNullOrNil(str)) {
                    hashMap.put("reason", str);
                }
                hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, Integer.valueOf(i2));
                hashMap.put("socketTaskId", str);
                hashMap.put("state", "close");
                new a().h(fVar).Zh(new JSONObject(hashMap).toString()).a(e.this.mgb.Zz(str));
                e.this.mgb.remove(str);
                AppMethodBeat.o(144209);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a
            public final void XU(String str) {
                AppMethodBeat.i(144210);
                e.a(e.this, fVar, str, str);
                AppMethodBeat.o(144210);
            }
        };
        String optString = jSONObject.optString("url");
        if (Util.isNullOrNil(optString)) {
            Log.i("MicroMsg.JsApiCreateSocketTask", "url is null");
            b(fVar, str, "url is null");
            AppMethodBeat.o(179501);
            return;
        }
        Log.i("MicroMsg.JsApiCreateSocketTask", "useProfile:%b,url is:%s", Boolean.valueOf(optBoolean), optString);
        com.tencent.mm.plugin.appbrand.s.a aVar = (com.tencent.mm.plugin.appbrand.s.a) fVar.av(com.tencent.mm.plugin.appbrand.s.a.class);
        Map<String, String> a2 = j.a(jSONObject, aVar);
        if (!(jSONObject.optBoolean("__skipDomainCheck__") ? false : aVar.nhD) || j.a(aVar.cyU, optString, aVar.cyP)) {
            int optInt = jSONObject.optInt("timeout", 0);
            if (optInt <= 0) {
                optInt = j.a(aVar, 1);
            }
            if (optInt <= 0) {
                optInt = 60000;
            }
            adh.a(fVar.getAppId(), str, this.mgi, optInt, jSONObject, a2, r7);
            if (this.mgj || this.mgk) {
                ((com.tencent.mm.plugin.appbrand.w.a) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972, 10, 1, false);
            } else {
                ((com.tencent.mm.plugin.appbrand.w.a) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972, 0, 1, false);
            }
            Log.i("MicroMsg.JsApiCreateSocketTask", "connectSocket, url is : %s , componentId: %s", optString, Integer.valueOf(fVar.getComponentId()));
            AppMethodBeat.o(179501);
            return;
        }
        Log.i("MicroMsg.JsApiCreateSocketTask", "not in domain url %s", optString);
        b(fVar, str, "url not in domain list");
        AppMethodBeat.o(179501);
    }

    private static JSONObject a(com.tencent.mm.plugin.appbrand.ae.e.f fVar) {
        AppMethodBeat.i(144215);
        JSONObject jSONObject = new JSONObject();
        Iterator<String> bZO = fVar.bZO();
        while (bZO.hasNext()) {
            try {
                String next = bZO.next();
                jSONObject.put(next, fVar.afQ(next));
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.JsApiCreateSocketTask", e2, "JSONExceptions ", new Object[0]);
            }
        }
        AppMethodBeat.o(144215);
        return jSONObject;
    }

    private void b(f fVar, String str, String str2) {
        String concat;
        AppMethodBeat.i(144216);
        if (Util.isNullOrNil(str2)) {
            concat = "fail";
        } else {
            concat = "fail:".concat(String.valueOf(str2));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("socketTaskId", str);
        hashMap.put("state", "error");
        hashMap.put("errMsg", concat);
        String jSONObject = new JSONObject(hashMap).toString();
        new a().h(fVar).Zh(jSONObject).a(this.mgb.Zz(str));
        this.mgb.remove(str);
        Log.d("MicroMsg.JsApiCreateSocketTask", "onSocketConnectFail jsonResult:%s ", jSONObject);
        ((com.tencent.mm.plugin.appbrand.w.a) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972, 3, 1, false);
        AppMethodBeat.o(144216);
    }
}
