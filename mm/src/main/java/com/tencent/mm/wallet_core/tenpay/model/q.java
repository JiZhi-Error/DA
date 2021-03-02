package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.y;
import java.util.HashMap;
import org.json.JSONObject;

public final class q extends m {
    public q() {
        AppMethodBeat.i(72896);
        setRequestData(new HashMap());
        AppMethodBeat.o(72896);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 19;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72897);
        Log.d("Micromsg.NetSceneTenpayTimeSeed", " errCode: " + i2 + " errMsg :" + str);
        String optString = jSONObject.optString("time_stamp");
        Log.i("Micromsg.NetSceneTenpayTimeSeed", "get svr time stamp: %s", optString);
        if (!Util.isNullOrNil(optString)) {
            y.setTimeStamp(optString);
            AppMethodBeat.o(72897);
            return;
        }
        Log.w("Micromsg.NetSceneTenpayTimeSeed", "hy: no timeseed. use local timeseed");
        y.setTimeStamp(new StringBuilder().append(System.currentTimeMillis() / 1000).toString());
        AppMethodBeat.o(72897);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/timeseed";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return b.CTRL_INDEX;
    }
}
