package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class ac extends m {
    public String HQn = "";
    public JSONObject lxS;

    public ac(String str, String str2, String str3, String str4, long j2, long j3, String str5, String str6, int i2, int i3) {
        AppMethodBeat.i(69950);
        this.HQn = str;
        HashMap hashMap = new HashMap();
        hashMap.put("activity_id", str);
        hashMap.put("award_id", str2);
        hashMap.put("send_record_id", str3);
        hashMap.put("user_record_id", str4);
        hashMap.put("activity_mch_id", String.valueOf(j2));
        hashMap.put("activity_type", String.valueOf(j3));
        hashMap.put("bank_type", String.valueOf(str5));
        hashMap.put("bank_serial", String.valueOf(str6));
        hashMap.put("bindbankscene", String.valueOf(i2));
        hashMap.put("realname_scene", String.valueOf(i3));
        setRequestData(hashMap);
        AppMethodBeat.o(69950);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1773;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/querybindcardaward";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1773;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69951);
        Log.i("MicroMsg.NetSceneTenpayQueryBindPayaward", "errcode %s errmsg %s json %s", Integer.valueOf(i2), str, jSONObject);
        this.lxS = jSONObject;
        AppMethodBeat.o(69951);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final boolean isBlock() {
        return false;
    }
}
