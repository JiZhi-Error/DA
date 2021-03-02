package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.co;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.model.e;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.k;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public class AppBrandRemoteTaskController extends MainProcessTask {
    public static final Parcelable.Creator<AppBrandRemoteTaskController> CREATOR = new Parcelable.Creator<AppBrandRemoteTaskController>() {
        /* class com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.AnonymousClass3 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandRemoteTaskController[] newArray(int i2) {
            return new AppBrandRemoteTaskController[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandRemoteTaskController createFromParcel(Parcel parcel) {
            AppMethodBeat.i(227474);
            AppBrandRemoteTaskController appBrandRemoteTaskController = new AppBrandRemoteTaskController();
            appBrandRemoteTaskController.f(parcel);
            AppMethodBeat.o(227474);
            return appBrandRemoteTaskController;
        }
    };
    private static long nPg;
    private static boolean nPl = false;
    int appType = 0;
    private transient k kCd = null;
    private transient f kDA = null;
    private String kIA;
    public String mAppId;
    int mDebugType;
    String mProcessName;
    private boolean nPb;
    private int nPc = -1;
    public a nPd = a.NONE;
    private int nPe;
    private long nPf;
    private g nPh = g.NIL;
    String nPi;
    private AppBrandInitConfigWC nPj;
    private transient boolean nPk = false;

    public enum a {
        NONE,
        REGISTER,
        UPDATE,
        REMOVE,
        KILL,
        KILL_ALL,
        ASSERT,
        CHECK_ALIVE,
        NETWORK_CHANGE,
        CLEAR_DUPLICATED,
        PRELOAD,
        NOTIFY_PAUSE,
        CLOSE;

        public static a valueOf(String str) {
            AppMethodBeat.i(48410);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(48410);
            return aVar;
        }

        static {
            AppMethodBeat.i(48411);
            AppMethodBeat.o(48411);
        }
    }

    public final String aiv() {
        return this.nPi;
    }

    public final String getAppId() {
        return this.mAppId;
    }

    public final int brf() {
        return this.mDebugType;
    }

    public final void a(f fVar) {
        AppMethodBeat.i(227476);
        this.mProcessName = MMApplicationContext.getProcessName();
        this.kIA = AppBrandPluginUI.class.getName();
        this.kDA = fVar;
        bDJ();
        AppMethodBeat.o(227476);
    }

    public final void a(k kVar, f fVar) {
        AppMethodBeat.i(48412);
        Activity activity = kVar.getActivity();
        this.mProcessName = MMApplicationContext.getProcessName();
        this.kIA = activity.getClass().getName();
        this.kCd = kVar;
        this.kDA = fVar;
        bDJ();
        AppMethodBeat.o(48412);
    }

    public final void N(q qVar) {
        boolean z;
        AppMethodBeat.i(227478);
        this.nPd = a.REGISTER;
        if (this.kCd != null) {
            z = true;
        } else {
            z = false;
        }
        this.nPb = z;
        Log.i("MicroMsg.AppBrandRemoteTaskController", "registerForClientProcess appId:%s, type:%d, mAttachedToUI:%b, taskId:%s, stack:%s", qVar.mAppId, Integer.valueOf(qVar.kAq.eix), Boolean.valueOf(this.nPb), this.jEY, android.util.Log.getStackTraceString(new Throwable()));
        M(qVar);
        AppBrandMainProcessService.a(this);
        AppMethodBeat.o(227478);
    }

    public final void O(q qVar) {
        boolean z;
        AppMethodBeat.i(227479);
        this.nPd = a.UPDATE;
        if (this.kCd != null) {
            z = true;
        } else {
            z = false;
        }
        this.nPb = z;
        Log.i("MicroMsg.AppBrandRemoteTaskController", "updateForClientProcess appId:%s, type:%d, mAttachedToUI:%b, taskId:%s, stack:%s", qVar.mAppId, Integer.valueOf(qVar.kAq.eix), Boolean.valueOf(this.nPb), this.jEY, android.util.Log.getStackTraceString(new Throwable()));
        M(qVar);
        AppBrandMainProcessService.a(this);
        AppMethodBeat.o(227479);
    }

    public final void aeZ(String str) {
        AppMethodBeat.i(48414);
        Log.i("MicroMsg.AppBrandRemoteTaskController", "removeForClientProcess appId:%s, stack:%s", str, android.util.Log.getStackTraceString(new Throwable()));
        this.nPd = a.REMOVE;
        this.mAppId = str;
        AppBrandMainProcessService.a(this);
        AppMethodBeat.o(48414);
    }

    static {
        AppMethodBeat.i(48428);
        AppMethodBeat.o(48428);
    }

    public final void iC(boolean z) {
        AppMethodBeat.i(48416);
        if (!nPl || z) {
            this.nPd = a.PRELOAD;
            AppBrandMainProcessService.a(this);
            nPl = true;
            AppMethodBeat.o(48416);
            return;
        }
        AppMethodBeat.o(48416);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void hg(boolean z) {
        AppMethodBeat.i(180368);
        if (!z) {
            Log.e("MicroMsg.AppBrandRemoteTaskController", "onCallbackResult failed, mOp[%s], mAppId[%s], mClsName[%s]", this.nPd, this.mAppId, this.kIA);
        }
        AppMethodBeat.o(180368);
    }

    /* access modifiers changed from: package-private */
    public final void afa(String str) {
        AppMethodBeat.i(48417);
        Log.i("MicroMsg.AppBrandRemoteTaskController", "removeForMainProcess appId[%s] mIgnoreRemovalForMainProcessOnce[%b], stack = %s", str, Boolean.valueOf(this.nPk), android.util.Log.getStackTraceString(new Throwable()));
        if (this.nPk) {
            Log.i("MicroMsg.AppBrandRemoteTaskController", "removeForMainProcess, ignore once");
            AppMethodBeat.o(48417);
            return;
        }
        this.nPd = a.REMOVE;
        this.mAppId = str;
        bVU();
        bDU();
        AppMethodBeat.o(48417);
    }

    /* access modifiers changed from: package-private */
    public final void zl(int i2) {
        AppMethodBeat.i(48418);
        Log.i("MicroMsg.AppBrandRemoteTaskController", "killForMainProcess(%d), class[%s] appId[%s] debugType[%d]", Integer.valueOf(i2), this.kIA, this.mAppId, Integer.valueOf(this.mDebugType));
        this.nPd = a.KILL;
        this.nPe = i2;
        bDU();
        AppMethodBeat.o(48418);
    }

    /* access modifiers changed from: package-private */
    public final boolean bVS() {
        AppMethodBeat.i(48419);
        this.nPd = a.CHECK_ALIVE;
        boolean bDU = bDU();
        AppMethodBeat.o(48419);
        return bDU;
    }

    /* access modifiers changed from: package-private */
    public final void bVT() {
        AppMethodBeat.i(227480);
        this.nPd = a.NETWORK_CHANGE;
        bDU();
        AppMethodBeat.o(227480);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        AppMethodBeat.i(48420);
        if (this.nPd == null) {
            Log.e("MicroMsg.AppBrandRemoteTaskController", "runInMainProcess null==mOp");
            AppMethodBeat.o(48420);
            return;
        }
        switch (this.nPd) {
            case REGISTER:
                afb("REGISTER");
                synchronized (AppBrandRemoteTaskController.class) {
                    try {
                        if (nPg == 0) {
                            long currentTimeMillis = System.currentTimeMillis();
                            nPg = currentTimeMillis;
                            try {
                                SharedPreferences.Editor edit = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "pref_appbrand_process", 4).edit();
                                edit.putLong("on_wxa_process_connected_time", currentTimeMillis);
                                edit.commit();
                                Log.v("MicroMsg.AppBrandReporter", "update timestamp(%s)", Long.valueOf(currentTimeMillis));
                            } catch (Throwable th) {
                                Log.printErrStackTrace("MicroMsg.AppBrandReporter", th, "updateTimestamp(%d)", Long.valueOf(currentTimeMillis));
                            }
                        }
                        this.nPf = nPg;
                    } catch (Throwable th2) {
                        AppMethodBeat.o(48420);
                        throw th2;
                    }
                }
                bDU();
                AppMethodBeat.o(48420);
                return;
            case UPDATE:
                afb("UPDATE");
                AppMethodBeat.o(48420);
                return;
            case REMOVE:
                bVU();
                AppMethodBeat.o(48420);
                return;
            case KILL_ALL:
                h.bWb().zn(this.nPe);
                AppMethodBeat.o(48420);
                return;
            case CLEAR_DUPLICATED:
                afc(this.mAppId);
                AppMethodBeat.o(48420);
                return;
            case PRELOAD:
                h.bWc().a(this.nPh, z.APPBRAND_RUNTIME_PRELOAD_NEXT, true);
                AppMethodBeat.o(48420);
                return;
            case NOTIFY_PAUSE:
                e eVar = e.INSTANCE;
                e.a aVar = eVar.nIC.get(this.mAppId);
                if (aVar != null) {
                    aVar.nIE = Util.nowMilliSecond();
                    break;
                }
                break;
        }
        AppMethodBeat.o(48420);
    }

    private void afb(String str) {
        AppMethodBeat.i(227481);
        if (this.nPj != null) {
            if (h.bzT() != null) {
                h.bzT().a(this.nPj.username, this.nPj);
            } else {
                final AppBrandInitConfigWC appBrandInitConfigWC = this.nPj;
                new IListener<co>() {
                    /* class com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.AnonymousClass1 */

                    {
                        AppMethodBeat.i(227471);
                        this.__eventId = co.class.getName().hashCode();
                        AppMethodBeat.o(227471);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(co coVar) {
                        AppMethodBeat.i(227472);
                        h.bzT().a(appBrandInitConfigWC.username, appBrandInitConfigWC);
                        dead();
                        AppMethodBeat.o(227472);
                        return false;
                    }
                }.alive();
            }
        }
        if (!this.nPb) {
            Log.i("MicroMsg.AppBrandRemoteTaskController", "updateImplByMainProcess, !mAttachedToUI, reason:%s, class:%s, appId:%s, versionType:%d, usedCommLibVersion:%d, instanceId:%s", str, this.kIA, this.mAppId, Integer.valueOf(this.mDebugType), Integer.valueOf(this.nPc), this.nPi);
            AppMethodBeat.o(227481);
            return;
        }
        n b2 = h.bWc().b(this.kIA, this.nPh);
        if (b2 == null) {
            Log.e("MicroMsg.AppBrandRemoteTaskController", "updateImplByMainProcess, task==null, reason:%s, class:%s appId:%s, versionType:%d, usedCommLibVersion:%d, instanceId:%s", str, this.kIA, this.mAppId, Integer.valueOf(this.mDebugType), Integer.valueOf(this.nPc), this.nPi);
            AppMethodBeat.o(227481);
            return;
        }
        Log.i("MicroMsg.AppBrandRemoteTaskController", "updateImplByMainProcess, reason:%s, class:%s, appId:%s, versionType:%d, usedCommLibVersion:%d, instanceId:%s", str, this.kIA, this.mAppId, Integer.valueOf(this.mDebugType), Integer.valueOf(this.nPc), this.nPi);
        b2.a(this.mAppId, this.mDebugType, this);
        b2.nPc = this.nPc;
        h.bWc().b(b2);
        h.bWb().a(this.mAppId, this);
        AppMethodBeat.o(227481);
    }

    private void bVU() {
        AppMethodBeat.i(48422);
        if (h.bWc().a(this.mAppId, this.kIA, this.nPh) == null) {
            h.bWb().a(this.mAppId, this);
            AppMethodBeat.o(48422);
            return;
        }
        h.bWc().afk(this.mAppId);
        AppMethodBeat.o(48422);
    }

    private synchronized void afc(String str) {
        AppMethodBeat.i(48423);
        Log.i("MicroMsg.AppBrandRemoteTaskController", "clearDuplicatedImplByMainProcess");
        this.nPk = true;
        h.bWb().afe(str);
        this.nPk = false;
        AppMethodBeat.o(48423);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjk() {
        AppMethodBeat.i(48424);
        if (this.nPd == null) {
            Log.e("MicroMsg.AppBrandRemoteTaskController", "runInClientProcess null==mOp");
            AppMethodBeat.o(48424);
            return;
        }
        switch (this.nPd) {
            case REMOVE:
                bVV();
                AppMethodBeat.o(48424);
                return;
            case CLOSE:
                this.kDA.vB(hashCode());
                AppMethodBeat.o(48424);
                return;
            case KILL:
                if (this.kCd == null) {
                    Log.e("MicroMsg.AppBrandRemoteTaskController", "killImplByClientProcess mUIController==null, appId:%s, type:%d", this.mAppId, Integer.valueOf(this.mDebugType));
                }
                switch (this.nPe) {
                    case 0:
                    case 3:
                        b.Lm(MMApplicationContext.getProcessName());
                        if (this.kCd != null) {
                            this.kCd.finish();
                        } else {
                            bVV();
                        }
                        if (this.nPe == 0) {
                            iC(true);
                        }
                        com.tencent.mm.hellhoundlib.b.a a2 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                        Object obj = new Object();
                        com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController", "killImplByClientProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                        Process.killProcess(((Integer) a2.pG(0)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController", "killImplByClientProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                        AppMethodBeat.o(48424);
                        return;
                    case 1:
                    case 2:
                    default:
                        if (this.kCd != null) {
                            this.kCd.a(new k.a() {
                                /* class com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.AnonymousClass2 */

                                @Override // com.tencent.mm.plugin.appbrand.task.k.a
                                public final void proceed() {
                                    AppMethodBeat.i(227473);
                                    AppBrandRemoteTaskController.a(AppBrandRemoteTaskController.this);
                                    AppMethodBeat.o(227473);
                                }
                            });
                            AppMethodBeat.o(48424);
                            return;
                        }
                        bVV();
                        AppMethodBeat.o(48424);
                        return;
                }
            case ASSERT:
                Assert.assertTrue("AppBrand Test Assert", false);
                AppMethodBeat.o(48424);
                return;
            case NETWORK_CHANGE:
                this.kDA.onNetworkChange(hashCode());
                break;
        }
        AppMethodBeat.o(48424);
    }

    private void bVV() {
        AppMethodBeat.i(227482);
        this.kDA.vA(hashCode());
        AppMethodBeat.o(227482);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4 = -1;
        AppMethodBeat.i(48425);
        parcel.writeString(this.mAppId);
        parcel.writeInt(this.mDebugType);
        parcel.writeString(this.kIA);
        parcel.writeInt(this.nPd == null ? -1 : this.nPd.ordinal());
        parcel.writeInt(this.nPe);
        parcel.writeLong(this.nPf);
        if (this.nPh != null) {
            i4 = this.nPh.ordinal();
        }
        parcel.writeInt(i4);
        parcel.writeString(this.nPi);
        parcel.writeInt(this.nPc);
        parcel.writeString(this.mProcessName);
        if (this.nPb) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeInt(this.appType);
        parcel.writeParcelable(this.nPj, 0);
        AppMethodBeat.o(48425);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        AppMethodBeat.i(48426);
        this.mAppId = parcel.readString();
        this.mDebugType = parcel.readInt();
        this.kIA = parcel.readString();
        int readInt = parcel.readInt();
        this.nPd = (readInt == -1 || readInt >= a.values().length) ? null : a.values()[readInt];
        this.nPe = parcel.readInt();
        this.nPf = parcel.readLong();
        int readInt2 = parcel.readInt();
        this.nPh = (readInt2 == -1 || readInt2 >= g.values().length) ? g.NIL : g.values()[readInt2];
        this.nPi = parcel.readString();
        this.nPc = parcel.readInt();
        this.mProcessName = parcel.readString();
        this.nPb = parcel.readByte() != 0;
        this.appType = parcel.readInt();
        this.nPj = (AppBrandInitConfigWC) parcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader());
        AppMethodBeat.o(48426);
    }

    public final void M(q qVar) {
        AppMethodBeat.i(227477);
        this.mAppId = qVar.mAppId;
        this.mDebugType = qVar.kAq.eix;
        this.nPh = g.j(qVar.bsC());
        this.appType = qVar.bsC().cyo + 1000;
        this.nPi = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(qVar.mAppId).kEY;
        ICommLibReader bqZ = qVar.bqZ();
        this.nPc = bqZ == null ? -1 : bqZ.bvd();
        this.nPj = qVar.bsC();
        AppMethodBeat.o(227477);
    }

    static /* synthetic */ void a(AppBrandRemoteTaskController appBrandRemoteTaskController) {
        AppMethodBeat.i(48427);
        appBrandRemoteTaskController.nPd = a.KILL_ALL;
        appBrandRemoteTaskController.nPe = 0;
        AppBrandMainProcessService.a(appBrandRemoteTaskController);
        AppMethodBeat.o(48427);
    }
}
