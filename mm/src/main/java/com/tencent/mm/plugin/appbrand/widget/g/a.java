package com.tencent.mm.plugin.appbrand.widget.g;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.ArrayList;

public final class a {
    public static void d(int i2, long j2, long j3, int i3) {
        int i4;
        AppMethodBeat.i(73437);
        if (j2 <= 0 || j3 <= 0 || i3 <= 0) {
            AppMethodBeat.o(73437);
            return;
        }
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(703);
        iDKey.SetKey(i2 == 1 ? 3 : 0);
        iDKey.SetValue(j2);
        arrayList.add(iDKey);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(703);
        if (i2 == 1) {
            i4 = 4;
        } else {
            i4 = 1;
        }
        iDKey2.SetKey(i4);
        iDKey2.SetValue(j3);
        arrayList.add(iDKey2);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(703);
        iDKey3.SetKey(i2 == 1 ? 5 : 2);
        iDKey3.SetValue((long) i3);
        arrayList.add(iDKey3);
        h.INSTANCE.b(arrayList, false);
        AppMethodBeat.o(73437);
    }

    public static void J(int i2, long j2) {
        int i3;
        AppMethodBeat.i(73438);
        if (j2 <= 500000) {
            i3 = 0;
        } else if (j2 <= TimeUtil.SECOND_TO_US) {
            i3 = 1;
        } else if (j2 <= 2000000) {
            i3 = 2;
        } else if (j2 <= 3000000) {
            i3 = 3;
        } else if (j2 <= 4000000) {
            i3 = 4;
        } else if (j2 <= 5000000) {
            i3 = 5;
        } else {
            i3 = 6;
        }
        h.INSTANCE.idkeyStat((long) i2, (long) i3, 1, false);
        AppMethodBeat.o(73438);
    }

    public static void K(int i2, long j2) {
        int i3;
        AppMethodBeat.i(73439);
        if (j2 <= 20000000) {
            i3 = 0;
        } else if (j2 <= 25000000) {
            i3 = 1;
        } else if (j2 <= 30000000) {
            i3 = 2;
        } else if (j2 <= 35000000) {
            i3 = 3;
        } else if (j2 <= 40000000) {
            i3 = 4;
        } else if (j2 <= 50000000) {
            i3 = 5;
        } else if (j2 <= 60000000) {
            i3 = 6;
        } else if (j2 <= 70000000) {
            i3 = 7;
        } else if (j2 <= 80000000) {
            i3 = 8;
        } else {
            i3 = 9;
        }
        h.INSTANCE.idkeyStat((long) i2, (long) i3, 1, false);
        AppMethodBeat.o(73439);
    }
}
