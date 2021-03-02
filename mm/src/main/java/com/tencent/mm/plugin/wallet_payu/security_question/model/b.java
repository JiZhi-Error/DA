package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends a {
    public String IuH;
    public String dRM;
    public String id;
    public boolean sPX;
    public String yWF;

    public b(String str, String str2, String str3) {
        AppMethodBeat.i(72209);
        this.id = str2;
        this.yWF = str3;
        this.dRM = str;
        HashMap hashMap = new HashMap();
        hashMap.put("id", str2);
        hashMap.put("answer", str3);
        hashMap.put("payu_reference", str);
        setRequestData(hashMap);
        AppMethodBeat.o(72209);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 18;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72210);
        this.sPX = jSONObject.optBoolean("verified");
        this.IuH = jSONObject.optString("payu_reference");
        AppMethodBeat.o(72210);
    }
}
