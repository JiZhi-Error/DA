package com.google.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a {
    AZTEC,
    CODABAR,
    CODE_39,
    CODE_93,
    CODE_128,
    DATA_MATRIX,
    EAN_8,
    EAN_13,
    ITF,
    MAXICODE,
    PDF_417,
    QR_CODE,
    RSS_14,
    RSS_EXPANDED,
    UPC_A,
    UPC_E,
    UPC_EAN_EXTENSION;

    public static a valueOf(String str) {
        AppMethodBeat.i(12227);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(12227);
        return aVar;
    }

    static {
        AppMethodBeat.i(12228);
        AppMethodBeat.o(12228);
    }
}
