package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.luggage.a.e;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.w.a;
import java.util.ArrayList;

public final class c {
    public static void pl(int i2) {
        AppMethodBeat.i(144491);
        ((a) e.N(a.class)).idkeyStat(762, (long) i2, 1, false);
        AppMethodBeat.o(144491);
    }

    public static void dY(int i2, int i3) {
        AppMethodBeat.i(144492);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(762);
        iDKey.SetKey(i2);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(762);
        iDKey2.SetKey(i3);
        iDKey2.SetValue(1);
        arrayList.add(iDKey2);
        ((a) e.N(a.class)).b(arrayList, true);
        AppMethodBeat.o(144492);
    }
}
