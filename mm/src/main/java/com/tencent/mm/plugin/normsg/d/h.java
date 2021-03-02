package com.tencent.mm.plugin.normsg.d;

import android.app.ActivityManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.reflect.Field;
import java.util.List;

public final class h {
    public static boolean AGq;

    static {
        AppMethodBeat.i(149094);
        AGq = false;
        long nanoTime = System.nanoTime();
        try {
            AGq = false;
            if (Build.VERSION.SDK_INT < 21) {
                AGq = false;
            } else {
                Field declaredField = ActivityManager.RecentTaskInfo.class.getDeclaredField("instanceId");
                declaredField.setAccessible(true);
                List<ActivityManager.RecentTaskInfo> recentTasks = ((ActivityManager) MMApplicationContext.getContext().getApplicationContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRecentTasks(1, 2);
                if (recentTasks == null || recentTasks.size() == 0) {
                    AGq = false;
                } else if (declaredField.getInt(recentTasks.get(0)) > 0) {
                    AGq = true;
                }
            }
            Log.i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", Boolean.valueOf(AGq), Long.valueOf(System.nanoTime() - nanoTime));
            AppMethodBeat.o(149094);
        } catch (Throwable th) {
            Log.i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", Boolean.valueOf(AGq), Long.valueOf(System.nanoTime() - nanoTime));
            AppMethodBeat.o(149094);
            throw th;
        }
    }
}
