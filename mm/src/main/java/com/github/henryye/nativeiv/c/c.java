package com.github.henryye.nativeiv.c;

import com.github.henryye.nativeiv.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileInputStream;
import java.io.FilterInputStream;

public final class c extends FilterInputStream {
    private long mMarkPosition = 0;

    public c(FileInputStream fileInputStream) {
        super(fileInputStream);
    }

    public final boolean markSupported() {
        return true;
    }

    public final void mark(int i2) {
        AppMethodBeat.i(127395);
        try {
            this.mMarkPosition = ((FileInputStream) this.in).getChannel().position();
            AppMethodBeat.o(127395);
        } catch (Exception e2) {
            b.printStackTrace("MicroMsg.FileSeekingInputStream", e2, "Failed seeking FileChannel.", new Object[0]);
            AppMethodBeat.o(127395);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() {
        AppMethodBeat.i(127396);
        ((FileInputStream) this.in).getChannel().position(this.mMarkPosition);
        AppMethodBeat.o(127396);
    }
}
