package com.tencent.mm.plugin.luckymoney.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class bc extends av {
    public String wFL;
    public String yQE;
    public String yXH;

    public bc(int i2, String str, String str2, String str3, String str4, String str5, int i3, String str6, int i4, String str7, int i5, int i6, String str8) {
        this(i2, str, str2, str3, str4, str5, i3, "", "", str6, i4, str7, i5, i6, str8);
    }

    private bc(int i2, String str, String str2, String str3, String str4, String str5, int i3, String str6, String str7, String str8, int i4, String str9, int i5, int i6, String str10) {
        AppMethodBeat.i(65307);
        HashMap hashMap = new HashMap();
        hashMap.put("amount", String.valueOf(i2));
        hashMap.put("wishing", URLEncoder.encode(Util.nullAsNil(str)));
        hashMap.put("sendUserName", str4);
        if (!Util.isNullOrNil(str3)) {
            hashMap.put(ch.COL_USERNAME, str3);
        }
        if (!Util.isNullOrNil(str2)) {
            hashMap.put("headImg", URLEncoder.encode(str2));
        }
        if (!Util.isNullOrNil(str5)) {
            hashMap.put("nickName", URLEncoder.encode(Util.nullAsNil(str5)));
        }
        hashMap.put("inWay", String.valueOf(i3));
        hashMap.put("imageId", str6);
        hashMap.put("imageAesKey", str7);
        hashMap.put("imageLength", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("expressionurl", str8);
        hashMap.put("expressiontype", String.valueOf(i4));
        if (!Util.isNullOrNil(str9)) {
            hashMap.put("unique_id", str9);
        }
        hashMap.put("user_confirm_jump", String.valueOf(i5));
        hashMap.put("unpay_type", String.valueOf(i6));
        if (!Util.isNullOrNil(str10)) {
            hashMap.put("cancel_sendid", str10);
        }
        setRequestData(hashMap);
        AppMethodBeat.o(65307);
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public final String czD() {
        return "/cgi-bin/mmpay-bin/yearrequestwxhb";
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1643;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(65308);
        this.yQE = jSONObject.optString("sendId");
        this.wFL = jSONObject.optString("reqkey");
        this.yXH = jSONObject.optString("sendMsgXml");
        AppMethodBeat.o(65308);
    }
}
