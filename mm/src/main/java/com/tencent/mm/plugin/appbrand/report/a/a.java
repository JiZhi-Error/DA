package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.keylogger.f;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/keystep/AppBrandKeyStepUtils;", "", "()V", "OPEN", "", "()Z", "plugin-appbrand-integration_release"})
public final class a {
    public static final a nIf = new a();

    static {
        AppMethodBeat.i(229308);
        AppMethodBeat.o(229308);
    }

    private a() {
    }

    public static final boolean bUC() {
        AppMethodBeat.i(229307);
        if (f.abT(KSProcessWeAppLaunch.NAME) || BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger() || DebuggerShell.bAx()) {
            AppMethodBeat.o(229307);
            return true;
        }
        AppMethodBeat.o(229307);
        return false;
    }
}
