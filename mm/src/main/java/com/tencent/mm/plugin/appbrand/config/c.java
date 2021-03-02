package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfigTrimHelper;", "", "()V", "TAG", "", "trimOffInjectConfigFields", "", "appId", "injectConfig", "Lorg/json/JSONObject;", "pruneWxConfigByPage", "", "luggage-wxa-app_release"})
public final class c {
    public static final c lcF = new c();

    static {
        AppMethodBeat.i(135557);
        AppMethodBeat.o(135557);
    }

    private c() {
    }

    public static final void a(String str, JSONObject jSONObject, boolean z) {
        JSONArray optJSONArray;
        AppMethodBeat.i(135556);
        p.h(str, "appId");
        p.h(jSONObject, "injectConfig");
        long nowMilliSecond = Util.nowMilliSecond();
        JSONObject optJSONObject = jSONObject.optJSONObject("tabBar");
        if (!(optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("list")) == null)) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                optJSONArray.getJSONObject(i2).remove("iconData");
                optJSONArray.getJSONObject(i2).remove("selectedIconData");
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("subPackages");
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                optJSONArray2.getJSONObject(i3).remove("pages");
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("subpackages");
        if (optJSONArray3 != null) {
            int length3 = optJSONArray3.length();
            for (int i4 = 0; i4 < length3; i4++) {
                optJSONArray3.getJSONObject(i4).remove("pages");
            }
        }
        if (z) {
            jSONObject.remove("page");
            jSONObject.remove("preloadRule");
        }
        jSONObject.remove("preloadResources");
        jSONObject.remove("preloadSubpackages");
        jSONObject.remove("manualSplashScreen");
        jSONObject.remove("useCommandBuffer");
        jSONObject.remove("permission");
        jSONObject.remove("navigateToMiniProgramAppIdList");
        Log.d("Luggage.WXA.AppBrandAppConfigTrimHelper", "trimOffInjectConfigFields appId[" + str + "] cost[" + (Util.nowMilliSecond() - nowMilliSecond) + "ms]");
        AppMethodBeat.o(135556);
    }
}
