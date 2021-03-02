package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public interface h {
    void a(String str, a aVar);

    public enum a {
        CANCEL,
        DELETE,
        SELECT;

        public static a valueOf(String str) {
            AppMethodBeat.i(136674);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(136674);
            return aVar;
        }

        static {
            AppMethodBeat.i(136675);
            AppMethodBeat.o(136675);
        }
    }
}
