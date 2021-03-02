package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class bh {
    public cbe yUC;
    public bg yXV;

    public static bh aDy(String str) {
        AppMethodBeat.i(65312);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(65312);
            return null;
        }
        try {
            bh bhVar = new bh();
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("operation");
            if (optJSONObject != null) {
                bhVar.yXV = ac.ba(optJSONObject);
            }
            bhVar.yUC = ac.bb(jSONObject.optJSONObject("source"));
            AppMethodBeat.o(65312);
            return bhVar;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.ShowSourceOpen", e2, "", new Object[0]);
            AppMethodBeat.o(65312);
            return null;
        }
    }
}
