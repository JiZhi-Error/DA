package com.tencent.mm.plugin.appbrand.launching.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J1\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/teenmode/AppBrandTeenModeUtils;", "", "()V", "TAG", "", "canAddCollection", "", "isTeenMode", "miniProgramOption", "", "canLaunchAppBrand", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "scene", ch.COL_USERNAME, "versionType", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Ljava/lang/Integer;Ljava/lang/String;I)Z", "plugin-appbrand-integration_release"})
public final class b {
    public static final b mZB = new b();

    static {
        AppMethodBeat.i(228796);
        AppMethodBeat.o(228796);
    }

    private b() {
    }

    public static final boolean a(AppBrandInitConfigWC appBrandInitConfigWC, Integer num, String str, int i2) {
        AppMethodBeat.i(228794);
        p.h(appBrandInitConfigWC, "config");
        if (i2 != 0) {
            AppMethodBeat.o(228794);
            return true;
        } else if ((num != null && num.intValue() == 1045) || ((num != null && num.intValue() == 1046) || ((num != null && num.intValue() == 1084) || ((num != null && num.intValue() == 1067) || ((num != null && num.intValue() == 1095) || ((num != null && num.intValue() == 1035) || ((num != null && num.intValue() == 1102) || ((num != null && num.intValue() == 1058) || ((num != null && num.intValue() == 1091) || (num != null && num.intValue() == 1144)))))))))) {
            AppMethodBeat.o(228794);
            return true;
        } else if (appBrandInitConfigWC.cyo == 7 || appBrandInitConfigWC.ldN) {
            AppMethodBeat.o(228794);
            return true;
        } else {
            a af = g.af(com.tencent.mm.plugin.teenmode.a.b.class);
            p.g(af, "MMKernel.service(ITeenModeService::class.java)");
            boolean Vt = ((com.tencent.mm.plugin.teenmode.a.b) af).Vt();
            if (!Vt) {
                AppMethodBeat.o(228794);
                return true;
            }
            a af2 = g.af(com.tencent.mm.plugin.teenmode.a.b.class);
            p.g(af2, "MMKernel.service(ITeenModeService::class.java)");
            int fvp = ((com.tencent.mm.plugin.teenmode.a.b) af2).fvp();
            Log.i("MicroMsg.AppBrandTeenModeUtils", "canLaunchAppBrand isTeenMode: %b, miniProgramOption: %d, serviceType: %d, isPluginApp: %b", Boolean.valueOf(Vt), Integer.valueOf(fvp), Integer.valueOf(appBrandInitConfigWC.cyo), Boolean.valueOf(appBrandInitConfigWC.ldN));
            if (fvp == 0) {
                ag agVar = (ag) g.af(ag.class);
                if (str == null) {
                    str = "";
                }
                boolean bf = agVar.bf(str, i2);
                AppMethodBeat.o(228794);
                return bf;
            } else if (fvp == 2) {
                AppMethodBeat.o(228794);
                return false;
            } else {
                AppMethodBeat.o(228794);
                return true;
            }
        }
    }

    public static final boolean bOn() {
        AppMethodBeat.i(228795);
        a af = g.af(com.tencent.mm.plugin.teenmode.a.b.class);
        p.g(af, "MMKernel.service(ITeenModeService::class.java)");
        boolean Vt = ((com.tencent.mm.plugin.teenmode.a.b) af).Vt();
        a af2 = g.af(com.tencent.mm.plugin.teenmode.a.b.class);
        p.g(af2, "MMKernel.service(ITeenModeService::class.java)");
        boolean t = t(Vt, ((com.tencent.mm.plugin.teenmode.a.b) af2).fvp());
        AppMethodBeat.o(228795);
        return t;
    }

    public static final boolean t(boolean z, int i2) {
        if (z && i2 != 1) {
            return false;
        }
        return true;
    }
}
