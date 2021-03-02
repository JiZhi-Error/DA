package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, hxF = {"appBrandDebugUIPrecondition", "", "getAppBrandDebugUIPrecondition", "()Z", "plugin-appbrand-integration_release"})
public final class f {
    private static final boolean nSR = (WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_RED);

    static {
        AppMethodBeat.i(229479);
        AppMethodBeat.o(229479);
    }

    public static final boolean bWW() {
        return nSR;
    }
}
