package com.tencent.mm.plugin.remittance.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.b.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class q extends a {
    public q(String str, String str2, int i2, long j2, int i3) {
        AppMethodBeat.i(67871);
        HashMap hashMap = new HashMap();
        hashMap.put("recv_username", str);
        hashMap.put("qrcodeid", str2);
        hashMap.put(FirebaseAnalytics.b.CURRENCY, String.valueOf(i2));
        hashMap.put("amount", String.valueOf(j2));
        hashMap.put("set_amount", String.valueOf(i3));
        setRequestData(hashMap);
        Log.i("MicroMsg.NetSceneH5F2fTransferCancelPay", "qrcodeId: %s, currency: %s", str2, Integer.valueOf(i2));
        AppMethodBeat.o(67871);
    }

    @Override // com.tencent.mm.wallet_core.b.a.a
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(67872);
        Log.d("MicroMsg.NetSceneH5F2fTransferCancelPay", "json: %s", jSONObject.toString());
        Log.i("MicroMsg.NetSceneH5F2fTransferCancelPay", "errCode: %s, errMsg: %s", Integer.valueOf(i2), str);
        AppMethodBeat.o(67872);
    }

    @Override // com.tencent.mm.wallet_core.b.a.a
    public final String czD() {
        return "/cgi-bin/mmpay-bin/h5f2ftransfercancelpay";
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1257;
    }

    @Override // com.tencent.mm.wallet_core.b.a.a
    public final int czE() {
        return 1257;
    }
}
