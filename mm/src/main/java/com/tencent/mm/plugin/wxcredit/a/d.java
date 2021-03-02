package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends m {
    public k JPI;

    public d(String str, String str2) {
        AppMethodBeat.i(72303);
        HashMap hashMap = new HashMap();
        hashMap.put("bind_serialno", str);
        hashMap.put("bank_type", str2);
        hashMap.put("query_method", "1");
        setRequestData(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("banktype", str2);
        setWXRequestData(hashMap2);
        AppMethodBeat.o(72303);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 57;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        boolean z = true;
        AppMethodBeat.i(72304);
        Log.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            AppMethodBeat.o(72304);
            return;
        }
        try {
            this.JPI = new k();
            this.JPI.JPM = jSONObject.optInt("credit_state");
            this.JPI.JPH = ((double) jSONObject.optInt("credit_amount")) / 100.0d;
            this.JPI.JPN = ((double) jSONObject.optInt("credit_usable")) / 100.0d;
            this.JPI.JPO = ((double) jSONObject.optInt("bill_amount")) / 100.0d;
            this.JPI.JPP = jSONObject.optInt("bill_date");
            this.JPI.JPQ = ((double) jSONObject.optInt("repay_amount")) / 100.0d;
            this.JPI.JPR = ((double) jSONObject.optInt("repay_minimum")) / 100.0d;
            k kVar = this.JPI;
            if (jSONObject.optInt("upgrade_amount") != 1) {
                z = false;
            }
            kVar.JPS = z;
            this.JPI.JPT = jSONObject.optInt("bill_month");
            this.JPI.JPU = jSONObject.optString("repay_url");
            this.JPI.JPV = jSONObject.optString("repay_lasttime");
            this.JPI.JPY = jSONObject.optString("lasttime");
            JSONArray jSONArray = jSONObject.getJSONArray("jump_url_array");
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    String string = jSONObject2.getString("jump_name");
                    if ("account_rights_url".equals(string)) {
                        this.JPI.JPX = jSONObject2.getString("jump_url");
                    } else if ("bill_url".equals(string)) {
                        this.JPI.Cpy = jSONObject2.getString("jump_url");
                    } else if ("card_detail_url".equals(string)) {
                        this.JPI.JPW = jSONObject2.getString("jump_url");
                    } else if ("know_more_url".equals(string)) {
                        this.JPI.JPZ = jSONObject2.getString("jump_url");
                    }
                }
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("appservice");
            if (jSONObject3 != null) {
                this.JPI.JQa = new j();
                this.JPI.JQa.JPL = jSONObject3.getString("app_telephone");
                this.JPI.JQa.nickname = jSONObject3.getString("nickname");
                this.JPI.JQa.username = jSONObject3.getString(ch.COL_USERNAME);
                this.JPI.JQa.url = jSONObject3.getString("jump_url");
            }
            AppMethodBeat.o(72304);
        } catch (Exception e2) {
            Log.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e2, "", new Object[0]);
            AppMethodBeat.o(72304);
        }
    }
}
