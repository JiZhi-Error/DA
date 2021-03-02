package com.tencent.mm.plugin.appbrand.jsapi.ag.e.a;

import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\t\u001a\u00020\n*\u00020\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"CAST_BUTTON_CLICKED", "", "CAST_BUTTON_SHOW", "CAST_URL_CHANGE", "DEVICE_BUTTON_CLICKED", "EXIT_BUTTON_CLICKED", "HELP_BUTTON_CLICKED", "RECONNECT_BUTTON_CLICKED", "SWITCH_BUTTON_CLICKED", "getAppBrandRuntime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "luggage-xweb-ext_release"})
public final class d {
    public static final AppBrandRuntime A(a aVar) {
        AppMethodBeat.i(139683);
        p.h(aVar, "$this$getAppBrandRuntime");
        if (!(aVar instanceof b)) {
            IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.o(139683);
            throw illegalStateException;
        }
        f NN = ((b) aVar).NN();
        if (!(NN instanceof com.tencent.mm.plugin.appbrand.d)) {
            IllegalStateException illegalStateException2 = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.o(139683);
            throw illegalStateException2;
        }
        AppBrandRuntime runtime = ((com.tencent.mm.plugin.appbrand.d) NN).getRuntime();
        p.g(runtime, "component.runtime");
        AppMethodBeat.o(139683);
        return runtime;
    }
}
