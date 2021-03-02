package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, hxF = {"kvCommand", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvCommand", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "webview-sdk_release"})
public final class h {
    public static final MultiProcessMMKV cdi() {
        AppMethodBeat.i(225051);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("__webview_command");
        p.g(mmkv, "MultiProcessMMKV.getMMKV(\"__webview_command\")");
        AppMethodBeat.o(225051);
        return mmkv;
    }
}
