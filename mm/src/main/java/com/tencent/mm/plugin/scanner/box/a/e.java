package com.tencent.mm.plugin.scanner.box.a;

import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.box.a.a.b;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiShake;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "vibrator", "Landroid/os/Vibrator;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", e.edq, "", "plugin-scan_release"})
public final class e extends b {
    public static final e CDF = new e();
    private static final String edq = edq;
    private static Vibrator paT;

    static {
        AppMethodBeat.i(240354);
        AppMethodBeat.o(240354);
    }

    private e() {
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final String ePz() {
        return edq;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final boolean a(f fVar, n nVar) {
        AppMethodBeat.i(240353);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        Log.d("MicroMsg.JsApiShake", "ScanJsApi-Call:shake");
        if (paT == null) {
            Object systemService = fVar.context.getSystemService("vibrator");
            if (systemService == null) {
                t tVar = new t("null cannot be cast to non-null type android.os.Vibrator");
                AppMethodBeat.o(240353);
                throw tVar;
            }
            paT = (Vibrator) systemService;
        }
        Vibrator vibrator = paT;
        if (vibrator != null) {
            vibrator.vibrate(10);
        }
        fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
        AppMethodBeat.o(240353);
        return true;
    }
}
