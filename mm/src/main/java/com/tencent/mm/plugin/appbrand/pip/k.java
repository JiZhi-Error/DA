package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogicFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogicFactory;", "()V", "createPipStablePosLogic", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogic;", "appId", "", "pipContainerView", "Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;", "plugin-appbrand-integration_release"})
public final class k implements j {
    public static final k nDP = new k();

    static {
        AppMethodBeat.i(229263);
        AppMethodBeat.o(229263);
    }

    private k() {
    }

    @Override // com.tencent.mm.plugin.appbrand.pip.j
    public final i a(String str, AppBrandPipContainerView appBrandPipContainerView) {
        AppMethodBeat.i(229262);
        p.h(str, "appId");
        p.h(appBrandPipContainerView, "pipContainerView");
        l lVar = new l(str, appBrandPipContainerView);
        AppMethodBeat.o(229262);
        return lVar;
    }
}
