package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONArray;

/* access modifiers changed from: package-private */
public final class ad {
    static LinkedList<String> n(JSONArray jSONArray) {
        AppMethodBeat.i(123526);
        if (jSONArray == null) {
            AppMethodBeat.o(123526);
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            linkedList.add(jSONArray.optString(i2));
        }
        AppMethodBeat.o(123526);
        return linkedList;
    }
}
