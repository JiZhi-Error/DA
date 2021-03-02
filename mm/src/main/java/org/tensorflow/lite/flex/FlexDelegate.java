package org.tensorflow.lite.flex;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Closeable;
import org.tensorflow.lite.a.a;
import org.tensorflow.lite.b;

public class FlexDelegate implements Closeable, b {
    private long Ujw = nativeCreateDelegate();

    private static native long nativeCreateDelegate();

    private static native void nativeDeleteDelegate(long j2);

    private static native long nativeInitTensorFlow();

    public FlexDelegate() {
        AppMethodBeat.i(238989);
        AppMethodBeat.o(238989);
    }

    @Override // org.tensorflow.lite.b
    public final long getNativeHandle() {
        return this.Ujw;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(238990);
        if (this.Ujw != 0) {
            nativeDeleteDelegate(this.Ujw);
            this.Ujw = 0;
        }
        AppMethodBeat.o(238990);
    }

    static {
        AppMethodBeat.i(238991);
        if (!a.Ujx.value) {
            Log.e("MicroMsg.FlexDelegate", "load library error");
        }
        AppMethodBeat.o(238991);
    }
}
