package com.tencent.mm.plugin.luckymoney.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class al extends ai {
    public String egX;
    public int egY;
    public int egZ;
    public int eha;
    public String yQE;
    public String yVb;
    public bg yVs;
    public String yVt;
    public String yWL;
    public String yWM;
    public int yWP;
    public String yWQ;
    public String yWR;
    public int yWS;
    public int yWU;
    public String yWV;
    public String yWW;
    public int yWX = 1;
    public String yWY = null;
    public String yWZ = null;
    public String yXa = null;
    public String yXb = null;
    public String yXc = null;
    public long yXd = 0;

    public al(String str, String str2, int i2, String str3) {
        AppMethodBeat.i(65281);
        this.egX = str2;
        this.yQE = str;
        this.yWU = i2;
        HashMap hashMap = new HashMap();
        hashMap.put("sendId", str);
        if (!Util.isNullOrNil(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("way", String.valueOf(i2));
        hashMap.put("channelId", "2");
        hashMap.put("package", str3);
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
        setRequestData(hashMap);
        AppMethodBeat.o(65281);
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah
    public final int czE() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(65282);
        this.yWV = jSONObject.optString("spidLogo");
        this.yWW = jSONObject.optString("spidWishing");
        this.yWL = jSONObject.optString("spidName");
        this.yWV = jSONObject.optString("spidLogo");
        this.egZ = jSONObject.optInt("hbStatus");
        this.eha = jSONObject.optInt("receiveStatus");
        this.yVb = jSONObject.optString("statusMess");
        this.yWM = jSONObject.optString("hintMess");
        this.yVt = jSONObject.optString("watermark");
        this.yQE = jSONObject.optString("sendId");
        this.yWP = jSONObject.optInt("focusFlag");
        this.yWQ = jSONObject.optString("focusWording");
        this.yWR = jSONObject.optString("focusAppidUserName");
        this.yWS = jSONObject.optInt("isFocus");
        this.egY = jSONObject.optInt("hbType");
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
        this.yVs = ac.ba(jSONObject.optJSONObject("operationTail"));
        AppMethodBeat.o(65282);
    }
}
