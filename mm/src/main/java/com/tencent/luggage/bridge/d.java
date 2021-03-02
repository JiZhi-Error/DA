package com.tencent.luggage.bridge;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends e {
    public d(String str, JSONObject jSONObject) {
        super(b.EVENT);
        AppMethodBeat.i(140316);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("event name can not be null or empty");
            AppMethodBeat.o(140316);
            throw illegalArgumentException;
        }
        jSONObject = jSONObject == null ? new JSONObject() : jSONObject;
        HashMap hashMap = new HashMap();
        hashMap.put("event", str);
        hashMap.put("data", jSONObject);
        b(new JSONObject(hashMap));
        AppMethodBeat.o(140316);
    }
}
