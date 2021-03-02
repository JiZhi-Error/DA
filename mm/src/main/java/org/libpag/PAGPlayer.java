package org.libpag;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGPlayer {
    private long nativeContext = 0;
    private PAGSurface pagSurface = null;

    private native void nativeFinalize();

    private native void nativeGetMatrix(float[] fArr);

    private static final native void nativeInit();

    private final native void nativeRelease();

    private native void nativeSetMatrix(float f2, float f3, float f4, float f5, float f6, float f7);

    private native void nativeSetSurface(long j2);

    private final native void nativeSetup();

    public native boolean cacheEnabled();

    public native float cacheScale();

    public native long duration();

    public native boolean flush();

    public native RectF getBounds(PAGLayer pAGLayer);

    public native PAGComposition getComposition();

    public native PAGLayer[] getLayersUnderPoint(float f2, float f3);

    public native double getProgress();

    public native boolean hitTestPoint(PAGLayer pAGLayer, float f2, float f3, boolean z);

    public native float maxFrameRate();

    public native int scaleMode();

    public native void setCacheEnabled(boolean z);

    public native void setCacheScale(float f2);

    public native void setComposition(PAGComposition pAGComposition);

    public native void setMaxFrameRate(float f2);

    public native void setProgress(double d2);

    public native void setScaleMode(int i2);

    public native void setVideoEnabled(boolean z);

    public native boolean videoEnabled();

    public PAGPlayer() {
        AppMethodBeat.i(236905);
        nativeSetup();
        AppMethodBeat.o(236905);
    }

    public PAGSurface getSurface() {
        return this.pagSurface;
    }

    public void setSurface(PAGSurface pAGSurface) {
        AppMethodBeat.i(236906);
        this.pagSurface = pAGSurface;
        if (pAGSurface == null) {
            nativeSetSurface(0);
            AppMethodBeat.o(236906);
            return;
        }
        nativeSetSurface(pAGSurface.nativeSurface);
        AppMethodBeat.o(236906);
    }

    public Matrix matrix() {
        AppMethodBeat.i(236907);
        float[] fArr = new float[9];
        nativeGetMatrix(fArr);
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        AppMethodBeat.o(236907);
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        AppMethodBeat.i(236908);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        nativeSetMatrix(fArr[0], fArr[3], fArr[1], fArr[4], fArr[2], fArr[5]);
        AppMethodBeat.o(236908);
    }

    public void release() {
        AppMethodBeat.i(236909);
        nativeRelease();
        AppMethodBeat.o(236909);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(236910);
        nativeFinalize();
        AppMethodBeat.o(236910);
    }

    static {
        AppMethodBeat.i(236911);
        b.loadLibrary("pag");
        nativeInit();
        AppMethodBeat.o(236911);
    }
}
