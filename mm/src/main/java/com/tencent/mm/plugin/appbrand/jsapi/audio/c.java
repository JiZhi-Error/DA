package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import java.util.HashMap;
import java.util.Map;

public enum c {
    INSTANCE;
    
    private Map<String, a> lDI = new HashMap(2);

    private c(String str) {
        AppMethodBeat.i(256420);
        AppMethodBeat.o(256420);
    }

    public static c valueOf(String str) {
        AppMethodBeat.i(256419);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(256419);
        return cVar;
    }

    static {
        AppMethodBeat.i(256422);
        AppMethodBeat.o(256422);
    }

    public final a Zm(String str) {
        AppMethodBeat.i(256421);
        if (!this.lDI.containsKey(str)) {
            this.lDI.put(str, new a());
        }
        a aVar = this.lDI.get(str);
        AppMethodBeat.o(256421);
        return aVar;
    }
}
