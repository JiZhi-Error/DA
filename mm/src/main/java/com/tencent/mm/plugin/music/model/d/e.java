package com.tencent.mm.plugin.music.model.d;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.plugin.music.h.c;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public final class e {
    private static a AlA;
    public static boolean Alx;
    public static boolean Aly;
    public static int Alz;
    public static long iJF;
    public static int scene;
    public static int zaP;

    public static final void at(int i2, int i3, int i4) {
        AppMethodBeat.i(63144);
        a etY = ((com.tencent.mm.plugin.music.e.e) b.aS(com.tencent.mm.plugin.music.e.e.class)).etY();
        if (etY != null) {
            Log.v("MicroMsg.Music.MusicReportUtil", "kvReportShakeReport: %d, %d, %d, %s, %s, %s, %s, %d %s, %s", 13042, Integer.valueOf(i2), Integer.valueOf(i3), etY.field_musicId, etY.field_songName, etY.field_songAlbum, Integer.valueOf(etY.field_songId), Integer.valueOf(i4), etY.field_songSinger, etY.field_appId);
            h.INSTANCE.a(13042, Integer.valueOf(i2), Integer.valueOf(i3), etY.field_musicId, etY.field_songName, etY.field_songAlbum, Integer.valueOf(etY.field_songId), Integer.valueOf(i4), etY.field_songSinger, etY.field_appId);
        }
        AppMethodBeat.o(63144);
    }

    public static final void hu(int i2, int i3) {
        AppMethodBeat.i(63145);
        a etY = ((com.tencent.mm.plugin.music.e.e) b.aS(com.tencent.mm.plugin.music.e.e.class)).etY();
        if (etY != null) {
            Log.v("MicroMsg.Music.MusicReportUtil", "kvReportAction: %d, %s, %s, %s, %s, %d, %d, %s, %s", 13232, etY.field_musicId, etY.field_songName, etY.field_songAlbum, Integer.valueOf(etY.field_songId), Integer.valueOf(i3), Integer.valueOf(i2), etY.field_songSinger, etY.field_appId);
            h.INSTANCE.a(13232, etY.field_musicId, etY.field_songName, etY.field_songAlbum, Integer.valueOf(etY.field_songId), Integer.valueOf(i3), Integer.valueOf(i2), etY.field_songSinger, etY.field_appId);
        }
        AppMethodBeat.o(63145);
    }

    public static synchronized void g(a aVar) {
        synchronized (e.class) {
            AlA = aVar;
        }
    }

    public static final synchronized void euK() {
        int i2;
        int i3 = 1;
        synchronized (e.class) {
            AppMethodBeat.i(63146);
            if (AlA != null) {
                bdY();
                Object[] objArr = new Object[12];
                objArr[0] = 13044;
                objArr[1] = AlA.field_musicId;
                objArr[2] = AlA.field_songName;
                objArr[3] = AlA.field_songAlbum;
                objArr[4] = Integer.valueOf(AlA.field_songId);
                objArr[5] = Integer.valueOf(Alz);
                objArr[6] = Integer.valueOf(zaP);
                objArr[7] = Integer.valueOf(Alx ? 1 : 2);
                objArr[8] = Integer.valueOf(Aly ? 1 : 2);
                objArr[9] = Integer.valueOf(scene);
                objArr[10] = AlA.field_songSinger;
                objArr[11] = AlA.field_appId;
                Log.v("MicroMsg.Music.MusicReportUtil", "kvReportMusicPlayInfo: %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", objArr);
                h hVar = h.INSTANCE;
                Object[] objArr2 = new Object[11];
                objArr2[0] = AlA.field_musicId;
                objArr2[1] = AlA.field_songName;
                objArr2[2] = AlA.field_songAlbum;
                objArr2[3] = Integer.valueOf(AlA.field_songId);
                objArr2[4] = Integer.valueOf(Alz);
                objArr2[5] = Integer.valueOf(zaP);
                if (Alx) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                objArr2[6] = Integer.valueOf(i2);
                if (!Aly) {
                    i3 = 2;
                }
                objArr2[7] = Integer.valueOf(i3);
                objArr2[8] = Integer.valueOf(scene);
                objArr2[9] = AlA.field_songSinger;
                objArr2[10] = AlA.field_appId;
                hVar.a(13044, objArr2);
            }
            AlA = null;
            Alx = false;
            Aly = false;
            Alz = 0;
            zaP = 0;
            iJF = 0;
            scene = 0;
            AppMethodBeat.o(63146);
        }
    }

    public static final void bdY() {
        AppMethodBeat.i(63147);
        if (iJF > 0) {
            zaP = (int) (((long) zaP) + ((System.currentTimeMillis() - iJF) / 1000));
            iJF = 0;
        }
        AppMethodBeat.o(63147);
    }

    public static final void euL() {
        AppMethodBeat.i(63148);
        h.INSTANCE.idkeyStat(285, 4, 1, false);
        AppMethodBeat.o(63148);
    }

    public static final void SX(int i2) {
        f bef;
        AppMethodBeat.i(63149);
        if (i2 == 2 && (bef = com.tencent.mm.ay.a.bef()) != null) {
            com.tencent.mm.plugin.fav.a.h.w(Util.getLong(bef.jft, 0), 1);
        }
        AppMethodBeat.o(63149);
    }

    public static final void SY(int i2) {
        f bef;
        AppMethodBeat.i(63150);
        if (i2 == 2 && (bef = com.tencent.mm.ay.a.bef()) != null) {
            com.tencent.mm.plugin.fav.a.h.w(Util.getLong(bef.jft, 0), 0);
        }
        AppMethodBeat.o(63150);
    }

    public static final void SZ(int i2) {
        AppMethodBeat.i(63151);
        a etY = ((com.tencent.mm.plugin.music.e.e) b.aS(com.tencent.mm.plugin.music.e.e.class)).etY();
        if (etY != null) {
            Log.i("MicroMsg.Music.MusicReportUtil", "ReportMusicPlayerShareStat ShareType:%d, MusicId:%s, MusicTitle:%s, Singer:%s, AppId:%s", Integer.valueOf(i2), etY.field_musicId, etY.field_songName, etY.field_songSinger, etY.field_appId);
            h.INSTANCE.a(12836, Integer.valueOf(i2), etY.field_musicId, etY.field_songName, etY.field_songSinger, etY.field_appId);
        }
        AppMethodBeat.o(63151);
    }

    public static void a(int i2, a aVar) {
        AppMethodBeat.i(63152);
        if (aVar == null) {
            Log.e("MicroMsg.Music.MusicReportUtil", "kvReportMusicNotificationStat music is null, err");
            AppMethodBeat.o(63152);
            return;
        }
        Log.i("MicroMsg.Music.MusicReportUtil", "kvReportMusicNotificationStat scene:%d, action:%d, src:%s, title:%s, singer:%s", Integer.valueOf(aVar.field_musicType), Integer.valueOf(i2), aVar.field_songWifiUrl, aVar.field_songName, aVar.field_songSinger);
        h.INSTANCE.a(15106, Integer.valueOf(aVar.field_musicType), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()), aVar.field_songWifiUrl, aVar.field_songName, aVar.field_songSinger);
        AppMethodBeat.o(63152);
    }

    public static void a(f fVar, boolean z) {
        AppMethodBeat.i(63153);
        if (fVar == null) {
            Log.e("MicroMsg.Music.MusicReportUtil", "idKeyReportMusicPlayerSum music is null");
            AppMethodBeat.o(63153);
            return;
        }
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(JsApiSetLabInfo.CTRL_INDEX);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(JsApiSetLabInfo.CTRL_INDEX);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(JsApiSetLabInfo.CTRL_INDEX);
        iDKey3.SetValue(1);
        if (z) {
            iDKey3.SetKey(10);
        } else if (c.U(fVar)) {
            Ta(fVar.jeT);
            AppMethodBeat.o(63153);
            return;
        } else if (c.Th(fVar.jeT)) {
            iDKey3.SetKey(2);
            iDKey2.SetKey(c.SW(fVar.jeT));
            arrayList.add(iDKey2);
            h.INSTANCE.a(14174, 1, Integer.valueOf(fVar.jeT));
            if (com.tencent.mm.plugin.music.model.a.b.aHR(fVar.playUrl)) {
                IDKey iDKey4 = new IDKey();
                iDKey4.SetID(JsApiSetLabInfo.CTRL_INDEX);
                iDKey4.SetKey(216);
                iDKey4.SetValue(1);
                arrayList.add(iDKey4);
            }
        } else {
            iDKey3.SetKey(1);
            iDKey2.SetKey(c.SV(fVar.jeT));
            arrayList.add(iDKey2);
            h.INSTANCE.a(14174, 0, Integer.valueOf(fVar.jeT));
            if (com.tencent.mm.plugin.music.model.a.b.aHR(fVar.playUrl)) {
                IDKey iDKey5 = new IDKey();
                iDKey5.SetID(JsApiSetLabInfo.CTRL_INDEX);
                iDKey5.SetKey(215);
                iDKey5.SetValue(1);
                arrayList.add(iDKey5);
            }
        }
        arrayList.add(iDKey);
        arrayList.add(iDKey3);
        h.INSTANCE.b(arrayList, true);
        AppMethodBeat.o(63153);
    }

    private static void Ta(int i2) {
        AppMethodBeat.i(63154);
        Log.i("MicroMsg.Music.MusicReportUtil", "idKeyReportExoMusicPlayerSum scene:%d", Integer.valueOf(i2));
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(797);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(797);
        iDKey2.SetKey(b.SS(i2));
        iDKey2.SetValue(1);
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        h.INSTANCE.b(arrayList, true);
        AppMethodBeat.o(63154);
    }
}
