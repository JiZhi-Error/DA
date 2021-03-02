package com.tencent.mm.plugin.collect.model;

import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.b.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class n extends a {
    public int dDN;
    public String desc;
    public long eht;
    public String jTx;
    public String jTy;
    public String qwn;
    public String qwo;
    public int qwp;
    public String qwq;
    public String qwr;
    public String qws;
    public String qwt;
    public String qwu;
    public String qwv;
    public int qww;
    public String qwx;
    public String qwy;
    public int qwz;

    public n(int i2) {
        AppMethodBeat.i(63832);
        HashMap hashMap = new HashMap();
        hashMap.put("set_amount", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("wallet_type", String.valueOf(i2));
        setRequestData(hashMap);
        Log.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "setAmount: %s, walletType: %s", 0, Integer.valueOf(i2));
        AppMethodBeat.o(63832);
    }

    public n(long j2, String str, int i2) {
        AppMethodBeat.i(63833);
        HashMap hashMap = new HashMap();
        hashMap.put("amount", String.valueOf(j2));
        hashMap.put("set_amount", "1");
        try {
            if (!Util.isNullOrNil(str)) {
                hashMap.put("desc", URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            }
        } catch (UnsupportedEncodingException e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferGetQrCode", e2, "", new Object[0]);
        }
        hashMap.put("wallet_type", String.valueOf(i2));
        setRequestData(hashMap);
        this.eht = j2;
        this.desc = str;
        Log.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "amount: %d, setAmount: %s, desc: %s, walletType: %s", Long.valueOf(j2), 1, str, Integer.valueOf(i2));
        AppMethodBeat.o(63833);
    }

    @Override // com.tencent.mm.wallet_core.b.a.a
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(63834);
        this.dDN = jSONObject.optInt("retcode", 0);
        this.qwn = jSONObject.optString("retmsg", "");
        this.qwo = jSONObject.optString("qrcode_url", "");
        this.qwp = jSONObject.optInt("alert_type", 0);
        this.qwq = jSONObject.optString("alert_title", "");
        this.qwr = jSONObject.optString("left_button_text", "");
        this.qws = jSONObject.optString("right_button_text", "");
        this.qwt = jSONObject.optString("right_button_url", "");
        this.qwu = jSONObject.optString("bottom_text", "");
        this.qwv = jSONObject.optString("bottom_url", "");
        this.qww = jSONObject.optInt(FirebaseAnalytics.b.CURRENCY, 0);
        this.qwx = jSONObject.optString("currencyunit", "");
        this.jTx = jSONObject.optString("notice", "");
        this.jTy = jSONObject.optString("notice_url", "");
        this.qwy = jSONObject.optString("recv_realname", "");
        this.qwz = jSONObject.optInt("set_amount", 0);
        if (this.qwz == 0) {
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_HK_PAY_URL_STRING, this.qwo);
            Log.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "set payurl: %s", this.qwo);
        }
        Log.d("MicroMsg.NetSceneH5F2fTransferGetQrCode", "url: %s, currency: %s", this.qwo, Integer.valueOf(this.qww));
        AppMethodBeat.o(63834);
    }

    @Override // com.tencent.mm.wallet_core.b.a.a
    public final String czD() {
        return "/cgi-bin/mmpay-bin/h5f2ftransfergetqrcode";
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1335;
    }

    @Override // com.tencent.mm.wallet_core.b.a.a
    public final int czE() {
        return 1335;
    }

    @Override // com.tencent.mm.wallet_core.b.a.a
    public final boolean czF() {
        return true;
    }
}
