package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public int Isv;
    public double Iut;
    public String Iuu;
    public String dDL;
    public double dDO;
    public String dFv;
    public String dQm;
    public String dkV;
    public int oLM;
    public String pin;

    public a(String str, String str2, double d2, String str3, int i2, String str4, String str5, String str6) {
        AppMethodBeat.i(72166);
        this.dDL = str;
        this.pin = str2;
        this.dDO = d2;
        this.dFv = str3;
        this.oLM = i2 == 2 ? 0 : i2;
        this.dkV = str4;
        this.dQm = str5;
        HashMap hashMap = new HashMap();
        hashMap.put("pin", str2);
        hashMap.put("req_key", str);
        hashMap.put("total_fee", new StringBuilder().append(Math.round(100.0d * d2)).toString());
        hashMap.put("fee_type", str3);
        hashMap.put("transfer_type", String.valueOf(i2));
        hashMap.put("target_username", str4);
        hashMap.put("bind_serial", str5);
        hashMap.put("transfer_qrcode_id", str6);
        setRequestData(hashMap);
        AppMethodBeat.o(72166);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 14;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72167);
        this.Isv = jSONObject.optInt("response_result");
        this.Iut = Util.getDouble(jSONObject.optString("total_fee"), 0.0d);
        this.Iuu = jSONObject.optString("fee_type");
        AppMethodBeat.o(72167);
    }
}
