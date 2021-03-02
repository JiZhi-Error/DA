package com.tencent.mm.plugin.wepkg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class a extends c {
    int count;

    public a(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, com.tencent.mm.plugin.wepkg.d.c, java.io.InputStream
    public final int read(byte[] bArr) {
        AppMethodBeat.i(110768);
        int read = super.read(bArr);
        this.count = (read >= 0 ? read : 0) + this.count;
        AppMethodBeat.o(110768);
        return read;
    }

    @Override // java.io.FilterInputStream, com.tencent.mm.plugin.wepkg.d.c, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(110769);
        int read = super.read(bArr, i2, i3);
        this.count = (read >= 0 ? read : 0) + this.count;
        AppMethodBeat.o(110769);
        return read;
    }

    @Override // java.io.FilterInputStream, com.tencent.mm.plugin.wepkg.d.c, java.io.InputStream
    public final int read() {
        AppMethodBeat.i(110770);
        int read = super.read();
        this.count = (read >= 0 ? 1 : 0) + this.count;
        AppMethodBeat.o(110770);
        return read;
    }

    @Override // java.io.FilterInputStream, com.tencent.mm.plugin.wepkg.d.c, java.io.InputStream
    public final long skip(long j2) {
        AppMethodBeat.i(110771);
        long skip = super.skip(j2);
        this.count = (int) (((long) this.count) + skip);
        AppMethodBeat.o(110771);
        return skip;
    }

    public final synchronized int gkW() {
        int i2;
        i2 = this.count;
        this.count = 0;
        return i2;
    }
}
