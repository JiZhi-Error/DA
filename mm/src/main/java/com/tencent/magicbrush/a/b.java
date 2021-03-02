package com.tencent.magicbrush.a;

import com.github.henryye.nativeiv.a.a;
import com.tencent.magicbrush.a.c;
import com.tencent.magicbrush.utils.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    private static a cMD = new a() {
        /* class com.tencent.magicbrush.a.b.AnonymousClass1 */

        @Override // com.tencent.magicbrush.a.b.a
        public final void loadLibrary(String str) {
            AppMethodBeat.i(139955);
            h.ef(str);
            AppMethodBeat.o(139955);
        }

        @Override // com.tencent.magicbrush.a.b.a
        public final String dZ(String str) {
            AppMethodBeat.i(206805);
            String findLibPath = h.findLibPath(str);
            AppMethodBeat.o(206805);
            return findLibPath;
        }
    };
    private static boolean sLibraryLoaded = false;

    public interface a {
        String dZ(String str);

        void loadLibrary(String str);
    }

    static {
        AppMethodBeat.i(139960);
        AppMethodBeat.o(139960);
    }

    public static void a(final a aVar) {
        AppMethodBeat.i(139957);
        cMD = aVar;
        com.github.henryye.nativeiv.a.a.a(new a.AbstractC0083a() {
            /* class com.tencent.magicbrush.a.b.AnonymousClass2 */

            @Override // com.github.henryye.nativeiv.a.a.AbstractC0083a
            public final void loadLibrary(String str) {
                AppMethodBeat.i(139956);
                aVar.loadLibrary(str);
                AppMethodBeat.o(139956);
            }
        });
        AppMethodBeat.o(139957);
    }

    public static void loadLibrary(String str) {
        AppMethodBeat.i(139958);
        cMD.loadLibrary(str);
        AppMethodBeat.o(139958);
    }

    public static void loadLibraries() {
        AppMethodBeat.i(139959);
        if (sLibraryLoaded) {
            c.C0193c.i("MagicBrush", "library already loaded", new Object[0]);
            AppMethodBeat.o(139959);
            return;
        }
        long currentTicks = h.currentTicks();
        c.C0193c.i("MagicBrush", "start loadLibraries", new Object[0]);
        long currentTicks2 = h.currentTicks();
        cMD.loadLibrary("mmv8");
        long currentTicks3 = h.currentTicks();
        cMD.loadLibrary("magicbrush");
        sLibraryLoaded = true;
        c.C0193c.i("MagicBrush", "total[%d]ms load mmv8 cost [%d]ms, load magicbrush cost [%d]ms", Long.valueOf(h.ticksToNow(currentTicks)), Long.valueOf(currentTicks3 - currentTicks2), Long.valueOf(h.ticksToNow(currentTicks3)));
        AppMethodBeat.o(139959);
    }

    public static String dZ(String str) {
        AppMethodBeat.i(206806);
        String dZ = cMD.dZ(str);
        AppMethodBeat.o(206806);
        return dZ;
    }
}
