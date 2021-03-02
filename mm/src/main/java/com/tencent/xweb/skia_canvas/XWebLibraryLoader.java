package com.tencent.xweb.skia_canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWebLibraryLoader {
    private static IXWebLibraryLoader DEFAULT;
    private static IXWebLibraryLoader sXWebLibraryLoader;

    static {
        AppMethodBeat.i(4312);
        AnonymousClass1 r0 = new IXWebLibraryLoader() {
            /* class com.tencent.xweb.skia_canvas.XWebLibraryLoader.AnonymousClass1 */

            @Override // com.tencent.xweb.skia_canvas.IXWebLibraryLoader
            public final boolean beforeLoad() {
                return false;
            }

            @Override // com.tencent.xweb.skia_canvas.IXWebLibraryLoader
            public final boolean load(String str) {
                AppMethodBeat.i(4308);
                try {
                    System.loadLibrary(str);
                } catch (Exception e2) {
                    XWebLibraryLoader.class.getSimpleName();
                    String.format("%s load fail %s", str, e2);
                }
                AppMethodBeat.o(4308);
                return true;
            }

            @Override // com.tencent.xweb.skia_canvas.IXWebLibraryLoader
            public final boolean afterLoad() {
                return false;
            }
        };
        DEFAULT = r0;
        sXWebLibraryLoader = r0;
        AppMethodBeat.o(4312);
    }

    public static void initXWebLibraryLoader(IXWebLibraryLoader iXWebLibraryLoader) {
        sXWebLibraryLoader = iXWebLibraryLoader;
    }

    public static boolean load(String str) {
        AppMethodBeat.i(4309);
        boolean load = sXWebLibraryLoader.load(str);
        AppMethodBeat.o(4309);
        return load;
    }

    public static void beforeLoad() {
        AppMethodBeat.i(4310);
        sXWebLibraryLoader.beforeLoad();
        AppMethodBeat.o(4310);
    }

    public static void afetrLoad() {
        AppMethodBeat.i(4311);
        sXWebLibraryLoader.afterLoad();
        AppMethodBeat.o(4311);
    }
}
