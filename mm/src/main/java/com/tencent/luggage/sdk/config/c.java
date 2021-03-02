package com.tencent.luggage.sdk.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.sdk.platformtools.Util;

public interface c {
    public static final c czg = new c() {
        /* class com.tencent.luggage.sdk.config.c.AnonymousClass1 */

        @Override // com.tencent.luggage.sdk.config.c
        public final String NI() {
            AppMethodBeat.i(229828);
            String str = p.getString(hashCode()) + "_" + Util.nowMilliSecond();
            AppMethodBeat.o(229828);
            return str;
        }
    };

    public static class a {
        public static c czh;
    }

    String NI();
}
