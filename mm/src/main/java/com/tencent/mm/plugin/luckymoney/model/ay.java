package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.utils.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ay extends av {
    public String egX;
    long msgId;
    public String talker;
    public String yQE;
    public RealnameGuideHelper yRu;
    public q yWT;
    public String yXC;
    public int yXD;
    public b yXE;
    public String yXF;
    public String yXG;
    public String yXh;
    public int yXi;
    public LuckyMoneyEmojiSwitch yXj;

    public ay(int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(i2, i3, str, str2, str3, str4, str5, str6, str7, "");
        AppMethodBeat.i(65301);
        AppMethodBeat.o(65301);
    }

    public ay(int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        AppMethodBeat.i(213323);
        this.yWT = null;
        this.yXD = 0;
        this.yXF = "";
        this.yXG = "";
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
        hashMap.put("left_button_continue", str8);
        Log.i("MicroMsg.NetSceneOpenLuckyMoney", "NetSceneOpenLuckyMoney request");
        setRequestData(hashMap);
        AppMethodBeat.o(213323);
    }

    public ay() {
        this.yWT = null;
        this.yXD = 0;
        this.yXF = "";
        this.yXG = "";
    }

    @Override // com.tencent.mm.ak.q
    public int getType() {
        return 1685;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public String czD() {
        return "/cgi-bin/mmpay-bin/openwxhb";
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah
    public void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        String displayName;
        JSONObject optJSONObject;
        AppMethodBeat.i(65302);
        Log.i("MicroMsg.NetSceneOpenLuckyMoney", "errCode: %s, errMsg: %s ，json：%s", Integer.valueOf(i2), str, jSONObject.toString());
        try {
            this.yWT = ac.aY(jSONObject);
            this.yXj = LuckyMoneyEmojiSwitch.aX(jSONObject);
            Log.i("MicroMsg.NetSceneOpenLuckyMoney", "luckyMoneyEmojiSwitch:%s", this.yXj.toString());
            this.yXh = jSONObject.optString("expression_md5");
            this.yXi = jSONObject.optInt("expression_type");
            Log.i("MicroMsg.NetSceneOpenLuckyMoney", "expressionmd5:%s expressiontype:%s", this.yXh, Integer.valueOf(this.yXi));
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
            if (jSONObject.has("intercept_win_after")) {
                this.yXF = jSONObject.optJSONObject("intercept_win_after").toString();
            }
            if (jSONObject.has("left_button_continue")) {
                this.yXG = jSONObject.optString("left_button_continue");
            }
            this.yXC = jSONObject.optString("SystemMsgContext");
            this.yXD = jSONObject.optInt("showYearExpression");
            Log.i("MicroMsg.NetSceneOpenLuckyMoney", "showYearExpression:%s", Integer.valueOf(this.yXD));
            if (i2 == 0 && !Util.isNullOrNil(this.yXC) && !Util.isNullOrNil(this.yWT.yVy) && !ab.IN(this.talker)) {
                try {
                    if (z.aTY().equals(this.yWT.yVy)) {
                        displayName = MMApplicationContext.getContext().getString(R.string.esd);
                    } else {
                        displayName = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.yWT.yVy);
                    }
                    this.yXC = this.yXC.replace("$" + this.yWT.yVy + "$", displayName);
                    af.iB(this.yXC, this.talker);
                } catch (Exception e2) {
                    Log.e("MicroMsg.NetSceneOpenLuckyMoney", "insertLocalSysMsgIfNeed error: %s", e2.getMessage());
                }
            }
            efk();
            AppMethodBeat.o(65302);
        } catch (JSONException e3) {
            Log.w("MicroMsg.NetSceneOpenLuckyMoney", "parse luckyMoneyDetail fail: " + e3.getLocalizedMessage());
            AppMethodBeat.o(65302);
        }
    }

    public final void efk() {
        AppMethodBeat.i(213324);
        g.aAi();
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_HONGBAO_LOCAL_SWITCH_INT, (Object) 0)).intValue();
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_hongbao_emoji_all_switch, 0);
        if (Util.isEqual(intValue, 1) || Util.isEqual(a2, 1)) {
            if (this.yXj == null) {
                this.yXj = new LuckyMoneyEmojiSwitch();
            }
            this.yXj.yVG = 1;
            this.yXj.yVH = 1;
            this.yXj.yVI = 1;
            this.yXj.yVJ = 1;
            this.yXD = 1;
        }
        Log.i("MicroMsg.NetSceneOpenLuckyMoney", "localSwitch() luckyMoneyEmojiSwitch:%s ", this.yXj.toString());
        AppMethodBeat.o(213324);
    }
}
