package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/utils/OpenUrlHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IOpenUrlHelper;", "()V", "openUrl", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "url", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class ab implements b {
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.b
    public final void a(f fVar, String str, Context context) {
        AppMethodBeat.i(51403);
        p.h(fVar, "component");
        p.h(str, "url");
        p.h(context, "context");
        ag agVar = (ag) fVar.M(ag.class);
        if (agVar != null) {
            agVar.a(context, str, null);
            AppMethodBeat.o(51403);
            return;
        }
        AppMethodBeat.o(51403);
    }
}
