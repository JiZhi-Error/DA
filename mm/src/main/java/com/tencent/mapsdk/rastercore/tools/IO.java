package com.tencent.mapsdk.rastercore.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;

public class IO {
    public static final void safeClose(Closeable closeable) {
        AppMethodBeat.i(217191);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.o(217191);
                return;
            } catch (IOException e2) {
            }
        }
        AppMethodBeat.o(217191);
    }
}
