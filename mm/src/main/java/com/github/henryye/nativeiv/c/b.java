package com.github.henryye.nativeiv.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;

public final class b {
    public static void b(Closeable closeable) {
        AppMethodBeat.i(127394);
        try {
            closeable.close();
            AppMethodBeat.o(127394);
        } catch (IOException | IllegalStateException e2) {
            AppMethodBeat.o(127394);
        }
    }
}
