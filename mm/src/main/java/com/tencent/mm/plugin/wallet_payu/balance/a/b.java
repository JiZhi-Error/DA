package com.tencent.mm.plugin.wallet_payu.balance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends a {
    public String IsA;
    public String Isr;
    public String Iss;
    public String Ist;
    public String Isu;
    public int Isv;
    public boolean Isw;
    public String Isx;
    public String Isy;
    public boolean Isz;
    public String dDL;
    public double dDO;
    public String dFv;
    public String pin;
    public String qvD;

    public b(String str, String str2, String str3, double d2, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(71963);
        this.pin = str;
        this.Isr = str2;
        this.dDL = str3;
        this.dDO = d2;
        this.dFv = str4;
        this.Iss = str5;
        this.Ist = str6;
        this.Isu = str7;
        HashMap hashMap = new HashMap();
        hashMap.put("pin", str);
        hashMap.put("bind_serial", str5);
        hashMap.put("req_key", str3);
        hashMap.put("fee_type", str4);
        hashMap.put("total_fee", new StringBuilder().append(Math.round(100.0d * d2)).toString());
        hashMap.put("bank_type", str6);
        hashMap.put("cvv", str2);
        hashMap.put("dest_bind_serial", str7);
        setRequestData(hashMap);
        AppMethodBeat.o(71963);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 10;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(71964);
        this.qvD = jSONObject.optString("trans_id");
        this.Isv = jSONObject.optInt("response_result");
        this.Isw = jSONObject.optBoolean("redirect");
        this.Isx = jSONObject.optString("gateway_reference");
        this.Isy = jSONObject.optString("gateway_code");
        this.Isz = jSONObject.optBoolean("is_force_adjust");
        this.IsA = jSONObject.optString("force_adjust_code");
        AppMethodBeat.o(71964);
    }
}
