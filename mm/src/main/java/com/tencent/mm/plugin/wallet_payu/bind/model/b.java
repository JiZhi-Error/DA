package com.tencent.mm.plugin.wallet_payu.bind.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends a {
    public String IsH;
    public String dRM;

    public b(String str, String str2) {
        AppMethodBeat.i(71977);
        this.IsH = str;
        this.dRM = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("bind_serial", str);
        hashMap.put("payu_reference", String.valueOf(str2));
        setRequestData(hashMap);
        AppMethodBeat.o(71977);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 6;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
    }
}
