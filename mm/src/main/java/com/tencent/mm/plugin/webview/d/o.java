package com.tencent.mm.plugin.webview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0011J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/webview/jsapi/ScanWebViewJsApiPool;", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "()V", "TAG", "", "jsApis", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "initJsApis", "", "jsApiList", "", "support", "webview-sdk_release"})
public final class o implements e {
    private static Map<String, a> ISh = new HashMap();
    public static final o ISi = new o();

    static {
        AppMethodBeat.i(225114);
        AppMethodBeat.o(225114);
    }

    private o() {
    }

    public static void bM(Map<String, ? extends a> map) {
        AppMethodBeat.i(225111);
        p.h(map, "jsApiList");
        ISh.clear();
        ISh.putAll(map);
        AppMethodBeat.o(225111);
    }

    @Override // com.tencent.mm.plugin.webview.d.e
    public final boolean b(f fVar, n nVar) {
        boolean z;
        AppMethodBeat.i(225112);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        if (!ISh.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !p.j(fVar.IQZ.IKO, this)) {
            AppMethodBeat.o(225112);
            return false;
        }
        AppMethodBeat.o(225112);
        return true;
    }

    @Override // com.tencent.mm.plugin.webview.d.e
    public final boolean a(f fVar, n nVar) {
        AppMethodBeat.i(225113);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        if (ISh.containsKey(nVar.mhO)) {
            a aVar = ISh.get(nVar.mhO);
            if (aVar == null) {
                p.hyc();
            }
            a aVar2 = aVar;
            if (aVar2.ePA() == 10007) {
                aVar2.a(fVar, nVar);
            } else {
                Log.e("MicroMsg.ScanWebViewJsApiPool", "handleMsg access denied func: " + nVar.mhO);
                fVar.IQZ.h(nVar.ISe, "system:access_denied", null);
            }
            AppMethodBeat.o(225113);
        } else {
            AppMethodBeat.o(225113);
        }
        return true;
    }
}
