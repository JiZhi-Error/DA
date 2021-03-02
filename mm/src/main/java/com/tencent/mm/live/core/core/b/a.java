package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/live/core/core/model/CdnSwitchMode;", "", "(Ljava/lang/String;I)V", "MMLiveStreamSwitchMode_Fixed", "MMLiveStreamSwitchMode_Auto", "MMLiveStreamSwitchMode_ML", "plugin-core_release"})
public enum a {
    MMLiveStreamSwitchMode_Fixed,
    MMLiveStreamSwitchMode_Auto,
    MMLiveStreamSwitchMode_ML;

    static {
        AppMethodBeat.i(196444);
        AppMethodBeat.o(196444);
    }

    public static a valueOf(String str) {
        AppMethodBeat.i(196446);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(196446);
        return aVar;
    }
}
