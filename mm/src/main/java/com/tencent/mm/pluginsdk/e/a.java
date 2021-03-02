package com.tencent.mm.pluginsdk.e;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class a {
    public static Bundle bdk(String str) {
        String[] split;
        AppMethodBeat.i(30935);
        Bundle bundle = new Bundle();
        bundle.putInt("key_scene", 1);
        String[] split2 = str.split("&");
        if (split2 == null || split2.length == 0) {
            Log.e("MicroMsg.MallManager", "getWapPayBundle arrKeys == null || arrKeys.length == 0");
            AppMethodBeat.o(30935);
            return bundle;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : split2) {
            if (!TextUtils.isEmpty(str2) && (split = str2.split("=")) != null && split.length == 2) {
                hashMap.put(split[0], split[1]);
            }
        }
        bundle.putString("_wxapi_payreq_appid", e("appid", hashMap));
        bundle.putString("_wxapi_payreq_partnerid", e("partnerid", hashMap));
        bundle.putString("_wxapi_payreq_prepayid", e("prepayid", hashMap));
        bundle.putString("_wxapi_payreq_noncestr", e("noncestr", hashMap));
        bundle.putString("_wxapi_payreq_timestamp", e(AppMeasurement.Param.TIMESTAMP, hashMap));
        bundle.putString("_wxapi_payreq_packagevalue", e("package", hashMap));
        bundle.putString("_wxapi_payreq_sign", e("sign", hashMap));
        bundle.putString("_wxapi_payreq_sign_type", e("signtype", hashMap));
        bundle.putString("_wxapi_payreq_extdata", e("extdata", hashMap));
        bundle.putString("_wxapi_payoptions_callback_classname", "");
        bundle.putInt("_wxapi_payoptions_callback_flags", -1);
        AppMethodBeat.o(30935);
        return bundle;
    }

    private static String e(String str, HashMap<String, String> hashMap) {
        AppMethodBeat.i(30936);
        String str2 = hashMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            Log.e("MicroMsg.MallManager", "getWapPayKey key: " + str + " value is empty");
            AppMethodBeat.o(30936);
            return "";
        }
        AppMethodBeat.o(30936);
        return str2;
    }
}
