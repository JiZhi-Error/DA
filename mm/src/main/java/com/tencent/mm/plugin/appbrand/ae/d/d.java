package com.tencent.mm.plugin.appbrand.ae.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public interface d {
    ByteBuffer bZH();

    boolean bZI();

    boolean bZJ();

    a bZK();

    void e(d dVar);

    public enum a {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING;

        public static a valueOf(String str) {
            AppMethodBeat.i(156658);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(156658);
            return aVar;
        }

        static {
            AppMethodBeat.i(156659);
            AppMethodBeat.o(156659);
        }
    }
}
