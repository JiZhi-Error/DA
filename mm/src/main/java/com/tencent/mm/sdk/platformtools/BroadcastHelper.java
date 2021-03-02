package com.tencent.mm.sdk.platformtools;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;

public class BroadcastHelper {
    private static final String TAG = "MicroMsg.BroadcastHelper";

    public static void setIntentPackageName(Intent intent) {
        AppMethodBeat.i(156176);
        if (d.oD(26)) {
            intent.setPackage(MMApplicationContext.getPackageName());
        }
        AppMethodBeat.o(156176);
    }
}
