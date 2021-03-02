package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends m {
    public String AOl;
    public double Cpj;
    public String desc;

    public c(String str) {
        AppMethodBeat.i(69262);
        HashMap hashMap = new HashMap();
        hashMap.put("token", str);
        setRequestData(hashMap);
        AppMethodBeat.o(69262);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 123;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        AppMethodBeat.i(69263);
        if (i2 == 0) {
            this.AOl = jSONObject.optString("fee_type");
            this.Cpj = jSONObject.optDouble("total_fee") / 100.0d;
            JSONArray optJSONArray = jSONObject.optJSONArray("Array");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.desc = ((JSONObject) optJSONArray.opt(0)).optString("desc");
            }
            ak fQJ = t.fQJ();
            JSONObject optJSONObject = jSONObject.optJSONObject("bindqueryresp");
            fQJ.IbD.clear();
            if (optJSONObject == null) {
                Log.e("MicroMsg.WalletRepaymentBankcardMgr", "parse from json error,json is null");
                AppMethodBeat.o(69263);
                return;
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("Array");
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                Log.e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list is null");
            } else {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    d fQh = d.fQh();
                    try {
                        jSONObject2 = (JSONObject) optJSONArray2.get(i3);
                    } catch (JSONException e2) {
                        Log.printErrStackTrace("MicroMsg.WalletRepaymentBankcardMgr", e2, "", new Object[0]);
                        jSONObject2 = null;
                    }
                    if (jSONObject2 != null) {
                        Bankcard bA = fQh.bA(jSONObject2);
                        if (bA.fQb()) {
                            bA.field_desc = bA.field_bankName;
                        } else if (bA.fQd()) {
                            bA.field_desc = MMApplicationContext.getContext().getString(R.string.ibl, bA.field_bankName, bA.field_bankcardTail);
                        } else if (bA.fQa()) {
                            bA.field_desc = MMApplicationContext.getContext().getString(R.string.iw2, bA.field_bankName, bA.field_bankcardTail);
                        } else {
                            bA.field_desc = MMApplicationContext.getContext().getString(R.string.ic5, bA.field_bankName, bA.field_bankcardTail);
                        }
                        fQJ.IbD.add(bA);
                    }
                }
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                fQJ.IbE = optJSONObject2.optString("last_card_bind_serialno");
                AppMethodBeat.o(69263);
                return;
            }
            Log.e("MicroMsg.WalletRepaymentBankcardMgr", "user_info is null");
        }
        AppMethodBeat.o(69263);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1603;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/webankloanordershow";
    }
}
