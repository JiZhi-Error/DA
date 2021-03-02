package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;

public final class o {

    public enum a {
        GUIDE_EXPOSE(1),
        GUIDE_CLOSE(2),
        TO_APP_LAUNCHER(3),
        GUIDE_CLOSE_BY_BACK(4);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(48170);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(48170);
            return aVar;
        }

        static {
            AppMethodBeat.i(48171);
            AppMethodBeat.o(48171);
        }

        private a(int i2) {
            this.value = i2;
        }
    }

    public static void a(a aVar, String str) {
        AppMethodBeat.i(48172);
        e.INSTANCE.a(14750, Integer.valueOf(aVar.value), str);
        AppMethodBeat.o(48172);
    }
}
