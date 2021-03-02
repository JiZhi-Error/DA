package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l extends m {
    public int HQh;
    public int HQi;
    public String[] HSA = null;
    public Profession[] HTV = null;
    public int HTW;

    public l() {
        AppMethodBeat.i(70156);
        HashMap hashMap = new HashMap();
        if (!Util.isNullOrNil((String) null)) {
            hashMap.put("scene", null);
        }
        setRequestData(hashMap);
        AppMethodBeat.o(70156);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1976;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1976;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getuserexinfo";
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(70157);
        Log.i("MicroMsg.NetSceneTenpayGetUserExInfo", "errCode: %s, errMsg: %s", Integer.valueOf(i2), str);
        Log.d("MicroMsg.NetSceneTenpayGetUserExInfo", "json: %s", jSONObject.toString());
        this.HQh = jSONObject.optInt("need_area");
        this.HQi = jSONObject.optInt("need_profession");
        JSONArray optJSONArray = jSONObject.optJSONArray("array");
        if (optJSONArray != null) {
            this.HTV = new Profession[optJSONArray.length()];
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("profession_name");
                    int optInt = optJSONObject.optInt("profession_type");
                    if (!Util.isNullOrNil(optString)) {
                        this.HTV[i3] = new Profession(optString, optInt);
                    } else {
                        Log.i("MicroMsg.NetSceneTenpayGetUserExInfo", "empty profession_name!");
                    }
                }
            }
        }
        this.HTW = jSONObject.optInt("need_nationality");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("nationality_exclude_array");
        if (optJSONArray2 != null) {
            this.HSA = new String[optJSONArray2.length()];
            for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                this.HSA[i4] = optJSONArray2.optString(i4);
            }
        }
        AppMethodBeat.o(70157);
    }
}
