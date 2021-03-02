package com.tencent.mm.plugin.appbrand.jsapi.o.b;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.Scopes;
import com.tencent.luggage.a.e;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.n;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.s.d;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.s.o;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class a implements h {
    public static int mgg = 0;
    public static int mgh = 1;
    private d.b mgG;
    private boolean mgH = false;
    private boolean mgI = false;
    private boolean mgJ = false;
    private com.tencent.mm.plugin.appbrand.jsapi.base.a mgb;
    private int mgi = mgg;
    private final AtomicBoolean mgl = new AtomicBoolean(false);

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.o.b.a$a  reason: collision with other inner class name */
    public static class C0692a extends bc {
        public static final int CTRL_INDEX = 244;
        public static final String NAME = "onRequestTaskStateChange";
    }

    static /* synthetic */ void a(a aVar, f fVar, String str, String str2) {
        AppMethodBeat.i(207097);
        aVar.b(fVar, str, str2);
        AppMethodBeat.o(207097);
    }

    public a(int i2, d.b bVar, com.tencent.mm.plugin.appbrand.jsapi.base.a aVar) {
        AppMethodBeat.i(207096);
        Log.i("MicroMsg.BaseCreateRequestTask", "JsApiCreateRequestTask, programType:%d", Integer.valueOf(i2));
        this.mgi = i2;
        this.mgG = bVar;
        this.mgb = aVar;
        AppMethodBeat.o(207096);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String bjl() {
        AppMethodBeat.i(179524);
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.plugin.appbrand.s.f.bPA();
        String sb2 = sb.append(com.tencent.mm.plugin.appbrand.s.f.bPw()).toString();
        AppMethodBeat.o(179524);
        return sb2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String auJ() {
        return "requestTaskId";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final void a(f fVar, JSONObject jSONObject, final String str) {
        d acZ;
        AppMethodBeat.i(179525);
        Log.d("MicroMsg.BaseCreateRequestTask", "JsApiCreateRequestTask");
        if (!this.mgl.getAndSet(true)) {
            if (this.mgG != null) {
                d.b bVar = this.mgG;
                fVar.getAppId();
                this.mgH = bVar.btA();
                d.b bVar2 = this.mgG;
                fVar.getAppId();
                this.mgI = bVar2.btz();
                d.b bVar3 = this.mgG;
                fVar.getAppId();
                this.mgJ = bVar3.btB();
            }
            if (this.mgH || this.mgI) {
                com.tencent.mm.plugin.appbrand.s.a aVar = (com.tencent.mm.plugin.appbrand.s.a) fVar.av(com.tencent.mm.plugin.appbrand.s.a.class);
                if (aVar == null) {
                    Log.e("MicroMsg.BaseCreateRequestTask", "setupRequestMode config not found, setUserCertVerify false appId(%s)", fVar.getAppId());
                    CronetLogic.setUserCertVerify(false);
                } else {
                    Log.i("MicroMsg.BaseCreateRequestTask", "setupRequestMode(%b),appId(%s)", Boolean.valueOf(aVar.nhO), fVar.getAppId());
                    CronetLogic.setUserCertVerify(aVar.nhO);
                }
            }
            if (this.mgJ) {
                Log.i("MicroMsg.BaseCreateRequestTask", "setUseHttpdns(%b),appId(%s)", Boolean.TRUE, fVar.getAppId());
                CronetLogic.setUseHttpdns(true);
            }
        }
        final WeakReference weakReference = new WeakReference(fVar);
        final long currentTimeMillis = System.currentTimeMillis();
        AnonymousClass1 r1 = new d.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.o.b.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.s.d.a
            public final void dC(String str, String str2) {
                int length;
                AppMethodBeat.i(179520);
                f fVar = (f) weakReference.get();
                Object[] objArr = new Object[4];
                objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                if (str2 == null) {
                    length = 0;
                } else {
                    length = str2.length();
                }
                objArr[1] = Integer.valueOf(length);
                objArr[2] = str;
                objArr[3] = fVar;
                Log.i("MicroMsg.BaseCreateRequestTask", "onRequestResult, time: %d, data size: %d,requestTaskId %s, service:%s", objArr);
                if (fVar == null) {
                    AppMethodBeat.o(179520);
                    return;
                }
                if ("fail".equals(str)) {
                    Log.e("MicroMsg.BaseCreateRequestTask", "onRequestResult taskId[%s] reason[%s] data[%s]", str, str, str2);
                }
                d acZ = com.tencent.mm.plugin.appbrand.s.f.bPA().acZ(fVar.getAppId());
                if (acZ == null || !acZ.acT(str)) {
                    a.a(a.this, fVar, str, str2);
                    ((o) e.N(o.class)).Yl(fVar.getAppId());
                    AppMethodBeat.o(179520);
                    return;
                }
                Log.e("MicroMsg.BaseCreateRequestTask", "request abort %s", str);
                AppMethodBeat.o(179520);
            }

            @Override // com.tencent.mm.plugin.appbrand.s.d.a
            public final void a(String str, Object obj, int i2, JSONObject jSONObject, Map map) {
                int i3;
                AppMethodBeat.i(179521);
                if (obj != null && (obj instanceof ByteBuffer)) {
                    i3 = ((ByteBuffer) obj).array().length;
                } else if (obj == null || !(obj instanceof String)) {
                    i3 = 0;
                } else {
                    i3 = ((String) obj).length();
                }
                f fVar = (f) weakReference.get();
                Log.i("MicroMsg.BaseCreateRequestTask", "onRequestResultWithCode, time: %d, data size: %d, code %s,requestTaskId %s, service:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(i3), Integer.valueOf(i2), str, fVar);
                if (fVar == null) {
                    AppMethodBeat.o(179521);
                    return;
                }
                d acZ = com.tencent.mm.plugin.appbrand.s.f.bPA().acZ(fVar.getAppId());
                if (acZ == null || !acZ.acT(str)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("requestTaskId", str);
                    if (str.equalsIgnoreCase("ok")) {
                        hashMap.put("state", "success");
                        hashMap.put("data", obj);
                        if (map != null && map.size() > 0) {
                            hashMap.put(Scopes.PROFILE, map);
                        }
                    } else {
                        hashMap.put("state", "fail");
                    }
                    hashMap.put("statusCode", Integer.valueOf(i2));
                    if (jSONObject != null) {
                        hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, jSONObject);
                    }
                    C0692a aVar = new C0692a();
                    x.b a2 = x.a(fVar.getJsRuntime(), hashMap, (x.a) fVar.av(x.a.class));
                    if ((obj != null && (obj instanceof String)) || a2 == x.b.OK) {
                        aVar.h(fVar).Zh(new JSONObject(hashMap).toString()).a(a.this.mgb.Zz(str));
                    } else if (a2 == x.b.FAIL_SIZE_EXCEED_LIMIT) {
                        x.m(fVar, C0692a.NAME);
                    }
                    a.this.mgb.remove(str);
                    AppMethodBeat.o(179521);
                    return;
                }
                Log.d("MicroMsg.BaseCreateRequestTask", "request abort %s", str);
                AppMethodBeat.o(179521);
            }

            @Override // com.tencent.mm.plugin.appbrand.s.d.a
            public final void J(JSONObject jSONObject) {
                AppMethodBeat.i(179522);
                if (jSONObject == null) {
                    AppMethodBeat.o(179522);
                    return;
                }
                f fVar = (f) weakReference.get();
                if (fVar == null) {
                    AppMethodBeat.o(179522);
                } else if (!jSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("requestTaskId", str);
                    hashMap.put("state", "headersReceived");
                    hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, jSONObject);
                    C0692a aVar = new C0692a();
                    aVar.h(fVar).Zh(new JSONObject(hashMap).toString()).a(a.this.mgb.Zz(str));
                    AppMethodBeat.o(179522);
                } else if (!((com.tencent.mm.plugin.appbrand.s.a) fVar.av(com.tencent.mm.plugin.appbrand.s.a.class)).cyp) {
                    AppMethodBeat.o(179522);
                } else {
                    jSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
                    n nVar = new n();
                    nVar.dCn.dCo = ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID;
                    nVar.dCn.dCq = jSONObject;
                    nVar.dCn.dCp = str;
                    EventCenter.instance.publish(nVar);
                    AppMethodBeat.o(179522);
                }
            }
        };
        String optString = jSONObject.optString("url");
        if (Util.isNullOrNil(optString)) {
            Log.e("MicroMsg.BaseCreateRequestTask", "url is null");
            b(fVar, str, "url is null or nil");
            AppMethodBeat.o(179525);
            return;
        }
        com.tencent.mm.plugin.appbrand.s.a aVar2 = (com.tencent.mm.plugin.appbrand.s.a) fVar.av(com.tencent.mm.plugin.appbrand.s.a.class);
        int i2 = 60000;
        int optInt = jSONObject.optInt("timeout", 0);
        Log.i("MicroMsg.BaseCreateRequestTask", "lm:data configTimeout %d", Integer.valueOf(optInt));
        if (optInt <= 0) {
            optInt = j.a(aVar2, 0);
            Log.i("MicroMsg.BaseCreateRequestTask", "lm:getRequiredTimeout configTimeout %d", Integer.valueOf(optInt));
        }
        if (optInt > 0) {
            i2 = optInt;
        }
        Log.i("MicroMsg.BaseCreateRequestTask", "lm:configTimeout: %d,timeout: %d", Integer.valueOf(optInt), Integer.valueOf(i2));
        if (aVar2.cyK <= 0) {
            Log.i("MicroMsg.BaseCreateRequestTask", "maxRequestConcurrent <= 0 use default concurrent");
        }
        Map<String, String> a2 = j.a(jSONObject, aVar2);
        boolean z = jSONObject.optBoolean("__skipDomainCheck__") ? false : aVar2.nhD;
        if (!z || j.c(aVar2.cyT, optString)) {
            if (com.tencent.mm.plugin.appbrand.s.f.bPA().acZ(fVar.getAppId()) == null) {
                acZ = new d(fVar, this.mgi, this.mgH, this.mgI);
                com.tencent.mm.plugin.appbrand.s.f bPA = com.tencent.mm.plugin.appbrand.s.f.bPA();
                String appId = fVar.getAppId();
                if (!bPA.nhY.containsKey(appId)) {
                    bPA.nhY.put(appId, acZ);
                }
            } else {
                acZ = com.tencent.mm.plugin.appbrand.s.f.bPA().acZ(fVar.getAppId());
            }
            Log.i("MicroMsg.BaseCreateRequestTask", "request url: %s", optString);
            if (acZ == null) {
                b(fVar, str, "create request error");
                AppMethodBeat.o(179525);
            } else if (!z) {
                Log.i("MicroMsg.BaseCreateRequestTask", "debug type, do not verify domains");
                acZ.a(fVar, i2, jSONObject, a2, (ArrayList<String>) null, r1, str, b.NAME);
                AppMethodBeat.o(179525);
            } else {
                acZ.a(fVar, i2, jSONObject, a2, aVar2.cyT, r1, str, b.NAME);
                AppMethodBeat.o(179525);
            }
        } else {
            Log.i("MicroMsg.BaseCreateRequestTask", "not in domain url %s", optString);
            b(fVar, str, "url not in domain list");
            AppMethodBeat.o(179525);
        }
    }

    private final void b(f fVar, String str, String str2) {
        AppMethodBeat.i(179526);
        Log.w("MicroMsg.BaseCreateRequestTask", "sendFailMsg, requestTaskId = %s, errMsg = %s", str, str2);
        HashMap hashMap = new HashMap();
        hashMap.put("requestTaskId", str);
        hashMap.put("state", "fail");
        hashMap.put("errMsg", str2);
        new C0692a().h(fVar).Zh(new JSONObject(hashMap).toString()).a(this.mgb.Zz(str));
        this.mgb.remove(str);
        AppMethodBeat.o(179526);
    }
}
