package com.tencent.mm.plugin.appbrand.page.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p.a;
import com.tencent.mm.plugin.appbrand.q;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/navigation/AppBrandPageNavigateBackSilentInterceptorWC;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageNavigateBackSilentInterceptor;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "()V", "onIntercepted", "", "runtime", "scene", "", "plugin-appbrand-integration_release"})
public final class b extends d<q> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.AppBrandRuntime, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.page.b.d
    public final /* synthetic */ void m(q qVar, String str) {
        AppMethodBeat.i(229253);
        q qVar2 = qVar;
        p.h(qVar2, "runtime");
        p.h(str, "scene");
        super.m(qVar2, str);
        switch (str.hashCode()) {
            case -1128437284:
                if (str.equals("scene_actionbar_back")) {
                    a.C0694a aVar = a.mkm;
                    a.C0694a.a(qVar2, 3);
                    AppMethodBeat.o(229253);
                    return;
                }
                break;
            case 13653565:
                if (str.equals("scene_back_key_pressed")) {
                    a.C0694a aVar2 = a.mkm;
                    a.C0694a.a(qVar2, 2);
                    AppMethodBeat.o(229253);
                    return;
                }
                break;
            case 298295391:
                if (str.equals("scene_swipe_back")) {
                    a.C0694a aVar3 = a.mkm;
                    a.C0694a.a(qVar2, 1);
                    AppMethodBeat.o(229253);
                    return;
                }
                break;
            case 560038708:
                if (str.equals("scene_jsapi_navigate_back")) {
                    a.C0694a aVar4 = a.mkm;
                    a.C0694a.a(qVar2, 4);
                    break;
                }
                break;
        }
        AppMethodBeat.o(229253);
    }
}
