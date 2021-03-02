package com.tencent.mm.plugin.remittance.model;

import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.wallet_core.utils.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class v extends m {
    public String CoU;
    public b yXE;
    public String yXG;
    public String yXI;
    public b zdG;

    public v(String str, String str2, int i2, String str3, String str4, int i3) {
        this(str, str2, i2, str3, str4, i3, "");
        AppMethodBeat.i(67883);
        AppMethodBeat.o(67883);
    }

    public v(String str, String str2, int i2, String str3, String str4, int i3, String str5) {
        AppMethodBeat.i(213733);
        this.CoU = null;
        this.yXI = "";
        this.yXG = "";
        this.CoU = str3;
        HashMap hashMap = new HashMap();
        hashMap.put("trans_id", str2);
        hashMap.put(FirebaseAnalytics.b.TRANSACTION_ID, str);
        hashMap.put("op", str3);
        hashMap.put(ch.COL_USERNAME, str4);
        hashMap.put("invalid_time", String.valueOf(i3));
        hashMap.put("total_fee", String.valueOf(i2));
        hashMap.put("left_button_continue", str5);
        Log.i("Micromsg.NetSceneTenpayRemittanceQuery", "trans_id=" + str2 + ";transaction_id=" + str + ";total_fee=" + i2);
        setRequestData(hashMap);
        AppMethodBeat.o(213733);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1691;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferoperation";
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(67884);
        Log.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            AppMethodBeat.o(67884);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
        if (optJSONObject != null) {
            this.yXI = optJSONObject.optString("guide_flag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        if (jSONObject.has("intercept_win")) {
            this.yXE = b.bV(jSONObject.optJSONObject("intercept_win"));
        }
        if (jSONObject.has("intercept_win_after")) {
            this.zdG = b.bV(jSONObject.optJSONObject("intercept_win_after"));
        }
        if (jSONObject.has("left_button_continue")) {
            this.yXG = jSONObject.optString("left_button_continue");
        }
        AppMethodBeat.o(67884);
    }
}
