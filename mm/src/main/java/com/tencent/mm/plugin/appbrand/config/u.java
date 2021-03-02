package com.tencent.mm.plugin.appbrand.config;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eqm;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public enum u {
    ;

    public static u valueOf(String str) {
        AppMethodBeat.i(147005);
        u uVar = (u) Enum.valueOf(u.class, str);
        AppMethodBeat.o(147005);
        return uVar;
    }

    static ex E(JSONObject jSONObject) {
        AppMethodBeat.i(147006);
        JSONObject optJSONObject = jSONObject.optJSONObject("AppConfig");
        ex exVar = new ex();
        if (optJSONObject != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("VersionList");
            exVar.KIo = new LinkedList<>();
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                    eqm eqm = new eqm();
                    eqm.type = optJSONObject2.optInt("type");
                    eqm.version = optJSONObject2.optInt("version");
                    exVar.KIo.add(eqm);
                }
            }
        }
        AppMethodBeat.o(147006);
        return exVar;
    }

    public static void a(AppBrandSysConfigLU appBrandSysConfigLU, String str) {
        boolean z;
        AppMethodBeat.i(147007);
        appBrandSysConfigLU.ley = true;
        appBrandSysConfigLU.lez = true;
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.AppBrandSysConfigUtil", "operationInfo nil");
            AppMethodBeat.o(147007);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("bgKeepAlive");
            appBrandSysConfigLU.ley = jSONObject.optInt("music", 1) == 1;
            if (jSONObject.optInt(FirebaseAnalytics.b.LOCATION, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            appBrandSysConfigLU.lez = z;
            AppMethodBeat.o(147007);
        } catch (JSONException e2) {
            Log.w("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo operationInfo:%s", str);
            Log.w("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo exp:%s", e2);
            AppMethodBeat.o(147007);
        }
    }
}
