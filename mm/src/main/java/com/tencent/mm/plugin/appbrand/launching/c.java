package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.backgroundfetch.b;
import com.tencent.mm.plugin.appbrand.backgroundfetch.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.WebRenderingCacheDirectoryDescriptor;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.h;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public final class c {
    public static void b(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(47067);
        if (b.d(appBrandInitConfigWC)) {
            b.a(appBrandInitConfigWC.appId, appBrandInitConfigWC.username, appBrandInitConfigWC.eix, appBrandInitConfigWC.kHw, appBrandStatObject.scene, new j());
        }
        g.aAf();
        appBrandInitConfigWC.uin = a.getUin();
        boolean bm = n.buJ().bm(appBrandInitConfigWC.username, appBrandInitConfigWC.eix);
        if (n.buK().bj(appBrandInitConfigWC.username, appBrandInitConfigWC.eix)) {
            appBrandStatObject.nHt = 1;
        } else if (bm) {
            appBrandStatObject.nHt = 2;
        } else {
            appBrandStatObject.nHt = 3;
        }
        if (appBrandInitConfigWC.NA()) {
            ((com.tencent.mm.plugin.boots.a.c) g.af(com.tencent.mm.plugin.boots.a.c.class)).CN(com.tencent.mm.plugin.boots.a.b.pkw);
        }
        if (!appBrandInitConfigWC.ldN) {
            ((com.tencent.mm.plugin.boots.a.c) g.af(com.tencent.mm.plugin.boots.a.c.class)).CN(com.tencent.mm.plugin.boots.a.b.pky);
            if (!appBrandInitConfigWC.NA()) {
                ((com.tencent.mm.plugin.boots.a.c) g.af(com.tencent.mm.plugin.boots.a.c.class)).CN(com.tencent.mm.plugin.boots.a.b.pkz);
            }
        }
        if ("wxfe02ecfe70800f46".equalsIgnoreCase(appBrandInitConfigWC.appId)) {
            ((com.tencent.mm.plugin.boots.a.c) g.af(com.tencent.mm.plugin.boots.a.c.class)).CN(com.tencent.mm.plugin.boots.a.b.pkA);
        }
        if (appBrandInitConfigWC.NA()) {
            appBrandInitConfigWC.ldV = null;
            if (appBrandInitConfigWC.launchMode == 1) {
                appBrandInitConfigWC.cBG = "portrait";
                AppMethodBeat.o(47067);
                return;
            }
        } else {
            appBrandInitConfigWC.ldV = new WebRenderingCacheDirectoryDescriptor();
            appBrandInitConfigWC.ldV.nwn = h.aeh(appBrandInitConfigWC.appId);
        }
        AppMethodBeat.o(47067);
    }
}
