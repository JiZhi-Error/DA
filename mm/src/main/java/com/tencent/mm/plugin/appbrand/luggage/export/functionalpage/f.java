package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalConfigAssembler;", "", "()V", "assembleAppConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "assembleSysConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;", "plugin-appbrand-integration_release"})
public final class f {
    public static final f nau = new f();

    static {
        AppMethodBeat.i(50866);
        AppMethodBeat.o(50866);
    }

    private f() {
    }

    public static final AppBrandSysConfigWC a(l lVar) {
        AppMethodBeat.i(50864);
        p.h(lVar, "runtime");
        AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(lVar.getAppId()), n.class);
        if (appBrandSysConfigWC != null) {
            appBrandSysConfigWC.leE = new WxaPkgWrappingInfo();
            appBrandSysConfigWC.leE.kNW = lVar.bsC().eix;
            appBrandSysConfigWC.leE.pkgVersion = lVar.bsC().appVersion;
            appBrandSysConfigWC.leE.kNY = true;
            AppMethodBeat.o(50864);
            return appBrandSysConfigWC;
        }
        AppMethodBeat.o(50864);
        return null;
    }

    public static final b b(l lVar) {
        AppMethodBeat.i(50865);
        p.h(lVar, "runtime");
        b cS = b.cS(lVar.getAppId(), "{}");
        cS.lcc = lVar.bsC().kHw;
        p.g(cS, "AppBrandAppConfig.parse(…onfig.enterPath\n        }");
        AppMethodBeat.o(50865);
        return cS;
    }
}
