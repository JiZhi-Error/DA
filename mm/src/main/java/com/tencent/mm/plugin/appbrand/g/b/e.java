package com.tencent.mm.plugin.appbrand.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e {
    public a lkh = a.NoMediaPresent;
    public int progress = 0;
    public int volume = 0;

    public enum a {
        NoMediaPresent,
        Stopped,
        Transitioning,
        Playing,
        Paused;

        public static a valueOf(String str) {
            AppMethodBeat.i(158943);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(158943);
            return aVar;
        }

        static {
            AppMethodBeat.i(158944);
            AppMethodBeat.o(158944);
        }
    }
}
