package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiSetPageTitle;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "doSetPageTitle", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "handleMsg", "plugin-webview_release"})
public final class w extends a {
    private static final int CDJ = 1202;
    private static final String TAG = TAG;
    public static final w VhQ = new w();
    private static final String edq = edq;

    static {
        AppMethodBeat.i(259831);
        AppMethodBeat.o(259831);
    }

    private w() {
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
        AppMethodBeat.i(259829);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        j(fVar, nVar);
        AppMethodBeat.o(259829);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0060 A[Catch:{ Exception -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0069 A[Catch:{ Exception -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean j(com.tencent.mm.plugin.webview.d.f r9, com.tencent.mm.plugin.webview.d.n r10) {
        /*
        // Method dump skipped, instructions count: 186
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.newjsapi.w.j(com.tencent.mm.plugin.webview.d.f, com.tencent.mm.plugin.webview.d.n):boolean");
    }
}
