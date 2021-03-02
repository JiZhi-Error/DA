package com.tencent.mm.sdk.platformtools;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.app.x;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SuppressLint({"NewApi"})
public final class StartupCostReporter {
    private static final Application.ActivityLifecycleCallbacks ACTIVITY_LIFECYCLE_CALLBACKS = new Application.ActivityLifecycleCallbacks() {
        /* class com.tencent.mm.sdk.platformtools.StartupCostReporter.AnonymousClass1 */

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
            r0.putExtra(com.tencent.mm.sdk.platformtools.StartupCostReporter.INTENT_KEY_CREATE_TS, java.lang.System.currentTimeMillis());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(215442);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
            r0 = r6.getIntent();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
            if (r0 == null) goto L_0x002a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onActivityCreated(android.app.Activity r6, android.os.Bundle r7) {
            /*
                r5 = this;
                r4 = 215442(0x34992, float:3.01899E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                boolean[] r1 = com.tencent.mm.sdk.platformtools.StartupCostReporter.access$000()
                monitor-enter(r1)
                boolean[] r0 = com.tencent.mm.sdk.platformtools.StartupCostReporter.access$000()     // Catch:{ all -> 0x002e }
                r2 = 0
                boolean r0 = r0[r2]     // Catch:{ all -> 0x002e }
                if (r0 == 0) goto L_0x0019
                monitor-exit(r1)     // Catch:{ all -> 0x002e }
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x0018:
                return
            L_0x0019:
                monitor-exit(r1)
                android.content.Intent r0 = r6.getIntent()
                if (r0 == 0) goto L_0x002a
                long r2 = java.lang.System.currentTimeMillis()
                java.lang.String r1 = "scr_key_create_timestamp"
                r0.putExtra(r1, r2)
            L_0x002a:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x0018
            L_0x002e:
                r0 = move-exception
                monitor-exit(r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.StartupCostReporter.AnonymousClass1.onActivityCreated(android.app.Activity, android.os.Bundle):void");
        }

        public final void onActivityStarted(Activity activity) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
            r0 = r5.getWindow();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
            if (r0 != null) goto L_0x0030;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002c, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(215443);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
            r0 = r0.getDecorView();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
            if (r0 != null) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(215443);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
            r0.addOnAttachStateChangeListener(new com.tencent.mm.sdk.platformtools.StartupCostReporter.AnonymousClass1.AnonymousClass1(r4));
            com.tencent.matrix.trace.core.AppMethodBeat.o(215443);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
            if (r5 != null) goto L_0x0026;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(215443);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onActivityResumed(final android.app.Activity r5) {
            /*
                r4 = this;
                r3 = 215443(0x34993, float:3.019E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                boolean[] r1 = com.tencent.mm.sdk.platformtools.StartupCostReporter.access$000()
                monitor-enter(r1)
                boolean[] r0 = com.tencent.mm.sdk.platformtools.StartupCostReporter.access$000()     // Catch:{ all -> 0x0020 }
                r2 = 0
                boolean r0 = r0[r2]     // Catch:{ all -> 0x0020 }
                if (r0 == 0) goto L_0x0019
                monitor-exit(r1)     // Catch:{ all -> 0x0020 }
                com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            L_0x0018:
                return
            L_0x0019:
                monitor-exit(r1)
                if (r5 != 0) goto L_0x0026
                com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                goto L_0x0018
            L_0x0020:
                r0 = move-exception
                monitor-exit(r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                throw r0
            L_0x0026:
                android.view.Window r0 = r5.getWindow()
                if (r0 != 0) goto L_0x0030
                com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                goto L_0x0018
            L_0x0030:
                android.view.View r0 = r0.getDecorView()
                if (r0 != 0) goto L_0x003a
                com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                goto L_0x0018
            L_0x003a:
                com.tencent.mm.sdk.platformtools.StartupCostReporter$1$1 r1 = new com.tencent.mm.sdk.platformtools.StartupCostReporter$1$1
                r1.<init>(r0, r5)
                r0.addOnAttachStateChangeListener(r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                goto L_0x0018
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.StartupCostReporter.AnonymousClass1.onActivityResumed(android.app.Activity):void");
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }
    };
    private static final Application[] APPLICATION = {null};
    private static final String CURRENT_PROCESS_NAME = d.cQi;
    private static final boolean[] HAS_MET_FIRST_UI = {false};
    private static final int IDKEY_ID = 1557;
    private static final int IDKEY_KEY_APPBRAND_COLD_STARTUP_COST_TIMEOUT = 38;
    private static final int IDKEY_KEY_APPBRAND_WARM_STARTUP_COST_TIMEOUT = 39;
    private static final int IDKEY_KEY_CONCERNED_PROCESS_REPORT_COUNT = 31;
    private static final int IDKEY_KEY_INSTALL_FAILURE = 40;
    private static final int IDKEY_KEY_MM_COLD_STARTUP_COST_TIMEOUT = 32;
    private static final int IDKEY_KEY_MM_WARM_STARTUP_COST_TIMEOUT = 33;
    private static final int IDKEY_KEY_REPORT_COUNT = 30;
    private static final int IDKEY_KEY_TOOLSMP_COLD_STARTUP_COST_TIMEOUT = 36;
    private static final int IDKEY_KEY_TOOLSMP_WARM_STARTUP_COST_TIMEOUT = 37;
    private static final int IDKEY_KEY_TOOLS_COLD_STARTUP_COST_TIMEOUT = 34;
    private static final int IDKEY_KEY_TOOLS_WARM_STARTUP_COST_TIMEOUT = 35;
    private static final Set<String> IGNORED_ACTIVITIES = Collections.unmodifiableSet(new HashSet(Arrays.asList("com.tencent.mm.splash.SplashHackActivity", "com.tencent.mm.app.WeChatSplashActivity")));
    private static final Instrumentation[] INSTRUMENTATION = {null};
    private static final String INTENT_KEY_CREATE_TS = "scr_key_create_timestamp";
    private static final boolean[] IS_COLD_START = {false};
    private static final boolean[] IS_INSTALLED = {false};
    private static final int KVSTAT_ID = 21381;
    private static final int KVSTAT_TYPEID_FIRST_UI_SHOWN_COLD = -268435455;
    private static final int KVSTAT_TYPEID_FIRST_UI_SHOWN_WARM = -268435454;
    private static final PeriodRecorder REPORT_PERIOD_LIMIT = new PeriodRecorder("StartupCostReporter_kvstat", TimeUnit.HOURS.toMillis(1), true, true);
    private static final long[] STARTUP_BEGIN_TS = {-1};
    private static final String TAG = "MicroMsg.StartupCostReporter";

    static /* synthetic */ void access$100(Activity activity) {
        AppMethodBeat.i(215453);
        reportDurationToFirstUIShown(activity);
        AppMethodBeat.o(215453);
    }

    static {
        AppMethodBeat.i(215454);
        AppMethodBeat.o(215454);
    }

    public static void install(Application application) {
        AppMethodBeat.i(215444);
        synchronized (IS_INSTALLED) {
            try {
                if (!isInstalled()) {
                    try {
                        setApplication(application);
                        application.registerActivityLifecycleCallbacks(ACTIVITY_LIFECYCLE_CALLBACKS);
                        IS_INSTALLED[0] = true;
                    } catch (Throwable th) {
                        x.a(TAG, th, "[-] [%s] installed failed.", CURRENT_PROCESS_NAME);
                        IS_INSTALLED[0] = false;
                    }
                    if (!IS_INSTALLED[0] && REPORT_PERIOD_LIMIT.isExpired("idkey_install_failure_rpt")) {
                        x.WF();
                    }
                    AppMethodBeat.o(215444);
                }
            } finally {
                AppMethodBeat.o(215444);
            }
        }
    }

    private static boolean isInstalled() {
        boolean z;
        synchronized (IS_INSTALLED) {
            z = IS_INSTALLED[0];
        }
        return z;
    }

    private static void setApplication(Application application) {
        synchronized (APPLICATION) {
            APPLICATION[0] = application;
        }
    }

    private static Application getApplication() {
        Application application;
        synchronized (APPLICATION) {
            application = APPLICATION[0];
        }
        return application;
    }

    private static Instrumentation getInstrumentation(boolean z) {
        Instrumentation instrumentation;
        AppMethodBeat.i(215445);
        synchronized (INSTRUMENTATION) {
            try {
                if (INSTRUMENTATION[0] == null || z) {
                    try {
                        Class<?> cls = Class.forName("android.app.ActivityThread");
                        Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
                        declaredMethod.setAccessible(true);
                        Object invoke = declaredMethod.invoke(null, new Object[0]);
                        Method declaredMethod2 = cls.getDeclaredMethod("getInstrumentation", new Class[0]);
                        declaredMethod2.setAccessible(true);
                        INSTRUMENTATION[0] = (Instrumentation) declaredMethod2.invoke(invoke, new Object[0]);
                    } catch (Throwable th) {
                        x.a(TAG, th, "[-] Fail to get instrumentation.", new Object[0]);
                        INSTRUMENTATION[0] = null;
                    }
                }
                instrumentation = INSTRUMENTATION[0];
            } finally {
                AppMethodBeat.o(215445);
            }
        }
        return instrumentation;
    }

    public static void markStartupBegin() {
        AppMethodBeat.i(215446);
        if (!isInstalled()) {
            AppMethodBeat.o(215446);
            return;
        }
        synchronized (STARTUP_BEGIN_TS) {
            try {
                STARTUP_BEGIN_TS[0] = System.currentTimeMillis();
            } finally {
                AppMethodBeat.o(215446);
            }
        }
        if (currentProcessWillShowForegroundUI()) {
            markCurrentProcessColdStart();
        }
    }

    private static boolean isCurrentProcessColdStartBefore() {
        boolean z;
        synchronized (IS_COLD_START) {
            z = IS_COLD_START[0];
        }
        return z;
    }

    private static void markCurrentProcessColdStart() {
        synchronized (IS_COLD_START) {
            IS_COLD_START[0] = true;
        }
    }

    private static long getCostMsFromStartupBegin() {
        long j2 = -1;
        AppMethodBeat.i(215447);
        synchronized (STARTUP_BEGIN_TS) {
            try {
                long j3 = STARTUP_BEGIN_TS[0];
                if (j3 != -1) {
                    j2 = System.currentTimeMillis() - j3;
                } else {
                    AppMethodBeat.o(215447);
                }
            } finally {
                AppMethodBeat.o(215447);
            }
        }
        return j2;
    }

    private static boolean currentProcessWillShowForegroundUI() {
        AppMethodBeat.i(215448);
        Application application = getApplication();
        if (application == null) {
            AppMethodBeat.o(215448);
            return false;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) application.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            AppMethodBeat.o(215448);
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.uid == Process.myUid() && runningAppProcessInfo.pid == Process.myPid() && runningAppProcessInfo.importance == 100) {
                AppMethodBeat.o(215448);
                return true;
            }
        }
        AppMethodBeat.o(215448);
        return false;
    }

