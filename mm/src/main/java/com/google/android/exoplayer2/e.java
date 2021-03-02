package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class e extends Exception {
    public final int bbY;
    public final int type;

    public static e b(Exception exc, int i2) {
        AppMethodBeat.i(91883);
        e eVar = new e(1, exc, i2);
        AppMethodBeat.o(91883);
        return eVar;
    }

    public static e a(IOException iOException) {
        AppMethodBeat.i(91884);
        e eVar = new e(0, iOException, -1);
        AppMethodBeat.o(91884);
        return eVar;
    }

    static e a(RuntimeException runtimeException) {
        AppMethodBeat.i(91885);
        e eVar = new e(2, runtimeException, -1);
        AppMethodBeat.o(91885);
        return eVar;
    }

    private e(int i2, Throwable th, int i3) {
        super(null, th);
        this.type = i2;
        this.bbY = i3;
    }
}
