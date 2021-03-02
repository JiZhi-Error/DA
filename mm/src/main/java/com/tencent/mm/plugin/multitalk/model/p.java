package com.tencent.mm.plugin.multitalk.model;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;

public final class p {
    public static int zMn = 0;
    public static int zMo = 0;
    public static int zMp = 0;
    public static int zMq = 0;
    public static int zMr = 0;
    public static int zMs = 0;
    public static int zMt = 0;
    public static int zMu = 0;
    public static int zbi = 0;

    public static final void a(boolean z, long j2, String str) {
        AppMethodBeat.i(114442);
        Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectSuccess %b %d %s", Boolean.valueOf(z), Long.valueOf(j2), str);
        h.INSTANCE.idkeyStat(220, 34, 1, false);
        h.INSTANCE.a(12725, 1, Integer.valueOf(z ? 1 : 2), Long.valueOf(j2), str);
        AppMethodBeat.o(114442);
    }

    public static final void a(boolean z, long j2, String str, int i2) {
        int i3;
        AppMethodBeat.i(114443);
        Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectFail %b %d %s %d", Boolean.valueOf(z), Long.valueOf(j2), str, Integer.valueOf(i2));
        if (z) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        h.INSTANCE.a(12725, 2, Integer.valueOf(i3), Long.valueOf(j2), str, Integer.valueOf(i2));
        AppMethodBeat.o(114443);
    }

    public static final void emV() {
        AppMethodBeat.i(114444);
        Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailSuccess");
        h.INSTANCE.a(12722, 1);
        AppMethodBeat.o(114444);
    }

    public static final void emW() {
        AppMethodBeat.i(114445);
        Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailFail");
        h.INSTANCE.a(12722, 2);
        AppMethodBeat.o(114445);
    }

    public static final void bI(int i2, String str) {
        AppMethodBeat.i(114446);
        Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkReceiveCall %d %s", Integer.valueOf(i2), str);
        h.INSTANCE.a(12723, Integer.valueOf(i2), str);
        AppMethodBeat.o(114446);
    }

    public static final void z(long j2, String str) {
        AppMethodBeat.i(114447);
        Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMutliTalkDuration %d %s", Long.valueOf(j2), str);
        h.INSTANCE.a(12726, Long.valueOf(j2), str);
        AppMethodBeat.o(114447);
    }

