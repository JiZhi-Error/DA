package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public boolean DcO;
    public String Itw;
    public String Itx;
    public String dRM;

    public a(String str, String str2) {
        AppMethodBeat.i(72047);
        this.Itw = str;
        this.dRM = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("otp", str);
        hashMap.put("payu_reference", String.valueOf(str2));
        setRequestData(hashMap);
        AppMethodBeat.o(72047);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 4;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72048);
        Log.d("MicroMsg.NetScenePayUComfirmOtp", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", Integer.valueOf(i2), str, jSONObject.toString());
        this.DcO = jSONObject.optBoolean("verified");
        this.Itx = jSONObject.optString("payu_reference");
        AppMethodBeat.o(72048);
    }
}
