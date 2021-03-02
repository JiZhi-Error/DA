package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class d extends br {
    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final b.a aVar) {
        AppMethodBeat.i(186851);
        if (com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext())) {
            aVar.c("", null);
            AppMethodBeat.o(186851);
            return;
        }
        RequestFloatWindowPermissionDialog.a(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.dd5), new RequestFloatWindowPermissionDialog.a() {
            /* class com.tencent.mm.plugin.game.luggage.b.d.AnonymousClass1 */

            @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
            public final void onResultAllow(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                AppMethodBeat.i(186848);
                Log.w("MicroMsg.JsApiBookDownloadGame", "float window permission granted");
                requestFloatWindowPermissionDialog.finish();
                aVar.c("", null);
                AppMethodBeat.o(186848);
            }

            @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
            public final void onResultRefuse(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                AppMethodBeat.i(186849);
                Log.w("MicroMsg.JsApiBookDownloadGame", "float window permission refused");
                requestFloatWindowPermissionDialog.finish();
                aVar.c("", null);
                AppMethodBeat.o(186849);
            }

            @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
            public final void onResultCancel(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                AppMethodBeat.i(186850);
                Log.w("MicroMsg.JsApiBookDownloadGame", "onResultCancel ok:%b", Boolean.valueOf(com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext())));
                requestFloatWindowPermissionDialog.finish();
                aVar.c("", null);
                AppMethodBeat.o(186850);
            }
        }, true, a.apJ());
        AppMethodBeat.o(186851);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "bookDownloadGame";
    }
}
