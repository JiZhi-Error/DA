package com.tencent.mm.plugin.performance.watchdogs;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.performance.a.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.performance.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class c implements Application.ActivityLifecycleCallbacks, Runnable {
    private static final c AXa = new c();
    public int AXb;
    public int AXc;
    private int AXd = 0;
    private final Set<String> AXe = new HashSet();
    private boolean AXf = true;
    private volatile boolean AXg = false;
    private long AXh = 524288000;
    private long AXi = 1258291;
    private long AXj;
    private long AXk;
    public long AXl;
    private boolean AXm = false;
    private boolean AXn = false;
    private long AXo;
    public final ActivityManager aJf = ((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME));
    private volatile String activity;
    public volatile boolean cPB = true;

    static /* synthetic */ void a(c cVar, a aVar, int i2) {
        AppMethodBeat.i(201175);
        cVar.a(aVar, i2);
        AppMethodBeat.o(201175);
    }

    static /* synthetic */ boolean b(c cVar) {
        AppMethodBeat.i(201174);
        boolean eCM = cVar.eCM();
        AppMethodBeat.o(201174);
        return eCM;
    }

    static {
        AppMethodBeat.i(201176);
        AppMethodBeat.o(201176);
    }

    private c() {
        AppMethodBeat.i(201152);
        com.tencent.mm.performance.a.a.jJE = new a.AbstractC0503a() {
            /* class com.tencent.mm.plugin.performance.watchdogs.c.AnonymousClass1 */

            @Override // com.tencent.mm.performance.a.a.AbstractC0503a
            public final void bkR() {
                AppMethodBeat.i(201144);
                c.this.S(true, 0);
                AppMethodBeat.o(201144);
            }
        };
        com.tencent.matrix.a.INSTANCE.a(new com.tencent.matrix.b.c() {
            /* class com.tencent.mm.plugin.performance.watchdogs.c.AnonymousClass2 */

            @Override // com.tencent.matrix.b.c
            public final void onForeground(boolean z) {
                AppMethodBeat.i(201145);
                Log.d("MicroMsg.MemoryWatchDog", "[%s] isProcessForeground: %s", MMApplicationContext.getProcessName(), Boolean.valueOf(z));
                c.this.AXg = z;
                if (!z) {
                    c.this.AXk = System.currentTimeMillis();
                }
                AppMethodBeat.o(201145);
            }
        });
        com.tencent.mm.plugin.performance.b.a.AUa.a(new a.AbstractC1570a() {
            /* class com.tencent.mm.plugin.performance.watchdogs.c.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.performance.b.a.AbstractC1570a
            public final void eCj() {
                AppMethodBeat.i(201146);
                c.this.AXm = true;
                AppMethodBeat.o(201146);
            }

            @Override // com.tencent.mm.plugin.performance.b.a.AbstractC1570a
            public final String Lb() {
                return "MicroMsg.MemoryWatchDog";
            }

            @Override // com.tencent.mm.plugin.performance.b.a.AbstractC1570a
            public final double eCk() {
                AppMethodBeat.i(201147);
                double a2 = 1.0d / ((double) ((b) g.af(b.class)).a(b.a.clicfg_diagnostic_memory_hook_auto_trigger_rate_denominator, -1L));
                AppMethodBeat.o(201147);
                return a2;
            }

            @Override // com.tencent.mm.plugin.performance.b.a.AbstractC1570a
            public final long eCl() {
                return 0;
            }
        });
        AppMethodBeat.o(201152);
    }

    public static c eCH() {
        return AXa;
    }

    public final a S(boolean z, int i2) {
        AppMethodBeat.i(201153);
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a();
        if (this.activity != null) {
            aVar.activity = this.activity;
        }
        aVar.source = i2;
        aVar.AXA = (long) this.AXb;
        aVar.AXB = (long) this.AXc;
        if (z) {
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                Debug.MemoryInfo[] processMemoryInfo = this.aJf.getProcessMemoryInfo(new int[]{Process.myPid()});
                Log.d("MicroMsg.MemoryWatchDog", "pidMemInfoArray size = " + processMemoryInfo.length);
                if (processMemoryInfo != null && processMemoryInfo.length == 1) {
                    Debug.MemoryInfo memoryInfo = processMemoryInfo[0];
                    aVar.AXF = memoryInfo.getTotalPss();
                    if (Build.VERSION.SDK_INT >= 23) {
                        aVar.map = memoryInfo.getMemoryStats();
                    } else {
                        Log.d("MicroMsg.MemoryWatchDog", "API level < 23, reflect to get stat");
                        aVar.map = new HashMap();
                        aVar.map.put("summary.java-heap", String.valueOf(memoryInfo.dalvikPrivateDirty));
                        aVar.map.put("summary.native-heap", String.valueOf(memoryInfo.nativePrivateDirty));
                        aVar.map.put("summary.code", "-1");
                        aVar.map.put("summary.stack", "-1");
                        aVar.map.put("summary.graphics", "-1");
                        aVar.map.put("summary.private-other", "-1");
                        aVar.map.put("summary.system", String.valueOf((memoryInfo.getTotalPss() - memoryInfo.getTotalPrivateClean()) - memoryInfo.getTotalPrivateDirty()));
                        aVar.map.put("summary.total-pss", String.valueOf(memoryInfo.getTotalPss()));
                        aVar.map.put("summary.total-swap", "-1");
                        Log.d("MicroMsg.MemoryWatchDog", "reflect stat: %s", aVar.map);
                    }
                }
                Log.d("MicroMsg.MemoryWatchDog", "getting process memory info costs %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                if (MMApplicationContext.isMainProcess()) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    a[] eCI = eCI();
                    Debug.MemoryInfo[] processMemoryInfo2 = this.aJf.getProcessMemoryInfo(a(eCI));
                    if (processMemoryInfo2 != null) {
                        Log.d("MicroMsg.MemoryWatchDog", "pidMemInfoArray2 size = %s, memoryInfos size = %s", Integer.valueOf(processMemoryInfo2.length), Integer.valueOf(eCI.length));
                        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.isCoolassistEnv()) {
                            Assert.assertEquals(eCI.length, processMemoryInfo2.length);
                        }
                        int i3 = 0;
                        for (int i4 = 0; i4 < Math.min(processMemoryInfo2.length, eCI.length); i4++) {
                            Log.d("MicroMsg.MemoryWatchDog", "total pss = %d", Integer.valueOf(processMemoryInfo2[i4].getTotalPss()));
                            eCI[i4].AXF = processMemoryInfo2[i4].getTotalPss();
                            i3 += eCI[i4].AXF;
                        }
                        aVar.AXG = i3;
                        aVar.AXH = eCI;
                    } else {
                        Log.e("MicroMsg.MemoryWatchDog", "pidMemInfoArray2 == null");
                    }
                    Log.d("MicroMsg.MemoryWatchDog", "getting process memory info costs %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                }
                i(aVar);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MemoryWatchDog", e2, "", new Object[0]);
                aVar.hju = System.currentTimeMillis() - currentTimeMillis;
                if (!BuildInfo.IS_FLAVOR_RED && !BuildInfo.IS_FLAVOR_PURPLE && !z && aVar.hju > 30 && this.AXf) {
                    this.AXd++;
                    if (this.AXd > 10) {
                        Log.w("MicroMsg.MemoryWatchDog", "adjust for printing async!");
                        this.AXf = false;
                    }
                }
                if (aVar.AXE == null) {
                    Log.e("MicroMsg.MemoryWatchDog", "Something wrong when dumping memory");
                    aVar.AXE = new ActivityManager.MemoryInfo();
                }
            } catch (Throwable th) {
                aVar.hju = System.currentTimeMillis() - currentTimeMillis;
                if (!BuildInfo.IS_FLAVOR_RED && !BuildInfo.IS_FLAVOR_PURPLE && !z && aVar.hju > 30 && this.AXf) {
                    this.AXd++;
                    if (this.AXd > 10) {
                        Log.w("MicroMsg.MemoryWatchDog", "adjust for printing async!");
                        this.AXf = false;
                    }
                }
                if (aVar.AXE == null) {
                    Log.e("MicroMsg.MemoryWatchDog", "Something wrong when dumping memory");
                    aVar.AXE = new ActivityManager.MemoryInfo();
                }
                AppMethodBeat.o(201153);
                throw th;
            }
        }
        Matcher matcher = Pattern.compile("\\d+").matcher(getVmSize());
        if (matcher.find()) {
            aVar.AXq = Util.safeParseInt(matcher.group());
        }
        aVar.AXu = Debug.getNativeHeapSize();
        aVar.AXv = Debug.getNativeHeapAllocatedSize();
        aVar.AXw = Debug.getNativeHeapFreeSize();
        aVar.AXx = Runtime.getRuntime().totalMemory();
        aVar.AXy = Runtime.getRuntime().freeMemory();
        aVar.AXz = Runtime.getRuntime().maxMemory();
        ActivityManager.MemoryInfo memoryInfo2 = new ActivityManager.MemoryInfo();
        this.aJf.getMemoryInfo(memoryInfo2);
        aVar.AXE = memoryInfo2;
        aVar.hju = System.currentTimeMillis() - currentTimeMillis;
        if (!BuildInfo.IS_FLAVOR_RED && !BuildInfo.IS_FLAVOR_PURPLE && !z && aVar.hju > 30 && this.AXf) {
            this.AXd++;
            if (this.AXd > 10) {
                Log.w("MicroMsg.MemoryWatchDog", "adjust for printing async!");
                this.AXf = false;
            }
        }
        if (aVar.AXE == null) {
            Log.e("MicroMsg.MemoryWatchDog", "Something wrong when dumping memory");
            aVar.AXE = new ActivityManager.MemoryInfo();
        }
        aVar.cPB = this.cPB;
        aVar.AXg = this.AXg;
        if (eCK()) {
            aVar.AXt = this.AXe.isEmpty();
        }
        if (eCK() && !aVar.AXg) {
            aVar.AXD = System.currentTimeMillis() - this.AXk;
        } else if (!eCK() && !aVar.cPB) {
            aVar.AXD = System.currentTimeMillis() - this.AXj;
        }
        AppMethodBeat.o(201153);
        return aVar;
    }

    private void i(a aVar) {
        AppMethodBeat.i(201154);
        long currentTimeMillis = System.currentTimeMillis();
        for (ActivityManager.RunningServiceInfo runningServiceInfo : this.aJf.getRunningServices(Integer.MAX_VALUE)) {
            if (runningServiceInfo.uid == Process.myUid()) {
                Log.d("MicroMsg.MemoryWatchDog", "foreground %s, stared %s, lastActivityTime %s, activeSince %s, class %s", Boolean.valueOf(runningServiceInfo.foreground), Boolean.valueOf(runningServiceInfo.started), Long.valueOf(runningServiceInfo.lastActivityTime), Long.valueOf(runningServiceInfo.activeSince), runningServiceInfo.service.getClassName());
                if (runningServiceInfo.foreground) {
                    aVar.AXr.add(runningServiceInfo.service.getClassName());
                }
            }
        }
        Log.d("MicroMsg.MemoryWatchDog", "getting running service info cost %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(201154);
    }

    private a[] eCI() {
        AppMethodBeat.i(201155);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.aJf.getRunningAppProcesses();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < runningAppProcesses.size(); i2++) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i2);
            String packageName = WeChatBrands.AppInfo.current().getPackageName();
            Log.d("MicroMsg.MemoryWatchDog", "pkg name is [%s]", packageName);
            if (Process.myUid() != runningAppProcessInfo.uid || TextUtils.isEmpty(runningAppProcessInfo.processName) || !runningAppProcessInfo.processName.startsWith(packageName)) {
                Log.e("MicroMsg.MemoryWatchDog", "info with uid [%s] & process name [%s] is not current app [%s][%s]", Integer.valueOf(runningAppProcesses.get(i2).uid), runningAppProcesses.get(i2).processName, Integer.valueOf(Process.myUid()), packageName);
            } else {
                a aVar = new a();
                aVar.pid = runningAppProcesses.get(i2).pid;
                aVar.processName = runningAppProcesses.get(i2).processName;
                arrayList.add(aVar);
                Log.d("MicroMsg.MemoryWatchDog", "pid = %s, process = %s", Integer.valueOf(aVar.pid), aVar.processName);
            }
        }
        a[] aVarArr = new a[arrayList.size()];
        arrayList.toArray(aVarArr);
        AppMethodBeat.o(201155);
        return aVarArr;
    }

    private static int[] a(a[] aVarArr) {
        int[] iArr = new int[aVarArr.length];
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            iArr[i2] = aVarArr[i2].pid;
        }
        return iArr;
    }

    public final a eCJ() {
        AppMethodBeat.i(259394);
        a S = S(true, 0);
        AppMethodBeat.o(259394);
        return S;
    }

    private void Us(final int i2) {
        AppMethodBeat.i(201157);
        h.RTc.o(new Runnable() {
            /* class com.tencent.mm.plugin.performance.watchdogs.c.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(201148);
                a S = c.this.S(false, i2);
                Log.i("MicroMsg.MemoryWatchDog", "[dumpMemoryAsync] %s", S);
                if (c.b(c.this)) {
                    c.a(c.this, S, i2);
                }
                AppMethodBeat.o(201148);
            }
        }, 2000);
        AppMethodBeat.o(201157);
    }

    private static String getVmSize() {
        AppMethodBeat.i(201158);
        try {
            String[] split = getStringFromFile(String.format("/proc/%s/status", Integer.valueOf(Process.myPid()))).trim().split("\n");
            for (String str : split) {
                if (str.startsWith("VmSize")) {
                    AppMethodBeat.o(201158);
                    return str;
                }
            }
            Log.w("MicroMsg.MemoryWatchDog", "[getVmSize] Wrong!", split[12]);
            String str2 = split[12];
            AppMethodBeat.o(201158);
            return str2;
        } catch (Exception e2) {
            AppMethodBeat.o(201158);
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String convertStreamToString(java.io.InputStream r5) {
        /*
            r4 = 201159(0x311c7, float:2.81884E-40)
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.performance.watchdogs.c.convertStreamToString(java.io.InputStream):java.lang.String");
    }

    private static String getStringFromFile(String str) {
        AppMethodBeat.i(201160);
        InputStream inputStream = null;
        try {
            inputStream = s.ao(new o(str));
            return convertStreamToString(inputStream);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            AppMethodBeat.o(201160);
        }
    }

    private boolean axz() {
        AppMethodBeat.i(201161);
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z = uptimeMillis - this.AXo > 2000;
        this.AXo = uptimeMillis;
        AppMethodBeat.o(201161);
        return z;
    }

    public final void cy(boolean z) {
        AppMethodBeat.i(201162);
        Log.d("MicroMsg.MemoryWatchDog", "isAppForeground: %s", Boolean.valueOf(z));
        this.cPB = z;
        if (!z) {
            this.AXj = System.currentTimeMillis();
            AppMethodBeat.o(201162);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.AXl > 300000) {
            Log.i("MicroMsg.MemoryWatchDog", "onAppForeground: forward check");
            this.AXl = currentTimeMillis;
            h.RTc.bqo("MicroMsg.MemoryWatchDog");
            h.RTc.a(this, 300000, "MicroMsg.MemoryWatchDog");
        }
        AppMethodBeat.o(201162);
    }

    public final void onActivityStarted(Activity activity2) {
        AppMethodBeat.i(201163);
        this.activity = activity2.getClass().getSimpleName();
        if (axz()) {
            Us(1);
        }
        AppMethodBeat.o(201163);
    }

    public final void onActivityStopped(Activity activity2) {
        AppMethodBeat.i(201164);
        if (axz()) {
            Us(2);
        }
        AppMethodBeat.o(201164);
    }

    static boolean eCK() {
        AppMethodBeat.i(201165);
        if (MMApplicationContext.isAppBrandProcess() || MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsMpProcess()) {
            AppMethodBeat.o(201165);
            return true;
        }
        AppMethodBeat.o(201165);
        return false;
    }

    private boolean eCM() {
        AppMethodBeat.i(201167);
        if (((b) g.af(b.class)).a(b.a.clicfg_memory_hook_auto_trigger_sos, false)) {
            AppMethodBeat.o(201167);
            return false;
        } else if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || d.KyR || WeChatEnvironment.hasDebugger() || this.AXm) {
            AppMethodBeat.o(201167);
            return true;
        } else {
            AppMethodBeat.o(201167);
            return false;
        }
    }

    public final void run() {
        AppMethodBeat.i(201168);
        eCL();
        this.AXl = System.currentTimeMillis();
        h.RTc.a(this, this.cPB ? 300000 : 1800000, "MicroMsg.MemoryWatchDog");
        AppMethodBeat.o(201168);
    }

    private static int getWatchDogTriggerProcessKey() {
        AppMethodBeat.i(201169);
        if (MMApplicationContext.isMainProcess()) {
            AppMethodBeat.o(201169);
            return 30;
        } else if (MMApplicationContext.isAppBrandProcess()) {
            AppMethodBeat.o(201169);
            return 31;
        } else if (MMApplicationContext.isToolsMpProcess() || MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsIsolatedProcess()) {
            AppMethodBeat.o(201169);
            return 32;
        } else {
            AppMethodBeat.o(201169);
            return -1;
        }
    }

    private void a(a aVar, int i2) {
        AppMethodBeat.i(201170);
        Log.i("MicroMsg.MemoryWatchDog", "check triggerMemoryHook");
        if (!BuildInfo.IS_ARM64) {
            Log.i("MicroMsg.MemoryWatchDog", "not trigger on 32-bit devices");
            AppMethodBeat.o(201170);
        } else if (!this.AXn) {
            if ((aVar.AXv > 209715200 || aVar.AXF > 1048576) && Build.VERSION.SDK_INT >= 26) {
                Log.i("MicroMsg.MemoryWatchDog", "trigger hook");
                com.tencent.mm.plugin.performance.a.a.INSTANCE.aJQ("<cmd><diagnostic><MemoryHook enable='1' source='auto' process='" + processCmd() + "' duration='24' hook='" + ".*com\\.tencent\\.mm.*\\.so$" + "' stack='1' min='0' max='0' force='1' enableExpt='0' sampling='1' mmap='0'/></diagnostic></cmd>");
                ArrayList<IDKey> arrayList = new ArrayList<>();
                IDKey iDKey = new IDKey(1571, 1, 1);
                IDKey iDKey2 = new IDKey(1571, getWatchDogTriggerProcessKey(), 1);
                arrayList.add(iDKey);
                arrayList.add(iDKey2);
                com.tencent.mm.plugin.report.service.h.INSTANCE.b(arrayList, false);
                this.AXn = true;
            }
            AppMethodBeat.o(201170);
        } else {
            if (aVar.AXv > this.AXh || ((long) aVar.AXF) > this.AXi) {
                this.AXh = aVar.AXv + DownloadHelper.SAVE_LENGTH;
                if (this.AXi < 2097152) {
                    this.AXi = (long) (aVar.AXF + ShareConstants.MD5_FILE_BUF_LENGTH);
                } else {
                    this.AXi = MAlarmHandler.NEXT_FIRE_INTERVAL;
                }
                Log.i("MicroMsg.MemoryWatchDog", "trigger report, next threshold : native %s pss %s, isFg=%s, fgSvs=%s, bgDur=%s", Long.valueOf(this.AXh), Long.valueOf(this.AXi), Boolean.valueOf(aVar.cPB), Arrays.toString(aVar.AXr.toArray()), Long.valueOf(aVar.AXD));
                if (i2 != 3) {
                    Log.i("MicroMsg.MemoryWatchDog", "not SOURCE_AUTO_CHECK, dumpForegroundService");
                    i(aVar);
                }
                ((com.tencent.mm.plugin.performance.diagnostic.b.b) com.tencent.mm.plugin.performance.a.a.INSTANCE.aT(com.tencent.mm.plugin.performance.diagnostic.b.b.class)).a(aVar);
            }
            AppMethodBeat.o(201170);
        }
    }

    private static String processCmd() {
        AppMethodBeat.i(201171);
        if (MMApplicationContext.isMainProcess()) {
            AppMethodBeat.o(201171);
            return "mm";
        } else if (MMApplicationContext.isAppBrandProcess()) {
            AppMethodBeat.o(201171);
            return "appbrand";
        } else if (MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsMpProcess()) {
            AppMethodBeat.o(201171);
            return "tools";
        } else {
            AppMethodBeat.o(201171);
            return "all";
        }
    }

    public static class a {
        public long AXA;
        public long AXB;
        public long AXC = Thread.currentThread().getId();
        public long AXD = -1;
        public ActivityManager.MemoryInfo AXE;
        public int AXF;
        public int AXG;
        public a[] AXH;
        public boolean AXg;
        public int AXq;
        public List<String> AXr = new ArrayList();
        public boolean AXs = c.eCK();
        public boolean AXt;
        public long AXu;
        public long AXv;
        public long AXw;
        public long AXx;
        public long AXy;
        public long AXz;
        public String activity = BuildConfig.KINDA_DEFAULT;
        public boolean cPB;
        public long hju;
        public Map<String, String> map;
        public int pid;
        public String processName = "current";
        public int source = 0;

        public a() {
            AppMethodBeat.i(201149);
            AppMethodBeat.o(201149);
        }

        public final String toString() {
            Object obj;
            AppMethodBeat.i(201150);
            StringBuilder sb = new StringBuilder(" \n");
            StringBuilder append = sb.append(String.format(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> MemoryInfo(tid=%s) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<", Long.valueOf(this.AXC))).append("\n| Activity:\t").append(this.activity).append("\tAppForeground:").append(this.cPB).append("\tProcessForeground:").append(this.AXg).append(c.eCK() ? "\thasActivity:" : "");
            if (c.eCK()) {
                obj = Boolean.valueOf(this.AXt);
            } else {
                obj = "";
            }
            append.append(obj).append("\n| Source:\t ").append(this.source).append("\n| VmSize:\t ").append(this.AXq).append("kB\n| SystemMemoryInfo:\t totalMem=").append(this.AXE.totalMem).append(", availMem=").append(this.AXE.availMem).append(", lowMemory=").append(this.AXE.lowMemory).append(", threshold=").append(this.AXE.threshold).append("\n| Dalvik:\t memClass=").append(this.AXA).append(", memLargeClass=").append(this.AXB).append(" B, TalMemory=").append(this.AXx).append(" B, FreeMemory=").append(this.AXy).append(" B, MaxMemory=").append(this.AXz).append(" B\n| NATIVE:\t HeapSize=").append(this.AXu).append(" B, AllocatedSize=").append(this.AXv).append(" B, FreeSize=").append(this.AXw).append(" B\n| Stats:\t pss-sum:").append(this.AXG).append(" KB, ").append(aE(this.map)).append("\n| FgService:\t").append(Arrays.toString(this.AXr.toArray())).append("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> END(cost:").append(this.hju).append("ms) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
            if (this.AXH != null) {
                a[] aVarArr = this.AXH;
                for (a aVar : aVarArr) {
                    sb.append("| Process: ").append(aVar.processName).append(", pid: ").append(aVar.pid).append(", totalPss: ").append(aVar.AXF).append("\n");
                }
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(201150);
            return sb2;
        }

        private static String aE(Map<String, String> map2) {
            AppMethodBeat.i(201151);
            if (map2 == null) {
                AppMethodBeat.o(201151);
                return BuildConfig.COMMAND;
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                if (!entry.getKey().equals("java-heap") && !entry.getKey().equals("native-heap")) {
                    sb.append(entry.getKey().replaceFirst("summary.", "")).append("=").append(entry.getValue()).append(", ");
                }
            }
            sb.delete(sb.length() - 2, sb.length());
            String sb2 = sb.toString();
            AppMethodBeat.o(201151);
            return sb2;
        }
    }

    public final void onActivityCreated(Activity activity2, Bundle bundle) {
        AppMethodBeat.i(201172);
        if (MMApplicationContext.isAppBrandProcess() || MMApplicationContext.isToolsMpProcess() || MMApplicationContext.isToolsProcess()) {
            String str = activity2.toString() + ":" + activity2.hashCode();
            this.AXe.add(str);
            Log.i("MicroMsg.MemoryWatchDog", "onActivityCreated: %s, mActivities.size = %s", str, Integer.valueOf(this.AXe.size()));
        }
        AppMethodBeat.o(201172);
    }

    public final void onActivityResumed(Activity activity2) {
    }

    public final void onActivityPaused(Activity activity2) {
    }

    public final void onActivitySaveInstanceState(Activity activity2, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity2) {
        AppMethodBeat.i(201173);
        if (MMApplicationContext.isAppBrandProcess() || MMApplicationContext.isToolsMpProcess() || MMApplicationContext.isToolsProcess()) {
            String str = activity2.toString() + ":" + activity2.hashCode();
            this.AXe.remove(str);
            Log.i("MicroMsg.MemoryWatchDog", "onActivityDestroyed: %s, mActivities.size = %s", str, Integer.valueOf(this.AXe.size()));
        }
        AppMethodBeat.o(201173);
    }

    public final void eCL() {
        boolean z = true;
        AppMethodBeat.i(201166);
        a S = S(true, 3);
        new StringBuilder("[AutoCheck] ").append(S);
        Log.i("MicroMsg.MemoryWatchDog", "[AutoCheck] process = %s AppForeground = %s %s", MMApplicationContext.getProcessName(), Boolean.valueOf(this.cPB), S);
        if (this.AXe.isEmpty()) {
            z = false;
        }
        b.a(S, z);
        if (eCM()) {
            a(S, 3);
        }
        AppMethodBeat.o(201166);
    }
}
