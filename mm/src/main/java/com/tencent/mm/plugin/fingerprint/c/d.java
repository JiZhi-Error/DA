package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends m implements com.tencent.mm.network.m {
    public d(int i2) {
        AppMethodBeat.i(64469);
        HashMap hashMap = new HashMap();
        e flM = com.tencent.mm.plugin.soter.d.d.flM();
        String str = flM.FhU;
        String str2 = flM.hFF;
        hashMap.put("cpu_id", str);
        hashMap.put("uid", str2);
        hashMap.put("soter_type", String.valueOf(i2));
        setRequestData(hashMap);
        AppMethodBeat.o(64469);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 116;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        int i3;
        AppMethodBeat.i(64470);
        if (i2 == 0) {
            if (jSONObject != null) {
                i3 = jSONObject.optInt("clear_rsa_key_level", 0);
            } else {
                i3 = 0;
            }
            ((i) g.af(i.class)).q(Integer.valueOf(i3));
            AppMethodBeat.o(64470);
            return;
        }
        Log.e("MicroMsg.NetSceneTenpayCloseTouchPay", "do close fingerprint cgi failed!");
        AppMethodBeat.o(64470);
    }

    @Override // com.tencent.mm.wallet_core.c.w, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(64471);
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        a aVar = (a) g.af(a.class);
        if (aVar.dJO()) {
            h.INSTANCE.a(13686, Integer.valueOf(i3), Integer.valueOf(i4));
        } else if (aVar.dJR()) {
            h.INSTANCE.a(16994, Integer.valueOf(i3), Integer.valueOf(i4));
        }
        if (i3 == 0 && i4 == 0) {
            aVar.pj(false);
            aVar.pk(false);
            Log.e("MicroMsg.NetSceneTenpayCloseTouchPay", "hy: do close fingerprint cgi success!");
            AppMethodBeat.o(64471);
            return;
        }
        Log.e("MicroMsg.NetSceneTenpayCloseTouchPay", "hy: do close fingerprint cgi failed!");
        AppMethodBeat.o(64471);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1597;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/closetouchpay";
    }
}
