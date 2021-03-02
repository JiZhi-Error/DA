package com.tencent.mm.plugin.luckymoney.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.utils.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class az extends ay {
    public az(int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(213325);
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
        hashMap.put("sessionUserName", str5);
        hashMap.put("ver", str6);
        hashMap.put("timingIdentifier", str7);
        hashMap.put("union_source", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Log.i("MicroMsg.NetSceneOpenLuckyMoneyUnion", "NetSceneOpenLuckyMoneyUnion request");
        setRequestData(hashMap);
        AppMethodBeat.o(213325);
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ay, com.tencent.mm.ak.q
    public final int getType() {
        return 5148;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ay, com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public final String czD() {
        return "/cgi-bin/mmpay-bin/unionhb/openunionhb";
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ay, com.tencent.mm.plugin.luckymoney.model.ah
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        JSONObject optJSONObject;
        AppMethodBeat.i(213326);
        Log.i("MicroMsg.NetSceneOpenLuckyMoneyUnion", "errCode: %s, errMsg: %s ，json：%s", Integer.valueOf(i2), str, jSONObject.toString());
        try {
            this.yWT = ac.aY(jSONObject);
            this.yXj = LuckyMoneyEmojiSwitch.aX(jSONObject);
            Log.i("MicroMsg.NetSceneOpenLuckyMoneyUnion", "luckyMoneyEmojiSwitch:%s", this.yXj.toString());
            this.yXh = jSONObject.optString("expression_md5");
            this.yXi = jSONObject.optInt("expression_type");
            Log.i("MicroMsg.NetSceneOpenLuckyMoneyUnion", "expressionmd5:%s expressiontype:%s", this.yXh, Integer.valueOf(this.yXi));
            if (i2 == 0 && jSONObject.has("real_name_info") && (optJSONObject = jSONObject.optJSONObject("real_name_info")) != null) {
                String optString = optJSONObject.optString("guide_flag");
                String optString2 = optJSONObject.optString("guide_wording");
                String optString3 = optJSONObject.optString("left_button_wording");
                String optString4 = optJSONObject.optString("right_button_wording");
                String optString5 = optJSONObject.optString("upload_credit_url");
                this.yRu = new RealnameGuideHelper();
                this.yRu.b(optString, optString2, optString3, optString4, optString5, 1003);
            }
            if (jSONObject.has("intercept_win")) {
                this.yXE = b.bV(jSONObject.optJSONObject("intercept_win"));
            }
            this.yXC = jSONObject.optString("SystemMsgContext");
            this.yXD = jSONObject.optInt("showYearExpression");
            Log.i("MicroMsg.NetSceneOpenLuckyMoneyUnion", "showYearExpression:%s", Integer.valueOf(this.yXD));
            if (i2 == 0 && !Util.isNullOrNil(this.yXC) && !ab.IN(this.talker)) {
                try {
                    af.iB(this.yXC, this.talker);
                } catch (Exception e2) {
                    Log.e("MicroMsg.NetSceneOpenLuckyMoneyUnion", "insertLocalSysMsgIfNeed error: %s", e2.getMessage());
                }
            }
            efk();
            AppMethodBeat.o(213326);
        } catch (JSONException e3) {
            Log.w("MicroMsg.NetSceneOpenLuckyMoneyUnion", "parse luckyMoneyDetail fail: " + e3.getLocalizedMessage());
            AppMethodBeat.o(213326);
        }
    }
}
