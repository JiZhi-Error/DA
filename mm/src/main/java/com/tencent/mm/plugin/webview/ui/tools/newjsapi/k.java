package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleAdAction;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "ACTION_REPORT", "", "KEY_ACTION", "KEY_DATA", "TAG", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "doReport", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "data", "handleMsg", "plugin-webview_release"})
public final class k extends a {
    private static final int CDJ = CDJ;
    public static final k Jxm = new k();
    private static final String edq = edq;

    static {
        AppMethodBeat.i(182677);
        AppMethodBeat.o(182677);
    }

    private k() {
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
        boolean z;
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(210598);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        String str = (String) nVar.params.get(NativeProtocol.WEB_DIALOG_ACTION);
        Log.i("MicroMsg.JsApiHandleMPPageAction", "alvinfluo handleAdAction action: %s", str);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail action is empty", null);
            AppMethodBeat.o(210598);
            return true;
        } else if (p.j(str, "report")) {
            String str3 = (String) nVar.params.get("data");
            String str4 = str3;
            if (str4 == null || str4.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail data is empty", null);
                AppMethodBeat.o(210598);
                return true;
            }
            JSONObject jSONObject = new JSONObject(str3);
            int safeParseInt = Util.safeParseInt(jSONObject.optString("logid"));
            String optString = jSONObject.optString("logstr");
            Log.v("MicroMsg.JsApiHandleMPPageAction", "alvinluo handleAdAction doReport logId: %s, logStr: %s", Integer.valueOf(safeParseInt), optString);
            p.g(optString, "logStr");
            if (optString.length() > 0) {
                z3 = true;
            }
            if (z3) {
                h.INSTANCE.kvStat(safeParseInt, optString);
            }
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
            AppMethodBeat.o(210598);
            return true;
        } else {
            AppMethodBeat.o(210598);
            return false;
        }
    }
}
