package com.tencent.mm.plugin.topstory.a.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.di;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

public final class b {
    public static void fxU() {
        AppMethodBeat.i(91001);
        try {
            ArrayList<IDKey> arrayList = new ArrayList<>();
            IDKey iDKey = new IDKey();
            iDKey.SetID(di.CTRL_INDEX);
            iDKey.SetValue(1);
            iDKey.SetKey(0);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(di.CTRL_INDEX);
            iDKey2.SetValue(1);
            iDKey2.SetKey(1);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            h.INSTANCE.b(arrayList, false);
            AppMethodBeat.o(91001);
        } catch (Throwable th) {
            AppMethodBeat.o(91001);
        }
    }
}
