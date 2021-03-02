package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends m {
    private Map<String, String> AJV = new HashMap();
    public boolean JPE = false;
    public String dSf;
    public boolean efW = true;
    public String token;

    public a(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(72296);
        this.AJV.put("session_key", str3);
        this.AJV.put("bank_type", str4);
        this.AJV.put("name", str);
        this.AJV.put("cre_id", str2);
        setRequestData(this.AJV);
        AppMethodBeat.o(72296);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final boolean resend() {
        AppMethodBeat.i(72297);
        super.resend();
        this.AJV.put("retry", "1");
        setRequestData(this.AJV);
        AppMethodBeat.o(72297);
        return true;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 64;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72298);
        Log.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            AppMethodBeat.o(72298);
            return;
        }
        try {
            this.token = jSONObject.optString("session_key");
            this.efW = "1".equals(jSONObject.getString("need_bind"));
            this.JPE = "1".equals(jSONObject.getString("bank_user"));
            this.dSf = jSONObject.optString("mobile_no");
            AppMethodBeat.o(72298);
        } catch (JSONException e2) {
            Log.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e2, "", new Object[0]);
            AppMethodBeat.o(72298);
        }
    }
}
