package com.tencent.mm.plugin.webview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, hxF = {"kvJsLoader", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvJsLoader", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "webview-sdk_release"})
public final class m {
    static final MultiProcessMMKV gbp() {
        AppMethodBeat.i(225110);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("_webview_jsloader");
        p.g(mmkv, "MultiProcessMMKV.getMMKV(\"_webview_jsloader\")");
        AppMethodBeat.o(225110);
        return mmkv;
    }
}
