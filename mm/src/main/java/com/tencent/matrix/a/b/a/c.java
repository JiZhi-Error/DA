package com.tencent.matrix.a.b.a;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.a.b.a.g;
import com.tencent.matrix.a.c.h;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c extends a {
    int cSF = 1024;
    int cSG = 1024;
    int cSH = 100;
    List<C0207c> cSI = Collections.emptyList();
    List<h.a> cSJ = Collections.emptyList();
    Runnable cSK = new Runnable() {
        /* class com.tencent.matrix.a.b.a.c.AnonymousClass1 */

        public final void run() {
            if (c.this.cSI.size() >= c.this.cSq.cSe.cRQ) {
                synchronized ("Matrix.battery.AppStatMonitorFeature") {
                    h.K(c.this.cSI);
                }
            }
            if (c.this.cSJ.size() >= c.this.cSq.cSe.cRQ) {
                synchronized ("Matrix.battery.AppStatMonitorFeature") {
                    h.K(c.this.cSJ);
                }
            }
        }
    };

    public interface a {
        void a(boolean z, int i2, int i3, ComponentName componentName, long j2);
    }

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void d(com.tencent.matrix.a.b.c cVar) {
        super.d(cVar);
        this.cSH = Math.max(cVar.cSe.cRR, 100);
    }

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void Se() {
        super.Se();
        C0207c cVar = new C0207c(1);
        h.a aVar = new h.a(this.cSq.getScene());
        synchronized ("Matrix.battery.AppStatMonitorFeature") {
            this.cSI = new ArrayList();
            this.cSI.add(0, cVar);
            this.cSJ = new ArrayList();
            this.cSJ.add(0, aVar);
        }
    }

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void Sf() {
        super.Sf();
        synchronized ("Matrix.battery.AppStatMonitorFeature") {
            this.cSI.clear();
            this.cSJ.clear();
        }
    }

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void onForeground(boolean z) {
        super.onForeground(z);
        int k = com.tencent.matrix.a.c.c.k(com.tencent.matrix.a.b.c.getContext(), z);
        synchronized ("Matrix.battery.AppStatMonitorFeature") {
            if (this.cSI != Collections.EMPTY_LIST) {
                this.cSI.add(0, new C0207c(k));
                Sj();
            }
        }
        com.tencent.matrix.g.c.i("Matrix.battery.AppStatMonitorFeature", "updateAppImportance when app " + (z ? "foreground" : "background"), new Object[0]);
        Sk();
    }

    @Override // com.tencent.matrix.a.b.a.g, com.tencent.matrix.a.b.a.a
    public final void ba(long j2) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        super.ba(j2);
        com.tencent.matrix.g.c.i("Matrix.battery.AppStatMonitorFeature", "#onBackgroundCheck, during = ".concat(String.valueOf(j2)), new Object[0]);
        if (this.cSG > this.cSH || this.cSF > this.cSH) {
            Context context = com.tencent.matrix.a.b.c.getContext();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            if (!(activityManager == null || (runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) == null)) {
                for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                    if (!TextUtils.isEmpty(runningServiceInfo.process) && runningServiceInfo.process.startsWith(context.getPackageName()) && runningServiceInfo.foreground) {
                        com.tencent.matrix.g.c.i("Matrix.battery.AppStatMonitorFeature", "checkForegroundService whether app importance is low, during = ".concat(String.valueOf(j2)), new Object[0]);
                        if (this.cSG > this.cSH) {
                            com.tencent.matrix.g.c.w("Matrix.battery.AppStatMonitorFeature", "foreground service detected with low global importance: " + this.cSF + ", " + this.cSG + ", " + runningServiceInfo.service, new Object[0]);
                            this.cSq.a(false, this.cSF, this.cSG, runningServiceInfo.service, j2);
                        }
                        if (this.cSF > this.cSH && runningServiceInfo.process.equals(context.getPackageName())) {
                            com.tencent.matrix.g.c.w("Matrix.battery.AppStatMonitorFeature", "foreground service detected with low app importance: " + this.cSF + ", " + this.cSG + ", " + runningServiceInfo.service, new Object[0]);
                            this.cSq.a(true, this.cSF, this.cSG, runningServiceInfo.service, j2);
                        }
                    }
                }
            }
        }
    }

    public final void eq(String str) {
        synchronized ("Matrix.battery.AppStatMonitorFeature") {
            if (this.cSJ != Collections.EMPTY_LIST) {
                this.cSJ.add(0, new h.a(str));
                Sj();
            }
        }
        com.tencent.matrix.g.c.i("Matrix.battery.AppStatMonitorFeature", "updateAppImportance when launch: ".concat(String.valueOf(str)), new Object[0]);
        Sk();
    }

    private void Sj() {
        this.cSq.mHandler.removeCallbacks(this.cSK);
        this.cSq.mHandler.postDelayed(this.cSK, 1000);
    }

    private void Sk() {
        if (this.cSF > this.cSH || this.cSG > this.cSH) {
            AnonymousClass2 r0 = new Runnable() {
                /* class com.tencent.matrix.a.b.a.c.AnonymousClass2 */

                public final void run() {
                    String str;
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
                    Context context = com.tencent.matrix.a.b.c.getContext();
                    String packageName = context.getPackageName();
                    if (packageName.contains(":")) {
                        str = packageName.substring(0, packageName.indexOf(":"));
                    } else {
                        str = packageName;
                    }
                    ActivityManager activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
                    if (!(activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null)) {
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (runningAppProcessInfo.processName.startsWith(str)) {
                                if (c.this.cSG > runningAppProcessInfo.importance) {
                                    com.tencent.matrix.g.c.i("Matrix.battery.AppStatMonitorFeature", "update global importance: " + c.this.cSG + " > " + runningAppProcessInfo.importance + ", reason = " + runningAppProcessInfo.importanceReasonComponent, new Object[0]);
                                    c.this.cSG = runningAppProcessInfo.importance;
                                }
                                if (runningAppProcessInfo.processName.equals(context.getPackageName()) && c.this.cSF > runningAppProcessInfo.importance) {
                                    com.tencent.matrix.g.c.i("Matrix.battery.AppStatMonitorFeature", "update app importance: " + c.this.cSF + " > " + runningAppProcessInfo.importance + ", reason = " + runningAppProcessInfo.importanceReasonComponent, new Object[0]);
                                    c.this.cSF = runningAppProcessInfo.importance;
                                }
                            }
                        }
                    }
                }
            };
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.cSq.mHandler.post(r0);
            } else {
                r0.run();
            }
        }
    }

    @Override // com.tencent.matrix.a.b.a.g
    public final int Sg() {
        return Integer.MAX_VALUE;
    }

    public final b bb(long j2) {
        try {
            C0207c cVar = new C0207c(com.tencent.matrix.a.c.c.k(com.tencent.matrix.a.b.c.getContext(), this.cSq.cSh));
            synchronized ("Matrix.battery.AppStatMonitorFeature") {
                if (this.cSI != Collections.EMPTY_LIST) {
                    this.cSI.add(0, cVar);
                }
            }
            h.b a2 = h.a(this.cSI, j2);
            b bVar = new b();
            bVar.cTq = a2.cTq;
            bVar.cSM = g.a.c.b.b(Long.valueOf(a2.cUw));
            bVar.cSN = g.a.c.b.b(Long.valueOf((long) a2.ex("1")));
            bVar.cSO = g.a.c.b.b(Long.valueOf((long) a2.ex("2")));
            bVar.cSP = g.a.c.b.b(Long.valueOf((long) a2.ex(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)));
            return bVar;
        } catch (Throwable th) {
            com.tencent.matrix.g.c.w("Matrix.battery.AppStatMonitorFeature", "configureSnapshot fail: " + th.getMessage(), new Object[0]);
            b bVar2 = new b();
            bVar2.cTq = false;
            return bVar2;
        }
    }

    /* renamed from: com.tencent.matrix.a.b.a.c$c  reason: collision with other inner class name */
    static final class C0207c extends h.a {
        public C0207c(int i2) {
            super(String.valueOf(i2));
        }
    }

    public static final class b extends g.a<b> {
        public g.a.c.b<Long> cSM = g.a.c.b.b(0L);
        public g.a.c.b<Long> cSN = g.a.c.b.b(0L);
        public g.a.c.b<Long> cSO = g.a.c.b.b(0L);
        public g.a.c.b<Long> cSP = g.a.c.b.b(0L);

        b() {
        }
    }

    public final h.b bc(long j2) {
        try {
            h.a aVar = new h.a(this.cSq.getScene());
            synchronized ("Matrix.battery.AppStatMonitorFeature") {
                if (this.cSJ != Collections.EMPTY_LIST) {
                    this.cSJ.add(0, aVar);
                }
            }
            return h.a(this.cSJ, j2);
        } catch (Throwable th) {
            com.tencent.matrix.g.c.w("Matrix.battery.AppStatMonitorFeature", "currentSceneSnapshot fail: " + th.getMessage(), new Object[0]);
            h.b bVar = new h.b();
            bVar.cTq = false;
            return bVar;
        }
    }
}
