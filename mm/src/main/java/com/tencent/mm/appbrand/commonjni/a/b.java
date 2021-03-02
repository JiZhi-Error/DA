package com.tencent.mm.appbrand.commonjni.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    private static a doM = new a() {
        /* class com.tencent.mm.appbrand.commonjni.a.b.AnonymousClass1 */

        @Override // com.tencent.mm.appbrand.commonjni.a.b.a
        public final void loadLibrary(String str) {
            AppMethodBeat.i(201242);
            System.loadLibrary(str);
            AppMethodBeat.o(201242);
        }
    };
    private static boolean sLibraryLoaded = false;

    public interface a {
        void loadLibrary(String str);
    }

    static {
        AppMethodBeat.i(201244);
        AppMethodBeat.o(201244);
    }

    public static void a(a aVar) {
        doM = aVar;
    }

    public static void loadLibrary(String str) {
        AppMethodBeat.i(201243);
        doM.loadLibrary(str);
        AppMethodBeat.o(201243);
    }
}
