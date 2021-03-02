package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.us;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.protocal.protobuf.eoa;
import com.tencent.mm.protocal.protobuf.eob;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;

public enum i {
    ;
    
    public static final IListener<us> kUr = new IListener<us>() {
        /* class com.tencent.mm.plugin.appbrand.appusage.i.AnonymousClass1 */

        {
            AppMethodBeat.i(160591);
            this.__eventId = us.class.getName().hashCode();
            AppMethodBeat.o(160591);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(us usVar) {
            AppMethodBeat.i(44464);
            us usVar2 = usVar;
            usVar2.eaV.eaX = i.bxK();
            if (usVar2.eaU.eaW) {
                us.b bVar = usVar2.eaV;
                usVar2.eaV.eaY = false;
                bVar.eaZ = false;
                if (!i.bxM()) {
                    switch (AnonymousClass2.kUt[t.byc().ordinal()]) {
                        case 1:
                            usVar2.eaV.eaZ = true;
                            break;
                        case 2:
                            usVar2.eaV.eaY = true;
                            break;
                    }
                } else {
                    usVar2.eaV.eaZ = true;
                }
                if (usVar2.eaV.eaY || usVar2.eaV.eaZ) {
                    t.bye();
                }
                t.c cVar = t.kVb;
                q.bxV();
                if (g.aAc() && aa.aZx()) {
                    long nowSecond = Util.nowSecond();
                    long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_END_TIME_SECOND_LONG, (Object) 0L)).longValue();
                    long longValue2 = ((Long) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_FREQUENCY_SECOND_LONG, Long.valueOf((long) MAlarmHandler.NEXT_FIRE_INTERVAL))).longValue() + ((Long) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_LAST_TIME_SECOND_LONG, (Object) 0L)).longValue();
                    if (longValue2 > 0 && nowSecond < longValue && nowSecond >= longValue2) {
                        Log.d("MicroMsg.AppBrandPushNewOrRedDotLogic", "doReport");
                        d.bca().b((b.a) f.cP(new b.a() {
                            /* class com.tencent.mm.plugin.appbrand.appusage.t.c.AnonymousClass1 */
                            int count = 0;

                            @Override // com.tencent.mm.modelgeo.b.a
                            public final boolean a(boolean z, final float f2, final float f3, int i2, double d2, final double d3) {
                                AppMethodBeat.i(44559);
                                f.bs(this);
                                com.tencent.mm.modelgeo.d.bca().c(this);
                                int i3 = this.count;
                                this.count = i3 + 1;
                                if (i3 <= 0 && z) {
                                    d.a aVar = new d.a();
                                    aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/uploaduserlocationinfo";
                                    aVar.funcId = 1154;
                                    aVar.iLO = new eob();
                                    eoa eoa = new eoa();
                                    eoa.latitude = (double) f3;
                                    eoa.longitude = (double) f2;
                                    eoa.NlN = d3;
                                    aVar.iLN = eoa;
                                    aa.a(aVar.aXF(), new aa.a() {
                                        /* class com.tencent.mm.plugin.appbrand.appusage.t.c.AnonymousClass1.AnonymousClass1 */

                                        @Override // com.tencent.mm.ak.aa.a
                                        public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
                                            AppMethodBeat.i(44558);
                                            Log.d("MicroMsg.AppBrandPushNewOrRedDotLogic", "locationReport, errType %d, errCode %d, errMsg %s, longitude %f, latitude %f, accuracy %f", Integer.valueOf(i2), Integer.valueOf(i3), str, Float.valueOf(f2), Float.valueOf(f3), Double.valueOf(d3));
                                            AppMethodBeat.o(44558);
                                            return 0;
                                        }
                                    }, true);
                                }
                                AppMethodBeat.o(44559);
                                return true;
                            }
                        }), true);
                        g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_LAST_TIME_SECOND_LONG, Long.valueOf(nowSecond));
                    }
                }
            }
            AppMethodBeat.o(44464);
            return true;
        }
    };

    static {
        AppMethodBeat.i(44477);
        AppMethodBeat.o(44477);
    }

    public static i valueOf(String str) {
        AppMethodBeat.i(44467);
        i iVar = (i) Enum.valueOf(i.class, str);
        AppMethodBeat.o(44467);
        return iVar;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.i$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] kUt = new int[t.a.values().length];

        static {
            AppMethodBeat.i(44465);
            try {
                kUt[t.a.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                kUt[t.a.REDDOT.ordinal()] = 2;
                AppMethodBeat.o(44465);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.o(44465);
            }
        }
    }

    public static boolean bxK() {
        AppMethodBeat.i(44468);
        if (!g.aAc()) {
            AppMethodBeat.o(44468);
            return false;
        } else if (h.aqJ().getInt("WeAppForbiddenSwitch", 0) == 1) {
            Log.i("MicroMsg.AppBrandEntranceLogic", "showInFindMore, WeAppForbiddenSwitch == 1, not show");
            AppMethodBeat.o(44468);
            return false;
        } else if (bxP() || t.byb()) {
            AppMethodBeat.o(44468);
            return true;
        } else {
            AppMethodBeat.o(44468);
            return false;
        }
    }

    public static void bxL() {
        AppMethodBeat.i(44469);
        if (!g.aAc()) {
            AppMethodBeat.o(44469);
            return;
        }
        if (bxM()) {
            t.e eVar = t.e.kVn;
            t.e.a("", 0, 2, 1);
        }
        g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_ENTRANCE_SHOW_NEW_BOOLEAN, Boolean.FALSE);
        AppMethodBeat.o(44469);
    }

    static boolean bxM() {
        AppMethodBeat.i(44470);
        if (!g.aAc()) {
            AppMethodBeat.o(44470);
            return false;
        }
        boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_ENTRANCE_SHOW_NEW_BOOLEAN, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(44470);
        return booleanValue;
    }

    static void dO(int i2, int i3) {
        boolean z = true;
        AppMethodBeat.i(226382);
        if (!g.aAc()) {
            AppMethodBeat.o(226382);
            return;
        }
        ao azQ = g.aAh().azQ();
        b((i2 & 2) > 0, i3 != 4, "");
        ar.a aVar = ar.a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_FAVORITE_BOOLEAN;
        if ((i2 & 1) <= 0) {
            z = false;
        }
        azQ.set(aVar, Boolean.valueOf(z));
        AppMethodBeat.o(226382);
    }

    static void b(boolean z, boolean z2, String str) {
        boolean z3;
        AppBrandGuideUI.a buB;
        AppMethodBeat.i(226383);
        if (!g.aAc()) {
            AppMethodBeat.o(226383);
            return;
        }
        Boolean bool = (Boolean) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_HISTORY_BOOLEAN, (Object) null);
        if (bool == null || bool.booleanValue() || !z) {
            z3 = false;
        } else {
            g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_ENTRANCE_SHOW_NEW_BOOLEAN, Boolean.TRUE);
            t.e eVar = t.e.kVn;
            t.e.byi();
            z3 = true;
        }
        g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_HISTORY_BOOLEAN, Boolean.valueOf(z));
        if (!z2) {
            AppMethodBeat.o(226383);
            return;
        }
        if (z3 && (buB = n.buB()) != null) {
            buB.afr(str);
        }
        AppMethodBeat.o(226383);
    }

    public static boolean bxN() {
        AppMethodBeat.i(44474);
        if (!g.aAc()) {
            AppMethodBeat.o(44474);
            return false;
        }
        boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_HISTORY_BOOLEAN, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(44474);
        return booleanValue;
    }

    public static boolean bxO() {
        AppMethodBeat.i(44475);
        v.bym();
        if (!g.aAc()) {
            AppMethodBeat.o(44475);
            return false;
        }
        boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_FAVORITE_BOOLEAN, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(44475);
        return booleanValue;
    }

    public static boolean bxP() {
        AppMethodBeat.i(44476);
        if (bxO() || bxN()) {
            AppMethodBeat.o(44476);
            return true;
        }
        AppMethodBeat.o(44476);
        return false;
    }
}
