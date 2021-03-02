package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String Ita;
    public String Itb;
    public String Itc;
    public String Itd;
    public String Ite;
    public String dRM;
    public String pin;

    public a(String str, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(72009);
        this.Ita = str;
        this.Itb = str2;
        this.pin = str3;
        this.Itd = str4;
        this.Itc = str4;
        this.Ite = str6;
        HashMap hashMap = new HashMap();
        hashMap.put("dial_code", str);
        hashMap.put("number", String.valueOf(str2));
        hashMap.put("pin", String.valueOf(str3));
        hashMap.put("secret_question_id", String.valueOf(str4));
        hashMap.put("secret_question_answer", String.valueOf(str5));
        hashMap.put("payu_reference", str6);
        setRequestData(hashMap);
        AppMethodBeat.o(72009);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 5;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72010);
        Log.d("MicroMsg.NetScenePayUCreateUser", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", Integer.valueOf(i2), str, jSONObject.toString());
        this.dRM = jSONObject.optString("payu_reference");
        AppMethodBeat.o(72010);
    }
}
