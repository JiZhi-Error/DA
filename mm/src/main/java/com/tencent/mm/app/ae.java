package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ap.a;
import com.tencent.mm.app.o;
import com.tencent.mm.booter.z;
import com.tencent.mm.cr.d;
import com.tencent.mm.g.a.e;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelsimple.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.f;

@Deprecated
public final class ae extends o.a {
    private static int dmr = -1;
    private static boolean dmt = false;
    public boolean dmq = true;
    private boolean dms = false;
    private final MTimerHandler dmu = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.app.ae.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(19480);
            String topActivityName = Util.getTopActivityName(MMApplicationContext.getContext());
            if (topActivityName == null || !topActivityName.toLowerCase().startsWith(MMApplicationContext.getSourcePackageName())) {
                Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired, kill tools process");
                d.bpG("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                AppMethodBeat.o(19480);
            } else {
                Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired, top activity belongs to mm, skip kill tools");
                AppMethodBeat.o(19480);
            }
            return false;
        }
    }, true);
    private Handler handler = new Handler(Looper.getMainLooper());

    public ae() {
        AppMethodBeat.i(19482);
        AppMethodBeat.o(19482);
    }

    static /* synthetic */ int WI() {
        int i2 = dmr;
        dmr = i2 + 1;
        return i2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.app.o.a
    public final Handler getHandler() {
        return this.handler;
    }

    @Override // com.tencent.mm.app.o
    public final void onAppForeground(final String str) {
        AppMethodBeat.i(19483);
        final long uptimeMillis = SystemClock.uptimeMillis();
        if (!this.dmu.stopped()) {
            this.dmu.stopTimer();
        }
        if (bg.aAc() && g.aAf().hpY && !bg.azj()) {
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.app.ae.AnonymousClass2 */

                public final void run() {
                    String str;
                    AppMethodBeat.i(231392);
                    f.fJ(true);
                    a.fE(true);
                    com.tencent.mm.modelmulti.o.a(o.d.TEXT).bdQ().execute();
                    bg.aVF();
                    c.aSM().d(null);
                    com.tencent.mm.modelstat.o.run(4);
                    com.tencent.mm.modelstat.o.run(3);
                    com.tencent.mm.modelstat.o.fM(true);
                    xk xkVar = new xk();
                    xkVar.edE.edF = true;
                    xkVar.edE.scene = 1;
                    EventCenter.instance.publish(xkVar);
                    com.tencent.mm.aj.o.aYx();
                    cf.aWl().f(19, 1);
                    l lVar = new l();
                    lVar.dCi.isActive = true;
                    EventCenter.instance.publish(lVar);
                    com.tencent.mm.g.a.d dVar = new com.tencent.mm.g.a.d();
                    dVar.dBP.dBQ = true;
                    EventCenter.instance.publish(dVar);
                    z zVar = z.gmQ;
                    String str2 = str;
                    if (zVar.gnb == -1) {
                        if (zVar.gmR.ake(3) == 0) {
                            zVar.gmR.setLong(1, Util.nowSecond());
                        }
                        zVar.gnb = Util.nowSecond();
                        Object[] objArr = new Object[2];
                        if (zVar.gmU == null) {
                            str = BuildConfig.COMMAND;
                        } else {
                            str = zVar.gmU.gnh;
                        }
                        objArr[0] = str;
                        objArr[1] = str2;
                        Log.i("MicroMsg.StayTimeReport", "onAppResume chatUser:%s, class:%s", objArr);
                        if (zVar.gmU != null) {
                            zVar.gmY = Util.currentTicks();
                            if (str2 != null && str2.contains("WebViewUI")) {
                                zVar.gmZ = Util.currentTicks();
                            }
                        }
                    }
                    e eVar = new e();
                    eVar.dBR.active = true;
                    eVar.dBR.className = str;
                    EventCenter.instance.publish(eVar);
                    try {
                        if (ae.dmt) {
                            boolean unused = ae.dmt = false;
                            Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                            AppMethodBeat.o(231392);
                            return;
                        }
                        boolean unused2 = ae.dmt = true;
                        if (ae.this.dmq) {
                            if (com.tencent.mm.compatible.util.d.oD(23)) {
                                Context context = MMApplicationContext.getContext();
                                int a2 = ((b) g.af(b.class)).a(b.a.clicfg_if_show_ignore_battery_optimizations, 0);
                                int i2 = MultiProcessMMKV.getMMKV("sdcard_usable_report").getInt("ignore_battery_dialog_time", 0);
                                Log.i("MicroMsg.BatteryUtil", "getIgnoreBatteryOptimizationsDialogTime() time=%s", Integer.valueOf(i2));
                                if (Util.isEqual(a2, 1) && i2 < 3 && !com.tencent.mm.booter.c.cf(context)) {
                                    Log.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations()");
                                    SharedPreferences.Editor edit = MultiProcessMMKV.getMMKV("sdcard_usable_report").edit();
                                    long currentTimeMillis = System.currentTimeMillis();
                                    boolean z = false;
                                    if (i2 == 0) {
                                        try {
                                            com.tencent.mm.booter.c.aky();
                                        } catch (Exception e2) {
                                            z = true;
                                            Log.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", e2.getClass().toString(), e2.getMessage());
                                        }
                                        if (!z) {
                                            edit.putLong("last_ignore_battery_dialog_time", currentTimeMillis);
                                            edit.putInt("ignore_battery_dialog_time", 1);
                                        }
                                    } else {
                                        long j2 = MultiProcessMMKV.getMMKV("sdcard_usable_report").getLong("last_ignore_battery_dialog_time", currentTimeMillis);
                                        long j3 = currentTimeMillis - j2;
                                        Log.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() last:%s diff:%s", Long.valueOf(j2), Long.valueOf(j3));
                                        if (i2 == 1) {
                                            if (j3 >= Util.MILLSECONDS_OF_DAY) {
                                                try {
                                                    com.tencent.mm.booter.c.aky();
                                                } catch (Exception e3) {
                                                    z = true;
                                                    Log.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", e3.getClass().toString(), e3.getMessage());
                                                }
                                                if (!z) {
                                                    edit.putLong("last_ignore_battery_dialog_time", currentTimeMillis);
                                                    edit.putInt("ignore_battery_dialog_time", 2);
                                                }
                                            }
                                        } else if (i2 == 2 && j3 >= 604800000) {
                                            try {
                                                com.tencent.mm.booter.c.aky();
                                            } catch (Exception e4) {
                                                z = true;
                                                Log.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", e4.getClass().toString(), e4.getMessage());
                                            }
                                            if (!z) {
                                                edit.putLong("last_ignore_battery_dialog_time", currentTimeMillis);
                                                edit.putInt("ignore_battery_dialog_time", 3);
                                            }
                                        }
                                    }
                                    edit.commit();
                                }
                            }
                            if (com.tencent.mm.pluginsdk.l.c.goj() || ae.this.dms) {
                                Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "SdcardUsableDetectionEvent pass tipCountAboutSdcardDisable=%s ifSdcardDialogShow=%s", Integer.valueOf(ae.dmr), Boolean.valueOf(ae.this.dms));
                                int unused3 = ae.dmr = -1;
                                if (ae.this.dms) {
                                    boolean unused4 = ae.dmt = false;
                                    Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                                    AppMethodBeat.o(231392);
                                    return;
                                }
                                SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("sdcard_usable_report", 4);
                                int i3 = sharedPreferences.getInt("mm_process_pid", -1);
                                int myPid = Process.myPid();
                                Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "SdcardUsableDetectionEvent pass mmPid=%s mmCurPid=%s", Integer.valueOf(i3), Integer.valueOf(myPid));
                                if (Util.isEqual(i3, -1)) {
                                    boolean unused5 = ae.dmt = false;
                                    Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                                    AppMethodBeat.o(231392);
                                    return;
                                }
                                if (Util.isEqual(i3, myPid)) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(951, 22);
                                } else if (!Util.isEqual(i3, myPid)) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(951, 21);
                                }
                                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                                edit2.putInt("mm_process_pid", -1);
                                edit2.apply();
                                boolean unused6 = ae.dmt = false;
                                Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                                AppMethodBeat.o(231392);
                                return;
                            }
                            ae.WI();
                            Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "tipCountAboutSdcardDisable:%d", Integer.valueOf(ae.dmr));
                            if (ae.dmr <= 0) {
                                boolean unused7 = ae.dmt = false;
                                Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                                AppMethodBeat.o(231392);
                                return;
                            }
                            ae.this.dms = true;
                            switch (ae.dmr) {
                                case 1:
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(951, 0);
                                    SharedPreferences.Editor edit3 = MMApplicationContext.getContext().getSharedPreferences("sdcard_usable_report", 4).edit();
                                    edit3.putInt("mm_process_pid", Process.myPid());
                                    edit3.apply();
                                    break;
                                case 3:
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(951, 1);
                                    break;
                                case 5:
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(951, 2);
                                    break;
                                case 10:
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(951, 3);
                                    break;
                            }
                            ae.this.getHandler().post(new Runnable() {
                                /* class com.tencent.mm.app.ae.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(231391);
                                    new f.a(MMApplicationContext.getContext()).bow(MMApplicationContext.getContext().getString(R.string.gf6)).aC(MMApplicationContext.getContext().getString(R.string.zb)).Dq(false).b(new f.c() {
                                        /* class com.tencent.mm.app.ae.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                        @Override // com.tencent.mm.ui.widget.a.f.c
                                        public final void e(boolean z, String str) {
                                            AppMethodBeat.i(231390);
                                            ae.this.dmq = false;
                                            ae.this.dms = false;
                                            AppMethodBeat.o(231390);
                                        }
                                    }).show();
                                    AppMethodBeat.o(231391);
                                }
                            });
                            boolean unused8 = ae.dmt = false;
                            Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                            AppMethodBeat.o(231392);
                            return;
                        }
                        ae.this.dmq = true;
                        boolean unused9 = ae.dmt = false;
                        Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                        AppMethodBeat.o(231392);
                    } catch (Throwable th) {
                        boolean unused10 = ae.dmt = false;
                        Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                        AppMethodBeat.o(231392);
                        throw th;
                    }
                }
            }, "onAppForegroundThread");
        }
        AppMethodBeat.o(19483);
    }

    @Override // com.tencent.mm.app.o
    public final void onAppBackground(String str) {
        AppMethodBeat.i(19484);
        if (bg.aAc() && g.aAf().hpY && !bg.azj()) {
            com.tencent.mm.modelsimple.f.fJ(false);
            a.fE(false);
            com.tencent.mm.modelstat.o.fM(false);
            com.tencent.mm.bs.a.bfX(com.tencent.mm.bs.a.gsY());
            if (!this.dmu.stopped()) {
                this.dmu.stopTimer();
            }
            boolean z = Util.isProcessRunning(MMApplicationContext.getContext(), new StringBuilder().append(MMApplicationContext.getPackageName()).append(":tools").toString()) || Util.isProcessRunning(MMApplicationContext.getContext(), new StringBuilder().append(MMApplicationContext.getPackageName()).append(":toolsmp").toString());
            Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "before kill tools, tools is running : %b", Boolean.valueOf(z));
            if (z) {
                this.dmu.startTimer(1800000);
            }
            Log.d("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][statInputMethod]");
            boolean z2 = false;
            bg.aVF();
            Object obj = c.azQ().get(327808, (Object) null);
            if (obj == null) {
                z2 = true;
            } else if (Util.isNullOrNil(obj.toString())) {
                z2 = true;
            } else {
                if (System.currentTimeMillis() - Util.safeParseLong(obj.toString()) >= 604800000) {
                    z2 = true;
                }
            }
            Log.d("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][statInputMethod] needToStat:%s", String.valueOf(z2));
            if (z2) {
                try {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(11375, Util.nullAsNil(Settings.Secure.getString(MMApplicationContext.getContext().getContentResolver(), "default_input_method")));
                    bg.aVF();
                    c.azQ().set(327808, Long.valueOf(System.currentTimeMillis()));
                } catch (Exception e2) {
                    Log.e("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][inputMethodStat]exception:" + e2.getMessage());
                }
            }
            l lVar = new l();
            lVar.dCi.isActive = false;
            EventCenter.instance.publish(lVar);
            com.tencent.mm.g.a.d dVar = new com.tencent.mm.g.a.d();
            dVar.dBP.dBQ = false;
            EventCenter.instance.publish(dVar);
            z zVar = z.gmQ;
            if (zVar.gnb != -1) {
                long nowSecond = Util.nowSecond();
                String str2 = ((String) zVar.gmR.get(2, "")) + zVar.gnb + "|" + nowSecond + "#";
                zVar.gmR.set(2, str2);
                int ake = zVar.gmR.ake(3) + 1;
                zVar.gmR.setInt(3, ake);
                Log.i("MicroMsg.StayTimeReport", "onAppPause,appReportCnt:%d app(%d-%d)", Integer.valueOf(ake), Long.valueOf(zVar.gnb), Long.valueOf(nowSecond));
                zVar.gnb = -1;
                if (Util.secondsToNow(zVar.gmR.getLong(1, 0)) > 3600 * ((long) zVar.gnd) || ake > zVar.gnc) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(13110, str2);
                    Log.i("MicroMsg.StayTimeReport", "report appStayTime:%s", str2);
                    zVar.gmR.set(2, "");
                    zVar.gmR.setInt(3, 0);
                }
                if (zVar.gmU != null) {
                    zVar.gmU.time += Util.ticksToNow(zVar.gmY) / 1000;
                    if (str != null && str.contains("WebViewUI")) {
                        z.a aVar = zVar.gmU;
                        aVar.gnk = (int) (((long) aVar.gnk) + (Util.ticksToNow(zVar.gmZ) / 1000));
                    }
                    Log.i("MicroMsg.StayTimeReport", "onAppPause, chatting:totalTime:%d", Long.valueOf(zVar.gmU.time));
                }
            }
            e eVar = new e();
            eVar.dBR.active = false;
            eVar.dBR.className = str;
            EventCenter.instance.publish(eVar);
        }
        AppMethodBeat.o(19484);
    }
}
