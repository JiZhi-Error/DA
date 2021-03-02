package com.tencent.mm.plugin.webview.ui.tools.fts.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.hs;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.webview.ui.tools.fts.preload.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\bJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadLogic;", "", "()V", "CONTINUE_SET_RESULT", "", "SET_RESULT_HANDLER", "preloadObjMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadObj;", "getPreloadObjMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "getPreloadWebView", "biz", "preloadWebView", "", "url", "reset", "", "plugin-webview_release"})
public final class b {
    private static final ConcurrentHashMap<Integer, d> JpA = new ConcurrentHashMap<>();
    public static final b JpB = new b();

    static {
        AppMethodBeat.i(210528);
        AppMethodBeat.o(210528);
    }

    private b() {
    }

    public static void k(int i2, String str, boolean z) {
        AppMethodBeat.i(210526);
        p.h(str, "url");
        if (z) {
            JpA.remove(Integer.valueOf(i2));
        }
        e eVar = new e(i2, str);
        if (JpA.containsKey(Integer.valueOf(eVar.mrG))) {
            Log.i(c.getTAG(), "already exist preload obj biz:" + eVar.mrG + " url:" + eVar.url);
            AppMethodBeat.o(210526);
            return;
        }
        Log.i(c.getTAG(), "start to preload obj biz:" + eVar.mrG + " url:" + eVar.url);
        eVar.JpD = cl.aWA();
        d dVar = new d(eVar.mrG, eVar.url);
        JpA.put(Integer.valueOf(dVar.mrG), dVar);
        eVar.JpE = dVar;
        d.h(new e.f(eVar));
        hs hsVar = new hs();
        hsVar.qS((long) eVar.mrG);
        hsVar.qT(1);
        hsVar.bfK();
        ar.a(hsVar);
        AppMethodBeat.o(210526);
    }

    public static d agX(int i2) {
        AppMethodBeat.i(210527);
        d dVar = JpA.get(Integer.valueOf(i2));
        if (dVar != null) {
            if (!dVar.JpC.get()) {
                dVar = null;
            }
            if (dVar != null) {
                JpA.remove(Integer.valueOf(i2));
                AppMethodBeat.o(210527);
                return dVar;
            }
        }
        AppMethodBeat.o(210527);
        return null;
    }
}
