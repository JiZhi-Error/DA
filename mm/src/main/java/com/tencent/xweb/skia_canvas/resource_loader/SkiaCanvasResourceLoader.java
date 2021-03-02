package com.tencent.xweb.skia_canvas.resource_loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SkiaCanvasResourceLoader {
    private static final String TAG = SkiaCanvasResourceLoader.class.getSimpleName();
    private static ThreadLocal<ResourceLoaderDelegateWrapper> sThreadLocalLoader = new ThreadLocal<>();

    static {
        AppMethodBeat.i(217625);
        AppMethodBeat.o(217625);
    }

    public static void setDelegate(IResourceLoader iResourceLoader) {
        AppMethodBeat.i(217622);
        sThreadLocalLoader.set(new ResourceLoaderDelegateWrapper(iResourceLoader));
        AppMethodBeat.o(217622);
    }

    static ResourceLoaderDelegateWrapper getDelegateWrapperForCurrentThread() {
        AppMethodBeat.i(217623);
        ResourceLoaderDelegateWrapper resourceLoaderDelegateWrapper = sThreadLocalLoader.get();
        AppMethodBeat.o(217623);
        return resourceLoaderDelegateWrapper;
    }

    public static boolean hasDelegateSet() {
        AppMethodBeat.i(217624);
        if (sThreadLocalLoader.get() != null) {
            AppMethodBeat.o(217624);
            return true;
        }
        AppMethodBeat.o(217624);
        return false;
    }
}
