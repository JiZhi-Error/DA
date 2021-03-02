package org.libpag;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGImage {
    long nativeContext = 0;

    private static native long LoadFromAssets(AssetManager assetManager, String str);

    private static native long LoadFromBitmap(Bitmap bitmap);

    private static native long LoadFromBytes(byte[] bArr, int i2);

    private static native long LoadFromPath(String str);

    private static native long LoadFromTexture(int i2, int i3, int i4, int i5, boolean z);

    private native void nativeFinalize();

    private native void nativeGetMatrix(float[] fArr);

    private static final native void nativeInit();

    private final native void nativeRelease();

    private native void nativeSetMatrix(float f2, float f3, float f4, float f5, float f6, float f7);

    public native int height();

    public native int scaleMode();

    public native void setScaleMode(int i2);

    public native int width();

    public static PAGImage FromBitmap(Bitmap bitmap) {
        AppMethodBeat.i(236881);
        long LoadFromBitmap = LoadFromBitmap(bitmap);
        if (LoadFromBitmap == 0) {
            AppMethodBeat.o(236881);
            return null;
        }
        PAGImage pAGImage = new PAGImage(LoadFromBitmap);
        AppMethodBeat.o(236881);
        return pAGImage;
    }

    public static PAGImage FromPath(String str) {
        AppMethodBeat.i(236882);
        long LoadFromPath = LoadFromPath(str);
        if (LoadFromPath == 0) {
            AppMethodBeat.o(236882);
            return null;
        }
        PAGImage pAGImage = new PAGImage(LoadFromPath);
        AppMethodBeat.o(236882);
        return pAGImage;
    }

    public static PAGImage FromBytes(byte[] bArr) {
        AppMethodBeat.i(236883);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(236883);
            return null;
        }
        long LoadFromBytes = LoadFromBytes(bArr, bArr.length);
        if (LoadFromBytes == 0) {
            AppMethodBeat.o(236883);
            return null;
        }
        PAGImage pAGImage = new PAGImage(LoadFromBytes);
        AppMethodBeat.o(236883);
        return pAGImage;
    }

    public static PAGImage FromAssets(AssetManager assetManager, String str) {
        AppMethodBeat.i(236884);
        long LoadFromAssets = LoadFromAssets(assetManager, str);
        if (LoadFromAssets == 0) {
            AppMethodBeat.o(236884);
            return null;
        }
        PAGImage pAGImage = new PAGImage(LoadFromAssets);
        AppMethodBeat.o(236884);
        return pAGImage;
    }

    public static PAGImage FromTexture(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(236885);
        PAGImage FromTexture = FromTexture(i2, i3, i4, i5, false);
        AppMethodBeat.o(236885);
        return FromTexture;
    }

    public static PAGImage FromTexture(int i2, int i3, int i4, int i5, boolean z) {
        AppMethodBeat.i(236886);
        long LoadFromTexture = LoadFromTexture(i2, i3, i4, i5, z);
        if (LoadFromTexture == 0) {
            AppMethodBeat.o(236886);
            return null;
        }
        PAGImage pAGImage = new PAGImage(LoadFromTexture);
        AppMethodBeat.o(236886);
        return pAGImage;
    }

    PAGImage(long j2) {
        this.nativeContext = j2;
    }

    public Matrix matrix() {
        AppMethodBeat.i(236887);
        float[] fArr = new float[9];
        nativeGetMatrix(fArr);
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        AppMethodBeat.o(236887);
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        AppMethodBeat.i(236888);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        nativeSetMatrix(fArr[0], fArr[3], fArr[1], fArr[4], fArr[2], fArr[5]);
        AppMethodBeat.o(236888);
    }

    public void release() {
        AppMethodBeat.i(236889);
        nativeRelease();
        AppMethodBeat.o(236889);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(236890);
        nativeFinalize();
        AppMethodBeat.o(236890);
    }

    static {
        AppMethodBeat.i(236891);
        b.loadLibrary("pag");
        nativeInit();
        AppMethodBeat.o(236891);
    }
}
