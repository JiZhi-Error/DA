package com.tencent.mm.websocket.libwcwss;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static AbstractC2172a Rww = new AbstractC2172a() {
        /* class com.tencent.mm.websocket.libwcwss.a.AnonymousClass1 */

        @Override // com.tencent.mm.websocket.libwcwss.a.AbstractC2172a
        public final void loadLibrary(String str) {
            AppMethodBeat.i(3488);
            System.loadLibrary(str);
            AppMethodBeat.o(3488);
        }
    };

    /* renamed from: com.tencent.mm.websocket.libwcwss.a$a  reason: collision with other inner class name */
    public interface AbstractC2172a {
        void loadLibrary(String str);
    }

    static {
        AppMethodBeat.i(3490);
        AppMethodBeat.o(3490);
    }

    public static void a(AbstractC2172a aVar) {
        Rww = aVar;
    }

    public static void loadLibraries() {
        AppMethodBeat.i(3489);
        Rww.loadLibrary("mmwcwss");
        AppMethodBeat.o(3489);
    }
}
