package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.WebView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiSetNavigationBarColor;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "setNavigationBarColor", "plugin-webview_release"})
public final class v extends a {
    private static final int CDJ = CDJ;
    private static final String TAG = TAG;
    public static final v VhP = new v();
    private static final String edq = "setNavigationBarColor";

    static {
        AppMethodBeat.i(259828);
        AppMethodBeat.o(259828);
    }

    private v() {
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
        AppMethodBeat.i(259826);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        i(fVar, nVar);
        fVar.IQZ.h(nVar.ISe, "setNavigationBarColor:ok", null);
        AppMethodBeat.o(259826);
        return true;
    }

    private static boolean i(f fVar, n nVar) {
        int i2;
        int i3;
        boolean z;
        boolean z2;
        com.tencent.mm.plugin.webview.stub.f fVar2;
        int i4 = -1;
        AppMethodBeat.i(259827);
        Log.i(TAG, "setNavigationBarColor");
        boolean j2 = p.j("1", (String) nVar.params.get("actionCode"));
        Bundle bundle = new Bundle();
        if (j2) {
            bundle.putBoolean("set_navigation_bar_color_reset", true);
        } else {
            try {
                String bfL = z.bfL((String) nVar.params.get("wxcolor"));
                if (Util.isNullOrNil(bfL)) {
                    bfL = (String) nVar.params.get("color");
                }
                i2 = Color.parseColor(bfL) | WebView.NIGHT_MODE_COLOR;
            } catch (Exception e2) {
                Log.e(TAG, e2.getMessage());
                bundle.putBoolean("set_navigation_bar_color_reset", true);
                i2 = -1;
            }
            try {
                String str = (String) nVar.params.get("alpha");
                String str2 = str;
                if (str2 == null || kotlin.n.n.aL(str2)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    i4 = (int) (Util.getFloat(str, 1.0f) * 255.0f);
                    if (i4 < 0 || i4 > 255) {
                        i4 = 255;
                    }
                    String str3 = (String) nVar.params.get("titleAlphaAdjustment");
                    String str4 = str3;
                    if (str4 == null || kotlin.n.n.aL(str4)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        bundle.putBoolean("set_navigation_bar_color_titleAlphaAdjustment", Util.getBoolean(str3, false));
                        i3 = i4;
                        bundle.putInt("set_navigation_bar_color_color", i2);
                        bundle.putInt("set_navigation_bar_color_alpha", i3);
                    }
                }
                i3 = i4;
            } catch (Exception e3) {
                i3 = -1;
                Log.e(TAG, e3.getMessage());
            }
            bundle.putInt("set_navigation_bar_color_color", i2);
            bundle.putInt("set_navigation_bar_color_alpha", i3);
        }
        Context context = fVar.context;
        if (!(context instanceof WebViewUI)) {
            context = null;
        }
        WebViewUI webViewUI = (WebViewUI) context;
        if (!(webViewUI == null || (fVar2 = webViewUI.ISw) == null)) {
            fVar2.j(53, bundle);
        }
        AppMethodBeat.o(259827);
        return true;
    }
}
