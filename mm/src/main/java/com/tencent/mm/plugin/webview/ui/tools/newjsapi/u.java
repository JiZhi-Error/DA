package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiSetNavigationBarButtons;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "doSetNavigationBarButtons", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "handleMsg", "plugin-webview_release"})
public final class u extends a {
    private static final int CDJ = 195;
    private static final String TAG = TAG;
    public static final u VhO = new u();
    private static final String edq = edq;

    static {
        AppMethodBeat.i(259825);
        AppMethodBeat.o(259825);
    }

    private u() {
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
        AppMethodBeat.i(259823);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        h(fVar, nVar);
        AppMethodBeat.o(259823);
        return true;
    }

    private static boolean h(f fVar, n nVar) {
        com.tencent.mm.plugin.webview.stub.f fVar2;
        AppMethodBeat.i(259824);
        String str = (String) nVar.params.get("left");
        String str2 = (String) nVar.params.get("right");
        if (!Util.isNullOrNil(str) || !Util.isNullOrNil(str2)) {
            Bundle bundle = new Bundle();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String bfL = z.bfL(jSONObject.optString("wxcolor", ""));
                if (Util.isNullOrNil(bfL)) {
                    bfL = jSONObject.optString("color", "");
                }
                if (!Util.isNullOrNil(bfL)) {
                    bundle.putString("set_navigation_bar_buttons_left_text_color", bfL);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "setNavigationBarButtons opt left ", new Object[0]);
            }
            try {
                JSONObject jSONObject2 = new JSONObject(str2);
                boolean optBoolean = jSONObject2.optBoolean("hidden", false);
                String optString = jSONObject2.optString("text", "");
                String nullAsNil = Util.nullAsNil(z.bfI(jSONObject2.optString("iconData", "")));
                String bfL2 = z.bfL(jSONObject2.optString("wxcolor", ""));
                if (Util.isNullOrNil(bfL2)) {
                    bfL2 = jSONObject2.optString("color", "");
                }
                boolean optBoolean2 = jSONObject2.optBoolean("needClickEvent", false);
                if (!optBoolean) {
                    bundle.putString("set_navigation_bar_buttons_text", optString);
                    bundle.putString("set_navigation_bar_buttons_icon_data", nullAsNil);
                    bundle.putString("set_navigation_bar_buttons_text_color", bfL2);
                    bundle.putBoolean("set_navigation_bar_buttons_need_click_event", optBoolean2);
                } else {
                    bundle.putBoolean("set_navigation_bar_buttons_hide_right_button", true);
                }
                bundle.putBoolean("set_navigation_bar_right_style", true);
            } catch (Exception e3) {
                Log.printErrStackTrace(TAG, e3, "setNavigationBarButtons opt right ", new Object[0]);
            }
            if (bundle.size() < 0) {
                fVar.IQZ.h(nVar.ISe, "setNavigationBarButtons:fail_invalid_params", null);
                AppMethodBeat.o(259824);
            } else {
                try {
                    Context context = fVar.context;
                    if (!(context instanceof WebViewUI)) {
                        context = null;
                    }
                    WebViewUI webViewUI = (WebViewUI) context;
                    if (!(webViewUI == null || (fVar2 = webViewUI.ISw) == null)) {
                        fVar2.j(44, bundle);
                    }
                    fVar.IQZ.h(nVar.ISe, "setNavigationBarButtons:ok", null);
                } catch (Exception e4) {
                    Log.printErrStackTrace(TAG, e4, "setNavigationBarButtons invoke ", new Object[0]);
                    fVar.IQZ.h(nVar.ISe, "setNavigationBarButtons:fail_invoke", null);
                }
                AppMethodBeat.o(259824);
            }
        } else {
            fVar.IQZ.h(nVar.ISe, "setNavigationBarButtons:fail", null);
            AppMethodBeat.o(259824);
        }
        return true;
    }
}
