package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ao extends av {
    long msgId;
    String talker;
    public q yWT;
    public String yXg;
    public String yXh;
    public int yXi;
    public LuckyMoneyEmojiSwitch yXj;

    public ao() {
        this.yWT = null;
    }

    public ao(String str, int i2, int i3, String str2, String str3) {
        this(str, i2, i3, str2, str3, "");
    }

    public ao(String str, int i2, String str2, long j2, String str3, String str4) {
        AppMethodBeat.i(65285);
        this.yWT = null;
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
        Log.i("MicroMsg.NetSceneLuckyMoneyDetail", "sendId: %s, limit: %s，offet: %s, nativeUrl: %s，processContent: %s", str, 11, Integer.valueOf(i2), str2, str4);
        setRequestData(hashMap);
        AppMethodBeat.o(65285);
    }

    public ao(String str, int i2, int i3, String str2, String str3, String str4) {
        AppMethodBeat.i(65286);
        this.yWT = null;
        HashMap hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("limit", String.valueOf(i2));
        hashMap.put("offset", String.valueOf(i3));
        if (!Util.isNullOrNil(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("ver", str3);
        hashMap.put("processContent", str4);
        Log.i("MicroMsg.NetSceneLuckyMoneyDetail", "sendId: %s, limit: %s，offet: %s, nativeUrl: %s，processContent: %s", str, Integer.valueOf(i2), Integer.valueOf(i3), str2, str4);
        setRequestData(hashMap);
        AppMethodBeat.o(65286);
    }

    @Override // com.tencent.mm.ak.q
    public int getType() {
        return 1585;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public String czD() {
        return "/cgi-bin/mmpay-bin/qrydetailwxhb";
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(65287);
        Log.i("MicroMsg.NetSceneLuckyMoneyDetail", "errCode: %s, errMsg: %s ，json：%s", Integer.valueOf(i2), str, jSONObject.toString());
        try {
            this.yWT = ac.aY(jSONObject);
            this.yXg = jSONObject.optString("processContent");
            this.yXj = LuckyMoneyEmojiSwitch.aX(jSONObject);
            Log.i("MicroMsg.NetSceneLuckyMoneyDetail", "luckyMoneyEmojiSwitch:%s", this.yXj.toString());
            this.yXh = jSONObject.optString("expression_md5");
            this.yXi = jSONObject.optInt("expression_type");
            Log.i("MicroMsg.NetSceneLuckyMoneyDetail", "expressionmd5:%s expressiontype:%s", this.yXh, Integer.valueOf(this.yXi));
            g.aAi();
            int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_HONGBAO_LOCAL_SWITCH_INT, (Object) 0)).intValue();
            int a2 = ((b) g.af(b.class)).a(b.a.clicfg_hongbao_emoji_all_switch, 0);
            if (Util.isEqual(intValue, 1) || Util.isEqual(a2, 1)) {
                if (this.yXj == null) {
                    this.yXj = new LuckyMoneyEmojiSwitch();
                }
                this.yXj.yVG = 1;
                this.yXj.yVH = 1;
                this.yXj.yVI = 1;
                this.yXj.yVJ = 1;
            }
            Log.i("MicroMsg.NetSceneLuckyMoneyDetail", "localSwitch() luckyMoneyEmojiSwitch:%s ", this.yXj.toString());
            AppMethodBeat.o(65287);
        } catch (JSONException e2) {
            Log.w("MicroMsg.NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + e2.getLocalizedMessage());
            AppMethodBeat.o(65287);
        }
    }
}
