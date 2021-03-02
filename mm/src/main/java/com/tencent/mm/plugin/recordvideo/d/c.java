package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ij;
import com.tencent.mm.g.b.a.ik;
import com.tencent.mm.g.b.a.jf;
import com.tencent.mm.g.b.a.jq;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import java.util.ArrayList;
import kotlin.g.b.p;

public final class c {
    public static a BXA = new a();
    private static jf BXB = new jf();
    private static a BXC = new a();
    private static int BXD = -1;
    private static jq BXE = new jq();
    private static a BXF = new a();
    private static String BXG = "";
    private static String BXH = "";
    public static final c BXI = new c();
    private static RecordMediaReportInfo BXz = new RecordMediaReportInfo();

    static {
        AppMethodBeat.i(75839);
        AppMethodBeat.o(75839);
    }

    private c() {
    }

    public static void a(VideoCaptureReportInfo videoCaptureReportInfo) {
        AppMethodBeat.i(75831);
        BXz = new RecordMediaReportInfo();
        BXA = new a();
        x("KEY_FROM_SCENE_INT", videoCaptureReportInfo != null ? Integer.valueOf(videoCaptureReportInfo.sQn) : -1);
        AppMethodBeat.o(75831);
    }

    public static void x(String str, Object obj) {
        AppMethodBeat.i(75832);
        p.h(str, "key");
        p.h(obj, "value");
        BXz.x(str, obj);
        AppMethodBeat.o(75832);
    }

    public static void fl(String str, int i2) {
        AppMethodBeat.i(237440);
        p.h(str, "key");
        ArrayList arrayList = (ArrayList) BXz.y(str, new ArrayList());
        arrayList.add(Integer.valueOf(i2));
        BXz.x(str, arrayList);
        AppMethodBeat.o(237440);
    }

    public static /* synthetic */ void aLu(String str) {
        AppMethodBeat.i(75833);
        p.h(str, "key");
        BXz.x(str, Integer.valueOf(((Integer) BXz.y(str, 0)).intValue() + 1));
        AppMethodBeat.o(75833);
    }

    public static void VH(int i2) {
        AppMethodBeat.i(75834);
        BXA.VG(i2);
        AppMethodBeat.o(75834);
    }

    public static RecordMediaReportInfo eKW() {
        AppMethodBeat.i(75835);
        BXz.x("KEY_ACTION_TRACE_STRING", BXA.eKV());
        RecordMediaReportInfo recordMediaReportInfo = BXz;
        AppMethodBeat.o(75835);
        return recordMediaReportInfo;
    }

    public static jf eKX() {
        return BXB;
    }

    public static void VI(int i2) {
        AppMethodBeat.i(75836);
        if (i2 == 15 && (BXD == 4 || BXD == 10)) {
            BXD = i2;
            AppMethodBeat.o(75836);
            return;
        }
        BXD = i2;
        BXC.VG(i2);
        BXF.VG(i2);
        AppMethodBeat.o(75836);
    }

    public static void VJ(int i2) {
        AppMethodBeat.i(75837);
        if (i2 == 3) {
            RecordMediaReportInfo eKW = eKW();
            BXB.wD(String.valueOf(((Number) eKW.y("KEY_MUSIC_ID_INT", 0)).intValue()));
            jf jfVar = BXB;
            Object y = eKW.y("KEY_MUSIC_INDEX_INT", 0L);
            p.g(y, "commonRecordInfo.getRepo…e(KEY_MUSIC_INDEX_INT, 0)");
            jfVar.rD(((Number) y).longValue());
            jf jfVar2 = BXB;
            Object y2 = eKW.y("KEY_MUSIC_REQ_ID_INT", 0L);
            p.g(y2, "commonRecordInfo.getRepo…(KEY_MUSIC_REQ_ID_INT, 0)");
            jfVar2.rE(((Number) y2).longValue());
            jf jfVar3 = BXB;
            Object y3 = eKW.y("KEY_SEARCH_MUSIC_INT", 0L);
            p.g(y3, "commonRecordInfo.getRepo…(KEY_SEARCH_MUSIC_INT, 0)");
            jfVar3.rG(((Number) y3).longValue());
            BXB.wH(BXC.eKV());
            BXB.bfK();
            BXD = -1;
        }
        BXB = new jf();
        BXC = new a();
        AppMethodBeat.o(75837);
    }

    public static jq eKY() {
        return BXE;
    }

    public static void VK(int i2) {
        AppMethodBeat.i(75838);
        if (i2 == 3) {
            BXE.sE(System.currentTimeMillis());
            BXE.wW(BXF.eKV());
            BXE.bfK();
        }
        BXE = new jq();
        BXF = new a();
        AppMethodBeat.o(75838);
    }

    public static void aLv(String str) {
        AppMethodBeat.i(237441);
        p.h(str, "sessionId");
        BXG = str;
        AppMethodBeat.o(237441);
    }

    public static void HY(long j2) {
        AppMethodBeat.i(237442);
        ik ikVar = new ik();
        ikVar.rq(j2);
        ikVar.wi(BXG);
        ikVar.bfK();
        AppMethodBeat.o(237442);
    }

    public static void aLw(String str) {
        AppMethodBeat.i(237443);
        p.h(str, "sessionId");
        BXH = str;
        AppMethodBeat.o(237443);
    }

    public static void eKZ() {
        AppMethodBeat.i(237444);
        ij ijVar = new ij();
        ijVar.ro(1);
        ijVar.wh(BXH);
        ijVar.bfK();
        AppMethodBeat.o(237444);
    }

    public static void HZ(long j2) {
        AppMethodBeat.i(237445);
        ij ijVar = new ij();
        ijVar.ro(2);
        ijVar.rp(j2);
        ijVar.wh(BXH);
        ijVar.bfK();
        AppMethodBeat.o(237445);
    }
}
