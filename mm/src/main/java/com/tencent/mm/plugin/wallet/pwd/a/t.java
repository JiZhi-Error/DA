package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class t extends m {
    public int HIA;
    public int HIB = -1;
    public int HIC = -1;
    public String HIz;
    public String dYK = "";
    public String ega;
    public String packageName = "";
    public int scene = -1;

    public t(String str, int i2, String str2) {
        AppMethodBeat.i(69576);
        this.HIz = str;
        this.HIA = i2;
        this.ega = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("cre_id", q.encode(str));
        hashMap.put("cre_type", q.encode(String.valueOf(i2)));
        hashMap.put("true_name", q.encode(str2));
        hashMap.put("verifyScene", "1");
        setRequestData(hashMap);
        AppMethodBeat.o(69576);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/verifyuserrealnameinfo";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 2784;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 2784;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69577);
        Log.i("MicroMsg.NetSceneVerifyUserRealNameInfo", "onGYNetEnd, errCode: %s, errMsg: %s, json: %s", Integer.valueOf(i2), str, jSONObject);
        if (i2 == 0) {
            jSONObject.optString("retcode");
            jSONObject.optString("retmsg");
            this.HIB = jSONObject.optInt("is_support_face", 0);
            this.scene = jSONObject.optInt("scene", 0);
            this.packageName = jSONObject.optString("package");
            this.HIC = jSONObject.optInt("is_need_cert");
            this.dYK = jSONObject.optString("packagesign");
        }
        AppMethodBeat.o(69577);
    }
}
