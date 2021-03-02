package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends a {
    public String CpA;
    public String Cpz;
    public String desc;
    public double qwJ;
    public int qwL;
    public int scene;
    public String username;

    public d(String str) {
        AppMethodBeat.i(72172);
        HashMap hashMap = new HashMap();
        hashMap.put("transfer_url", str);
        setRequestData(hashMap);
        AppMethodBeat.o(72172);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72173);
        Log.d("MicroMsg.NetScenePayURemittanceGetUsername", "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            AppMethodBeat.o(72173);
            return;
        }
        this.username = jSONObject.optString("user_name");
        this.Cpz = jSONObject.optString("true_name");
        this.qwJ = jSONObject.optDouble("fee") / 100.0d;
        this.desc = jSONObject.optString("desc");
        this.scene = jSONObject.optInt("scene");
        this.CpA = jSONObject.optString("transfer_qrcode_id");
        this.qwL = jSONObject.optInt("time_stamp");
        AppMethodBeat.o(72173);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 24;
    }
}
