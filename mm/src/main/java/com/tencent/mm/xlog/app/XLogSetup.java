package com.tencent.mm.xlog.app;

import android.os.Looper;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class XLogSetup {
    public static Boolean appendIsSync;
    public static String cachePath;
    public static boolean hasInit = false;
    public static Boolean isLogcatOpen;
    public static String logPath;
    public static String nameprefix;
    private static boolean setup = false;
    public static Integer toolsLevel;
    public static Xlog xlog = new Xlog();

    static {
        AppMethodBeat.i(133558);
        AppMethodBeat.o(133558);
    }

    public static void realSetupXlog() {
        AppMethodBeat.i(133556);
        keep_setupXLog(true, cachePath, logPath, toolsLevel, appendIsSync, isLogcatOpen, nameprefix);
        AppMethodBeat.o(133556);
    }

    public static void keep_setupXLog(boolean z, String str, String str2, Integer num, Boolean bool, Boolean bool2, String str3) {
        int i2 = 1;
        AppMethodBeat.i(133557);
        if (!hasInit) {
            PlatformComm.init(MMApplicationContext.getContext(), new MMHandler(Looper.getMainLooper()));
            hasInit = true;
        }
        cachePath = str;
        logPath = str2;
        toolsLevel = num;
        appendIsSync = bool;
        isLogcatOpen = bool2;
        nameprefix = str3;
        if (!z) {
            AppMethodBeat.o(133557);
        } else if (setup) {
            AppMethodBeat.o(133557);
        } else {
            setup = true;
            String str4 = a.Rza;
            XLogSetup.class.getClassLoader();
            j.Ed(str4);
            Log.setLogImp(xlog);
            Log.setConsoleLogOpen(isLogcatOpen.booleanValue());
            if (toolsLevel == null) {
                Log.appenderOpen(2, 0, cachePath, logPath, nameprefix, 3);
                LogLogic.initIPxxLogInfo();
                AppMethodBeat.o(133557);
                return;
            }
            if (!bool.booleanValue()) {
                i2 = 0;
            }
            Log.appenderOpen(toolsLevel.intValue(), i2, cachePath, logPath, nameprefix, 0);
            AppMethodBeat.o(133557);
        }
    }
}
