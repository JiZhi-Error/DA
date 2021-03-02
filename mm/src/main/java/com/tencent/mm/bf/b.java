package com.tencent.mm.bf;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Base64;
import com.tencent.map.geolocation.sapp.TencentLocationUtils;
import com.tencent.map.swlocation.api.LocationUpdateListener;
import com.tencent.map.swlocation.api.ServerMessageListener;
import com.tencent.map.swlocation.api.SwEngine;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.i;
import com.tencent.mm.b.p;
import com.tencent.mm.bb.n;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.d;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.h;
import com.tencent.mm.platformtools.ad;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ar;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b {
    private static final byte[] jim = "@wechat*weixin!!".getBytes();
    private static b jin;
    private int jiA;
    private ServerMessageListener jiB;
    private boolean jio = false;
    private HandlerThread jip;
    int jiq = 5000;
    int jir = 5000;
    int jis = CommonUtils.MAX_TIMEOUT_MS;
    private int jit = LocalCache.TIME_HOUR;
    private c jiu;
    private List<d> jiv = new ArrayList();
    private List<d> jiw = new ArrayList();
    private IListener jix = new IListener<d>() {
        /* class com.tencent.mm.bf.b.AnonymousClass3 */

        {
            AppMethodBeat.i(161783);
            this.__eventId = d.class.getName().hashCode();
            AppMethodBeat.o(161783);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(d dVar) {
            AppMethodBeat.i(150879);
            if (!dVar.dBP.dBQ) {
                int max = Math.max(b.this.jir, b.this.jiq);
                Log.i("MicroMsg.SenseWhereHelper", "it is [deactivated mode], stop sense where sdk after %d", Integer.valueOf(max));
                b.beI();
                b.a(b.this, max);
            }
            AppMethodBeat.o(150879);
            return false;
        }
    };
    private MTimerHandler jiy;
    private LocationUpdateListener jiz;
    private long startTime = 0;

    static /* synthetic */ boolean b(b bVar) {
        AppMethodBeat.i(150890);
        boolean beE = bVar.beE();
        AppMethodBeat.o(150890);
        return beE;
    }

    static /* synthetic */ String beG() {
        AppMethodBeat.i(150893);
        String beC = beC();
        AppMethodBeat.o(150893);
        return beC;
    }

    static {
        AppMethodBeat.i(150903);
        AppMethodBeat.o(150903);
    }

    public static b beB() {
        AppMethodBeat.i(150883);
        if (jin == null) {
            jin = new b();
        }
        b bVar = jin;
        AppMethodBeat.o(150883);
        return bVar;
    }

    public b() {
        AppMethodBeat.i(150884);
        g.aAi();
        this.jiy = new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.bf.b.AnonymousClass4 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(150880);
                Log.i("MicroMsg.SenseWhereHelper", "time up, stop sense where sdk.");
                b.beJ();
                b.this.beD();
                AppMethodBeat.o(150880);
                return false;
            }
        }, false);
        this.jiz = new LocationUpdateListener() {
            /* class com.tencent.mm.bf.b.AnonymousClass5 */

            @Override // com.tencent.map.swlocation.api.LocationUpdateListener, com.b.a.a.t.b
            public final void onLocationUpdate(double d2, double d3, int i2, int i3, long j2) {
                AppMethodBeat.i(150881);
                Log.d("MicroMsg.SenseWhereHelper", "onLocationUpdate latitude[%f] longitude[%f] error[%d] floor[%d] buildingId[%d]", Double.valueOf(d2), Double.valueOf(d3), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2));
                AppMethodBeat.o(150881);
            }
        };
        this.jiA = 0;
        this.jiB = new ServerMessageListener() {
            /* class com.tencent.mm.bf.b.AnonymousClass6 */

            @Override // com.b.a.a.t.d, com.tencent.map.swlocation.api.ServerMessageListener
            public final void onMessage(int i2, String str) {
                AppMethodBeat.i(150882);
                Log.d("MicroMsg.SenseWhereHelper", "onMessage code[%d] message[%s]", Integer.valueOf(i2), str);
                if (i2 != 0 && b.o(b.this) > 3) {
                    Log.i("MicroMsg.SenseWhereHelper", "sense where error time more than %d, stop now.", 3);
                    b.beK();
                    b.this.beD();
                }
                AppMethodBeat.o(150882);
            }
        };
        AppMethodBeat.o(150884);
    }

    private static String beC() {
        AppMethodBeat.i(150885);
        String dr = q.dr(true);
        g.aAf();
        String str = dr + "_" + new p(a.getUin()).toString();
        try {
            ad adVar = new ad();
            byte[] bytes = str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            String str2 = new String(Base64.encode(adVar.a(bytes, bytes.length, jim), 0), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            Log.i("MicroMsg.SenseWhereHelper", "create encrypt imei[%s], original imei[%s]", str2, Util.secPrint(str));
            AppMethodBeat.o(150885);
            return str2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SenseWhereHelper", e2, "", new Object[0]);
            Log.e("MicroMsg.SenseWhereHelper", "create imei error: " + e2.toString());
            AppMethodBeat.o(150885);
            return "";
        }
    }

    public final void a(final float f2, final float f3, final int i2, final String str, final String str2, final int i3, final int i4) {
        AppMethodBeat.i(150886);
        if (g.aAf().azp()) {
            g.aAf();
            if (!a.azj()) {
                g.aAi();
                g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.bf.b.AnonymousClass1 */
                    final /* synthetic */ int jiG = 0;

                    public final void run() {
                        AppMethodBeat.i(150877);
                        if (b.this.jio) {
                            Log.d("MicroMsg.SenseWhereHelper", "it is collection now, do not start sense where sdk.");
                            AppMethodBeat.o(150877);
                        } else if (!b.b(b.this)) {
                            Log.d("MicroMsg.SenseWhereHelper", "it do not start sense where sdk by config.");
                            AppMethodBeat.o(150877);
                        } else {
                            b.beF();
                            if (b.this.jiw.size() == 0 && b.this.jiv.size() == 0) {
                                b.e(b.this);
                            }
                            if (!b.a(b.this, i3, f2, f3)) {
                                AppMethodBeat.o(150877);
                                return;
                            }
                            Log.i("MicroMsg.SenseWhereHelper", "it begin to start sense where sdk to upload location info.[%d, %f, %f, %d]", Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i4));
                            b.this.jio = true;
                            g.aAh().azQ().set(ar.a.USERINFO_LAST_START_SENSE_WHERE_LONG, Long.valueOf(Util.nowSecond()));
                            EventCenter.instance.addListener(b.this.jix);
                            if (b.this.jiu != null) {
                                b.this.jiu.finish();
                            }
                            b.this.jiA = 0;
                            b.this.startTime = Util.currentTicks();
                            b.this.jiu = new c(f2, f3, i2, this.jiG, str, str2, i3, i4);
                            SwEngine.setImei(b.beG());
                            SwEngine.creatLocationEngine(MMApplicationContext.getContext(), b.this.jiu);
                            SwEngine.startContinousLocationUpdate(b.i(b.this), b.this.jiq, b.this.jir, b.this.jiz, b.this.jiB);
                            b.beH();
                            b.a(b.this, b.this.jis);
                            AppMethodBeat.o(150877);
                        }
                    }
                });
                AppMethodBeat.o(150886);
                return;
            }
        }
        AppMethodBeat.o(150886);
    }

    public final void beD() {
        AppMethodBeat.i(150887);
        g.aAi();
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.bf.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(150878);
                Log.i("MicroMsg.SenseWhereHelper", "it stop sense where sdk.");
                EventCenter.instance.removeListener(b.this.jix);
                SwEngine.stopContinousLocationUpdate();
                SwEngine.onDestroy();
                if (b.this.jiu != null) {
                    b.this.jiu.finish();
                    b.this.jiu = null;
                }
                b.l(b.this);
                b.m(b.this);
                b.n(b.this);
                b.this.jio = false;
                AppMethodBeat.o(150878);
            }
        });
        AppMethodBeat.o(150887);
    }

    private boolean beE() {
        AppMethodBeat.i(150888);
        g.aAf();
        if (new p(a.getUin()).longValue() < TimeUtil.SECOND_TO_US) {
            Log.i("MicroMsg.SenseWhereHelper", "it boss uin do not start sense where.");
            AppMethodBeat.o(150888);
            return false;
        }
        String value = h.aqJ().getValue("AndroidSenseWhereArgs");
        if (Util.isNullOrNil(value)) {
            Log.i("MicroMsg.SenseWhereHelper", "it has no config do not start sense where.");
            AppMethodBeat.o(150888);
            return false;
        }
        try {
            Log.d("MicroMsg.SenseWhereHelper", "sense where config : ".concat(String.valueOf(value)));
            String[] split = value.split(";");
            int i2 = Util.getInt(split[0], 0);
            g.aAf();
            int ch = i.ch(a.getUin() + 5, 100);
            if (ch > i2) {
                Log.d("MicroMsg.SenseWhereHelper", "do not start sense where.uinhash %d, percent %d", Integer.valueOf(ch), Integer.valueOf(i2));
                AppMethodBeat.o(150888);
                return false;
            }
            this.jir = Util.getInt(split[1], 5000);
            this.jiq = Util.getInt(split[2], 5000);
            this.jis = Util.getInt(split[3], CommonUtils.MAX_TIMEOUT_MS);
            this.jit = Util.getInt(split[4], LocalCache.TIME_HOUR);
            Log.i("MicroMsg.SenseWhereHelper", "check sense where report args[%d, %d, %d, %d]", Integer.valueOf(this.jir), Integer.valueOf(this.jiq), Integer.valueOf(this.jis), Integer.valueOf(this.jit));
            long secondsToNow = Util.secondsToNow(((Long) g.aAh().azQ().get(ar.a.USERINFO_LAST_START_SENSE_WHERE_LONG, (Object) 0L)).longValue());
            if (secondsToNow > ((long) this.jit)) {
                AppMethodBeat.o(150888);
                return true;
            }
            Log.i("MicroMsg.SenseWhereHelper", "it is not time out. diff[%d], collection interval[%d]", Long.valueOf(secondsToNow), Integer.valueOf(this.jit));
            AppMethodBeat.o(150888);
            return false;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SenseWhereHelper", e2, "", new Object[0]);
            Log.e("MicroMsg.SenseWhereHelper", "check sense where config error: " + e2.toString());
            Log.i("MicroMsg.SenseWhereHelper", "it default do not start sense where.");
            AppMethodBeat.o(150888);
            return false;
        }
    }

    public static void beF() {
        AppMethodBeat.i(150889);
        if (Util.secondsToNow(Util.nullAs((Long) g.aAh().azQ().get(ar.a.USERINFO_LAST_GET_SENSE_WHERE_LOCATION_LONG, (Object) null), 0)) * 1000 > 21600000) {
            Log.i("MicroMsg.SenseWhereHelper", "update sense where location package list.");
            g.aAg().hqi.a(new n(36), 0);
            g.aAh().azQ().set(ar.a.USERINFO_LAST_GET_SENSE_WHERE_LOCATION_LONG, Long.valueOf(Util.nowSecond()));
        }
        AppMethodBeat.o(150889);
    }

    static /* synthetic */ void e(b bVar) {
        AppMethodBeat.i(150891);
        bVar.jiv.clear();
        bVar.jiw.clear();
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_SENSE_WHERE_LOCATION_STRING, "");
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.SenseWhereHelper", "sense where location xml is null.");
            AppMethodBeat.o(150891);
            return;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "SenseWhere", null);
        if (parseXml == null) {
            Log.w("MicroMsg.SenseWhereHelper", "parseLocation maps is null, xml[%s]", str);
            AppMethodBeat.o(150891);
            return;
        }
        int i2 = 0;
        while (true) {
            String str2 = ".SenseWhere.item" + (i2 == 0 ? "" : Integer.valueOf(i2));
            String str3 = parseXml.get(str2 + ".$gpstype");
            if (!Util.isNullOrNil(str3)) {
                d dVar = new d();
                dVar.jiO = str3;
                dVar.longitude = Util.getDouble(parseXml.get(str2 + ".$longitude"), 0.0d);
                dVar.latitude = Util.getDouble(parseXml.get(str2 + ".$latitude"), 0.0d);
                dVar.jiP = Util.getDouble(parseXml.get(str2 + ".$distance"), 0.0d);
                if (dVar.jiP > 5500000.0d) {
                    dVar.jiP = 5500000.0d;
                }
                if ("1".equals(dVar.jiO)) {
                    bVar.jiv.add(dVar);
                } else {
                    bVar.jiw.add(dVar);
                }
                i2++;
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(345, 6, 1, false);
                Log.i("MicroMsg.SenseWhereHelper", "parse location finish earth[%d] mars[%d]", Integer.valueOf(bVar.jiw.size()), Integer.valueOf(bVar.jiv.size()));
                AppMethodBeat.o(150891);
                return;
            }
        }
    }

    static /* synthetic */ boolean a(b bVar, int i2, float f2, float f3) {
        List<d> list;
        boolean z;
        AppMethodBeat.i(150892);
        if (i2 == 1) {
            list = bVar.jiv;
        } else {
            list = bVar.jiw;
        }
        if (list == null || list.size() <= 0) {
            Log.i("MicroMsg.SenseWhereHelper", "it has not report location, do not start sense where.");
            AppMethodBeat.o(150892);
            return false;
        }
        long currentTicks = Util.currentTicks();
        Iterator<d> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            d next = it.next();
            double distanceBetween = TencentLocationUtils.distanceBetween(next.latitude, next.longitude, (double) f3, (double) f2);
            Log.d("MicroMsg.SenseWhereHelper", "loc[%f, %f], config[%f, %f], dis[%f, %f]", Float.valueOf(f3), Float.valueOf(f2), Double.valueOf(next.latitude), Double.valueOf(next.longitude), Double.valueOf(distanceBetween), Double.valueOf(next.jiP));
            if (distanceBetween <= next.jiP) {
                z = true;
                break;
            }
        }
        Log.i("MicroMsg.SenseWhereHelper", "check location[%d, %f, %f] finish %b, cost time %d", Integer.valueOf(i2), Float.valueOf(f3), Float.valueOf(f2), Boolean.valueOf(z), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(150892);
        return z;
    }

    static /* synthetic */ Handler i(b bVar) {
        AppMethodBeat.i(150894);
        bVar.jip = com.tencent.f.c.d.bqq("sensewhere");
        bVar.jip.start();
        Handler handler = new Handler(bVar.jip.getLooper());
        AppMethodBeat.o(150894);
        return handler;
    }

    static /* synthetic */ void beH() {
        AppMethodBeat.i(150895);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(345, 1, 1, false);
        AppMethodBeat.o(150895);
    }

    static /* synthetic */ void a(b bVar, int i2) {
        AppMethodBeat.i(150896);
        bVar.jiy.startTimer((long) i2);
        AppMethodBeat.o(150896);
    }

    static /* synthetic */ void l(b bVar) {
        AppMethodBeat.i(150897);
        if (bVar.jip != null) {
            bVar.jip.quit();
        }
        bVar.jip = null;
        AppMethodBeat.o(150897);
    }

    static /* synthetic */ void m(b bVar) {
        AppMethodBeat.i(150898);
        bVar.jiy.stopTimer();
        AppMethodBeat.o(150898);
    }

    static /* synthetic */ void n(b bVar) {
        AppMethodBeat.i(150899);
        if (bVar.startTime > 0) {
            long currentTicks = (Util.currentTicks() - bVar.startTime) / 1000;
            int nullAsNil = Util.nullAsNil((Integer) com.tencent.mm.plugin.report.service.h.a((int) currentTicks, new int[]{5, 10, 20, 30}, 10, 14));
            Log.d("MicroMsg.SenseWhereHelper", "reportCollectionTime time %d, res %d", Long.valueOf(currentTicks), Integer.valueOf(nullAsNil));
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(345, (long) nullAsNil, 1, false);
        }
        AppMethodBeat.o(150899);
    }

    static /* synthetic */ void beI() {
        AppMethodBeat.i(150900);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(345, 5, 1, false);
        AppMethodBeat.o(150900);
    }

    static /* synthetic */ void beJ() {
        AppMethodBeat.i(150901);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(345, 2, 1, false);
        AppMethodBeat.o(150901);
    }

    static /* synthetic */ int o(b bVar) {
        int i2 = bVar.jiA + 1;
        bVar.jiA = i2;
        return i2;
    }

    static /* synthetic */ void beK() {
        AppMethodBeat.i(150902);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(345, 3, 1, false);
        AppMethodBeat.o(150902);
    }
}
