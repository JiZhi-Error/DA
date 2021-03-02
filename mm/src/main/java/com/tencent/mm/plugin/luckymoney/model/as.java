package com.tencent.mm.plugin.luckymoney.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class as extends av {
    public String qwI;

    public as(int i2, long j2, long j3, int i3, String str, String str2, String str3, String str4, int i4) {
        AppMethodBeat.i(65291);
        HashMap hashMap = new HashMap();
        hashMap.put("totalNum", String.valueOf(i2));
        hashMap.put("totalAmount", String.valueOf(j2));
        hashMap.put("perValue", String.valueOf(j3));
        hashMap.put("hbType", String.valueOf(i3));
        hashMap.put("wishing", URLEncoder.encode(Util.nullAsNil(str)));
        hashMap.put(FirebaseAnalytics.b.CURRENCY, String.valueOf(i4));
        if (!Util.isNullOrNil(str3)) {
            hashMap.put("headImg", URLEncoder.encode(str3));
        }
        hashMap.put("nickName", URLEncoder.encode(Util.nullAsNil(str4)));
        if (!Util.isNullOrNil(str2)) {
            hashMap.put(ch.COL_USERNAME, URLEncoder.encode(str2));
        }
        setRequestData(hashMap);
        AppMethodBeat.o(65291);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1647;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public final String czD() {
        return "/cgi-bin/mmpay-bin/h5requestwxhb";
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah
    public final int czE() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(65292);
        Log.i("MicroMsg.NetSceneLuckyMoneyH5Request", "NetSceneLuckyMoneyH5Request response errCode=".concat(String.valueOf(i2)));
        if (i2 == 0) {
            this.qwI = jSONObject.optString("payUrl");
        }
        AppMethodBeat.o(65292);
    }
}
