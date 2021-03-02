package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends a {
    public b(String str, String str2) {
        AppMethodBeat.i(72144);
        HashMap hashMap = new HashMap();
        hashMap.put("old_pin", str);
        hashMap.put("new_pin", String.valueOf(str2));
        setRequestData(hashMap);
        AppMethodBeat.o(72144);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 2;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
    }
}
