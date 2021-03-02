package com.tencent.mm.plugin.wallet_core.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.y;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    private boolean HQJ;

    public a() {
        this("");
    }

    public a(String str) {
        this(str, true);
    }

    public a(String str, boolean z) {
        AppMethodBeat.i(69976);
        HashMap hashMap = new HashMap();
        hashMap.put("req_key", str);
        setRequestData(hashMap);
        this.HQJ = z;
        AppMethodBeat.o(69976);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 1;
    }

    @Override // com.tencent.mm.ak.q, com.tencent.mm.wallet_core.e.a.a
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69977);
        int doScene = super.doScene(gVar, iVar);
        AppMethodBeat.o(69977);
        return doScene;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        Bankcard bankcard;
        AppMethodBeat.i(69978);
        Log.i("MicroMsg.NetScenePayUQueryBoundBankcard", "hy: payu query bind on gy net end. errCode: %d, errMsg: %s", Integer.valueOf(i2), str);
        if (i2 != 0) {
            AppMethodBeat.o(69978);
            return;
        }
        try {
            long optLong = jSONObject.optLong("time_stamp");
            if (optLong > 0) {
                y.setTimeStamp(String.valueOf(optLong));
            } else {
                Log.w("MicroMsg.NetScenePayUQueryBoundBankcard", "no time_stamp in bindquerynew.");
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("user_info");
            am amVar = new am();
            if (jSONObject2 == null || jSONObject2.length() <= 0) {
                amVar = null;
            } else {
                amVar.field_is_reg = Util.getInt(jSONObject2.optString("is_reg"), 0);
                amVar.field_true_name = jSONObject2.optString("true_name");
                amVar.field_main_card_bind_serialno = jSONObject2.optString("main_card_bind_serialno");
                amVar.field_ftf_pay_url = jSONObject2.optString("transfer_url");
                t.fQI();
                an.aVo(amVar.field_main_card_bind_serialno);
            }
            amVar.field_switchConfig = jSONObject.getJSONObject("switch_info").getInt("switch_bit");
            JSONArray optJSONArray = jSONObject.optJSONArray("Array");
            ArrayList<Bankcard> arrayList = new ArrayList<>();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i3);
                    jSONObject3.put("extra_bind_flag", "NORMAL");
                    Bankcard bA = com.tencent.mm.plugin.wallet_core.model.a.a.fSl().bA(jSONObject3);
                    if (bA != null) {
                        arrayList.add(bA);
                    }
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("balance_info");
            if (optJSONObject == null || optJSONObject.length() <= 0) {
                bankcard = null;
            } else {
                bankcard = new Bankcard((byte) 0);
                bankcard.HVC = ((double) optJSONObject.optInt("avail_balance")) / 100.0d;
                bankcard.HVE = ((double) optJSONObject.optInt("fetch_balance")) / 100.0d;
                bankcard.field_bankcardType = optJSONObject.optString("balance_bank_type");
                bankcard.field_bindSerial = optJSONObject.optString("balance_bind_serial");
                bankcard.field_forbidWord = optJSONObject.optString("balance_forbid_word");
                bankcard.field_desc = MMApplicationContext.getContext().getString(R.string.ide);
                bankcard.field_cardType |= Bankcard.HVr;
            }
            t.fQI().a(amVar, arrayList, null, bankcard, null, null, null, null, 0, 0, null);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NetScenePayUQueryBoundBankcard", e2, "", new Object[0]);
        }
        if (this.HQJ && !t.fQI().fRk()) {
            this.callback.onSceneEnd(1000, -100869, "", this);
            this.isChildConsume = true;
        }
        AppMethodBeat.o(69978);
    }
}
