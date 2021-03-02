package com.tencent.mm.plugin.appbrand.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.handoff.model.HandOffMG;
import com.tencent.mm.plugin.handoff.model.HandOffMP;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wcdb.FileUtils;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/handoff/HandOffUtils;", "", "()V", "obtainHandOffModel", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "handOffType", "", "plugin-appbrand-integration_release"})
public final class a {
    public static final a lvB = new a();

    static {
        AppMethodBeat.i(175133);
        AppMethodBeat.o(175133);
    }

    private a() {
    }

    public static final HandOffMP y(q qVar) {
        AppMethodBeat.i(175132);
        p.h(qVar, "$this$obtainHandOffModel");
        AppBrandInitConfigWC bsC = qVar.bsC();
        String nullAsNil = Util.nullAsNil(bsC.iconUrl);
        String nullAsNil2 = Util.nullAsNil(bsC.brandName);
        String nullAsNil3 = Util.nullAsNil(bsC.appId);
        String nullAsNil4 = Util.nullAsNil(bsC.username);
        String nullAsNil5 = Util.nullAsNil(bsC.kHw);
        p.g(bsC, "config");
        if (bsC.NA()) {
            p.g(nullAsNil, "icon");
            p.g(nullAsNil2, "title");
            p.g(nullAsNil3, "appId");
            p.g(nullAsNil5, "entryPage");
            p.g(nullAsNil4, "appUserName");
            HandOffMG handOffMG = new HandOffMG(nullAsNil, nullAsNil2, nullAsNil3, nullAsNil5, nullAsNil4, 1, null, null, null, FileUtils.S_IRWXU, null);
            AppMethodBeat.o(175132);
            return handOffMG;
        }
        p.g(nullAsNil, "icon");
        p.g(nullAsNil2, "title");
        p.g(nullAsNil3, "appId");
        p.g(nullAsNil5, "entryPage");
        p.g(nullAsNil4, "appUserName");
        HandOffMP handOffMP = new HandOffMP(nullAsNil, nullAsNil2, nullAsNil3, nullAsNil5, nullAsNil4, 1, null, null, null, FileUtils.S_IRWXU, null);
        AppMethodBeat.o(175132);
        return handOffMP;
    }
}
