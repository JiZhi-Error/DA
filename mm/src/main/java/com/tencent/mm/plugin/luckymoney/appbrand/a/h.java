package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h {

    public enum a {
        RANDOM_LUCK(1),
        FIX_NORMAL(0);
        
        public final int cND;

        public static a valueOf(String str) {
            AppMethodBeat.i(64888);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(64888);
            return aVar;
        }

        static {
            AppMethodBeat.i(64889);
            AppMethodBeat.o(64889);
        }

        private a(int i2) {
            this.cND = i2;
        }
    }
}
