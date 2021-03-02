package com.tencent.mm.plugin.webview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/webview/jsapi/WebViewJsApiPoolManager;", "", "()V", "TAG", "", "jsApiPoolList", "", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "addJsApiPool", "", "jsApiPool", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "removeJsApiPool", "webview-sdk_release"})
public final class q {
    private static final List<e> ISl = j.mutableListOf(p.ISk);
    public static final q ISm = new q();

    static {
        AppMethodBeat.i(225123);
        AppMethodBeat.o(225123);
    }

    private q() {
    }

    public static boolean a(f fVar, n nVar) {
        AppMethodBeat.i(225120);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        for (T t : ISl) {
            if (t.b(fVar, nVar) && t.a(fVar, nVar)) {
                AppMethodBeat.o(225120);
                return true;
            }
        }
        AppMethodBeat.o(225120);
        return false;
    }

    public static void a(e eVar) {
        AppMethodBeat.i(225121);
        p.h(eVar, "jsApiPool");
        if (!ISl.contains(eVar)) {
            ISl.add(eVar);
            Log.v("MicroMsg.WebViewJsApiPoolManager", "addJsApiPool size: %s, added: %s", Integer.valueOf(ISl.size()), eVar);
        }
        AppMethodBeat.o(225121);
    }

    public static void b(e eVar) {
        AppMethodBeat.i(225122);
        p.h(eVar, "jsApiPool");
        if (ISl.contains(eVar)) {
            ISl.remove(eVar);
            Log.v("MicroMsg.WebViewJsApiPoolManager", "removeJsApiPool size: %s, removed: %s", Integer.valueOf(ISl.size()), eVar);
        }
        AppMethodBeat.o(225122);
    }
}
