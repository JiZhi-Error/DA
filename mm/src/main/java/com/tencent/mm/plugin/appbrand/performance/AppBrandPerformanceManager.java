package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.util.SparseArray;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.storage.GetStorageSizeTask;
import com.tencent.mm.plugin.appbrand.performance.f;
import com.tencent.mm.plugin.appbrand.ui.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

@SuppressLint({"DefaultLocale"})
public class AppBrandPerformanceManager {
    protected static final SparseArray<a> nwB = new SparseArray<>();

    static {
        AppMethodBeat.i(147593);
        AppMethodBeat.o(147593);
    }

    public static void aei(String str) {
        AppMethodBeat.i(147582);
        Log.d("MicroMsg.AppBrandPerformanceManager", "stopMonitoring, appId: %s", str);
        int hashCode = str.hashCode();
        a aVar = nwB.get(hashCode);
        if (aVar != null) {
            nwB.remove(hashCode);
            aVar.stop();
        }
        AppMethodBeat.o(147582);
    }

    public static void aej(String str) {
        AppMethodBeat.i(147583);
        Log.d("MicroMsg.AppBrandPerformanceManager", "enablePanel for AppId %s", str);
        SetAppPerformanceModeTask setAppPerformanceModeTask = new SetAppPerformanceModeTask((byte) 0);
        setAppPerformanceModeTask.mAppId = str;
        setAppPerformanceModeTask.mEnable = true;
        AppBrandMainProcessService.a(setAppPerformanceModeTask);
        AppMethodBeat.o(147583);
    }

    public static void aek(String str) {
        AppMethodBeat.i(147584);
        Log.d("MicroMsg.AppBrandPerformanceManager", "disablePanel for AppId %s", str);
        SetAppPerformanceModeTask setAppPerformanceModeTask = new SetAppPerformanceModeTask((byte) 0);
        setAppPerformanceModeTask.mAppId = str;
        setAppPerformanceModeTask.mEnable = false;
        AppBrandMainProcessService.a(setAppPerformanceModeTask);
        AppMethodBeat.o(147584);
    }

    public static boolean e(d dVar) {
        AppMethodBeat.i(147585);
        a aVar = (a) dVar.av(a.class);
        if (aVar == null || !aVar.nwy) {
            AppMethodBeat.o(147585);
            return false;
        }
        AppMethodBeat.o(147585);
        return true;
    }

    public static void a(d dVar, int i2, long j2) {
        AppMethodBeat.i(147586);
        a(dVar, i2, String.format("%d ms", Long.valueOf(j2)));
        AppMethodBeat.o(147586);
    }

    public static void a(d dVar, long j2) {
        AppMethodBeat.i(147591);
        a(dVar, 201, j2);
        AppMethodBeat.o(147591);
    }

    public static boolean h(d dVar) {
        AppMethodBeat.i(147592);
        if (!e(dVar)) {
            AppMethodBeat.o(147592);
            return false;
        }
        boolean ael = c.ael(dVar.mAppId);
        AppMethodBeat.o(147592);
        return ael;
    }

