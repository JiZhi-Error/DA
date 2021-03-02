package com.tencent.mm.wallet_core.tenpay.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.d;
import com.tencent.mm.protocal.protobuf.exi;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.c;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public class o extends m implements j {
    public String IqM;
    public exi IqN = new exi();
    public String RuX;
    public String appId;
    public int channel;
    public String dDL;
    public String productId;
    public String qwG;
    public int scene;

    public o(String str, int i2, int i3, int i4, int i5, String str2) {
        AppMethodBeat.i(72894);
        this.scene = i2;
        this.channel = i4;
        HashMap hashMap = new HashMap();
        hashMap.put("url", URLEncoder.encode(str));
        hashMap.put("scene", String.valueOf(i3));
        hashMap.put("a8key_scene", String.valueOf(i2));
        hashMap.put("channel", String.valueOf(i4));
        Log.d("MicroMsg.NetSceneTenpayNativeAuthen", "sourceType: %d, source: %s", Integer.valueOf(i5), str2);
        if (i5 < 0) {
            Log.e("MicroMsg.NetSceneTenpayNativeAuthen", "illegal sourceType: %d, source: %s", Integer.valueOf(i5), str2);
            hashMap.put("source_type", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            hashMap.put("source", "");
        } else {
            hashMap.put("source_type", String.valueOf(i5));
            hashMap.put("source", str2);
        }
        setRequestData(hashMap);
        c Fu = d.aXu().Fu("100456");
        if (!Fu.isValid()) {
            Log.w("MicroMsg.NetSceneTenpayNativeAuthen", "invalid abtest value");
            AppMethodBeat.o(72894);
        } else if (Util.getInt(Fu.gzz().get(WeChatBrands.Business.GROUP_OPEN), 0) == 0) {
            Log.i("MicroMsg.NetSceneTenpayNativeAuthen", "abtest unopened");
            AppMethodBeat.o(72894);
        } else {
            try {
                String query = new URI(str).getQuery();
                if (!Util.isNullOrNil(query)) {
                    String[] split = query.split("&");
                    int length = split.length;
                    for (int i6 = 0; i6 < length; i6++) {
                        if (split[i6].contains("groupid")) {
                            String[] split2 = split[i6].split("=");
                            if (split2.length == 2) {
                                int i7 = Util.getInt(split2[1], 0);
                                Log.d("MicroMsg.NetSceneTenpayNativeAuthen", "groupid: %s", Integer.valueOf(i7));
                                getCommReqResp().getReqObj().setRouteInfo(i7);
                            }
                        }
                    }
                }
                AppMethodBeat.o(72894);
            } catch (URISyntaxException e2) {
                Log.printErrStackTrace("MicroMsg.NetSceneTenpayNativeAuthen", e2, "", new Object[0]);
                AppMethodBeat.o(72894);
            }
        }
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public int getTenpayCgicmd() {
        return TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72895);
        Log.i("MicroMsg.NetSceneTenpayNativeAuthen", "errCode: %d, errMsg: %s", Integer.valueOf(i2), str);
        Log.d("MicroMsg.NetSceneTenpayNativeAuthen", "json: %s", jSONObject.toString());
        this.dDL = jSONObject.optString("reqkey");
        this.appId = jSONObject.optString("appid");
        this.IqM = jSONObject.optString("appsource");
        this.productId = jSONObject.optString("productid");
        this.RuX = jSONObject.optString("retcode");
        this.qwG = jSONObject.optString("retmsg");
        JSONObject optJSONObject = jSONObject.optJSONObject("wallet_mix_sp_genprepay_resp");
        if (optJSONObject != null) {
            this.IqN.NuI = optJSONObject.optString("pay_gate_url");
            this.IqN.NuK = optJSONObject.optBoolean("need_dialog");
            this.IqN.NuL = optJSONObject.optString("dialog_text");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("callback_retry_conf");
            if (optJSONObject2 != null) {
                this.IqN.NuJ = new th();
                this.IqN.NuJ.LbS = optJSONObject2.optInt("inteval_time");
                this.IqN.NuJ.LbT = optJSONObject2.optInt("max_count");
                this.IqN.NuJ.LbU = optJSONObject2.optString("default_wording");
            }
            Log.d("MicroMsg.NetSceneTenpayNativeAuthen", "pay_gate_url: %s, dialog_text: %s", this.IqN.NuI, this.IqN.NuL);
        }
        AppMethodBeat.o(72895);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/payauthnative";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public int getFuncId() {
        return 1694;
    }
}
