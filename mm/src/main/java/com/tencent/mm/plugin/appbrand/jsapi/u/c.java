package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "", "(Ljava/lang/String;I)V", "ORIGIN", "NO_REFERRER", "luggage-commons_release"})
public enum c {
    ORIGIN,
    NO_REFERRER;

    static {
        AppMethodBeat.i(221363);
        AppMethodBeat.o(221363);
    }

    public static c valueOf(String str) {
        AppMethodBeat.i(221365);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(221365);
        return cVar;
    }
}
