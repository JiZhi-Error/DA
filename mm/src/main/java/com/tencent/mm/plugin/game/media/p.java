package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.util.b;

public final class p {
    public static final String xCG = (b.c(b.a.ONE_WEEK) + "haowan/");

    static {
        AppMethodBeat.i(41173);
        AppMethodBeat.o(41173);
    }

    public enum a {
        FROM_PUBLISH_GALLERY,
        FROM_TAB_GALLERY;

        public static a valueOf(String str) {
            AppMethodBeat.i(41171);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(41171);
            return aVar;
        }

        static {
            AppMethodBeat.i(41172);
            AppMethodBeat.o(41172);
        }
    }
}
