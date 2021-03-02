package rx.internal.util.unsafe;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Pow2 {
    private Pow2() {
        AppMethodBeat.i(90151);
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        AppMethodBeat.o(90151);
        throw illegalStateException;
    }

    public static int roundToPowerOfTwo(int i2) {
        AppMethodBeat.i(90152);
        int numberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(i2 - 1));
        AppMethodBeat.o(90152);
        return numberOfLeadingZeros;
    }

    public static boolean isPowerOfTwo(int i2) {
        return ((i2 + -1) & i2) == 0;
    }
}
