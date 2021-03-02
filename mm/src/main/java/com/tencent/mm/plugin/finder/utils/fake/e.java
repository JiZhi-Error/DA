package com.tencent.mm.plugin.finder.utils.fake;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/fake/GiftType;", "", "(Ljava/lang/String;I)V", "LOVE", "CLAP", "FLOWER", "HEYTEA", "CALL666", "ROCKET", "ISLAND", "plugin-finder_release"})
public enum e {
    LOVE,
    CLAP,
    FLOWER,
    HEYTEA,
    CALL666,
    ROCKET,
    ISLAND;

    static {
        AppMethodBeat.i(253857);
        AppMethodBeat.o(253857);
    }

    public static e valueOf(String str) {
        AppMethodBeat.i(253859);
        e eVar = (e) Enum.valueOf(e.class, str);
        AppMethodBeat.o(253859);
        return eVar;
    }
}
