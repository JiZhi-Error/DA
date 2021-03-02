package com.tencent.tinker.a.b.a;

import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import java.io.EOFException;

public final class g extends a {
    final short[] Shs;

    public g(short[] sArr) {
        if (sArr == null) {
            throw new NullPointerException("array == null");
        }
        this.Shs = sArr;
    }

    public final int read() {
        try {
            short s = this.Shs[this.apk];
            hoY();
            return s & ISelectionInterface.HELD_NOTHING;
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new EOFException();
        }
    }

    public final int readInt() {
        return read() | (read() << 16);
    }

    public final long readLong() {
        return ((long) read()) | (((long) read()) << 16) | (((long) read()) << 32) | (((long) read()) << 48);
    }
}
