package com.tencent.mm.plugin.appbrand.jsapi;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;

public final class o {
    volatile g lxN;

    public o(g gVar) {
        this.lxN = gVar;
    }

    @JavascriptInterface
    public final void publishHandler(String str, String str2, String str3) {
        AppMethodBeat.i(140636);
        try {
            g gVar = this.lxN;
            if (gVar == null) {
                AppMethodBeat.o(140636);
                return;
            }
            gVar.b(str, str2, XV(str3));
            AppMethodBeat.o(140636);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandJSInterface", e2, "publishHandler", new Object[0]);
            AppMethodBeat.o(140636);
            throw e2;
        }
    }

    @JavascriptInterface
    public final String invokeHandler(String str, String str2, int i2) {
        AppMethodBeat.i(140637);
        try {
            g gVar = this.lxN;
            if (gVar == null) {
                AppMethodBeat.o(140637);
                return "";
            }
            String y = gVar.y(str, str2, i2);
            AppMethodBeat.o(140637);
            return y;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandJSInterface", e2, "invokeHandler", new Object[0]);
            AppMethodBeat.o(140637);
            throw e2;
        }
    }

    private static int[] XV(String str) {
        AppMethodBeat.i(140639);
        int[] iArr = new int[0];
        try {
            JSONArray jSONArray = new JSONArray(str);
            iArr = new int[jSONArray.length()];
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                iArr[i2] = jSONArray.getInt(i2);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrandJSInterface", e2.getMessage());
        }
        AppMethodBeat.o(140639);
        return iArr;
    }
}
