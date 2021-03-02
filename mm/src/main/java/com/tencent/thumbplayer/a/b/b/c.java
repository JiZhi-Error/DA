package com.tencent.thumbplayer.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.b;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;

public final class c {
    public static boolean d(b bVar) {
        AppMethodBeat.i(189007);
        if (bVar == null) {
            AppMethodBeat.o(189007);
            return true;
        } else if (bVar.RVk == 0) {
            AppMethodBeat.o(189007);
            return true;
        } else if (g(bVar) || f(bVar)) {
            AppMethodBeat.o(189007);
            return true;
        } else {
            AppMethodBeat.o(189007);
            return false;
        }
    }

    private static boolean f(b bVar) {
        AppMethodBeat.i(189009);
        boolean isVCodecCapabilitySupport = TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(102, bVar.RVk, (int) bVar.width, (int) bVar.height, bVar.RVj, bVar.RVp);
        AppMethodBeat.o(189009);
        return isVCodecCapabilitySupport;
    }

    private static boolean g(b bVar) {
        AppMethodBeat.i(189010);
        boolean isVCodecCapabilitySupport = TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(101, bVar.RVk, (int) bVar.width, (int) bVar.height, bVar.RVj, bVar.RVp);
        AppMethodBeat.o(189010);
        return isVCodecCapabilitySupport;
    }

    public static boolean e(b bVar) {
        AppMethodBeat.i(189008);
        if (bVar.RVk == 0) {
            AppMethodBeat.o(189008);
            return true;
        }
        boolean f2 = f(bVar);
        AppMethodBeat.o(189008);
        return f2;
    }
}
