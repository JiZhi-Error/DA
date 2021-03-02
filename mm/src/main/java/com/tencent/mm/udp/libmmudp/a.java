package com.tencent.mm.udp.libmmudp;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static AbstractC2070a Owr = new AbstractC2070a() {
        /* class com.tencent.mm.udp.libmmudp.a.AnonymousClass1 */

        @Override // com.tencent.mm.udp.libmmudp.a.AbstractC2070a
        public final void loadLibrary(String str) {
            AppMethodBeat.i(62485);
            System.loadLibrary(str);
            AppMethodBeat.o(62485);
        }
    };

    /* renamed from: com.tencent.mm.udp.libmmudp.a$a  reason: collision with other inner class name */
    public interface AbstractC2070a {
        void loadLibrary(String str);
    }

    static {
        AppMethodBeat.i(62487);
        AppMethodBeat.o(62487);
    }

    public static void a(AbstractC2070a aVar) {
        Owr = aVar;
    }

    public static void loadLibraries() {
        AppMethodBeat.i(62486);
        Owr.loadLibrary("mmudp");
        AppMethodBeat.o(62486);
    }
}
