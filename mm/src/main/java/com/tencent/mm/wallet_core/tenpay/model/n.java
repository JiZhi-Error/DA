package com.tencent.mm.wallet_core.tenpay.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.c.j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class n extends p implements j {
    private static int RuP = 0;
    public RealnameGuideHelper AJr;
    private String AJs;
    private String AJt;
    private String AJu;
    private String AJv;
    private String AJw;
    public String HIu;
    public int HZm = 0;
    protected Map<String, String> RuN = new HashMap();
    public int RuO = 0;
    private boolean RuQ = false;
    public int RuR = 0;
    public int RuS = 0;
    public String RuT = null;
    public JSONObject RuU = null;
    private boolean RuV = false;
    public int RuW = -1;
    protected int efQ;

    /* access modifiers changed from: protected */
    public final void b(String str, String str2, int i2, int i3, String str3, String str4) {
        RuP++;
        this.RuN.put("req_key", str);
        this.RuN.put(FirebaseAnalytics.b.TRANSACTION_ID, str2);
        this.RuN.put("pay_scene", String.valueOf(i2));
        this.RuN.put("bank_type", str3);
        this.RuN.put("channel", String.valueOf(i3));
        this.RuN.put("bind_serial", str4);
    }

    /* access modifiers changed from: protected */
    public final void a(Orders orders, Authen authen) {
        List<Orders.Commodity> list = orders.HZd;
        String str = null;
        if (list.size() > 0) {
            str = list.get(0).dDM;
        }
        b(orders.dDL, str, authen.BDB.dVv, authen.BDB.channel, authen.dDj, authen.ANo);
    }

    public final Map<String, String> hhM() {
        return this.RuN;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.p, com.tencent.mm.wallet_core.c.s
    public void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        boolean z;
        if (!this.RuQ) {
            this.RuS = i2;
            this.RuT = str;
            this.RuU = jSONObject;
            this.RuQ = true;
            if (jSONObject != null) {
                this.RuO = jSONObject.optInt("query_order_flag", 0);
            }
        }
        if (jSONObject == null || !jSONObject.has("real_name_info")) {
            z = false;
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
            this.AJs = optJSONObject.optString("guide_flag");
            this.AJt = optJSONObject.optString("guide_wording");
            this.AJu = optJSONObject.optString("left_button_wording");
            this.AJv = optJSONObject.optString("right_button_wording");
            this.AJw = optJSONObject.optString("upload_credit_url");
            z = true;
        }
        SetPwdInfo setPwdInfo = null;
        if (jSONObject != null && jSONObject.has("set_pwd_info")) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("set_pwd_info");
            setPwdInfo = new SetPwdInfo();
            setPwdInfo.yXJ = optJSONObject2.optString("guide_wording");
            setPwdInfo.lHA = optJSONObject2.optString("left_button_wording");
            setPwdInfo.lHB = optJSONObject2.optString("right_button_wording");
            setPwdInfo.HUM = optJSONObject2.optInt("send_pwd_msg");
            z = true;
        }
        if (z && ("1".equals(this.AJs) || "2".equals(this.AJs) || setPwdInfo != null)) {
            this.AJr = new RealnameGuideHelper();
            this.AJr.a(this.AJs, setPwdInfo, this.AJt, this.AJu, this.AJv, this.AJw, this.efQ);
        }
        this.HIu = jSONObject.optString("forget_pwd_url", "");
        this.RuW = jSONObject.optInt("is_clear_failure", -1);
        Log.i("MicroMsg.NetSceneTenpayDelayQueryBase", "forget_pwd_url %s", this.HIu);
        this.RuV = true;
        super.onGYNetEnd(i2, str, jSONObject);
    }

    public final boolean hhN() {
        return this.RuO == 1;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.p, com.tencent.mm.wallet_core.c.s
    public void onGYNetEnd2(e eVar, JSONObject jSONObject) {
        Log.i("MicroMsg.NetSceneTenpayDelayQueryBase", "always callback: %s,%s", Integer.valueOf(eVar.errCode), eVar.errMsg);
        super.onGYNetEnd2(eVar, jSONObject);
        if (!this.RuV && !this.RuQ) {
            this.RuR = eVar.errType;
            this.RuS = eVar.errCode;
            this.RuT = eVar.errMsg;
            if (jSONObject != null) {
                this.RuO = jSONObject.optInt("query_order_flag", 0);
                this.RuU = jSONObject;
            }
            this.RuQ = true;
        }
    }

    public boolean fOn() {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.p, com.tencent.mm.wallet_core.tenpay.model.m
    public boolean canRetry() {
        return false;
    }
}
