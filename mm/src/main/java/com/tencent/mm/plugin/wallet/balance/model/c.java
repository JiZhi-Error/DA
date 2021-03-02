package com.tencent.mm.plugin.wallet.balance.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends m {
    public boolean HsS = false;
    public String dNQ = null;

    public c(int i2, String str, String str2, String str3, int i3, String str4) {
        AppMethodBeat.i(213845);
        HashMap hashMap = new HashMap();
        hashMap.put("flag", String.valueOf(i2));
        hashMap.put("passwd", str);
        hashMap.put("req_key", str3);
        hashMap.put("verify_code", str2);
        hashMap.put("pay_scene", String.valueOf(i3));
        hashMap.put("ignore_bind", str4);
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str4)) {
            this.HsS = true;
        }
        setRequestData(hashMap);
        HashMap hashMap2 = new HashMap();
        if (z.hhq()) {
            hashMap2.put("uuid_for_bindcard", z.getBindCardUuid());
            hashMap2.put("bindcard_scene", new StringBuilder().append(z.hhr()).toString());
        }
        setWXRequestData(hashMap2);
        AppMethodBeat.o(213845);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 76;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(68393);
        Log.d("Micromsg.NetSceneTenpayBalanceSave", "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            AppMethodBeat.o(68393);
            return;
        }
        this.dNQ = jSONObject.optString("req_key");
        AppMethodBeat.o(68393);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1506;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/verifybind";
    }
}
