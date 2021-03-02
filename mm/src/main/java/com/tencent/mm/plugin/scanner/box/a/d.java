package com.tencent.mm.plugin.scanner.box.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiSend;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "onFailed", "", "onSuccess", d.edq, "text", "plugin-scan_release"})
public final class d extends com.tencent.mm.plugin.scanner.box.a.a.b {
    public static final d CDD = new d();
    private static final String edq = edq;

    static {
        AppMethodBeat.i(240351);
        AppMethodBeat.o(240351);
    }

    private d() {
    }

    public static final /* synthetic */ void b(f fVar) {
        AppMethodBeat.i(240352);
        a(fVar);
        AppMethodBeat.o(240352);
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final String ePz() {
        return edq;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final boolean a(f fVar, n nVar) {
        String str;
        AppMethodBeat.i(240349);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        String str2 = (String) nVar.params.get("content");
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        Log.i("MicroMsg.JsApiSend", "ScanJsApi-Call:send");
        if (str.length() == 0) {
            Log.e("MicroMsg.JsApiSend", "ScanJsApi-Call:send text is empty");
        } else {
            Intent intent = new Intent();
            intent.putExtra("Retr_Msg_content", str);
            intent.putExtra("Retr_Msg_Type", 4);
            intent.putExtra("Retr_show_success_tips", false);
            if (fVar.context instanceof MMActivity) {
                int hashCode = hashCode() & 65535;
                Context context = fVar.context;
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(240349);
                    throw tVar;
                }
                c.a((MMActivity) context, "com.tencent.mm.ui.transmit.MsgRetransmitUI", intent, hashCode, new b(fVar));
            } else {
                c.f(fVar.context, "com.tencent.mm.ui.transmit.MsgRetransmitUI", intent);
                a(fVar);
            }
        }
        fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
        AppMethodBeat.o(240349);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class b implements MMActivity.a {
        final /* synthetic */ f CDE;

        b(f fVar) {
            this.CDE = fVar;
        }

        @Override // com.tencent.mm.ui.MMActivity.a
        public final void d(int i2, int i3, Intent intent) {
            boolean z = true;
            AppMethodBeat.i(240348);
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i3);
            if (intent == null) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            Log.i("MicroMsg.JsApiSend", "ScanJsApi-Call:send requestCode: %s, resultCode: %s, data != null: %s", objArr);
            if (i2 == (d.CDD.hashCode() & 65535) && i3 == -1 && intent != null && intent.getIntExtra("sendResult", -1) == 0) {
                d dVar = d.CDD;
                d.b(this.CDE);
            }
            AppMethodBeat.o(240348);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ f CDE;

        a(f fVar) {
            this.CDE = fVar;
        }

        public final void run() {
            AppMethodBeat.i(240347);
            u.cG(this.CDE.context, this.CDE.context.getString(R.string.yt));
            AppMethodBeat.o(240347);
        }
    }

    private static void a(f fVar) {
        AppMethodBeat.i(240350);
        h.RTc.aV(new a(fVar));
        AppMethodBeat.o(240350);
    }
}
