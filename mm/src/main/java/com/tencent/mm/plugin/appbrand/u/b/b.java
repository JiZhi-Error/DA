package com.tencent.mm.plugin.appbrand.u.b;

import com.tencent.luggage.h.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private static a nkg = null;

    public interface a {
        void a(AppBrandRuntime appBrandRuntime, JSONObject jSONObject);
    }

    public static void a(a aVar) {
        nkg = aVar;
    }

    public static JSONObject ac(AppBrandRuntime appBrandRuntime) {
        int i2;
        AppMethodBeat.i(147390);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", appBrandRuntime.mAppId);
            jSONObject.put("appversion", appBrandRuntime.OT() == null ? 0 : appBrandRuntime.OT().leE.pkgVersion);
            if (appBrandRuntime.OT() == null) {
                i2 = 0;
            } else {
                i2 = appBrandRuntime.OT().leE.kNW + 1;
            }
            jSONObject.put("appstate", i2);
        } catch (JSONException e2) {
            Log.e("MicroMsg.PrepareDataForNodeHelper", "prepareCommonData e:%s", e2);
        }
        com.tencent.mm.plugin.appbrand.s.a aVar = (com.tencent.mm.plugin.appbrand.s.a) appBrandRuntime.av(com.tencent.mm.plugin.appbrand.s.a.class);
        if (aVar != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("maxWebsocketConcurrent", aVar.nhI);
                jSONObject2.put("socketDomains", e.H(aVar.cyU));
                jSONObject2.put("websocketSkipPortCheck", aVar.cyP);
                jSONObject2.put("websocketTimeoutMS", aVar.nhF);
                jSONObject2.put("headerFilterMode", aVar.mode);
                jSONObject2.put("blacklistHeaders", e.H(aVar.nhJ));
                jSONObject2.put("whitelistHeaders", e.H(aVar.nhK));
                jSONObject2.put("referer", aVar.referer);
                jSONObject2.put("canSkipCheckDomainsByArg", aVar.nhC);
                jSONObject2.put("shouldCheckDomains", aVar.nhD);
                jSONObject2.put("userAgentString", aVar.nhM);
                jSONObject.put("networkConfig", jSONObject2);
            } catch (JSONException e3) {
                Log.e("MicroMsg.PrepareDataForNodeHelper", "prepareNetworkConfigData e:%s", e3);
            }
        }
        x.a aVar2 = (x.a) appBrandRuntime.av(x.a.class);
        if (aVar2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("nativeBufferSizeLimitByte", aVar2.ldb);
                jSONObject3.put("itemBase64", aVar2.ohn);
                jSONObject3.put("itemID", aVar2.ohm);
                jSONObject3.put("itemKey", aVar2.ohl);
                jSONObject3.put("outKey", aVar2.ohk);
                jSONObject.put("nativeBufferConfig", jSONObject3);
            } catch (JSONException e4) {
                Log.e("MicroMsg.PrepareDataForNodeHelper", "prepareNativeBufferConfigData e:%s", e4);
            }
        }
        b(appBrandRuntime, jSONObject);
        if (nkg != null) {
            nkg.a(appBrandRuntime, jSONObject);
        }
        Log.v("MicroMsg.PrepareDataForNodeHelper", "prepareDataForNode :%s", jSONObject.toString());
        AppMethodBeat.o(147390);
        return jSONObject;
    }

    private static void b(AppBrandRuntime appBrandRuntime, JSONObject jSONObject) {
        AppMethodBeat.i(147391);
        if (!(appBrandRuntime.getFileSystem() instanceof v)) {
            IllegalStateException illegalStateException = new IllegalStateException("getFileSystem not LuggageFileSystemRegistry");
            AppMethodBeat.o(147391);
            throw illegalStateException;
        }
        JSONObject jSONObject2 = new JSONObject();
        LinkedList<q> linkedList = ((v) appBrandRuntime.getFileSystem()).kTe;
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            q qVar = linkedList.get(i2);
            if (qVar instanceof z) {
                z zVar = (z) qVar;
                String str = zVar.kSr;
                String str2 = zVar.kTj;
                long j2 = zVar.kTk;
                Log.i("MicroMsg.PrepareDataForNodeHelper", "prepareFSData rootPath:%s pathPrefix:%s quota:%d", str, str2, Long.valueOf(j2));
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("type", 1);
                    jSONObject3.put("rootPath", str);
                    jSONObject3.put("quota", j2);
                    jSONObject2.put(str2, jSONObject3);
                } catch (JSONException e2) {
                    Log.e("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", e2);
                }
            }
        }
        for (q qVar2 : linkedList) {
            if (qVar2 instanceof o) {
                o oVar = (o) qVar2;
                String str3 = oVar.kSr;
                String str4 = oVar.kSq;
                try {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("type", 0);
                    jSONObject4.put("rootPath", str3);
                    jSONObject2.put(str4, jSONObject4);
                } catch (JSONException e3) {
                    Log.e("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", e3);
                }
            }
        }
        try {
            jSONObject.put("fsData", jSONObject2);
            AppMethodBeat.o(147391);
        } catch (JSONException e4) {
            Log.e("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", e4);
            AppMethodBeat.o(147391);
        }
    }
}
