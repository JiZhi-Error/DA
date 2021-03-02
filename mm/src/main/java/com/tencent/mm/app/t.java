package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Environment;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.storage.StorageManager;
import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.f.h;
import com.tencent.mm.b.p;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.crash.CrashUploaderService;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.cp;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.plugin.performance.watchdogs.ThreadWatchDog;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.rabbiteye.a;
import com.tencent.mm.sandbox.monitor.CrashUploadAlarmReceiver;
import com.tencent.mm.sdk.crash.CallbackForReset;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.crash.ICrashReporter;
import com.tencent.mm.sdk.crash.ISubReporter;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.o;
import com.tencent.nativecrash.NativeCrash;
import com.tencent.recovery.Recovery;
import com.tencent.recovery.wx.util.WXUtil;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.xweb.WebView;
import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.xwalk.core.XWalkEnvironment;

public final class t implements CoreService.b, ICrashReporter, MMUncaughtExceptionHandler.IReporter {
    private static String dlA = "";
    private static Message dlB = null;
    private static long dlC = 0;
    private static boolean dlD = false;
    private static boolean dlE = false;
    private static long[] dlF = {0, 0, 0};
    public static final long dlq = Util.nowMilliSecond();
    private static final Set<ICrashReporter.ICrashReportExtraMessageGetter> dlu = new HashSet();
    private static final Set<ICrashReporter.ICrashReportListener> dlv = new HashSet();
    private static CrashMonitorForJni.CrashExtraMessageGetter sCrashExtraMessageGetter = new CrashMonitorForJni.CrashExtraMessageGetter() {
        /* class com.tencent.mm.app.t.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.CrashMonitorForJni.CrashExtraMessageGetter
        public final String getExtraMessage() {
            StringBuilder sb = new StringBuilder();
            String processName = MMApplicationContext.getProcessName();
            if (processName != null && (processName.contains(":tools") || processName.contains(":appbrand"))) {
                sb.append("\n");
                String crashExtraMessage = WebView.getCrashExtraMessage(MMApplicationContext.getContext());
                if (crashExtraMessage != null && crashExtraMessage.length() > 0) {
                    String str = crashExtraMessage + String.format(Locale.US, "client_version:%s;", BuildInfo.CLIENT_VERSION);
                    if (str.length() > 8192) {
                        str = str.substring(str.length() - 8192);
                    }
                    sb.append("#qbrowser.crashmsg=" + Base64.encodeToString(str.getBytes(), 2));
                    Log.v("MicroMsg.MMCrashReporter", "header #qbrowser.crashmsg=%s", str);
                }
            }
            for (ICrashReporter.ICrashReportExtraMessageGetter iCrashReportExtraMessageGetter : t.Wy()) {
                sb.append('\n').append(iCrashReportExtraMessageGetter.getCrashReportExtraMessage());
            }
            return sb.toString();
        }
    };
    volatile b dlG;
    private MMUncaughtExceptionHandler dlr = null;
    private a dls;
    private volatile long dlt = 0;
    HashSet<String> dlw;
    String dlx;
    String dly;
    ConditionVariable dlz;

    /* access modifiers changed from: private */
    public static String Wv() {
        String aA = bf.iDu.aA(WXUtil.LAST_LOGIN_WEXIN_USERNAME, "");
        if (Util.isNullOrNil(aA)) {
            return bf.iDu.aA(WXUtil.LAST_LOGIN_USERNAME, "never_login_crash");
        }
        return aA;
    }

    public static boolean d(boolean z, String str) {
        boolean z2;
        a.C2040a aVar;
        Class<?> cls;
        Class<?> cls2 = null;
        dlA = str;
        if (d.elq() == null) {
            try {
                cls = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox");
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "setup sanbox Failed printing stack trace1.", new Object[0]);
                cls = null;
            }
            try {
                cls2 = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox", true, MMApplicationContext.getContext().getClassLoader());
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.MMCrashReporter", e3, "setup sanbox Failed printing stack trace2.", new Object[0]);
            }
            Log.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test1: " + cls + " thisProcName: " + dlA);
            Log.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test2: " + cls2 + " thisProcName: " + dlA);
            Class<?> mI = c.mI("sandbox", ".SubCoreSandBox");
            Log.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass clz: " + mI + " thisProcName: " + dlA);
            if (mI != null) {
                try {
                    com.tencent.mm.plugin.p.c cVar = (com.tencent.mm.plugin.p.c) mI.newInstance();
                    d.a(cVar);
                    Log.i("MicroMsg.MMCrashReporter", "setup sanbox mgr:" + cVar + " thisProcName: " + dlA);
                } catch (Exception e4) {
                    Log.printErrStackTrace("MicroMsg.MMCrashReporter", e4, "", new Object[0]);
                    Log.w("MicroMsg.MMCrashReporter", "setup sanbox e type:%s, e msg:%s", e4.getClass().getSimpleName(), e4.getMessage());
                }
            }
        }
        try {
            ICrashReporter iCrashReporter = (ICrashReporter) Class.forName("com.tencent.mm.crash.RDMCrashReporter").newInstance();
            iCrashReporter.init(MMApplicationContext.getContext(), z);
            iCrashReporter.setReportID(bf.iDu.aA(WXUtil.LAST_LOGIN_UIN, p.getString(q.aoG().hashCode())));
            CrashReportFactory.setupCrashReporter(iCrashReporter);
            iCrashReporter.setupSubReporter(new ISubReporter() {
                /* class com.tencent.mm.app.t.AnonymousClass4 */

                @Override // com.tencent.mm.sdk.crash.ISubReporter
                public final void report(String str) {
                    if (d.elq() != null) {
                        Intent intent = new Intent();
                        intent.setAction("uncatch_exception");
                        intent.putExtra("exceptionPid", Process.myPid());
                        intent.putExtra("userName", t.Wv());
                        intent.putExtra("tag", 0);
                        intent.putExtra("exceptionMsg", Base64.encodeToString((((Object) t.a("", true, BuildInfo.CLIENT_VERSION)) + str).getBytes(), 2));
                        d.elq().ak(MMApplicationContext.getContext(), intent);
                    }
                }
            });
            return true;
        } catch (Exception e5) {
            Log.w("MicroMsg.MMCrashReporter", "rdm crash reporter load failed");
            t tVar = new t();
            tVar.init(MMApplicationContext.getContext(), false);
            CrashReportFactory.setupCrashReporter(tVar);
            boolean z3 = str.contains(":tools") || str.contains(":appbrand") || str.contains(":support");
            NativeCrash.class.getClassLoader();
            j.Ed("wechatcrash");
            com.tencent.mm.crash.a arO = com.tencent.mm.crash.a.arO();
            if (z3) {
                String crashExtraMessage = WebView.getCrashExtraMessage(MMApplicationContext.getContext());
                com.tencent.mm.crash.a.EJ(crashExtraMessage);
                Log.i("MicroMsg.MMCrashReporter", "append crash extra message : %s", crashExtraMessage);
            }
            arO.gNl = sCrashExtraMessageGetter;
            cp.KL(com.tencent.mm.loader.j.b.aKB());
            EventCenter.instance.add(new IListener<fp>() {
                /* class com.tencent.mm.app.t.AnonymousClass3 */

                {
                    this.__eventId = fp.class.getName().hashCode();
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* synthetic */ boolean callback(fp fpVar) {
                    h.RTc.aY(new Runnable() {
                        /* class com.tencent.mm.app.t.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            try {
                                MultiProcessMMKV.getDefault().encode("clicfg_lag_report", ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_lag_report, false));
                                MultiProcessMMKV.getDefault().encode("clicfg_anr_trace", ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_anr_trace, false));
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "Cannot load A/B test", new Object[0]);
                            }
                        }
                    });
                    return true;
                }
            });
            z2 = MultiProcessMMKV.getDefault().getBoolean("clicfg_lag_report", false);
            boolean z4 = MultiProcessMMKV.getDefault().getBoolean("clicfg_anr_trace", false);
            aVar = new a.C2040a();
            aVar.f1529a = true;
            boolean z5 = Build.VERSION.SDK_INT >= 26 && (z4 || com.tencent.mm.protocal.d.KyR || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG);
            dlD = z5;
            if (z5) {
                Log.i("MicroMsg.MMCrashReporter", "printTrace2Xlog");
                aVar.f1530b = true;
                File file = new File(MMApplicationContext.getContext().getFilesDir(), "anr");
                if (!file.exists()) {
                    Log.i("MicroMsg.MMCrashReporter", "anrTraceDir not exists");
                    Log.i("MicroMsg.MMCrashReporter", "anrTraceDir mkdirs = %b", Boolean.valueOf(file.mkdirs()));
                } else {
                    Log.i("MicroMsg.MMCrashReporter", "anrTraceDir exists");
                }
                aVar.f1531c = new File(file, "currentAnr.trace").getAbsolutePath();
            }
        } catch (Throwable th) {
            Log.e("MicroMsg.MMCrashReporter", "print ANR trace failed, message : " + th.getMessage());
        }
        if (z2) {
            aVar.f1532d = true;
            aVar.f1535g = true;
            aVar.f1534f = true;
        }
        aVar.f1533e = false;
        com.tencent.mm.rabbiteye.a.a(new a.b() {
            /* class com.tencent.mm.app.t.AnonymousClass5 */

            @Override // com.tencent.mm.rabbiteye.a.b
            public final void a(String str, long j2, String str2, boolean z, String str3) {
                String processName = MMApplicationContext.getProcessName();
                Log.i("MicroMsg.MMCrashReporter", "[RabbitEye] Happens Lag stacktrace : %s, processName :%s , scene : %s, isForeground : %b, type : %s", str2, processName, str3, Boolean.valueOf(z), str);
                if (str.equals("Touch")) {
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                    Object[] objArr = new Object[6];
                    objArr[0] = str3;
                    objArr[1] = str2;
                    objArr[2] = Integer.valueOf(z ? 1 : 0);
                    objArr[3] = 1;
                    objArr[4] = Long.valueOf(j2);
                    objArr[5] = processName;
                    hVar.a(20841, objArr);
                } else if (str.equals("IdleHandler")) {
                    com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                    Object[] objArr2 = new Object[6];
                    objArr2[0] = str3;
                    objArr2[1] = str2;
                    objArr2[2] = Integer.valueOf(z ? 1 : 0);
                    objArr2[3] = 2;
                    objArr2[4] = Long.valueOf(j2);
                    objArr2[5] = processName;
                    hVar2.a(20841, objArr2);
                }
            }

            @Override // com.tencent.mm.rabbiteye.a.b
            public final void gf(String str) {
                try {
                    e.INSTANCE.idkeyStat(1356, 60, 1, true);
                    com.tencent.mm.plugin.fcm.a.asz(str);
                    t.fV(str);
                } catch (Throwable th) {
                    Log.e("MicroMsg.MMCrashReporter", "detectedAnr report failed, message = " + th.getMessage());
                }
            }
        });
        com.tencent.mm.rabbiteye.a.a(aVar);
        return false;
    }

    public static void addOnUncaughtExceptionListener(MMUncaughtExceptionHandler.IOnUncaughtExceptionListener iOnUncaughtExceptionListener) {
        MMUncaughtExceptionHandler.addOnUncaughtExceptionListener(iOnUncaughtExceptionListener);
    }

    private static void ge(String str) {
        while (str.length() > 896) {
            try {
                int lastIndexOf = str.substring(0, com.tencent.mm.plugin.appbrand.jsapi.aa.e.CTRL_INDEX).lastIndexOf("\n");
                if (-1 == lastIndexOf) {
                    Log.e("MicroMsg.MMCrashReporter", str.substring(0, com.tencent.mm.plugin.appbrand.jsapi.aa.e.CTRL_INDEX));
                    str = str.substring(com.tencent.mm.plugin.appbrand.jsapi.aa.d.CTRL_INDEX);
                } else {
                    Log.e("MicroMsg.MMCrashReporter", str.substring(0, lastIndexOf));
                    str = str.substring(lastIndexOf + 1);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "Failed printing stack trace.", new Object[0]);
                return;
            }
        }
        Log.e("MicroMsg.MMCrashReporter", str);
        Log.appenderFlush();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f0, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f1, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x019b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x019c, code lost:
        r1 = r0;
     */
    @Override // com.tencent.mm.booter.CoreService.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bL(android.content.Context r16) {
        /*
        // Method dump skipped, instructions count: 466
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.t.bL(android.content.Context):void");
    }

    private static void bM(Context context) {
        String string = context.getSharedPreferences(context.getPackageName() + "_preferences", 0).getString(WXUtil.LAST_LOGIN_USERNAME, "never_login_crash");
        SharedPreferences sharedPreferences = context.getSharedPreferences("system_config_prefs", 0);
        StringBuilder sb = new StringBuilder(HttpWrapperBase.PROTOCAL_HTTP);
        String str = com.tencent.mm.network.c.icB;
        String sb2 = sb.append(sharedPreferences.getString(str, str)).toString();
        o oVar = new o(context.getFilesDir().getParentFile().getAbsolutePath() + "/MicroMsg/crash/");
        if (oVar.exists() && oVar.isDirectory()) {
            o[] het = oVar.het();
            for (o oVar2 : het) {
                if (oVar2.isDirectory() && oVar2.getName().endsWith("_nf")) {
                    CrashUploaderService.a(oVar2, string, com.tencent.mm.loader.j.a.ics, sb2, "exception");
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter
    public final void init(Context context, boolean z) {
        String str;
        MMUncaughtExceptionHandler.setReporter(this);
        if (dlA.endsWith(":push")) {
            try {
                str = af.get("dalvik.vm.stack-trace-file");
                if (str == null || str.length() == 0) {
                    str = "/data/anr/traces.txt";
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "Failed finding out ANR trace file path, using default.", new Object[0]);
                str = "/data/anr/traces.txt";
            }
            File file = new File(str);
            this.dlx = file.getParent();
            if (this.dlx == null || this.dlx.length() == 0) {
                this.dlx = FilePathGenerator.ANDROID_DIR_SEP;
            }
            this.dly = file.getName();
            this.dlz = new ConditionVariable();
            Log.i("MicroMsg.MMCrashReporter", "Initialize ANR Observer, trace file: ".concat(String.valueOf(str)));
            this.dlw = new HashSet<>();
            this.dls = new a(this.dlx);
            this.dls.startWatching();
            CoreService.a(this);
        }
        if (MMApplicationContext.isMainProcess()) {
            context.sendBroadcast(new Intent(context, CrashUploadAlarmReceiver.class));
        }
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter
    public final void reportRawMessage(String str, String str2) {
        if (d.elq() != null) {
            Intent intent = new Intent();
            intent.setAction("custom_exception");
            intent.putExtra("userName", Wv());
            intent.putExtra("tag", str2);
            intent.putExtra("exceptionMsg", str);
            d.elq().ak(MMApplicationContext.getContext(), intent);
        }
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter
    public final void setCallbackForReset(CallbackForReset callbackForReset) {
        MMUncaughtExceptionHandler.setCallbackForReset(callbackForReset);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001a, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0) == false) goto L_0x001c;
     */
    @Override // com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IReporter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void reportException(com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler r5, java.lang.String r6, java.lang.Throwable r7) {
        /*
            r4 = this;
            r3 = 0
            java.lang.String r1 = ""
            boolean r0 = r7 instanceof junit.framework.AssertionFailedError
            if (r0 == 0) goto L_0x0039
            java.lang.String r0 = r7.getMessage()
            boolean r2 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0)
            if (r2 != 0) goto L_0x0039
            java.lang.String r0 = r5.getReportByAssertPrefix(r0)
            boolean r2 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0)
            if (r2 != 0) goto L_0x0039
        L_0x001c:
            com.tencent.mm.app.af.e(r7)
            r1 = 1
            java.lang.String r2 = com.tencent.mm.sdk.platformtools.BuildInfo.CLIENT_VERSION
            java.lang.StringBuilder r0 = a(r0, r1, r2)
            java.lang.StringBuilder r0 = r0.append(r6)
            java.lang.String r0 = r0.toString()
            b(r0, r3, r3)
            com.tencent.mm.wlogcat.b.a r0 = com.tencent.mm.wlogcat.b.a.hig()
            r0.hih()
            return
        L_0x0039:
            r0 = r1
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.t.reportException(com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler, java.lang.String, java.lang.Throwable):void");
    }

    private static void b(String str, int i2, boolean z) {
        ge(str);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11338, true, true, 2);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(25, 0, 1, true);
        if (MMApplicationContext.getProcessName().endsWith(":push")) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(25, 2, 1, true);
        } else if (MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsMpProcess()) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(25, 3, 1, true);
        } else if (MMApplicationContext.getProcessName().endsWith(":exdevice")) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(25, 4, 1, true);
        } else if (MMApplicationContext.isMMProcess()) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(25, 1, 1, true);
        }
        if (h.bH(MMApplicationContext.getContext()) == 1) {
            int bI = h.bI(MMApplicationContext.getContext());
            Log.i("MicroMsg.MMCrashReporter", "google play crash size limit %s", Integer.valueOf(bI));
            if (str.length() > bI) {
                str = str.substring(0, bI);
            }
        }
        h.d(MMApplicationContext.getContext(), MMApplicationContext.getProcessName(), z ? "jni" : "java");
        if (i2 > 0 && str.length() > i2) {
            str = str.substring(0, i2);
        }
        if (d.elq() != null) {
            Intent intent = new Intent();
            intent.setAction("uncatch_exception");
            intent.putExtra("exceptionPid", Process.myPid());
            intent.putExtra("exceptionTime", SystemClock.elapsedRealtime());
            intent.putExtra("userName", Wv());
            intent.putExtra("exceptionMsg", Base64.encodeToString(str.getBytes(), 2));
            d.elq().ak(MMApplicationContext.getContext(), intent);
        }
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        com.tencent.mm.plugin.report.service.h.eOI();
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter
    public final void reportJniCrash(int i2, String str, String str2) {
        a(i2, str, str2, false, BuildInfo.CLIENT_VERSION);
        com.tencent.mm.wlogcat.b.a.hig().hih();
    }

    /* access modifiers changed from: private */
    public static void a(String str, String str2, int i2, boolean z, String str3, int i3) {
        String formatTime = f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, System.currentTimeMillis() / 1000);
        String str4 = BuildInfo.REV;
        String str5 = BuildInfo.CLIENT_VERSION;
        String str6 = "";
        if (dlB != null) {
            str6 = dlB.toString();
        }
        long j2 = CrashReportFactory.heavyUserFlag;
        Log.i("MicroMsg.MMCrashReporter", "reportSignalAnrReal, heavyUserflag = %d", Long.valueOf(j2));
        e.INSTANCE.idkeyStat(1356, 61, 1, true);
        e eVar = e.INSTANCE;
        Object[] objArr = new Object[13];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(z ? 1 : 0);
        objArr[4] = str3;
        objArr[5] = formatTime;
        objArr[6] = str4;
        objArr[7] = str6;
        objArr[8] = Long.valueOf(dlC);
        objArr[9] = Integer.valueOf(i3);
        objArr[10] = Integer.valueOf(dlD ? 1 : 0);
        objArr[11] = Long.valueOf(j2);
        objArr[12] = str5;
        eVar.a(19664, objArr);
    }

    private static boolean cN(boolean z) {
        try {
            MessageQueue queue = Looper.getMainLooper().getQueue();
            Field declaredField = queue.getClass().getDeclaredField("mMessages");
            declaredField.setAccessible(true);
            Message message = (Message) declaredField.get(queue);
            dlB = message;
            if (message == null) {
                return false;
            }
            long when = message.getWhen();
            if (when == 0) {
                return false;
            }
            long uptimeMillis = when - SystemClock.uptimeMillis();
            dlC = uptimeMillis;
            long j2 = -10000;
            if (z) {
                j2 = -2000;
            }
            if (uptimeMillis >= j2) {
                return false;
            }
            if (message.getTarget() == null) {
                h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.app.t.AnonymousClass8 */

                    public final void run() {
                        t.Wz();
                    }
                });
            }
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.MMCrashReporter", "firstCheckMessage errror, msessage : " + e2.getMessage());
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static boolean Ww() {
        try {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = ((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getProcessesInErrorState();
            if (processesInErrorState == null) {
                return false;
            }
            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                Log.i("MicroMsg.MMCrashReporter", "[checkErrorState] found Error State proccessName = %s, proc.condition = %d", processErrorStateInfo.processName, Integer.valueOf(processErrorStateInfo.condition));
                if (processErrorStateInfo.uid != Process.myUid() && processErrorStateInfo.condition == 2) {
                    Log.i("MicroMsg.MMCrashReporter", "maybe received other apps ANR signal");
                }
                if (processErrorStateInfo.pid == Process.myPid() && processErrorStateInfo.condition == 2) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            Log.e("MicroMsg.MMCrashReporter", "[checkErrorState] error : %s", th.getMessage());
            return false;
        }
    }

    private static void a(int i2, String str, String str2, boolean z, String str3) {
        String str4 = null;
        if (i2 == 6) {
            try {
                String Wx = Wx();
                if (Wx != null) {
                    str4 = a(Wx, Process.myPid(), System.currentTimeMillis(), null);
                }
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.MMCrashReporter", th, "Failed reporting JNI crash.", new Object[0]);
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                } else if (th instanceof Error) {
                    throw ((Error) th);
                } else {
                    return;
                }
            }
        }
        StringBuilder sb = new StringBuilder(1024);
        sb.append("#[jin_crash]sig=").append(i2).append('\n');
        sb.append("#crash.previous=").append(z).append('\n');
        sb.append("#crash.provider=").append(str2).append('\n');
        sb.append((CharSequence) a("", false, str3));
        sb.append(str).append('\n');
        if (str4 != null) {
            sb.append("******* ANR Trace *******\n");
            sb.append(str4);
        }
        String sb2 = sb.toString();
        for (ICrashReporter.ICrashReportListener iCrashReportListener : dlv) {
            iCrashReportListener.onCrashDumped(sb2);
        }
        b(sb2, "NativeCrash".equals(str2) ? 32768 : 8192, true);
    }

    private static String Wx() {
        String str;
        try {
            str = af.get("dalvik.vm.stack-trace-file");
            if (str == null || str.length() == 0) {
                str = "/data/anr/traces.txt";
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "Failed finding out ANR trace file path, using default.", new Object[0]);
            str = "/data/anr/traces.txt";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            String processName = MMApplicationContext.getProcessName();
            if (processName == null || processName.length() == 0) {
                processName = MMApplicationContext.getApplicationId();
            }
            String str2 = str.substring(0, lastIndexOf) + '_' + processName + str.substring(lastIndexOf);
            if (new File(str2).isFile()) {
                return str2;
            }
        }
        if (!new File(str).isFile()) {
            return null;
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c0 A[SYNTHETIC, Splitter:B:37:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cf A[SYNTHETIC, Splitter:B:46:0x00cf] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String a(java.lang.String r10, int r11, long r12, android.app.ActivityManager.ProcessErrorStateInfo r14) {
        /*
        // Method dump skipped, instructions count: 232
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.t.a(java.lang.String, int, long, android.app.ActivityManager$ProcessErrorStateInfo):java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public final void v(String str, int i2) {
        Recovery.anr();
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11339, true, true, 5000, 0);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(26, 0, 1, true);
        ge(str);
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        com.tencent.mm.plugin.report.service.h.eOI();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.dlt >= 120000) {
            this.dlt = currentTimeMillis;
            h.d(MMApplicationContext.getContext(), MMApplicationContext.getProcessName(), "anr");
            StringBuilder sb = new StringBuilder(4096);
            sb.append((CharSequence) a("", true, BuildInfo.CLIENT_VERSION));
            sb.append("******* ANR Trace *******\n");
            if (str != null && str.length() > 51200) {
                str = str.substring(0, 51200);
            }
            sb.append(str);
            if (d.elq() != null) {
                Intent intent = new Intent();
                intent.setAction("uncatch_exception");
                intent.putExtra("tag", "anr");
                intent.putExtra("exceptionPid", i2);
                intent.putExtra("exceptionTime", SystemClock.elapsedRealtime());
                intent.putExtra("userName", bf.iDu.aA(WXUtil.LAST_LOGIN_USERNAME, "never_login_crash"));
                intent.putExtra("exceptionMsg", Base64.encodeToString(sb.toString().getBytes(), 2));
                d.elq().ak(MMApplicationContext.getContext(), intent);
            }
        }
    }

    public static void q(Context context, String str) {
        boolean z;
        StorageStats storageStats;
        dlF[0] = 0;
        dlF[1] = 0;
        dlF[2] = 0;
        if (Build.VERSION.SDK_INT < 26) {
            synchronized (dlF) {
                try {
                    PackageManager.class.getMethod("getPackageSizeInfo", String.class, IPackageStatsObserver.class).invoke(context.getPackageManager(), str, new IPackageStatsObserver.Stub() {
                        /* class com.tencent.mm.app.t.AnonymousClass11 */

                        @Override // android.content.pm.IPackageStatsObserver
                        public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                            if (packageStats != null) {
                                try {
                                    t.dlF[0] = packageStats.cacheSize;
                                    t.dlF[1] = packageStats.dataSize;
                                    t.dlF[2] = packageStats.codeSize;
                                    Log.i("MicroMsg.MMCrashReporter", "onGetStatsCompleted succeeded[%b] cacheSize :%d ,dataSize :%d ,codeSize :%d ", Boolean.valueOf(z), Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize));
                                } catch (Throwable th) {
                                    Log.printErrStackTrace("MicroMsg.MMCrashReporter", th, "onGetStatsCompleted", new Object[0]);
                                    return;
                                }
                            } else {
                                Log.i("MicroMsg.MMCrashReporter", "onGetStatsCompleted pStats is null succeeded[%b]", Boolean.valueOf(z));
                            }
                            synchronized (t.dlF) {
                                t.dlF.notify();
                            }
                        }
                    });
                    dlF.wait(500);
                } catch (Exception e2) {
                    dlF[0] = -1;
                    dlF[1] = -1;
                    dlF[2] = -1;
                    Log.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "crash e:", new Object[0]);
                    synchronized (dlF) {
                        dlF.notify();
                    }
                }
            }
            return;
        }
        Log.i("MicroMsg.MMCrashReporter", "getStats, %s", str);
        int checkOpNoThrow = ((AppOpsManager) context.getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), str);
        if (checkOpNoThrow == 3) {
            z = context.checkCallingOrSelfPermission("android.permission.PACKAGE_USAGE_STATS") == 0;
        } else {
            z = checkOpNoThrow == 0;
        }
        StorageStatsManager storageStatsManager = (StorageStatsManager) context.getSystemService("storagestats");
        int i2 = -1;
        try {
            i2 = context.getPackageManager().getPackageUid(str, 128);
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.MMCrashReporter", e3, "summer getStats crash1 e:", new Object[0]);
        }
        context.getSystemService("storage");
        try {
            storageStats = storageStatsManager.queryStatsForUid(StorageManager.UUID_DEFAULT, i2);
        } catch (Exception e4) {
            Log.printErrStackTrace("MicroMsg.MMCrashReporter", e4, "summer getStats crash2 e:", new Object[0]);
            storageStats = null;
        }
        dlF[0] = storageStats.getCacheBytes();
        dlF[1] = storageStats.getDataBytes();
        dlF[2] = storageStats.getAppBytes();
        Log.i("MicroMsg.MMCrashReporter", "summer getStats mode[%s] granted[%s] [%s, %s, %s] stack[%s]", Integer.valueOf(checkOpNoThrow), Boolean.valueOf(z), Long.valueOf(dlF[0]), Long.valueOf(dlF[1]), Long.valueOf(dlF[2]), Util.getStack());
    }

