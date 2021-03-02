package org.libpag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import org.extra.tools.b;

public class PAGComposition extends PAGLayer {
    public static native PAGComposition Make(int i2, int i3);

    private static native void nativeInit();

    public native void addLayer(PAGLayer pAGLayer);

    public native void addLayerAt(PAGLayer pAGLayer, int i2);

    public native ByteBuffer audioBytes();

    public native PAGMarker[] audioMarkers();

    public native long audioStartTime();

    public native boolean contains(PAGLayer pAGLayer);

    public native PAGLayer getLayerAt(int i2);

    public native int getLayerIndex(PAGLayer pAGLayer);

    public native PAGLayer[] getLayersByName(String str);

    public native PAGLayer[] getLayersUnderPoint(float f2, float f3);

    public native int height();

    public native int numChildren();

    public native void removeAllLayers();

    public native PAGLayer removeLayer(PAGLayer pAGLayer);

    public native PAGLayer removeLayerAt(int i2);

    public native void setContentSize(int i2, int i3);

    public native void setLayerIndex(PAGLayer pAGLayer, int i2);

    public native void swapLayer(PAGLayer pAGLayer, PAGLayer pAGLayer2);

    public native void swapLayerAt(int i2, int i3);

    public native int width();

    public PAGComposition(long j2) {
        super(j2);
    }

    public int numLayers() {
        AppMethodBeat.i(236856);
        int numChildren = numChildren();
        AppMethodBeat.o(236856);
        return numChildren;
    }

    static {
        AppMethodBeat.i(236857);
        b.loadLibrary("pag");
        nativeInit();
        AppMethodBeat.o(236857);
    }
}
