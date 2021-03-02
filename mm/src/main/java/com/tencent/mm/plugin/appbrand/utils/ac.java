package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "", "(Ljava/lang/String;I)V", "UNSPECIFIED", "PORTRAIT", "LANDSCAPE", "luggage-commons-jsapi-default-impl_release"})
public enum ac {
    UNSPECIFIED,
    PORTRAIT,
    LANDSCAPE;

    static {
        AppMethodBeat.i(193749);
        AppMethodBeat.o(193749);
    }

    public static ac valueOf(String str) {
        AppMethodBeat.i(193751);
        ac acVar = (ac) Enum.valueOf(ac.class, str);
        AppMethodBeat.o(193751);
        return acVar;
    }
}
