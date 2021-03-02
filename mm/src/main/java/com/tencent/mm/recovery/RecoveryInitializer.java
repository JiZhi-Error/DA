package com.tencent.mm.recovery;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.os.Looper;
import android.support.annotation.Keep;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.booter.aa;
import com.tencent.mm.cc.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cr;
import com.tencent.mm.recovery.a;
import com.tencent.mm.recovery.ui.RecoveryUI;
import com.tencent.mm.recoveryv2.a;
import com.tencent.mm.recoveryv2.b;
import com.tencent.mm.recoveryv2.f;
import com.tencent.mm.recoveryv2.h;
import com.tencent.mm.recoveryv2.i;
import com.tencent.mm.recoveryv2.k;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tinkerboots.sdk.a;
import java.io.File;
import java.lang.Thread;
import java.util.List;

@Keep
@SuppressLint({"LongLogTag"})
public class RecoveryInitializer {
    private static final int RECOVERY_SETTING_DEBUG = 30000;
    private static final String TAG = "MicroMsg.recovery.initializer";

    @Keep
    public static boolean init(final Context context) {
        boolean z;
        AppMethodBeat.i(193894);
        try {
            z = isStartWithActivity(context);
        } catch (Throwable th) {
            f.w(TAG, "check isStartWithActivity error", th);
            z = false;
        }
        if (!z) {
            f.i(TAG, "isStartWithActivity = false, skip recovery detect");
            AppMethodBeat.o(193894);
            return true;
        } else if (k.iT(context)) {
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                /* class com.tencent.mm.recovery.RecoveryInitializer.AnonymousClass1 */

                public final void uncaughtException(Thread thread, Throwable th) {
                    AppMethodBeat.i(193891);
                    f.w(RecoveryInitializer.TAG, "recovery process crash, thread = " + thread.getName(), th);
                    f.iL(context);
                    AppMethodBeat.o(193891);
                }
            });
            try {
                MMApplicationContext.setContext(context);
                try {
                    MMApplicationContext.setResources(b.a(context.getResources(), context, true));
                    LocaleUtil.initLanguage(context);
                } catch (Throwable th2) {
                    f.w(TAG, "init MMResources fail", th2);
                }
                h hVar = new h(k.guZ(), d.dks.getApplication(), d.dks);
                hVar.gmN = com.tencent.mm.booter.d.cg(hVar.ca);
                g.a(hVar);
                com.tencent.mm.vfs.g.setContext(context);
                com.tencent.f.g.a(hVar.ca, new aa());
                PlatformComm.init(MMApplicationContext.getContext(), new MMHandler(Looper.getMainLooper()));
                cr.aWI();
                a.a(new a.C2238a(d.dks).a(new com.tencent.tinker.lib.d.b(context) {
                    /* class com.tencent.mm.recovery.b.AnonymousClass1 */

                    @Override // com.tencent.tinker.lib.d.d, com.tencent.tinker.lib.d.b
                    public final void e(File file, int i2) {
                        int i3;
                        AppMethodBeat.i(193896);
                        super.e(file, i2);
                        f.i("MicroMsg.recovery.operator", "#onPatchPackageCheckFail, code = ".concat(String.valueOf(i2)));
                        if (i2 != 0) {
                            i3 = Math.abs(i2) + 10;
                        } else {
                            i3 = 0;
                        }
                        i iQ = i.iQ(this.context);
                        iQ.NBY = false;
                        iQ.NBX = i3;
                        iQ.save();
                        AppMethodBeat.o(193896);
                    }
                }).hvY());
                k.guX().a("diagnostic_mmkv_reset", new a.AbstractC2042a("diagnostic_storage") {
                    /* class com.tencent.mm.recovery.a.AnonymousClass1 */

                    @Override // com.tencent.mm.recoveryv2.e
                    public final void guu() {
                        AppMethodBeat.i(193889);
                        bhA(".cmd.diagnostic.MemoryHook.$enable");
                        bhA(".cmd.diagnostic.PthreadHook.$enable");
                        bhz(".cmd.diagnostic.MemoryHook.crash");
                        bhz(".cmd.diagnostic.PthreadHook.crash");
                        AppMethodBeat.o(193889);
                    }
                });
                k.guX().a("jectl_mmkv_reset", new a.AbstractC2042a("jectl_config") {
                    /* class com.tencent.mm.recovery.a.AnonymousClass2 */

                    @Override // com.tencent.mm.recoveryv2.e
                    public final void guu() {
                        AppMethodBeat.i(193890);
                        bhA("JE_KEY_ENABLE_BOOLEAN");
                        AppMethodBeat.o(193890);
                    }
                });
            } catch (Throwable th3) {
                f.w(TAG, "recovery process init error", th3);
                f.iL(context);
            }
            AppMethodBeat.o(193894);
            return false;
        } else if (!k.iS(context)) {
            AppMethodBeat.o(193894);
            return true;
        } else {
            k guX = k.guX();
            if (context != null) {
                guX.mContext = context;
            }
            AnonymousClass4 r2 = new b.c() {
                /* class com.tencent.mm.recovery.RecoveryInitializer.AnonymousClass4 */

                @Override // com.tencent.mm.recoveryv2.b.c
                public final Class<? extends Activity> guw() {
                    return RecoveryUI.class;
                }

                @Override // com.tencent.mm.recoveryv2.b.c
                public final Class<? extends Service> gux() {
                    return WXRecoveryUploadService.class;
                }
            };
            if (guX.NCs == null) {
                guX.guY();
            }
            guX.NCs.a(r2);
            k b2 = guX.b(1, new com.tencent.mm.recoveryv2.d() {
                /* class com.tencent.mm.recovery.RecoveryInitializer.AnonymousClass3 */

                @Override // com.tencent.mm.recoveryv2.d
                public final void ajq(int i2) {
                    AppMethodBeat.i(193893);
                    Log.e(RecoveryInitializer.TAG, "onRecovery, level = ".concat(String.valueOf(i2)));
                    AppMethodBeat.o(193893);
                }
            }).b(2, new com.tencent.mm.recoveryv2.d() {
                /* class com.tencent.mm.recovery.RecoveryInitializer.AnonymousClass2 */

                @Override // com.tencent.mm.recoveryv2.d
                public final void ajq(int i2) {
                    AppMethodBeat.i(193892);
                    Log.e(RecoveryInitializer.TAG, "onRecovery, level = ".concat(String.valueOf(i2)));
                    AppMethodBeat.o(193892);
                }
            });
            if (!k.iS(b2.getContext())) {
                a.C2043a.log(4, "MicroMsg.recovery", "not main proc, skip");
            } else if (!h.a.iN(b2.getContext()).mEnabled) {
                a.C2043a.log(4, "MicroMsg.recovery", "Recovery is disabled, skip");
            } else {
                if (b2.NCs == null) {
                    b2.guY();
                }
                b2.NCs.begin();
            }
            AppMethodBeat.o(193894);
            return true;
        }
    }

    private static boolean isStartWithActivity(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        AppMethodBeat.i(193895);
        ActivityManager activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (!(activityManager == null || (runningTasks = activityManager.getRunningTasks(Integer.MAX_VALUE)) == null)) {
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                if (runningTaskInfo.numActivities > 0) {
                    String packageName = context.getPackageName();
                    ComponentName componentName = runningTaskInfo.topActivity;
                    if (componentName != null && packageName.equals(componentName.getPackageName())) {
                        AppMethodBeat.o(193895);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.o(193895);
        return false;
    }
}
