package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.tenpay.model.m;
import org.json.JSONObject;

public final class h extends m {
    public String HTK;
    public String HTL;
    public String HTM;
    public String HTN;
    public int HTO;
    public long HTP;
    public String title;

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1614;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(70153);
        Log.i("MicroMsg.NetSceneRealnameGetDuty", "errCode=" + i2 + ";errMsg=" + str);
        if (i2 == 0 && jSONObject != null) {
            this.HTK = jSONObject.optString("agreed_flag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.title = jSONObject.optString("title", "");
            this.HTL = jSONObject.optString("service_protocol_wording", "");
            this.HTM = jSONObject.optString("service_protocol_url", "");
            this.HTN = jSONObject.optString("button_wording", "");
            this.HTP = jSONObject.optLong("delay_expired_time", 0);
            if (this.HTP > 0) {
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_WALLET_REALNAME_DISCLAIMER_QUERY_EXPIRED_TIME_LONG_SYNC, Long.valueOf(System.currentTimeMillis() + (this.HTP * 1000)));
            }
        }
        AppMethodBeat.o(70153);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnamegetduty";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1614;
    }
}
