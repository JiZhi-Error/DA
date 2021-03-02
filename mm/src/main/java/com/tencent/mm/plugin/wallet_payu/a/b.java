package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends a {
    public String Ita;
    public String Itb;
    public boolean Ity;
    public String dRM;

    public b(String str, String str2) {
        AppMethodBeat.i(72049);
        this.Ita = str;
        this.Itb = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("dial_code", str);
        hashMap.put("number", String.valueOf(str2));
        setRequestData(hashMap);
        AppMethodBeat.o(72049);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 12;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72050);
        Log.d("MicroMsg.NetScenePayUGenerateOtp", "hy: get NetScenePayUGenerateOtp info. errCode: %d, errMsg:%s, json:%s", Integer.valueOf(i2), str, jSONObject.toString());
        this.Ity = jSONObject.optBoolean("has_mobile");
        this.dRM = jSONObject.optString("payu_reference");
        AppMethodBeat.o(72050);
    }
}
