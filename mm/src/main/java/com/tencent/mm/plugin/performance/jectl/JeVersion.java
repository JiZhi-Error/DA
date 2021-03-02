package com.tencent.mm.plugin.performance.jectl;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.crash.ICrashReporter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.tencentmap.mapsdk.maps.BuildConfig;
import com.tencent.wxperf.jectl.JeCtl;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public final class JeVersion {
    private static MultiProcessMMKV AUP = MultiProcessMMKV.getMMKV("diagnostic_storage");
    private static final long AUQ = TimeUnit.DAYS.toMillis(1);
    private static final IListener<ps> AUR = new IListener<ps>() {
        /* class com.tencent.mm.plugin.performance.jectl.JeVersion.AnonymousClass1 */
        private long AUS = JeVersion.AUP.decodeLong("JV_KEY_LAST_REPORT_TIME_MILLIS_LONG", 0);

        {
            AppMethodBeat.i(201101);
            this.__eventId = ps.class.getName().hashCode();
            AppMethodBeat.o(201101);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ps psVar) {
            AppMethodBeat.i(201103);
            boolean bet = bet();
            AppMethodBeat.o(201103);
            return bet;
        }

        private boolean bet() {
            AppMethodBeat.i(201102);
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - this.AUS;
            Log.i("MicroMsg.JeVersion", "currentMillis - mLastReportTimeMillis = %s", Long.valueOf(j2));
            if (j2 < JeVersion.AUQ) {
                Log.i("MicroMsg.JeVersion", "not report");
                AppMethodBeat.o(201102);
            } else {
                this.AUS = currentTimeMillis;
                JeVersion.AUP.encode("JV_KEY_LAST_REPORT_TIME_MILLIS_LONG", this.AUS);
                try {
                    JeVersion.eCw();
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.JeVersion", th, "", new Object[0]);
                }
                AppMethodBeat.o(201102);
            }
            return false;
        }
    };

    static {
        AppMethodBeat.i(201116);
        AppMethodBeat.o(201116);
    }

    public static void eCv() {
        boolean z;
        AppMethodBeat.i(201111);
        if (BuildInfo.IS_ARM64) {
            Log.i("MicroMsg.JeVersion", "it's none of arm64's business");
            AppMethodBeat.o(201111);
            return;
        }
        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger() || ((b) g.af(b.class)).a(b.a.clicfg_jeversion_enable, false)) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Log.i("MicroMsg.JeVersion", "not enabled");
            AppMethodBeat.o(201111);
            return;
        }
        AUR.alive();
        CrashReportFactory.addCrashReportExtraMessageGetter(new ICrashReporter.ICrashReportExtraMessageGetter() {
            /* class com.tencent.mm.plugin.performance.jectl.JeVersion.AnonymousClass2 */

            @Override // com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportExtraMessageGetter
            public final String getCrashReportExtraMessage() {
                AppMethodBeat.i(201104);
                String decodeString = JeVersion.AUP.decodeString("JV_KEY_LAST_JE_VERSION_STRING", "");
                if (TextUtils.isEmpty(decodeString)) {
                    AppMethodBeat.o(201104);
                    return "";
                }
                String concat = "jemalloc:".concat(String.valueOf(decodeString));
                AppMethodBeat.o(201104);
                return concat;
            }
        });
        AppMethodBeat.o(201111);
    }

    public static void eCw() {
        AppMethodBeat.i(201112);
        if (Build.FINGERPRINT.equalsIgnoreCase(AUP.decodeString("JV_KEY_LAST_FINGERPRINT_STRING", ""))) {
            String decodeString = AUP.decodeString("JV_KEY_LAST_JE_VERSION_STRING", "");
            if (TextUtils.isEmpty(decodeString)) {
                Log.i("MicroMsg.JeVersion", "lastVersion is empty");
                eCx();
                AppMethodBeat.o(201112);
                return;
            }
            aJY(decodeString);
            AppMethodBeat.o(201112);
            return;
        }
        Log.i("MicroMsg.JeVersion", "finger print changed");
        eCx();
        AppMethodBeat.o(201112);
    }

    private static void aJY(String str) {
        int i2;
        AppMethodBeat.i(201113);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        arrayList.add(new IDKey(1446, 20, 1));
        if (str.startsWith("5.1.0")) {
            i2 = 21;
        } else if (str.startsWith("5.0.1")) {
            i2 = 22;
        } else if (str.startsWith(BuildConfig.VERSION_NAME)) {
            i2 = 23;
        } else if (str.startsWith("4.")) {
            i2 = 24;
        } else if (str.startsWith("3.")) {
            i2 = 25;
        } else if (str.startsWith("64-bit")) {
            i2 = 26;
        } else if (str.startsWith("Error")) {
            i2 = 27;
        } else if (str.startsWith("Exception")) {
            i2 = 28;
        } else if (str.startsWith("CrashTooManyTimes")) {
            i2 = 29;
        } else {
            i2 = 30;
        }
        Log.i("MicroMsg.JeVersion", "je version = %s", str);
        arrayList.add(new IDKey(1446, i2, 1));
        h.INSTANCE.b(arrayList, false);
        Log.i("MicroMsg.JeVersion", "report done");
        AppMethodBeat.o(201113);
    }

    private static void eCx() {
        AppMethodBeat.i(201114);
        Log.i("MicroMsg.JeVersion", "reportJeVersionHard");
        MMApplicationContext.getContext().startService(new Intent(MMApplicationContext.getContext(), JeService.class));
        AppMethodBeat.o(201114);
    }

    public static class JeService extends Service {
        public int onStartCommand(Intent intent, int i2, int i3) {
            AppMethodBeat.i(201108);
            com.tencent.f.h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.plugin.performance.jectl.JeVersion.JeService.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(201105);
                    JeService.a(JeService.this);
                    JeVersion.access$300();
                    JeService.this.stopSelf();
                    AppMethodBeat.o(201105);
                }
            });
            int onStartCommand = super.onStartCommand(intent, i2, i3);
            AppMethodBeat.o(201108);
            return onStartCommand;
        }

        public void onDestroy() {
            AppMethodBeat.i(201109);
            super.onDestroy();
            Log.d("MicroMsg.JeVersion", "onDestroy");
            com.tencent.f.h.RTc.o(new Runnable() {
                /* class com.tencent.mm.plugin.performance.jectl.JeVersion.JeService.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(201107);
                    Log.i("MicroMsg.JeVersion", "onDestroy: kill self");
                    a a2 = c.a(Process.myPid(), new a());
                    Object obj = new Object();
                    com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/plugin/performance/jectl/JeVersion$JeService$3", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                    Process.killProcess(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/performance/jectl/JeVersion$JeService$3", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                    AppMethodBeat.o(201107);
                }
            }, Util.MILLSECONDS_OF_MINUTE);
            AppMethodBeat.o(201109);
        }

        public IBinder onBind(Intent intent) {
            return null;
        }

        static /* synthetic */ void a(JeService jeService) {
            AppMethodBeat.i(201110);
            CrashReportFactory.addCrashReportExtraMessageGetter(new ICrashReporter.ICrashReportExtraMessageGetter() {
                /* class com.tencent.mm.plugin.performance.jectl.JeVersion.JeService.AnonymousClass2 */

                @Override // com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportExtraMessageGetter
                public final String getCrashReportExtraMessage() {
                    AppMethodBeat.i(201106);
                    int decodeInt = JeVersion.AUP.decodeInt("JV_KEY_CRASH_TIMES_INT", 0) + 1;
                    JeVersion.AUP.encode("JV_KEY_CRASH_TIMES_INT", decodeInt);
                    String str = "JeService crashed for " + decodeInt + " times";
                    AppMethodBeat.o(201106);
                    return str;
                }
            });
            AppMethodBeat.o(201110);
        }
    }

    static /* synthetic */ void access$300() {
        String str;
        AppMethodBeat.i(201115);
        try {
            if (AUP.decodeInt("JV_KEY_CRASH_TIMES_INT", 0) > 3) {
                AUP.encode("JV_KEY_LAST_JE_VERSION_STRING", "CrashTooManyTimes");
                AUP.encode("JV_KEY_LAST_FINGERPRINT_STRING", Build.FINGERPRINT);
                AppMethodBeat.o(201115);
                return;
            }
            str = JeCtl.version();
            AUP.encode("JV_KEY_LAST_JE_VERSION_STRING", str);
            AUP.encode("JV_KEY_LAST_FINGERPRINT_STRING", Build.FINGERPRINT);
            aJY(str);
            AppMethodBeat.o(201115);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.JeVersion", th, "JeCtl.version", new Object[0]);
            str = "Exception";
        }
    }
}
