package com.tencent.mm.svg;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.svg.b.b;

public class WeChatSVG {
    public static native float[] getViewPort(long j2);

    private static native void nativeInit();

    public static native long parse(String str);

    public static native void release(long j2);

    public static native int render(long j2, Canvas canvas);

    public static native int renderViewPort(long j2, Canvas canvas, float f2, float f3);

    static {
        AppMethodBeat.i(148690);
        if (b.gFX()) {
            System.loadLibrary("wechatsvg");
            nativeInit();
        }
        AppMethodBeat.o(148690);
    }
}
