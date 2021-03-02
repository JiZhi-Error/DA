package com.tencent.tbs.one.impl.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class h extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private OutputStream[] f2362a;

    public h(OutputStream[] outputStreamArr) {
        this.f2362a = outputStreamArr;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(173930);
        for (OutputStream outputStream : this.f2362a) {
            outputStream.close();
        }
        AppMethodBeat.o(173930);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        AppMethodBeat.i(173929);
        for (OutputStream outputStream : this.f2362a) {
            outputStream.flush();
        }
        AppMethodBeat.o(173929);
    }

    @Override // java.io.OutputStream
    public final void write(int i2) {
        AppMethodBeat.i(173926);
        for (OutputStream outputStream : this.f2362a) {
            outputStream.write(i2);
        }
        AppMethodBeat.o(173926);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        AppMethodBeat.i(173927);
        for (OutputStream outputStream : this.f2362a) {
            outputStream.write(bArr);
        }
        AppMethodBeat.o(173927);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(173928);
        for (OutputStream outputStream : this.f2362a) {
            outputStream.write(bArr, i2, i3);
        }
        AppMethodBeat.o(173928);
    }
}
