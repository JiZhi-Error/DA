package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b {
    AUTO(0),
    MIC(1),
    CAMCORDER(5),
    VOICE_RECOGNITION(6),
    VOICE_COMMUNICATION(7),
    UNPROCESSED(9);
    
    public int mFN;

    public static b valueOf(String str) {
        AppMethodBeat.i(146316);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(146316);
        return bVar;
    }

    static {
        AppMethodBeat.i(146318);
        AppMethodBeat.o(146318);
    }

    private b(int i2) {
        this.mFN = i2;
    }

    public static b a(String str, b bVar) {
        AppMethodBeat.i(146317);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(146317);
            return bVar;
        }
        b bVar2 = null;
        try {
            bVar2 = valueOf(str);
        } catch (Exception e2) {
        }
        if (bVar2 != null) {
            AppMethodBeat.o(146317);
            return bVar2;
        }
        AppMethodBeat.o(146317);
        return bVar;
    }
}
