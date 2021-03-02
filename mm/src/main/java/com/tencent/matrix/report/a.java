package com.tencent.matrix.report;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.e.k;
import android.text.TextUtils;
import com.tencent.matrix.a.b.a.e;
import com.tencent.matrix.a.b.a.g;
import com.tencent.matrix.a.c.c;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.AppBrands;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;

public final class a {
    public static String SN() {
        String processName = MMApplicationContext.getProcessName();
        if (TextUtils.isEmpty(processName)) {
            return "";
        }
        if (!processName.contains(":")) {
            return "main";
        }
        return processName.substring(":".length() + processName.lastIndexOf(":"));
    }

    public static String SO() {
        AppBrands.AppBrandAppInfo appBrandInfo;
        if (AppBrands.isAppBrandProc() && (appBrandInfo = AppBrands.getAppBrandInfo()) != null && !TextUtils.isEmpty(appBrandInfo.appName)) {
            return appBrandInfo.appName;
        }
        AppForegroundDelegate appForegroundDelegate = AppForegroundDelegate.INSTANCE;
        String Wb = AppForegroundDelegate.Wb();
        if (TextUtils.isEmpty(Wb)) {
            Wb = com.tencent.matrix.a.INSTANCE.cPC;
        }
        if (Wb.contains("@")) {
            return Wb.substring(0, Wb.lastIndexOf("@"));
        }
        return Wb;
    }

    public static int SP() {
        return cA(AppForegroundDelegate.INSTANCE.cPB);
    }

    @SuppressLint({"RestrictedApi"})
    public static int cA(boolean z) {
        if (z) {
            return 1;
        }
        if (c.bf(MMApplicationContext.getContext())) {
            return 3;
        }
        return 2;
    }

    @SuppressLint({"RestrictedApi"})
    public static int SQ() {
        Context context = MMApplicationContext.getContext();
        if (c.bc(context)) {
            return 1;
        }
        if (!c.bd(context)) {
            return 3;
        }
        if (c.be(context)) {
            return 4;
        }
        return 2;
    }

    /* renamed from: com.tencent.matrix.report.a$a  reason: collision with other inner class name */
    public static class C0226a {
        public static void cB(boolean z) {
            e.INSTANCE.idkeyStat(1540, z ? 101 : 100, 1, false);
        }

        public static void cC(boolean z) {
            long j2;
            e eVar = e.INSTANCE;
            if (z) {
                j2 = 0;
            } else {
                j2 = 1;
            }
            eVar.idkeyStat(1540, j2, 1, false);
        }

        public static void cD(boolean z) {
            e.INSTANCE.idkeyStat(1540, z ? 2 : 3, 1, false);
        }

        public static void cE(boolean z) {
            e.INSTANCE.idkeyStat(1540, z ? 4 : 5, 1, false);
        }

