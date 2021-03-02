package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import org.json.JSONObject;

public final class ai extends m {
    public double Cpd;
    public String Crl;
    public String HQt;
    public double HQu;

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1689;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transfergetchargefee";
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69962);
        Log.i("Micromsg.NetSceneTransferChargeQuery", "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            Log.i("Micromsg.NetSceneTransferChargeQuery", "NetSceneTransferChargeQuery request error");
            AppMethodBeat.o(69962);
            return;
        }
        this.HQt = jSONObject.optString("short_desc");
        this.Crl = jSONObject.optString("charge_desc");
        this.HQu = jSONObject.optDouble("acc_fee");
        this.Cpd = jSONObject.optDouble("remain_fee") / 100.0d;
        AppMethodBeat.o(69962);
    }
}
