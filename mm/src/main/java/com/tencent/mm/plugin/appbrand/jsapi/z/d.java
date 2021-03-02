package com.tencent.mm.plugin.appbrand.jsapi.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.a.a;
import com.tencent.mm.plugin.appbrand.utils.a.c;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends ab {
    public static final int CTRL_INDEX = 425;
    public static final String NAME = "getBatteryInfo";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final String a(f fVar, JSONObject jSONObject) {
        AppMethodBeat.i(137659);
        c bZx = a.INST.bZx();
        HashMap hashMap = new HashMap();
        hashMap.put("level", Integer.valueOf(bZx.ohW));
        hashMap.put("isCharging", Boolean.valueOf(bZx.ohV));
        String n = n("ok", hashMap);
        AppMethodBeat.o(137659);
        return n;
    }
}
