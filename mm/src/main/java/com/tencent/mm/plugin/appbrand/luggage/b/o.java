package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import com.tencent.luggage.f.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.ao;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class o extends b {
    public static Integer nan;

    private static int getMapType() {
        AppMethodBeat.i(47493);
        if (nan != null) {
            int intValue = nan.intValue();
            AppMethodBeat.o(47493);
            return intValue;
        }
        a aVar = a.C0356a.hnM;
        c Fu = a.Fu("100487");
        if (Fu == null || !Fu.isValid()) {
            Log.i("MicroMsg.WxaMapViewFactory", "[sMapType] item is null");
            AppMethodBeat.o(47493);
            return 1;
        }
        nan = Integer.valueOf(Util.getInt(Fu.gzz().get("MapType"), 1));
        Log.i("MicroMsg.WxaMapViewFactory", "sMapType:%d", nan);
        int intValue2 = nan.intValue();
        AppMethodBeat.o(47493);
        return intValue2;
    }

    @Override // com.tencent.luggage.f.a.b, com.tencent.mm.plugin.appbrand.jsapi.k.a.c
    public final com.tencent.mm.plugin.appbrand.jsapi.k.a.b b(f fVar, JSONObject jSONObject) {
        AppMethodBeat.i(47494);
        if (jSONObject != null) {
            try {
                jSONObject.put("mapType", getMapType());
                boolean optBoolean = jSONObject.optBoolean("enableDarkMode", false);
                if (!ao.isDarkMode()) {
                    optBoolean = false;
                }
                jSONObject.put("enableDarkMode", optBoolean ? 1 : 0);
            } catch (JSONException e2) {
                Log.printInfoStack("MicroMsg.WxaMapViewFactory", "", e2);
            }
        }
        com.tencent.mm.plugin.appbrand.jsapi.k.a.b b2 = super.b(fVar, jSONObject);
        AppMethodBeat.o(47494);
        return b2;
    }

    @Override // com.tencent.luggage.f.a.b, com.tencent.mm.plugin.appbrand.jsapi.k.a.c
    public final com.tencent.mm.plugin.appbrand.jsapi.k.a.b a(Context context, String str, Map<String, Object> map) {
        int i2 = 0;
        AppMethodBeat.i(47495);
        if (context == null) {
            AppMethodBeat.o(47495);
            return null;
        }
        int a2 = com.tencent.mm.plugin.appbrand.jsapi.k.a.f.a(map, "mapType", getMapType());
        int a3 = com.tencent.mm.plugin.appbrand.jsapi.k.a.f.a(map, "enableDarkMode", 0);
        if (ao.isDarkMode()) {
            i2 = a3;
        }
        map.put("enableDarkMode", Integer.valueOf(i2));
        if (a2 == 2) {
            com.tencent.mm.plugin.appbrand.jsapi.ag.d.b bVar = new com.tencent.mm.plugin.appbrand.jsapi.ag.d.b(context, str, map);
            AppMethodBeat.o(47495);
            return bVar;
        }
        com.tencent.mm.plugin.appbrand.jsapi.k.a.b a4 = super.a(context, str, map);
        AppMethodBeat.o(47495);
        return a4;
    }
}
