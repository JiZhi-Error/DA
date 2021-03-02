package org.libpag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGImageLayer extends PAGLayer {
    private static native void nativeInit();

    private static native long nativeMake(int i2, int i3, long j2);

    private native void replaceImage(long j2);

    public native long contentDuration();

    public native PAGVideoRange[] getVideoRanges();

    public static PAGImageLayer Make(int i2, int i3, long j2) {
        AppMethodBeat.i(236892);
        long nativeMake = nativeMake(i2, i3, j2);
        if (nativeMake == 0) {
            AppMethodBeat.o(236892);
            return null;
        }
        PAGImageLayer pAGImageLayer = new PAGImageLayer(nativeMake);
        AppMethodBeat.o(236892);
        return pAGImageLayer;
    }

    public PAGImageLayer(long j2) {
        super(j2);
    }

    public void replaceImage(PAGImage pAGImage) {
        AppMethodBeat.i(236893);
        replaceImage(pAGImage == null ? 0 : pAGImage.nativeContext);
        AppMethodBeat.o(236893);
    }

    static {
        AppMethodBeat.i(236894);
        b.loadLibrary("pag");
        nativeInit();
        AppMethodBeat.o(236894);
    }
}
