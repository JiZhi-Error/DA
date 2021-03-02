package com.tencent.mm.plugin.offline.a;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends m {
    public String AJk;
    public int AJl;
    public String AJm;

    public d() {
        AppMethodBeat.i(66286);
        HashMap hashMap = new HashMap();
        g.aAi();
        Object obj = g.aAh().azQ().get(ar.a.BUSINESS_OFFLINE_GETMSG_ACK_KEY_STRING, (Object) null);
        if (obj != null) {
            hashMap.put("ack_key", (String) obj);
        }
        hashMap.put(AppMeasurement.Param.TIMESTAMP, new StringBuilder().append(System.currentTimeMillis()).toString());
        setRequestData(hashMap);
        AppMethodBeat.o(66286);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1981;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinegetmsg";
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(66287);
        if (i2 == 0) {
            h.INSTANCE.idkeyStat(135, 56, 1, true);
            this.AJk = jSONObject.optString("appmsg");
            this.AJl = jSONObject.optInt("poll_time") * 1000;
            this.AJm = jSONObject.optString("ack_key");
            if (this.AJl > 0) {
                g.aAi();
                g.aAh().azQ().set(ar.a.BUSINESS_OFFLINE_GETMSG_INTERVAL_INT, Integer.valueOf(this.AJl));
            }
            g.aAi();
            g.aAh().azQ().set(ar.a.BUSINESS_OFFLINE_GETMSG_ACK_KEY_STRING, this.AJm);
            AppMethodBeat.o(66287);
            return;
        }
        h.INSTANCE.idkeyStat(135, 57, 1, true);
        AppMethodBeat.o(66287);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final boolean resend() {
        return false;
    }

    @Override // com.tencent.mm.ak.q
    public final long getReturnTimeout() {
        AppMethodBeat.i(66288);
        long ezj = (long) com.tencent.mm.plugin.offline.g.ezj();
        AppMethodBeat.o(66288);
        return ezj;
    }
}
