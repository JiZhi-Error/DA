package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.a.b;

public final class e {
    private static volatile boolean kIi = false;
    private static volatile boolean kIj = false;

    public static void j(Application application) {
        AppMethodBeat.i(44108);
        application.registerActivityLifecycleCallbacks(new a() {
            /* class com.tencent.mm.plugin.appbrand.app.e.AnonymousClass1 */
            private final SparseIntArray kIk = new SparseIntArray();

            {
                AppMethodBeat.i(44099);
                AppMethodBeat.o(44099);
            }

            private void buo() {
                AppMethodBeat.i(226294);
                Log.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", "alive activity count %d", Integer.valueOf(this.kIk.size()));
                AppMethodBeat.o(226294);
            }

            private void A(Activity activity) {
                AppMethodBeat.i(44100);
                if (activity == null) {
                    AppMethodBeat.o(44100);
                    return;
                }
                this.kIk.put(activity.hashCode(), 1);
                e.gD(true);
                buo();
                AppMethodBeat.o(44100);
            }

            private void B(Activity activity) {
                AppMethodBeat.i(44101);
                if (activity == null) {
                    AppMethodBeat.o(44101);
                    return;
                }
                this.kIk.delete(activity.hashCode());
                if (this.kIk.size() <= 0) {
                    e.gD(false);
                }
                buo();
                AppMethodBeat.o(44101);
            }

            @Override // com.tencent.mm.plugin.appbrand.ac.a
            public final void onActivityCreated(Activity activity, Bundle bundle) {
                AppMethodBeat.i(44102);
                A(activity);
                AppMethodBeat.o(44102);
            }

            @Override // com.tencent.mm.plugin.appbrand.ac.a
            public final void onActivityStarted(Activity activity) {
                AppMethodBeat.i(44103);
                A(activity);
                AppMethodBeat.o(44103);
            }

            @Override // com.tencent.mm.plugin.appbrand.ac.a
            public final void onActivityStopped(Activity activity) {
                AppMethodBeat.i(44104);
                B(activity);
                AppMethodBeat.o(44104);
            }

            @Override // com.tencent.mm.plugin.appbrand.ac.a
            public final void onActivityDestroyed(Activity activity) {
                AppMethodBeat.i(44105);
                B(activity);
                AppMethodBeat.o(44105);
            }
        });
        AppMethodBeat.o(44108);
    }

    public static void a(final g gVar, final AppBrandPreloadProfiler appBrandPreloadProfiler, final boolean z, final int i2) {
        AppMethodBeat.i(226298);
        kIj = true;
        if (gVar == null || gVar == g.NIL) {
            Log.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", "dl: AppBrandProcessPreloader said I can not preload [nil] type.");
            AppMethodBeat.o(226298);
            return;
        }
        if (appBrandPreloadProfiler == null) {
            appBrandPreloadProfiler = new AppBrandPreloadProfiler();
        }
        appBrandPreloadProfiler.nOE = SystemClock.elapsedRealtime();
        final AnonymousClass2 r0 = new b<String, Integer>() {
            /* class com.tencent.mm.plugin.appbrand.app.e.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Integer invoke(String str) {
                AppMethodBeat.i(226296);
                Integer UH = UH(str);
                AppMethodBeat.o(226296);
                return UH;
            }

            private Integer UH(String str) {
                AppMethodBeat.i(226295);
                boolean unused = e.kIj = true;
                boolean z = e.kIi;
                Log.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", "start misc preload type[%s], aggressive[%b], reason[%s], skip[%b], level[%d]", gVar, Boolean.valueOf(z), str, Boolean.valueOf(z), Integer.valueOf(i2));
                if (!z) {
                    try {
                        AppBrandMainProcessService.bDD();
                        if (z) {
                            if (com.tencent.mm.plugin.appbrand.task.e.l(gVar)) {
                                com.tencent.mm.plugin.appbrand.task.e.a(gVar, null, true, appBrandPreloadProfiler, i2);
                            }
                            e.UG("preload aggressive before keepalive");
                            if (com.tencent.mm.kernel.g.aAe().azG().mProcessName.endsWith(":appbrand0")) {
                                com.tencent.mm.plugin.appbrand.keepalive.b.c(AppBrandPluginUI.class.getName(), new Runnable() {
                                    /* class com.tencent.mm.plugin.appbrand.app.e.AnonymousClass2.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(44106);
                                        e.UG("preload aggressive after keepalive");
                                        AppMethodBeat.o(44106);
                                    }
                                });
                            }
                        } else {
                            com.tencent.mm.plugin.appbrand.task.e.a(gVar, null, false, appBrandPreloadProfiler, i2);
                        }
                    } catch (Exception e2) {
                        if (q.kDg) {
                            AppMethodBeat.o(226295);
                            throw e2;
                        }
                        Log.printErrStackTrace("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", e2, "Preload [%s] in IdleHandler encountered Exception", gVar.name());
                    }
                }
                AppMethodBeat.o(226295);
                return 0;
            }
        };
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.app.e.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(226297);
                r0.invoke("MMHandlerThread.postToMainThread");
                AppMethodBeat.o(226297);
            }
        });
        AppMethodBeat.o(226298);
    }

    public static boolean bun() {
        return kIj;
    }

    public static void gD(boolean z) {
        AppMethodBeat.i(44110);
        Log.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", "setSkipMiscPreload %b", Boolean.valueOf(z));
        kIi = z;
        AppMethodBeat.o(44110);
    }

    static /* synthetic */ void UG(String str) {
        AppMethodBeat.i(44111);
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        Log.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", "current ProcessImportance [%d][%d][%s], %s", Integer.valueOf(runningAppProcessInfo.importance), Integer.valueOf(runningAppProcessInfo.importanceReasonCode), runningAppProcessInfo.importanceReasonComponent, str);
        AppMethodBeat.o(44111);
    }
}
