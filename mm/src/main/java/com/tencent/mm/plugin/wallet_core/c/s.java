package com.tencent.mm.plugin.wallet_core.c;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class s extends m {
    public String HPV;
    public String HPW;
    public Orders.Promotions HPY;
    public String resultMsg;

    public s(Orders.Promotions promotions, String str, String str2, long j2) {
        AppMethodBeat.i(69930);
        this.HPY = promotions;
        HashMap hashMap = new HashMap();
        hashMap.put("activity_id", new StringBuilder().append(promotions.crw).toString());
        hashMap.put("award_id", new StringBuilder().append(promotions.Vgh).toString());
        hashMap.put("send_record_id", new StringBuilder().append(promotions.HYC).toString());
        hashMap.put("user_record_id", new StringBuilder().append(promotions.HYD).toString());
        hashMap.put("req_key", str);
        hashMap.put(FirebaseAnalytics.b.TRANSACTION_ID, str2);
        hashMap.put("activity_mch_id", String.valueOf(j2));
        setRequestData(hashMap);
        AppMethodBeat.o(69930);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1589;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69931);
        Log.i(m.TAG, "onGYNetEnd, errCode: %s, errMsg: %s, json: %s", Integer.valueOf(i2), str, jSONObject);
        if (jSONObject != null && i2 == 0) {
            this.HPV = jSONObject.optString("result_code");
            this.resultMsg = jSONObject.optString("result_msg");
            this.HPW = jSONObject.optString("alert_wording");
        }
        AppMethodBeat.o(69931);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1589;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sendpayaward";
    }
}
