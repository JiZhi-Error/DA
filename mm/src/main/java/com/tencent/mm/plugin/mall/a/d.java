package com.tencent.mm.plugin.mall.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class d {
    public String zjj = "";
    public int zjk = 0;
    public String zjl = "";

    public d(String str) {
        AppMethodBeat.i(65990);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zjj = jSONObject.optString("eu_protocol_url");
            this.zjk = jSONObject.optInt(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.zjl = jSONObject.optString("wxpay_protocol_url");
            AppMethodBeat.o(65990);
        } catch (Exception e2) {
            Log.printErrStackTrace("MciroMsg.EUInfo", e2, "", new Object[0]);
            AppMethodBeat.o(65990);
        }
    }
}
