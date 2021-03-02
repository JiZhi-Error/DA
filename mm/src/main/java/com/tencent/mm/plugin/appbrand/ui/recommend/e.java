package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.report.service.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\f\u0010\b\u001a\u00020\t*\u00020\u0006H\u0002¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendFakeNativeReporter;", "", "()V", "reportAppCloseBeforeReadyIfNeed", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "reportAppReadyIfNeed", "shouldReport", "", "appId", "", "versionType", "", "plugin-appbrand-integration_release"})
public final class e {
    public static final e ofh = new e();

    static {
        AppMethodBeat.i(51358);
        AppMethodBeat.o(51358);
    }

    private e() {
    }

    public static final void P(q qVar) {
        AppMethodBeat.i(51354);
        p.h(qVar, "runtime");
        if (R(qVar)) {
            h.INSTANCE.dN(1089, 51);
        }
        AppMethodBeat.o(51354);
    }

    public static final void Q(q qVar) {
        AppMethodBeat.i(51355);
        p.h(qVar, "runtime");
        if (R(qVar)) {
            h.INSTANCE.dN(1089, 50);
        }
        AppMethodBeat.o(51355);
    }

    private static boolean R(q qVar) {
        AppMethodBeat.i(51356);
        boolean cs = cs(qVar.getAppId(), qVar.brf());
        AppMethodBeat.o(51356);
        return cs;
    }

    public static final boolean cs(String str, int i2) {
        AppMethodBeat.i(51357);
        if (!p.j("wxb6d22f922f37b35a", str) || !j.a.vP(i2)) {
            AppMethodBeat.o(51357);
            return false;
        }
        AppMethodBeat.o(51357);
        return true;
    }
}
