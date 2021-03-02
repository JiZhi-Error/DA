package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class ab extends m {
    public String HQm;

    public ab(String str, int i2, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(69947);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("check_pwd_scene", String.valueOf(i2));
        hashMap.put("package", URLEncoder.encode(str2));
        hashMap.put("sign", str3);
        hashMap.put("sign_type", str4);
        hashMap.put("busi_id", str5);
        setRequestData(hashMap);
        AppMethodBeat.o(69947);
    }

    public ab(String str, int i2, String str2, String str3, String str4, String str5, int i3, String str6, String str7) {
        AppMethodBeat.i(69948);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("check_pwd_scene", String.valueOf(i2));
        hashMap.put("package", URLEncoder.encode(str2));
        hashMap.put("sign", str3);
        hashMap.put("sign_type", str4);
        hashMap.put("busi_id", str5);
        hashMap.put("use_touch", String.valueOf(i3));
        setRequestData(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("soter_req", str6);
        hashMap2.put("fingerData", str7);
        setWXRequestData(hashMap2);
        AppMethodBeat.o(69948);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 2704;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 2704;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/getpaypwdtoken";
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69949);
        this.HQm = jSONObject.optString("usertoken", "");
        AppMethodBeat.o(69949);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final boolean callbackUIWhenWalletError() {
        return true;
    }
}
