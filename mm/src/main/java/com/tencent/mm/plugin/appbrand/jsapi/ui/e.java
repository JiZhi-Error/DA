package com.tencent.mm.plugin.appbrand.jsapi.ui;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import org.json.JSONObject;

public final class e extends d<f> {
    private static final int CTRL_INDEX = 580;
    private static final String NAME = "showVirtualBottomNavigationBar";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(138280);
        d(fVar, i2);
        AppMethodBeat.o(138280);
    }

    /* access modifiers changed from: package-private */
    public final void d(final f fVar, final int i2) {
        AppMethodBeat.i(138281);
        if (!MMHandlerThread.isMainThread()) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ui.e.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(138279);
                    e.this.d(fVar, i2);
                    AppMethodBeat.o(138279);
                }
            });
            AppMethodBeat.o(138281);
            return;
        }
        Log.i("JsApiShowVirtualBottomNavigationBar", "show");
        E(fVar);
        fVar.i(i2, h("ok", null));
        AppMethodBeat.o(138281);
    }

    private static void E(f fVar) {
        AppMethodBeat.i(138282);
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(fVar.getContext());
        if (castActivityOrNull == null) {
            Log.i("JsApiShowVirtualBottomNavigationBar", "null == activity");
            AppMethodBeat.o(138282);
            return;
        }
        Window window = castActivityOrNull.getWindow();
        if (window == null) {
            Log.i("JsApiShowVirtualBottomNavigationBar", "null == window");
            AppMethodBeat.o(138282);
            return;
        }
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        if (Build.VERSION.SDK_INT >= 20) {
            systemUiVisibility = systemUiVisibility & -513 & -3;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            systemUiVisibility &= -4097;
        }
        window.getDecorView().setSystemUiVisibility(systemUiVisibility & -257);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(null);
        AppMethodBeat.o(138282);
    }
}
