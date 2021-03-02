package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class a {
    public static boolean ic(Context context) {
        AppMethodBeat.i(82364);
        try {
            Y(new o(context.getFilesDir().getParent() + "/app_webview/GPUCache"));
            Y(new o(context.getFilesDir().getParent() + "/app_x5webview/GPUCache"));
            context.getSharedPreferences("WebViewChromiumPrefs", 0).edit().clear().apply();
            AppMethodBeat.o(82364);
            return true;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.ABI64WebViewCompat", th, "", new Object[0]);
            AppMethodBeat.o(82364);
            return false;
        }
    }

    private static void Y(o oVar) {
        AppMethodBeat.i(175882);
        if (oVar == null) {
            AppMethodBeat.o(175882);
            return;
        }
        if (oVar.isDirectory()) {
            for (o oVar2 : oVar.het()) {
                Y(oVar2);
            }
        }
        Log.i("MicroMsg.ABI64WebViewCompat", "delete isSuccessDelete: %s fileName: %s", Boolean.valueOf(oVar.delete()), aa.z(oVar.her()));
        AppMethodBeat.o(175882);
    }
}
