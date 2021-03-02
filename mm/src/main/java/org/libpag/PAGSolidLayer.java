package org.libpag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGSolidLayer extends PAGLayer {
    private static native void nativeInit();

    public native void setSolidColor(int i2);

    public native int solidColor();

    public PAGSolidLayer(long j2) {
        super(j2);
    }

    static {
        AppMethodBeat.i(236923);
        b.loadLibrary("pag");
        nativeInit();
        AppMethodBeat.o(236923);
    }
}
