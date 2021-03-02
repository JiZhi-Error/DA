package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class m extends com.tencent.mm.wallet_core.tenpay.model.m {
    public m(String str, String str2, String str3, Profession profession, String str4) {
        AppMethodBeat.i(70158);
        Log.d("MicroMsg.NetSceneTenpaySetUserExInfo", "country: %s, province: %s, city: %s, nationality: %s", str, str2, str3, str4);
        HashMap hashMap = new HashMap();
        if (!Util.isNullOrNil(str)) {
            hashMap.put("user_country", str);
        }
        if (!Util.isNullOrNil(str2)) {
            hashMap.put("user_province", str2);
        }
        if (!Util.isNullOrNil(str3)) {
            hashMap.put("user_city", str3);
        }
        if (profession != null) {
            Log.d("MicroMsg.NetSceneTenpaySetUserExInfo", "name: %s, type: %s", profession.HTX, Integer.valueOf(profession.HTY));
            hashMap.put("profession_name", profession.HTX);
            hashMap.put("profession_type", String.valueOf(profession.HTY));
        }
        if (!Util.isNullOrNil(str4)) {
            hashMap.put("nationality", str4);
        }
        setRequestData(hashMap);
        AppMethodBeat.o(70158);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1978;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(70159);
        Log.i("MicroMsg.NetSceneTenpaySetUserExInfo", "errCode: %s, errMsg: %s", Integer.valueOf(i2), str);
        AppMethodBeat.o(70159);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/setuserexinfo";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1978;
    }
}
