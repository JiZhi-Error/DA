package org.libpag;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import org.extra.tools.b;

public class PAGLayer {
    public static final int LayerTypeImage = 5;
    public static final int LayerTypeNull = 1;
    public static final int LayerTypePreCompose = 6;
    public static final int LayerTypeShape = 4;
    public static final int LayerTypeSolid = 2;
    public static final int LayerTypeText = 3;
    public static final int LayerTypeUnknown = 0;
    protected long nativeContext;

    private native void getTotalMatrix(float[] fArr);

    private native void matrix(float[] fArr);

    private static native void nativeInit();

    private native void nativeRelease();

    private native void setMatrix(float[] fArr);

    public native void addFilter(PAGFilter pAGFilter);

    public native long currentTime();

    public native long duration();

    public native int editableIndex();

    public native boolean excludedFromTimeline();

    public native float frameRate();

    public native RectF getBounds();

    public native double getProgress();

    public native long globalToLocalTime(long j2);

    public native String layerName();

    public native int layerType();

    public native long localTimeToGlobal(long j2);

    public native PAGMarker[] markers();

    public native int numFilters();

    public native PAGComposition parent();

    public native void removeAllFilters();

    public native void resetMatrix();

    public native void setCurrentTime(long j2);

    public native void setExcludedFromTimeline(boolean z);

    public native void setProgress(double d2);

    public native void setStartTime(long j2);

    public native void setVisible(boolean z);

    public native long startTime();

    public native PAGLayer trackMatteLayer();

    public native boolean visible();

    public PAGLayer(long j2) {
        this.nativeContext = j2;
    }

    public Matrix matrix() {
        AppMethodBeat.i(236895);
        float[] fArr = new float[9];
        matrix(fArr);
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        AppMethodBeat.o(236895);
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        AppMethodBeat.i(236896);
        if (matrix == null) {
            AppMethodBeat.o(236896);
            return;
        }
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        setMatrix(fArr);
        AppMethodBeat.o(236896);
    }

    public Matrix getTotalMatrix() {
        AppMethodBeat.i(236897);
        float[] fArr = new float[9];
        getTotalMatrix(fArr);
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        AppMethodBeat.o(236897);
        return matrix;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(236898);
        nativeRelease();
        AppMethodBeat.o(236898);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(236899);
        if (this == obj) {
            AppMethodBeat.o(236899);
            return true;
        } else if (!(obj instanceof PAGLayer)) {
            AppMethodBeat.o(236899);
            return false;
        } else if (hashCode() == obj.hashCode()) {
            AppMethodBeat.o(236899);
            return true;
        } else {
            AppMethodBeat.o(236899);
            return false;
        }
    }

    public int hashCode() {
        return ((int) (this.nativeContext ^ (this.nativeContext >>> 32))) + JsApiGetABTestConfig.CTRL_INDEX;
    }

    static {
        AppMethodBeat.i(236900);
        b.loadLibrary("pag");
        nativeInit();
        AppMethodBeat.o(236900);
    }
}
