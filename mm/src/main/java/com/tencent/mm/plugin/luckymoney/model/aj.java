package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class aj extends ai {
    public aj(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(65277);
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put("timeStamp", str2);
        hashMap.put("nonceStr", str3);
        if (str4 != null) {
            hashMap.put("package", URLEncoder.encode(str4));
        }
        hashMap.put("signType", str5);
        if (str6 != null) {
            hashMap.put("paySign", URLEncoder.encode(str6));
        }
        hashMap.put("way", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        if (str7 != null) {
            hashMap.put("jsapiH5Url", URLEncoder.encode(str7));
        }
        setRequestData(hashMap);
        AppMethodBeat.o(65277);
    }

    public aj(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        AppMethodBeat.i(65278);
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put("timeStamp", str2);
        hashMap.put("nonceStr", str3);
        if (str4 != null) {
            hashMap.put("package", URLEncoder.encode(str4));
        }
        hashMap.put("signType", str5);
        if (str6 != null) {
            hashMap.put("paySign", URLEncoder.encode(str6));
        }
        hashMap.put("way", "4");
        if (str7 != null) {
            hashMap.put("androidSign", URLEncoder.encode(str7));
        }
        if (str8 != null) {
            hashMap.put("androidPackage", URLEncoder.encode(str8));
        }
        setRequestData(hashMap);
        AppMethodBeat.o(65278);
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah
    public final int czE() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
    }
}
