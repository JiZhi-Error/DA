package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class o extends m {
    public String RtT;

    public o(String str) {
        AppMethodBeat.i(72781);
        this.RtT = str;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("crt_no", q.encode(str));
        hashMap.put("deviceid", com.tencent.mm.compatible.deviceinfo.q.dr(false));
        setRequestData(hashMap);
        setWXRequestData(hashMap2);
        AppMethodBeat.o(72781);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1568;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1568;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/deletedigitalcert";
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72782);
        Log.i("MicroMsg.NetSceneDeletedigitalcert", "onGYNetEnd %d %s", Integer.valueOf(i2), str);
        AppMethodBeat.o(72782);
    }
}
