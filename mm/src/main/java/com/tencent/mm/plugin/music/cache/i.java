package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.j;
import com.tencent.mm.sdk.platformtools.Log;

public final class i {
    public static boolean aHH(String str) {
        AppMethodBeat.i(137206);
        if (!h.aHG(str) || h.hv(str) <= 0) {
            AppMethodBeat.o(137206);
            return false;
        }
        AppMethodBeat.o(137206);
        return true;
    }

    public static boolean aHI(String str) {
        AppMethodBeat.i(198178);
        j aHs = e.aHs(g.aHy(str));
        if (aHs == null) {
            Log.e("MicroMsg.Audio.IndexBitMgr", "isQQAudioCacheValid pMusic is null!'");
            AppMethodBeat.o(198178);
            return false;
        } else if (!h.aHG(str) || h.hv(str) <= 0 || aHs.jfB != 1) {
            AppMethodBeat.o(198178);
            return false;
        } else {
            AppMethodBeat.o(198178);
            return true;
        }
    }
}
