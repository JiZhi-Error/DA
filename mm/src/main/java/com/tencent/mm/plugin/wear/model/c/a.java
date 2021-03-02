package com.tencent.mm.plugin.wear.model.c;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.cr;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.eys;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class a {
    public static final void jZ(int i2, int i3) {
        AppMethodBeat.i(30051);
        eys eys = com.tencent.mm.plugin.wear.model.a.fVM().IxH.Iyu;
        if (eys != null) {
            Log.v("MicroMsg.Wear.ReportKVUtil", "report kv operation=%d scene=%d", Integer.valueOf(i2), Integer.valueOf(i3));
            h.INSTANCE.a(11632, Integer.valueOf(i2), eys.oTJ, eys.Nvq, Integer.valueOf(i3));
        }
        AppMethodBeat.o(30051);
    }

    public static final void aff(int i2) {
        AppMethodBeat.i(30052);
        h.INSTANCE.idkeyStat(249, (long) i2, 1, false);
        AppMethodBeat.o(30052);
    }

    public static final void yJ(boolean z) {
        AppMethodBeat.i(30053);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(cr.CTRL_INDEX);
        iDKey.SetKey(12);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        if (z) {
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(cr.CTRL_INDEX);
            iDKey2.SetKey(13);
            iDKey2.SetValue(1);
            arrayList.add(iDKey2);
        }
        h.INSTANCE.b(arrayList, false);
        AppMethodBeat.o(30053);
    }
}
