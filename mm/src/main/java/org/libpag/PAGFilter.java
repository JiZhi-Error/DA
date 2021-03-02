package org.libpag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGFilter {
    protected long nativeContext;

    public static native PAGFilter FromPAGFile(PAGFile pAGFile, int i2);

    private static native void nativeInit();

    private native void nativeRelease();

    public native long currentTime();

    public native long duration();

    public native boolean excludedFromTimeline();

    public native void setCurrentTime(long j2);

    public native void setDuration(long j2);

    public native void setExcludedFromTimeline(boolean z);

    public native void setVisible(boolean z);

    public native boolean visible();

    public PAGFilter(long j2) {
        this.nativeContext = j2;
    }

    static {
        AppMethodBeat.i(236863);
        b.loadLibrary("pag");
        nativeInit();
        AppMethodBeat.o(236863);
    }
}
