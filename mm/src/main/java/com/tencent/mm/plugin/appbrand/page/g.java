package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.plugin.appbrand.widget.tabbar.AppBrandTabBarItem;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetPreLoader;", "", "()V", "TAG", "", "preloadedWidgetFactory", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC;", "obtainInstance", "type", "warmUpAndTryPreload", "", "plugin-appbrand-integration_release"})
public final class g {
    private static final ConcurrentHashMap<com.tencent.mm.plugin.appbrand.task.g, e> nnJ = new ConcurrentHashMap<>();
    public static final g nnK = new g();

    static {
        AppMethodBeat.i(229238);
        AppMethodBeat.o(229238);
    }

    private g() {
    }

    public static void a(com.tencent.mm.plugin.appbrand.task.g gVar) {
        AppMethodBeat.i(229236);
        p.h(gVar, "type");
        Log.i("MicroMsg.AppBrandDecorWidgetPreLoader", "warmUpAndTryPreload type=".concat(String.valueOf(gVar)));
        if (nnJ.get(gVar) == null) {
            e eVar = new e();
            eVar.aD(b.class);
            eVar.aD(d.class);
            switch (h.$EnumSwitchMapping$0[gVar.ordinal()]) {
                case 1:
                    eVar.aD(a.class);
                    eVar.aD(AppBrandUILoadingSplash.class);
                    for (int i2 = 0; i2 <= 4; i2++) {
                        eVar.aD(AppBrandTabBarItem.class);
                    }
                    break;
            }
            nnJ.put(gVar, eVar);
        }
        AppMethodBeat.o(229236);
    }

    public static e b(com.tencent.mm.plugin.appbrand.task.g gVar) {
        AppMethodBeat.i(229237);
        p.h(gVar, "type");
        e eVar = nnJ.get(gVar);
        if (eVar == null) {
            Log.i("MicroMsg.AppBrandDecorWidgetPreLoader", "obtainInstance: no preloaded, create it [%s]", gVar.name());
            eVar = new e();
        }
        AppMethodBeat.o(229237);
        return eVar;
    }
}
