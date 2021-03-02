package com.tencent.mm.plugin.wxcredit.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends m {
    public List<l> JPJ;
    public int JPK;
    public String token;

    public e(String str) {
        AppMethodBeat.i(72305);
        HashMap hashMap = new HashMap();
        hashMap.put("bind_serialno", str);
        setRequestData(hashMap);
        AppMethodBeat.o(72305);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 59;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72306);
        Log.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            AppMethodBeat.o(72306);
            return;
        }
        try {
            this.token = jSONObject.getString("session_key");
            this.JPK = jSONObject.optInt("answer_times_left", -1);
            JSONArray jSONArray = jSONObject.getJSONArray("Array");
            if (jSONArray != null && jSONArray.length() > 0) {
                HashMap hashMap = new HashMap();
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    l lVar = new l();
                    lVar.id = jSONObject2.getString("qt_id");
                    lVar.JQc = jSONObject2.getString("parent_id");
                    lVar.type = jSONObject2.getString("qt_type");
                    lVar.desc = jSONObject2.getString("qt_cont");
                    lVar.JQd = jSONObject2.getInt("ans_len");
                    lVar.pWf = jSONObject2.getString("wording");
                    lVar.level = jSONObject2.getInt("level");
                    if (!hashMap.containsKey(lVar.JQc) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(lVar.JQc)) {
                        hashMap.put(lVar.id, lVar);
                    } else {
                        ((l) hashMap.get(lVar.JQc)).JQe = lVar;
                    }
                }
                this.JPJ = new ArrayList(hashMap.values());
                hashMap.clear();
            }
            AppMethodBeat.o(72306);
        } catch (JSONException e2) {
            Log.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e2, "", new Object[0]);
            AppMethodBeat.o(72306);
        }
    }
}
