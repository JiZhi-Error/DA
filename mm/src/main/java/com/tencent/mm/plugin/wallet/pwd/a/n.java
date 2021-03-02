package com.tencent.mm.plugin.wallet.pwd.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class n extends m implements com.tencent.mm.network.m {
    public JSONObject HIy;

    public n(boolean z, String str, String str2) {
        AppMethodBeat.i(69563);
        HashMap hashMap = new HashMap();
        Log.d("MicroMsg.NetSceneTenpayQueryBasicSecurityInfo", "cpuId: %s, uid: %s", str, str2);
        hashMap.put("is_root", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("is_device_open_touch", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("cpu_id", str);
        hashMap.put("app_uid", str2);
        setRequestData(hashMap);
        AppMethodBeat.o(69563);
    }

    @Override // com.tencent.mm.ak.q, com.tencent.mm.wallet_core.tenpay.model.m
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69564);
        this.callback = iVar;
        int doScene = super.doScene(gVar, iVar);
        AppMethodBeat.o(69564);
        return doScene;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/paysecurity";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1669;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69565);
        Log.i("MicroMsg.NetSceneTenpayQueryBasicSecurityInfo", "alvinluo errCode: %d, errMsg: %s", Integer.valueOf(i2), str);
        if (i2 == 0 && jSONObject != null) {
            Log.v("MicroMsg.NetSceneTenpayQueryBasicSecurityInfo", "alvinluo json: %s", jSONObject.toString());
            this.HIy = jSONObject;
            ad.hhv().ck(this.HIy);
        }
        AppMethodBeat.o(69565);
    }
}
