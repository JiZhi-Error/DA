package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.network.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class s extends m {
    public s(String str) {
        AppMethodBeat.i(69573);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        setRequestData(hashMap);
        AppMethodBeat.o(69573);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/touchlockauthen";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69574);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = str;
        objArr[2] = jSONObject != null ? jSONObject.toString() : BuildConfig.COMMAND;
        Log.v("MicroMsg.NetSceneTouchLockVerifyByPwd", "alvinluo errCode: %d, errMsg: %s, json: %s", objArr);
        AppMethodBeat.o(69574);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1304;
    }

    @Override // com.tencent.mm.ak.q, com.tencent.mm.wallet_core.tenpay.model.m
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69575);
        this.callback = iVar;
        int doScene = super.doScene(gVar, iVar);
        AppMethodBeat.o(69575);
        return doScene;
    }
}
