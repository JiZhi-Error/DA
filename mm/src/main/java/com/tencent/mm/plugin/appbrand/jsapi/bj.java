package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bj extends ab<d> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getPluginPermissionBytes";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* bridge */ /* synthetic */ String a(d dVar, JSONObject jSONObject) {
        AppMethodBeat.i(229888);
        String a2 = a(dVar, jSONObject);
        AppMethodBeat.o(229888);
        return a2;
    }

    private String a(d dVar, JSONObject jSONObject) {
        byte[] bArr;
        byte[] bArr2;
        AppMethodBeat.i(229887);
        Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "invoke jsapi: %s", NAME);
        if (dVar == null) {
            Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "fail:service is nil");
            String h2 = h("fail:service is nil", null);
            AppMethodBeat.o(229887);
            return h2;
        } else if (jSONObject == null) {
            Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "fail:data is nil");
            String h3 = h("fail:data is nil", null);
            AppMethodBeat.o(229887);
            return h3;
        } else {
            com.tencent.luggage.sdk.d.d NP = dVar.NP();
            if (NP == null) {
                Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "fail:runtime is nil");
                String h4 = h("fail:runtime is nil", null);
                AppMethodBeat.o(229887);
                return h4;
            }
            com.tencent.mm.plugin.appbrand.permission.d dVar2 = NP.cCn;
            if (dVar2 == null) {
                Log.e("MicroMsg.JsApiGetPluginPermissionBytes", "invoke failed, NULL permissionController with appId:%s", NP.mAppId);
                String h5 = h("fail:internal error", null);
                AppMethodBeat.o(229887);
                return h5;
            }
            try {
                JSONArray jSONArray = new JSONArray(jSONObject.optString("pluginList"));
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    String optString = optJSONObject.optString("pluginId");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("indexes");
                    Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "pluginId:%s,indexes:%s", optString, optJSONArray);
                    if (optJSONArray == null) {
                        Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "fail:indexes is nil");
                        String h6 = h("fail:indexes is nil", null);
                        AppMethodBeat.o(229887);
                        return h6;
                    }
                    int i3 = dVar2.nxp;
                    if (i3 == -1) {
                        bArr2 = new byte[]{1};
                    } else if (i3 == -2) {
                        bArr2 = new byte[]{0};
                    } else if (Util.isNullOrNil(optString)) {
                        bArr2 = null;
                    } else {
                        AppRuntimeApiPermissionBundle aen = dVar2.aen(optString);
                        if (aen == null) {
                            bArr2 = null;
                        } else {
                            if (dVar instanceof s) {
                                switch (dVar2.kEc.kAH.kQM.bwY()) {
                                    case SUSPEND:
                                    case DESTROYED:
                                    case BACKGROUND:
                                        bArr = aen.nxl;
                                        break;
                                    default:
                                        bArr = aen.nxk;
                                        break;
                                }
                            } else {
                                bArr = aen.nxk;
                            }
                            bArr2 = bArr;
                        }
                    }
                    if (bArr2 == null || bArr2.length <= 0) {
                        Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "fail:pluginId:%s ctrlBytes is empty", optString);
                    } else {
                        Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "pluginId:%s ctrlBytes:%d", optString, Integer.valueOf(bArr2.length));
                        JSONArray jSONArray2 = new JSONArray();
                        if (optJSONArray.length() == 0) {
                            for (int i4 = 0; i4 < bArr2.length; i4++) {
                                jSONArray2.put(dVar2.H(bArr2, i4));
                            }
                        } else {
                            for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                                jSONArray2.put(dVar2.H(bArr2, optJSONArray.optInt(i5, -1)));
                            }
                        }
                        hashMap2.put(optString, jSONArray2);
                    }
                }
                hashMap.put("pluginPermissionMap", hashMap2);
                Log.i("MicroMsg.JsApiGetPluginPermissionBytes", "invoke JsApiGetPluginPermissionBytes ok");
                String n = n("ok", hashMap);
                AppMethodBeat.o(229887);
                return n;
            } catch (Exception e2) {
                Log.e("MicroMsg.JsApiGetPluginPermissionBytes", "parse pluginList error:%s", e2);
                String h7 = h("fail:parse pluginList error", null);
                AppMethodBeat.o(229887);
                return h7;
            }
        }
    }
}
