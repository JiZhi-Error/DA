package com.tencent.mm.plugin.fts.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.coremedia.TimeUtil;
import java.math.BigInteger;
import java.util.ArrayList;

public final class e {
    public static final int[] wVk = {8, 9, 10, 11, 12, 14, 19, 20, 21, 22, 24, 25, 26, 15, 28, 29};
    public static final a wVl = new a();
    public static long wVm = 0;
    public static long wVn = 0;

    public static final class a {
        public long wVo = 0;
        public long wVp = 0;
        public long wVq = 0;
        public long wVr = 0;
        public long wVs = 0;
    }

    static {
        AppMethodBeat.i(131651);
        AppMethodBeat.o(131651);
    }

    public static final void l(int i2, long j2, long j3) {
        int i3;
        AppMethodBeat.i(131644);
        if (!d.f(i2, wVk)) {
            AppMethodBeat.o(131644);
            return;
        }
        g.aAf();
        long longValue = new p(com.tencent.mm.kernel.a.getUin()).longValue();
        if (d.KyP) {
            if (longValue % 100 != 1) {
                AppMethodBeat.o(131644);
                return;
            }
        } else if (d.KyQ && longValue % 10 != 1) {
            AppMethodBeat.o(131644);
            return;
        }
        Object[] objArr = new Object[11];
        objArr[0] = 0;
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Long.valueOf(j2);
        objArr[3] = 0;
        if (wVl.wVo >= 1536) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        objArr[4] = Integer.valueOf(i3);
        objArr[5] = Long.valueOf(wVl.wVo);
        objArr[6] = Long.valueOf(wVl.wVp);
        objArr[7] = Long.valueOf(wVl.wVq);
        objArr[8] = Long.valueOf(wVl.wVr);
        objArr[9] = Long.valueOf(wVl.wVs);
        objArr[10] = Long.valueOf(j3);
        String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", objArr);
        Log.v("MicroMsg.FTS.FTSReportApiLogic", "reportKVSearchTime: %d %s", 14175, format);
        com.tencent.mm.plugin.report.e.INSTANCE.kvStat(14175, format);
        AppMethodBeat.o(131644);
    }

    public static void am(int i2, long j2) {
        AppMethodBeat.i(131645);
        if (i2 > 0) {
            int i3 = ((i2 - 1) * 2) + 1;
            Log.v("MicroMsg.FTS.FTSReportApiLogic", "reportIDKeySearchTime: reportKey=%d taskId=%d time=%d", Integer.valueOf(i3), Integer.valueOf(i2), Long.valueOf(j2));
            ArrayList<IDKey> arrayList = new ArrayList<>();
            IDKey iDKey = new IDKey();
            iDKey.SetID(601);
            iDKey.SetKey(i3);
            iDKey.SetValue((long) ((int) j2));
            arrayList.add(iDKey);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(601);
            iDKey2.SetKey(i3 + 1);
            iDKey2.SetValue(1);
            arrayList.add(iDKey2);
            com.tencent.mm.plugin.report.e.INSTANCE.b(arrayList, false);
        }
        AppMethodBeat.o(131645);
    }

    public static void an(int i2, long j2) {
        AppMethodBeat.i(131646);
        if (i2 > 0) {
            int i3 = ((i2 - 1) * 4) + 1;
            ArrayList<IDKey> arrayList = new ArrayList<>();
            IDKey iDKey = new IDKey();
            iDKey.SetID(602);
            iDKey.SetKey(i3);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            if (j2 <= 100) {
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(602);
                iDKey2.SetKey(i3 + 1);
                iDKey2.SetValue(1);
                arrayList.add(iDKey2);
            } else if (j2 <= 500) {
                IDKey iDKey3 = new IDKey();
                iDKey3.SetID(602);
                iDKey3.SetKey(i3 + 2);
                iDKey3.SetValue(1);
                arrayList.add(iDKey3);
            } else {
                IDKey iDKey4 = new IDKey();
                iDKey4.SetID(602);
                iDKey4.SetKey(i3 + 3);
                iDKey4.SetValue(1);
                arrayList.add(iDKey4);
            }
            com.tencent.mm.plugin.report.e.INSTANCE.b(arrayList, false);
        }
        AppMethodBeat.o(131646);
    }

    public static void Nk(int i2) {
        AppMethodBeat.i(131647);
        IDKey iDKey = new IDKey();
        iDKey.SetID(146);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        arrayList.add(iDKey);
        if (i2 != 1) {
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(146);
            iDKey2.SetKey(2);
            iDKey2.SetValue(1);
            arrayList.add(iDKey2);
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(146);
            iDKey3.SetKey(i2);
            iDKey3.SetValue(1);
            arrayList.add(iDKey3);
        } else {
            IDKey iDKey4 = new IDKey();
            iDKey4.SetID(146);
            iDKey4.SetKey(1);
            iDKey4.SetValue(1);
            arrayList.add(iDKey4);
        }
        com.tencent.mm.plugin.report.e.INSTANCE.b(arrayList, false);
        AppMethodBeat.o(131647);
    }

    public static final void Nl(int i2) {
        AppMethodBeat.i(131648);
        Log.i("MicroMsg.FTS.FTSReportApiLogic", "reportCommonChatroom: %d %d", 14731, Integer.valueOf(i2));
        com.tencent.mm.plugin.report.e.INSTANCE.a(14731, Integer.valueOf(i2));
        AppMethodBeat.o(131648);
    }

    public static final void dOx() {
        AppMethodBeat.i(131649);
        Log.i("MicroMsg.FTS.FTSReportApiLogic", "reportIDKeyFTSData %d %d %d %d %d", Long.valueOf(wVl.wVo), Long.valueOf(wVl.wVp), Long.valueOf(wVl.wVq), Long.valueOf(wVl.wVs), Long.valueOf(wVl.wVr));
        ArrayList<IDKey> arrayList = new ArrayList<>();
        d(arrayList, 0);
        if (wVl.wVo > 1536) {
            d(arrayList, 1);
        }
        if (wVl.wVp >= 10000) {
            d(arrayList, 2);
        }
        if (wVl.wVq >= 5000) {
            d(arrayList, 3);
        }
        if (wVl.wVs >= 10000) {
            d(arrayList, 4);
        }
        if (wVl.wVr >= TimeUtil.SECOND_TO_US) {
            d(arrayList, 5);
        }
        com.tencent.mm.plugin.report.e.INSTANCE.b(arrayList, false);
        AppMethodBeat.o(131649);
    }

    private static final void d(ArrayList<IDKey> arrayList, int i2) {
        AppMethodBeat.i(131650);
        IDKey iDKey = new IDKey();
        iDKey.SetID(729);
        iDKey.SetKey(i2);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        AppMethodBeat.o(131650);
    }

    public static String dOy() {
        AppMethodBeat.i(206891);
        String GD = GD(wVm);
        AppMethodBeat.o(206891);
        return GD;
    }

    public static String GD(long j2) {
        AppMethodBeat.i(206892);
        String bigInteger = new BigInteger(Long.toBinaryString(j2), 2).toString();
        AppMethodBeat.o(206892);
        return bigInteger;
    }
}
