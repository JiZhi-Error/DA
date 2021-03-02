package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends a {
    public String token = "";

    public c(String str) {
        AppMethodBeat.i(72145);
        HashMap hashMap = new HashMap();
        hashMap.put("pin", str);
        setRequestData(hashMap);
        AppMethodBeat.o(72145);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 3;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72146);
        Log.d("MicroMsg.NetScenePayUCheckPwd", "errCode " + i2 + " errMsg: " + str);
        this.token = jSONObject.optString("payu_reference");
        AppMethodBeat.o(72146);
    }
}
