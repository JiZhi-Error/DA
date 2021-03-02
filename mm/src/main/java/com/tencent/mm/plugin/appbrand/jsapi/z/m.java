package com.tencent.mm.plugin.appbrand.jsapi.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0014¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetSystemInfoWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetSystemInfoLU;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "fillExtraInfo", "", "component", "data", "", "", "", "Companion", "plugin-appbrand-integration_release"})
public final class m extends k<d> {
    public static final a mua = new a((byte) 0);

    static {
        AppMethodBeat.i(228576);
        AppMethodBeat.o(228576);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.z.k
    public final void a(d dVar, Map<String, Object> map) {
        AppBrandInitConfig OU;
        AppMethodBeat.i(228575);
        p.h(dVar, "component");
        p.h(map, "data");
        super.a(dVar, map);
        AppBrandRuntime runtime = dVar.getRuntime();
        if (runtime == null || (OU = runtime.OU()) == null) {
            Log.i("JsApiGetSystemInfoWC", "initConfig is null, return");
            AppMethodBeat.o(228575);
            return;
        }
        if ((OU instanceof AppBrandInitConfigWC) && ((AppBrandInitConfigWC) OU).kHL.isEnable()) {
            Log.i("JsApiGetSystemInfoWC", "half screen mode, force [screenTop] to 0");
            map.put("screenTop", 0);
        }
        AppMethodBeat.o(228575);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetSystemInfoWC$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
