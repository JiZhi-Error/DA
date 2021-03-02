package com.google.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c {
    ERROR_CORRECTION,
    CHARACTER_SET,
    DATA_MATRIX_SHAPE,
    MIN_SIZE,
    MAX_SIZE,
    MARGIN,
    PDF417_COMPACT,
    PDF417_COMPACTION,
    PDF417_DIMENSIONS,
    AZTEC_LAYERS,
    QR_VERSION;

    public static c valueOf(String str) {
        AppMethodBeat.i(12215);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(12215);
        return cVar;
    }

    static {
        AppMethodBeat.i(12216);
        AppMethodBeat.o(12216);
    }
}
