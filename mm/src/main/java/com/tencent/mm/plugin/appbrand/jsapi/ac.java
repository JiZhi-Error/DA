package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandVideoAutogirationParseHelper;", "", "()V", "IS_AUTOGIRATION_DEFAULT", "", "IS_AUTOGIRATION_KEY", "", "isAutogiration", "dataJsonObj", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Ljava/lang/Boolean;", "luggage-wxa-app_release"})
public final class ac {
    public static final ac lyb = new ac();

    static {
        AppMethodBeat.i(135570);
        AppMethodBeat.o(135570);
    }

    private ac() {
    }

    public static final Boolean K(JSONObject jSONObject) {
        AppMethodBeat.i(178663);
        p.h(jSONObject, "dataJsonObj");
        if (jSONObject.has("autoRotation")) {
            Boolean valueOf = Boolean.valueOf(jSONObject.optBoolean("autoRotation", false));
            AppMethodBeat.o(178663);
            return valueOf;
        }
        AppMethodBeat.o(178663);
        return null;
    }
}
