package com.tencent.wcdb.extension.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.extension.SQLiteExtension;

public final class MMFtsTokenizer implements SQLiteExtension {
    public static final SQLiteExtension EXTENSION = new MMFtsTokenizer();

    private static native void nativeInitialize(long j2, long j3);

    static {
        AppMethodBeat.i(3327);
        AppMethodBeat.o(3327);
    }

    private MMFtsTokenizer() {
    }

    @Override // com.tencent.wcdb.extension.SQLiteExtension
    public final void initialize(long j2, long j3) {
        AppMethodBeat.i(3326);
        nativeInitialize(j2, j3);
        AppMethodBeat.o(3326);
    }
}
