package com.tencent.mm.plugin.fingerprint.c;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.fingerprint.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class f extends m implements com.tencent.mm.network.m {
    public f(String str, String str2, String str3, int i2) {
        AppMethodBeat.i(64474);
        HashMap hashMap = new HashMap();
        hashMap.put("encrypted_open_info", URLEncoder.encode(str));
        hashMap.put("encrypted_rsa_sign", URLEncoder.encode(str2));
        hashMap.put("passwd", str3);
        setRequestData(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("device_type", Build.MODEL);
        hashMap2.put("open_scene", String.valueOf(i2));
        setWXRequestData(hashMap2);
        AppMethodBeat.o(64474);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 119;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
    }

    @Override // com.tencent.mm.wallet_core.c.w, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(64475);
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        if (i3 == 0 && i4 == 0) {
            Log.i("MicroMsg.NetSceneTenpayOpenTouch", "open fingerprintpay success");
            d.pl(true);
            AppMethodBeat.o(64475);
            return;
        }
        Log.e("MicroMsg.NetSceneTenpayOpenTouch", "open fingerprintpay failed");
        AppMethodBeat.o(64475);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1599;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/androidopentouch";
    }
}
