package com.tencent.luggage.game.c;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Map;
import java.util.Objects;

public enum h {
    INST;
    
    private static String[] cvA = {"summary.native-heap", "summary.graphics"};

    public static class a {
        public int cvD;
        public int cvE;
        public int cvF;
        public int cvG;
        public int cvH;
        public int cvI;
        public int cvJ;
        public int cvK;
        public int cvL;
        public int cvM;
        public String cvN;
    }

    public static h valueOf(String str) {
        AppMethodBeat.i(130530);
        h hVar = (h) Enum.valueOf(h.class, str);
        AppMethodBeat.o(130530);
        return hVar;
    }

    static {
        AppMethodBeat.i(130532);
        AppMethodBeat.o(130532);
    }

    public static a Md() {
        Debug.MemoryInfo memoryInfo;
        Debug.MemoryInfo[] processMemoryInfo;
        AppMethodBeat.i(130531);
        int myPid = Process.myPid();
        a aVar = new a();
        ActivityManager activityManager = (ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (activityManager == null || (processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{myPid})) == null || processMemoryInfo.length <= 0) {
            memoryInfo = null;
        } else {
            memoryInfo = processMemoryInfo[0];
        }
        if (memoryInfo != null) {
            aVar.cvD = memoryInfo.getTotalPss() / 1024;
            aVar.cvE = memoryInfo.nativePss / 1024;
            aVar.cvF = memoryInfo.dalvikPss / 1024;
            if (Build.VERSION.SDK_INT >= 23) {
                aVar.cvG = Util.safeParseInt(memoryInfo.getMemoryStat("summary.graphics")) / 1024;
                aVar.cvH = Util.safeParseInt(memoryInfo.getMemoryStat("summary.system")) / 1024;
                aVar.cvI = Util.safeParseInt(memoryInfo.getMemoryStat("summary.total-swap")) / 1024;
                aVar.cvJ = Util.safeParseInt(memoryInfo.getMemoryStat("summary.java-heap")) / 1024;
                aVar.cvK = Util.safeParseInt(memoryInfo.getMemoryStat("summary.private-other")) / 1024;
                aVar.cvL = Util.safeParseInt(memoryInfo.getMemoryStat("summary.code")) / 1024;
                aVar.cvM = Util.safeParseInt(memoryInfo.getMemoryStat("summary.stack")) / 1024;
                StringBuilder sb = new StringBuilder(100);
                Map<String, String> memoryStats = memoryInfo.getMemoryStats();
                for (String str : memoryStats.keySet()) {
                    if (!Util.isNullOrNil(str) && com.tencent.mm.compatible.loader.a.contains(cvA, str)) {
                        sb.append(str).append(":").append(Util.safeParseInt((String) Objects.requireNonNull(memoryStats.get(str))) / 1024).append("m ").append(System.getProperty("line.separator"));
                    }
                }
                aVar.cvN = sb.toString();
            }
        }
        AppMethodBeat.o(130531);
        return aVar;
    }
}
