package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/WxaComponentAdapter;", "", "()V", "asPage", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "asService", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "luggage-wxa-app_release"})
public final class df {
    public static final df lCR = new df();

    static {
        AppMethodBeat.i(135576);
        AppMethodBeat.o(135576);
    }

    private df() {
    }

    public static final ac i(f fVar) {
        AppMethodBeat.i(135574);
        if (fVar == null) {
            AppMethodBeat.o(135574);
            return null;
        } else if (fVar instanceof ac) {
            ac acVar = (ac) fVar;
            AppMethodBeat.o(135574);
            return acVar;
        } else if (fVar instanceof s) {
            ac currentPageView = ((s) fVar).getCurrentPageView();
            AppMethodBeat.o(135574);
            return currentPageView;
        } else {
            AppMethodBeat.o(135574);
            return null;
        }
    }

    public static final s j(f fVar) {
        AppMethodBeat.i(135575);
        if (fVar == null) {
            AppMethodBeat.o(135575);
            return null;
        } else if (fVar instanceof ac) {
            s NY = ((ac) fVar).NY();
            AppMethodBeat.o(135575);
            return NY;
        } else if (fVar instanceof s) {
            s sVar = (s) fVar;
            AppMethodBeat.o(135575);
            return sVar;
        } else {
            AppMethodBeat.o(135575);
            return null;
        }
    }
}
