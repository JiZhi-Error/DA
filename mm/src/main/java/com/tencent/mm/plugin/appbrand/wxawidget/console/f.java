package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class f {
    public static boolean dm(View view) {
        boolean z;
        AppMethodBeat.i(121658);
        if (view == null) {
            AppMethodBeat.o(121658);
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.o(121658);
            return false;
        }
        IBinder windowToken = view.getWindowToken();
        if (windowToken == null) {
            AppMethodBeat.o(121658);
            return false;
        }
        try {
            z = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e2) {
            Log.e("MicroMsg.InputMethodHelper", "hide VKB(View) exception %s", e2);
            z = false;
        }
        AppMethodBeat.o(121658);
        return z;
    }
}
