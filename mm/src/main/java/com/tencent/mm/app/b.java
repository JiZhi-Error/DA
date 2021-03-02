package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b {
    private static final Application.ActivityLifecycleCallbacks ACTIVITY_LIFECYCLE_CALLBACKS = new Application.ActivityLifecycleCallbacks() {
        /* class com.tencent.mm.app.b.AnonymousClass5 */

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
            AppMethodBeat.i(160062);
            String unused = b.djN = b.o(activity);
            b.access$200();
            b.fV(b.o(activity));
            AppMethodBeat.o(160062);
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
            AppMethodBeat.i(160063);
            if (TextUtils.equals(b.djN, b.o(activity))) {
                b.fW(b.o(activity));
            }
            AppMethodBeat.o(160063);
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }
    };
    private static String djJ = null;
    private static MultiProcessMMKV djK = null;
    private static boolean djL = false;
    private static boolean djM = false;
    private static String djN = null;
    private static final List<a> djO = new ArrayList(8);

    /* access modifiers changed from: package-private */
    public interface a {
        boolean VX();

        void VY();
    }

    static /* synthetic */ void VV() {
        AppMethodBeat.i(160045);
        VU();
        AppMethodBeat.o(160045);
    }

    static /* synthetic */ void access$200() {
        AppMethodBeat.i(160042);
        VT();
        AppMethodBeat.o(160042);
    }

    static /* synthetic */ void fV(String str) {
        AppMethodBeat.i(160043);
        fS(str);
        AppMethodBeat.o(160043);
    }

    static /* synthetic */ void fW(String str) {
        AppMethodBeat.i(160044);
        fT(str);
        AppMethodBeat.o(160044);
    }

    static {
        AppMethodBeat.i(160046);
        a(new a() {
            /* class com.tencent.mm.app.b.AnonymousClass1 */

            @Override // com.tencent.mm.app.b.a
            public final boolean VX() {
                AppMethodBeat.i(160099);
                boolean isMainProcess = MMApplicationContext.isMainProcess();
                AppMethodBeat.o(160099);
                return isMainProcess;
            }

            @Override // com.tencent.mm.app.b.a
            public final void VY() {
                AppMethodBeat.i(160100);
                Log.i("MicroMsg.AccidentallyQuitMonitor", "[+] Report [%s] process accidentally quit.", MMApplicationContext.getProcessName());
                h.INSTANCE.idkeyStat(1182, 0, 1, true);
                AppMethodBeat.o(160100);
            }
        });
        a(new a() {
            /* class com.tencent.mm.app.b.AnonymousClass2 */

            @Override // com.tencent.mm.app.b.a
            public final boolean VX() {
                AppMethodBeat.i(160057);
                boolean isToolsProcess = MMApplicationContext.isToolsProcess();
                AppMethodBeat.o(160057);
                return isToolsProcess;
            }

            @Override // com.tencent.mm.app.b.a
            public final void VY() {
                AppMethodBeat.i(160058);
                Log.i("MicroMsg.AccidentallyQuitMonitor", "[+] Report [%s] process accidentally quit.", MMApplicationContext.getProcessName());
                h.INSTANCE.idkeyStat(1182, 1, 1, true);
                AppMethodBeat.o(160058);
            }
        });
        a(new a() {
            /* class com.tencent.mm.app.b.AnonymousClass3 */

            @Override // com.tencent.mm.app.b.a
            public final boolean VX() {
                AppMethodBeat.i(160128);
                boolean isToolsMpProcess = MMApplicationContext.isToolsMpProcess();
                AppMethodBeat.o(160128);
                return isToolsMpProcess;
            }

            @Override // com.tencent.mm.app.b.a
            public final void VY() {
                AppMethodBeat.i(160129);
                Log.i("MicroMsg.AccidentallyQuitMonitor", "[+] Report [%s] process accidentally quit.", MMApplicationContext.getProcessName());
                h.INSTANCE.idkeyStat(1182, 2, 1, true);
                AppMethodBeat.o(160129);
            }
        });
        a(new a() {
            /* class com.tencent.mm.app.b.AnonymousClass4 */

            @Override // com.tencent.mm.app.b.a
            public final boolean VX() {
                AppMethodBeat.i(160113);
                boolean isAppBrandProcess = MMApplicationContext.isAppBrandProcess();
                AppMethodBeat.o(160113);
                return isAppBrandProcess;
            }

            @Override // com.tencent.mm.app.b.a
            public final void VY() {
                AppMethodBeat.i(160114);
                Log.i("MicroMsg.AccidentallyQuitMonitor", "[+] Report [%s] process accidentally quit.", MMApplicationContext.getProcessName());
                h.INSTANCE.idkeyStat(1182, 3, 1, true);
                AppMethodBeat.o(160114);
            }
        });
        AppMethodBeat.o(160046);
    }

    private static void a(a aVar) {
        AppMethodBeat.i(160032);
        djO.add(aVar);
        AppMethodBeat.o(160032);
    }

    private static MultiProcessMMKV VQ() {
        AppMethodBeat.i(160033);
        if (djK == null) {
            djK = MultiProcessMMKV.getSingleMMKV(djJ);
        }
        MultiProcessMMKV multiProcessMMKV = djK;
        AppMethodBeat.o(160033);
        return multiProcessMMKV;
    }

    private static synchronized void fS(String str) {
        synchronized (b.class) {
            AppMethodBeat.i(160034);
            Log.i("MicroMsg.AccidentallyQuitMonitor", "[+] Calling markOnStartCalled, activity: %s, skip_rest: %s", str, Boolean.valueOf(djL));
            if (djL) {
                AppMethodBeat.o(160034);
            } else {
                if (VQ().getInt("kLastCallOnStartClientVersion", 0) != BuildInfo.CLIENT_VERSION_INT) {
                    VQ().putInt("kLastCallOnStartClientVersion", BuildInfo.CLIENT_VERSION_INT).commit();
                }
                djL = true;
                AppMethodBeat.o(160034);
            }
        }
    }

    private static synchronized void fT(String str) {
        synchronized (b.class) {
            AppMethodBeat.i(160035);
            Log.i("MicroMsg.AccidentallyQuitMonitor", "[+] Calling markOnStopCalled, activity: %s, skip_rest: %s", str, Boolean.valueOf(djM));
            if (djM) {
                AppMethodBeat.o(160035);
            } else {
                if (VQ().getInt("kLastCallOnStopClientVersion", 0) != BuildInfo.CLIENT_VERSION_INT) {
                    VQ().putInt("kLastCallOnStopClientVersion", BuildInfo.CLIENT_VERSION_INT).commit();
                }
                djM = true;
                AppMethodBeat.o(160035);
            }
        }
    }

    private static synchronized boolean VR() {
        boolean z = true;
        synchronized (b.class) {
            AppMethodBeat.i(160036);
            if (VQ().getInt("kLastCallOnStartClientVersion", 0) != BuildInfo.CLIENT_VERSION_INT) {
                AppMethodBeat.o(160036);
            } else if (VQ().getInt("kLastCallOnStopClientVersion", 0) == BuildInfo.CLIENT_VERSION_INT) {
                AppMethodBeat.o(160036);
            } else {
                AppMethodBeat.o(160036);
                z = false;
            }
        }
        return z;
    }

    private static synchronized void VS() {
        synchronized (b.class) {
            AppMethodBeat.i(160037);
            djL = false;
            VQ().remove("kLastCallOnStartClientVersion").commit();
            AppMethodBeat.o(160037);
        }
    }

    private static synchronized void VT() {
        synchronized (b.class) {
            AppMethodBeat.i(160038);
            djM = false;
            VQ().remove("kLastCallOnStopClientVersion").commit();
            AppMethodBeat.o(160038);
        }
    }

    private static synchronized void VU() {
        synchronized (b.class) {
            AppMethodBeat.i(160039);
            if (!VR()) {
                VS();
                Log.w("MicroMsg.AccidentallyQuitMonitor", "[!] Process [%s] was quit accidentally last time, try to report it.", MMApplicationContext.getProcessName());
                Iterator<a> it = djO.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        Log.w("MicroMsg.AccidentallyQuitMonitor", "[!] Process [%s] was quit accidentally last time and not handled by any handlers ！！", MMApplicationContext.getProcessName());
                        AppMethodBeat.o(160039);
                        break;
                    }
                    a next = it.next();
                    if (next.VX()) {
                        next.VY();
                        AppMethodBeat.o(160039);
                        break;
                    }
                }
            } else {
                Log.i("MicroMsg.AccidentallyQuitMonitor", "[+] Process [%s] was quit normally last time, skip report.", MMApplicationContext.getProcessName());
                VS();
                VT();
                AppMethodBeat.o(160039);
            }
        }
    }

    public static void c(final Application application) {
        boolean z;
        AppMethodBeat.i(160040);
        String processName = MMApplicationContext.getProcessName();
        Iterator<a> it = djO.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().VX()) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            Log.w("MicroMsg.AccidentallyQuitMonitor", "[!] Process [%s] is not targeted, skip rest logic.", processName);
            AppMethodBeat.o(160040);
            return;
        }
        djJ = "MMKV_AccidentiallyQuitMarks_" + z.gj(processName);
        com.tencent.f.h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.app.b.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(160076);
                b.VV();
                application.registerActivityLifecycleCallbacks(b.ACTIVITY_LIFECYCLE_CALLBACKS);
                AppMethodBeat.o(160076);
            }
        });
        AppMethodBeat.o(160040);
    }

    static /* synthetic */ String o(Activity activity) {
        AppMethodBeat.i(160041);
        if (activity == null) {
            AppMethodBeat.o(160041);
            return "<null>";
        }
        String str = activity.getClass().getName().substring(MMApplicationContext.getPackageName().length()) + "@" + activity.hashCode();
        AppMethodBeat.o(160041);
        return str;
    }
}
