package org.libpag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGShapeLayer extends PAGLayer {
    private static native void nativeInit();

    public PAGShapeLayer(long j2) {
        super(j2);
    }

    static {
        AppMethodBeat.i(236922);
        b.loadLibrary("pag");
        nativeInit();
        AppMethodBeat.o(236922);
    }
}