    static class SetAppPerformanceModeTask extends MainProcessTask {
        public static final Parcelable.Creator<SetAppPerformanceModeTask> CREATOR = new Parcelable.Creator<SetAppPerformanceModeTask>() {
            /* class com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.SetAppPerformanceModeTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SetAppPerformanceModeTask[] newArray(int i2) {
                return new SetAppPerformanceModeTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SetAppPerformanceModeTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(147576);
                SetAppPerformanceModeTask setAppPerformanceModeTask = new SetAppPerformanceModeTask((byte) 0);
                setAppPerformanceModeTask.f(parcel);
                AppMethodBeat.o(147576);
                return setAppPerformanceModeTask;
            }
        };
        private String mAppId;
        private boolean mEnable;

        private SetAppPerformanceModeTask() {
        }

        /* synthetic */ SetAppPerformanceModeTask(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(147577);
            ((com.tencent.luggage.sdk.customize.a) e.M(com.tencent.luggage.sdk.customize.a.class)).NL().cN(this.mAppId + "_PerformancePanelEnabled", this.mEnable ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            AppMethodBeat.o(147577);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(147578);
            this.mAppId = parcel.readString();
            this.mEnable = parcel.readByte() != 0;
            AppMethodBeat.o(147578);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(147579);
            parcel.writeString(this.mAppId);
            parcel.writeByte(this.mEnable ? (byte) 1 : 0);
            AppMethodBeat.o(147579);
        }

        static {
            AppMethodBeat.i(147580);
            AppMethodBeat.o(147580);
        }
    }

    /* access modifiers changed from: protected */
    public static class a implements Runnable {
        volatile boolean CA = false;
        protected final d cBE;
        protected final String mAppId;
        private volatile boolean mEnabled = true;
        private volatile double nwC = 0.0d;
        private volatile int nwD = 4;
        private volatile boolean nwE = false;
        protected volatile boolean nwF = false;
        private e nwG;
        f nwH;
        f.a nwI = new f.a() {
            /* class com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.performance.f.a
            public final void t(double d2) {
                AppMethodBeat.i(147566);
                if (Math.round(a.this.nwC) != Math.round(d2)) {
                    a.this.nwC = d2;
                    AppBrandPerformanceManager.a(a.this.cBE, 303, Math.round(a.this.nwC) + " fps");
                    c.a(a.this.mAppId, "Hardware", "FPS", a.this.nwC);
                }
                AppMethodBeat.o(147566);
            }
        };
        private h.c nwJ = new h.c() {
            /* class com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onDestroy() {
                AppMethodBeat.i(147567);
                super.onDestroy();
                a.this.stop();
                AppMethodBeat.o(147567);
            }

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void a(h.d dVar) {
                AppMethodBeat.i(147568);
                super.a(dVar);
                a aVar = a.this;
                aVar.CA = true;
                if (a.bSJ() && aVar.nwH != null) {
                    aVar.nwH.stop();
                }
                AppMethodBeat.o(147568);
            }

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onResume() {
                AppMethodBeat.i(147569);
                super.onResume();
                a aVar = a.this;
                aVar.CA = false;
                if (a.bSJ() && aVar.nwH != null) {
                    aVar.nwH.start();
                }
                AppMethodBeat.o(147569);
            }
        };

        public a(d dVar) {
            AppMethodBeat.i(147570);
            this.cBE = dVar;
            this.mAppId = dVar.mAppId;
            this.nwG = new e(Process.myPid());
            this.nwF = false;
            if (bSJ()) {
                this.nwH = new f();
                this.nwH.mInterval = 100;
                this.nwH.nwI = this.nwI;
            }
            AppMethodBeat.o(147570);
        }

        public final void start() {
            AppMethodBeat.i(147571);
            this.mEnabled = true;
            m.bZn().postToWorker(this);
            h.a(this.mAppId, this.nwJ);
            if (bSJ() && this.nwH != null) {
                this.nwH.start();
            }
            AppMethodBeat.o(147571);
        }

        public final void stop() {
            AppMethodBeat.i(147572);
            this.mEnabled = false;
            h.b(this.mAppId, this.nwJ);
            if (bSJ() && this.nwH != null) {
                this.nwH.stop();
            }
            if (this.nwG != null) {
                this.nwG.close();
            }
            AppMethodBeat.o(147572);
        }

        static boolean bSJ() {
            return Build.VERSION.SDK_INT >= 16;
        }

        /* access modifiers changed from: protected */
        public void bSK() {
            AppMethodBeat.i(147573);
            int selfMemInMB = Util.getSelfMemInMB(MMApplicationContext.getContext());
            AppBrandPerformanceManager.a(this.cBE, 102, selfMemInMB + "m");
            c.a(this.mAppId, "Hardware", "MEMORY", (double) selfMemInMB);
            AppMethodBeat.o(147573);
        }

        /* access modifiers changed from: protected */
        public void bSL() {
            if (!this.nwF) {
            }
        }

        /* access modifiers changed from: protected */
        public void bSM() {
            if (!this.nwF) {
            }
        }

        /* access modifiers changed from: protected */
        public void bSN() {
        }

        /* access modifiers changed from: protected */
        public void bSO() {
        }

        /* access modifiers changed from: protected */
        public void bSP() {
        }

        private void bSQ() {
            AppMethodBeat.i(147574);
            AppBrandSysConfigLU OM = this.cBE.OM();
            if (OM == null) {
                AppMethodBeat.o(147574);
            } else if (OM.leF == 1) {
                final GetStorageSizeTask getStorageSizeTask = new GetStorageSizeTask();
                getStorageSizeTask.appId = this.mAppId;
                getStorageSizeTask.lyv = new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(147565);
                        AppBrandPerformanceManager.a(a.this.cBE, 401, Util.getSizeKB((long) getStorageSizeTask.size));
                        getStorageSizeTask.bDK();
                        AppMethodBeat.o(147565);
                    }
                };
                getStorageSizeTask.bDJ();
                AppBrandMainProcessService.a(getStorageSizeTask);
                AppMethodBeat.o(147574);
            } else {
                AppBrandPerformanceManager.a(this.cBE, 401, Util.getSizeKB((long) ((com.tencent.luggage.sdk.customize.a) e.M(com.tencent.luggage.sdk.customize.a.class)).dD(this.mAppId).VL(this.mAppId)));
                AppMethodBeat.o(147574);
            }
        }

        public void run() {
            AppMethodBeat.i(147575);
            if (this.cBE.isDestroyed()) {
                AppMethodBeat.o(147575);
                return;
            }
            if (this.mEnabled && !this.CA) {
                double bSU = this.nwG.bSU();
                AppBrandPerformanceManager.a(this.cBE, 101, ((int) bSU) + "%");
                c.a(this.mAppId, "Hardware", "CPU", bSU);
                bSK();
                bSL();
                bSM();
                bSN();
                bSO();
                bSP();
                this.nwD++;
                if (this.nwD >= 4) {
                    this.nwD = 0;
                    bSQ();
                }
            }
            if (this.mEnabled) {
                m.bZn().j(this, 1000);
            }
            AppMethodBeat.o(147575);
        }
    }

