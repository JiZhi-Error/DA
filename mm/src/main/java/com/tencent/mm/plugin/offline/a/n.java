package com.tencent.mm.plugin.offline.a;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n extends m {
    public static String AJR = "";
    public static String AJy = "";
    public String AJS = "";
    public String AJT = "";
    public String AJU = "";
    final Map<String, String> AJV = new HashMap();
    public int AJo = -1;
    public String AJp = "";
    private int dDN = -1;
    private String qwn = "";

    public n(String str, int i2) {
        AppMethodBeat.i(66310);
        this.AJV.put(TPDownloadProxyEnum.USER_DEVICE_ID, q.aoG());
        this.AJV.put(AppMeasurement.Param.TIMESTAMP, str);
        this.AJV.put("scene", String.valueOf(i2));
        this.AJV.put("sign", MD5Util.getMD5String(q.aoG() + "&" + str));
        Map<String, String> map = this.AJV;
        StringBuilder sb = new StringBuilder();
        g.aAi();
        map.put("code_ver", sb.append(g.aAh().azQ().get(ar.a.USERINFO_WALLET_OFFLINE_CODE_VER_STRING, "")).toString());
        setRequestData(this.AJV);
        AppMethodBeat.o(66310);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 49;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(66311);
        if (jSONObject != null) {
            AJy = jSONObject.optString("limit_fee");
            AJR = jSONObject.optString("is_show_order_detail");
            String optString = jSONObject.optString("pay_amount");
            String optString2 = jSONObject.optString("pay_number");
            String optString3 = jSONObject.optString("card_logos");
            k.ezn();
            k.bN(196629, AJy);
            k.ezn();
            k.bN(196641, AJR);
            k.ezn();
            k.bN(196645, optString);
            k.ezn();
            k.bN(196646, optString2);
            a.aJo(optString3);
            this.dDN = jSONObject.optInt("retcode");
            this.qwn = jSONObject.optString("retmsg");
            this.AJo = jSONObject.optInt("wx_error_type");
            this.AJp = jSONObject.optString("wx_error_msg");
            this.AJS = jSONObject.optString("get_code_flag");
            this.AJT = jSONObject.optString("micropay_pause_flag");
            this.AJU = jSONObject.optString("micropay_pause_word");
        }
        AppMethodBeat.o(66311);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 568;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinequeryuser";
    }
}
