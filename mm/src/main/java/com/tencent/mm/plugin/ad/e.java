package com.tencent.mm.plugin.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0003"}, hxF = {"getManifestId", "", "host", "webview-sdk_release"})
public final class e {
    public static final String aWU(String str) {
        AppMethodBeat.i(224951);
        p.h(str, "host");
        String str2 = "_manifest_" + str.hashCode();
        AppMethodBeat.o(224951);
        return str2;
    }
}
