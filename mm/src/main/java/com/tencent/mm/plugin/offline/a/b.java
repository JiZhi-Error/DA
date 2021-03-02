package com.tencent.mm.plugin.offline.a;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends m {
    public String TAG = "MicroMsg.NetSceneOfflineAckMsg";

    public b(boolean z) {
        AppMethodBeat.i(66282);
        HashMap hashMap = new HashMap();
        hashMap.put("ack_key", a.eAH());
        hashMap.put("req_key", a.eAI());
        hashMap.put("paymsg_type", new StringBuilder().append(a.eAJ()).toString());
        hashMap.put("transactionid", a.eAK());
        hashMap.put(TencentLocation.NETWORK_PROVIDER, new StringBuilder().append(a.getNetworkType(MMApplicationContext.getContext())).toString());
        hashMap.put("processed", k.AIX ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("is_pos_enabled", a.eAL() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("channel", z ? "pull" : "push");
        hashMap.put(AppMeasurement.Param.TIMESTAMP, new StringBuilder().append(System.currentTimeMillis() / 1000).toString());
        setRequestData(hashMap);
        AppMethodBeat.o(66282);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(66283);
        if (i2 == 0) {
            Log.v(this.TAG, "response ok");
            h.INSTANCE.idkeyStat(135, 68, 1, true);
            int optInt = jSONObject.optInt("poll_time") * 1000;
            if (optInt > 0) {
                g.aAi();
                g.aAh().azQ().set(ar.a.BUSINESS_OFFLINE_GETMSG_INTERVAL_INT, Integer.valueOf(optInt));
            }
            AppMethodBeat.o(66283);
            return;
        }
        Log.v(this.TAG, "response fail");
        h.INSTANCE.idkeyStat(135, 69, 1, true);
        AppMethodBeat.o(66283);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1230;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineackmsg";
    }
}
