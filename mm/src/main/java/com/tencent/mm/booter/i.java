package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class i {
    public static boolean akM() {
        AppMethodBeat.i(19886);
        try {
            bg.aVF();
            Util.nullAs((Long) c.azQ().get(66817, (Object) null), 0);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.PostTaskMediaNoteStat", e2, "", new Object[0]);
        }
        if (Util.secondsToNow(0) * 1000 > 1800000) {
            AppMethodBeat.o(19886);
            return true;
        }
        AppMethodBeat.o(19886);
        return false;
    }
}