    private static void reportDurationToFirstUIShown(Activity activity) {
        long j2;
        AppMethodBeat.i(215449);
        if (!isInstalled()) {
            AppMethodBeat.o(215449);
            return;
        }
        String name = activity.getClass().getName();
        if (IGNORED_ACTIVITIES.contains(name)) {
            x.b(TAG, "[!] [%s] [%s] Ignored activity, skip this time.", CURRENT_PROCESS_NAME, name);
            AppMethodBeat.o(215449);
            return;
        }
        Intent intent = activity.getIntent();
        if (intent == null) {
            AppMethodBeat.o(215449);
            return;
        }
        synchronized (HAS_MET_FIRST_UI) {
            try {
                if (!HAS_MET_FIRST_UI[0]) {
                    boolean isCurrentProcessColdStartBefore = isCurrentProcessColdStartBefore();
                    long longExtra = intent.getLongExtra(INTENT_KEY_CREATE_TS, -1);
                    intent.removeExtra(INTENT_KEY_CREATE_TS);
                    if (isCurrentProcessColdStartBefore) {
                        j2 = getCostMsFromStartupBegin();
                    } else if (longExtra >= 0) {
                        j2 = System.currentTimeMillis() - longExtra;
                    } else {
                        j2 = -1;
                    }
                    if (j2 < 0) {
                        x.b(TAG, "[!] [%s] Cost should not less than 0.", CURRENT_PROCESS_NAME);
                    } else if (isCurrentProcessColdStartBefore) {
                        x.a(TAG, "[+] [UI-Startup] [%s] First ui [%s] was shown, report now, cold-startup, cost: %s ms.", CURRENT_PROCESS_NAME, name, Long.valueOf(j2));
                        doCostReportOnDemand(KVSTAT_TYPEID_FIRST_UI_SHOWN_COLD, j2);
                    } else {
                        x.a(TAG, "[+] [UI-Startup] [%s] First ui [%s] was shown, report now, warm-startup, cost: %s ms.", CURRENT_PROCESS_NAME, name, Long.valueOf(j2));
                        doCostReportOnDemand(KVSTAT_TYPEID_FIRST_UI_SHOWN_WARM, j2);
                    }
                    HAS_MET_FIRST_UI[0] = true;
                    AppMethodBeat.o(215449);
                }
            } finally {
                AppMethodBeat.o(215449);
            }
        }
    }

