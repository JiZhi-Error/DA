package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public final class f {
    private static f[][] IvA = ((f[][]) Array.newInstance(f.class, 3, 3));
    public int Ivy = 0;
    public int Ivz = 0;

    static {
        AppMethodBeat.i(129788);
        for (int i2 = 0; i2 < 3; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                IvA[i2][i3] = new f(i2, i3);
            }
        }
        AppMethodBeat.o(129788);
    }

    private f(int i2, int i3) {
        this.Ivy = i2;
        this.Ivz = i3;
    }

    public final String toString() {
        AppMethodBeat.i(129787);
        String format = String.format("{row: %d, col: %d}", Integer.valueOf(this.Ivy), Integer.valueOf(this.Ivz));
        AppMethodBeat.o(129787);
        return format;
    }

    public static synchronized f jW(int i2, int i3) {
        f fVar;
        synchronized (f.class) {
            AppMethodBeat.i(129786);
            if (i2 < 0 || i2 > 2) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("row id should be in range [0..2]");
                AppMethodBeat.o(129786);
                throw illegalArgumentException;
            } else if (i3 < 0 || i3 > 2) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("col id should be in range [0..2]");
                AppMethodBeat.o(129786);
                throw illegalArgumentException2;
            } else {
                fVar = IvA[i2][i3];
                AppMethodBeat.o(129786);
            }
        }
        return fVar;
    }
}
