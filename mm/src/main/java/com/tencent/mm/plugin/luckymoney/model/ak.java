package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class ak extends ai {
    public int egZ;
    public int eha;
    public long eht;
    public int qwe;
    public String yQE;
    public RealnameGuideHelper yRu;
    public String yVb;
    public i yVq;
    public String yWL;
    public String yWM;
    public int yWN;
    public String yWO;
    public int yWP;
    public String yWQ;
    public String yWR;
    public int yWS;
    public q yWT = null;

    public ak(String str, String str2, int i2, String str3, String str4) {
        AppMethodBeat.i(65279);
        this.yQE = str;
        HashMap hashMap = new HashMap();
        hashMap.put("sendId", str);
        if (!Util.isNullOrNil(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("way", String.valueOf(i2));
        hashMap.put("channelId", "2");
        hashMap.put("package", str3);
        hashMap.put("sessionUserName", str4);
        setRequestData(hashMap);
        AppMethodBeat.o(65279);
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah
    public final int czE() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        JSONObject optJSONObject;
        AppMethodBeat.i(65280);
        this.yWL = jSONObject.optString("spidName");
        this.egZ = jSONObject.optInt("hbStatus");
        this.eha = jSONObject.optInt("receiveStatus");
        this.yVb = jSONObject.optString("statusMess");
        this.yWM = jSONObject.optString("hintMess");
        this.eht = jSONObject.optLong("amount");
        this.yWN = jSONObject.optInt("recNum");
        this.qwe = jSONObject.optInt("totalNum");
        this.yVq = new i();
        JSONObject optJSONObject2 = jSONObject.optJSONObject("atomicFunc");
        if (optJSONObject2 != null) {
            this.yVq.gGn = optJSONObject2.optInt("enable");
            this.yVq.yUH = optJSONObject2.optString("fissionContent");
            this.yVq.yUG = optJSONObject2.optString("fissionUrl");
        }
        this.yWP = jSONObject.optInt("focusFlag");
        this.yWQ = jSONObject.optString("focusWording");
        this.yWR = jSONObject.optString("focusAppidUserName");
        this.yWS = jSONObject.optInt("isFocus");
        this.yWO = jSONObject.optString("smallHbButtonMess");
        try {
            this.yWT = ac.aY(jSONObject);
            this.yWT.yVe = jSONObject.optString("spidLogo");
            this.yWT.yVd = jSONObject.optString("spidName");
            this.yWT.yPK = jSONObject.optString("spidWishing");
        } catch (JSONException e2) {
            Log.w("MicroMsg.NetSceneLuckyMoneyBusiBase", "parse luckyMoneyDetail fail: " + e2.getLocalizedMessage());
        }
        if (i2 == 0 && jSONObject.has("real_name_info") && (optJSONObject = jSONObject.optJSONObject("real_name_info")) != null) {
            String optString = optJSONObject.optString("guide_flag");
            String optString2 = optJSONObject.optString("guide_wording");
            String optString3 = optJSONObject.optString("left_button_wording");
            String optString4 = optJSONObject.optString("right_button_wording");
            String optString5 = optJSONObject.optString("upload_credit_url");
            this.yRu = new RealnameGuideHelper();
            this.yRu.b(optString, optString2, optString3, optString4, optString5, 1005);
        }
        AppMethodBeat.o(65280);
    }
}
