package com.tencent.luggage.sdk.d;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bn;
import com.tencent.mm.plugin.appbrand.appcache.bo;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\f\u0010\u0012\u001a\u00020\u0004*\u00020\u000fH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0013"}, hxF = {"Lcom/tencent/luggage/sdk/runtime/RuntimePkgReaderFactoryInterceptorImpl;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgReaderInternalImplFactory$FactoryInterceptor;", "()V", "forceNewReader", "", "getForceNewReader", "()Z", "setForceNewReader", "(Z)V", "forceNewReaderForGame", "getForceNewReaderForGame", "setForceNewReaderForGame", "createInternalReader", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "wrapper", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgRuntimeReader;", "isGame", "luggage-wechat-full-sdk_release"})
public final class g implements bo.a {
    private static volatile boolean cCo;
    private static volatile boolean cCp;
    public static final g cCq = new g();

    static {
        AppMethodBeat.i(183002);
        AppMethodBeat.o(183002);
    }

    private g() {
    }

    public static void OV() {
        cCo = true;
    }

    public static void OW() {
        cCp = true;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.bo.a
    public final q a(AppBrandRuntime appBrandRuntime, bg bgVar) {
        bn bnVar;
        WxaPkgWrappingInfo wxaPkgWrappingInfo;
        WxaRuntimeModulePluginListMap wxaRuntimeModulePluginListMap;
        AppMethodBeat.i(183000);
        p.h(appBrandRuntime, "rt");
        p.h(bgVar, "wrapper");
        AppBrandSysConfigLU appBrandSysConfigLU = (AppBrandSysConfigLU) appBrandRuntime.d(AppBrandSysConfigLU.class, false);
        if (appBrandSysConfigLU != null && (wxaPkgWrappingInfo = appBrandSysConfigLU.leE) != null && (wxaRuntimeModulePluginListMap = wxaPkgWrappingInfo.kOb) != null && !wxaRuntimeModulePluginListMap.isEmpty()) {
            bnVar = new bn(appBrandRuntime);
        } else if (!cCo || isGame(appBrandRuntime)) {
            bnVar = (!cCp || !isGame(appBrandRuntime)) ? null : new bn(appBrandRuntime);
        } else {
            bnVar = new bn(appBrandRuntime);
        }
        if (bnVar != null) {
            bgVar.Vq("__plugin__/");
            bgVar.Vq(WxaPluginPkgInfo.PREFIX_EXTENDED);
        } else {
            bnVar = null;
        }
        bn bnVar2 = bnVar;
        AppMethodBeat.o(183000);
        return bnVar2;
    }

    private static boolean isGame(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(183001);
        AppBrandInitConfig OU = appBrandRuntime.OU();
        if (!(OU instanceof AppBrandInitConfigLU)) {
            OU = null;
        }
        AppBrandInitConfigLU appBrandInitConfigLU = (AppBrandInitConfigLU) OU;
        if (appBrandInitConfigLU == null || appBrandInitConfigLU.cyo != 4) {
            AppMethodBeat.o(183001);
            return false;
        }
        AppMethodBeat.o(183001);
        return true;
    }
}
