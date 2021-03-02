package com.tencent.mm.wallet_core.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.y;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends a {
    public b() {
        AppMethodBeat.i(72877);
        setRequestData(new HashMap());
        AppMethodBeat.o(72877);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 28;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72878);
        Log.d("Micromsg.NetScenePayUTimeSeed", " errCode: " + i2 + " errMsg :" + str);
        String optString = jSONObject.optString("time_stamp");
        if (!Util.isNullOrNil(optString)) {
            y.setTimeStamp(optString);
        }
        AppMethodBeat.o(72878);
    }
}
