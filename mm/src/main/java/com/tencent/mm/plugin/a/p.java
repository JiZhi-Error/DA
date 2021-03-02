package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.RandomAccessFile;

public final class p extends a {
    public g jRq;
    public d jRr;

    public p(int i2, long j2, int i3) {
        super(i2, j2, i3, 0);
    }

    public static g b(RandomAccessFile randomAccessFile, byte[] bArr) {
        AppMethodBeat.i(133892);
        g gVar = (g) c.a(randomAccessFile, bArr, a.bln);
        AppMethodBeat.o(133892);
        return gVar;
    }
}
