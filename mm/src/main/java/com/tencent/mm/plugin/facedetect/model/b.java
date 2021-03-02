package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    static boolean DE(long j2) {
        AppMethodBeat.i(103685);
        if (System.currentTimeMillis() - j2 > 200) {
            AppMethodBeat.o(103685);
            return true;
        }
        AppMethodBeat.o(103685);
        return false;
    }
}
