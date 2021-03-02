package com.tencent.mm.plugin.wallet.pwd.a;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class j extends m {
    public j(String str, String str2) {
        AppMethodBeat.i(69551);
        HashMap hashMap = new HashMap();
        hashMap.put("auth_token", str);
        hashMap.put("passwd", String.valueOf(str2));
        hashMap.put(AppMeasurement.Param.TIMESTAMP, new StringBuilder().append(System.currentTimeMillis()).toString());
        setRequestData(hashMap);
        AppMethodBeat.o(69551);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/resetpaypwdbyface";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 2514;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 2514;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69552);
        Log.i("MicroMsg.NetSceneResetPayPwdByFace", "onGYNetEnd, errCode: %s, errMsg: %s, json: %s", Integer.valueOf(i2), str, jSONObject);
        if (i2 == 0) {
            jSONObject.optString("retcode");
            jSONObject.optString("retmsg");
        }
        AppMethodBeat.o(69552);
    }
}
