package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.h.f;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequest;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class q extends com.tencent.mm.plugin.webview.d.c.a {
    private static final int CDJ = 331;
    public static final q JxD = new q();
    private static final String TAG = TAG;
    private static final String edq = "request";

    static {
        AppMethodBeat.i(175687);
        AppMethodBeat.o(175687);
    }

    private q() {
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final int ePA() {
        return CDJ;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final String ePz() {
        return edq;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062F\u0010\u0007\u001aB\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\t0\t \u0004* \u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\t0\t\u0018\u00010\n0\bH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "kotlin.jvm.PlatformType", "ret", "", "retValue", "", "", "", "callback"})
    static final class a implements f.a {
        final /* synthetic */ com.tencent.mm.plugin.webview.d.f CDE;

        a(com.tencent.mm.plugin.webview.d.f fVar) {
            this.CDE = fVar;
        }

        @Override // com.tencent.mm.plugin.webview.h.f.a
        public final void a(n nVar, String str, Map<String, Object> map) {
            AppMethodBeat.i(210651);
            this.CDE.IQZ.h(nVar.ISe, str, map);
            AppMethodBeat.o(210651);
        }
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final boolean a(com.tencent.mm.plugin.webview.d.f fVar, n nVar) {
        AppMethodBeat.i(210652);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        boolean a2 = f.a(nVar, new a(fVar));
        AppMethodBeat.o(210652);
        return a2;
    }
}
