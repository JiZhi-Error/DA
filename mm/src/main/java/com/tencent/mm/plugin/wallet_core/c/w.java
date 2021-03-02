package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class w extends m {
    public String HPZ;
    private int scene;
    public String token;

    public w(String str, int i2, String str2) {
        AppMethodBeat.i(69937);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("req_key", str2);
        if (i2 == 6) {
            hashMap.put("time_stamp", new StringBuilder().append(System.currentTimeMillis()).toString());
        }
        setRequestData(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("check_pwd_scene", String.valueOf(i2));
        if (z.hhq()) {
            hashMap2.put("uuid_for_bindcard", z.getBindCardUuid());
            hashMap2.put("bindcard_scene", new StringBuilder().append(z.hhr()).toString());
        }
        setWXRequestData(hashMap2);
        this.scene = i2;
        AppMethodBeat.o(69937);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 18;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69938);
        Log.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i2 + " errMsg: " + str);
        if (this.scene == 6 || this.scene == 8 || this.scene == 18 || this.scene == 1) {
            this.token = jSONObject.optString("usertoken");
            this.HPZ = jSONObject.optString("token_type");
        }
        AppMethodBeat.o(69938);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return JsApiOpenAdCanvas.CTRL_INDEX;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/checkpwd";
    }
}
