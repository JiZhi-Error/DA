package com.tencent.mm.plugin.remittance.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.b.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class aa extends a {
    public String Cql = "";
    public String Cqm = "";
    public String jTx;
    public String jTy;
    public int qww = 0;

    public aa(int i2) {
        AppMethodBeat.i(67899);
        Log.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTenpayh5Index create");
        HashMap hashMap = new HashMap();
        hashMap.put("wallet_type", String.valueOf(i2));
        setRequestData(hashMap);
        AppMethodBeat.o(67899);
    }

    @Override // com.tencent.mm.wallet_core.b.a.a
    public final int czE() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.b.a.a
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(67900);
        Log.i("MicroMsg.NetSceneTenpayh5Index", "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            Log.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTransferChargeQuery request error");
            AppMethodBeat.o(67900);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        this.qww = jSONObject.optInt(FirebaseAnalytics.b.CURRENCY);
        this.Cql = jSONObject.optString("currencyUint");
        this.Cqm = jSONObject.optString("currencyWording");
        this.jTx = jSONObject.optString("notice");
        this.jTy = jSONObject.optString("notice_url");
        stringBuffer.append("currency:" + this.qww);
        stringBuffer.append(" currencyuint:" + this.Cql);
        stringBuffer.append(" currencywording:" + this.Cqm);
        stringBuffer.append(" notice:" + this.jTx);
        stringBuffer.append(" notice_url:" + this.jTy);
        Log.i("MicroMsg.NetSceneTenpayh5Index", "resp " + stringBuffer.toString());
        AppMethodBeat.o(67900);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1574;
    }

    @Override // com.tencent.mm.wallet_core.b.a.a
    public final String czD() {
        return "/cgi-bin/mmpay-bin/h5transferoperate";
    }
}
