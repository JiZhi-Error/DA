package com.tencent.mm.plugin.s;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.e;

public final class a {
    private static final Application.ActivityLifecycleCallbacks ARR = new com.tencent.mm.plugin.appbrand.ac.a() {
        /* class com.tencent.mm.plugin.s.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.ac.a
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            AppMethodBeat.i(116064);
            try {
                if (Util.nullAsNil(activity.getLocalClassName()).contains("WebView")) {
                    Object[] objArr = new Object[2];
                    objArr[0] = activity.getLocalClassName();
                    objArr[1] = activity.getIntent() == null ? null : activity.getIntent().getStringExtra(e.p.OzI);
                    Log.i("MicroMsg.WxPayAdUxInfoTracer", "onActivityCreated-%s, adUxInfo=%s", objArr);
                }
                AppMethodBeat.o(116064);
            } catch (Exception e2) {
                AppMethodBeat.o(116064);
            }
        }
    };

    static {
        AppMethodBeat.i(116071);
        AppMethodBeat.o(116071);
    }

    public static void m(Application application) {
        AppMethodBeat.i(116065);
        application.registerActivityLifecycleCallbacks(ARR);
        AppMethodBeat.o(116065);
    }

    public static void p(String str, Object... objArr) {
        AppMethodBeat.i(116066);
        Log.i("MicroMsg.WxPayAdUxInfoTracer", "trace: ".concat(String.valueOf(str)), objArr);
        AppMethodBeat.o(116066);
    }

    public static void a(String str, PersistableBundle persistableBundle) {
        AppMethodBeat.i(116067);
        a("onCreate", str, persistableBundle);
        AppMethodBeat.o(116067);
    }

    public static void b(String str, PersistableBundle persistableBundle) {
        AppMethodBeat.i(116068);
        a("onNewConfig", str, persistableBundle);
        AppMethodBeat.o(116068);
    }

    private static void a(String str, String str2, PersistableBundle persistableBundle) {
        String string;
        AppMethodBeat.i(116069);
        Object[] objArr = new Object[3];
        objArr[0] = str2;
        objArr[1] = str;
        if (persistableBundle == null) {
            string = null;
        } else {
            string = persistableBundle.getString("adUxInfo");
        }
        objArr[2] = string;
        Log.i("MicroMsg.WxPayAdUxInfoTracer", "AppBrandRuntime(%s)-%s, adUxInfo=%s", objArr);
        AppMethodBeat.o(116069);
    }

    public static void x(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(116070);
        Log.i("MicroMsg.WxPayAdUxInfoTracer", "trace: scene[%s] api[%s] udUxInfo[%s] source[%s]", str, str2, str3, str4);
        AppMethodBeat.o(116070);
    }
}
