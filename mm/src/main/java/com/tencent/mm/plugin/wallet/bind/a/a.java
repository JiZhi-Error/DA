package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends m {
    public int HCt;
    public String HCu;

    public a(String str, String str2) {
        AppMethodBeat.i(69061);
        HashMap hashMap = new HashMap();
        hashMap.put("bankcard_type", str);
        hashMap.put("bind_serial", str2);
        setRequestData(hashMap);
        AppMethodBeat.o(69061);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1540;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1540;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/unbindbanner";
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69062);
        if (i2 == 0) {
            if (jSONObject != null) {
                this.HCt = jSONObject.optInt("unbindbannerlevel", 0);
                this.HCu = jSONObject.optString("unbindbannerwording");
                AppMethodBeat.o(69062);
                return;
            }
            Log.e("MicroMsg.NetSceneGetUnbindInfo", "json is null");
        }
        AppMethodBeat.o(69062);
    }
}
