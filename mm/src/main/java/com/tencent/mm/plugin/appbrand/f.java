package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.expt.b.b;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.apache.commons.b.g;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/AppBrandFakeNativeCheckXWebConfig;", "", "()V", "DEFAULT_CONFIG", "", "kotlin.jvm.PlatformType", "checkIfXWebRequired", "", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "plugin-appbrand-integration_release"})
public final class f {
    private static final String kzA = g.a((Object[]) new String[]{"wxfe02ecfe70800f46", "wx1d9b0b103d81d15d", "wx162102d2ff543cb2"}, ',', 3);
    public static final f kzB = new f();

    static {
        AppMethodBeat.i(175098);
        AppMethodBeat.o(175098);
    }

    private f() {
    }

    public static final boolean a(AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(175097);
        p.h(appBrandInitConfigWC, "config");
        String a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_android_appbrand_fakenative_check_xweb_required, kzA);
        p.g(a2, "MMKernel.service(IExptSe…required, DEFAULT_CONFIG)");
        ArrayList arrayList = new ArrayList();
        for (T t : n.a(a2, new String[]{","})) {
            if (!(t.length() == 0)) {
                arrayList.add(t);
            }
        }
        ArrayList<String> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(j.a(arrayList2, 10));
        for (String str : arrayList2) {
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
                AppMethodBeat.o(175097);
                throw tVar;
            }
            arrayList3.add(n.trim(str).toString());
        }
        boolean contains = arrayList3.contains(appBrandInitConfigWC.appId);
        AppMethodBeat.o(175097);
        return contains;
    }
}
