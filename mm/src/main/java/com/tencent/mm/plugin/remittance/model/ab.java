package com.tencent.mm.plugin.remittance.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.b.a.a;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class ab extends a {
    public String CoO = "";
    public int CoV;
    public String Cqn = "";
    public int Cqo;
    public int qww = 0;

    public ab(double d2, String str, String str2, String str3, String str4, int i2) {
        AppMethodBeat.i(67901);
        Log.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay create");
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("transfer_amount", new StringBuilder().append(Math.round(100.0d * d2)).toString());
            hashMap.put("pay_nickname", URLEncoder.encode(str, ProtocolPackage.ServerEncoding));
            hashMap.put("rcvd_username", String.valueOf(str2));
            hashMap.put("rcvd_nickname", URLEncoder.encode(str3, ProtocolPackage.ServerEncoding));
            hashMap.put("reason", URLEncoder.encode(Util.nullAs(str4, ""), ProtocolPackage.ServerEncoding));
            hashMap.put(FirebaseAnalytics.b.CURRENCY, String.valueOf(i2));
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneTenpayh5Pay", "error " + e2.getMessage());
        }
        setRequestData(hashMap);
        AppMethodBeat.o(67901);
    }

    @Override // com.tencent.mm.wallet_core.b.a.a
    public final int czE() {
        return 1;
    }

    @Override // com.tencent.mm.wallet_core.b.a.a
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(67902);
        Log.i("MicroMsg.NetSceneTenpayh5Pay", "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            Log.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay request error");
            AppMethodBeat.o(67902);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        this.CoO = jSONObject.optString("payurl");
        this.Cqn = jSONObject.optString("tradeurl");
        this.CoV = jSONObject.optInt("transfering_num");
        this.Cqo = jSONObject.optInt("transfering_type");
        stringBuffer.append("payurl:" + this.CoO);
        stringBuffer.append(" tradeurl:" + this.Cqn);
        stringBuffer.append(" transfering_num:" + this.CoV);
        stringBuffer.append(" transfering_type:" + this.Cqo);
        Log.i("MicroMsg.NetSceneTenpayh5Pay", "resp " + stringBuffer.toString());
        AppMethodBeat.o(67902);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1622;
    }

    @Override // com.tencent.mm.wallet_core.b.a.a
    public final String czD() {
        return "/cgi-bin/mmpay-bin/h5requesttransfer";
    }
}
