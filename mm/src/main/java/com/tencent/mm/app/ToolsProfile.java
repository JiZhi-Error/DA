package com.tencent.mm.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.util.ArrayMap;
import com.tencent.mars.Mars;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.plugin.e;
import com.tencent.mm.booter.w;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.cr.b;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.pluginsdk.ui.span.d;
import com.tencent.mm.sdk.CommLibFileName;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.xweb.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;

public final class ToolsProfile extends d {
    private static final String TAG = ("MicroMsg." + b.getModuleName() + "Profile");
    public static final String dkO = MMApplicationContext.getProcessName();
    private static Locale locale;
    private int dmD = 0;

    public ToolsProfile() {
        AppMethodBeat.i(19498);
        AppMethodBeat.o(19498);
    }

    static /* synthetic */ int a(ToolsProfile toolsProfile) {
        int i2 = toolsProfile.dmD;
        toolsProfile.dmD = i2 + 1;
        return i2;
    }

    static /* synthetic */ int b(ToolsProfile toolsProfile) {
        int i2 = toolsProfile.dmD;
        toolsProfile.dmD = i2 - 1;
        return i2;
    }

    static {
        AppMethodBeat.i(19501);
        AppMethodBeat.o(19501);
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onCreate() {
        AppMethodBeat.i(19499);
        long currentTimeMillis = System.currentTimeMillis();
        ToolsProfile.class.getClassLoader();
        com.tencent.mm.f.a.cc(MMApplicationContext.getContext());
        t.addOnUncaughtExceptionListener(new MMUncaughtExceptionHandler.IOnUncaughtExceptionListener() {
            /* class com.tencent.mm.app.ToolsProfile.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener
            public final void uncaughtException(MMUncaughtExceptionHandler mMUncaughtExceptionHandler, String str, Throwable th) {
                AppMethodBeat.i(231393);
                KVCommCrossProcessReceiver.eOD();
                AppMethodBeat.o(231393);
            }
        });
        Log.i("MicroMsg.ToolsProfileTest", dkO);
        t.d(false, dkO);
        AppLogic.setCallBack(new AppCallBack(MMApplicationContext.getContext()));
        w wVar = new w(com.tencent.mm.booter.d.cg(this.app.getBaseContext()));
        wVar.CN("TOOL");
        ac.jNP = Util.nullAs(wVar.CO(".com.tencent.mm.debug.test.display_errcode"), false);
        ac.jNQ = Util.nullAs(wVar.CO(".com.tencent.mm.debug.test.display_msgstate"), false);
        ac.jNR = Util.nullAs(wVar.CO(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        ac.jNS = Util.nullAs(wVar.CO(".com.tencent.mm.debug.test.network.force_touch"), false);
        ac.jNT = Util.nullAs(wVar.CO(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        ac.jNU = Util.nullAs(wVar.CO(".com.tencent.mm.debug.test.crashIsExit"), false);
        ac.jNY = Util.nullAs(wVar.CO(".com.tencent.mm.debug.test.album_show_info"), false);
        ac.jNZ = Util.nullAs(wVar.CO(".com.tencent.mm.debug.test.location_help"), false);
        ac.jOc = Util.nullAs(wVar.CO(".com.tencent.mm.debug.test.force_soso"), false);
        ac.jOd = Util.nullAs(wVar.CO(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        ac.jOe = Util.nullAs(wVar.CO(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        ac.jOf = Util.nullAs(wVar.CO(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        ac.jOi = Util.nullAs(wVar.CO(".com.tencent.mm.debug.test.filterfpnp"), false);
        ac.jOj = Util.nullAs(wVar.CO(".com.tencent.mm.debug.test.testForPull"), false);
        int nullAs = Util.nullAs(wVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        ac.jOg = nullAs;
        if (nullAs != 4 && ac.jOg > 0) {
            aq.NSc = ac.jOg;
            Log.e("MicroMsg.ToolDebugger", "cdn thread num " + ac.jOg);
        }
        ac.jOh = Util.nullAs(wVar.CO(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        try {
            int intValue = Integer.decode(wVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            com.tencent.mm.protocal.d.aiV(intValue);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(intValue));
        } catch (Exception e2) {
            Log.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            String string = wVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!Util.isNullOrNil(string)) {
                com.tencent.mm.protocal.d.ics = "android-".concat(String.valueOf(string));
                com.tencent.mm.protocal.d.KyK = "android-".concat(String.valueOf(string));
                com.tencent.mm.protocal.d.KyM = String.valueOf(string);
                CrashReportFactory.setDebugerApiLevel(string);
                new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.ics).append(" ").append(CrashReportFactory.getDebugerApiLevel());
            }
        } catch (Exception e3) {
            Log.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            int intValue2 = Integer.decode(wVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.KyN).append(" new: ").append(intValue2);
            com.tencent.mm.protocal.d.KyN = (long) intValue2;
        } catch (Exception e4) {
            Log.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            wVar.gmN.glq = Integer.decode(wVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e5) {
            Log.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            boolean nullAs2 = Util.nullAs(wVar.CO(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean nullAs3 = Util.nullAs(wVar.CO(".com.tencent.mm.debug.report.kvstat"), false);
            boolean nullAs4 = Util.nullAs(wVar.CO(".com.tencent.mm.debug.report.clientpref"), false);
            boolean nullAs5 = Util.nullAs(wVar.CO(".com.tencent.mm.debug.report.useraction"), false);
            c.d(nullAs2, nullAs3, nullAs4, nullAs5);
            new StringBuilder("try control report : debugModel[").append(nullAs2).append("],kv[").append(nullAs3).append("], clientPref[").append(nullAs4).append("], useraction[").append(nullAs5).append("]");
        } catch (Exception e6) {
            Log.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        ac.jOx = Util.nullAs(wVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        Log.d("MicroMsg.ToolDebugger", "Test.jsapiPermission = " + ac.jOx);
        ac.jOy = Util.nullAs(wVar.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
        Log.d("MicroMsg.ToolDebugger", "Test.generalCtrl = " + ac.jOy);
        ac.jOz = Util.nullAs(wVar.CO(".com.tencent.mm.debug.skiploadurlcheck"), false);
        Log.d("MicroMsg.ToolDebugger", "Test.skipLoadUrlCheck = " + ac.jOz);
        ac.jOA = Util.nullAs(wVar.CO(".com.tencent.mm.debug.forcex5webview"), false);
        Log.d("MicroMsg.ToolDebugger", "Test.forceX5WebView = " + ac.jOA);
        f.bF(g.aAe().azG().ca);
        a.VP();
        j.Ed("wcdb");
        j.Ed("commonimgdec");
        j.Ed("wechatcommon");
        j.Ed(Mars.libMarsBase);
        j.Ed(CommLibFileName.quic);
        j.Ed(Mars.libMarsMM);
        j.Ed("FFmpeg");
        j.Ed("wechatpack");
        int aon = m.aon();
        if ((aon & 1024) != 0) {
            Log.i(TAG, "load wechatsight_v7a, core number: %d ", Integer.valueOf(aon >> 12));
            j.Ed("wechatsight_v7a");
            if ((aon >> 12) >= 4) {
                com.tencent.mm.plugin.sight.base.c.Dma = 3;
                com.tencent.mm.plugin.sight.base.c.Dmc = 3;
                com.tencent.mm.plugin.sight.base.c.Dmd = 544000;
            } else {
                com.tencent.mm.plugin.sight.base.c.Dma = 1;
                com.tencent.mm.plugin.sight.base.c.Dmc = 1;
                com.tencent.mm.plugin.sight.base.c.Dmd = 640000;
            }
        } else {
            Log.i(TAG, "load wechatsight");
            j.Ed("wechatsight");
            Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
            com.tencent.mm.plugin.sight.base.c.Dma = 1;
            com.tencent.mm.plugin.sight.base.c.Dmc = 1;
            com.tencent.mm.plugin.sight.base.c.Dmd = 640000;
        }
        SightVideoJNI.registerALL();
        locale = MMActivity.initLanguage(this.app.getBaseContext());
        ab.WH();
        if (com.tencent.mm.compatible.util.d.oD(14) && d.dks != null) {
            d.dks.getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                /* class com.tencent.mm.app.ToolsProfile.AnonymousClass2 */
                private Set<Activity> dmF = new HashSet();

                {
                    AppMethodBeat.i(231394);
                    AppMethodBeat.o(231394);
                }

                public final void onActivityCreated(Activity activity, Bundle bundle) {
                    AppMethodBeat.i(231395);
                    ToolsProfile.a(ToolsProfile.this);
                    this.dmF.add(activity);
                    AppMethodBeat.o(231395);
                }

                public final void onActivityDestroyed(Activity activity) {
                    AppMethodBeat.i(231396);
                    ToolsProfile.b(ToolsProfile.this);
                    Log.d(ToolsProfile.TAG, "onActivityDestroyed, after destroy, activityInstanceNum = %d", Integer.valueOf(ToolsProfile.this.dmD));
                    if (ToolsProfile.this.dmD == 0) {
                        a.access$200();
                        boolean canReboot = WebView.getCanReboot();
                        Log.i(ToolsProfile.TAG, "onActivityDestroyed, xwebCanReboot = %b", Boolean.valueOf(canReboot));
                        if (canReboot && !a.isLocked()) {
                            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                            Object obj = new Object();
                            com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/app/ToolsProfile$2", "onActivityDestroyed", "(Landroid/app/Activity;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                            Process.killProcess(((Integer) a2.pG(0)).intValue());
                            com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/app/ToolsProfile$2", "onActivityDestroyed", "(Landroid/app/Activity;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                        }
                    }
                    this.dmF.remove(activity);
                    AppMethodBeat.o(231396);
                }

                public final void onActivityPaused(Activity activity) {
                    AppMethodBeat.i(231397);
                    this.dmF.remove(activity);
                    a.access$300();
                    AppMethodBeat.o(231397);
                }

                public final void onActivityResumed(Activity activity) {
                    AppMethodBeat.i(231398);
                    if (!this.dmF.contains(activity)) {
                        a.Wz();
                    }
                    AppMethodBeat.o(231398);
                }

                public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public final void onActivityStarted(Activity activity) {
                }

                public final void onActivityStopped(Activity activity) {
                }
            });
        }
        Log.i(TAG, "start time check toolsprofile use time = " + (System.currentTimeMillis() - currentTimeMillis));
        if (MMApplicationContext.isToolsProcess()) {
            x.E(TbsCoreSettings.TBS_SETTINGS_USE_SANDBOX, Boolean.TRUE);
            x.E(TbsCoreSettings.TBS_SANDBOX_CRASH_RECORD_FILE0, aa.z(new o(MMApplicationContext.getContext().getFilesDir(), "crash/java_" + MMApplicationContext.getPackageName() + ":isolated_process0").her()));
            x.E(TbsCoreSettings.TBS_SANDBOX_CRASH_RECORD_FILE1, aa.z(new o(MMApplicationContext.getContext().getFilesDir(), "crash/" + MMApplicationContext.getPackageName() + ":isolated_process0").her()));
        }
        x.a.iq(MMApplicationContext.getContext());
        d.a.KqD = e.Xo();
        EventCenter.instance.addListener(new v(22, 32));
        x.a.gmH();
        AppMethodBeat.o(19499);
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(19500);
        Locale initLanguage = MMActivity.initLanguage(this.app.getBaseContext());
        Log.d(TAG, "onConfigurationChanged, locale = " + locale.toString() + ", n = " + initLanguage.toString());
        if (!initLanguage.equals(locale)) {
            Log.w(TAG, "language changed, restart process");
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(-1, new com.tencent.mm.hellhoundlib.b.a());
            Object obj = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/app/ToolsProfile", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
            System.exit(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/app/ToolsProfile", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
        }
        AppMethodBeat.o(19500);
    }

    public final String toString() {
        return dkO;
    }

    public static final class a {
        private static final AtomicInteger dmG = new AtomicInteger(0);
        private static Object dmH;

        static {
            AppMethodBeat.i(19497);
            AppMethodBeat.o(19497);
        }

        private static boolean WS() {
            AppMethodBeat.i(19493);
            try {
                if (dmH == null) {
                    Context context = MMApplicationContext.getContext();
                    Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                    method.setAccessible(true);
                    Object invoke = method.invoke(null, new Object[0]);
                    if (invoke == null) {
                        Field field = context.getClass().getField("mLoadedApk");
                        field.setAccessible(true);
                        Object obj = field.get(context);
                        Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
                        declaredField.setAccessible(true);
                        invoke = declaredField.get(obj);
                    }
                    dmH = invoke;
                    ArrayMap arrayMap = (ArrayMap) org.a.a.gG(invoke).bvr("mServices").object;
                    if (arrayMap.size() <= 0) {
                        AppMethodBeat.o(19493);
                        return true;
                    } else if (arrayMap.size() != 1 || !(arrayMap.values().toArray()[0] instanceof BaseIPCService)) {
                        AppMethodBeat.o(19493);
                        return false;
                    } else {
                        AppMethodBeat.o(19493);
                        return true;
                    }
                }
            } catch (Throwable th) {
                Log.e("MicroMsg.ToolsProcessLocker", "skipServiceConditionIfOnlyIPCServiceAlive, hack ActivityThread_mServices e=%s", th);
            }
            AppMethodBeat.o(19493);
            return false;
        }

        public static boolean isLocked() {
            boolean z;
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
            AppMethodBeat.i(19492);
            if (dmG.get() <= 0) {
                ActivityManager activityManager = (ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
                if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                    int[] iArr = {100};
                    int[] iArr2 = {300, 125};
                    int[] iArr3 = {1, 2};
                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (g.aAe().azG().mProcessName.equals(next.processName)) {
                            boolean z2 = com.tencent.mm.compatible.loader.a.contains(iArr, next.importance) || (com.tencent.mm.compatible.loader.a.contains(iArr2, next.importance) && !WS()) || com.tencent.mm.compatible.loader.a.contains(iArr3, next.importanceReasonCode);
                            Log.i("MicroMsg.ToolsProcessLocker", "hasRunningServicesOrProviders:%b %d %d", Boolean.valueOf(z2), Integer.valueOf(next.importance), Integer.valueOf(next.importanceReasonCode));
                            if (z2) {
                                z = true;
                            }
                        }
                    }
                }
                z = false;
                if (!z) {
                    AppMethodBeat.o(19492);
                    return false;
                }
            }
            AppMethodBeat.o(19492);
            return true;
        }

        static /* synthetic */ void access$200() {
            AppMethodBeat.i(19494);
            Log.i("MicroMsg.ToolsProcessLocker", "clearLock, beforeReset %d", Integer.valueOf(dmG.getAndSet(0)));
            AppMethodBeat.o(19494);
        }

        static /* synthetic */ void access$300() {
            AppMethodBeat.i(19495);
            Log.i("MicroMsg.ToolsProcessLocker", "doLocalLock, counter %d", Integer.valueOf(dmG.incrementAndGet()));
            AppMethodBeat.o(19495);
        }

        static /* synthetic */ void Wz() {
            AppMethodBeat.i(19496);
            Log.i("MicroMsg.ToolsProcessLocker", "doLocalUnlock, counter %d", Integer.valueOf(dmG.decrementAndGet()));
            AppMethodBeat.o(19496);
        }
    }
}
