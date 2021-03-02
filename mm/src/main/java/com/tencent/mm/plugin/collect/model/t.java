package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class t extends m {
    public String dFv;
    public String desc;
    public String qwI = null;
    public double qwJ;
    public int qwK;

    public t(double d2, String str, String str2) {
        AppMethodBeat.i(63848);
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("fee", new StringBuilder().append(Math.round(100.0d * d2)).toString());
            hashMap.put("fee_type", str);
            hashMap.put("desc", URLEncoder.encode(str2, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        } catch (UnsupportedEncodingException e2) {
            Log.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceQuery", e2, "", new Object[0]);
        }
        this.qwJ = d2;
        this.dFv = str;
        this.desc = str2;
        setRequestData(hashMap);
        AppMethodBeat.o(63848);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1623;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transfersetf2ffee";
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(63849);
        Log.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            AppMethodBeat.o(63849);
            return;
        }
        this.qwI = jSONObject.optString("pay_url");
        this.qwK = ag.aqj(jSONObject.optInt("qrcode_level"));
        Log.i("Micromsg.NetSceneTenpayRemittanceQuery", "qrcodeLevel:%s ", Integer.valueOf(this.qwK));
        AppMethodBeat.o(63849);
    }
}
