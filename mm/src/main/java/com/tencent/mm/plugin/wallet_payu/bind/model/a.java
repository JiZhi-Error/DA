package com.tencent.mm.plugin.wallet_payu.bind.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String Icz;
    public String IsB;
    public String IsC;
    public String IsD;
    public String Isr;
    public String description;
    public String ega;
    public String pin;

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 0;
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        AppMethodBeat.i(71973);
        this.IsB = str;
        this.Icz = str2;
        this.ega = str3;
        this.IsC = str4;
        this.IsD = str5;
        this.description = str6;
        this.Isr = str7;
        this.pin = str8;
        HashMap hashMap = new HashMap();
        hashMap.put("bank_type", str);
        hashMap.put("information", str2);
        hashMap.put("name_on_card", str3);
        hashMap.put("card_number", str4);
        hashMap.put("card_expiry", str5);
        hashMap.put("description", str6);
        hashMap.put("cvv", str7);
        hashMap.put("pin", str8);
        setRequestData(hashMap);
        AppMethodBeat.o(71973);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
    }
}
