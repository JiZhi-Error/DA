package com.tencent.mm.plugin.scanner.box.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiCopy;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-scan_release"})
public final class b extends com.tencent.mm.plugin.scanner.box.a.a.b {
    public static final b CDB = new b();
    private static final String edq = edq;

    static {
        AppMethodBeat.i(240344);
        AppMethodBeat.o(240344);
    }

    private b() {
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final String ePz() {
        return edq;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final boolean a(f fVar, n nVar) {
        String str;
        AppMethodBeat.i(240343);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        String str2 = (String) nVar.params.get("content");
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        Log.i("MicroMsg.JsApiCopy", "ScanJsApi-Call:copy content: %s", str);
        ClipboardHelper.setText(MMApplicationContext.getContext(), str, str);
        if (Iu(System.currentTimeMillis())) {
            u.cE(fVar.context, fVar.context.getString(R.string.ta));
        }
        fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
        AppMethodBeat.o(240343);
        return true;
    }
}
