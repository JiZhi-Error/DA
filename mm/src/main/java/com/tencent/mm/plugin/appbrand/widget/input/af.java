package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface af {
    void a(String str, int i2, a aVar);

    public enum a {
        COMPLETE,
        CONFIRM,
        CHANGED;

        public static a valueOf(String str) {
            AppMethodBeat.i(131515);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(131515);
            return aVar;
        }

        static {
            AppMethodBeat.i(131516);
            AppMethodBeat.o(131516);
        }
    }
}
