package com.tencent.mm.sdk.platformtools;

import android.content.Intent;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ServiceHelper {
    public static void startService(Intent intent) {
        AppMethodBeat.i(215436);
        if (Build.VERSION.SDK_INT >= 26) {
            MMApplicationContext.getContext().startForegroundService(intent);
            AppMethodBeat.o(215436);
            return;
        }
        MMApplicationContext.getContext().startService(intent);
        AppMethodBeat.o(215436);
    }
}
