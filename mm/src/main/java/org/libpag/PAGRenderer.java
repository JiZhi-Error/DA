package org.libpag;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGRenderer {
    private long nativeContext = 0;
    private PAGFile pagFile = null;
    private PAGSurface pagSurface = null;

    private native void nativeFinalize();

    private native void nativeGetMatrix(float[] fArr);

    private static final native void nativeInit();

    private final native void nativeRelease();

    private native void nativeReplaceImage(int i2, long j2);

    private native void nativeSetFile(long j2);

    private native void nativeSetMatrix(float f2, float f3, float f4, float f5, float f6, float f7);

    private native void nativeSetSurface(long j2);

    private final native void nativeSetup();

    public native boolean cacheEnabled();

    public native float cacheScale();

    public native void draw();

    public native boolean flush(boolean z);

    public native PAGLayer[] getLayersUnderPoint(float f2, float f3);

    public native double getProgress();

    public native PAGComposition getRootComposition();

    public native float maxFrameRate();

    public native void reset();

    public native int scaleMode();

    public native void setCacheEnabled(boolean z);

    public native void setCacheScale(float f2);

    public native void setMaxFrameRate(float f2);

    public native void setProgress(double d2);

    public native void setScaleMode(int i2);

    public native void setTextData(int i2, PAGText pAGText);

    public PAGRenderer() {
        AppMethodBeat.i(236912);
        nativeSetup();
        AppMethodBeat.o(236912);
    }

    public PAGFile getFile() {
        return this.pagFile;
    }

    public void setFile(PAGFile pAGFile) {
        AppMethodBeat.i(236913);
        this.pagFile = pAGFile;
        if (pAGFile != null) {
            nativeSetFile(pAGFile.nativeContext);
            AppMethodBeat.o(236913);
            return;
        }
        nativeSetFile(0);
        AppMethodBeat.o(236913);
    }

    public PAGSurface getSurface() {
        return this.pagSurface;
    }

    public void setSurface(PAGSurface pAGSurface) {
        AppMethodBeat.i(236914);
        this.pagSurface = pAGSurface;
        if (pAGSurface == null) {
            nativeSetSurface(0);
            AppMethodBeat.o(236914);
            return;
        }
        nativeSetSurface(pAGSurface.nativeSurface);
        AppMethodBeat.o(236914);
    }

    public Matrix matrix() {
        AppMethodBeat.i(236915);
        float[] fArr = new float[9];
        nativeGetMatrix(fArr);
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        AppMethodBeat.o(236915);
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        AppMethodBeat.i(236916);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        nativeSetMatrix(fArr[0], fArr[3], fArr[1], fArr[4], fArr[2], fArr[5]);
        AppMethodBeat.o(236916);
    }

    public void replaceImage(int i2, PAGImage pAGImage) {
        AppMethodBeat.i(236917);
        if (pAGImage == null) {
            nativeReplaceImage(i2, 0);
            AppMethodBeat.o(236917);
            return;
        }
        nativeReplaceImage(i2, pAGImage.nativeContext);
        AppMethodBeat.o(236917);
    }

    public boolean flush() {
        AppMethodBeat.i(236918);
        boolean flush = flush(false);
        AppMethodBeat.o(236918);
        return flush;
    }

    public void release() {
        AppMethodBeat.i(236919);
        nativeRelease();
        AppMethodBeat.o(236919);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(236920);
        nativeFinalize();
        AppMethodBeat.o(236920);
    }

    static {
        AppMethodBeat.i(236921);
        b.loadLibrary("pag");
        nativeInit();
        AppMethodBeat.o(236921);
    }
}
