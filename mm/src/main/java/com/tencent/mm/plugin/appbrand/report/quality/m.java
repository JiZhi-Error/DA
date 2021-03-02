package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m {
    public volatile a nLJ = a.INVALID;

    public enum a {
        INVALID,
        _2D,
        WEBGL,
        GFX;

        public static a valueOf(String str) {
            AppMethodBeat.i(48235);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(48235);
            return aVar;
        }

        static {
            AppMethodBeat.i(48236);
            AppMethodBeat.o(48236);
        }
    }
}