    public static final void a(int i2, boolean z, int i3, String str, int i4) {
        int i5;
        AppMethodBeat.i(114448);
        Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkSelectContact %d %b %d %s %d", Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), str, Integer.valueOf(i4));
        if (z) {
            i5 = 1;
        } else {
            i5 = 2;
        }
        h.INSTANCE.a(12727, Integer.valueOf(i2), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i2), str, Integer.valueOf(i4));
        AppMethodBeat.o(114448);
    }

    public static final void A(long j2, String str) {
        AppMethodBeat.i(114449);
        long j3 = j2 > 1000 ? j2 / 1000 : 1;
        Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkVideoDuration %d %s", Long.valueOf(j3), str);
        h.INSTANCE.a(12728, Long.valueOf(j3), str);
        AppMethodBeat.o(114449);
    }

    public static final void aFV(String str) {
        AppMethodBeat.i(114450);
        Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkFunction %s %d %d %d %d %d,%d,%d,%d,%d", str, Integer.valueOf(zMn), Integer.valueOf(zMo), Integer.valueOf(zMp), Integer.valueOf(zbi), Integer.valueOf(zMq), Integer.valueOf(zMr), Integer.valueOf(zMs), Integer.valueOf(zMt), Integer.valueOf(zMu));
        h.INSTANCE.a(12729, str, Integer.valueOf(zMn), Integer.valueOf(zMo), Integer.valueOf(zMp), Integer.valueOf(zbi), Integer.valueOf(zMq), Integer.valueOf(zMr), Integer.valueOf(zMs), Integer.valueOf(zMt), Integer.valueOf(zMu));
        hi(9, zMn);
        hi(10, zMq);
        hi(11, zMo);
        hi(12, zMp);
        hi(13, zbi);
        zMn = 0;
        zMo = 0;
        zMp = 0;
        zbi = 0;
        zMq = 0;
        zMr = 0;
        zMs = 0;
        zMt = 0;
        zMu = 0;
        AppMethodBeat.o(114450);
    }

    public static final void j(String str, boolean z, boolean z2) {
        AppMethodBeat.i(114451);
        if (z && z2) {
            h.INSTANCE.a(12917, str, 2, 1);
            AppMethodBeat.o(114451);
        } else if (z) {
            h.INSTANCE.a(12917, str, 2, 2);
            AppMethodBeat.o(114451);
        } else if (z2) {
            h.INSTANCE.a(12917, str, 1, 1);
            AppMethodBeat.o(114451);
        } else {
            h.INSTANCE.a(12917, str, 1, 2);
            AppMethodBeat.o(114451);
        }
    }

    public static final void iO(String str, String str2) {
        AppMethodBeat.i(114452);
        Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkGroupId %s %s", str2, str);
        h.INSTANCE.a(17771, 0, 0, str2, str);
        AppMethodBeat.o(114452);
    }

    public static final void n(int i2, String str, int i3) {
        AppMethodBeat.i(178878);
        Log.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkMoreArrowClick %s,%s, %s", Integer.valueOf(i2), str, Integer.valueOf(i3));
        h.INSTANCE.a(19424, Integer.valueOf(i2), 0, Integer.valueOf(i3), str);
        AppMethodBeat.o(178878);
    }

    public static final void n(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(239365);
        Log.i("MicroMsg.MT.MultiTalkKvReportUtil", "reportScreenProjectFuncReport %s,%s, %s,%s", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        h.INSTANCE.a(21344, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(239365);
    }

    public static final void Re(int i2) {
        AppMethodBeat.i(178879);
        h.INSTANCE.idkeyStat(220, 35, 1, false);
        h.INSTANCE.idkeyStat(220, 36, (long) i2, false);
        AppMethodBeat.o(178879);
    }

    public static final void emX() {
        AppMethodBeat.i(178880);
        h.INSTANCE.idkeyStat(220, 27, 1, false);
        AppMethodBeat.o(178880);
    }

    public static final void emY() {
        AppMethodBeat.i(178881);
        h.INSTANCE.idkeyStat(220, 26, 1, false);
        AppMethodBeat.o(178881);
    }

    public static final void rC(boolean z) {
        AppMethodBeat.i(178882);
        if (z) {
            h.INSTANCE.idkeyStat(220, 21, 1, false);
            AppMethodBeat.o(178882);
            return;
        }
        h.INSTANCE.idkeyStat(220, 22, 1, false);
        AppMethodBeat.o(178882);
    }

    public static final void Rf(int i2) {
        AppMethodBeat.i(178883);
        h.INSTANCE.idkeyStat(220, 23, 1, false);
        h.INSTANCE.idkeyStat(220, 24, (long) i2, false);
        AppMethodBeat.o(178883);
    }

    public static final void Rg(int i2) {
        AppMethodBeat.i(178884);
        h.INSTANCE.idkeyStat(220, 19, 1, false);
        h.INSTANCE.idkeyStat(220, 20, (long) i2, false);
        AppMethodBeat.o(178884);
    }

    public static final void rD(boolean z) {
        AppMethodBeat.i(178885);
        if (z) {
            h.INSTANCE.idkeyStat(220, 30, 1, false);
            AppMethodBeat.o(178885);
            return;
        }
        h.INSTANCE.idkeyStat(220, 31, 1, false);
        AppMethodBeat.o(178885);
    }

    public static final void rE(boolean z) {
        AppMethodBeat.i(178886);
        if (z) {
            h.INSTANCE.idkeyStat(220, 33, 1, false);
            AppMethodBeat.o(178886);
            return;
        }
        h.INSTANCE.idkeyStat(220, 32, 1, false);
        AppMethodBeat.o(178886);
    }

    public static final void emZ() {
        AppMethodBeat.i(178887);
        h.INSTANCE.idkeyStat(220, 25, 1, false);
        AppMethodBeat.o(178887);
    }

    public static final void ena() {
        AppMethodBeat.i(114453);
        h.INSTANCE.idkeyStat(220, 0, 1, false);
        AppMethodBeat.o(114453);
    }

    public static final void rF(boolean z) {
        AppMethodBeat.i(114454);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS);
        iDKey.SetKey(3);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        if (z) {
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS);
            iDKey2.SetKey(4);
            iDKey2.SetValue(1);
            arrayList.add(iDKey2);
        }
        h.INSTANCE.b(arrayList, false);
        AppMethodBeat.o(114454);
    }

    public static final void enb() {
        AppMethodBeat.i(114455);
        h.INSTANCE.idkeyStat(220, 1, 1, false);
        AppMethodBeat.o(114455);
    }

    public static final void rG(boolean z) {
        AppMethodBeat.i(114456);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS);
        iDKey.SetKey(5);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        if (z) {
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS);
            iDKey2.SetKey(6);
            iDKey2.SetValue(1);
            arrayList.add(iDKey2);
        }
        h.INSTANCE.b(arrayList, false);
        AppMethodBeat.o(114456);
    }

    public static final void Rh(int i2) {
        AppMethodBeat.i(114457);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS);
        iDKey.SetKey(7);
        iDKey.SetValue((long) i2);
        arrayList.add(iDKey);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS);
        iDKey2.SetKey(8);
        iDKey2.SetValue(1);
        arrayList.add(iDKey2);
        h.INSTANCE.b(arrayList, false);
        AppMethodBeat.o(114457);
    }

    private static void hi(int i2, int i3) {
        AppMethodBeat.i(114458);
        h.INSTANCE.idkeyStat(220, (long) i2, (long) i3, false);
        AppMethodBeat.o(114458);
    }

    public static final void enc() {
        AppMethodBeat.i(114459);
        h.INSTANCE.a(14849, 1);
        AppMethodBeat.o(114459);
    }

    public static final void ene() {
        AppMethodBeat.i(114460);
        h.INSTANCE.a(14849, 2);
        AppMethodBeat.o(114460);
    }

    public static final void enf() {
        AppMethodBeat.i(114461);
        h.INSTANCE.a(14849, 3);
        AppMethodBeat.o(114461);
    }

    public static final void eng() {
        AppMethodBeat.i(114462);
        h.INSTANCE.a(14849, 4);
        AppMethodBeat.o(114462);
    }

    public static final void enh() {
        AppMethodBeat.i(114463);
        h.INSTANCE.a(14849, 5);
        AppMethodBeat.o(114463);
    }

    public static final void eni() {
        AppMethodBeat.i(114464);
        h.INSTANCE.a(14849, 6);
        AppMethodBeat.o(114464);
    }

    public static final void enj() {
        AppMethodBeat.i(114465);
        h.INSTANCE.a(14849, 7);
        AppMethodBeat.o(114465);
    }

    public static final void enk() {
        AppMethodBeat.i(114466);
        h.INSTANCE.a(14849, 8);
        AppMethodBeat.o(114466);
    }

    public static final void enl() {
        AppMethodBeat.i(114467);
        h.INSTANCE.a(14849, 9);
        AppMethodBeat.o(114467);
    }
}
