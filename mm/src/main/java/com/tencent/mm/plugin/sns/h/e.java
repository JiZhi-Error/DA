package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.c;

public final class e {
    public static void aPM(String str) {
        AppMethodBeat.i(96132);
        Log.i("MicroMsg.SnsABTestStrategy", "dump id ".concat(String.valueOf(str)));
        c Fu = d.aXu().Fu(str);
        if (!Fu.isValid()) {
            Log.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
        }
        if (Fu.gzz() != null) {
            Log.i("MicroMsg.SnsABTestStrategy", "dump feed abtest " + Fu.field_rawXML);
        }
        AppMethodBeat.o(96132);
    }
}
