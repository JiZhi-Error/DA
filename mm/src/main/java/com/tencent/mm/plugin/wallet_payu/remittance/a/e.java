package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends a {
    public String AOl;
    private String CpP;
    public int CpR;
    public int Iuv;
    public int Iuw;
    public int cSx;
    public int dJY;
    public double qwJ;
    public int status;

    public e(String str, String str2, int i2) {
        this(str, str2, i2, 0);
    }

    public e(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(72174);
        this.CpP = null;
        this.CpP = str;
        this.dJY = 1;
        this.cSx = i3;
        HashMap hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("receiver_name", str2);
        hashMap.put("invalid_time", String.valueOf(i2));
        setRequestData(hashMap);
        AppMethodBeat.o(72174);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72175);
        Log.d("MicroMsg.NetScenePayURemittanceQuery", "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            AppMethodBeat.o(72175);
            return;
        }
        this.CpR = jSONObject.optInt("pay_time");
        this.qwJ = jSONObject.optDouble("total_fee") / 100.0d;
        this.AOl = jSONObject.optString("fee_type");
        this.status = jSONObject.optInt("pay_status");
        this.Iuv = jSONObject.optInt("refund_time");
        this.Iuw = jSONObject.optInt("receive_time");
        AppMethodBeat.o(72175);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 25;
    }
}
