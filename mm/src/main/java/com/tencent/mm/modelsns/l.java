package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;

public final class l {
    public static int jlv = 0;
    public static l jlw = new l();

    static {
        AppMethodBeat.i(125681);
        AppMethodBeat.o(125681);
    }

    public static void bfL() {
        AppMethodBeat.i(125680);
        c Fu = d.aXu().Fu("100024");
        Log.i("MicroMsg.StatisticsOplogAbTest", "test " + Fu.field_rawXML + " " + Fu.isValid());
        if (Fu.isValid()) {
            jlv = Util.safeParseInt(Fu.gzz().get("Switch"));
            Log.i("MicroMsg.StatisticsOplogAbTest", "switchVal " + jlv);
        }
        AppMethodBeat.o(125680);
    }
}
