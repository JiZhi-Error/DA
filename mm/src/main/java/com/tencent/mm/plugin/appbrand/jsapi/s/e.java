package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/pip/PipOrientationMode;", "", "(Ljava/lang/String;I)V", "LANDSCAPE", "PORTRAIT", "luggage-wxa-app_release"})
public enum e {
    LANDSCAPE,
    PORTRAIT;

    static {
        AppMethodBeat.i(219682);
        AppMethodBeat.o(219682);
    }

    public static e valueOf(String str) {
        AppMethodBeat.i(219684);
        e eVar = (e) Enum.valueOf(e.class, str);
        AppMethodBeat.o(219684);
        return eVar;
    }
}
