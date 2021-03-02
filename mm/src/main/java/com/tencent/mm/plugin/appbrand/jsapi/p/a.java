package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u00012\u00020\u0002:\u0001\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/AppBrandOnNavigateBackInterceptEvent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/NavigateBackInterceptionConstant;", "()V", "Companion", "luggage-wxa-app-jsapi_release"})
public final class a extends s {
    private static final int CTRL_INDEX = 881;
    private static final String NAME = "onNavigateBackIntercept";
    public static final C0694a mkm = new C0694a((byte) 0);

    static {
        AppMethodBeat.i(240918);
        AppMethodBeat.o(240918);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/AppBrandOnNavigateBackInterceptEvent$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "dispatch", "", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "type", "luggage-wxa-app-jsapi_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.p.a$a  reason: collision with other inner class name */
    public static final class C0694a {
        private C0694a() {
        }

        public /* synthetic */ C0694a(byte b2) {
            this();
        }

        public static void a(AppBrandRuntime appBrandRuntime, int i2) {
            ac pageView;
            AppMethodBeat.i(240917);
            p.h(appBrandRuntime, "rt");
            a aVar = new a((byte) 0);
            Log.i("AppBrandOnNavigateBackInterceptEvent", "[dispatch] type=".concat(String.valueOf(i2)));
            HashMap hashMap = new HashMap(1);
            hashMap.put("type", Integer.valueOf(i2));
            aVar.L(hashMap).g(appBrandRuntime.NY()).bEo();
            w brh = appBrandRuntime.brh();
            if (brh == null || (pageView = brh.getPageView()) == null) {
                AppMethodBeat.o(240917);
                return;
            }
            aVar.L(hashMap).g(pageView).bEo();
            AppMethodBeat.o(240917);
        }
    }

    private a() {
    }

    public /* synthetic */ a(byte b2) {
        this();
    }
}
