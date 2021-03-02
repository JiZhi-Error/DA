package com.tencent.luggage.sdk.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public interface d {
    public static final d czi = new d() {
        /* class com.tencent.luggage.sdk.config.d.AnonymousClass1 */

        @Override // com.tencent.luggage.sdk.config.d
        public final String NJ() {
            AppMethodBeat.i(229829);
            String str = "SessionId@" + hashCode() + "#" + Util.nowMilliSecond();
            AppMethodBeat.o(229829);
            return str;
        }
    };

    public static class a {
        public static d czj;
    }

    String NJ();
}
