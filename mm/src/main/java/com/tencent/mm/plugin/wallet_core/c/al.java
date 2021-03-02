package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ag;
import org.json.JSONObject;

public final class al {
    public boolean HQD;
    public ak HQE;
    public String HQF;
    public String HQG;
    public String oqZ;
    public String title;

    public static al bx(JSONObject jSONObject) {
        AppMethodBeat.i(69966);
        if (jSONObject == null) {
            AppMethodBeat.o(69966);
            return null;
        }
        al alVar = new al();
        alVar.title = jSONObject.optString("title");
        alVar.oqZ = jSONObject.optString("sub_title");
        alVar.HQD = jSONObject.optBoolean("is_lqt_user");
        alVar.HQF = jSONObject.optString("lqt_operate_id");
        alVar.HQG = jSONObject.optString("lqt_trace_info");
        ag.aUH(alVar.HQG);
        JSONObject optJSONObject = jSONObject.optJSONObject("open_lqt_info");
        if (optJSONObject != null) {
            alVar.HQE = new ak();
            alVar.HQE.HQB = optJSONObject.optString("open_info");
            alVar.HQE.HQC = optJSONObject.optString("open_url");
            alVar.HQE.lHz = optJSONObject.optInt("route_type");
            alVar.HQE.ixZ = optJSONObject.optString("appname");
        }
        AppMethodBeat.o(69966);
        return alVar;
    }
}
