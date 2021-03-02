package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.res.Resources;
import android.text.StaticLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.ac.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.HashMap;
import org.json.JSONObject;

public final class j extends ab<f> {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "measureTextString";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final String a(f fVar, JSONObject jSONObject) {
        AppMethodBeat.i(193674);
        JSONObject optJSONObject = jSONObject.optJSONObject("size");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("label");
        if (optJSONObject == null || optJSONObject2 == null) {
            String h2 = h("fail:invalid data", null);
            AppMethodBeat.o(193674);
            return h2;
        }
        int optInt = optJSONObject.optInt("width", Integer.MAX_VALUE);
        int optInt2 = optJSONObject.optInt("height", Integer.MAX_VALUE);
        a aVar = new a(fVar.getContext() == null ? Resources.getSystem() : fVar.getContext().getResources(), optInt);
        c.a(aVar, optJSONObject2);
        StaticLayout staticLayout = aVar.lSP.aBl().huH;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < staticLayout.getLineCount(); i2++) {
            f2 = Math.max(f2, staticLayout.getLineWidth(i2));
        }
        final HashMap hashMap = new HashMap(2);
        hashMap.put("width", Float.valueOf(g.aS(f2)));
        hashMap.put("height", Float.valueOf(g.aS((float) Math.min(staticLayout.getHeight(), optInt2))));
        String n = n("ok", new HashMap<String, Object>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.j.AnonymousClass1 */

            {
                AppMethodBeat.i(193673);
                put("size", hashMap);
                AppMethodBeat.o(193673);
            }
        });
        AppMethodBeat.o(193674);
        return n;
    }
}
