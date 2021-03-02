package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class h {
    public cbe yUC;
    public String yUD;
    public boolean yUE;
    public String yUF;

    public static h aDt(String str) {
        AppMethodBeat.i(65164);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(65164);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            h hVar = new h();
            hVar.yUD = jSONObject.optString("showSourceMac");
            hVar.yUF = jSONObject.optString("illegal_msg");
            hVar.yUE = jSONObject.optBoolean("is_illegal");
            JSONObject optJSONObject = jSONObject.optJSONObject("showSource");
            if (optJSONObject != null) {
                hVar.yUC = ac.bb(optJSONObject);
            }
            AppMethodBeat.o(65164);
            return hVar;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.EnvelopSourceMac", e2, "", new Object[0]);
            AppMethodBeat.o(65164);
            return null;
        }
    }
}
