package com.tencent.mm.plugin.appbrand.jsapi.ui;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import org.json.JSONObject;

public final class c extends d {
    private static final int CTRL_INDEX = 580;
    private static final String NAME = "hideVirtualBottomNavigationBar";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(138276);
        d(fVar, i2);
        AppMethodBeat.o(138276);
    }

    /* access modifiers changed from: package-private */
    public final void d(final f fVar, final int i2) {
        AppMethodBeat.i(138277);
        if (!MMHandlerThread.isMainThread()) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ui.c.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(138274);
                    c.this.d(fVar, i2);
                    AppMethodBeat.o(138274);
                }
            });
            AppMethodBeat.o(138277);
            return;
        }
        Log.i("JsApiHideVirtualBottomNavigationBar", MessengerShareContentUtility.SHARE_BUTTON_HIDE);
        E(fVar);
        fVar.i(i2, h("ok", null));
        AppMethodBeat.o(138277);
    }

    private void E(f fVar) {
        AppMethodBeat.i(138278);
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(fVar.getContext());
        if (castActivityOrNull == null) {
            Log.i("JsApiHideVirtualBottomNavigationBar", "null == activity");
            AppMethodBeat.o(138278);
            return;
        }
        final Window window = castActivityOrNull.getWindow();
        if (window == null) {
            Log.i("JsApiHideVirtualBottomNavigationBar", "null == window");
            AppMethodBeat.o(138278);
            return;
        }
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        if (Build.VERSION.SDK_INT >= 20) {
            systemUiVisibility = systemUiVisibility | 512 | 2;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            systemUiVisibility |= 4096;
        }
        final int i2 = systemUiVisibility | 256;
        window.getDecorView().setSystemUiVisibility(i2);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ui.c.AnonymousClass2 */

            public final void onSystemUiVisibilityChange(int i2) {
                AppMethodBeat.i(138275);
                if ((i2 & 4) == 0) {
                    window.getDecorView().setSystemUiVisibility(i2);
                }
                AppMethodBeat.o(138275);
            }
        });
        AppMethodBeat.o(138278);
    }
}