    public static void d(d dVar) {
        AppMethodBeat.i(147581);
        String str = dVar.mAppId;
        Log.d("MicroMsg.AppBrandPerformanceManager", "startMonitoring, appId: %s", str);
        a aVar = nwB.get(str.hashCode());
        if (aVar == null) {
            aVar = new a(dVar);
            nwB.put(str.hashCode(), aVar);
        }
        aVar.start();
        AppMethodBeat.o(147581);
    }

    public static void a(d dVar, int i2, String str) {
        AppMethodBeat.i(147587);
        String str2 = dVar.mAppId;
        v vVar = dVar.cCl;
        if (vVar == null) {
            ad.aVe().G(str2.hashCode() + "performance_data", true).l(String.valueOf(i2), str);
            AppMethodBeat.o(147587);
            return;
        }
        vVar.aw(i2, str);
        AppMethodBeat.o(147587);
    }

    public static void a(d dVar, String str, String str2) {
        AppMethodBeat.i(147588);
        String str3 = dVar.mAppId;
        v vVar = dVar.cCl;
        if (vVar == null) {
            ad.aVe().G(str3.hashCode() + "performance_custom_data", true).l(str, str2);
            AppMethodBeat.o(147588);
            return;
        }
        vVar.eL(str, str2);
        AppMethodBeat.o(147588);
    }

    public static void f(d dVar) {
        AppMethodBeat.i(147589);
        String str = dVar.mAppId;
        v vVar = dVar.cCl;
        ad.b JW = ad.aVe().JW(str.hashCode() + "performance_data");
        if (vVar == null) {
            Log.e("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData panel is not ready.");
        } else if (JW == null) {
            Log.d("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData cache is empty.");
        } else {
            for (String str2 : JW.getKeySet()) {
                String str3 = (String) JW.get(str2);
                if (str3 != null) {
                    vVar.aw(Util.getInt(str2, 0), str3);
                }
            }
        }
        g(dVar);
        AppMethodBeat.o(147589);
    }

    private static void g(d dVar) {
        AppMethodBeat.i(147590);
        String str = dVar.mAppId;
        v vVar = dVar.cCl;
        ad.b JW = ad.aVe().JW(str.hashCode() + "performance_custom_data");
        if (vVar == null) {
            Log.e("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData panel is not ready.");
            AppMethodBeat.o(147590);
        } else if (JW == null) {
            Log.d("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData cache is empty.");
            AppMethodBeat.o(147590);
        } else {
            for (String str2 : JW.getKeySet()) {
                String str3 = (String) JW.get(str2);
                if (str3 != null) {
                    vVar.eL(str2, str3);
                }
            }
            AppMethodBeat.o(147590);
        }
    }
}
