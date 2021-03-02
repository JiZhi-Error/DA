package com.tencent.mm.app;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.facebook.internal.NativeProtocol;
import com.huawei.easygo.sdk.EasyGo;
import com.tencent.f.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.blink.a;
import com.tencent.mm.boot.a;
import com.tencent.mm.booter.aa;
import com.tencent.mm.booter.d;
import com.tencent.mm.cc.a;
import com.tencent.mm.cc.b;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.report.business.DataPackageFrequencyDetect;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.AndroidOSafety;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.splash.m;
import com.tencent.mm.ui.NoRomSpaceDexUI;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.y;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;
import org.xwalk.core.XWalkEnvironment;

public class MMApplicationWrapper implements ApplicationLifeCycle {
    private static final String TAG = "MicroMsg.MMApplicationWrapper";
    public Application app;
    private EasyGo easyGoManager = null;
    private final ApplicationLike lifeCycle;
    private final long processInitTimestamp = System.currentTimeMillis();
    private h profile = null;
    private String thisProcess;

    public MMApplicationWrapper(ApplicationLike applicationLike, String str) {
        AppMethodBeat.i(160077);
        a.r(applicationLike.getApplicationStartMillisTime(), applicationLike.getApplicationStartElapsedTime());
        this.app = applicationLike.getApplication();
        this.lifeCycle = applicationLike;
        this.thisProcess = str;
        AppMethodBeat.o(160077);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onBaseContextAttached(final Context context) {
        AppMethodBeat.i(160078);
        com.tencent.mm.kernel.a.a.hrO = SystemClock.elapsedRealtime();
        com.tencent.mm.kernel.a.a.hrN = System.currentTimeMillis();
        AndroidOSafety.replaceTargetVersion(context.getApplicationInfo());
        this.profile = new h(this.thisProcess, this.app, this.lifeCycle);
        this.profile.htp.htq = this.processInitTimestamp;
        ai.init(context);
        j.a(new j.b() {
            /* class com.tencent.mm.app.MMApplicationWrapper.AnonymousClass1 */

            @Override // com.tencent.mm.compatible.util.j.b
            public final boolean Wt() {
                AppMethodBeat.i(257897);
                if (!BuildInfo.IS_ARM64 || Build.CPU_ABI.equals(XWalkEnvironment.RUNTIME_ABI_ARM64_STR)) {
                    AppMethodBeat.o(257897);
                    return false;
                }
                Context context = context;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(context, NoRomSpaceDexUI.class).addFlags(268435456).putExtra("titleRes", R.string.a4i).putExtra("messageRes", R.string.a4h).putExtra("buttonRes", R.string.a4g).putExtra(NativeProtocol.WEB_DIALOG_ACTION, PendingIntent.getActivity(context, 0, new Intent("android.intent.action.VIEW", Uri.parse(HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2m) + FilePathGenerator.ANDROID_DIR_SEP)).addFlags(268435456), 0)));
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/MMApplicationWrapper$1", "onFailure", "(Ljava/lang/String;Ljava/lang/UnsatisfiedLinkError;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/MMApplicationWrapper$1", "onFailure", "(Ljava/lang/String;Ljava/lang/UnsatisfiedLinkError;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.b.a a2 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/app/MMApplicationWrapper$1", "onFailure", "(Ljava/lang/String;Ljava/lang/UnsatisfiedLinkError;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
                Process.killProcess(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/app/MMApplicationWrapper$1", "onFailure", "(Ljava/lang/String;Ljava/lang/UnsatisfiedLinkError;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
                AppMethodBeat.o(257897);
                return true;
            }
        });
        y.f(this.profile);
        g.a(this.profile.ca, new aa());
        boolean gl = z.gl(this.thisProcess);
        boolean gk = z.gk(this.thisProcess);
        if (!gl) {
            context.getClassLoader();
            j.Ed("stlport_shared");
            context.getClassLoader();
            j.Ed("c++_shared");
            String str = com.tencent.mm.xlog.app.a.Rza;
            context.getClassLoader();
            j.Ed(str);
            this.profile.gmN = d.cg(this.profile.ca);
            setupXLogDebugger(this.profile);
        }
        com.tencent.mm.splash.a.n(this.app);
        AppForegroundDelegate.INSTANCE.d(this.app);
        DataPackageFrequencyDetect.CxA.d(this.app);
        com.tencent.mm.bu.a.a.gtp();
        if (!gk) {
            aj.a(this.profile, "com.tencent.mm.app.WeChatSplashStartup");
        } else {
            Log.i(TAG, "is plain process. load nothing");
            aj.a(this.profile, null);
        }
        Application application = this.app;
        MMApplicationContext.setResources(b.a(application.getResources(), application, gk));
        com.tencent.mm.cc.a.a(new a.AbstractC0287a() {
            /* class com.tencent.mm.app.MMApplicationWrapper.AnonymousClass2 */

            @Override // com.tencent.mm.cc.a.AbstractC0287a
            public final void Wu() {
                AppMethodBeat.i(257896);
                com.tencent.mm.bv.a.iH(MMApplicationContext.getContext());
                com.tencent.mm.hellhoundlib.b.a a2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/app/MMApplicationWrapper$2", "onDensityChange", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
                System.exit(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/app/MMApplicationWrapper$2", "onDensityChange", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
                AppMethodBeat.o(257896);
            }
        });
        if (com.tencent.mm.cc.c.gvD()) {
            if (!MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("special_dark_mode_set_follow_system", false)) {
                MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system", true);
                ao.gJU();
                MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("special_dark_mode_set_follow_system", true);
            }
        } else if (!MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("dark_mode_set_follow_system", false)) {
            MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system", true);
            ao.gJU();
            MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_set_follow_system", true);
        }
        ab.ab(a.C0281a.class);
        ab.gm("com.tencent.mm.boot");
        AppMethodBeat.o(160078);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onCreate() {
        AppMethodBeat.i(160080);
        com.tencent.mm.ad.c.g(this.app);
        m.gyz();
        AppMethodBeat.o(160080);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onTerminate() {
        AppMethodBeat.i(160081);
        if (this.profile != null) {
            this.profile.onTerminate();
        }
        AppMethodBeat.o(160081);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(160082);
        if (this.profile != null) {
            this.profile.onConfigurationChanged(configuration);
        }
        AppMethodBeat.o(160082);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onLowMemory() {
        AppMethodBeat.i(160083);
        if (this.profile != null) {
            this.profile.onLowMemory();
        }
        AppMethodBeat.o(160083);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onTrimMemory(int i2) {
        AppMethodBeat.i(160084);
        if (this.profile != null) {
            this.profile.onTrimMemory(i2);
        }
        AppMethodBeat.o(160084);
    }

    private void setupXLogDebugger(h hVar) {
        AppMethodBeat.i(160079);
        d dVar = hVar.gmN;
        if (hVar.aBb()) {
            dVar.CN("MM");
            AppMethodBeat.o(160079);
        } else if (hVar.FY(":push")) {
            dVar.CN("PUSH");
            AppMethodBeat.o(160079);
        } else if (hVar.FY(":tools")) {
            dVar.CN("TOOL");
            AppMethodBeat.o(160079);
        } else if (hVar.FY(":toolsmp")) {
            dVar.CN("TOOLSMP");
            AppMethodBeat.o(160079);
        } else if (hVar.FY(":sandbox")) {
            dVar.CN("SANDBOX");
            AppMethodBeat.o(160079);
        } else if (hVar.FY(":exdevice")) {
            dVar.CN("EXDEVICE");
            AppMethodBeat.o(160079);
        } else if (hVar.FY(":patch")) {
            dVar.CN("PATCH");
            AppMethodBeat.o(160079);
        } else if (hVar.FY(":appbrand0")) {
            dVar.CN("APPBRAND0");
            AppMethodBeat.o(160079);
        } else if (hVar.FY(":appbrand1")) {
            dVar.CN("APPBRAND1");
            AppMethodBeat.o(160079);
        } else if (hVar.FY(":appbrand2")) {
            dVar.CN("APPBRAND2");
            AppMethodBeat.o(160079);
        } else if (hVar.FY(":appbrand3")) {
            dVar.CN("APPBRAND3");
            AppMethodBeat.o(160079);
        } else if (hVar.FY(":appbrand4")) {
            dVar.CN("APPBRAND4");
            AppMethodBeat.o(160079);
        } else if (hVar.FY(":TMAssistantDownloadSDKService")) {
            dVar.CN("TMSDK");
            AppMethodBeat.o(160079);
        } else if (hVar.FY(":dexopt")) {
            dVar.CN("DEXOPT");
            AppMethodBeat.o(160079);
        } else {
            if (hVar.FY(":extmig")) {
                dVar.CN("EXTMIG");
            }
            AppMethodBeat.o(160079);
        }
    }
}
