package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.r;

public final class d extends r {
    public static Activity kD(Context context) {
        AppMethodBeat.i(259296);
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(context);
        AppMethodBeat.o(259296);
        return castActivityOrNull;
    }

    public static boolean f(Window window) {
        AppMethodBeat.i(133826);
        if (window == null || window.getDecorView() == null) {
            AppMethodBeat.o(133826);
            return false;
        } else if (Build.VERSION.SDK_INT < 23 || (window.getDecorView().getSystemUiVisibility() & 8192) == 0) {
            AppMethodBeat.o(133826);
            return false;
        } else {
            AppMethodBeat.o(133826);
            return true;
        }
    }

    public static void e(Window window) {
        AppMethodBeat.i(133827);
        if (window == null) {
            AppMethodBeat.o(133827);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
        AppMethodBeat.o(133827);
    }
}
