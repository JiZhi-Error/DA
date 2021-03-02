package com.tencent.mm.plugin.remittance.model;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class x extends m {
    public String CpA;
    public String CpB = "";
    public String CpC = "";
    public String CpD = "";
    public String CpE = "";
    public int CpF;
    public String CpG = "";
    public String CpH = "";
    public int CpI;
    public String CpJ;
    public String CpK;
    public int CpL;
    public String CpM;
    public int CpN;
    public BusiRemittanceResp CpO;
    public String Cpg;
    public String Cpz;
    public int dDN;
    public String desc;
    public int pTI;
    public String pTL;
    public double qwJ;
    public int scene;
    public String username;

    public x(String str, int i2) {
        AppMethodBeat.i(67887);
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("transfer_url", URLEncoder.encode(str));
        setRequestData(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("channel", String.valueOf(i2));
        setWXRequestData(hashMap2);
        AppMethodBeat.o(67887);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1515;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferscanqrcode";
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(67888);
        try {
            Log.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "errCode " + i2 + " errMsg: " + str);
            if (i2 != 0) {
                AppMethodBeat.o(67888);
                return;
            }
            Log.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "json %s", jSONObject.toString());
            this.username = jSONObject.optString("user_name", "");
            this.Cpz = jSONObject.optString("true_name");
            this.qwJ = jSONObject.optDouble("fee") / 100.0d;
            this.desc = jSONObject.optString("desc");
            this.scene = jSONObject.optInt("scene");
            this.CpA = URLEncoder.encode(jSONObject.optString("transfer_qrcode_id"));
            this.CpB = jSONObject.optString("f2f_pay_desc");
            this.CpC = jSONObject.optString("rcvr_desc");
            this.CpD = jSONObject.optString("payer_desc");
            this.CpE = jSONObject.optString("rcvr_ticket");
            this.CpF = jSONObject.optInt("busi_type", 0);
            this.CpG = jSONObject.optString("mch_name");
            this.CpH = jSONObject.optString("mch_photo");
            this.CpK = jSONObject.optString("mch_type", "");
            this.CpI = jSONObject.optInt("mch_time", 0);
            this.CpJ = jSONObject.optString("receiver_openid");
            this.CpL = jSONObject.optInt("get_pay_wifi");
            this.Cpg = jSONObject.optString("receiver_true_name");
            this.CpM = jSONObject.optString("mch_info_string");
            this.CpN = jSONObject.optInt("amount_remind_bit");
            this.pTI = jSONObject.optInt(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE);
            this.dDN = jSONObject.optInt("retcode");
            this.pTL = jSONObject.optString("jump_url");
            this.CpO = new BusiRemittanceResp(jSONObject);
            AppMethodBeat.o(67888);
        } catch (Exception e2) {
            Log.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceGetUsername", e2, "", new Object[0]);
            AppMethodBeat.o(67888);
        }
    }
}
