package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends m {
    public d zjm;

    public e() {
        AppMethodBeat.i(65991);
        setRequestData(new HashMap());
        AppMethodBeat.o(65991);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 2713;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/geteuinfo";
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(65992);
        Log.d("MicroMsg.NetSceneGetEUInfo", "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            AppMethodBeat.o(65992);
            return;
        }
        try {
            this.zjm = new d(jSONObject.toString());
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_MALL_INDEX_GDPR_CACHE_STRING_SYNC, jSONObject.toString());
            AppMethodBeat.o(65992);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneGetEUInfo", e2, "", new Object[0]);
            AppMethodBeat.o(65992);
        }
    }
}
