package com.tencent.mm.plugin.luckymoney.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;

public final class bb extends ba {
    public bb(int i2, long j2, long j3, int i3, String str, String str2, String str3, String str4, String str5, String str6, int i4, String str7, String str8, int i5, int i6, String str9, String str10, int i7) {
        AppMethodBeat.i(213328);
        this.qwe = i2;
        HashMap hashMap = new HashMap();
        hashMap.put("totalNum", String.valueOf(i2));
        hashMap.put("totalAmount", String.valueOf(j2));
        hashMap.put("perValue", String.valueOf(j3));
        hashMap.put("hbType", String.valueOf(i3));
        hashMap.put("wishing", URLEncoder.encode(Util.nullAsNil(str)));
        hashMap.put("sendUserName", str5);
        if (!Util.isNullOrNil(str8)) {
            hashMap.put("unique_id", str8);
        }
        hashMap.put("user_confirm_jump", String.valueOf(i5));
        hashMap.put("unpay_type", String.valueOf(i6));
        hashMap.put("cancel_sendid", str9);
        hashMap.put("expression_md5", str10);
        hashMap.put("expression_type", String.valueOf(i7));
        if (!Util.isNullOrNil(str3)) {
            hashMap.put(ch.COL_USERNAME, str3);
        }
        if (!Util.isNullOrNil(str2)) {
            hashMap.put("headImg", URLEncoder.encode(str2));
            hashMap.put("nickName", URLEncoder.encode(Util.nullAsNil(str6)));
            if (!Util.isNullOrNil(str4)) {
                hashMap.put("receiveNickName", URLEncoder.encode(str4));
            }
        }
        hashMap.put("inWay", String.valueOf(i4));
        if (i4 == 0 || i4 == 1 || i4 == 7) {
            hashMap.put("needSendToMySelf", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        hashMap.put("showSourceMac", URLEncoder.encode(str7));
        hashMap.put("scene", "20");
        hashMap.put("union_source", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Log.i("MicroMsg.NetScenePrepareLuckyMoneyUnion", "NetScenePrepareLuckyMoneyUnion request :uniqueId:%s, userConfiremJump:%s, unpayType:%s, cancelSendId:%s", str8, Integer.valueOf(i5), Integer.valueOf(i6), Util.nullAsNil(str9));
        setRequestData(hashMap);
        AppMethodBeat.o(213328);
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ba, com.tencent.mm.ak.q
    public final int getType() {
        return 4915;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ba, com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public final String czD() {
        return "/cgi-bin/mmpay-bin/unionhb/requestunionhb";
    }
}
