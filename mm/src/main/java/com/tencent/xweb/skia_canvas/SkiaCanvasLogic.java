package com.tencent.xweb.skia_canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SkiaCanvasLogic {
    private static boolean sInit = false;

    static void init() {
        AppMethodBeat.i(4294);
        if (!sInit) {
            sInit = true;
            XWebLibraryLoader.beforeLoad();
            XWebLibraryLoader.load("c++_shared");
            XWebLibraryLoader.load("mmskia");
            XWebLibraryLoader.load("canvas");
            XWebLibraryLoader.load("skia-canvas");
            XWebLibraryLoader.afetrLoad();
        }
        AppMethodBeat.o(4294);
    }
}
