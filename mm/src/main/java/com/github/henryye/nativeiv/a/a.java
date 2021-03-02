package com.github.henryye.nativeiv.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static AbstractC0083a bbq = new AbstractC0083a() {
        /* class com.github.henryye.nativeiv.a.a.AnonymousClass1 */

        @Override // com.github.henryye.nativeiv.a.a.AbstractC0083a
        public final void loadLibrary(String str) {
            AppMethodBeat.i(127377);
            System.loadLibrary(str);
            AppMethodBeat.o(127377);
        }
    };

    /* renamed from: com.github.henryye.nativeiv.a.a$a  reason: collision with other inner class name */
    public interface AbstractC0083a {
        void loadLibrary(String str);
    }

    static {
        AppMethodBeat.i(127379);
        AppMethodBeat.o(127379);
    }

    public static void a(AbstractC0083a aVar) {
        bbq = aVar;
    }

    public static void loadLibrary(String str) {
        AppMethodBeat.i(127378);
        bbq.loadLibrary(str);
        AppMethodBeat.o(127378);
    }
}
