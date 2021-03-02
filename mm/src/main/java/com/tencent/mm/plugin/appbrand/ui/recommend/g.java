package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bud;
import java.util.ArrayList;
import java.util.Iterator;

public final class g {
    public static void a(long j2, bud bud) {
        int i2;
        AppMethodBeat.i(49297);
        if (bud == null || bud.MaR == null) {
            i2 = 0;
        } else {
            i2 = bud.MaR.size();
        }
        b.i("MicroMsg.Recommend.AppBrandRecommendIdkeyReport", "doReportCgiGet costTime:%d, list size:%d", Long.valueOf(j2), Integer.valueOf(i2));
        IDKey iDKey = new IDKey();
        iDKey.SetID(1043);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        arrayList.add(iDKey);
        if (bud == null) {
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(1043);
            iDKey2.SetKey(1);
            iDKey2.SetValue(1);
            arrayList.add(iDKey2);
        } else if (bud.MaR == null || bud.MaR.size() == 0) {
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(1043);
            iDKey3.SetKey(2);
            iDKey3.SetValue(1);
            arrayList.add(iDKey3);
        } else {
            IDKey iDKey4 = new IDKey();
            iDKey4.SetID(1043);
            iDKey4.SetKey(3);
            iDKey4.SetValue(1);
            arrayList.add(iDKey4);
        }
        IDKey iDKey5 = new IDKey();
        iDKey5.SetID(1043);
        iDKey5.SetKey(5);
        iDKey5.SetValue(1);
        arrayList.add(iDKey5);
        IDKey iDKey6 = new IDKey();
        iDKey6.SetID(1043);
        iDKey6.SetKey(Bq(j2));
        iDKey6.SetValue(1);
        arrayList.add(iDKey6);
        h.INSTANCE.b(arrayList, true);
        M(arrayList);
        AppMethodBeat.o(49297);
    }

    private static int Bq(long j2) {
        if (j2 <= 1) {
            return 6;
        }
        if (1 < j2 && j2 <= 3) {
            return 7;
        }
        if (3 < j2 && j2 <= 5) {
            return 8;
        }
        if (5 < j2 && j2 <= 10) {
            return 9;
        }
        if (10 >= j2 || j2 > 20) {
            return 11;
        }
        return 10;
    }

    public static void zz(int i2) {
        AppMethodBeat.i(49298);
        b.i("MicroMsg.Recommend.AppBrandRecommendIdkeyReport", "doReportDataSource");
        IDKey iDKey = new IDKey();
        iDKey.SetID(1043);
        iDKey.SetKey(18);
        iDKey.SetValue(1);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        arrayList.add(iDKey);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(1043);
        if (i2 == 1) {
            iDKey2.SetKey(19);
        } else {
            iDKey2.SetKey(20);
        }
        iDKey2.SetValue(1);
        arrayList.add(iDKey2);
        h.INSTANCE.b(arrayList, true);
        M(arrayList);
        AppMethodBeat.o(49298);
    }

    private static void M(ArrayList<IDKey> arrayList) {
        AppMethodBeat.i(49299);
        StringBuilder sb = new StringBuilder();
        sb.append("idkeyGroupStat:  id:1043");
        Iterator<IDKey> it = arrayList.iterator();
        while (it.hasNext()) {
            IDKey next = it.next();
            sb.append(", key:" + next.GetKey() + " value:" + next.GetValue());
        }
        b.i("MicroMsg.Recommend.AppBrandRecommendIdkeyReport", sb.toString());
        AppMethodBeat.o(49299);
    }
}