    private static void doCostReportOnDemand(int i2, long j2) {
        AppMethodBeat.i(215450);
        boolean z = i2 == KVSTAT_TYPEID_FIRST_UI_SHOWN_COLD;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new IDKey((int) IDKEY_ID, 30, 1));
        if (MMApplicationContext.isMainProcess()) {
            arrayList.add(new IDKey((int) IDKEY_ID, 31, 1));
            if (z) {
                if (j2 > 5000) {
                    arrayList.add(new IDKey((int) IDKEY_ID, 32, 1));
                    doFreqLimitedKVStatNumReport(i2, j2);
                }
            } else if (j2 > 2000) {
                arrayList.add(new IDKey((int) IDKEY_ID, 33, 1));
                doFreqLimitedKVStatNumReport(i2, j2);
            }
        } else if (MMApplicationContext.isToolsProcess()) {
            arrayList.add(new IDKey((int) IDKEY_ID, 31, 1));
            if (z) {
                if (j2 > 5000) {
                    arrayList.add(new IDKey((int) IDKEY_ID, 34, 1));
                    doFreqLimitedKVStatNumReport(i2, j2);
                }
            } else if (j2 > 2000) {
                arrayList.add(new IDKey((int) IDKEY_ID, 35, 1));
                doFreqLimitedKVStatNumReport(i2, j2);
            }
        } else if (MMApplicationContext.isToolsMpProcess()) {
            arrayList.add(new IDKey((int) IDKEY_ID, 31, 1));
            if (z) {
                if (j2 > 5000) {
                    arrayList.add(new IDKey((int) IDKEY_ID, 36, 1));
                    doFreqLimitedKVStatNumReport(i2, j2);
                }
            } else if (j2 > 2000) {
                arrayList.add(new IDKey((int) IDKEY_ID, 37, 1));
                doFreqLimitedKVStatNumReport(i2, j2);
            }
        } else if (MMApplicationContext.isAppBrandProcess()) {
            arrayList.add(new IDKey((int) IDKEY_ID, 31, 1));
            if (z) {
                if (j2 > 5000) {
                    arrayList.add(new IDKey((int) IDKEY_ID, 38, 1));
                    doFreqLimitedKVStatNumReport(i2, j2);
                }
            } else if (j2 > 2000) {
                arrayList.add(new IDKey((int) IDKEY_ID, 39, 1));
                doFreqLimitedKVStatNumReport(i2, j2);
            }
        }
        x.f(arrayList);
        AppMethodBeat.o(215450);
    }

    private static void doFreqLimitedKVStatNumReport(int i2, long j2) {
        AppMethodBeat.i(215451);
        long j3 = ((long) i2) & Util.MAX_32BIT_VALUE;
        if (REPORT_PERIOD_LIMIT.isExpired("rpt_" + CURRENT_PROCESS_NAME + "_" + j3)) {
            x.a(KVSTAT_ID, Long.valueOf(j3), d.cQi, Long.valueOf(j2));
            x.a(TAG, "[+] doKVStatNumReport, content: %s,%s,%s", Long.valueOf(j3), CURRENT_PROCESS_NAME, Long.valueOf(j2));
            AppMethodBeat.o(215451);
            return;
        }
        x.a(TAG, "[+] Hit report freq limit, skip reporting this time. content: %s,%s,%s", Long.valueOf(j3), CURRENT_PROCESS_NAME, Long.valueOf(j2));
        AppMethodBeat.o(215451);
    }

    private StartupCostReporter() {
        AppMethodBeat.i(215452);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(215452);
        throw unsupportedOperationException;
    }
}