        public static void SR() {
            e.INSTANCE.idkeyStat(1540, 7, 1, false);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public static class b {
        /* access modifiers changed from: private */
        public static void a(int i2, String str, String str2, int i3, int i4, String str3, long j2, String str4, long j3, String str5, long j4, String str6, String str7, long j5, long j6, long j7) {
            e.INSTANCE.a(21468, Integer.valueOf(i2), 4, str, str2, Integer.valueOf(i3), Integer.valueOf(i4), str3, Long.valueOf(j2), str4, Long.valueOf(j3), str5, Long.valueOf(j4), str6, str7, Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7));
        }

        static String eA(String str) {
            if (TextUtils.isDigitsOnly(str)) {
                return str;
            }
            if (str.contains("[GT]ColdPool#")) {
                return "[GT]ColdPool";
            }
            if (str.contains("[GT]HotPool#")) {
                return "[GT]HotPool";
            }
            if (str.contains("mars::")) {
                return "mars::xxx";
            }
            return str;
        }

        /* renamed from: com.tencent.matrix.report.a$b$b  reason: collision with other inner class name */
        public static final class C0228b {
            public static void c(int i2, int i3, String str) {
                if (com.tencent.matrix.c.a.SA()) {
                    String SN = a.SN();
                    String eu = c.eu("/proc/" + i2 + "/task/" + i3 + "/stat");
                    int SP = a.SP();
                    int SQ = a.SQ();
                    String SO = a.SO();
                    Log.i("Matrix.battery.BatteryReporter", "#statJiffiesTaskParseError");
                    b.a(0, SN, eu, SP, SQ, "statError", 1, "pid", (long) i2, "tid", (long) i3, SO, str, 0, 0, 0);
                }
            }

            public static void a(boolean z, g.a.AbstractC0209a<e.b> aVar) {
                e.b.a aVar2;
                if (com.tencent.matrix.c.a.SA()) {
                    String SN = a.SN();
                    StringBuilder sb = new StringBuilder();
                    int cA = a.cA(z);
                    int SQ = a.SQ();
                    String SO = a.SO();
                    long max = Math.max(1L, aVar.cTu / Util.MILLSECONDS_OF_MINUTE);
                    long longValue = ((Long) ((e.b) aVar.cTt).cTd.cTz).longValue() / max;
                    ArrayList arrayList = new ArrayList(3);
                    for (int i2 = 0; i2 < 3; i2++) {
                        String str = "";
                        long j2 = 0;
                        if (((e.b) aVar.cTt).cTe.list.size() > i2 && (aVar2 = (e.b.a) ((e.b) aVar.cTt).cTe.list.get(i2)) != null) {
                            str = aVar2.name;
                            j2 = ((Long) aVar2.cTz).longValue() / max;
                        }
                        arrayList.add(new k(str, Long.valueOf(j2)));
                    }
                    Log.i("Matrix.battery.BatteryReporter", "#statJiffies");
                    StringBuilder append = sb.append(b.eA(((k) arrayList.get(1)).first)).append(":").append((Object) ((k) arrayList.get(1)).second).append(b.eA(((k) arrayList.get(2)).first)).append(":").append((Object) ((k) arrayList.get(2)).second);
                    append.append("|batTemp=").append(c.ba(MMApplicationContext.getContext()));
                    int[] Sq = c.Sq();
                    if (Sq.length > 0) {
                        append.append("|cupFreq=").append(Arrays.toString(Sq));
                    }
                    b.a(0, SN, append.toString(), cA, SQ, "avgJiffies", longValue, b.eA(((k) arrayList.get(0)).first), ((k) arrayList.get(0)).second.longValue(), "duringMin", max, SO, "", 0, 0, 0);
                }
            }
        }

        /* renamed from: com.tencent.matrix.report.a$b$a  reason: collision with other inner class name */
        public static final class C0227a {
            public static void a(g.a.AbstractC0209a<e.b> aVar, long j2, long j3, String str, long j4) {
                e.b.a aVar2;
                String SN = a.SN();
                StringBuilder sb = new StringBuilder();
                int cA = a.cA(false);
                int SQ = a.SQ();
                long max = Math.max(1L, aVar.cTu / Util.MILLSECONDS_OF_MINUTE);
                long longValue = ((Long) ((e.b) aVar.cTt).cTd.cTz).longValue() / max;
                ArrayList arrayList = new ArrayList(3);
                for (int i2 = 0; i2 < 3; i2++) {
                    String str2 = "";
                    long j5 = 0;
                    if (((e.b) aVar.cTt).cTe.list.size() > i2 && (aVar2 = (e.b.a) ((e.b) aVar.cTt).cTe.list.get(i2)) != null) {
                        str2 = aVar2.name;
                        j5 = ((Long) aVar2.cTz).longValue() / max;
                    }
                    arrayList.add(new k(str2, Long.valueOf(j5)));
                }
                Log.i("Matrix.battery.BatteryReporter", "#reportJiffiesException");
                StringBuilder append = sb.append(b.eA(((k) arrayList.get(1)).first)).append(":").append((Object) ((k) arrayList.get(1)).second).append(b.eA(((k) arrayList.get(2)).first)).append(":").append((Object) ((k) arrayList.get(2)).second);
                append.append("|batTemp=").append(c.ba(MMApplicationContext.getContext()));
                int[] Sq = c.Sq();
                if (Sq.length > 0) {
                    append.append("|cupFreq=").append(Arrays.toString(Sq));
                }
                b.a(1, SN, append.toString(), cA, SQ, "avgJiffiesException", longValue, b.eA(((k) arrayList.get(0)).first), ((k) arrayList.get(0)).second.longValue(), "duringMin", max, str, "", j2, j3, j4);
            }
        }
    }
}
