package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.f;
import java.math.RoundingMode;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends m implements j, ITenpaySave {
    public boolean HsT = false;
    public String HsU = "";
    public String dNQ = null;
    public String egd;
    public String ege;
    public String egf;
    public String egg;
    public String egh;
    private ITenpaySave.RetryPayInfo retryPayInfo;

    public e(double d2, String str, String str2, String str3) {
        AppMethodBeat.i(68396);
        HashMap hashMap = new HashMap();
        hashMap.put("total_fee", f.c(String.valueOf(d2), "100", 0, RoundingMode.HALF_UP).toString());
        hashMap.put("fee_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("bank_type", str3);
        setRequestData(hashMap);
        AppMethodBeat.o(68396);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 74;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(68397);
        Log.d("Micromsg.NetSceneTenpayBalanceSave", "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            AppMethodBeat.o(68397);
            return;
        }
        this.dNQ = jSONObject.optString("req_key");
        this.HsT = "1".equals(jSONObject.optString("should_alert"));
        this.HsU = jSONObject.optString("alert_msg");
        if (jSONObject.has("real_name_info")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
            Log.i("Micromsg.NetSceneTenpayBalanceSave", "get real_name_info %s", optJSONObject.toString());
            this.egd = optJSONObject.optString("guide_flag");
            this.ege = optJSONObject.optString("guide_wording");
            this.egf = optJSONObject.optString("left_button_wording");
            this.egg = optJSONObject.optString("right_button_wording");
            this.egh = optJSONObject.optString("upload_credit_url");
        }
        this.retryPayInfo = new ITenpaySave.RetryPayInfo();
        this.retryPayInfo.bK(jSONObject);
        AppMethodBeat.o(68397);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1502;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/genpresave";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.ITenpaySave
    public final ITenpaySave.RetryPayInfo getRetryPayInfo() {
        return this.retryPayInfo;
    }
}
