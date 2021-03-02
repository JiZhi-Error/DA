package com.tencent.luggage.xweb_ext.extendplugin;

import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.b.c;
import com.tencent.luggage.xweb_ext.extendplugin.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.au;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;
import java.util.Locale;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkView;

public final class d {
    public static String o(String str, int i2) {
        AppMethodBeat.i(138808);
        String format = String.format(Locale.US, "%s#%d", str, Integer.valueOf(i2));
        AppMethodBeat.o(138808);
        return format;
    }

    public static void a(c cVar, String str, int i2, float f2, float f3) {
        AppMethodBeat.i(215536);
        if (!(cVar == null || cVar.QK() == null)) {
            Log.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyPluginTextureScale, %s#%d, scale:[%s,%s]", str, Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3));
            cVar.QK().setPluginTextureScale(str, i2, f2, f3);
        }
        AppMethodBeat.o(215536);
    }

    public static void a(c cVar, String str, int i2) {
        AppMethodBeat.i(215537);
        if (!(cVar == null || cVar.QK() == null)) {
            Log.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyPluginScreenshot, %s#%d", str, Integer.valueOf(i2));
            cVar.QK().takePluginScreenshot(str, i2);
        }
        AppMethodBeat.o(215537);
    }

    public static c a(WebView webView, com.tencent.luggage.xweb_ext.extendplugin.b.d dVar, com.tencent.luggage.xweb_ext.extendplugin.a.c cVar, au auVar) {
        AppMethodBeat.i(215535);
        if (!XWalkEnvironment.isCurrentVersionSupportExtendPluginForAppbrand()) {
            Log.w("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current version not support extend plugin");
            AppMethodBeat.o(215535);
            return null;
        }
        if (webView == null || !webView.isXWalkKernel()) {
            Log.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current webview is not xweb kernel");
        } else {
            View webViewUI = webView.getWebViewUI();
            if (!(webViewUI instanceof XWalkView) || dVar == null) {
                Log.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client fail");
            } else {
                XWalkView xWalkView = (XWalkView) webViewUI;
                c QM = dVar.QM();
                c cVar2 = new c(xWalkView);
                cVar2.cDJ = QM;
                QM.a(cVar2);
                xWalkView.setExtendPluginClient(cVar2);
                if (auVar != null) {
                    a aVar = new a(xWalkView);
                    aVar.cKd = auVar;
                    xWalkView.setExtendTextAreaClient(aVar);
                }
                if (cVar != null) {
                    QM.a(cVar);
                }
                Log.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client success");
                AppMethodBeat.o(215535);
                return QM;
            }
        }
        AppMethodBeat.o(215535);
        return null;
    }
}
