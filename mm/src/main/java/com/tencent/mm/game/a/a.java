package com.tencent.mm.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static AbstractC0345a hhj = new AbstractC0345a() {
        /* class com.tencent.mm.game.a.a.AnonymousClass1 */

        @Override // com.tencent.mm.game.a.a.AbstractC0345a
        public final void loadLibrary(String str) {
            AppMethodBeat.i(43437);
            System.loadLibrary(str);
            AppMethodBeat.o(43437);
        }
    };

    /* renamed from: com.tencent.mm.game.a.a$a  reason: collision with other inner class name */
    public interface AbstractC0345a {
        void loadLibrary(String str);
    }

    static {
        AppMethodBeat.i(43439);
        AppMethodBeat.o(43439);
    }

    public static void a(AbstractC0345a aVar) {
        hhj = aVar;
    }

    public static void loadLibraries() {
        AppMethodBeat.i(43438);
        hhj.loadLibrary("mmlockstep");
        AppMethodBeat.o(43438);
    }
}
