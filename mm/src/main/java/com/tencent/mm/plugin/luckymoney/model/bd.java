package com.tencent.mm.plugin.luckymoney.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public class bd extends av {
    public boolean UXB;
    public int UXx;
    public int channelId;
    public String egX;
    public int egY;
    public int egZ;
    public int eha;
    public String ivQ;
    long msgId;
    public int msgType;
    String talker;
    public String yPK;
    public String yQE;
    public String yRQ;
    public int yUt;
    public String yVb;
    public String yVe;
    public int yVm;
    public bg yVs;
    public String yVt;
    public String yVy;
    public int yWX;
    public String yWY;
    public String yWZ;
    public int yXD;
    public String yXN;
    public long yXO;
    public long yXP;
    public int yXQ;
    public String yXR;
    public bi yXS;
    public String yXa;
    public String yXb;
    public String yXc;
    public long yXd;
    public String yXh;
    public int yXi;
    public int yXr;

    public bd(int i2, String str, String str2, int i3, String str3, String str4) {
        AppMethodBeat.i(213329);
        this.UXB = false;
        this.yWX = 1;
        this.yWY = null;
        this.yWZ = null;
        this.yXa = null;
        this.yXb = null;
        this.yXc = null;
        this.yXd = 0;
        this.yXr = 0;
        this.yXD = 0;
        this.yUt = 0;
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
        Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "NetSceneReceiveLuckyMoney request");
        setRequestData(hashMap);
        AppMethodBeat.o(213329);
    }

    public bd() {
        this.UXB = false;
        this.yWX = 1;
        this.yWY = null;
        this.yWZ = null;
        this.yXa = null;
        this.yXb = null;
        this.yXc = null;
        this.yXd = 0;
        this.yXr = 0;
        this.yXD = 0;
        this.yUt = 0;
    }

    @Override // com.tencent.mm.ak.q
    public int getType() {
        return 1581;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public String czD() {
        return "/cgi-bin/mmpay-bin/receivewxhb";
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah
    public void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(65310);
        Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "errCode: %s, errMsg: %s ，json：%s", Integer.valueOf(i2), str, jSONObject.toString());
        this.yXN = jSONObject.optString("sendNick");
        this.yVe = jSONObject.optString("sendHeadImg");
        this.egZ = jSONObject.optInt("hbStatus");
        this.eha = jSONObject.optInt("receiveStatus");
        this.yVb = jSONObject.optString("statusMess");
        this.yPK = jSONObject.optString("wishing");
        this.yVm = jSONObject.optInt("isSender");
        this.yXO = jSONObject.optLong("sceneAmount");
        this.yXP = jSONObject.optLong("sceneRecTimeStamp");
        this.egY = jSONObject.optInt("hbType");
        this.yVt = jSONObject.optString("watermark");
        this.yRQ = jSONObject.optString("externMess");
        this.yVy = jSONObject.optString("sendUserName");
        if (Util.isNullOrNil(this.yXN)) {
            this.UXB = true;
        }
        if (!Util.isNullOrNil(this.yVy) && Util.isNullOrNil(this.yXN)) {
            this.yXN = ((b) g.af(b.class)).getDisplayName(this.yVy);
        }
        this.yVs = ac.ba(jSONObject.optJSONObject("operationTail"));
        this.yXr = jSONObject.optInt("scenePicSwitch");
        JSONObject optJSONObject = jSONObject.optJSONObject("agree_duty");
        if (optJSONObject != null) {
            this.yWY = optJSONObject.optString("agreed_flag", "-1");
            this.yWZ = optJSONObject.optString("title", "");
            this.yXa = optJSONObject.optString("service_protocol_wording", "");
            this.yXb = optJSONObject.optString("service_protocol_url", "");
            this.yXc = optJSONObject.optString("button_wording", "");
            this.yXd = optJSONObject.optLong("delay_expired_time", 0);
        }
        if (this.yXd > 0) {
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_REALNAME_DISCLAIMER_QUERY_EXPIRED_TIME_LONG_SYNC, Long.valueOf(System.currentTimeMillis() + (this.yXd * 1000)));
        }
        Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "scenePicSwitch:" + this.yXr);
        this.yXQ = jSONObject.optInt("preStrainFlag", 1);
        Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "preStrainFlag:" + this.yXQ);
        this.yXD = jSONObject.optInt("showYearExpression");
        Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "showYearExpression:%s", Integer.valueOf(this.yXD));
        this.yUt = jSONObject.optInt("showRecNormalExpression");
        Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "showRecNormalExpression:%s", Integer.valueOf(this.yUt));
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_NEWYEAR_HONGBAO_IMAGE_PRESTRAIN_FLAG_INT_SYNC, Integer.valueOf(this.yXQ));
        this.yXR = jSONObject.optString("timingIdentifier");
        this.ivQ = jSONObject.optString("effectResource");
        this.yXh = jSONObject.optString("expression_md5");
        this.yXi = jSONObject.optInt("expression_type");
        this.UXx = jSONObject.optInt("not_show_avatar", 0);
        Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "expressionmd5:%s expressiontype:%s", this.yXh, Integer.valueOf(this.yXi));
        this.yXS = bi.bc(jSONObject.optJSONObject("showSourceRec"));
        efk();
        AppMethodBeat.o(65310);
    }

    public final void efk() {
        AppMethodBeat.i(213330);
        g.aAi();
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_HONGBAO_LOCAL_SWITCH_INT, (Object) 0)).intValue();
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_hongbao_emoji_all_switch, 0);
        if (Util.isEqual(intValue, 1) || Util.isEqual(a2, 1)) {
            this.yUt = 1;
            this.yXD = 1;
        }
        Log.i("MicroMsg.NetSceneReceiveLuckyMoney", "localSwitch() showRecNormalExpression:%s showYearExpression:%s", Integer.valueOf(this.yUt), Integer.valueOf(this.yXD));
        AppMethodBeat.o(213330);
    }
}
