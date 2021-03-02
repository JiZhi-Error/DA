package com.tencent.mm.plugin.performance.watchdogs;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.support.annotation.Keep;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.f.h;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.performance.b.a;
import com.tencent.mm.plugin.performance.watchdogs.e;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xwalk.core.XWalkEnvironment;

@Keep
public class ThreadWatchDog implements Application.ActivityLifecycleCallbacks {
    private static final int HOOK_ID_KEY = 1571;
    public static final int HOOK_THRESHOLD = 20;
    private static final int LIMIT_THREAD_COUNT_150 = 150;
    private static final int LIMIT_THREAD_COUNT_200 = 200;
    private static final int LIMIT_THREAD_COUNT_300 = 300;
    private static final int OVER_300 = 2;
    private static final int OVER_500 = 1;
    private static final int OVER_500_WHITE_THREAD = 3;
    protected static final int REPORT_ID = 960;
    private static final int REPORT_KV_ID = 16470;
    private static final String TAG = "MicroMsg.ThreadWatchDog";
    private static volatile int TOP_THREAD_COUNT = 500;
    private boolean enableTriggerPthreadHook;
    private boolean isSensitiveMode;
    private volatile StringBuilder mContent;
    private volatile int mJavaThreadCount = 0;
    private int mLastReportedThreadCount;
    private long mLastWangTime;
    private volatile int mProcessThreadCount = 0;
    private volatile boolean mShouldPreventThrow;

