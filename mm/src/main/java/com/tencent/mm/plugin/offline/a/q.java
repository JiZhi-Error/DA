package com.tencent.mm.plugin.offline.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.Map;
import org.json.JSONObject;

public final class q extends m {
    public n AJW;
    public ad AJX;
    public e AJY;
    public e AJZ;

    public q(String str) {
        AppMethodBeat.i(213611);
        this.AJW = new n(new StringBuilder().append(System.currentTimeMillis()).toString(), 13);
        setRequestData(this.AJW.AJV);
        this.AJX = new ad(null, 8);
        this.AJX.HQr = true;
        Map<String, String> map = this.AJX.AJV;
        map.put("event_id", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        map.put("event_feature", str);
        addRequestData(map);
        setWXRequestData(this.AJX.HFF);
        Log.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "do offline user bind query");
        AppMethodBeat.o(213611);
    }

    public q(int i2, int i3, String str, int i4) {
        AppMethodBeat.i(213612);
        this.AJW = new n(new StringBuilder().append(System.currentTimeMillis()).toString(), i2);
        setRequestData(this.AJW.AJV);
        this.AJX = new ad(null, 8);
        this.AJX.HQr = true;
        Map<String, String> map = this.AJX.AJV;
        map.put("event_id", String.valueOf(i3));
        map.put("event_feature", str);
        map.put("is_first_show", String.valueOf(i4));
        addRequestData(map);
        setWXRequestData(this.AJX.HFF);
        Log.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "do offline user bind query");
        AppMethodBeat.o(213612);
    }

    public q(int i2, int i3, String str, String str2, String str3) {
        AppMethodBeat.i(213613);
        this.AJW = new n(new StringBuilder().append(System.currentTimeMillis()).toString(), i2);
        setRequestData(this.AJW.AJV);
        this.AJX = new ad(null, 8);
        this.AJX.HQr = true;
        Map<String, String> map = this.AJX.AJV;
        map.put("event_id", String.valueOf(i3));
        map.put("event_feature", str);
        map.put("package", str3);
        map.put("appId", str2);
        addRequestData(map);
        setWXRequestData(this.AJX.HFF);
        Log.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "do offline user bind query");
        AppMethodBeat.o(213613);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1742;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1742;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineuserbindquery";
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(66316);
        if (i2 != 0) {
            AppMethodBeat.o(66316);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("queryuser_resp");
        this.AJY = be(optJSONObject);
        this.AJW.onGYNetEnd(this.AJY.errCode, this.AJY.errMsg, optJSONObject);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bindquerynew_resp");
        this.AJZ = be(optJSONObject2);
        this.AJX.onGYNetEnd(this.AJZ.errCode, this.AJZ.errMsg, optJSONObject2);
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("card_list");
            if (optString != null) {
                a.aJl(optString);
            }
            Log.d("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "card_list: %s", optString);
        }
        AppMethodBeat.o(66316);
    }

    private static e be(JSONObject jSONObject) {
        int i2;
        AppMethodBeat.i(66317);
        e eVar = new e();
        eVar.errMsg = MMApplicationContext.getContext().getString(R.string.ibn);
        String string = MMApplicationContext.getContext().getString(R.string.ibn);
        try {
            i2 = jSONObject.getInt("retcode");
            string = jSONObject.optString("retmsg");
        } catch (Exception e2) {
            Log.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: json resolve error: error when resolving error code : " + e2.toString());
            i2 = -10089;
        }
        if (i2 != 0) {
            Log.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: resolve busi error: retCode is error");
            if (i2 != -10089) {
                eVar.f(1000, i2, string, 2);
            } else {
                eVar.f(1000, 2, string, 2);
            }
        } else {
            Log.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: all's OK");
        }
        AppMethodBeat.o(66317);
        return eVar;
    }
}
