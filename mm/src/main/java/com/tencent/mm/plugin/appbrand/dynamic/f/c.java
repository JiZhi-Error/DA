package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends com.tencent.mm.aa.b.c {
    public String data;

    public c() {
        super("onDataPush");
    }

    c(int i2) {
        super("onDataPush", i2);
    }

    @Override // com.tencent.mm.aa.b.c
    public final JSONObject toJSONObject() {
        AppMethodBeat.i(121393);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", Util.nullAsNil(this.data));
        } catch (JSONException e2) {
        }
        AppMethodBeat.o(121393);
        return jSONObject;
    }
}
