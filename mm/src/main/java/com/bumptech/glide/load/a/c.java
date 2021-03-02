package com.bumptech.glide.load.a;

import com.bumptech.glide.load.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class c extends OutputStream {
    private b aCo;
    private byte[] buffer;
    private int index;
    private final OutputStream out;

    public c(OutputStream outputStream, b bVar) {
        this(outputStream, bVar, (byte) 0);
    }

    private c(OutputStream outputStream, b bVar, byte b2) {
        AppMethodBeat.i(76865);
        this.out = outputStream;
        this.aCo = bVar;
        this.buffer = (byte[]) bVar.a(65536, byte[].class);
        AppMethodBeat.o(76865);
    }

    @Override // java.io.OutputStream
    public final void write(int i2) {
        AppMethodBeat.i(76866);
        byte[] bArr = this.buffer;
        int i3 = this.index;
        this.index = i3 + 1;
        bArr[i3] = (byte) i2;
        ou();
        AppMethodBeat.o(76866);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        AppMethodBeat.i(76867);
        write(bArr, 0, bArr.length);
        AppMethodBeat.o(76867);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(76868);
        int i4 = 0;
        do {
            int i5 = i3 - i4;
            int i6 = i2 + i4;
            if (this.index != 0 || i5 < this.buffer.length) {
                int min = Math.min(i5, this.buffer.length - this.index);
                System.arraycopy(bArr, i6, this.buffer, this.index, min);
                this.index += min;
                i4 += min;
                ou();
            } else {
                this.out.write(bArr, i6, i5);
                AppMethodBeat.o(76868);
                return;
            }
        } while (i4 < i3);
        AppMethodBeat.o(76868);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        AppMethodBeat.i(76869);
        flushBuffer();
        this.out.flush();
        AppMethodBeat.o(76869);
    }

    private void flushBuffer() {
        AppMethodBeat.i(76870);
        if (this.index > 0) {
            this.out.write(this.buffer, 0, this.index);
            this.index = 0;
        }
        AppMethodBeat.o(76870);
    }

    private void ou() {
        AppMethodBeat.i(76871);
        if (this.index == this.buffer.length) {
            flushBuffer();
        }
        AppMethodBeat.o(76871);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(76872);
        try {
            flush();
            this.out.close();
            if (this.buffer != null) {
                this.aCo.put(this.buffer);
                this.buffer = null;
            }
            AppMethodBeat.o(76872);
        } catch (Throwable th) {
            this.out.close();
            AppMethodBeat.o(76872);
            throw th;
        }
    }
}
