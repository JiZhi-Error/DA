package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.mb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.djz;
import com.tencent.mm.protocal.protobuf.dka;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.HashMap;

public final class o {
    private static long joV = Util.MILLSECONDS_OF_DAY;
    private static HashMap<String, Long> joW = new HashMap<>();
    private static String joX = null;
    private static long joY = MAlarmHandler.NEXT_FIRE_INTERVAL;
    private static int joZ = 0;
    private static long jpa = 0;
    private static long jpb = 0;
    private static float jpc = 0.0f;
    private static float jpd = 0.0f;
    private static int jpe = 0;
    private static int jpf = 0;
    private static long jpg = 0;
    private static String jph = "";
    private static final byte[] lock = new byte[0];
    private static MTimerHandler timer = new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.modelstat.o.AnonymousClass4 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(151113);
            try {
                long unused = o.joY = MAlarmHandler.NEXT_FIRE_INTERVAL;
                if (o.joZ >= 2000 || o.joZ <= 1000) {
                    o.tY(o.joZ);
                } else {
                    o.tX(o.joZ);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.NetTypeReporter", "run :%s", Util.stackTraceToString(e2));
            }
            AppMethodBeat.o(151113);
            return false;
        }
    }, false);

    static /* synthetic */ void tY(int i2) {
        AppMethodBeat.i(151128);
        a(i2, 0.0f, 0.0f, 0, 0);
        AppMethodBeat.o(151128);
    }

    static class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(151115);
            try {
                if (g.aAf().azp()) {
                    g.aAf();
                    if (!com.tencent.mm.kernel.a.azj()) {
                        if (intent == null || Util.isNullOrNil(intent.getAction())) {
                            Object[] objArr = new Object[1];
                            objArr[0] = intent == null ? "intent is null" : "action is null";
                            Log.e("MicroMsg.NetTypeReporter", "onReceive %s  ", objArr);
                            AppMethodBeat.o(151115);
                            return;
                        }
                        String action = intent.getAction();
                        Log.i("MicroMsg.NetTypeReporter", "onReceive action:%s foreground:%b", action, Boolean.valueOf(CrashReportFactory.foreground));
                        if (!CrashReportFactory.foreground) {
                            AppMethodBeat.o(151115);
                            return;
                        } else if (action.equals("android.net.wifi.supplicant.CONNECTION_CHANGE")) {
                            o.run(1001);
                            AppMethodBeat.o(151115);
                            return;
                        } else if (action.equals("android.net.wifi.supplicant.STATE_CHANGE")) {
                            o.run(1002);
                            AppMethodBeat.o(151115);
                            return;
                        } else if (action.equals("android.net.wifi.STATE_CHANGE")) {
                            o.run(1003);
                            AppMethodBeat.o(151115);
                            return;
                        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                            o.run(1004);
                            AppMethodBeat.o(151115);
                            return;
                        } else if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                            o.run(1005);
                            AppMethodBeat.o(151115);
                            return;
                        } else {
                            if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                                o.run(1006);
                                EventCenter.instance.publish(new mb());
                            }
                            AppMethodBeat.o(151115);
                            return;
                        }
                    }
                }
                g.aAf();
                Log.e("MicroMsg.NetTypeReporter", "onReceive acc not ready .%b %b", Boolean.valueOf(g.aAf().azp()), Boolean.valueOf(com.tencent.mm.kernel.a.azj()));
                AppMethodBeat.o(151115);
            } catch (Throwable th) {
                Log.e("MicroMsg.NetTypeReporter", "onReceive : %s", Util.stackTraceToString(th));
                AppMethodBeat.o(151115);
            }
        }
    }

    public static void dh(Context context) {
        AppMethodBeat.i(151116);
        if (context == null) {
            try {
                Log.e("MicroMsg.NetTypeReporter", "registerReceiver ctx == null");
                AppMethodBeat.o(151116);
            } catch (Throwable th) {
                Log.e("MicroMsg.NetTypeReporter", "registerReceiver : %s", Util.stackTraceToString(th));
                AppMethodBeat.o(151116);
            }
        } else {
            a aVar = new a((byte) 0);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.supplicant.CONNECTION_CHANGE");
            intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(aVar, intentFilter);
            Log.i("MicroMsg.NetTypeReporter", "registerReceiver finish");
            AppMethodBeat.o(151116);
        }
    }

    static {
        AppMethodBeat.i(151129);
        AppMethodBeat.o(151129);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x014e A[SYNTHETIC, Splitter:B:43:0x014e] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0153 A[Catch:{ Exception -> 0x0158 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0178 A[SYNTHETIC, Splitter:B:52:0x0178] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x017d A[Catch:{ Exception -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01da A[Catch:{ Exception -> 0x01e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x020e A[SYNTHETIC, Splitter:B:82:0x020e] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0213 A[Catch:{ Exception -> 0x0217 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x022f A[SYNTHETIC, Splitter:B:91:0x022f] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0234 A[Catch:{ Exception -> 0x023b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean w(java.util.ArrayList<java.lang.String> r14) {
        /*
        // Method dump skipped, instructions count: 617
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelstat.o.w(java.util.ArrayList):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0214 A[Catch:{ Exception -> 0x033f }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0243 A[Catch:{ Exception -> 0x048e }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0429  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x044a  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0498  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String[] tW(int r19) {
        /*
        // Method dump skipped, instructions count: 1179
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelstat.o.tW(int):java.lang.String[]");
    }

    private static String PT(String str) {
        AppMethodBeat.i(151119);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(151119);
            return "";
        }
        char[] charArray = str.toCharArray();
        for (char c2 : charArray) {
            if ((c2 < 'a' || c2 > 'z') && ((c2 < 'A' || c2 > 'Z') && !((c2 >= '0' && c2 <= '9') || c2 == '|' || c2 == '-' || c2 == ' ' || c2 == ':'))) {
                AppMethodBeat.o(151119);
                return "";
            }
        }
        AppMethodBeat.o(151119);
        return str;
    }

    private static long bgk() {
        long nullAs;
        AppMethodBeat.i(151120);
        synchronized (lock) {
            try {
                nullAs = Util.nullAs((Long) g.aAh().azQ().get(ar.a.USERINFO_REPORTNETTYPE_SEQ_LONG, (Object) null), 1);
                g.aAh().azQ().set(ar.a.USERINFO_REPORTNETTYPE_SEQ_LONG, Long.valueOf(1 + nullAs));
                g.aAh().azQ().gBI();
                Log.i("MicroMsg.NetTypeReporter", "incSeq after write  old:%d new:%d", Long.valueOf(nullAs), Long.valueOf(Util.nullAs((Long) g.aAh().azQ().get(ar.a.USERINFO_REPORTNETTYPE_SEQ_LONG, (Object) null), 1)));
                try {
                } catch (Throwable th) {
                    AppMethodBeat.o(151120);
                    throw th;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.NetTypeReporter", "incSeq :%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(151120);
                return -1;
            }
        }
        AppMethodBeat.o(151120);
        return nullAs;
    }

    private static void a(int i2, final float f2, final float f3, final int i3, final long j2) {
        AppMethodBeat.i(151121);
        long nowMilliSecond = Util.nowMilliSecond();
        if (jpa <= 0 || nowMilliSecond - jpa <= 5000) {
            final String[] tW = tW(i2);
            if (tW == null || tW.length != 4 || Util.isNullOrNil(tW[0])) {
                Log.e("MicroMsg.NetTypeReporter", "report get failed val");
                AppMethodBeat.o(151121);
                return;
            }
            Log.d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", Integer.valueOf(i2), Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i3), Long.valueOf(j2), tW[0]);
            d.a aVar = new d.a();
            aVar.iLN = new djz();
            aVar.iLO = new dka();
            aVar.uri = "/cgi-bin/micromsg-bin/rtkvreport";
            aVar.funcId = 716;
            d aXF = aVar.aXF();
            final djz djz = (djz) aXF.iLK.iLR;
            djz.hid = com.tencent.mm.protocal.d.KyJ;
            djz.hie = com.tencent.mm.protocal.d.KyI;
            djz.hif = com.tencent.mm.protocal.d.KyL;
            djz.hig = com.tencent.mm.protocal.d.KyM;
            djz.hih = LocaleUtil.getApplicationLanguage();
            djz.MlF = 11747;
            long milliSecondsToNow = Util.milliSecondsToNow(jpa);
            if (milliSecondsToNow > 600000 || milliSecondsToNow < 0) {
                milliSecondsToNow = 0;
            }
            djz.Cyk = tW[0] + "0," + f2 + "," + f3 + "," + i3 + "," + j2 + "," + (CrashReportFactory.foreground ? "1" : String.valueOf(milliSecondsToNow)) + "," + tW[1] + "," + tW[2] + "," + tW[3];
            final long nowMilliSecond2 = Util.nowMilliSecond();
            aa.a(aXF, new aa.a() {
                /* class com.tencent.mm.modelstat.o.AnonymousClass2 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(int i2, int i3, String str, d dVar, q qVar) {
                    AppMethodBeat.i(151111);
                    Log.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(Util.milliSecondsToNow(nowMilliSecond2)), djz.Cyk);
                    if (!(i2 == 0 && i3 == 0)) {
                        long milliSecondsToNow = Util.milliSecondsToNow(o.jpa);
                        if (milliSecondsToNow > 600000 || milliSecondsToNow < 0) {
                            milliSecondsToNow = 0;
                        }
                        h.INSTANCE.kvStat(11747, tW[0] + "1," + f2 + "," + f3 + "," + i3 + "," + j2 + "," + (CrashReportFactory.foreground ? "1" : String.valueOf(milliSecondsToNow)) + "," + tW[1] + "," + tW[2] + "," + tW[3]);
                    }
                    g.aAh().azQ().set(ar.a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, Long.valueOf(Util.nowMilliSecond()));
                    AppMethodBeat.o(151111);
                    return 0;
                }
            }, true);
            AppMethodBeat.o(151121);
            return;
        }
        Log.e("MicroMsg.NetTypeReporter", "never  report  at  background :%d diff:%d", Long.valueOf(jpa), Long.valueOf(nowMilliSecond - jpa));
        AppMethodBeat.o(151121);
    }

    public static void O(int i2, String str) {
        AppMethodBeat.i(151122);
        d.a aVar = new d.a();
        aVar.iLN = new djz();
        aVar.iLO = new dka();
        aVar.uri = "/cgi-bin/micromsg-bin/rtkvreport";
        aVar.funcId = 716;
        d aXF = aVar.aXF();
        final djz djz = (djz) aXF.iLK.iLR;
        djz.hid = com.tencent.mm.protocal.d.KyJ;
        djz.hie = com.tencent.mm.protocal.d.KyI;
        djz.hif = com.tencent.mm.protocal.d.KyL;
        djz.hig = com.tencent.mm.protocal.d.KyM;
        djz.hih = LocaleUtil.getApplicationLanguage();
        djz.MlF = i2;
        djz.Cyk = str;
        Log.i("MicroMsg.NetTypeReporter", "reportCgi logId:%d, value:%s", Integer.valueOf(i2), str);
        final long nowMilliSecond = Util.nowMilliSecond();
        aa.a(aXF, new aa.a() {
            /* class com.tencent.mm.modelstat.o.AnonymousClass3 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                AppMethodBeat.i(151112);
                Log.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)), djz.Cyk);
                AppMethodBeat.o(151112);
                return 0;
            }
        });
        AppMethodBeat.o(151122);
    }

    private static void b(int i2, float f2, float f3, int i3, long j2) {
        AppMethodBeat.i(151123);
        try {
            Log.i("MicroMsg.NetTypeReporter", "checkTimeReport scene:%d diff:%d  time:%d", Integer.valueOf(i2), Long.valueOf(Util.milliSecondsToNow(joY)), Long.valueOf(joY));
            if (i2 > 2000 || Util.milliSecondsToNow(joY) > 300000) {
                Log.i("MicroMsg.NetTypeReporter", "force Run, scene:%d diff:%d time:%d ", Integer.valueOf(i2), Long.valueOf(Util.milliSecondsToNow(joY)), Long.valueOf(joY));
                joZ = i2;
                joY = MAlarmHandler.NEXT_FIRE_INTERVAL;
                a(i2, f2, f3, i3, j2);
                AppMethodBeat.o(151123);
                return;
            }
            if (joY == MAlarmHandler.NEXT_FIRE_INTERVAL) {
                joY = Util.nowMilliSecond() + Util.MILLSECONDS_OF_MINUTE;
            }
            joZ = i2;
            timer.startTimer(Util.MILLSECONDS_OF_MINUTE);
            AppMethodBeat.o(151123);
        } catch (Throwable th) {
            Log.e("MicroMsg.NetTypeReporter", "checkTimeReport error: %s", Util.stackTraceToString(th));
            AppMethodBeat.o(151123);
        }
    }

    public static void fM(boolean z) {
        AppMethodBeat.i(151124);
        if (z) {
            jpa = 0;
            AppMethodBeat.o(151124);
        } else if (timer.stopped()) {
            AppMethodBeat.o(151124);
        } else {
            Log.i("MicroMsg.NetTypeReporter", "setToForeground user turn to background run report now");
            jpa = Util.nowMilliSecond();
            timer.startTimer(0);
            AppMethodBeat.o(151124);
        }
    }

    public static synchronized void a(int i2, float f2, float f3, int i3) {
        synchronized (o.class) {
            AppMethodBeat.i(151125);
            if (i2 < 2000 || f2 == 0.0f || f3 == 0.0f) {
                Log.e("MicroMsg.NetTypeReporter", "reportGps, invalid args, scene = %d, lon = %f, lat = %f, pre = %d", Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i3));
                AppMethodBeat.o(151125);
            } else if (Util.milliSecondsToNow(jpg) < Util.MILLSECONDS_OF_MINUTE) {
                Log.e("MicroMsg.NetTypeReporter", "reportGps, hit lastReportGpsLimit, request dropped, scene = %d, lon = %f, lat = %f, pre = %d", Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i3));
                AppMethodBeat.o(151125);
            } else {
                Log.i("MicroMsg.NetTypeReporter", "reportGps scene:%d lon:%f lat:%f pre:%d last:%d", Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i3), Long.valueOf(Util.milliSecondsToNow(jpg)));
                jpg = Util.nowMilliSecond();
                jpf = i2;
                jpb = Util.nowMilliSecond();
                jpe = i3;
                jpc = f3;
                jpd = f2;
                try {
                    ((WifiManager) MMApplicationContext.getContext().getSystemService("wifi")).startScan();
                    g.aAk().postToWorkerDelayed(new Runnable() {
                        /* class com.tencent.mm.modelstat.o.AnonymousClass5 */

                        public final void run() {
                            AppMethodBeat.i(151114);
                            o.run(1005);
                            AppMethodBeat.o(151114);
                        }
                    }, 5000);
                    AppMethodBeat.o(151125);
                } catch (Exception e2) {
                    Log.e("MicroMsg.NetTypeReporter", "reportGps :%s", Util.stackTraceToString(e2));
                    AppMethodBeat.o(151125);
                }
            }
        }
    }

    public static synchronized void run(int i2) {
        synchronized (o.class) {
            AppMethodBeat.i(151126);
            Log.i("MicroMsg.NetTypeReporter", "run scene:%d foreground:%b lastGpsTime:%d lastbssid:%s", Integer.valueOf(i2), Boolean.valueOf(CrashReportFactory.foreground), Long.valueOf(jpb), jph);
            if (i2 == 1005) {
                try {
                    if (jpb > 0) {
                        Log.d("MicroMsg.NetTypeReporter", "report gps scene:%d lastscene:%d [%f,%f,%d] lastGpsTime", Integer.valueOf(i2), Integer.valueOf(jpf), Float.valueOf(jpd), Float.valueOf(jpc), Integer.valueOf(jpe), Long.valueOf(jpb));
                        long milliSecondsToNow = Util.milliSecondsToNow(jpb);
                        int i3 = jpf;
                        float f2 = jpc;
                        float f3 = jpd;
                        int i4 = jpe;
                        jpb = 0;
                        jpc = 0.0f;
                        jpd = 0.0f;
                        jpe = 0;
                        jpf = 0;
                        b(i3, f3, f2, i4, milliSecondsToNow);
                        AppMethodBeat.o(151126);
                    }
                } catch (Throwable th) {
                    Log.e("MicroMsg.NetTypeReporter", "run :%s", Util.stackTraceToString(th));
                    AppMethodBeat.o(151126);
                }
            }
            if (!CrashReportFactory.foreground) {
                Log.w("MicroMsg.NetTypeReporter", "run is not foreground give up %d ", Integer.valueOf(i2));
                AppMethodBeat.o(151126);
            } else if (i2 == 3) {
                String bssid = ((WifiManager) MMApplicationContext.getContext().getSystemService("wifi")).getConnectionInfo().getBSSID();
                Log.d("MicroMsg.NetTypeReporter", "run scene:%d SCENE_TO_FOREGROUND_BSSID_CHANGE %s %s ", Integer.valueOf(i2), bssid, jph);
                if (!Util.isNullOrNil(bssid) && !bssid.equals(jph)) {
                    jph = bssid;
                    b(i2, 0.0f, 0.0f, 0, 0);
                }
                AppMethodBeat.o(151126);
            } else if (i2 == 4) {
                long milliSecondsToNow2 = Util.milliSecondsToNow(Util.nullAs((Long) g.aAh().azQ().get(ar.a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, (Object) null), 0));
                Log.i("MicroMsg.NetTypeReporter", "run scene:%d SCENE_TO_FOREGROUND_TIMEOUT  diff:%d", Integer.valueOf(i2), Long.valueOf(milliSecondsToNow2));
                if (milliSecondsToNow2 >= 21600000) {
                    b(i2, 0.0f, 0.0f, 0, 0);
                }
                AppMethodBeat.o(151126);
            } else {
                b(i2, 0.0f, 0.0f, 0, 0);
                AppMethodBeat.o(151126);
            }
        }
    }

    static /* synthetic */ void tX(int i2) {
        AppMethodBeat.i(151127);
        long nowMilliSecond = Util.nowMilliSecond();
        if (jpa <= 0 || nowMilliSecond - jpa <= 5000) {
            String[] tW = tW(i2);
            if (tW == null || tW.length != 4 || Util.isNullOrNil(tW[0])) {
                Log.e("MicroMsg.NetTypeReporter", "report get failed val");
                AppMethodBeat.o(151127);
                return;
            }
            Log.d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", Integer.valueOf(i2), Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)), Float.valueOf(0.0f), Float.valueOf(0.0f), 0, 0L, tW[0]);
            long milliSecondsToNow = Util.milliSecondsToNow(jpa);
            if (milliSecondsToNow > 600000 || milliSecondsToNow < 0) {
                milliSecondsToNow = 0;
            }
            h.INSTANCE.kvStat(11747, tW[0] + "1,0.0,0.0" + ",0,0" + "," + (CrashReportFactory.foreground ? "1" : String.valueOf(milliSecondsToNow)) + "," + tW[1] + "," + tW[2] + "," + tW[3]);
            g.aAh().azQ().set(ar.a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, Long.valueOf(Util.nowMilliSecond()));
            AppMethodBeat.o(151127);
            return;
        }
        Log.e("MicroMsg.NetTypeReporter", "never  report (reportKV) at  background :%d diff:%d", Long.valueOf(jpa), Long.valueOf(nowMilliSecond - jpa));
        AppMethodBeat.o(151127);
    }
}
