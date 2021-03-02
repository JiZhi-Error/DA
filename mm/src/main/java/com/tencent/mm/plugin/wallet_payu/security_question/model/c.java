package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends a {
    public String IuI;
    public String dRM;
    public String id;

    public c() {
        this("");
    }

    public c(String str) {
        AppMethodBeat.i(72211);
        this.dRM = str;
        HashMap hashMap = new HashMap();
        hashMap.put("payu_reference", Util.nullAs(str, ""));
        setRequestData(hashMap);
        AppMethodBeat.o(72211);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 23;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72212);
        this.id = jSONObject.optString("id");
        this.IuI = jSONObject.optString("description");
        AppMethodBeat.o(72212);
    }
}
