package com.tencent.mm.plugin.appbrand.jsapi.ui.launcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/JSAPIsForAppBrandLauncherUI;", "", "()V", "collectAPIs", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "plugin-appbrand-integration_release"})
public final class d {
    public static final d mvo = new d();

    static {
        AppMethodBeat.i(50723);
        AppMethodBeat.o(50723);
    }

    private d() {
    }

    public static final List<p> bIV() {
        AppMethodBeat.i(50722);
        List<p> listOf = j.listOf((Object[]) new com.tencent.mm.plugin.appbrand.jsapi.d[]{new API_openWeAppSearch(), new a(), new c(), new b()});
        AppMethodBeat.o(50722);
        return listOf;
    }
}
