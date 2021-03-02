package org.libpag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGTextLayer extends PAGLayer {
    private static native void nativeInit();

    private native void setFont(String str, String str2);

    public native int fillColor();

    public native PAGFont font();

    public native float fontSize();

    public native void setFillColor(int i2);

    public native void setFontSize(float f2);

    public native void setStrokeColor(int i2);

    public native void setText(String str);

    public native int strokeColor();

    public native String text();

    public PAGTextLayer(long j2) {
        super(j2);
    }

    public void setFont(PAGFont pAGFont) {
        AppMethodBeat.i(236935);
        setFont(pAGFont.fontFamily, pAGFont.fontStyle);
        AppMethodBeat.o(236935);
    }

    static {
        AppMethodBeat.i(236936);
        b.loadLibrary("pag");
        nativeInit();
        AppMethodBeat.o(236936);
    }
}
