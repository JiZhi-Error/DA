package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class h {
    private long[] bHf;
    public int size;

    public h() {
        this((byte) 0);
    }

    private h(byte b2) {
        AppMethodBeat.i(93136);
        this.bHf = new long[32];
        AppMethodBeat.o(93136);
    }

    public final void add(long j2) {
        AppMethodBeat.i(93137);
        if (this.size == this.bHf.length) {
            this.bHf = Arrays.copyOf(this.bHf, this.size * 2);
        }
        long[] jArr = this.bHf;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr[i2] = j2;
        AppMethodBeat.o(93137);
    }

    public final long get(int i2) {
        AppMethodBeat.i(93138);
        if (i2 < 0 || i2 >= this.size) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("Invalid index " + i2 + ", size is " + this.size);
            AppMethodBeat.o(93138);
            throw indexOutOfBoundsException;
        }
        long j2 = this.bHf[i2];
        AppMethodBeat.o(93138);
        return j2;
    }

    public final long[] toArray() {
        AppMethodBeat.i(93139);
        long[] copyOf = Arrays.copyOf(this.bHf, this.size);
        AppMethodBeat.o(93139);
        return copyOf;
    }
}
