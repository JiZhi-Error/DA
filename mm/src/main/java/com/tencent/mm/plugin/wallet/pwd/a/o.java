package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.c;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class o extends m implements j {
    public o(v vVar) {
        AppMethodBeat.i(69566);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("flag", vVar.flag);
        hashMap.put("passwd", vVar.kdF);
        hashMap.put("rpasswd", vVar.kdF);
        hashMap.put("verify_code", vVar.IaW);
        hashMap.put("token", vVar.token);
        setPayInfo(vVar.BDB, hashMap, hashMap2);
        setRequestData(hashMap);
        setWXRequestData(hashMap2);
        AppMethodBeat.o(69566);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 20;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return c.CTRL_INDEX;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwd";
    }
}
