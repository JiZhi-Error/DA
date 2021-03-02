package com.tencent.mm.plugin.wallet.balance.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.f;
import java.math.RoundingMode;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends m implements j, ITenpaySave {
    public double CoZ = 0.0d;
    public double Cpj = 0.0d;
    public boolean HsT = false;
    public String HsU = "";
    public b HsV;
    public b HsW;
    public com.tencent.mm.plugin.wallet_core.model.j HsX;
    public String HsY;
    public boolean HsZ = false;
    public a Hta;
    public String Htb;
    public int dDe = 0;
    public String dNQ = null;
    public String egd;
    public String ege;
    public String egf;
    public String egg;
    public String egh;
    private ITenpaySave.RetryPayInfo retryPayInfo;

    public static class a {
        public String Htc;
        public String content;
        public String gTt;
        public String title;
    }

    public d(double d2, String str, String str2, int i2) {
        AppMethodBeat.i(68394);
        HashMap hashMap = new HashMap();
        hashMap.put("total_fee", f.c(String.valueOf(d2), "100", 0, RoundingMode.HALF_UP).toString());
        hashMap.put("fee_type", str);
        hashMap.put("bank_type", str2);
        hashMap.put("operation", String.valueOf(i2));
        hashMap.put("charge_rate_version", (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_FETCH_CHARGE_RATE_VERSION_STRING_SYNC, ""));
        setRequestData(hashMap);
        AppMethodBeat.o(68394);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 75;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        boolean z = false;
        AppMethodBeat.i(68395);
        Log.d("Micromsg.NetSceneTenpayBalanceFetch", "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            AppMethodBeat.o(68395);
            return;
        }
        this.dNQ = jSONObject.optString("req_key");
        this.HsT = "1".equals(jSONObject.optString("should_alert"));
        this.HsU = jSONObject.optString("alert_msg");
        this.CoZ = f.a(jSONObject.optString("charge_fee", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", 2, RoundingMode.HALF_UP);
        this.Cpj = f.a(jSONObject.optString("total_fee", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", 2, RoundingMode.HALF_UP);
        JSONObject optJSONObject = jSONObject.optJSONObject("first_fetch_info");
        if (optJSONObject != null) {
            Log.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is valid");
            this.HsV = ai.c(optJSONObject, false);
        } else {
            Log.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is null");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("need_charge_fee_info");
        if (optJSONObject2 != null) {
            Log.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is valid");
            this.HsW = ai.c(optJSONObject2, false);
        } else {
            Log.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is null");
        }
        this.dDe = jSONObject.optInt("operation", 0);
        Log.i("Micromsg.NetSceneTenpayBalanceFetch", "charge_fee:" + this.CoZ + " total_fee:" + this.Cpj + " operation:" + this.dDe);
        if (jSONObject.has("real_name_info")) {
            JSONObject optJSONObject3 = jSONObject.optJSONObject("real_name_info");
            Log.i("Micromsg.NetSceneTenpayBalanceFetch", "get real_name_info %s", optJSONObject3.toString());
            this.egd = optJSONObject3.optString("guide_flag");
            this.ege = optJSONObject3.optString("guide_wording");
            this.egf = optJSONObject3.optString("left_button_wording");
            this.egg = optJSONObject3.optString("right_button_wording");
            this.egh = optJSONObject3.optString("upload_credit_url");
        }
        this.HsZ = jSONObject.optBoolean("need_large_account_tip");
        if (this.HsZ && jSONObject.has("large_account_tip")) {
            Log.i("Micromsg.NetSceneTenpayBalanceFetch", "get large_account_tip");
            a aVar = new a();
            JSONObject optJSONObject4 = jSONObject.optJSONObject("large_account_tip");
            aVar.title = optJSONObject4.optString("title");
            aVar.content = optJSONObject4.optString("content");
            aVar.gTt = optJSONObject4.optString("button_name");
            aVar.Htc = optJSONObject4.optString("button_jump_url");
            Log.d("Micromsg.NetSceneTenpayBalanceFetch", "parseLargeAccountTipDialog() title:%s content:%s button_name:%s button_jump_url:%s", Util.nullAsNil(aVar.title), Util.nullAsNil(aVar.content), Util.nullAsNil(aVar.gTt), Util.nullAsNil(aVar.Htc));
            this.Hta = aVar;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.HsZ);
        if (this.Hta == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        Log.i("Micromsg.NetSceneTenpayBalanceFetch", "needLargeAccountTip:%s accountTipDialog:%s", objArr);
        this.retryPayInfo = new ITenpaySave.RetryPayInfo();
        this.retryPayInfo.bK(jSONObject);
        this.HsY = jSONObject.optString("charge_checkout_wording");
        this.HsX = com.tencent.mm.plugin.wallet_core.model.j.bH(jSONObject.optJSONObject("fetch_alert_dialog"));
        JSONObject optJSONObject5 = jSONObject.optJSONObject("cashier_v2");
        if (optJSONObject5 != null) {
            this.Htb = optJSONObject5.toString();
        }
        AppMethodBeat.o(68395);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1503;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/genprefetch";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.ITenpaySave
    public final ITenpaySave.RetryPayInfo getRetryPayInfo() {
        return this.retryPayInfo;
    }
}
