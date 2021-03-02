package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.Log;

public class bd extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "setCloseWindowConfirmDialogInfo";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        AppMethodBeat.i(78623);
        Log.i("MicroMsg.JsApiSetCloseWindowConfirmDialogInfo", "invoke");
        Boolean valueOf = Boolean.valueOf(aVar.ctb.csi.optBoolean("switch"));
        String optString = aVar.ctb.csi.optString("title_cn");
        String optString2 = aVar.ctb.csi.optString("title_eng");
        String optString3 = aVar.ctb.csi.optString("ok_cn");
        String optString4 = aVar.ctb.csi.optString("ok_eng");
        String optString5 = aVar.ctb.csi.optString("cancel_cn");
        String optString6 = aVar.ctb.csi.optString("cancel_eng");
        m gbC = aVar.cta.gbC();
        if (gbC == null) {
            AppMethodBeat.o(78623);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("close_window_confirm_dialog_switch", valueOf.booleanValue());
        bundle.putString("close_window_confirm_dialog_title_cn", optString);
        bundle.putString("close_window_confirm_dialog_title_eng", optString2);
        bundle.putString("close_window_confirm_dialog_ok_cn", optString3);
        bundle.putString("close_window_confirm_dialog_ok_eng", optString4);
        bundle.putString("close_window_confirm_dialog_cancel_cn", optString5);
        bundle.putString("close_window_confirm_dialog_cancel_eng", optString6);
        gbC.setCloseWindowConfirmInfo(bundle);
        aVar.c("", null);
        AppMethodBeat.o(78623);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
