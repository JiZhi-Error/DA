package com.tencent.mm.live.core.mini;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/live/core/mini/LiveMiniState;", "", "(Ljava/lang/String;I)V", "STATE_NORMAL", "STATE_DISCONNECT", "STATE_FINISH", "plugin-core_release"})
public enum d {
    STATE_NORMAL,
    STATE_DISCONNECT,
    STATE_FINISH;

    static {
        AppMethodBeat.i(196593);
        AppMethodBeat.o(196593);
    }

    public static d valueOf(String str) {
        AppMethodBeat.i(196595);
        d dVar = (d) Enum.valueOf(d.class, str);
        AppMethodBeat.o(196595);
        return dVar;
    }
}
