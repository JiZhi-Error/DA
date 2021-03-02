package com.tencent.mm.plugin.appbrand.launching;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public enum ax {
    ;

    public static ax valueOf(String str) {
        AppMethodBeat.i(47315);
        ax axVar = (ax) Enum.valueOf(ax.class, str);
        AppMethodBeat.o(47315);
        return axVar;
    }

    public static void a(int i2, aa aaVar) {
        AppMethodBeat.i(227096);
        a(MMApplicationContext.getResources().getString(i2), aaVar);
        AppMethodBeat.o(227096);
    }

    public static void a(final String str, aa aaVar) {
        AppMethodBeat.i(227097);
        Log.e("MicroMsg.AppBrand.PrepareQuickAccess", "toast: %s, step:%s", str, aaVar.getClass().getName());
        if (!aaVar.bNh()) {
            AppMethodBeat.o(227097);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.launching.ax.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(47313);
                Toast.makeText(MMApplicationContext.getContext(), str, 0).show();
                AppMethodBeat.o(47313);
            }
        });
        AppMethodBeat.o(227097);
    }

    public static String getMMString(int i2, Object... objArr) {
        AppMethodBeat.i(47318);
        String mMString = f.getMMString(i2, objArr);
        AppMethodBeat.o(47318);
        return mMString;
    }
}
