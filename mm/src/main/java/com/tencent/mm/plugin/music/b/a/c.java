package com.tencent.mm.plugin.music.b.a;

import android.text.TextUtils;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.k.g;
import com.tencent.mm.plugin.appbrand.jsapi.p.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c implements d {
    private static volatile int AhX = 0;
    private static volatile int AhY = 0;
    private static volatile int AhZ = 0;
    private static volatile int Aia = 0;
    private static volatile int Aib = 0;
    private static volatile int Aic = 0;
    private static volatile int Aid = 0;
    private static volatile HashMap<String, Integer> Aie = new HashMap<>();
    private static volatile HashMap<String, Integer> Aif = new HashMap<>();
    private static volatile HashMap<String, a> Aig = new HashMap<>();
    private static volatile HashMap<String, List<Long>> Aih = new HashMap<>();
    private static volatile HashMap<String, List<Long>> Aii = new HashMap<>();
    private static volatile HashMap<String, List<Long>> Aij = new HashMap<>();

    static /* synthetic */ int TU() {
        int i2 = Aia;
        Aia = i2 + 1;
        return i2;
    }

    static /* synthetic */ int WI() {
        int i2 = AhY;
        AhY = i2 + 1;
        return i2;
    }

    static /* synthetic */ int bhf() {
        int i2 = Aib;
        Aib = i2 + 1;
        return i2;
    }

    static /* synthetic */ int etu() {
        int i2 = Aid;
        Aid = i2 + 1;
        return i2;
    }

    static /* synthetic */ int etv() {
        int i2 = Aic;
        Aic = i2 + 1;
        return i2;
    }

    @Override // com.tencent.mm.plugin.music.b.a.d
    public final void ho(int i2, int i3) {
        int i4;
        AppMethodBeat.i(62947);
        IDKey iDKey = new IDKey();
        iDKey.SetID(com.tencent.mm.plugin.appbrand.game.e.b.c.CTRL_INDEX);
        iDKey.SetKey(1);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(com.tencent.mm.plugin.appbrand.game.e.b.c.CTRL_INDEX);
        Log.d("MicroMsg.Audio.AudioPlayIdKeyReport", "getQQAudioPlayerErrSceneIdKey, scene:".concat(String.valueOf(i2)));
        switch (i2) {
        }
        iDKey2.SetKey(9);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(com.tencent.mm.plugin.appbrand.game.e.b.c.CTRL_INDEX);
        Log.i("MicroMsg.Audio.AudioPlayIdKeyReport", "getQQAudioPlayerErrIdKey, errCode:".concat(String.valueOf(i3)));
        switch (i3) {
            case 53:
                i4 = 17;
                break;
            case 54:
                i4 = 18;
                break;
            case 55:
                i4 = 19;
                break;
            case 62:
                i4 = 20;
                break;
            case 63:
                i4 = 21;
                break;
            case 64:
                i4 = 22;
                break;
            case 66:
                i4 = 23;
                break;
            case 67:
                i4 = 24;
                break;
            case 69:
                i4 = 25;
                break;
            case 70:
                i4 = 36;
                break;
            case 74:
                i4 = 26;
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                i4 = 27;
                break;
            case 101:
                i4 = 28;
                break;
            case 102:
                i4 = 29;
                break;
            case 500:
                i4 = 31;
                break;
            case 501:
                i4 = 32;
                break;
            case 502:
                i4 = 33;
                break;
            case 503:
                i4 = 34;
                break;
            case 504:
                i4 = 35;
                break;
            default:
                i4 = 30;
                break;
        }
        iDKey3.SetKey(i4);
        iDKey3.SetValue(1);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        h.INSTANCE.b(arrayList, true);
        AppMethodBeat.o(62947);
    }

    @Override // com.tencent.mm.plugin.music.b.a.d
    public final void Sx(int i2) {
        int i3;
        AppMethodBeat.i(62948);
        IDKey iDKey = new IDKey();
        iDKey.SetID(com.tencent.mm.plugin.appbrand.game.e.b.c.CTRL_INDEX);
        if (i2 == 2) {
            i3 = 42;
        } else if (i2 == 3) {
            i3 = 43;
        } else if (i2 == 4) {
            i3 = 44;
        } else if (i2 == 5) {
            i3 = 45;
        } else if (i2 == 6) {
            i3 = 46;
        } else if (i2 == 7) {
            i3 = 47;
        } else if (i2 == 8) {
            i3 = 48;
        } else if (i2 == 9) {
            i3 = 49;
        } else {
            i3 = 50;
        }
        iDKey.SetKey(i3);
        iDKey.SetValue(1);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        arrayList.add(iDKey);
        h.INSTANCE.b(arrayList, true);
        AppMethodBeat.o(62948);
    }

    static {
        AppMethodBeat.i(62961);
        AppMethodBeat.o(62961);
    }

    @Override // com.tencent.mm.plugin.music.b.a.d
    public final void etr() {
        synchronized (Aif) {
            AhZ++;
        }
    }

    @Override // com.tencent.mm.plugin.music.b.a.d
    public final void iT(final String str, final String str2) {
        AppMethodBeat.i(62952);
        com.tencent.mm.ch.a.post(new Runnable() {
            /* class com.tencent.mm.plugin.music.b.a.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(62942);
                String str = str + "-" + MD5Util.getMD5String(str2);
                synchronized (c.Aif) {
                    try {
                        if (c.Aie.containsKey(str)) {
                            c.Aie.put(str, Integer.valueOf(((Integer) c.Aie.get(str)).intValue() + 1));
                        } else {
                            c.Aie.put(str, 1);
                        }
                        c.WI();
                    } finally {
                        AppMethodBeat.o(62942);
                    }
                }
            }
        });
        AppMethodBeat.o(62952);
    }

    @Override // com.tencent.mm.plugin.music.b.a.d
    public final void t(final String str, final String str2, final boolean z) {
        AppMethodBeat.i(62953);
        com.tencent.mm.ch.a.post(new Runnable() {
            /* class com.tencent.mm.plugin.music.b.a.c.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(62943);
                String str = str + "-" + MD5Util.getMD5String(str2);
                synchronized (c.Aif) {
                    try {
                        if (c.Aif.containsKey(str)) {
                            c.Aif.put(str, Integer.valueOf(((Integer) c.Aif.get(str)).intValue() + 1));
                        } else {
                            c.Aif.put(str, 1);
                        }
                        if (!z) {
                            c.bhf();
                        } else {
                            c.TU();
                        }
                    } finally {
                        AppMethodBeat.o(62943);
                    }
                }
            }
        });
        AppMethodBeat.o(62953);
    }

    @Override // com.tencent.mm.plugin.music.b.a.d
    public final void a(String str, String str2, long j2, long j3, long j4) {
        AppMethodBeat.i(62954);
        a(str, str2, j2, j3, j4, true, "", 0L, 0L, 0L);
        AppMethodBeat.o(62954);
    }

    @Override // com.tencent.mm.plugin.music.b.a.d
    public final void a(final String str, final String str2, final long j2, final long j3, final long j4, final boolean z, final String str3, final long j5, final long j6, final long j7) {
        AppMethodBeat.i(62955);
        com.tencent.mm.ch.a.post(new Runnable() {
            /* class com.tencent.mm.plugin.music.b.a.c.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(62944);
                String str = str + "-" + MD5Util.getMD5String(str2);
                synchronized (c.Aif) {
                    try {
                        if (c.Aif.containsKey(str)) {
                            c.a(c.Aih, str, j2);
                            c.a(c.Aii, str, j3);
                            c.a(c.Aij, str, j4);
                            int intValue = ((Integer) c.Aif.get(str)).intValue() - 1;
                            if (intValue > 0) {
                                c.Aif.put(str, Integer.valueOf(intValue));
                            } else {
                                c.Aif.remove(str);
                            }
                            if (!z) {
                                int unused = c.AhX = 1;
                                c.etu();
                            } else {
                                c.etv();
                            }
                        } else {
                            Log.d("MicroMsg.Audio.AudioReportService", "leonlaudio not exist audioKey, audioId:%s, audioSrc:%s", str, str2);
                        }
                        if (c.Aie.containsKey(str)) {
                            int intValue2 = ((Integer) c.Aie.get(str)).intValue() - 1;
                            if (intValue2 > 0) {
                                c.Aie.put(str, Integer.valueOf(intValue2));
                            } else {
                                c.Aie.remove(str);
                            }
                        }
                        if (!z && !TextUtils.isEmpty(str3)) {
                            if (c.Aig.containsKey(str3)) {
                                a aVar = (a) c.Aig.get(str3);
                                if (aVar != null) {
                                    aVar.Aiv++;
                                }
                                aVar.Aiw = j7;
                                aVar.fileSize = j6;
                                aVar.duration = j5;
                                c.Aig.put(str3, aVar);
                            } else {
                                a aVar2 = new a();
                                aVar2.Aiv = 1;
                                aVar2.Aiw = j7;
                                aVar2.fileSize = j6;
                                aVar2.duration = j5;
                                c.Aig.put(str3, aVar2);
                            }
                        }
                    } finally {
                        AppMethodBeat.o(62944);
                    }
                }
            }
        });
        AppMethodBeat.o(62955);
    }

    /* access modifiers changed from: package-private */
    public class b {
        int Aix = 0;
        long Aiy = 0;
        long cxN = 0;

        b() {
        }
    }

    /* access modifiers changed from: package-private */
    public class a {
        int Aiv = 0;
        long Aiw = 0;
        long duration = 0;
        long fileSize = 0;

        a() {
        }
    }

    @Override // com.tencent.mm.plugin.music.b.a.d
    public final void c(final String str, final long j2, final long j3, final long j4) {
        AppMethodBeat.i(62956);
        com.tencent.mm.ch.a.post(new Runnable() {
            /* class com.tencent.mm.plugin.music.b.a.c.AnonymousClass4 */

            public final void run() {
                int i2;
                int i3;
                String str;
                AppMethodBeat.i(62945);
                synchronized (c.Aif) {
                    try {
                        Log.d("MicroMsg.Audio.AudioReportService", "leonlaudio clear appId:%s", str);
                        int i4 = 0;
                        int i5 = 0;
                        String str2 = "";
                        for (Map.Entry entry : c.Aie.entrySet()) {
                            String str3 = (String) entry.getKey();
                            i4 += ((Integer) entry.getValue()).intValue();
                            if (((Integer) entry.getValue()).intValue() > i5) {
                                i3 = ((Integer) entry.getValue()).intValue();
                                str = str3;
                            } else {
                                i3 = i5;
                                str = str2;
                            }
                            Log.d("MicroMsg.Audio.AudioReportService", "leonlaudio clear real invoke audioKey:%s, lostCount:%s", str3, entry.getValue());
                            i5 = i3;
                            str2 = str;
                        }
                        c.Aie.clear();
                        int i6 = 0;
                        String str4 = "";
                        int i7 = 0;
                        for (Map.Entry entry2 : c.Aif.entrySet()) {
                            String str5 = (String) entry2.getKey();
                            int intValue = i7 + ((Integer) entry2.getValue()).intValue();
                            if (((Integer) entry2.getValue()).intValue() > i6) {
                                i2 = ((Integer) entry2.getValue()).intValue();
                                str4 = str5;
                            } else {
                                i2 = i6;
                            }
                            Log.d("MicroMsg.Audio.AudioReportService", "leonlaudio clear audioKey:%s, lostCount:%s", str5, entry2.getValue());
                            i6 = i2;
                            i7 = intValue;
                        }
                        c.Aif.clear();
                        b bVar = new b();
                        b bVar2 = new b();
                        b bVar3 = new b();
                        c.a(bVar, c.Aih);
                        c.a(bVar2, c.Aii);
                        c.a(bVar3, c.Aij);
                        c.Aih.clear();
                        c.Aii.clear();
                        c.Aij.clear();
                        Log.d("MicroMsg.Audio.AudioReportService", "leonlaudio clear invokeTotalLostCount:%s, invokeMaxLostCount:%s, invokeMaxLostKey:%s, totalCostCount:%s, totalCostTime:%s, averageCostTime:%s, totalJsCostCount:%s, totalJSCostTime:%s, averageJSCostTime:%s,totalInvokeCostCount:%s, totalInvokeCostTime:%s, averageInvokeCostTime:%s,totalLostCount:%s, maxLostCount:%s, maxLostKey:%s, realInvokeTotalCount:%s, reachMaxPlayerCount:%s, audioPlayerType:%s, useQQAudioPlayerCount:%s, useAudioMixPlayerCount:%s, mixAverageTime:%s, maxCacheBufferSize:%s, realCacheBufferSize:%s", Integer.valueOf(i4), Integer.valueOf(i5), str2, Integer.valueOf(bVar.Aix), Long.valueOf(bVar.cxN), Long.valueOf(bVar.Aiy), Integer.valueOf(bVar2.Aix), Long.valueOf(bVar2.cxN), Long.valueOf(bVar2.Aiy), Integer.valueOf(bVar3.Aix), Long.valueOf(bVar3.cxN), Long.valueOf(bVar3.Aiy), Integer.valueOf(i7), Integer.valueOf(i6), str4, Integer.valueOf(c.AhY), Integer.valueOf(c.AhZ), Integer.valueOf(c.AhX), Integer.valueOf(c.Aic), Integer.valueOf(c.Aid), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
                        Log.d("MicroMsg.Audio.AudioReportService", "leonlaudio clear invokeQQAudioPlayerPlayCount:%s, invokeMixPlayerPlayCount:%s, useQQAudioPlayerPlayLostCount:%s, useMixPlayerPlayLostCount:%s, ", Integer.valueOf(c.Aia), Integer.valueOf(c.Aib), Integer.valueOf((c.Aia - c.Aic) + c.AhZ), Integer.valueOf(c.Aib - c.Aid));
                        if (bVar.Aix > 0 && bVar2.Aix > 0 && bVar3.Aix > 0) {
                            h.INSTANCE.a(15686, str, Integer.valueOf(i4), Integer.valueOf(i5), str2, Integer.valueOf(bVar.Aix), Long.valueOf(bVar.cxN), Long.valueOf(bVar.Aiy), Integer.valueOf(bVar2.Aix), Long.valueOf(bVar2.cxN), Long.valueOf(bVar2.Aiy), Integer.valueOf(bVar3.Aix), Long.valueOf(bVar3.cxN), Long.valueOf(bVar3.Aiy), Integer.valueOf(i7), Integer.valueOf(i6), str4, Integer.valueOf(c.AhY), Integer.valueOf(c.AhZ), Integer.valueOf(c.AhX), Integer.valueOf(c.Aic), Integer.valueOf(c.Aid), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf((c.Aia - c.Aic) + c.AhZ), Integer.valueOf(c.Aib - c.Aid));
                            c.a(c.AhX, bVar2.Aiy, bVar3.Aiy, bVar.Aiy, i7 + c.AhZ, i4, j3, j4, c.AhZ + (c.Aia - c.Aic), c.Aib - c.Aid);
                        }
                        int unused = c.AhY = 0;
                        int unused2 = c.AhZ = 0;
                        int unused3 = c.AhX = 0;
                        int unused4 = c.Aia = 0;
                        int unused5 = c.Aib = 0;
                        int unused6 = c.Aic = 0;
                        int unused7 = c.Aid = 0;
                        c.aHq(str);
                        c.Aig.clear();
                    } finally {
                        AppMethodBeat.o(62945);
                    }
                }
            }
        });
        AppMethodBeat.o(62956);
    }

    @Override // com.tencent.mm.plugin.music.b.a.d
    public final void Sw(int i2) {
        AppMethodBeat.i(62946);
        Log.d("MicroMsg.Audio.AudioPlayIdKeyReport", "idKeyReportQQAudioPlayerSum scene:%d", Integer.valueOf(i2));
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(com.tencent.mm.plugin.appbrand.game.e.b.c.CTRL_INDEX);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(com.tencent.mm.plugin.appbrand.game.e.b.c.CTRL_INDEX);
        Log.d("MicroMsg.Audio.AudioPlayIdKeyReport", "getQQAudioPlayerSumIdKeyByScene, scene:".concat(String.valueOf(i2)));
        switch (i2) {
        }
        iDKey2.SetKey(2);
        iDKey2.SetValue(1);
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        h.INSTANCE.b(arrayList, true);
        AppMethodBeat.o(62946);
    }

    @Override // com.tencent.mm.plugin.music.b.a.d
    public final void Sy(int i2) {
        AppMethodBeat.i(62949);
        Log.d("MicroMsg.Audio.AudioPlayIdKeyReport", "idKeyReportAudioMixPlayerSum scene:%d", Integer.valueOf(i2));
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(com.tencent.mm.plugin.appbrand.game.e.b.c.CTRL_INDEX);
        iDKey.SetKey(90);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        h.INSTANCE.b(arrayList, true);
        AppMethodBeat.o(62949);
    }

    @Override // com.tencent.mm.plugin.music.b.a.d
    public final void Sz(int i2) {
        AppMethodBeat.i(62950);
        IDKey iDKey = new IDKey();
        iDKey.SetID(com.tencent.mm.plugin.appbrand.game.e.b.c.CTRL_INDEX);
        iDKey.SetKey(91);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(com.tencent.mm.plugin.appbrand.game.e.b.c.CTRL_INDEX);
        iDKey2.SetKey(b.Sv(i2));
        iDKey2.SetValue(1);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        h.INSTANCE.b(arrayList, true);
        b.M(arrayList);
        AppMethodBeat.o(62950);
    }

    @Override // com.tencent.mm.plugin.music.b.a.d
    public final void SA(int i2) {
        AppMethodBeat.i(62951);
        IDKey iDKey = new IDKey();
        iDKey.SetID(com.tencent.mm.plugin.appbrand.game.e.b.c.CTRL_INDEX);
        iDKey.SetKey(118);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(com.tencent.mm.plugin.appbrand.game.e.b.c.CTRL_INDEX);
        iDKey2.SetKey(b.Sv(i2));
        iDKey2.SetValue(1);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        h.INSTANCE.b(arrayList, true);
        b.M(arrayList);
        AppMethodBeat.o(62951);
    }

    public static void a(int i2, long j2, long j3, long j4, int i3, int i4, long j5, long j6, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        AppMethodBeat.i(62957);
        IDKey iDKey = new IDKey();
        iDKey.SetID(971);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        arrayList.add(iDKey);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(971);
        iDKey2.SetValue(1);
        arrayList.add(iDKey2);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(971);
        iDKey3.SetValue(1);
        arrayList.add(iDKey3);
        IDKey iDKey4 = new IDKey();
        iDKey4.SetID(971);
        iDKey4.SetValue(1);
        arrayList.add(iDKey4);
        IDKey iDKey5 = new IDKey();
        iDKey5.SetID(971);
        iDKey5.SetValue(1);
        arrayList.add(iDKey5);
        IDKey iDKey6 = new IDKey();
        iDKey6.SetID(971);
        iDKey6.SetValue(1);
        arrayList.add(iDKey6);
        IDKey iDKey7 = new IDKey();
        iDKey7.SetID(971);
        iDKey7.SetValue(1);
        arrayList.add(iDKey7);
        IDKey iDKey8 = new IDKey();
        iDKey8.SetID(971);
        iDKey8.SetValue(1);
        arrayList.add(iDKey8);
        IDKey iDKey9 = new IDKey();
        IDKey iDKey10 = new IDKey();
        if (i3 > 0) {
            iDKey9.SetID(971);
            iDKey9.SetValue(1);
            arrayList.add(iDKey9);
            iDKey10.SetID(971);
            iDKey10.SetValue(1);
            arrayList.add(iDKey10);
        }
        IDKey iDKey11 = new IDKey();
        IDKey iDKey12 = new IDKey();
        if (i4 > 0) {
            iDKey11.SetID(971);
            iDKey11.SetValue(1);
            arrayList.add(iDKey11);
            iDKey12.SetID(971);
            iDKey12.SetValue(1);
            arrayList.add(iDKey12);
        }
        if (i2 == 0) {
            iDKey2.SetKey(1);
            iDKey3.SetKey(2);
            if (0 <= j2 && j2 <= 3) {
                i16 = 3;
            } else if (3 < j2 && j2 <= 6) {
                i16 = 4;
            } else if (6 < j2 && j2 <= 10) {
                i16 = 5;
            } else if (10 < j2 && j2 <= 15) {
                i16 = 6;
            } else if (15 >= j2 || j2 > 20) {
                i16 = 8;
            } else {
                i16 = 7;
            }
            iDKey4.SetKey(i16);
            iDKey5.SetKey(11);
            if (0 <= j3 && j3 <= 6) {
                i17 = 12;
            } else if (6 < j3 && j3 <= 10) {
                i17 = 13;
            } else if (10 < j3 && j3 <= 15) {
                i17 = 14;
            } else if (15 < j3 && j3 <= 20) {
                i17 = 15;
            } else if (20 < j3 && j3 <= 30) {
                i17 = 16;
            } else if (30 < j3 && j3 <= 40) {
                i17 = 17;
            } else if (40 >= j3 || j3 > 50) {
                i17 = 19;
            } else {
                i17 = 18;
            }
            iDKey6.SetKey(i17);
            iDKey7.SetKey(22);
            if (0 <= j4 && j4 <= 20) {
                i18 = 23;
            } else if (20 < j4 && j4 <= 30) {
                i18 = 24;
            } else if (30 < j4 && j4 <= 40) {
                i18 = 25;
            } else if (40 < j4 && j4 <= 50) {
                i18 = 26;
            } else if (50 < j4 && j4 <= 60) {
                i18 = 27;
            } else if (60 < j4 && j4 <= 70) {
                i18 = 28;
            } else if (70 < j4 && j4 <= 80) {
                i18 = 29;
            } else if (80 < j4 && j4 <= 90) {
                i18 = 30;
            } else if (90 < j4 && j4 <= 100) {
                i18 = 31;
            } else if (100 < j4 && j4 <= 110) {
                i18 = 32;
            } else if (110 < j4 && j4 <= 120) {
                i18 = 33;
            } else if (120 < j4 && j4 <= 130) {
                i18 = 34;
            } else if (130 < j4 && j4 <= 140) {
                i18 = 35;
            } else if (140 < j4 && j4 <= 150) {
                i18 = 36;
            } else if (150 >= j4 || j4 > 200) {
                i18 = 38;
            } else {
                i18 = 37;
            }
            iDKey8.SetKey(i18);
            if (i3 > 0) {
                iDKey9.SetKey(41);
                if (i3 == 0) {
                    i20 = 42;
                } else if (i3 > 0 && i3 <= 3) {
                    i20 = 43;
                } else if (4 <= i3 && i3 <= 6) {
                    i20 = 44;
                } else if (7 <= i3 && i3 <= 10) {
                    i20 = 45;
                } else if (11 <= i3 && i3 <= 15) {
                    i20 = 46;
                } else if (15 < i3 && i3 <= 20) {
                    i20 = 47;
                } else if (20 < i3 && i3 <= 40) {
                    i20 = 48;
                } else if (40 < i3 && i3 <= 60) {
                    i20 = 49;
                } else if (60 >= i3 || i3 > 100) {
                    i20 = 51;
                } else {
                    i20 = 50;
                }
                iDKey10.SetKey(i20);
            }
            if (i4 > 0) {
                iDKey11.SetKey(124);
                if (i4 == 0) {
                    i19 = 125;
                } else if (i4 >= 0 && i4 <= 10) {
                    i19 = 126;
                } else if (10 <= i4 && i4 <= 20) {
                    i19 = TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
                } else if (20 <= i4 && i4 <= 40) {
                    i19 = 128;
                } else if (40 <= i4 && i4 <= 60) {
                    i19 = 129;
                } else if (60 < i4 && i4 <= 100) {
                    i19 = 130;
                } else if (100 < i4 && i4 <= 150) {
                    i19 = TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE;
                } else if (150 < i4 && i4 <= 200) {
                    i19 = 132;
                } else if (200 >= i4 || i4 > 500) {
                    i19 = g.CTRL_INDEX;
                } else {
                    i19 = 133;
                }
                iDKey12.SetKey(i19);
            }
        } else {
            iDKey2.SetKey(59);
            iDKey3.SetKey(60);
            if (0 < j2 && j2 <= 3) {
                i7 = 61;
            } else if (3 < j2 && j2 <= 6) {
                i7 = 62;
            } else if (6 < j2 && j2 <= 10) {
                i7 = 63;
            } else if (10 < j2 && j2 <= 15) {
                i7 = 64;
            } else if (15 >= j2 || j2 > 20) {
                i7 = 66;
            } else {
                i7 = 65;
            }
            iDKey4.SetKey(i7);
            iDKey5.SetKey(69);
            if (0 <= j3 && j3 <= 6) {
                i8 = 70;
            } else if (6 < j3 && j3 <= 10) {
                i8 = 71;
            } else if (10 < j3 && j3 <= 15) {
                i8 = 72;
            } else if (15 < j3 && j3 <= 20) {
                i8 = 73;
            } else if (20 < j3 && j3 <= 30) {
                i8 = 74;
            } else if (30 < j3 && j3 <= 40) {
                i8 = 75;
            } else if (40 >= j3 || j3 > 50) {
                i8 = 77;
            } else {
                i8 = 76;
            }
            iDKey6.SetKey(i8);
            iDKey7.SetKey(80);
            if (0 <= j4 && j4 <= 20) {
                i9 = 81;
            } else if (20 < j4 && j4 <= 30) {
                i9 = 82;
            } else if (30 < j4 && j4 <= 40) {
                i9 = 83;
            } else if (40 < j4 && j4 <= 50) {
                i9 = 84;
            } else if (50 < j4 && j4 <= 60) {
                i9 = 85;
            } else if (60 < j4 && j4 <= 70) {
                i9 = 86;
            } else if (70 < j4 && j4 <= 80) {
                i9 = 87;
            } else if (80 < j4 && j4 <= 90) {
                i9 = 88;
            } else if (90 < j4 && j4 <= 100) {
                i9 = 89;
            } else if (100 < j4 && j4 <= 110) {
                i9 = 90;
            } else if (110 < j4 && j4 <= 120) {
                i9 = 91;
            } else if (120 < j4 && j4 <= 130) {
                i9 = 92;
            } else if (130 < j4 && j4 <= 140) {
                i9 = 93;
            } else if (140 < j4 && j4 <= 150) {
                i9 = 94;
            } else if (150 >= j4 || j4 > 200) {
                i9 = 96;
            } else {
                i9 = 95;
            }
            iDKey8.SetKey(i9);
            if (i3 > 0) {
                iDKey9.SetKey(98);
                if (i3 == 0) {
                    i13 = 99;
                } else if (i3 > 0 && i3 <= 3) {
                    i13 = 100;
                } else if (4 <= i3 && i3 <= 6) {
                    i13 = 101;
                } else if (7 <= i3 && i3 <= 10) {
                    i13 = 102;
                } else if (11 <= i3 && i3 <= 15) {
                    i13 = 103;
                } else if (15 < i3 && i3 <= 20) {
                    i13 = 104;
                } else if (20 < i3 && i3 <= 40) {
                    i13 = 105;
                } else if (40 < i3 && i3 <= 60) {
                    i13 = 106;
                } else if (60 >= i3 || i3 > 100) {
                    i13 = 108;
                } else {
                    i13 = 107;
                }
                iDKey10.SetKey(i13);
            }
            if (i4 > 0) {
                iDKey11.SetKey(com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX);
                if (i4 == 0) {
                    i12 = 140;
                } else if (i4 >= 0 && i4 <= 10) {
                    i12 = 141;
                } else if (10 <= i4 && i4 <= 20) {
                    i12 = TbsListener.ErrorCode.NEEDDOWNLOAD_3;
                } else if (20 <= i4 && i4 <= 40) {
                    i12 = TbsListener.ErrorCode.NEEDDOWNLOAD_4;
                } else if (40 <= i4 && i4 <= 60) {
                    i12 = 144;
                } else if (60 < i4 && i4 <= 100) {
                    i12 = 145;
                } else if (100 < i4 && i4 <= 150) {
                    i12 = 146;
                } else if (150 < i4 && i4 <= 200) {
                    i12 = TbsListener.ErrorCode.NEEDDOWNLOAD_8;
                } else if (200 >= i4 || i4 > 500) {
                    i12 = 149;
                } else {
                    i12 = 148;
                }
                iDKey12.SetKey(i12);
            }
            if (j5 > 0 && j6 > 0) {
                IDKey iDKey13 = new IDKey();
                iDKey13.SetID(971);
                iDKey13.SetValue(1);
                iDKey13.SetKey(153);
                arrayList.add(iDKey13);
                IDKey iDKey14 = new IDKey();
                iDKey14.SetID(971);
                iDKey14.SetValue(1);
                if (0 <= j5 && j5 <= 10485760) {
                    i10 = 154;
                } else if (10485760 < j5 && j5 <= 20971520) {
                    i10 = 155;
                } else if (20971520 < j5 && j5 <= 31457280) {
                    i10 = 156;
                } else if (31457280 < j5 && j5 <= 41943040) {
                    i10 = 157;
                } else if (41943040 < j5 && j5 <= 52428800) {
                    i10 = 158;
                } else if (52428800 < j5 && j5 <= 62914560) {
                    i10 = JsApiGetBackgroundAudioState.CTRL_INDEX;
                } else if (62914560 < j5 && j5 <= 73400320) {
                    i10 = 160;
                } else if (73400320 < j5 && j5 <= 94371840) {
                    i10 = 161;
                } else if (94371840 >= j5 || j5 > 115343360) {
                    i10 = TbsListener.ErrorCode.STARTDOWNLOAD_4;
                } else {
                    i10 = TbsListener.ErrorCode.STARTDOWNLOAD_3;
                }
                iDKey14.SetKey(i10);
                arrayList.add(iDKey14);
                IDKey iDKey15 = new IDKey();
                iDKey15.SetID(971);
                iDKey15.SetValue(1);
                if (0 <= j6 && j6 <= 10485760) {
                    i11 = 169;
                } else if (10485760 < j6 && j6 <= 20971520) {
                    i11 = TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE;
                } else if (20971520 < j6 && j6 <= 31457280) {
                    i11 = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1;
                } else if (31457280 < j6 && j6 <= 41943040) {
                    i11 = 172;
                } else if (41943040 < j6 && j6 <= 52428800) {
                    i11 = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3;
                } else if (52428800 < j6 && j6 <= 62914560) {
                    i11 = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4;
                } else if (62914560 < j6 && j6 <= 73400320) {
                    i11 = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5;
                } else if (73400320 < j6 && j6 <= 94371840) {
                    i11 = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6;
                } else if (94371840 >= j6 || j6 > 115343360) {
                    i11 = 178;
                } else {
                    i11 = TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING;
                }
                iDKey15.SetKey(i11);
                arrayList.add(iDKey15);
            }
        }
        if (i5 > 0) {
            IDKey iDKey16 = new IDKey();
            iDKey16.SetID(971);
            iDKey16.SetValue(1);
            iDKey16.SetKey(181);
            arrayList.add(iDKey16);
            IDKey iDKey17 = new IDKey();
            iDKey17.SetID(971);
            iDKey17.SetValue(1);
            if (i5 > 0 && i5 <= 3) {
                i15 = 182;
            } else if (4 <= i5 && i5 <= 6) {
                i15 = 183;
            } else if (7 <= i5 && i5 <= 10) {
                i15 = 184;
            } else if (11 <= i5 && i5 <= 15) {
                i15 = 185;
            } else if (15 < i5 && i5 <= 20) {
                i15 = 186;
            } else if (20 < i5 && i5 <= 40) {
                i15 = 187;
            } else if (40 < i5 && i5 <= 60) {
                i15 = 188;
            } else if (60 >= i5 || i5 > 100) {
                i15 = FacebookRequestErrorClassification.EC_INVALID_TOKEN;
            } else {
                i15 = 189;
            }
            iDKey17.SetKey(i15);
            arrayList.add(iDKey17);
        }
        if (i6 > 0) {
            IDKey iDKey18 = new IDKey();
            IDKey iDKey19 = new IDKey();
            iDKey18.SetID(971);
            iDKey18.SetValue(1);
            iDKey18.SetKey(193);
            arrayList.add(iDKey18);
            iDKey19.SetID(971);
            iDKey19.SetValue(1);
            if (i6 > 0 && i6 <= 3) {
                i14 = 194;
            } else if (4 <= i6 && i6 <= 6) {
                i14 = 195;
            } else if (7 <= i6 && i6 <= 10) {
                i14 = 196;
            } else if (11 <= i6 && i6 <= 15) {
                i14 = 197;
            } else if (15 < i6 && i6 <= 20) {
                i14 = z.CTRL_INDEX;
            } else if (20 < i6 && i6 <= 40) {
                i14 = 199;
            } else if (40 < i6 && i6 <= 60) {
                i14 = 200;
            } else if (60 >= i6 || i6 > 100) {
                i14 = 202;
            } else {
                i14 = 201;
            }
            iDKey19.SetKey(i14);
            arrayList.add(iDKey19);
        }
        h.INSTANCE.b(arrayList, true);
        a.M(arrayList);
        AppMethodBeat.o(62957);
    }

    static /* synthetic */ void a(HashMap hashMap, String str, long j2) {
        AppMethodBeat.i(62958);
        if (hashMap.containsKey(str)) {
            ((List) hashMap.get(str)).add(Long.valueOf(j2));
            AppMethodBeat.o(62958);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j2));
        hashMap.put(str, arrayList);
        AppMethodBeat.o(62958);
    }

    static /* synthetic */ void a(b bVar, HashMap hashMap) {
        AppMethodBeat.i(62959);
        for (Map.Entry entry : hashMap.entrySet()) {
            List list = (List) entry.getValue();
            for (int i2 = 0; i2 < list.size(); i2++) {
                bVar.cxN = ((Long) list.get(i2)).longValue() + bVar.cxN;
            }
            bVar.Aix += list.size();
        }
        if (bVar.cxN > 0 && bVar.Aix > 0) {
            bVar.Aiy = bVar.cxN / ((long) bVar.Aix);
        }
        AppMethodBeat.o(62959);
    }

    static /* synthetic */ void aHq(String str) {
        long j2;
        AppMethodBeat.i(62960);
        for (Map.Entry<String, a> entry : Aig.entrySet()) {
            a value = entry.getValue();
            if (value != null && value.Aiv > 0) {
                if (value.fileSize == 0) {
                    j2 = com.tencent.mm.audio.mix.i.a.hv(entry.getKey());
                } else {
                    j2 = value.fileSize;
                }
                h.INSTANCE.a(16577, str, Long.valueOf(j2), Long.valueOf(value.Aiw), Long.valueOf(value.duration), Integer.valueOf(value.Aiv), 0);
            }
        }
        AppMethodBeat.o(62960);
    }
}
