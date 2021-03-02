package com.tencent.mm.gpu.f;

import android.app.ActivityManager;
import android.os.Debug;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.reflect.Field;

public final class a {
    private int[] hjC = null;

    public a() {
        AppMethodBeat.i(186208);
        ActivityManager activityManager = (ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (activityManager == null) {
            AppMethodBeat.o(186208);
            return;
        }
        Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()});
        if (processMemoryInfo == null || processMemoryInfo.length == 0) {
            AppMethodBeat.o(186208);
            return;
        }
        Debug.MemoryInfo memoryInfo = processMemoryInfo[0];
        if (memoryInfo == null) {
            AppMethodBeat.o(186208);
            return;
        }
        this.hjC = b(memoryInfo);
        AppMethodBeat.o(186208);
    }

    public final int axu() {
        int i2 = 0;
        AppMethodBeat.i(186209);
        if (this.hjC == null) {
            Log.e("Gpu.GpuMemoryGetter", "getGfx fail, because otherStats == null");
            AppMethodBeat.o(186209);
        } else {
            try {
                i2 = f(this.hjC, 4);
                AppMethodBeat.o(186209);
            } catch (Exception e2) {
                Log.e("Gpu.GpuMemoryGetter", "getGfx fail, because getOtherPrivate fail");
                AppMethodBeat.o(186209);
            }
        }
        return i2;
    }

    public final int axv() {
        int i2 = 0;
        AppMethodBeat.i(186210);
        if (this.hjC == null) {
            Log.e("Gpu.GpuMemoryGetter", "getEGL fail, because otherStats == null");
            AppMethodBeat.o(186210);
        } else {
            try {
                i2 = f(this.hjC, 14);
                AppMethodBeat.o(186210);
            } catch (Exception e2) {
                Log.e("Gpu.GpuMemoryGetter", "getEGL fail, because getOtherPrivate fail");
                AppMethodBeat.o(186210);
            }
        }
        return i2;
    }

    public final int axw() {
        int i2 = 0;
        AppMethodBeat.i(186211);
        if (this.hjC == null) {
            Log.e("Gpu.GpuMemoryGetter", "getGL fail, because getOtherStats == null");
            AppMethodBeat.o(186211);
        } else {
            try {
                i2 = f(this.hjC, 15);
                AppMethodBeat.o(186211);
            } catch (Exception e2) {
                Log.e("Gpu.GpuMemoryGetter", "getGL fail, because getOtherStats == null");
                AppMethodBeat.o(186211);
            }
        }
        return i2;
    }

    private static int[] b(Debug.MemoryInfo memoryInfo) {
        AppMethodBeat.i(186212);
        try {
            Field declaredField = Class.forName("android.os.Debug$MemoryInfo").getDeclaredField("otherStats");
            declaredField.setAccessible(true);
            int[] iArr = (int[]) declaredField.get(memoryInfo);
            AppMethodBeat.o(186212);
            return iArr;
        } catch (Exception e2) {
            Log.e("Gpu.GpuMemoryGetter", "getOtherStatsByReflect fail");
            AppMethodBeat.o(186212);
            return null;
        }
    }

    private static int f(int[] iArr, int i2) {
        AppMethodBeat.i(186213);
        int h2 = h(iArr, i2) + g(iArr, i2);
        AppMethodBeat.o(186213);
        return h2;
    }

    private static int g(int[] iArr, int i2) {
        return iArr[(i2 * 9) + 3];
    }

    private static int h(int[] iArr, int i2) {
        return iArr[(i2 * 9) + 5];
    }
}
