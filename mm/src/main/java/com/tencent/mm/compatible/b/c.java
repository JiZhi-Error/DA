package com.tencent.mm.compatible.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {

    public enum a {
        PCM,
        AMR,
        SILK,
        SPEEX,
        UNKNOWN;

        public static a valueOf(String str) {
            AppMethodBeat.i(155550);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(155550);
            return aVar;
        }

        static {
            AppMethodBeat.i(155551);
            AppMethodBeat.o(155551);
        }
    }
}
