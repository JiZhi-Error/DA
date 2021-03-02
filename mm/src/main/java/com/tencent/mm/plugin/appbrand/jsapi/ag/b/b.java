package com.tencent.mm.plugin.appbrand.jsapi.ag.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.skia_canvas.SkiaCanvasView;
import java.lang.ref.WeakReference;

public final class b {
    private static SparseArray<WeakReference<SkiaCanvasView>> mJq = new SparseArray<>();

    static {
        AppMethodBeat.i(215811);
        AppMethodBeat.o(215811);
    }

    public static synchronized SkiaCanvasView xS(int i2) {
        SkiaCanvasView skiaCanvasView;
        synchronized (b.class) {
            AppMethodBeat.i(215808);
            if (mJq.get(i2) == null) {
                skiaCanvasView = null;
                AppMethodBeat.o(215808);
            } else {
                skiaCanvasView = mJq.get(i2).get();
                AppMethodBeat.o(215808);
            }
        }
        return skiaCanvasView;
    }

    public static synchronized void a(int i2, SkiaCanvasView skiaCanvasView) {
        synchronized (b.class) {
            AppMethodBeat.i(215809);
            com.tencent.mm.audio.mix.i.b.i("Luggage.SkiaCanvasViewManager", "put viewId:%d skiaCanvasView:%s", Integer.valueOf(i2), skiaCanvasView);
            mJq.put(i2, new WeakReference<>(skiaCanvasView));
            AppMethodBeat.o(215809);
        }
    }

    public static synchronized void remove(int i2) {
        synchronized (b.class) {
            AppMethodBeat.i(215810);
            SkiaCanvasView xS = xS(i2);
            if (xS != null) {
                mJq.remove(i2);
                com.tencent.mm.audio.mix.i.b.i("Luggage.SkiaCanvasViewManager", "remove viewId:%d skiaCanvasView:%s", Integer.valueOf(i2), xS);
                AppMethodBeat.o(215810);
            } else {
                com.tencent.mm.audio.mix.i.b.i("Luggage.SkiaCanvasViewManager", "remove viewId:%d fail, not exist", Integer.valueOf(i2));
                AppMethodBeat.o(215810);
            }
        }
    }
}
