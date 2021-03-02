package com.tencent.mm.plugin.remittance.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.wallet_core.b.a.a;
import com.tencent.mm.wallet_core.c.j;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class r extends a implements j {
    public String CoO;

    public r(long j2, String str, String str2, String str3, String str4, String str5, int i2, int i3) {
        AppMethodBeat.i(67873);
        HashMap hashMap = new HashMap();
        hashMap.put("amount", String.valueOf(j2));
        hashMap.put("recv_username", str);
        hashMap.put("recv_nickname", str2);
        hashMap.put("qrcodeid", str5);
        try {
            if (!Util.isNullOrNil(str3)) {
                hashMap.put("desc", URLEncoder.encode(str3, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            }
            if (!Util.isNullOrNil(str4)) {
                hashMap.put("message", URLEncoder.encode(str4, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            }
        } catch (UnsupportedEncodingException e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferPay", e2, "", new Object[0]);
        }
        hashMap.put(FirebaseAnalytics.b.CURRENCY, String.valueOf(i2));
        hashMap.put("set_amount", String.valueOf(i3));
        setRequestData(hashMap);
        Log.i("MicroMsg.NetSceneH5F2fTransferPay", "username: %s, nickname: %s, amount: %s, desc: %s, msg: %s, currency: %s", str, str2, Long.valueOf(j2), str3, str4, Integer.valueOf(i2));
        AppMethodBeat.o(67873);
    }

    @Override // com.tencent.mm.wallet_core.b.a.a
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(67874);
        this.CoO = jSONObject.optString("payurl", "");
        Log.i("MicroMsg.NetSceneH5F2fTransferPay", "payurl: %s", this.CoO);
        AppMethodBeat.o(67874);
    }

    @Override // com.tencent.mm.wallet_core.b.a.a
    public final String czD() {
        return "/cgi-bin/mmpay-bin/h5f2ftransferpay";
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1529;
    }

    @Override // com.tencent.mm.wallet_core.b.a.a
    public final int czE() {
        return 1529;
    }
}
