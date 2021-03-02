package com.tencent.mm.plugin.appbrand.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/service/WXNativeInjector;", "", "()V", "WXNATIVE", "", "getWXNATIVE", "()Ljava/lang/String;", "WXNATIVEFILE", "getWXNATIVEFILE", "enableWxNative", "", "component", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "getWXNativeJSRet", "getWXNativeJSScript", "getWXNativeJSScriptName", "plugin-appbrand-integration_release"})
public final class aa {
    private static final String nMW = nMW;
    private static final String nMX = nMX;
    public static final aa nMY = new aa();

    static {
        AppMethodBeat.i(51061);
        AppMethodBeat.o(51061);
    }

    private aa() {
    }

    public static boolean f(c cVar) {
        AppMethodBeat.i(51059);
        p.h(cVar, "component");
        q runtime = cVar.getRuntime();
        p.g(runtime, "component.runtime");
        if (runtime.bsr() || BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED) {
            AppMethodBeat.o(51059);
            return true;
        }
        AppMethodBeat.o(51059);
        return false;
    }

    public static String bVu() {
        return nMW;
    }

    public static String bVv() {
        AppMethodBeat.i(51060);
        String afA = d.afA(nMX);
        p.g(afA, "AppBrandIOUtil.getAssetAsString(WXNATIVEFILE)");
        AppMethodBeat.o(51060);
        return afA;
    }

    public static String bVw() {
        return ";injectNativateRet";
    }
}
