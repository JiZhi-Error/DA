package com.tencent.mm.ui.base;

import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;

public final class aa {
    public static int OWJ = -1;

    public static void activateBroadcast(boolean z) {
        AppMethodBeat.i(142454);
        d(z, null);
        AppMethodBeat.o(142454);
    }

    public static void d(boolean z, Intent intent) {
        AppMethodBeat.i(142455);
        if (!BA(z)) {
            Log.w("MicroMsg.UIStatusUtil", "isRealSend = false,just return!");
            AppMethodBeat.o(142455);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        intent.setAction(z ? "com.tencent.mm.ui.ACTION_ACTIVE" : "com.tencent.mm.ui.ACTION_DEACTIVE");
        intent.putExtra(MMApplicationContext.INTENT_PROCESS_NAME, MMApplicationContext.getProcessName());
        intent.putExtra("process_id", Process.myPid());
        intent.putExtra("process_is_mm", MMApplicationContext.isMMProcess());
        MMApplicationContext.getContext().sendBroadcast(intent, WeChatPermissions.PERMISSION_MM_MESSAGE());
        AppMethodBeat.o(142455);
    }

    private static boolean BA(boolean z) {
        int i2;
        boolean z2 = true;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (OWJ == i2) {
            z2 = false;
        }
        OWJ = i2;
        return z2;
    }
}
