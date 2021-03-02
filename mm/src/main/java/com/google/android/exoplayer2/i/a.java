package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static void checkArgument(boolean z) {
        AppMethodBeat.i(93107);
        if (!z) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(93107);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(93107);
    }

    public static void checkArgument(boolean z, Object obj) {
        AppMethodBeat.i(93108);
        if (!z) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(obj));
            AppMethodBeat.o(93108);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(93108);
    }

    public static int bh(int i2, int i3) {
        AppMethodBeat.i(93109);
        if (i2 < 0 || i2 >= i3) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(93109);
            throw indexOutOfBoundsException;
        }
        AppMethodBeat.o(93109);
        return i2;
    }

    public static void checkState(boolean z) {
        AppMethodBeat.i(93110);
        if (!z) {
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(93110);
            throw illegalStateException;
        }
        AppMethodBeat.o(93110);
    }

    public static void checkState(boolean z, Object obj) {
        AppMethodBeat.i(93111);
        if (!z) {
            IllegalStateException illegalStateException = new IllegalStateException(String.valueOf(obj));
            AppMethodBeat.o(93111);
            throw illegalStateException;
        }
        AppMethodBeat.o(93111);
    }

    public static <T> T checkNotNull(T t) {
        AppMethodBeat.i(93112);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(93112);
            throw nullPointerException;
        }
        AppMethodBeat.o(93112);
        return t;
    }
}
