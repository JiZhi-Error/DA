package com.tencent.mm.plugin.luckymoney.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class be extends bd {
    public be(int i2, String str, String str2, int i3, String str3) {
        AppMethodBeat.i(213331);
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
        hashMap.put("union_source", AppEventsConstants.EVENT_PARAM_VALUE_NO);
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
        Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "NetSceneReceiveLuckyMoneyUnion request");
        setRequestData(hashMap);
        AppMethodBeat.o(213331);
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.bd, com.tencent.mm.ak.q
    public final int getType() {
        return 4536;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.bd, com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public final String czD() {
        return "/cgi-bin/mmpay-bin/unionhb/receiveunionhb";
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.bd, com.tencent.mm.plugin.luckymoney.model.ah
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(213332);
        Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "errCode: %s, errMsg: %s ，json：%s", Integer.valueOf(i2), str, jSONObject.toString());
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
        Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "scenePicSwitch:" + this.yXr);
        this.yXQ = jSONObject.optInt("preStrainFlag", 1);
        Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "preStrainFlag:" + this.yXQ);
        this.yXD = jSONObject.optInt("showYearExpression");
        Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "showYearExpression:%s", Integer.valueOf(this.yXD));
        this.yUt = jSONObject.optInt("showRecNormalExpression");
        Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "showRecNormalExpression:%s", Integer.valueOf(this.yUt));
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_NEWYEAR_HONGBAO_IMAGE_PRESTRAIN_FLAG_INT_SYNC, Integer.valueOf(this.yXQ));
        this.yXR = jSONObject.optString("timingIdentifier");
        this.ivQ = jSONObject.optString("effectResource");
        this.yXh = jSONObject.optString("expression_md5");
        this.yXi = jSONObject.optInt("expression_type");
        Log.i("MicroMsg.NetSceneReceiveLuckyMoneyUnion", "expressionmd5:%s expressiontype:%s", this.yXh, Integer.valueOf(this.yXi));
        this.yXS = bi.bc(jSONObject.optJSONObject("showSourceRec"));
        efk();
        AppMethodBeat.o(213332);
    }
}
