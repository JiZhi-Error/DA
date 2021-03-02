package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.c;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenAddressWithLightMode;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenAddress;", "()V", "onSetupIntent", "", "intent", "Landroid/content/Intent;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "data", "Lorg/json/JSONObject;", "Companion", "plugin-appbrand-integration_release"})
public final class bu extends bt {
    public static final int CTRL_INDEX = 905;
    public static final String NAME = "openAddressWithLightMode";
    public static final a lAV = new a((byte) 0);

    static {
        AppMethodBeat.i(228297);
        AppMethodBeat.o(228297);
    }

    public bu() {
        AppMethodBeat.i(228296);
        c.aem(NAME);
        AppMethodBeat.o(228296);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.bt
    public final void a(Intent intent, k kVar, JSONObject jSONObject) {
        boolean z = false;
        AppMethodBeat.i(228295);
        p.h(intent, "intent");
        super.a(intent, kVar, jSONObject);
        if (jSONObject != null) {
            z = jSONObject.optBoolean("forceLightMode", false);
        }
        intent.putExtra("force_light_mode", z);
        AppMethodBeat.o(228295);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenAddressWithLightMode$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
