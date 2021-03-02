package com.tencent.mm.plugin.appbrand.game.h;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0004H\u0002¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/game/util/WAGameSelfRestart;", "", "()V", "prepare_restart", "", "selfRestart", "suicide", "plugin-appbrand-integration_release"})
public final class a {
    public static final a lvA = new a();

    static {
        AppMethodBeat.i(50397);
        AppMethodBeat.o(50397);
    }

    private a() {
    }

    public static void suicide() {
        AppMethodBeat.i(50395);
        Object systemService = MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.ActivityManager");
            AppMethodBeat.o(50395);
            throw tVar;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
        p.g(runningAppProcesses, "am.runningAppProcesses");
        for (T t : runningAppProcesses) {
            String str = ((ActivityManager.RunningAppProcessInfo) t).processName;
            p.g(str, "it.processName");
            if (n.e(str, MMApplicationContext.getPackageName() + ":")) {
                com.tencent.mm.hellhoundlib.b.a a2 = c.a(((ActivityManager.RunningAppProcessInfo) t).pid, new com.tencent.mm.hellhoundlib.b.a());
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/plugin/appbrand/game/util/WAGameSelfRestart", "suicide", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                Process.killProcess(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/appbrand/game/util/WAGameSelfRestart", "suicide", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            }
        }
        com.tencent.mm.hellhoundlib.b.a a3 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object obj2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(obj2, a3.axQ(), "com/tencent/mm/plugin/appbrand/game/util/WAGameSelfRestart", "suicide", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer) a3.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(obj2, "com/tencent/mm/plugin/appbrand/game/util/WAGameSelfRestart", "suicide", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(50395);
    }

    public static void bDC() {
        AppMethodBeat.i(50396);
        Context context = MMApplicationContext.getContext();
        p.g(context, "context");
        PendingIntent activity = PendingIntent.getActivity(context, -1, context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()), 268435456);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            p.hyc();
        }
        alarmManager.set(1, System.currentTimeMillis() + 100, activity);
        AppMethodBeat.o(50396);
    }
}
