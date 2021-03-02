package com.tencent.mm.plugin.luckymoney.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.ao;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;

public final class d extends ao {
    public d(String str, String str2, String str3, String str4, String str5, int i2) {
        this(str, 0, str2, str3, "", str4, str5, i2);
    }

    public d(String str, int i2, String str2, long j2, String str3, String str4, String str5, String str6, int i3) {
        AppMethodBeat.i(258598);
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
        hashMap.put("liveid", str5);
        hashMap.put("liveattach", str6);
        if (i3 > 0) {
            hashMap.put("channellive_sender_flag", String.valueOf(i3));
        }
        Log.i("MicroMsg.NetSceneLiveQryLuckyMoneyDetail", "sendId: %s, limit: %s，offet: %s, nativeUrl: %s，processContent: %s", str, 11, Integer.valueOf(i2), str2, str4);
        setRequestData(hashMap);
        AppMethodBeat.o(258598);
    }

    public d(String str, int i2, String str2, String str3, String str4, String str5, String str6, int i3) {
        AppMethodBeat.i(258599);
        HashMap hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("limit", "11");
        hashMap.put("offset", String.valueOf(i2));
        if (!Util.isNullOrNil(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("ver", str3);
        hashMap.put("processContent", str4);
        hashMap.put("liveid", str5);
        hashMap.put("liveattach", str6);
        if (i3 > 0) {
            hashMap.put("channellive_sender_flag", String.valueOf(i3));
        }
        Log.i("MicroMsg.NetSceneLiveQryLuckyMoneyDetail", "sendId: %s, limit: %s，offet: %s, nativeUrl: %s，processContent: %s", str, 11, Integer.valueOf(i2), str2, str4);
        setRequestData(hashMap);
        AppMethodBeat.o(258599);
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ao, com.tencent.mm.ak.q
    public final int getType() {
        return 4339;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ao, com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public final String czD() {
        return "/cgi-bin/mmpay-bin/ftfhb/channelliveqrydetailwxhb";
    }
}
