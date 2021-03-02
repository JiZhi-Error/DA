package com.tencent.mm.pluginsdk.j.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class f extends IOException {
    public final IOException JZJ;
    public final int httpStatusCode;

    public f(int i2, IOException iOException) {
        this.httpStatusCode = i2;
        this.JZJ = iOException;
    }

    public final String toString() {
        AppMethodBeat.i(152010);
        String str = "UnknownConnectionError{httpStatusCode=" + this.httpStatusCode + ", realException=" + this.JZJ + '}';
        AppMethodBeat.o(152010);
        return str;
    }
}
