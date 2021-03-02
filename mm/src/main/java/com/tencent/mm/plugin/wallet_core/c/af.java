package com.tencent.mm.plugin.wallet_core.c;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class af extends m {
    public String HQn = "";
    public JSONObject lxS;

    public af(String str, String str2, String str3, String str4, String str5, String str6, long j2) {
        AppMethodBeat.i(69957);
        this.HQn = str;
        HashMap hashMap = new HashMap();
        hashMap.put("activity_id", str);
        hashMap.put("award_id", str2);
        hashMap.put("send_record_id", str3);
        hashMap.put("user_record_id", str4);
        hashMap.put("req_key", str5);
        hashMap.put(FirebaseAnalytics.b.TRANSACTION_ID, str6);
        hashMap.put("activity_mch_id", String.valueOf(j2));
        setRequestData(hashMap);
        AppMethodBeat.o(69957);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1979;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/querypayaward";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1979;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69958);
        Log.i("MicroMsg.NetSceneTenpayQueryPayaward", "errcode %s errmsg %s json %s", Integer.valueOf(i2), str, jSONObject);
        this.lxS = jSONObject;
        AppMethodBeat.o(69958);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final boolean isBlock() {
        return false;
    }
}
