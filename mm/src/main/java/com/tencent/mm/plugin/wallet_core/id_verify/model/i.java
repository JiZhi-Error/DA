package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class i extends m {
    public String HTQ;
    public String HTR;
    public String HTS;
    public String HTT;
    public String HTU;

    public i(String str) {
        AppMethodBeat.i(70154);
        HashMap hashMap = new HashMap();
        hashMap.put("channel", "1");
        setRequestData(hashMap);
        this.HTU = str;
        AppMethodBeat.o(70154);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1630;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1630;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnameguidequery";
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(70155);
        if (i2 == 0 && jSONObject != null) {
            this.HTQ = jSONObject.optString("guide_flag");
            this.HTR = jSONObject.optString("guide_wording");
            this.HTS = jSONObject.optString("left_button_wording");
            this.HTT = jSONObject.optString("right_button_wording");
        }
        AppMethodBeat.o(70155);
    }
}
