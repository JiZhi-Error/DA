package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.model.ad;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.ac.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.d;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class AppBrandProcessSuicideLogic extends a {
    private static final AppBrandProcessSuicideLogic kIu = new AppBrandProcessSuicideLogic();
    private final AtomicInteger kIv = new AtomicInteger(0);
    private final AtomicBoolean kIw = new AtomicBoolean();
    private final Set<Activity> kIx = new HashSet();

    public static void c(Application application) {
        AppMethodBeat.i(44118);
        application.registerActivityLifecycleCallbacks(kIu);
        AppMethodBeat.o(44118);
    }

    public static void C(Activity activity) {
        AppMethodBeat.i(226305);
        AppBrandProcessSuicideLogic appBrandProcessSuicideLogic = kIu;
        if (appBrandProcessSuicideLogic.kIx.add(activity)) {
            appBrandProcessSuicideLogic.kIv.incrementAndGet();
        }
        AppMethodBeat.o(226305);
    }

    static {
        AppMethodBeat.i(44125);
        AppMethodBeat.o(44125);
    }

    private AppBrandProcessSuicideLogic() {
        AppMethodBeat.i(44119);
        AppMethodBeat.o(44119);
    }

    public static void bup() {
        AppMethodBeat.i(44120);
        kIu.kIw.set(true);
        AppMethodBeat.o(44120);
    }

    @Override // com.tencent.mm.plugin.appbrand.ac.a
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AppMethodBeat.i(44121);
        this.kIw.set(false);
        if (this.kIx.add(activity)) {
            this.kIv.incrementAndGet();
        }
        AppMethodBeat.o(44121);
    }

    @Override // com.tencent.mm.plugin.appbrand.ac.a
    public final void onActivityStopped(Activity activity) {
        AppMethodBeat.i(226306);
        super.onActivityStopped(activity);
        if ((activity instanceof AppBrandUI) && activity.isFinishing()) {
            d dVar = d.nGE;
            d.aB("onActivityStopped", false);
        }
        AppMethodBeat.o(226306);
    }

    @Override // com.tencent.mm.plugin.appbrand.ac.a
    public final void onActivityDestroyed(Activity activity) {
        AppMethodBeat.i(44122);
        if ((this.kIx.remove(activity) ? this.kIv.decrementAndGet() : this.kIv.get()) == 0) {
            final Class<?> cls = activity.getClass();
            h.RTc.e(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(44112);
                    AppBrandProcessSuicideLogic.a(AppBrandProcessSuicideLogic.this, cls);
                    AppMethodBeat.o(44112);
                }
            }, "CleanupWhenNoActivitiesAliveInAppBrandProcess");
        }
        AppMethodBeat.o(44122);
    }

    public static void a(AppBrandUI appBrandUI, String str) {
        AppMethodBeat.i(226307);
        RebootProcessAndTask rebootProcessAndTask = new RebootProcessAndTask();
        rebootProcessAndTask.mProcessName = MMApplicationContext.getProcessName();
        Pair<AppBrandInitConfigWC, AppBrandStatObject> P = AppBrandUI.P(appBrandUI.getIntent());
        rebootProcessAndTask.kID = (AppBrandInitConfigWC) P.first;
        rebootProcessAndTask.kEH = (AppBrandStatObject) P.second;
        rebootProcessAndTask.cXS = str;
        AppBrandMainProcessService.b(rebootProcessAndTask);
        com.tencent.mm.hellhoundlib.b.a a2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        Object obj = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "java/lang/System_EXEC_", "exit", "(I)V");
        System.exit(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "java/lang/System_EXEC_", "exit", "(I)V");
        com.tencent.mm.hellhoundlib.b.a a3 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object obj2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(obj2, a3.axQ(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer) a3.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(obj2, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(226307);
    }

    public static class RebootProcessAndTask extends MainProcessTask {
        public static final Parcelable.Creator<RebootProcessAndTask> CREATOR = new Parcelable.Creator<RebootProcessAndTask>() {
            /* class com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic.RebootProcessAndTask.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ RebootProcessAndTask[] newArray(int i2) {
                return new RebootProcessAndTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RebootProcessAndTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(226300);
                RebootProcessAndTask rebootProcessAndTask = new RebootProcessAndTask();
                rebootProcessAndTask.f(parcel);
                AppMethodBeat.o(226300);
                return rebootProcessAndTask;
            }
        };
        public String cXS;
        public AppBrandStatObject kEH;
        public AppBrandInitConfigWC kID;
        public String mProcessName;

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(226301);
            b.Lm(this.mProcessName);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic.RebootProcessAndTask.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(226299);
                    Toast.makeText(MMApplicationContext.getContext(), RebootProcessAndTask.this.cXS, 1).show();
                    com.tencent.mm.plugin.appbrand.task.h.bWb().g(RebootProcessAndTask.this.kID, RebootProcessAndTask.this.kEH);
                    AppMethodBeat.o(226299);
                }
            }, 500);
            AppMethodBeat.o(226301);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(226302);
            parcel.writeString(this.mProcessName);
            parcel.writeParcelable(this.kID, i2);
            parcel.writeParcelable(this.kEH, i2);
            parcel.writeString(this.cXS);
            AppMethodBeat.o(226302);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(226303);
            this.mProcessName = parcel.readString();
            this.kID = (AppBrandInitConfigWC) parcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader());
            this.kEH = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
            this.cXS = parcel.readString();
            AppMethodBeat.o(226303);
        }

        static {
            AppMethodBeat.i(226304);
            AppMethodBeat.o(226304);
        }
    }

    public static void buq() {
        AppMethodBeat.i(44123);
        ProcessRestartTask processRestartTask = new ProcessRestartTask();
        processRestartTask.mProcessName = MMApplicationContext.getProcessName();
        processRestartTask.kIB = e.bVP();
        AppBrandMainProcessService.b(processRestartTask);
        com.tencent.mm.hellhoundlib.b.a a2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        Object obj = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
        System.exit(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
        com.tencent.mm.hellhoundlib.b.a a3 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object obj2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(obj2, a3.axQ(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer) a3.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(obj2, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(44123);
    }

    public static class ProcessRestartTask extends MainProcessTask {
        public static final Parcelable.Creator<ProcessRestartTask> CREATOR = new Parcelable.Creator<ProcessRestartTask>() {
            /* class com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic.ProcessRestartTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ProcessRestartTask[] newArray(int i2) {
                return new ProcessRestartTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ProcessRestartTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(44113);
                ProcessRestartTask processRestartTask = new ProcessRestartTask();
                processRestartTask.f(parcel);
                AppMethodBeat.o(44113);
                return processRestartTask;
            }
        };
        public String kIA;
        public g[] kIB;
        public int kIC;
        public String mProcessName;

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(44114);
            b.Lm(this.mProcessName);
            for (g gVar : this.kIB) {
                com.tencent.mm.plugin.appbrand.task.h.bWb().a(this.kIA, gVar);
            }
            AppMethodBeat.o(44114);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(44115);
            parcel.writeString(this.mProcessName);
            parcel.writeString(this.kIA);
            parcel.writeInt(this.kIB.length);
            int[] iArr = new int[this.kIB.length];
            for (int i3 = 0; i3 < this.kIB.length; i3++) {
                iArr[i3] = this.kIB[i3].code;
            }
            parcel.writeIntArray(iArr);
            AppMethodBeat.o(44115);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(44116);
            this.mProcessName = parcel.readString();
            this.kIA = parcel.readString();
            this.kIC = parcel.readInt();
            this.kIB = new g[this.kIC];
            try {
                int[] iArr = new int[this.kIC];
                parcel.readIntArray(iArr);
                for (int i2 = 0; i2 < this.kIB.length; i2++) {
                    this.kIB[i2] = g.zm(iArr[i2]);
                }
                AppMethodBeat.o(44116);
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrandProcessSuicideLogic", "ProcessRestartTask.parseFromParcel, deserialize mPreloadType get exception:%s", e2);
                Arrays.fill(this.kIB, g.NIL);
                AppMethodBeat.o(44116);
            }
        }

        static {
            AppMethodBeat.i(44117);
            AppMethodBeat.o(44117);
        }
    }

    static /* synthetic */ void a(AppBrandProcessSuicideLogic appBrandProcessSuicideLogic, Class cls) {
        boolean z;
        AppMethodBeat.i(44124);
        i.bUu();
        try {
            KVCommCrossProcessReceiver.eOD();
            com.tencent.mm.plugin.appbrand.report.a.iA(true);
            d dVar = d.nGE;
            d.aB("cleanupAndSuicideInWorker", false);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandProcessSuicideLogic", e2, "sendKV", new Object[0]);
        }
        if (!DebuggerShell.bAx() || !DebuggerShell.bAz()) {
            if (!k.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            boolean bug = a.bug();
            Log.i("MicroMsg.AppBrandProcessSuicideLogic", "before suicide, dump DataCenter %s", ad.aVe().toString());
            Log.i("MicroMsg.AppBrandProcessSuicideLogic", "before suicide, last activity is %s", cls.getName());
            Log.i("MicroMsg.AppBrandProcessSuicideLogic", "before suicide, mActivityRecreatingByConfigurationChanged %B", Boolean.valueOf(appBrandProcessSuicideLogic.kIw.get()));
            Log.i("MicroMsg.AppBrandProcessSuicideLogic", "before suicide, hasPersistentRuntimes %B", Boolean.valueOf(z));
            Log.i("MicroMsg.AppBrandProcessSuicideLogic", "before suicide, hasPendingLaunchActivity %B", Boolean.valueOf(bug));
            Log.appenderFlushSync();
            if (!appBrandProcessSuicideLogic.kIw.get()) {
                if (z || bug) {
                    AppMethodBeat.o(44124);
                    return;
                } else if (appBrandProcessSuicideLogic.kIv.get() <= 0) {
                    com.tencent.mm.plugin.appbrand.debugger.b.bAD();
                    if (AppBrandUI.class.isAssignableFrom(cls)) {
                        ProcessRestartTask processRestartTask = new ProcessRestartTask();
                        processRestartTask.mProcessName = MMApplicationContext.getProcessName();
                        processRestartTask.kIA = cls.getName();
                        processRestartTask.kIB = e.bVP();
                        AppBrandMainProcessService.b(processRestartTask);
                    }
                    com.tencent.mm.hellhoundlib.b.a a2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                    Object obj = new Object();
                    com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "cleanupAndSuicideInWorker", "(Ljava/lang/Class;)V", "java/lang/System_EXEC_", "exit", "(I)V");
                    System.exit(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "cleanupAndSuicideInWorker", "(Ljava/lang/Class;)V", "java/lang/System_EXEC_", "exit", "(I)V");
                }
            }
        }
        AppMethodBeat.o(44124);
    }
}
