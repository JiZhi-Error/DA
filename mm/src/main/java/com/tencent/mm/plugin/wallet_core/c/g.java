package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends m {
    public g() {
        AppMethodBeat.i(69900);
        t.fQM().db.execSQL("WalletBulletin", "delete from WalletBulletin");
        setRequestData(new HashMap());
        AppMethodBeat.o(69900);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1679;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getbannerinfo";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1679;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69901);
        Log.i("MicroMsg.NetSceneGetBannerInfo", "NetSceneGetBannerInfo errCode = " + i2 + " " + jSONObject);
        if (i2 == 0) {
            y.bN(jSONObject);
            long optLong = jSONObject.optLong("banner_update_interval", 0);
            Log.i("MicroMsg.NetSceneGetBannerInfo", "update_interval=".concat(String.valueOf(optLong)));
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_BULLETIN_UPDATE_INTERVAL_LONG, Long.valueOf(optLong));
            JSONObject optJSONObject = jSONObject.optJSONObject("lbs_info");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("config_array");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    k fQt = k.fQt();
                    if (optJSONArray != null) {
                        Log.d("MicroMsg.GpsReportHelper", optJSONArray.toString());
                        fQt.HXV = optJSONArray;
                        com.tencent.mm.kernel.g.aAi();
                        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_LBS_REPORT_CONFIG_STRING_SYNC, optJSONArray.toString());
                    }
                }
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_LBS_REPORT_DIALOG_TITLE_STRING_SYNC, optJSONObject.optString("title"));
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_LBS_REPORT_DIALOG_CONTENT_STRING_SYNC, optJSONObject.optString("content"));
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("realname_info");
            if (optJSONObject2 != null) {
                String optString = optJSONObject2.optString("title");
                String optString2 = optJSONObject2.optString("balance_title");
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_RELEAY_NAME_TIP_CONTENT_STRING_SYNC, optString);
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_RELEAY_NAME_BALANCE_CONTENT_STRING_SYNC, optString2);
            }
        }
        AppMethodBeat.o(69901);
    }
}
