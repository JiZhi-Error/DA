package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.os.Build;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.eg;
import com.tencent.mm.g.a.eh;
import com.tencent.mm.g.a.ei;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelmulti.d;
import com.tencent.mm.n.h;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.ccr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class l {
    private static b.a gmA = new b.a() {
        /* class com.tencent.mm.booter.l.AnonymousClass1 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(19891);
            if (z) {
                Log.d("MicroMsg.PostTaskStartRangeForIBeacon", "on location get ok");
                float unused = l.gmu = f3;
                float unused2 = l.gmv = f2;
                boolean unused3 = l.gmw = true;
                if (l.gmt != null) {
                    l.gmt.c(l.gmA);
                    boolean unused4 = l.gmw = false;
                }
            } else {
                Log.w("MicroMsg.PostTaskStartRangeForIBeacon", "getLocation fail");
            }
            AppMethodBeat.o(19891);
            return false;
        }
    };
    private static MTimerHandler gmB = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.booter.l.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(19893);
            try {
                bg.aVF();
                Boolean valueOf = Boolean.valueOf(Util.nullAs((Boolean) c.azQ().get(ar.a.USERINFO_IBEACON_PUSH_IS_IN_SHAKEUI_BOOLEAN, (Object) null), false));
                List<String> aqA = h.aqK().aqA();
                if (aqA != null) {
                    for (String str : aqA) {
                        Log.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=false,isInShakeUI:" + valueOf + ",iBeacon = %s", str);
                        eh ehVar = new eh();
                        ehVar.dHC.dHE = str;
                        ehVar.dHC.dHB = false;
                        if (!valueOf.booleanValue()) {
                            EventCenter.instance.publish(ehVar);
                        }
                    }
                    cco cco = new cco();
                    cco.latitude = (double) l.gmu;
                    cco.longitude = (double) l.gmv;
                    bg.aVF();
                    long nullAs = Util.nullAs((Long) c.azQ().get(ar.a.USERINFO_IBEACON_PUSH_SHOP_ID_LONG, (Object) null), 0);
                    if (l.gmx.size() <= 0 || l.gmz.booleanValue() || l.gmy.size() <= 0) {
                        bg.aVF();
                        c.azQ().set(ar.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, "");
                    } else {
                        Boolean unused = l.gmz = Boolean.TRUE;
                        final d dVar = new d(l.gmy, nullAs, cco);
                        Log.d("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]PostTaskStartRangeForIBeacon[kevinkma] shopId " + nullAs + ",beaconInfos size " + l.gmy.size() + ",info:" + l.gmy.toString());
                        bg.azz().a(1708, new i() {
                            /* class com.tencent.mm.booter.l.AnonymousClass2.AnonymousClass1 */

                            @Override // com.tencent.mm.ak.i
                            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                                AppMethodBeat.i(19892);
                                if (i2 == 0 && i3 == 0) {
                                    bjg bjg = (bjg) dVar.iUB.iLL.iLR;
                                    if (bjg.result == 0) {
                                        ccr ccr = bjg.LSV;
                                        ccm ccm = bjg.LSX;
                                        String str2 = ccr.title + "," + ccr.desc + "," + ccr.Mix + "," + ccr.Miy + "," + ccm.uuid + "," + ccm.major + "," + ccm.minor;
                                        bg.aVF();
                                        String[] split = Util.nullAs((String) c.azQ().get(ar.a.USERINFO_IBEACON_PUSH_LAST_BEACONINFO_STRING, (Object) null), "").split(",");
                                        Boolean bool = Boolean.FALSE;
                                        int length = split.length;
                                        for (int i4 = 0; i4 < length; i4++) {
                                            if (split[i4].equals(ccm.uuid + ccm.major + ccm.minor)) {
                                                bool = Boolean.TRUE;
                                            }
                                        }
                                        if (!bool.booleanValue()) {
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12653, 1, 1);
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12653, 2, 1);
                                            bg.aVF();
                                            c.azQ().set(ar.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, str2);
                                        } else {
                                            bg.aVF();
                                            c.azQ().set(ar.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, "");
                                        }
                                    } else {
                                        bg.aVF();
                                        c.azQ().set(ar.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, "");
                                    }
                                } else {
                                    bg.aVF();
                                    c.azQ().set(ar.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, "");
                                }
                                bg.aVF();
                                c.azl();
                                EventCenter.instance.publish(new eg());
                                Boolean unused = l.gmz = Boolean.FALSE;
                                bg.azz().b(1708, this);
                                AppMethodBeat.o(19892);
                            }
                        });
                        bg.azz().a(dVar, 0);
                    }
                    l.gmx.clear();
                    l.gmy.clear();
                    EventCenter.instance.removeListener(l.gmC);
                }
                AppMethodBeat.o(19893);
            } catch (Exception e2) {
                Log.e("MicroMsg.PostTaskStartRangeForIBeacon", e2.getMessage());
                AppMethodBeat.o(19893);
            }
            return false;
        }
    }, true);
    private static IListener gmC = new IListener<ei>() {
        /* class com.tencent.mm.booter.l.AnonymousClass3 */

        {
            AppMethodBeat.i(161269);
            this.__eventId = ei.class.getName().hashCode();
            AppMethodBeat.o(161269);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ei eiVar) {
            AppMethodBeat.i(19894);
            ei eiVar2 = eiVar;
            if (eiVar2 != null && (eiVar2 instanceof ei)) {
                String str = eiVar2.dHG.dHE;
                int i2 = eiVar2.dHG.dHH;
                int i3 = eiVar2.dHG.dHI;
                if (!l.gmx.containsKey(str + "," + i2 + "," + i3)) {
                    ccm ccm = new ccm();
                    ccm.uuid = str;
                    ccm.major = i2;
                    ccm.minor = 65535 & i3;
                    ccm.jiP = eiVar2.dHG.dHJ;
                    l.gmx.put(str + "," + i2 + "," + i3, ccm);
                    if (eiVar2.dHG.dHJ >= 0.0d && l.gmy.size() > 0) {
                        int i4 = 0;
                        while (true) {
                            if (i4 >= l.gmy.size()) {
                                break;
                            }
                            ccm ccm2 = (ccm) l.gmy.get(i4);
                            if (eiVar2.dHG.dHJ >= ccm2.jiP) {
                                if (i4 == l.gmy.size() - 1 && eiVar2.dHG.dHJ > ccm2.jiP) {
                                    l.gmy.add(ccm);
                                    break;
                                }
                                i4++;
                            } else {
                                l.gmy.add(i4, ccm);
                                break;
                            }
                        }
                    } else {
                        l.gmy.add(ccm);
                    }
                }
                Log.i("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]result iBeacon = %s,beaconMap.size:%d", str + "," + i2 + "," + i3, Integer.valueOf(l.gmx.size()));
            }
            AppMethodBeat.o(19894);
            return false;
        }
    };
    private static com.tencent.mm.modelgeo.d gmt;
    private static float gmu = -85.0f;
    private static float gmv = -1000.0f;
    private static boolean gmw = false;
    private static Map<String, ccm> gmx = new ConcurrentHashMap();
    private static List<ccm> gmy = new CopyOnWriteArrayList();
    private static Boolean gmz = Boolean.FALSE;

    static {
        AppMethodBeat.i(19896);
        AppMethodBeat.o(19896);
    }

    public static void run() {
        AppMethodBeat.i(19895);
        if (!bg.aAc() || bg.azj()) {
            AppMethodBeat.o(19895);
            return;
        }
        bg.aVF();
        Boolean valueOf = Boolean.valueOf(Util.nullAs((Boolean) c.azQ().get(ar.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, (Object) null), false));
        Log.i("MicroMsg.PostTaskStartRangeForIBeacon", "the range road status is ".concat(String.valueOf(valueOf)));
        if (!valueOf.booleanValue()) {
            AppMethodBeat.o(19895);
            return;
        }
        long nowSecond = Util.nowSecond();
        bg.aVF();
        long nullAs = Util.nullAs((Long) c.azQ().get(ar.a.USERINFO_IBEACON_PUSH_OPEN_TIEMSTAMP_LONG, (Object) null), 0);
        bg.aVF();
        if (nowSecond - nullAs > Util.nullAs((Long) c.azQ().get(ar.a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_TIME_LONG, (Object) null), 0)) {
            bg.aVF();
            c.azQ().set(ar.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.FALSE);
            bg.aVF();
            c.azQ().set(ar.a.USERINFO_IBEACON_PUSH_LAST_BEACONINFO_STRING, "");
            bg.aVF();
            c.azQ().set(ar.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, "");
            bg.aVF();
            c.azl();
            AppMethodBeat.o(19895);
            return;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (Build.VERSION.SDK_INT < 18 || defaultAdapter == null || defaultAdapter.getState() != 12) {
            bg.aVF();
            c.azQ().set(ar.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, "");
            AppMethodBeat.o(19895);
            return;
        }
        List<String> aqA = h.aqK().aqA();
        if (aqA != null) {
            for (String str : aqA) {
                Log.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=true,iBeacon = %s", str);
                eh ehVar = new eh();
                ehVar.dHC.dHE = str;
                ehVar.dHC.dHB = true;
                EventCenter.instance.publish(ehVar);
            }
            gmt = com.tencent.mm.modelgeo.d.bca();
            if (gmB.stopped()) {
                gmB.startTimer(3000);
            }
            if (!gmw && gmt != null) {
                gmt.a(gmA, true);
            }
            EventCenter.instance.addListener(gmC);
        }
        AppMethodBeat.o(19895);
    }
}
