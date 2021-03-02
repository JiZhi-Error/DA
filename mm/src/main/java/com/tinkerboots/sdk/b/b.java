package com.tinkerboots.sdk.b;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static boolean lL(Context context) {
        boolean z;
        AppMethodBeat.i(3461);
        if (Build.VERSION.SDK_INT < 23) {
            AppMethodBeat.o(3461);
            return true;
        }
        boolean z2 = context.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0;
        if (context.checkSelfPermission("android.permission.INTERNET") == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z2 || !z) {
            AppMethodBeat.o(3461);
            return false;
        }
        AppMethodBeat.o(3461);
        return true;
    }
}
