package com.tencent.mm.plugin.luckymoney.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;

public final class ap extends ao {
    public ap(String str, String str2, String str3) {
        this(str, 0, str2, str3, "");
    }

    public ap(String str, int i2, String str2, long j2, String str3, String str4) {
        AppMethodBeat.i(213318);
        HashMap hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("limit", "11");
        hashMap.put("offset", String.valueOf(i2));
        if (!Util.isNullOrNil(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("befortTimestamp", String.valueOf(j2));
        hashMap.put("ver", str3);
        hashMap.put("processContent", str4);
        hashMap.put("union_source", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Log.i("MicroMsg.NetSceneLuckyMoneyDetailUnion", "sendId: %s, limit: %s，offet: %s, nativeUrl: %s，processContent: %s", str, 11, Integer.valueOf(i2), str2, str4);
        setRequestData(hashMap);
        AppMethodBeat.o(213318);
    }

    public ap(String str, int i2, String str2, String str3, String str4) {
        AppMethodBeat.i(213319);
        HashMap hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("limit", "11");
        hashMap.put("offset", String.valueOf(i2));
        if (!Util.isNullOrNil(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("ver", str3);
        hashMap.put("processContent", str4);
        hashMap.put("union_source", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Log.i("MicroMsg.NetSceneLuckyMoneyDetailUnion", "sendId: %s, limit: %s，offet: %s, nativeUrl: %s，processContent: %s", str, 11, Integer.valueOf(i2), str2, str4);
        setRequestData(hashMap);
        AppMethodBeat.o(213319);
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ao, com.tencent.mm.ak.q
    public final int getType() {
        return 4395;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ao, com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public final String czD() {
        return "/cgi-bin/mmpay-bin/unionhb/qrydetailunionhb";
    }
}
