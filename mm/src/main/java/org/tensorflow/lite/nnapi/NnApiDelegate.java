package org.tensorflow.lite.nnapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.tensorflow.lite.TensorFlowLite;
import org.tensorflow.lite.b;

public class NnApiDelegate implements AutoCloseable, b {
    public long Ujw;

    public static final class a {
        String UjA = null;
        Integer UjB = null;
        Boolean UjC = null;
        Boolean UjD = null;
        int Ujy = -1;
        String Ujz = null;
        String cacheDir = null;
    }

    private static native long createDelegate(int i2, String str, String str2, String str3, int i3, boolean z, boolean z2, boolean z3);

    private static native void deleteDelegate(long j2);

    private static native int getNnapiErrno(long j2);

    private NnApiDelegate(a aVar) {
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.i(238992);
        TensorFlowLite.init();
        int i2 = aVar.Ujy;
        String str = aVar.Ujz;
        String str2 = aVar.cacheDir;
        String str3 = aVar.UjA;
        int intValue = aVar.UjB != null ? aVar.UjB.intValue() : -1;
        if (aVar.UjC != null) {
            z = true;
        } else {
            z = false;
        }
        if (aVar.UjC != null && aVar.UjC.booleanValue()) {
            z2 = false;
        }
        this.Ujw = createDelegate(i2, str, str2, str3, intValue, z, z2, aVar.UjD != null ? aVar.UjD.booleanValue() : z3);
        AppMethodBeat.o(238992);
    }

    public NnApiDelegate() {
        this(new a());
        AppMethodBeat.i(238993);
        AppMethodBeat.o(238993);
    }

    @Override // org.tensorflow.lite.b
    public final long getNativeHandle() {
        return this.Ujw;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(238994);
        if (this.Ujw != 0) {
            deleteDelegate(this.Ujw);
            this.Ujw = 0;
        }
        AppMethodBeat.o(238994);
    }
}
