package com.tencent.mm.plugin.appbrand.report;

import com.tencent.luggage.sdk.config.c;
import com.tencent.luggage.sdk.config.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/PVReportIDFactory;", "Lcom/tencent/luggage/sdk/config/MPInstanceIdFactory;", "Lcom/tencent/luggage/sdk/config/MPSessionIdFactory;", "()V", "createInstanceId", "", "createSessionId", "getUINString", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "plugin-appbrand-integration_release"})
public final class r implements c, d {
    public static final r nHM = new r();

    static {
        AppMethodBeat.i(229306);
        AppMethodBeat.o(229306);
    }

    private r() {
    }

    public static final void init() {
        d.a.czj = nHM;
        c.a.czh = nHM;
    }

    @Override // com.tencent.luggage.sdk.config.c
    public final String NI() {
        String string;
        AppMethodBeat.i(229304);
        String[] strArr = new String[5];
        StringBuilder sb = new StringBuilder("hash=");
        if (MMApplicationContext.isMainProcess()) {
            p.g(g.aAf(), "MMKernel.account()");
            string = a.ayV();
            p.g(string, "MMKernel.account().uinString");
        } else {
            string = com.tencent.mm.b.p.getString(a.ayW());
            p.g(string, "UIN.getString(CoreAccoun…dOnlyUinInOtherProcess())");
        }
        strArr[0] = sb.append(string).toString();
        strArr[1] = "ts=" + Util.nowMilliSecond();
        strArr[2] = "host=";
        strArr[3] = "version=" + com.tencent.mm.protocal.d.KyO;
        strArr[4] = "device=2";
        String a2 = org.apache.commons.b.g.a(strArr, "&");
        p.g(a2, "StringUtils.join(arrayOf…2-android\n        ), \"&\")");
        AppMethodBeat.o(229304);
        return a2;
    }

    @Override // com.tencent.luggage.sdk.config.d
    public final String NJ() {
        AppMethodBeat.i(229305);
        String NI = NI();
        AppMethodBeat.o(229305);
        return NI;
    }
}
