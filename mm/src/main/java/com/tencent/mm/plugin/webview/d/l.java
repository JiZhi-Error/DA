package com.tencent.mm.plugin.webview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@GX\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/webview/jsapi/JsLoaderSetting;", "", "()V", "value", "", "isVConsoleOpen", "()Z", "setVConsoleOpen", "(Z)V", "webview-sdk_release"})
public final class l {
    public static final l ISd = new l();

    static {
        AppMethodBeat.i(225109);
        AppMethodBeat.o(225109);
    }

    private l() {
    }

    public static final boolean gbo() {
        AppMethodBeat.i(225107);
        if ((BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG || ((b) g.af(b.class)).a(b.a.clicfg_webview_debug, 0) == 1) && m.gbp().getBoolean("vconsole", false)) {
            AppMethodBeat.o(225107);
            return true;
        }
        AppMethodBeat.o(225107);
        return false;
    }

    public static final void za(boolean z) {
        AppMethodBeat.i(225108);
        m.gbp().putBoolean("vconsole", z);
        AppMethodBeat.o(225108);
    }
}
