package com.tencent.matrix.d.c;

import android.os.Build;
import android.os.Debug;
import com.tencent.matrix.g.c;
import java.lang.reflect.Method;

public final class a {
    private static Method cWa = null;

    public static int a(String str, Debug.MemoryInfo memoryInfo) {
        if (Build.VERSION.SDK_INT < 23) {
            return -1;
        }
        try {
            if (cWa == null) {
                cWa = Class.forName("android.os.Debug$MemoryInfo").getMethod("getMemoryStat", String.class);
            }
            return Integer.parseInt((String) cWa.invoke(memoryInfo, str));
        } catch (Exception e2) {
            c.e("Matrix.DebugMemoryInfoUtil", e2.toString(), new Object[0]);
            return -1;
        }
    }

    public static int a(Debug.MemoryInfo memoryInfo) {
        if (Build.VERSION.SDK_INT < 23) {
            return -1;
        }
        return memoryInfo.dalvikPrivateDirty + memoryInfo.nativePrivateDirty + memoryInfo.otherPrivateDirty + memoryInfo.getTotalPrivateClean();
    }
}
