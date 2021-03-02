package com.tencent.mm.plugin.webview.a;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;

public final class a implements n {
    public static m jRt;
    public static l jRu;

    @Override // com.tencent.mm.pluginsdk.n
    public final void a(m mVar) {
        jRt = mVar;
    }

    @Override // com.tencent.mm.pluginsdk.n
    public final void a(l lVar) {
        jRu = lVar;
    }

    public static void aj(Runnable runnable) {
        AppMethodBeat.i(77826);
        if (0 > 0) {
            h.RTc.a(runnable, 0, "WebViewWorkerThread");
            AppMethodBeat.o(77826);
            return;
        }
        h.RTc.b(runnable, "WebViewWorkerThread");
        AppMethodBeat.o(77826);
    }
}
