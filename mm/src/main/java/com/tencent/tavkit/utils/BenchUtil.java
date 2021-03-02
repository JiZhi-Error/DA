package com.tencent.tavkit.utils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class BenchUtil {
    public static boolean ENABLE_DEBUG = false;
    private static final String TAG = "BenchUtil";
    private static Map<String, Long> endTimeMap = new HashMap();
    private static Map<String, Long> startTimeMap = new HashMap();

    static {
        AppMethodBeat.i(197663);
        AppMethodBeat.o(197663);
    }

    public static void clear() {
        AppMethodBeat.i(197660);
        startTimeMap.clear();
        endTimeMap.clear();
        AppMethodBeat.o(197660);
    }

    public static void benchStart(String str) {
        AppMethodBeat.i(197661);
        if (ENABLE_DEBUG && !TextUtils.isEmpty(str)) {
            startTimeMap.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        AppMethodBeat.o(197661);
    }

    public static long benchEnd(String str) {
        AppMethodBeat.i(197662);
        if (!ENABLE_DEBUG || TextUtils.isEmpty(str) || startTimeMap == null) {
            AppMethodBeat.o(197662);
            return 0;
        }
        Long l = startTimeMap.get(str);
        if (l == null) {
            AppMethodBeat.o(197662);
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - l.longValue();
        new StringBuilder().append(str).append(", cost time: ").append(currentTimeMillis);
        AppMethodBeat.o(197662);
        return currentTimeMillis;
    }

    public static void setEnableDebugLog(boolean z) {
        ENABLE_DEBUG = z;
    }
}
