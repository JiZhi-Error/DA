package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ad.c;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Set;
import kotlin.g.b.p;

public final class x {
    private static final Set<String> pFb = c.pFb;

    static {
        AppMethodBeat.i(195746);
        c.a aVar = c.ICA;
        AppMethodBeat.o(195746);
    }

    public static final MultiProcessMMKV coM() {
        AppMethodBeat.i(195745);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("_webview_web_prefetcher_info");
        p.g(mmkv, "MultiProcessMMKV.getMMKV…KV_WEBVIEW_PREFETCH_INFO)");
        AppMethodBeat.o(195745);
        return mmkv;
    }
}
