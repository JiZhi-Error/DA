package com.tencent.luggage.bridge;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.json.JSONObject;

final class c extends e {
    c(int i2, String str, JSONObject jSONObject, boolean z) {
        super(b.CALLBACK);
        AppMethodBeat.i(140315);
        HashMap hashMap = new HashMap();
        hashMap.put("callbackId", Integer.valueOf(i2));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("error", str);
        }
        if (jSONObject != null) {
            hashMap.put("data", jSONObject);
        }
        hashMap.put("keepCallback", Boolean.valueOf(z));
        l(hashMap);
        AppMethodBeat.o(140315);
    }
}
