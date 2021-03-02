package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

public final class o {
    public static void showToast(String str) {
        AppMethodBeat.i(6184);
        fh("MicroMsg.PreloadUtil", str);
        AppMethodBeat.o(6184);
    }

    public static void fh(String str, final String str2) {
        AppMethodBeat.i(6185);
        if (Log.getLogLevel() == 0 && WeChatEnvironment.hasDebugger()) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.preload.o.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(6183);
                    Toast.makeText(MMApplicationContext.getContext(), str2, 0).show();
                    AppMethodBeat.o(6183);
                }
            });
        }
        Log.i(str, str2);
        AppMethodBeat.o(6185);
    }
}
