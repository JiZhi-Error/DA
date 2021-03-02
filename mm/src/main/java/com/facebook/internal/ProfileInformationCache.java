package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class ProfileInformationCache {
    private static final ConcurrentHashMap<String, JSONObject> infoCache = new ConcurrentHashMap<>();

    ProfileInformationCache() {
    }

    static {
        AppMethodBeat.i(17911);
        AppMethodBeat.o(17911);
    }

    public static JSONObject getProfileInformation(String str) {
        AppMethodBeat.i(17909);
        JSONObject jSONObject = infoCache.get(str);
        AppMethodBeat.o(17909);
        return jSONObject;
    }

    public static void putProfileInformation(String str, JSONObject jSONObject) {
        AppMethodBeat.i(17910);
        infoCache.put(str, jSONObject);
        AppMethodBeat.o(17910);
    }
}
