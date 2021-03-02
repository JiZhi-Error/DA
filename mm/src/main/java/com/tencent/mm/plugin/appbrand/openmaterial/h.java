package com.tencent.mm.plugin.appbrand.openmaterial;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface h extends com.tencent.mm.vending.e.a {
    public static final h nli = new h() {
        /* class com.tencent.mm.plugin.appbrand.openmaterial.h.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.openmaterial.h
        public final void a(a aVar) {
        }

        @Override // com.tencent.mm.vending.e.a
        public final void dead() {
        }
    };

    void a(a aVar);

    public enum a {
        ENABLE,
        DISABLE,
        HIDE;

        public static a valueOf(String str) {
            AppMethodBeat.i(261695);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(261695);
            return aVar;
        }

        static {
            AppMethodBeat.i(261696);
            AppMethodBeat.o(261696);
        }
    }
}
