package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends a {
    public String Iup;
    public String Iuq;
    public String dRM;

    public d(String str, String str2) {
        AppMethodBeat.i(72147);
        this.Iup = str;
        this.Iuq = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("payu_reference", str);
        hashMap.put("new_pin", str2);
        setRequestData(hashMap);
        AppMethodBeat.o(72147);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 19;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72148);
        this.dRM = jSONObject.optString("payu_reference");
        AppMethodBeat.o(72148);
    }
}
