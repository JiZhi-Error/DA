package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0002\"\u0014\u0010\u0000\u001a\u00020\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, hxF = {"kvCommand", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvCommand", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "toast", "", "", "plugin-brandservice_release"})
public final class k {
    public static final MultiProcessMMKV cdi() {
        AppMethodBeat.i(6634);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("_webview_tmpl_command");
        p.g(mmkv, "MultiProcessMMKV.getMMKV…MKV_WEBVIEW_TMPL_COMMAND)");
        AppMethodBeat.o(6634);
        return mmkv;
    }
}