    /* access modifiers changed from: private */
    public static StringBuilder a(String str, boolean z, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        Context context = MMApplicationContext.getContext();
        StringBuilder sb = new StringBuilder(600);
        try {
            sb.append(" \n");
            sb.append("#build.info=" + BuildInfo.info()).append('\n');
            sb.append("#client.version=").append(str2).append('\n');
            sb.append("#client.verHistory=").append(cp.sj(4)).append('\n');
            sb.append("#client.revision=").append(BuildInfo.REV).append('\n');
            sb.append("#client.uin=").append(bf.iDu.aA(WXUtil.LAST_LOGIN_UIN, p.getString(q.aoG().hashCode()))).append('\n');
            sb.append("#client.dev=").append(q.aoG()).append('\n');
            sb.append("#client.build=").append(BuildInfo.TIME).append(":").append(BuildInfo.HOSTNAME).append(":").append(ChannelUtil.channelId).append('\n');
            sb.append("#client.runtime=").append(Util.nowMilliSecond() - dlq).append("(").append(Util.nullAsNil(dlA)).append(")\n");
            sb.append("#client.IMEI=").append(q.dr(true)).append('\n');
            sb.append("#client.abi=").append(Build.CPU_ABI).append('\n');
            sb.append("#qbrwoser.coreVersion=").append(WebView.getInstalledTbsCoreVersion(context)).append('\n');
            sb.append("#qbrwoser.ver=").append(WebView.getTbsSDKVersion(context)).append('\n');
            StringBuilder append = sb.append("#status.dwx_bt=");
            if (CrashReportFactory.isDualByTools()) {
                str3 = "1";
            } else {
                str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            append.append(str3).append('\n');
            StringBuilder append2 = sb.append("#status.xh=");
            if (CrashReportFactory.isHookedByXposed()) {
                str4 = "1";
            } else {
                str4 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            append2.append(str4).append('\n');
            StringBuilder append3 = sb.append("#status.x86_env=");
            if (CrashReportFactory.isX86Env()) {
                str5 = "1";
            } else {
                str5 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            append3.append(str5).append('\n');
            sb.append("#xsdkver=201201\n");
            sb.append("#accinfo.foreground=").append(AppForegroundDelegate.INSTANCE.cPB).append('\n');
            sb.append("#accinfo.currentThread=").append(Thread.currentThread().getName()).append('\n');
            StringBuilder append4 = sb.append("#accinfo.currentActivity=");
            AppForegroundDelegate appForegroundDelegate = AppForegroundDelegate.INSTANCE;
            append4.append(AppForegroundDelegate.Wb()).append('\n');
            Date date = new Date();
            sb.append("#accinfo.crashTime=").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date)).append('\n');
            Log.i("MicroMsg.MMCrashReporter", "build header.");
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                StatFs statFs2 = new StatFs(com.tencent.mm.loader.j.b.aKD());
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.app.t.AnonymousClass2 */

                    public final void run() {
                        try {
                            t.q(MMApplicationContext.getContext(), MMApplicationContext.getContext().getPackageName());
                        } catch (Exception e2) {
                            Log.e("MicroMsg.MMCrashReporter", "getPkgSize failed :%s", e2.getMessage());
                        }
                        countDownLatch.countDown();
                    }
                });
                countDownLatch.await(2, TimeUnit.SECONDS);
                str6 = String.format("%s:%d:%d:%d %d:%d:%d %s:%d:%d:%d", Environment.getDataDirectory().getAbsolutePath(), Long.valueOf(statFs.getBlockSizeLong()), Long.valueOf(statFs.getBlockCountLong()), Long.valueOf(statFs.getAvailableBlocksLong()), Long.valueOf(dlF[0]), Long.valueOf(dlF[1]), Long.valueOf(dlF[2]), com.tencent.mm.loader.j.b.aKD(), Long.valueOf(statFs2.getBlockSizeLong()), Long.valueOf(statFs2.getBlockCountLong()), Long.valueOf(statFs2.getAvailableBlocksLong()));
            } catch (Exception e2) {
                Log.e("MicroMsg.MMCrashReporter", "check data size failed :%s", e2.getMessage());
                str6 = "";
            }
            sb.append("#accinfo.data=").append(str6).append('\n');
            try {
                sb.append("#xwalk.coreVersion=").append(XWalkEnvironment.getInstalledNewstVersion(MMApplicationContext.getContext())).append('\n');
                if (XWalkEnvironment.getApplicationContext() != null) {
                    sb.append("#xwalk.sysWebCore=").append(XWalkEnvironment.safeGetChromiunVersion()).append('\n');
                }
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.MMCrashReporter", e3, "", new Object[0]);
            }
            try {
                List<com.tencent.xweb.xwalk.a.g> hvo = com.tencent.xweb.xwalk.a.h.hvo();
                if (!hvo.isEmpty()) {
                    sb.append("#xwalk.pluginInit=true\n");
                    for (com.tencent.xweb.xwalk.a.g gVar : hvo) {
                        if (gVar != null) {
                            sb.append("#xwalk.").append(gVar.getPluginName()).append("=").append(gVar.SHU).append('\n');
                        }
                    }
                } else {
                    sb.append("#xwalk.pluginInit=false\n");
                    for (Map.Entry<String, Integer> entry : com.tencent.xweb.xwalk.a.h.lI(MMApplicationContext.getContext()).entrySet()) {
                        if (entry != null) {
                            sb.append("#xwalk.").append(entry.getKey()).append("=").append(entry.getValue()).append('\n');
                        }
                    }
                }
            } catch (Exception e4) {
                Log.e("MicroMsg.MMCrashReporter", "get xwalk plugin info error ", e4);
            }
            String string = MMApplicationContext.getContext().getSharedPreferences("webview_url_prefs", 4).getString("url", null);
            if (string != null) {
                sb.append("#qbrowser.url=").append(string).append('\n');
                SharedPreferences.Editor edit = MMApplicationContext.getContext().getSharedPreferences("webview_url_prefs", 4).edit();
                edit.remove("url");
                edit.apply();
            }
            if (z) {
                String extraMessage = sCrashExtraMessageGetter.getExtraMessage();
                if (!Util.isNullOrNil(extraMessage)) {
                    sb.append("#extraCrashMsg=").append(extraMessage).append('\n');
                }
            }
            sb.append("#runtime.memory=").append(com.tencent.mm.plugin.performance.watchdogs.c.eCH().S(true, 0));
            String aBz = com.tencent.mm.ad.a.aBz();
            if (aBz.length() > 1024) {
                aBz = aBz.substring(0, 1024);
            }
            sb.append("#runtime.Activity dump [").append(aBz).append("]\n\n");
            int processThreadCount = ThreadWatchDog.getProcessThreadCount();
            sb.append("#runtime.processThreadCount=").append(processThreadCount).append('\n');
            if (processThreadCount >= 130 || BuildInfo.DEBUG) {
                sb.append("#runtime.threadInfo=");
                sb.append(com.tencent.matrix.f.a.To()).append('\n');
            }
            if (!Util.isNullOrNil(str)) {
                sb.append("#subHeader=").append(str).append('\n');
            }
            sb.append("#crashContent=\n");
        } catch (Exception e5) {
            Log.printErrStackTrace("MicroMsg.MMCrashReporter", e5, "", new Object[0]);
        }
        return sb;
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter
    public final void setupSubReporter(ISubReporter iSubReporter) {
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter
    public final void reportCrashMessage(String str, String str2) {
        b(((Object) a(str, true, BuildInfo.CLIENT_VERSION)) + str2, 0, false);
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter
    public final void setReportID(String str) {
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter
    public final void addExtraMessageGetter(ICrashReporter.ICrashReportExtraMessageGetter iCrashReportExtraMessageGetter) {
        if (iCrashReportExtraMessageGetter != null) {
            dlu.add(iCrashReportExtraMessageGetter);
        }
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter
    public final void addCrashReportListener(ICrashReporter.ICrashReportListener iCrashReportListener) {
        if (iCrashReportListener != null) {
            dlv.add(iCrashReportListener);
        }
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter
    public final void removeCrashReportListener(ICrashReporter.ICrashReportListener iCrashReportListener) {
        if (iCrashReportListener != null) {
            dlv.remove(iCrashReportListener);
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends FileObserver {
        a(String str) {
            super(str, 712);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final void onEvent(int i2, String str) {
            boolean z = false;
            if (System.currentTimeMillis() - t.this.dlt < 120000) {
                z = true;
            }
            if (!z) {
                synchronized (t.this.dlw) {
                    switch (i2) {
                        case 8:
                            Log.i("MicroMsg.MMCrashReporter", "Detected trace file changed: ".concat(String.valueOf(str)));
                            t.this.dlz.open();
                            if (t.this.dlG == null) {
                                t.this.dlG = new b(t.this, (byte) 0);
                                ThreadPool.post(t.this.dlG, "MMCrashReporter_parseANRTrace");
                            }
                            t.this.dlw.add(str);
                            break;
                        case 64:
                        case 512:
                            t.this.dlw.remove(str);
                            break;
                        case 128:
                            t.this.dlw.add(str);
                            break;
                    }
                }
            }
        }
    }

    class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(t tVar, byte b2) {
            this();
        }

        private static ActivityManager.ProcessErrorStateInfo WD() {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = ((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getProcessesInErrorState();
            if (processesInErrorState == null) {
                return null;
            }
            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                if (processErrorStateInfo.uid == Process.myUid() && processErrorStateInfo.condition == 2) {
                    return processErrorStateInfo;
                }
            }
            return null;
        }

        public final void run() {
            ArrayList arrayList;
            long currentTimeMillis = System.currentTimeMillis();
            Log.i("MicroMsg.MMCrashReporter", "ANR Parser started.");
            ActivityManager.ProcessErrorStateInfo processErrorStateInfo = null;
            while (t.this.dlz.block(10000)) {
                t.this.dlz.close();
                try {
                    Thread.sleep(500);
                } catch (Exception e2) {
                }
                processErrorStateInfo = WD();
                if (processErrorStateInfo != null) {
                    break;
                }
            }
            if (processErrorStateInfo == null && (processErrorStateInfo = WD()) == null) {
                Log.w("MicroMsg.MMCrashReporter", "ANR process not found, exit thread.");
                t.this.dlG = null;
                return;
            }
            Log.i("MicroMsg.MMCrashReporter", "Got ANR process: " + processErrorStateInfo.processName + " @ " + processErrorStateInfo.pid);
            synchronized (t.this.dlw) {
                arrayList = new ArrayList(t.this.dlw.size());
                int lastIndexOf = t.this.dly.lastIndexOf(46);
                if (lastIndexOf != -1) {
                    String str = t.this.dly.substring(0, lastIndexOf) + '_' + processErrorStateInfo.processName + t.this.dly.substring(lastIndexOf);
                    if (t.this.dlw.remove(str)) {
                        arrayList.add(str);
                    }
                }
                if (t.this.dlw.remove(t.this.dly)) {
                    arrayList.add(t.this.dly);
                }
                arrayList.addAll(t.this.dlw);
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str2 = t.this.dlx + '/' + ((String) it.next());
                String a2 = t.a(str2, processErrorStateInfo.pid, currentTimeMillis, processErrorStateInfo);
                if (a2 != null) {
                    Log.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': OK.", str2);
                    t.this.v(a2, processErrorStateInfo.pid);
                    break;
                }
                Log.i("MicroMsg.MMCrashReporter", "Parse ANR trace '%s': Not found.", str2);
            }
            Log.i("MicroMsg.MMCrashReporter", "ANR Parser ended.");
            t.this.dlG = null;
        }
    }

    static /* synthetic */ Collection Wy() {
        return new LinkedList(dlu);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void fV(final java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 258
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.t.fV(java.lang.String):void");
    }

    static /* synthetic */ void Wz() {
        AnonymousClass7 r0 = new Handler(Looper.getMainLooper()) {
            /* class com.tencent.mm.app.t.AnonymousClass7 */

            public final void handleMessage(Message message) {
                super.handleMessage(message);
            }
        };
        Message obtain = Message.obtain();
        obtain.setAsynchronous(true);
        obtain.arg1 = 1;
        Message obtain2 = Message.obtain();
        obtain2.arg2 = 2;
        r0.sendMessage(obtain);
        r0.sendMessage(obtain2);
    }

    static /* synthetic */ void WB() {
        String message;
        try {
            MessageQueue queue = Looper.getMainLooper().getQueue();
            Field declaredField = queue.getClass().getDeclaredField("mMessages");
            declaredField.setAccessible(true);
            Message message2 = (Message) declaredField.get(queue);
            if (message2 != null) {
                try {
                    message = message2.toString();
                    Log.i("MicroMsg.MMCrashReporter", "mMessage = %s", message);
                } catch (Exception e2) {
                    Log.e("MicroMsg.MMCrashReporter", "mMessage Exception e : " + e2.getMessage());
                }
                if (message2.getTarget() == null && message != null && message.contains("barrier=")) {
                    int i2 = message2.arg1;
                    Log.i("MicroMsg.MMCrashReporter", "[barrierWhen] barrierWhen : %s", Long.valueOf(message2.getWhen() - SystemClock.uptimeMillis()));
                }
            }
        } catch (Throwable th) {
            Log.e("MicroMsg.MMCrashReporter", "[checkSyncBarrierLeak] error : %s", th.getMessage());
        }
    }
}
