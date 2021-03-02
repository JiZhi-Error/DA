package com.tencent.mm.plugin.performance.elf;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Debug;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractProcessChecker extends BroadcastReceiver {
    private MMHandler AUg;
    a AUh = new a(this, (byte) 0);
    private long AUi = -1;
    boolean cQp = true;

    /* access modifiers changed from: protected */
    public abstract boolean af(long j2, long j3);

    /* access modifiers changed from: protected */
    public abstract long eCr();

    /* access modifiers changed from: protected */
    public abstract boolean isEnable();

    /* access modifiers changed from: protected */
    public abstract void onScreenOff();

    /* access modifiers changed from: protected */
    public String getTag() {
        return "AbstractProcessChecker";
    }

    public static String getProcessName() {
        return MMApplicationContext.getProcessName();
    }

    /* access modifiers changed from: protected */
    public void hJ(int i2, int i3) {
    }

    /* access modifiers changed from: protected */
    public boolean eCo() {
        return true;
    }

    public AbstractProcessChecker() {
        ((Application) MMApplicationContext.getContext()).registerActivityLifecycleCallbacks(this.AUh);
        if (ElfCallUpReceiver.AUm > 0) {
            hJ(Process.myPid(), ElfCallUpReceiver.AUm);
        } else {
            Log.w(getTag(), "not processElf call up!");
        }
    }

    /* access modifiers changed from: protected */
    public void start() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_ELF_CHECK");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        MMApplicationContext.getContext().registerReceiver(this, intentFilter);
    }

    /* access modifiers changed from: protected */
    public final MMHandler getWorkerHandler() {
        if (this.AUg == null || this.AUg.isQuit()) {
            this.AUg = new MMHandler("ProcessChecker");
        }
        return this.AUg;
    }

    public final void onReceive(Context context, final Intent intent) {
        if (intent.getAction() == "ACTION_ELF_CHECK") {
            getWorkerHandler().post(new Runnable() {
                /* class com.tencent.mm.plugin.performance.elf.AbstractProcessChecker.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(124968);
                    if ("ACTION_ELF_CHECK".equals(intent.getAction())) {
                        ElfCheckRequest elfCheckRequest = (ElfCheckRequest) intent.getParcelableExtra("MicroMsg.ElfCheckRequest");
                        if (elfCheckRequest == null) {
                            Log.w("MicroMsg.AbstractProcessChecker", "pass this check,because request is null! ????");
                            AppMethodBeat.o(124968);
                            return;
                        }
                        boolean af = AbstractProcessChecker.this.af((long) Process.myPid(), elfCheckRequest.dap);
                        Log.i("MicroMsg.AbstractProcessChecker", "[onReceive] begin to check process[%s] isCanKill:%s isNeedReCall:%s", AbstractProcessChecker.getProcessName(), Boolean.valueOf(af), Boolean.valueOf(AbstractProcessChecker.this.eCo()));
                        if (af) {
                            AbstractProcessChecker.this.eCp();
                            AppMethodBeat.o(124968);
                            return;
                        }
                        AbstractProcessChecker.this.sD(false);
                    }
                    AppMethodBeat.o(124968);
                }
            });
        } else if (intent.getAction() == "android.intent.action.SCREEN_OFF") {
            onScreenOff();
        }
    }

    /* access modifiers changed from: protected */
    public final void eCp() {
        if (this.cQp || this.AUh.isResume) {
            Log.w("MicroMsg.AbstractProcessChecker", "pass this kill! app is on foreground!");
            e.INSTANCE.idkeyStat(959, 6, 1, true);
            sD(false);
            return;
        }
        sD(true);
        throw new RuntimeException(eCq());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sD(boolean z) {
        ElfCheckResponse elfCheckResponse = new ElfCheckResponse(isEnable(), eCr(), z, eCo(), MMApplicationContext.getProcessName(), ElfCallUpReceiver.class.getName());
        Bundle bundle = new Bundle();
        bundle.putInt("processId", Process.myPid());
        elfCheckResponse.Ew = bundle;
        Intent intent = new Intent("ACTION_ELF_CHECK_RESPONSE");
        intent.putExtra("MicroMsg.ElfCheckResponse", elfCheckResponse);
        MMApplicationContext.getContext().sendBroadcast(intent);
    }

    public void cy(boolean z) {
        this.cQp = z;
    }

    /* access modifiers changed from: protected */
    public String eCq() {
        return String.format("ProcessEfl found exception!kill process[%s] %s %s %s", Integer.valueOf(Process.myPid()), Long.valueOf(TN()), Long.valueOf(Debug.getNativeHeapSize()), Long.valueOf(Runtime.getRuntime().totalMemory()));
    }

    public static long TN() {
        Matcher matcher = Pattern.compile("\\d+").matcher(eCs());
        if (matcher.find()) {
            return ((long) Util.safeParseInt(matcher.group())) * 1000;
        }
        return -1;
    }

    private static String eCs() {
        try {
            String[] split = getStringFromFile(String.format("/proc/%s/status", Integer.valueOf(Process.myPid()))).trim().split("\n");
            for (String str : split) {
                if (str.startsWith("VmSize")) {
                    return str;
                }
            }
            return split[12];
        } catch (Exception e2) {
            return "";
        }
    }

    protected static long Sr() {
        try {
            String stringFromFile = getStringFromFile(String.format("/proc/%s/schedstat", Integer.valueOf(Process.myPid())));
            if (stringFromFile == null) {
                return -1;
            }
            return Util.safeParseLong(stringFromFile.replaceAll("\n", "").split(" ")[2]);
        } catch (Exception e2) {
            return -2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String convertStreamToString(java.io.InputStream r4) {
        /*
            r2 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x002f }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x002f }
            r3.<init>(r4)     // Catch:{ all -> 0x002f }
            r1.<init>(r3)     // Catch:{ all -> 0x002f }
        L_0x0010:
            java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x0027
            java.lang.StringBuilder r2 = r0.append(r2)     // Catch:{ all -> 0x0020 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0020:
            r0 = move-exception
        L_0x0021:
            if (r1 == 0) goto L_0x0026
            r1.close()
        L_0x0026:
            throw r0
        L_0x0027:
            r1.close()
            java.lang.String r0 = r0.toString()
            return r0
        L_0x002f:
            r0 = move-exception
            r1 = r2
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.performance.elf.AbstractProcessChecker.convertStreamToString(java.io.InputStream):java.lang.String");
    }

    private static String getStringFromFile(String str) {
        InputStream inputStream = null;
        try {
            inputStream = s.ao(new o(str));
            return convertStreamToString(inputStream);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    protected static int aD(Map<String, Integer> map) {
        int i2;
        ThreadGroup threadGroup = Looper.getMainLooper().getThread().getThreadGroup();
        Thread[] threadArr = new Thread[(threadGroup.activeCount() * 2)];
        int enumerate = threadGroup.enumerate(threadArr);
        int i3 = 0;
        int i4 = 0;
        while (i3 < enumerate) {
            String name = threadArr[i3].getName();
            if (!Util.isNullOrNil(name)) {
                String replaceAll = name.replaceAll("-?[0-9]\\d*", "?");
                if (map.containsKey(replaceAll)) {
                    map.put(replaceAll, Integer.valueOf(map.get(replaceAll).intValue() + 1));
                } else {
                    map.put(replaceAll, 1);
                }
                i2 = i4 + 1;
            } else {
                i2 = i4;
            }
            i3++;
            i4 = i2;
        }
        return i4;
    }

    /* access modifiers changed from: protected */
    public final boolean eCt() {
        ActivityManager activityManager = (ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (activityManager == null) {
            Log.e("MicroMsg.AbstractProcessChecker", "[isHighPriorityProcess] mActivityManager is null.");
            return false;
        }
        List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(50);
        if (runningServices != null) {
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                if (runningServiceInfo.foreground) {
                    Log.i(getTag(), "foreground service:%s process:%s ", runningServiceInfo.service, runningServiceInfo.process);
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public class a implements Application.ActivityLifecycleCallbacks {
        String AUk;
        boolean AUl;
        boolean isResume;

        private a() {
            this.AUk = "";
            this.AUl = false;
            this.isResume = true;
        }

        /* synthetic */ a(AbstractProcessChecker abstractProcessChecker, byte b2) {
            this();
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            AppMethodBeat.i(124969);
            if (activity.getClass().getSimpleName().endsWith("WeChatSplashActivity")) {
                this.AUl = true;
                Log.i(AbstractProcessChecker.this.getTag(), "WeChatSplashActivity was created!");
            }
            AppMethodBeat.o(124969);
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
            AppMethodBeat.i(124970);
            this.AUk = activity.getClass().getName();
            this.isResume = true;
            AppMethodBeat.o(124970);
        }

        public final void onActivityPaused(Activity activity) {
            AppMethodBeat.i(124971);
            if (Util.isNullOrNil(this.AUk)) {
                this.AUk = activity.getClass().getName();
            }
            AppMethodBeat.o(124971);
        }

        public final void onActivityStopped(Activity activity) {
            AppMethodBeat.i(124972);
            if (Util.isNullOrNil(this.AUk)) {
                this.AUk = activity.getClass().getName();
            }
            this.isResume = false;
            AppMethodBeat.o(124972);
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }
    }
}
