package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class f extends m {
    public int HPB;
    public String desc;
    public String jmT;
    public String title;

    public f(String str, String str2, String str3, int i2, String str4, RealNameBundle realNameBundle) {
        AppMethodBeat.i(174504);
        HashMap hashMap = new HashMap();
        hashMap.put("flag", "1");
        hashMap.put("passwd", str);
        hashMap.put("token", str2);
        hashMap.put("face_token", str3);
        hashMap.put("realname_scene", String.valueOf(i2));
        hashMap.put("session_id", str4);
        Log.i("MicroMsg.NetSceneRealNameReg", "realname_scene=%d", Integer.valueOf(i2));
        if (realNameBundle != null) {
            realNameBundle.aY(hashMap);
        }
        setRequestData(hashMap);
        AppMethodBeat.o(174504);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1648;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(70144);
        Log.i("MicroMsg.NetSceneRealNameReg", "errCode=" + str + ";errMsg=" + str);
        this.title = jSONObject.optString("title");
        this.desc = jSONObject.optString("desc");
        this.jmT = jSONObject.optString("page");
        this.HPB = jSONObject.optInt("err_jump_page");
        AppMethodBeat.o(70144);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnamereg";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1648;
    }
}
