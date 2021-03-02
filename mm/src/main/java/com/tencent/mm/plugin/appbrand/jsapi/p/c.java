package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.page.ac;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends ab<ac> {
    public static int CTRL_INDEX = 71;
    public static String NAME = "getCurrentRoute";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* synthetic */ String a(ac acVar, JSONObject jSONObject) {
        AppMethodBeat.i(138216);
        HashMap hashMap = new HashMap();
        hashMap.put(TencentExtraKeys.LOCATION_KEY_ROUTE, acVar.lBI);
        String n = n("ok", hashMap);
        AppMethodBeat.o(138216);
        return n;
    }
}
