package com.tencent.mm.plugin.remittance.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.wallet_core.b.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class s extends a {
    public String CoP;
    public String CoQ;
    public String CoR;
    public String CoS;
    public String desc;
    public long eht;
    public String jTx;
    public String jTy;
    public int qww;
    public String qwx;
    public String qwy;
    public int qwz;

    public s(String str) {
        AppMethodBeat.i(67875);
        HashMap hashMap = new HashMap();
        try {
            if (!Util.isNullOrNil(str)) {
                hashMap.put("qrcode_url", URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            }
        } catch (UnsupportedEncodingException e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferScanQrCode", e2, "", new Object[0]);
        }
        setRequestData(hashMap);
        Log.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "qrcode_url: %s", str);
        AppMethodBeat.o(67875);
    }

    @Override // com.tencent.mm.wallet_core.b.a.a
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(67876);
        this.CoP = jSONObject.optString("recv_username", "");
        this.qwy = jSONObject.optString("recv_realname", "");
        this.CoQ = jSONObject.optString("recv_nickname", "");
        this.desc = jSONObject.optString("desc", "");
        this.eht = jSONObject.optLong("amount", 0);
        this.qwz = jSONObject.optInt("set_amount", 0);
        this.qww = jSONObject.optInt(FirebaseAnalytics.b.CURRENCY, 0);
        this.qwx = jSONObject.optString("currencyunit", "");
        this.CoR = jSONObject.optString("qrcodeid", "");
        this.jTx = jSONObject.optString("notice", "");
        this.jTy = jSONObject.optString("notice_url", "");
        this.CoS = jSONObject.optString("recv_headimgurl", "");
        Log.i("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_username: %s, recv_nickname: %s, desc: %s, amount: %s, setAmount: %s, currencyunit: %s recv_headimgurl: %s", this.CoP, this.CoQ, this.desc, Long.valueOf(this.eht), Integer.valueOf(this.qwz), this.qwx, this.CoS);
        Log.d("MicroMsg.NetSceneH5F2fTransferScanQrCode", "recv_realname: %s", this.qwy);
        AppMethodBeat.o(67876);
    }

    @Override // com.tencent.mm.wallet_core.b.a.a
    public final String czD() {
        return "/cgi-bin/mmpay-bin/h5f2ftransferscanqrcode";
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1301;
    }

    @Override // com.tencent.mm.wallet_core.b.a.a
    public final int czE() {
        return 1301;
    }
}
