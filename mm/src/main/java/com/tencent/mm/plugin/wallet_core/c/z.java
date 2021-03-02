package com.tencent.mm.plugin.wallet_core.c;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class z extends m {
    public z(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(69945);
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("appid", URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            hashMap.put(AppMeasurement.Param.TIMESTAMP, URLEncoder.encode(str2, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            hashMap.put("noncestr", URLEncoder.encode(str3, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            hashMap.put("package", URLEncoder.encode(str4, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            hashMap.put("sign", URLEncoder.encode(str5, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            setRequestData(hashMap);
            Log.d("MicroMsg.NetSceneTenpayF2fJsapiCheck", "package: %s, sign: %s", str4, str5);
            AppMethodBeat.o(69945);
        } catch (UnsupportedEncodingException e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneTenpayF2fJsapiCheck", e2, "", new Object[0]);
            AppMethodBeat.o(69945);
        }
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frcvdlistjsapicheck";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1973;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69946);
        Log.d("MicroMsg.NetSceneTenpayF2fJsapiCheck", "errCode: %d, errMsg: %s", Integer.valueOf(i2), str);
        AppMethodBeat.o(69946);
    }
}
