package com.tencent.mm.plugin.luckymoney.model.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.model.bd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.net.URLEncoder;
import java.util.HashMap;

public final class e extends bd {
    public e(int i2, String str, String str2, int i3, String str3, String str4, String str5, String str6, int i4) {
        AppMethodBeat.i(258600);
        this.msgType = 1;
        this.channelId = i2;
        this.yQE = str;
        this.egX = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("msgType", "1");
        hashMap.put("channelId", String.valueOf(i2));
        hashMap.put("sendId", str);
        hashMap.put("inWay", String.valueOf(i3));
        hashMap.put("ver", str3);
        g.aAi();
        long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REALNAME_DISCLAIMER_QUERY_EXPIRED_TIME_LONG_SYNC, (Object) 0L)).longValue();
        if (longValue > 0) {
            if (System.currentTimeMillis() < longValue) {
                hashMap.put("agreeDuty", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            } else {
                StringBuilder sb = new StringBuilder();
                g.aAi();
                hashMap.put("agreeDuty", sb.append((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_DISCLAIMER_NEED_AGERR_INT_SYNC, (Object) 1)).toString());
            }
        }
        if (!Util.isNullOrNil(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("group_name", str4);
        hashMap.put("liveid", str5);
        hashMap.put("liveattach", str6);
        if (i4 > 0) {
            hashMap.put("channellive_sender_flag", String.valueOf(i4));
        }
        Log.i("MicroMsg.NetSceneLiveReceiveLuckyMoney", "NetSceneReceiveLuckyMoney request");
        setRequestData(hashMap);
        AppMethodBeat.o(258600);
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.bd, com.tencent.mm.ak.q
    public final int getType() {
        return 4717;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.bd, com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public final String czD() {
        return "/cgi-bin/mmpay-bin/ftfhb/channellivereceivewxhb";
    }
}
