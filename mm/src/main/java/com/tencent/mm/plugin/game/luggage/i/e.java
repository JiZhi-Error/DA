package com.tencent.mm.plugin.game.luggage.i;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.luggage.d.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.f;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.ac.p;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;

public class e implements g {
    private Context mContext;
    private boolean qMl = true;
    private m xzE;

    public e(Context context) {
        AppMethodBeat.i(187015);
        this.mContext = context;
        this.xzE = f.b(null).XA();
        this.xzE.a(1, new h() {
            /* class com.tencent.mm.plugin.game.luggage.i.e.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.m.h
            public final void u(String str, String str2) {
                AppMethodBeat.i(187013);
                Log.e("MicroMsg.LuggageGameJsRuntimeImpl", "handleException, message : %s\n, stackTrace : %s", str, str2);
                String format = String.format("try {WxGameJsCoreBridge.invokeError(\"%s\");} catch(e) {console.log(e);}", org.apache.commons.b.f.bve("exception : " + str + " ; stack : " + str2));
                Log.i("MicroMsg.LuggageGameJsRuntimeImpl", "handleException, js = %s", format);
                e.this.evaluateJavascript(format, null);
                AppMethodBeat.o(187013);
            }
        });
        addJavascriptInterface(new c(), "WxGameJsCoreNative");
        AppMethodBeat.o(187015);
    }

    @Override // com.tencent.luggage.bridge.s
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.tencent.luggage.bridge.s
    public String getUserAgent() {
        AppMethodBeat.i(187016);
        String str = p.a(MMApplicationContext.getContext(), "", (p.a) com.tencent.luggage.a.e.M(p.a.class)) + " v8";
        AppMethodBeat.o(187016);
        return str;
    }

    @Override // com.tencent.luggage.bridge.s
    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(187017);
        this.xzE.a(obj, str, JavascriptInterface.class);
        AppMethodBeat.o(187017);
    }

    @Override // com.tencent.luggage.bridge.s
    public void evaluateJavascript(String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.i(187018);
        this.xzE.a(str, new m.b() {
            /* class com.tencent.mm.plugin.game.luggage.i.e.AnonymousClass2 */

            @Override // com.tencent.mm.appbrand.v8.m.b
            public final void a(String str, m.c cVar) {
                AppMethodBeat.i(187014);
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(str);
                }
                AppMethodBeat.o(187014);
            }
        });
        AppMethodBeat.o(187018);
    }

    @Override // com.tencent.luggage.d.g
    public final void Le() {
        AppMethodBeat.i(187019);
        this.xzE.a(d.afA("luggage_mm_adapter.js"), (m.b) null);
        Point az = au.az(MMApplicationContext.getContext());
        int eu = ((az.y - au.eu(MMApplicationContext.getContext())) - au.getStatusBarHeight(MMApplicationContext.getContext())) - au.aD(MMApplicationContext.getContext());
        float density = a.getDensity(MMApplicationContext.getContext());
        String formatedNetType = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
        evaluateJavascript(String.format(d.afA("game_jscore_system_info.js"), String.valueOf(az.x), String.valueOf(eu), String.valueOf(az.x), String.valueOf(az.y), String.valueOf(density), formatedNetType, Build.BRAND, Build.MODEL, String.format("0x%08X", Integer.valueOf(com.tencent.mm.protocal.d.KyO)), "Android-" + Build.VERSION.SDK_INT, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), Boolean.valueOf(ao.isDarkMode())), null);
        AppMethodBeat.o(187019);
    }

    @Override // com.tencent.luggage.d.g
    public final void destroy() {
        AppMethodBeat.i(187020);
        this.xzE.destroy();
        this.mContext = null;
        AppMethodBeat.o(187020);
    }
}
