package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class f extends m {
    private boolean ebI = true;

    public f(String str, String str2) {
        AppMethodBeat.i(66292);
        HashMap hashMap = new HashMap();
        hashMap.put("code_ver", str);
        hashMap.put("cn", str2);
        Log.i("MicroMsg.NetSceneOfflineVerifyToken", "reqtoken ver %s cn: %s", str, str2);
        setRequestData(hashMap);
        AppMethodBeat.o(66292);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1686;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineverifytoken";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1686;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(66293);
        Log.i("MicroMsg.NetSceneOfflineVerifyToken", "respone %d errMsg: %s", Integer.valueOf(i2), str);
        if (i2 == 0) {
            Log.i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken succ");
            h.INSTANCE.idkeyStat(135, 22, 1, true);
            AppMethodBeat.o(66293);
            return;
        }
        Log.i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken fail.errCode = %d ;errMsg = ", Integer.valueOf(i2), str);
        h.INSTANCE.idkeyStat(135, 23, 1, true);
        AppMethodBeat.o(66293);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd2(e eVar, JSONObject jSONObject) {
        AppMethodBeat.i(66294);
        if (eVar.Rtu != 0 || eVar.errType == 0) {
            this.ebI = true;
        } else {
            this.ebI = false;
        }
        Log.i("MicroMsg.NetSceneOfflineVerifyToken", "onGYNetEnd2 isBlock %s", Boolean.valueOf(this.ebI));
        AppMethodBeat.o(66294);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final boolean isBlock() {
        return this.ebI;
    }
}
