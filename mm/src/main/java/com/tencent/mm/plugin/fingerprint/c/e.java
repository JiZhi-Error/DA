package com.tencent.mm.plugin.fingerprint.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends m implements com.tencent.mm.network.m {
    public String dNS = "";
    public String wFp = "";
    public String wGk = "";

    public e(String str) {
        AppMethodBeat.i(64472);
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_cert_info is empty");
        } else {
            Log.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_cert_info is not empty");
        }
        hashMap.put("encrypted_cert_info", URLEncoder.encode(str));
        hashMap.put("ver", "0x1.0");
        setRequestData(hashMap);
        AppMethodBeat.o(64472);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 118;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(64473);
        if (jSONObject != null) {
            this.wFp = jSONObject.optString("encrypted_device_info");
            this.dNS = jSONObject.optString("encrypted_rsa_sign");
            this.wGk = jSONObject.optString("cert");
            if (TextUtils.isEmpty(this.wFp)) {
                Log.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_device_info is empty");
            } else {
                Log.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_device_info is not empty");
            }
            if (TextUtils.isEmpty(this.dNS)) {
                Log.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_rsa_sign is empty");
            } else {
                Log.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_rsa_sign is not empty");
            }
            if (TextUtils.isEmpty(this.wGk)) {
                Log.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "cert is empty");
                AppMethodBeat.o(64473);
                return;
            }
            Log.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "cert is not empty");
        }
        AppMethodBeat.o(64473);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getopentouchcert";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1598;
    }
}
