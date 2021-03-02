package com.tencent.mm.plugin.appbrand.appusage;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import java.util.Arrays;
import java.util.Map;

public final class t {
    public static final c kVb = new c();

    public static final class c {
    }

    static /* synthetic */ void c(boolean z, long j2, long j3) {
        AppMethodBeat.i(44574);
        b(z, j2, j3);
        AppMethodBeat.o(44574);
    }

    static /* synthetic */ void d(boolean z, long j2) {
        AppMethodBeat.i(44573);
        c(z, j2);
        AppMethodBeat.o(44573);
    }

    public enum a {
        NONE(0),
        REDDOT(1),
        NEW(2);
        
        public final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(44550);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(44550);
            return aVar;
        }

        static {
            AppMethodBeat.i(44551);
            AppMethodBeat.o(44551);
        }

        private a(int i2) {
            this.value = i2;
        }
    }

    public static final class b implements cj.a {
        private static final b kVg = new b();

        static {
            AppMethodBeat.i(44557);
            AppMethodBeat.o(44557);
        }

        private b() {
        }

        public static void LW() {
            AppMethodBeat.i(44553);
            q.bxV();
            ((s) g.ah(s.class)).getSysCmdMsgExtension().a("wxareddot", (cj.a) kVg, true);
            AppMethodBeat.o(44553);
        }

        public static void unregister() {
            AppMethodBeat.i(44554);
            q.bxV();
            ((s) g.ah(s.class)).getSysCmdMsgExtension().b("wxareddot", kVg, true);
            AppMethodBeat.o(44554);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(44555);
            final String a2 = z.a(aVar.heO.KHn);
            if (Util.isNullOrNil(a2)) {
                AppMethodBeat.o(44555);
                return;
            }
            f.bZn().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.appusage.t.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(44552);
                    b.Wv(a2);
                    AppMethodBeat.o(44552);
                }
            });
            AppMethodBeat.o(44555);
        }

        static /* synthetic */ void Wv(String str) {
            AppMethodBeat.i(44556);
            boolean aAc = g.aAc();
            Log.i("MicroMsg.AppBrandPushNewOrRedDotLogic", "parseThenProcess, accReady %b, received xml %s", Boolean.valueOf(aAc), str);
            if (aAc) {
                Map<String, String> parseXml = XmlParser.parseXml(str, "sysmsg", null);
                if (parseXml != null && parseXml.size() > 0) {
                    String str2 = parseXml.get(".sysmsg.wxareddot.id");
                    int i2 = Util.getInt(parseXml.get(".sysmsg.wxareddot.activitytype"), 0);
                    if (!Util.isNullOrNil(str2) && (i2 == 1 || i2 == 2)) {
                        int i3 = Util.getInt(parseXml.get(".sysmsg.wxareddot.close"), 0);
                        long j2 = Util.getLong(parseXml.get(".sysmsg.wxareddot.pushtime"), 0);
                        long j3 = Util.getLong(parseXml.get(".sysmsg.wxareddot.duration"), 0);
                        long j4 = Util.getLong(parseXml.get(".sysmsg.wxareddot.frequency"), 0);
                        parseXml.get(".sysmsg.wxareddot.tips");
                        int i4 = Util.getInt(parseXml.get(".sysmsg.wxareddot.showType"), 0);
                        int i5 = Util.getInt(parseXml.get(".sysmsg.wxareddot.reason"), 0);
                        switch (i2) {
                            case 1:
                                if (!str2.equals((String) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, (Object) null)) && !i.bxM() && !Util.getTopActivityName(MMApplicationContext.getContext()).equals(AppBrandLauncherUI.class.getName()) && q.bxX() != q.a.FORCE_OFF) {
                                    g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, str2);
                                    g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(j2));
                                    g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_SHOWTYPE_INT, Integer.valueOf(i4));
                                    g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_REASON_INT, Integer.valueOf(i5));
                                    if (i3 == 1 && t.byd()) {
                                        e eVar = e.kVn;
                                        e.a((String) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, ""), ((Long) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, (Object) 0L)).longValue(), 4, e.byj());
                                    }
                                    t.d(i3 != 1, j3);
                                    AppMethodBeat.o(44556);
                                    return;
                                }
                            case 2:
                                if (!str2.equals((String) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_MSG_ID_STRING, (Object) null))) {
                                    t.c(i3 != 1, j3, j4);
                                    break;
                                }
                                break;
                        }
                    } else {
                        AppMethodBeat.o(44556);
                        return;
                    }
                } else {
                    AppMethodBeat.o(44556);
                    return;
                }
            }
            AppMethodBeat.o(44556);
        }
    }

    private static void c(boolean z, long j2) {
        long nowSecond;
        AppMethodBeat.i(44566);
        if (!z) {
            g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_END_TIME_SECOND_LONG, (Object) 0L);
            AppMethodBeat.o(44566);
            return;
        }
        if (j2 == 0) {
            nowSecond = MAlarmHandler.NEXT_FIRE_INTERVAL;
        } else {
            nowSecond = Util.nowSecond() + Math.max(0L, j2);
        }
        g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_END_TIME_SECOND_LONG, Long.valueOf(nowSecond));
        g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_ENTRANCE_SHOW_RED_DOT_ONCE_BOOLEAN, Boolean.TRUE);
        g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_HAS_REPORTED_SEE_RED_DOT_BOOLEAN, Boolean.FALSE);
        e eVar = e.kVn;
        e.a((String) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, ""), ((Long) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, (Object) 0L)).longValue(), 1, e.byj());
        AppMethodBeat.o(44566);
    }

    private static void b(boolean z, long j2, long j3) {
        long j4 = 0;
        AppMethodBeat.i(44567);
        ao azQ = g.aAh().azQ();
        ar.a aVar = ar.a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_END_TIME_SECOND_LONG;
        if (z) {
            j4 = Math.max(0L, j2) + Util.nowSecond();
        }
        azQ.set(aVar, Long.valueOf(j4));
        ao azQ2 = g.aAh().azQ();
        ar.a aVar2 = ar.a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_FREQUENCY_SECOND_LONG;
        if (!z) {
            j3 = MAlarmHandler.NEXT_FIRE_INTERVAL;
        }
        azQ2.set(aVar2, Long.valueOf(j3));
        AppMethodBeat.o(44567);
    }

    public static boolean byb() {
        AppMethodBeat.i(44568);
        q.bxV();
        if (!g.aAc()) {
            AppMethodBeat.o(44568);
            return false;
        }
        boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_SHOW_RED_DOT_ONCE_BOOLEAN, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(44568);
        return booleanValue;
    }

    static a byc() {
        AppMethodBeat.i(44569);
        if (!byd()) {
            a aVar = a.NONE;
            AppMethodBeat.o(44569);
            return aVar;
        }
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_SHOWTYPE_INT, (Object) 0)).intValue();
        a[] values = a.values();
        for (a aVar2 : values) {
            if (aVar2.value == intValue) {
                AppMethodBeat.o(44569);
                return aVar2;
            }
        }
        a aVar3 = a.NONE;
        AppMethodBeat.o(44569);
        return aVar3;
    }

    public static boolean byd() {
        AppMethodBeat.i(44570);
        if (!g.aAc()) {
            AppMethodBeat.o(44570);
            return false;
        }
        long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_END_TIME_SECOND_LONG, (Object) 0L)).longValue();
        boolean z = longValue > Util.nowSecond();
        if (!z && longValue > 0) {
            g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_END_TIME_SECOND_LONG, (Object) 0L);
            e eVar = e.kVn;
            e.byh();
        }
        AppMethodBeat.o(44570);
        return z;
    }

    static void bye() {
        AppMethodBeat.i(44571);
        q.bxV();
        if (!g.aAc()) {
            AppMethodBeat.o(44571);
            return;
        }
        e eVar = e.kVn;
        if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_HAS_REPORTED_SEE_RED_DOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            e.a((String) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, ""), ((Long) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, (Object) 0L)).longValue(), 0, e.byj());
            g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_HAS_REPORTED_SEE_RED_DOT_BOOLEAN, Boolean.TRUE);
        }
        AppMethodBeat.o(44571);
    }

    public static void byf() {
        AppMethodBeat.i(44572);
        if (!g.aAc()) {
            AppMethodBeat.o(44572);
            return;
        }
        if (byd()) {
            c(false, 0);
            b(false, 0, 0);
            e eVar = e.kVn;
            e.a((String) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, ""), ((Long) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, (Object) 0L)).longValue(), 2, e.byj());
        }
        AppMethodBeat.o(44572);
    }

    public static final class e {
        public static final e kVn = new e();

        static {
            AppMethodBeat.i(44565);
            AppMethodBeat.o(44565);
        }

        static void byh() {
            AppMethodBeat.i(44561);
            a((String) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, ""), ((Long) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, (Object) 0L)).longValue(), 3, byj());
            AppMethodBeat.o(44561);
        }

        public static void byi() {
            AppMethodBeat.i(44562);
            a("", 0, 1, 1);
            AppMethodBeat.o(44562);
        }

        static int byj() {
            AppMethodBeat.i(44563);
            if (g.aAh().azQ().getBoolean(ar.a.USERINFO_APP_BRAND_ENTRANCE_SHOW_NEW_BOOLEAN, false)) {
                AppMethodBeat.o(44563);
                return 1;
            }
            int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_REASON_INT, (Object) 0)).intValue();
            if (intValue > 0) {
                intValue++;
            }
            AppMethodBeat.o(44563);
            return intValue;
        }

        static void a(String str, long j2, int i2, int i3) {
            AppMethodBeat.i(44564);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14112, 1, Util.nullAsNil(str), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(44564);
        }
    }

    public static final class d {
        public final String[] kVm = new String[9];

        public d() {
            AppMethodBeat.i(44560);
            Arrays.fill(this.kVm, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.kVm[0] = (String) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, "");
            this.kVm[1] = String.valueOf(g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, (Object) 0L));
            this.kVm[2] = String.valueOf(Util.nowSecond());
            AppMethodBeat.o(44560);
        }

        public final void byg() {
            this.kVm[8] = "1";
        }
    }

    static {
        AppMethodBeat.i(44575);
        AppMethodBeat.o(44575);
    }
}
