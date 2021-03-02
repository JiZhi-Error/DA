package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;

public final class v {
    private static v rDV = null;
    public MMHandler jkv = new MMHandler("MMExDevicePushCore");
    final HashMap<Long, Integer> rDW = new HashMap<>();

    private v() {
        AppMethodBeat.i(23698);
        AppMethodBeat.o(23698);
    }

    public static v cLz() {
        AppMethodBeat.i(23699);
        if (rDV == null) {
            rDV = new v();
        }
        v vVar = rDV;
        AppMethodBeat.o(23699);
        return vVar;
    }
}
