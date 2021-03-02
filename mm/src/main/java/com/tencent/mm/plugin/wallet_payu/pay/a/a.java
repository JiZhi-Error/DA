package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String IsA;
    public String Isr;
    public String Isx;
    public String Isy;
    public double ItP;
    public String ItQ;
    public double ItR;
    public String ItS;
    public boolean ItT;
    public boolean ItU;
    public String ItV;
    public String ItW;
    public String ItX;
    public String dDL;
    public String dQl;
    public String dQm;
    public String pin;
    public String qvD;
    public int qwL;

    public a(String str, double d2, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(72081);
        this.dDL = str;
        this.ItP = d2;
        this.ItQ = str2;
        this.dQl = str3;
        this.dQm = str4;
        this.Isr = str5;
        this.pin = str6;
        HashMap hashMap = new HashMap();
        hashMap.put("req_key", str);
        hashMap.put("total_fee", new StringBuilder().append(Math.round(100.0d * d2)).toString());
        hashMap.put("fee_type", str2);
        hashMap.put("bank_type", String.valueOf(str3));
        hashMap.put("bind_serial", str4);
        if (!str3.equals("SVA_PAYU")) {
            hashMap.put("cvv", String.valueOf(str5));
        }
        hashMap.put("pin", String.valueOf(str6));
        setRequestData(hashMap);
        AppMethodBeat.o(72081);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 9;
    }

    public final boolean isSuccess() {
        AppMethodBeat.i(72082);
        boolean equals = this.ItV.equals("1");
        AppMethodBeat.o(72082);
        return equals;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72083);
        if (jSONObject != null) {
            this.qvD = jSONObject.optString("trans_id");
            this.ItR = jSONObject.optDouble("total_fee") / 100.0d;
            this.ItS = jSONObject.optString("fee_type");
            this.ItT = jSONObject.optBoolean("redirect");
            this.Isx = jSONObject.optString("gateway_reference");
            this.Isy = jSONObject.optString("gateway_code");
            this.ItV = jSONObject.optString("pay_status");
            this.qwL = jSONObject.optInt(AppMeasurement.Param.TIMESTAMP);
            this.ItW = jSONObject.optString("pay_status_name");
            this.ItX = jSONObject.optString("bank_type");
            this.ItU = jSONObject.optBoolean("is_force_adjust");
            this.IsA = jSONObject.optString("force_adjust_code");
        }
        AppMethodBeat.o(72083);
    }
}
