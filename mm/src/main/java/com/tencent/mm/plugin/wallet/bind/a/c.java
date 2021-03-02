package com.tencent.mm.plugin.wallet.bind.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.p;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends m {
    public boolean HCv = true;
    public String HCw;
    public String HCx;
    private String HCy;
    public ArrayList<Bankcard> Hva = null;
    public boolean efV = false;
    public String token;

    public c(String str, PayInfo payInfo) {
        AppMethodBeat.i(69065);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        setPayInfo(payInfo, hashMap, hashMap2);
        g.aAi();
        p pVar = new p(Util.nullAs((Integer) g.aAh().azQ().get(9, (Object) null), 0));
        this.HCy = str;
        hashMap.put("import_code", str);
        hashMap.put("qqid", pVar.toString());
        setRequestData(hashMap);
        setWXRequestData(hashMap2);
        AppMethodBeat.o(69065);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 37;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69066);
        if (i2 != 0) {
            AppMethodBeat.o(69066);
            return;
        }
        this.Hva = new ArrayList<>();
        try {
            this.efV = "1".equals(jSONObject.optString("is_reg", AppEventsConstants.EVENT_PARAM_VALUE_NO));
            this.token = jSONObject.optString("token", "");
            JSONArray jSONArray = jSONObject.getJSONArray("Array");
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                Bankcard bA = d.fQh().bA(jSONObject2);
                if (bA != null) {
                    if (2 == jSONObject2.optInt("bank_acc_type", 2)) {
                        bA.field_cardType |= Bankcard.HVp;
                    }
                    bA.field_bankcardTail = jSONObject2.optString("bank_tail");
                    bA.HVy = "************" + bA.field_bankcardTail;
                    bA.field_trueName = jSONObject2.optString("true_name");
                    bA.HVx = jSONObject2.optString("cre_id");
                    bA.HUQ = jSONObject2.optInt("cre_type", -1);
                    bA.HVL = this.HCy;
                    bA.dKO = 1 == jSONObject2.optInt("samecardexist", 0);
                    if (bA.fQb()) {
                        bA.field_desc = bA.field_bankName;
                    } else if (bA.fQd()) {
                        bA.field_desc = MMApplicationContext.getContext().getString(R.string.ibl, bA.field_bankName, bA.field_bankcardTail);
                    } else if (bA.fQa()) {
                        bA.field_desc = MMApplicationContext.getContext().getString(R.string.iw2, bA.field_bankName, bA.field_bankcardTail);
                    } else {
                        bA.field_desc = MMApplicationContext.getContext().getString(R.string.ic5, bA.field_bankName, bA.field_bankcardTail);
                    }
                    JSONObject optJSONObject = jSONObject2.optJSONObject("bankappservice");
                    if (optJSONObject != null) {
                        this.HCw = optJSONObject.optString(ch.COL_USERNAME);
                        this.HCx = optJSONObject.optString("app_recommend_desc");
                    }
                    this.Hva.add(bA);
                }
            }
            Log.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "got data---isReg:" + this.efV + ",bankcard.size:" + this.Hva.size());
            AppMethodBeat.o(69066);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneTenpayQueryBindBankcard", e2, "", new Object[0]);
            AppMethodBeat.o(69066);
        }
    }
}
