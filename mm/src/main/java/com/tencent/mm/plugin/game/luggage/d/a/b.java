package com.tencent.mm.plugin.game.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bq.a;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class b extends com.tencent.mm.plugin.lite.jsapi.b {
    @Override // com.tencent.liteapp.jsapi.a
    public final void a(String str, JSONObject jSONObject) {
        AppMethodBeat.i(186902);
        if (!com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext())) {
            RequestFloatWindowPermissionDialog.a(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.dd5), new RequestFloatWindowPermissionDialog.a() {
                /* class com.tencent.mm.plugin.game.luggage.d.a.b.AnonymousClass1 */

                @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
                public final void onResultAllow(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                    AppMethodBeat.i(186899);
                    Log.w("LiteAppJsApiBookDownloadGame", "float window permission granted");
                    requestFloatWindowPermissionDialog.finish();
                    AppMethodBeat.o(186899);
                }

                @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
                public final void onResultRefuse(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                    AppMethodBeat.i(186900);
                    Log.w("LiteAppJsApiBookDownloadGame", "float window permission refused");
                    requestFloatWindowPermissionDialog.finish();
                    AppMethodBeat.o(186900);
                }

                @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
                public final void onResultCancel(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                    AppMethodBeat.i(186901);
                    Log.w("LiteAppJsApiBookDownloadGame", "onResultCancel ok:%b", Boolean.valueOf(com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext())));
                    requestFloatWindowPermissionDialog.finish();
                    AppMethodBeat.o(186901);
                }
            }, true, a.apJ());
        }
        AppMethodBeat.o(186902);
    }
}
