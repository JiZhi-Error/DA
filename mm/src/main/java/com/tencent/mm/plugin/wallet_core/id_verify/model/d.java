package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends m {
    public d(int i2) {
        AppMethodBeat.i(70138);
        HashMap hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i2));
        setRequestData(hashMap);
        AppMethodBeat.o(70138);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1584;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(70139);
        Log.i("MicroMsg.NetSceneAgreeDisclaimer", "errCode = " + i2 + ";errMsg = " + str);
        AppMethodBeat.o(70139);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1584;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnamesetduty";
    }
}
