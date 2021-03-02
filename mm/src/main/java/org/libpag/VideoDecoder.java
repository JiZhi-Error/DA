package org.libpag;

import org.extra.tools.b;

public abstract class VideoDecoder {
    public static native void RegisterSoftwareDecoderFactory(long j2);

    public static native void SetMaxHardwareDecoderCount(int i2);

    static {
        b.loadLibrary("pag");
    }
}
