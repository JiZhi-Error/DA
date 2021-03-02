package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.l;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public cfl IoL;
    public cfl IoM;
    public int IoN;
    public String dQx;

    public static b bV(JSONObject jSONObject) {
        AppMethodBeat.i(214250);
        if (jSONObject == null) {
            Log.w("MicroMsg.InterceptWin", "createFromJSONObject() jsonObject == null");
            AppMethodBeat.o(214250);
            return null;
        }
        b bVar = new b();
        bVar.dQx = jSONObject.optString("wording");
        try {
            bVar.IoL = l.ci(jSONObject.getJSONObject("left_button"));
            bVar.IoM = l.ci(jSONObject.getJSONObject("right_button"));
            bVar.IoN = jSONObject.optInt("win_type");
            AppMethodBeat.o(214250);
            return bVar;
        } catch (JSONException e2) {
            Log.e("MicroMsg.InterceptWin", "createFromJSONObject() Exception:%s", e2.getMessage());
            AppMethodBeat.o(214250);
            return null;
        }
    }
}
