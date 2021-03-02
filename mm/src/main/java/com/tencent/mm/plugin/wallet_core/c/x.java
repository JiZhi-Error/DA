package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class x extends m {
    public String HQa;
    public int HQb;
    public String HQc;
    public String HQd;

    public x(String str, String str2) {
        AppMethodBeat.i(69939);
        HashMap hashMap = new HashMap();
        hashMap.put("token", str);
        hashMap.put("use_touch", "1");
        setRequestData(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("soter_req", str2);
        setWXRequestData(hashMap2);
        AppMethodBeat.o(69939);
    }

    public x(String str, String str2, byte b2) {
        AppMethodBeat.i(69940);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("token", str2);
        setRequestData(hashMap);
        setWXRequestData(new HashMap());
        AppMethodBeat.o(69940);
    }

    public x(String str, String str2, char c2) {
        AppMethodBeat.i(69941);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("token", str2);
        hashMap.put("resend", "1");
        setRequestData(hashMap);
        setWXRequestData(new HashMap());
        AppMethodBeat.o(69941);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 100;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69942);
        Log.d("Micromsg.NetSceneTenpayCheckPwdByToken", "errCode " + i2 + " errMsg: " + str);
        this.HQa = jSONObject.optString("usertoken");
        this.HQb = jSONObject.optInt("is_free_sms");
        this.HQc = jSONObject.optString("mobile_no");
        this.HQd = jSONObject.optString("relation_key");
        AppMethodBeat.o(69942);
    }

    public final boolean fPR() {
        return this.HQb == 0;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1515;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getusertoken";
    }
}
