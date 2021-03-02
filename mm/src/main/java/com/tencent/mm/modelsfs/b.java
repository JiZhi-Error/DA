package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.FilterOutputStream;

public final class b extends FilterOutputStream {
    private a jiU;

    public b(o oVar, long j2) {
        super(s.d(oVar, false));
        AppMethodBeat.i(155982);
        this.jiU = new a(j2);
        AppMethodBeat.o(155982);
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public final void write(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(155983);
        this.jiU.B(bArr, i3);
        super.write(bArr, i2, i3);
        AppMethodBeat.o(155983);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(155984);
        super.close();
        if (this.jiU != null) {
            this.jiU.free();
        }
        AppMethodBeat.o(155984);
    }
}
