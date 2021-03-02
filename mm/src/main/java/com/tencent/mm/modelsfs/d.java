package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends SFSOutputStream {
    private a jiU;

    public d(long j2, String str) {
        super(j2);
        AppMethodBeat.i(155992);
        this.jiU = new a(str);
        AppMethodBeat.o(155992);
    }

    @Override // java.io.OutputStream, com.tencent.mm.modelsfs.SFSOutputStream
    public final void write(int i2) {
        AppMethodBeat.i(155993);
        super.write(i2);
        AppMethodBeat.o(155993);
    }

    @Override // java.io.OutputStream, com.tencent.mm.modelsfs.SFSOutputStream
    public final void write(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(155994);
        this.jiU.B(bArr, i3);
        super.write(bArr, i2, i3);
        AppMethodBeat.o(155994);
    }

    @Override // java.io.OutputStream, com.tencent.mm.modelsfs.SFSOutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(155995);
        super.close();
        if (this.jiU != null) {
            this.jiU.free();
        }
        AppMethodBeat.o(155995);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.modelsfs.SFSOutputStream, java.lang.Object
    public final void finalize() {
        AppMethodBeat.i(155996);
        super.finalize();
        AppMethodBeat.o(155996);
    }
}
