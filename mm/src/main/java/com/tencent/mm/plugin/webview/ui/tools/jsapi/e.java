package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\u0006*\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiInvokeMiniProgramAPI;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "binderID", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "getBinderID", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;)I", "handleMsg", "", "env", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class e extends com.tencent.mm.plugin.webview.d.c.a {
    private static final int CDJ = 295;
    public static final e JsD = new e();
    private static final String edq = edq;

    static {
        AppMethodBeat.i(175672);
        AppMethodBeat.o(175672);
    }

    private e() {
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final int ePA() {
        return CDJ;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final String ePz() {
        return edq;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final boolean a(f fVar, n nVar) {
        AppMethodBeat.i(210553);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        j jVar = (j) g.af(j.class);
        if (jVar != null) {
            jVar.a(fVar.IQZ.getBinderID(), nVar.ISf.optString("name"), nVar.ISf.opt("arg"));
        } else {
            a.JsE.invoke();
        }
        fVar.IQZ.h(nVar.ISe, edq + ":ok", null);
        AppMethodBeat.o(210553);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        public static final a JsE = new a();

        static {
            AppMethodBeat.i(175670);
            AppMethodBeat.o(175670);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(175669);
            Log.e("MicroMsg.WebView.JsApiInvokeMiniProgramAPI", "invoke but get NULL IAppBrandServiceForWebView");
            x xVar = x.SXb;
            AppMethodBeat.o(175669);
            return xVar;
        }
    }
}