    public ThreadWatchDog() {
        AppMethodBeat.i(201188);
        com.tencent.mm.plugin.performance.b.a.AUa.a(new a.AbstractC1570a() {
            /* class com.tencent.mm.plugin.performance.watchdogs.ThreadWatchDog.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.performance.b.a.AbstractC1570a
            public final void eCj() {
                AppMethodBeat.i(201182);
                Log.i(ThreadWatchDog.TAG, "enable trigger pthread hook");
                ThreadWatchDog.this.enableTriggerPthreadHook = true;
                AppMethodBeat.o(201182);
            }

            @Override // com.tencent.mm.plugin.performance.b.a.AbstractC1570a
            public final String Lb() {
                return ThreadWatchDog.TAG;
            }

            @Override // com.tencent.mm.plugin.performance.b.a.AbstractC1570a
            public final double eCk() {
                AppMethodBeat.i(201183);
                double a2 = 1.0d / ((double) ((long) ((b) g.af(b.class)).a(b.a.clicfg_diagnostic_pthread_hook_auto_trigger_rate_denominator, -1)));
                AppMethodBeat.o(201183);
                return a2;
            }

            @Override // com.tencent.mm.plugin.performance.b.a.AbstractC1570a
            public final long eCl() {
                return 0;
            }
        });
        this.isSensitiveMode = ((b) g.af(b.class)).a(b.a.clicfg_diagnostic_pthread_hook_sensitive, false);
        AppMethodBeat.o(201188);
    }

    static /* synthetic */ void access$300(ThreadWatchDog threadWatchDog) {
        AppMethodBeat.i(201204);
        threadWatchDog.report();
        AppMethodBeat.o(201204);
    }

    static /* synthetic */ boolean access$400(ThreadWatchDog threadWatchDog, int i2, int i3, int i4, StringBuilder sb) {
        AppMethodBeat.i(201205);
        boolean onOverThread = threadWatchDog.onOverThread(i2, i3, i4, sb);
        AppMethodBeat.o(201205);
        return onOverThread;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
        AppMethodBeat.i(201189);
        if (isCheck()) {
            wang();
            dumpThreadCountAndReportAsync();
        }
        AppMethodBeat.o(201189);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    private void dumpThreadCountAndReportAsync() {
        AppMethodBeat.i(201190);
        h.RTc.aY(new Runnable() {
            /* class com.tencent.mm.plugin.performance.watchdogs.ThreadWatchDog.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(201184);
                long uptimeMillis = SystemClock.uptimeMillis();
                try {
                    LinkedList linkedList = new LinkedList();
                    ThreadWatchDog.this.mProcessThreadCount = ThreadWatchDog.getProcessThreadCount();
                    ThreadWatchDog.this.mJavaThreadCount = ThreadWatchDog.getJavaThreads(linkedList);
                    ThreadWatchDog.access$300(ThreadWatchDog.this);
                    Log.w(ThreadWatchDog.TAG, "[dumpAsync][%s:%s]:%s", Integer.valueOf(ThreadWatchDog.this.mJavaThreadCount), Integer.valueOf(ThreadWatchDog.this.mProcessThreadCount), linkedList.toString());
                    Log.i(ThreadWatchDog.TAG, "[dumpAsync] Cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                    AppMethodBeat.o(201184);
                } catch (Throwable th) {
                    Log.i(ThreadWatchDog.TAG, "[dumpAsync] Cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                    AppMethodBeat.o(201184);
                    throw th;
                }
            }
        });
        AppMethodBeat.o(201190);
    }

    private void wang() {
        AppMethodBeat.i(201191);
        if (this.mProcessThreadCount <= TOP_THREAD_COUNT) {
            AppMethodBeat.o(201191);
        } else if (this.mShouldPreventThrow) {
            Log.i(TAG, "prevent throw Exception");
            TOP_THREAD_COUNT += 1024;
            AppMethodBeat.o(201191);
        } else {
            StringBuilder sb = new StringBuilder(TAG);
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(this.mJavaThreadCount);
            objArr[1] = Integer.valueOf(this.mProcessThreadCount);
            objArr[2] = this.mContent == null ? BuildConfig.COMMAND : this.mContent.toString();
            RuntimeException runtimeException = new RuntimeException(sb.append(String.format("\nThreadOver[%s:%s]: %s", objArr)).toString());
            AppMethodBeat.o(201191);
            throw runtimeException;
        }
    }

    private void report() {
        int i2;
        AppMethodBeat.i(201192);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (MMApplicationContext.isMainProcess()) {
            i2 = 100;
        } else if (MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsMpProcess()) {
            i2 = 120;
        } else if (MMApplicationContext.isAppBrandProcess()) {
            i2 = 140;
        } else {
            i2 = -1;
        }
        if (i2 == -1) {
            AppMethodBeat.o(201192);
            return;
        }
        try {
            if (this.mProcessThreadCount > TOP_THREAD_COUNT) {
                this.mContent = new StringBuilder();
                Log.i(TAG, "trigger Over 500");
                this.mShouldPreventThrow = onOverThread(1, this.mJavaThreadCount, this.mProcessThreadCount, this.mContent);
                e.INSTANCE.idkeyStat(960, (long) (i2 + 1), 1, true);
            } else if (this.mProcessThreadCount > 300) {
                e.INSTANCE.idkeyStat(960, (long) i2, 1, true);
                if (this.mProcessThreadCount - this.mLastReportedThreadCount >= 50) {
                    this.mLastReportedThreadCount = this.mProcessThreadCount;
                    h.RTc.aY(new Runnable() {
                        /* class com.tencent.mm.plugin.performance.watchdogs.ThreadWatchDog.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(201185);
                            Log.i(ThreadWatchDog.TAG, "trigger Over 300");
                            ThreadWatchDog.access$400(ThreadWatchDog.this, 2, ThreadWatchDog.this.mJavaThreadCount, ThreadWatchDog.this.mProcessThreadCount, null);
                            AppMethodBeat.o(201185);
                        }
                    });
                }
            } else if (this.mProcessThreadCount > 200) {
                e.INSTANCE.idkeyStat(960, (long) (i2 + 2), 1, true);
            } else if (this.mProcessThreadCount > 150) {
                e.INSTANCE.idkeyStat(960, (long) (i2 + 3), 1, true);
            } else {
                e.INSTANCE.idkeyStat(960, (long) (i2 + 8), 1, true);
            }
            if (this.mJavaThreadCount > TOP_THREAD_COUNT) {
                e.INSTANCE.idkeyStat(960, (long) (i2 + 4), 1, true);
            } else if (this.mJavaThreadCount > 300) {
                e.INSTANCE.idkeyStat(960, (long) (i2 + 5), 1, true);
            } else if (this.mJavaThreadCount > 200) {
                e.INSTANCE.idkeyStat(960, (long) (i2 + 6), 1, true);
            } else if (this.mJavaThreadCount > 150) {
                e.INSTANCE.idkeyStat(960, (long) (i2 + 7), 1, true);
            } else {
                e.INSTANCE.idkeyStat(960, (long) (i2 + 9), 1, true);
            }
            Log.i(TAG, "[wang] Cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            AppMethodBeat.o(201192);
        } catch (Throwable th) {
            Log.i(TAG, "[wang] Cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            AppMethodBeat.o(201192);
            throw th;
        }
    }

    private boolean onOverThread(int i2, int i3, int i4, StringBuilder sb) {
        String str;
        int i5;
        String str2;
        int i6;
        String str3;
        boolean z;
        AppMethodBeat.i(201193);
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = false;
        List<a.d> To = com.tencent.matrix.f.a.To();
        int i7 = 0;
        a.d[] dVarArr = new a.d[3];
        for (a.d dVar : To) {
            dVarArr[i7] = dVar;
            if (1 == i2) {
                if (e.a.gi(dVar.name)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    z2 = true;
                    i2 = 3;
                }
            }
            i7++;
            if (i7 >= 3) {
                break;
            }
        }
        String obj = To.toString();
        Log.d(TAG, "content %s", obj);
        com.tencent.mm.plugin.report.e eVar = com.tencent.mm.plugin.report.e.INSTANCE;
        Object[] objArr = new Object[14];
        objArr[0] = String.format("ThreadOver[%s:%s]: %s", Integer.valueOf(i3), Integer.valueOf(i4), obj);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = Integer.valueOf(i4);
        if (dVarArr[0] != null) {
            str = dVarArr[0].name;
        } else {
            str = BuildConfig.COMMAND;
        }
        objArr[4] = str;
        objArr[5] = dVarArr[0] != null ? Integer.valueOf(dVarArr[0].getSize()) : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (dVarArr[0] == null || !dVarArr[0].Tr()) {
            i5 = 0;
        } else {
            i5 = 1;
        }
        objArr[6] = Integer.valueOf(i5);
        if (dVarArr[1] != null) {
            str2 = dVarArr[1].name;
        } else {
            str2 = BuildConfig.COMMAND;
        }
        objArr[7] = str2;
        objArr[8] = dVarArr[1] != null ? Integer.valueOf(dVarArr[1].getSize()) : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (dVarArr[1] == null || !dVarArr[1].Tr()) {
            i6 = 0;
        } else {
            i6 = 1;
        }
        objArr[9] = Integer.valueOf(i6);
        if (dVarArr[2] != null) {
            str3 = dVarArr[2].name;
        } else {
            str3 = BuildConfig.COMMAND;
        }
        objArr[10] = str3;
        objArr[11] = dVarArr[2] != null ? Integer.valueOf(dVarArr[2].getSize()) : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        objArr[12] = Integer.valueOf((dVarArr[2] == null || !dVarArr[2].Tr()) ? 0 : 1);
        objArr[13] = MMApplicationContext.getProcessName();
        eVar.a(REPORT_KV_ID, objArr);
        ArrayList arrayList = new ArrayList();
        for (int i8 = 0; i8 < 3; i8++) {
            if (dVarArr[i8] != null && dVarArr[i8].getSize() > 20) {
                arrayList.add(dVarArr[i8].name);
            }
        }
        if (1 == i2 || BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger() || d.KyR || d.KyP || this.isSensitiveMode) {
            ((com.tencent.mm.plugin.performance.diagnostic.c.b) com.tencent.mm.plugin.performance.a.a.INSTANCE.aT(com.tencent.mm.plugin.performance.diagnostic.c.b.class)).hd(false);
        }
        enablePthreadHook(arrayList);
        Log.i(TAG, "onOverThread: dump costs %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        if (sb != null) {
            sb.append(obj);
        }
        AppMethodBeat.o(201193);
        return z2;
    }

    private void enablePthreadHook(List<String> list) {
        AppMethodBeat.i(201194);
        boolean z = BuildInfo.IS_FLAVOR_RED || d.KyR || WeChatEnvironment.isCoolassistEnv() || WeChatEnvironment.hasDebugger() || this.enableTriggerPthreadHook;
        Log.i(TAG, "enable auto trigger? %s", Boolean.valueOf(z));
        if (!z) {
            AppMethodBeat.o(201194);
        } else if (list.isEmpty()) {
            Log.w(TAG, "threadNames is empty, just return");
            AppMethodBeat.o(201194);
        } else {
            StringBuilder sb = new StringBuilder();
            for (String str : list) {
                String replace = str.replace("[", "\\[").replace("]", "\\]").replace("?", ".*");
                if (replace.length() > 1 && replace.endsWith("J")) {
                    replace = replace.substring(0, replace.length() - 1);
                }
                sb.append(replace).append(";");
            }
            com.tencent.mm.plugin.performance.a.a.INSTANCE.aJQ("<cmd><diagnostic><PthreadHook\n enable='1' process='" + processCmd() + "' duration='1' hook='.*\\.so$' thread='" + sb.toString() + "'/></diagnostic></cmd>");
            ArrayList<IDKey> arrayList = new ArrayList<>();
            IDKey iDKey = new IDKey((int) HOOK_ID_KEY, 11, 1);
            IDKey iDKey2 = new IDKey((int) HOOK_ID_KEY, getWatchDogTriggerProcessKey(), 1);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            com.tencent.mm.plugin.report.service.h.INSTANCE.b(arrayList, false);
            AppMethodBeat.o(201194);
        }
    }

    private int getWatchDogTriggerProcessKey() {
        AppMethodBeat.i(201195);
        if (MMApplicationContext.isMainProcess()) {
            AppMethodBeat.o(201195);
            return 60;
        } else if (MMApplicationContext.isAppBrandProcess()) {
            AppMethodBeat.o(201195);
            return 61;
        } else if (MMApplicationContext.isToolsMpProcess() || MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsIsolatedProcess()) {
            AppMethodBeat.o(201195);
            return 62;
        } else {
            AppMethodBeat.o(201195);
            return -1;
        }
    }

    private final String processCmd() {
        AppMethodBeat.i(201196);
        if (MMApplicationContext.isMainProcess()) {
            AppMethodBeat.o(201196);
            return "mm";
        } else if (MMApplicationContext.isAppBrandProcess()) {
            AppMethodBeat.o(201196);
            return "appbrand";
        } else if (MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsMpProcess()) {
            AppMethodBeat.o(201196);
            return "tools";
        } else {
            AppMethodBeat.o(201196);
            return "all";
        }
    }

    private boolean isCheck() {
        AppMethodBeat.i(201197);
        if (SystemClock.uptimeMillis() - this.mLastWangTime >= 10000) {
            this.mLastWangTime = SystemClock.uptimeMillis();
            AppMethodBeat.o(201197);
            return true;
        }
        AppMethodBeat.o(201197);
        return false;
    }

    public static int getProcessThreadCount() {
        AppMethodBeat.i(201198);
        try {
            String[] split = getStringFromFile(String.format("/proc/%s/status", Integer.valueOf(Process.myPid()))).trim().split("\n");
            for (String str : split) {
                if (str.startsWith("Threads")) {
                    Matcher matcher = Pattern.compile("\\d+").matcher(str);
                    if (matcher.find()) {
                        int safeParseInt = Util.safeParseInt(matcher.group());
                        AppMethodBeat.o(201198);
                        return safeParseInt;
                    }
                }
            }
            Log.w(TAG, "[getProcessThreadCount] Wrong!", split[24]);
            int safeParseInt2 = Util.safeParseInt(split[24].trim());
            AppMethodBeat.o(201198);
            return safeParseInt2;
        } catch (Exception e2) {
            AppMethodBeat.o(201198);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String convertStreamToString(java.io.InputStream r5) {
        /*
            r4 = 201199(0x311ef, float:2.8194E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            r2 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x003b }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x003b }
            r3.<init>(r5)     // Catch:{ all -> 0x003b }
            r1.<init>(r3)     // Catch:{ all -> 0x003b }
        L_0x0016:
            java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x0026 }
            if (r2 == 0) goto L_0x0030
            java.lang.StringBuilder r2 = r0.append(r2)     // Catch:{ all -> 0x0026 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0026 }
            goto L_0x0016
        L_0x0026:
            r0 = move-exception
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            r1.close()
        L_0x002c:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r0
        L_0x0030:
            r1.close()
            java.lang.String r0 = r0.toString()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return r0
        L_0x003b:
            r0 = move-exception
            r1 = r2
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.performance.watchdogs.ThreadWatchDog.convertStreamToString(java.io.InputStream):java.lang.String");
    }

    private static String getStringFromFile(String str) {
        AppMethodBeat.i(201200);
        InputStream inputStream = null;
        try {
            inputStream = s.ao(new o(str));
            return convertStreamToString(inputStream);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            AppMethodBeat.o(201200);
        }
    }

    public static int getJavaThreadCount() {
        AppMethodBeat.i(XWalkEnvironment.SDK_VERSION);
        ThreadGroup threadGroup = Looper.getMainLooper().getThread().getThreadGroup();
        int enumerate = threadGroup.enumerate(new Thread[(threadGroup.activeCount() * 2)]);
        AppMethodBeat.o(XWalkEnvironment.SDK_VERSION);
        return enumerate;
    }

    public static int getJavaThreads(List<a> list) {
        int i2;
        String str;
        AppMethodBeat.i(201202);
        HashMap hashMap = new HashMap();
        ThreadGroup threadGroup = Looper.getMainLooper().getThread().getThreadGroup();
        Thread[] threadArr = new Thread[(threadGroup.activeCount() * 2)];
        int enumerate = threadGroup.enumerate(threadArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < enumerate) {
            String name = threadArr[i3].getName();
            if (!Util.isNullOrNil(name)) {
                String replaceAll = name.replaceAll("[0-9]\\d*", "?");
                if (replaceAll.contains("Binder:")) {
                    str = "Binder:?_?";
                } else {
                    str = replaceAll;
                }
                if (hashMap.containsKey(str)) {
                    hashMap.put(str, Integer.valueOf(((Integer) hashMap.get(str)).intValue() + 1));
                } else {
                    hashMap.put(str, 1);
                }
                i2 = i4 + 1;
            } else {
                i2 = i4;
            }
            i3++;
            i4 = i2;
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            list.add(new a((String) entry.getKey(), ((Integer) entry.getValue()).intValue()));
        }
        Collections.sort(list, new Comparator<a>() {
            /* class com.tencent.mm.plugin.performance.watchdogs.ThreadWatchDog.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
                AppMethodBeat.i(201186);
                int compare = Integer.compare(aVar2.count, aVar.count);
                AppMethodBeat.o(201186);
                return compare;
            }
        });
        AppMethodBeat.o(201202);
        return i4;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        int count;
        String name;

        public a(String str, int i2) {
            this.name = str;
            this.count = i2;
        }

        public final String toString() {
            AppMethodBeat.i(201187);
            String str = this.name + "=" + this.count;
            AppMethodBeat.o(201187);
            return str;
        }
    }

    public static boolean isSB() {
        AppMethodBeat.i(201203);
        if (!BuildInfo.IS_FLAVOR_PURPLE || (!z.aTY().contains("caicy1662") && !z.aTY().contains("foreverzeus") && !z.aTY().contains("10618855"))) {
            AppMethodBeat.o(201203);
            return false;
        }
        AppMethodBeat.o(201203);
        return true;
    }
}
