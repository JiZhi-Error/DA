package com.tencent.xweb.skia_canvas.resource_loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

class ResourceLoaderJNI {
    private static final String TAG = "ResourceLoaderJNI";

    ResourceLoaderJNI() {
    }

    static byte[] loadResource(String str, String str2) {
        AppMethodBeat.i(217620);
        if (SkiaCanvasResourceLoader.hasDelegateSet()) {
            byte[] loadResource = SkiaCanvasResourceLoader.getDelegateWrapperForCurrentThread().loadResource(str, str2);
            AppMethodBeat.o(217620);
            return loadResource;
        }
        byte[] bArr = new byte[0];
        AppMethodBeat.o(217620);
        return bArr;
    }

    static void loadResourceAsync(int i2, String str, String str2) {
        AppMethodBeat.i(217621);
        if (SkiaCanvasResourceLoader.hasDelegateSet()) {
            SkiaCanvasResourceLoader.getDelegateWrapperForCurrentThread().loadResourceAsync(i2, str, str2);
        }
        AppMethodBeat.o(217621);
    }
}
