package com.tencent.mm.pluginsdk.j.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class b extends IOException {
    private final long JZI;
    private final long contentLength;

    public b() {
        this(0, 0);
    }

    public b(long j2, long j3) {
        super(String.format("contentLength: %d, requestRange:%d", Long.valueOf(j2), Long.valueOf(j3)));
        AppMethodBeat.i(152008);
        this.contentLength = j2;
        this.JZI = j3;
        AppMethodBeat.o(152008);
    }

    public final String toString() {
        AppMethodBeat.i(152009);
        String str = "FileSizeOutOfRangeException{contentLength=" + this.contentLength + ", requestRange=" + this.JZI + '}';
        AppMethodBeat.o(152009);
        return str;
    }
}
