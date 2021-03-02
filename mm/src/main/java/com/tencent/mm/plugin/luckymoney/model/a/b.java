package com.tencent.mm.plugin.luckymoney.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.ay;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;

public final class b extends ay {
    public b(int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i4) {
        AppMethodBeat.i(258596);
        this.yQE = str;
        this.egX = str2;
        this.talker = str5;
        HashMap hashMap = new HashMap();
        hashMap.put("msgType", String.valueOf(i2));
        hashMap.put("channelId", String.valueOf(i3));
        hashMap.put("sendId", str);
        if (!Util.isNullOrNil(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        if (!Util.isNullOrNil(str3)) {
            hashMap.put("headImg", URLEncoder.encode(str3));
            hashMap.put("nickName", URLEncoder.encode(Util.nullAsNil(str4)));
        }
        hashMap.put("ver", str6);
        hashMap.put("timingIdentifier", str7);
        hashMap.put("left_button_continue", str8);
        hashMap.put("liveid", str9);
        hashMap.put("liveattach", str10);
        if (i4 > 0) {
            hashMap.put("channellive_sender_flag", String.valueOf(i4));
        }
        Log.i("MicroMsg.NetSceneLiveOpenLuckyMoney", "NetSceneOpenLuckyMoney request");
        setRequestData(hashMap);
        AppMethodBeat.o(258596);
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ay, com.tencent.mm.ak.q
    public final int getType() {
        return 4595;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ay, com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public final String czD() {
        return "/cgi-bin/mmpay-bin/ftfhb/channelliveopenwxhb";
    }
}
