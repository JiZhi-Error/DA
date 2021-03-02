package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends m {
    public boolean JPF = true;
    public String hXp;
    public String name;
    public String token;

    public b(String str, int i2, String str2) {
        AppMethodBeat.i(72299);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("bank_type", str2);
        hashMap.put("check_pwd_scene", String.valueOf(i2));
        setRequestData(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("check_pwd_scene", String.valueOf(i2));
        setWXRequestData(hashMap2);
        AppMethodBeat.o(72299);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 63;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72300);
        Log.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            AppMethodBeat.o(72300);
            return;
        }
        this.token = jSONObject.optString("session_key");
        if ("1".equals(jSONObject.optString("all_info"))) {
            this.JPF = false;
            AppMethodBeat.o(72300);
            return;
        }
        this.JPF = true;
        this.name = jSONObject.optString("name");
        this.hXp = jSONObject.optString("cre_id");
        AppMethodBeat.o(72300);
    }
}
