package com.tencent.xweb;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

public final class ai {
    static String SAR;
    static boolean SAS = true;
    static boolean SAT;

    public static synchronized void bss(String str) {
        synchronized (ai.class) {
            AppMethodBeat.i(219061);
            XWalkEnvironment.addXWalkInitializeLog("XWebUpdaterSetting", "setEmbedInstallLibDir: ".concat(String.valueOf(str)));
            SAR = str;
            AppMethodBeat.o(219061);
        }
    }

    public static synchronized String hti() {
        String str;
        synchronized (ai.class) {
            AppMethodBeat.i(219062);
            if (!TextUtils.isEmpty(SAR)) {
                str = SAR;
                AppMethodBeat.o(219062);
            } else {
                str = XWalkEnvironment.getApplicationContext().getApplicationInfo().nativeLibraryDir;
                AppMethodBeat.o(219062);
            }
        }
        return str;
    }

    public static synchronized void Ek(boolean z) {
        synchronized (ai.class) {
            AppMethodBeat.i(219063);
            XWalkEnvironment.addXWalkInitializeLog("XWebUpdaterSetting", "setIsEmbedDirReady: ".concat(String.valueOf(z)));
            SAS = z;
            AppMethodBeat.o(219063);
        }
    }

    public static synchronized void El(boolean z) {
        synchronized (ai.class) {
            AppMethodBeat.i(219064);
            XWalkEnvironment.addXWalkInitializeLog("XWebUpdaterSetting", "setForbidDownloadCode: ".concat(String.valueOf(z)));
            SAT = z;
            AppMethodBeat.o(219064);
        }
    }

    public static synchronized boolean htj() {
        boolean z;
        synchronized (ai.class) {
            z = SAT;
        }
        return z;
    }
}
