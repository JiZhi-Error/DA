package com.tencent.mm.plugin.luckymoney.model.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.ba;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;

public final class c extends ba {
    public c(int i2, long j2, long j3, int i3, String str, String str2, String str3, String str4, String str5, int i4, String str6, String str7, int i5, int i6, String str8, String str9, int i7, String str10, String str11, String str12, int i8) {
        AppMethodBeat.i(258597);
        Log.i("MicroMsg.NetSceneLivePrepareLuckyMoney", "NetScenePrepareLuckyMoney() uniqueId:%s, userConfiremJump:%s, unpayType:%s, cancelSendId:%s", str7, Integer.valueOf(i5), Integer.valueOf(i6), Util.nullAsNil(str8));
        this.qwe = i2;
        HashMap hashMap = new HashMap();
        if (i3 == 3) {
            hashMap.put("totalNum", "1");
        } else {
            hashMap.put("totalNum", String.valueOf(i2));
        }
        hashMap.put("totalAmount", String.valueOf(j2));
        hashMap.put("perValue", String.valueOf(j3));
        hashMap.put("hbType", String.valueOf(i3));
        hashMap.put("wishing", URLEncoder.encode(Util.nullAsNil(str)));
        hashMap.put("sendUserName", str4);
        if (!Util.isNullOrNil(str7)) {
            hashMap.put("unique_id", str7);
        }
        hashMap.put("user_confirm_jump", String.valueOf(i5));
        hashMap.put("unpay_type", String.valueOf(i6));
        hashMap.put("cancel_sendid", str8);
        hashMap.put("expression_md5", str9);
        hashMap.put("expression_type", String.valueOf(i7));
        if (!Util.isNullOrNil(str2)) {
            hashMap.put("headImg", URLEncoder.encode(str2));
            hashMap.put("nickName", URLEncoder.encode(Util.nullAsNil(str5)));
            if (!Util.isNullOrNil(str3)) {
                hashMap.put("receiveNickName", URLEncoder.encode(str3));
            }
        }
        hashMap.put("inWay", String.valueOf(i4));
        if (i4 == 0 || i4 == 1 || i4 == 7) {
            hashMap.put("needSendToMySelf", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        hashMap.put("showSourceMac", URLEncoder.encode(str6));
        hashMap.put("exclusiveRecvUsername", str10);
        hashMap.put("liveid", str11);
        hashMap.put("liveattach", str12);
        if (i8 > 0) {
            hashMap.put("channellive_sender_flag", String.valueOf(i8));
        }
        hashMap.put("scene", "23");
        setRequestData(hashMap);
        AppMethodBeat.o(258597);
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ba, com.tencent.mm.ak.q
    public final int getType() {
        return 4373;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ba, com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public final String czD() {
        return "/cgi-bin/mmpay-bin/ftfhb/channelliverequestwxhb";
    }
}
