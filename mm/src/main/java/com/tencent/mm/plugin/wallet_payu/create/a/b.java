package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends a {
    public String Ita;
    public String dRM;
    public String ebd;
    public String pin;

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 17;
    }

    public b(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(72011);
        this.Ita = str;
        this.ebd = str2;
        this.pin = str3;
        this.dRM = str4;
        HashMap hashMap = new HashMap();
        hashMap.put("dial_code", str);
        hashMap.put("number", str2);
        hashMap.put("pin", str3);
        hashMap.put("payu_reference", str4);
        setRequestData(hashMap);
        AppMethodBeat.o(72011);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
    }
}
