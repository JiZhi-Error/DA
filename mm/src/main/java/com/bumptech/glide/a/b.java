package com.bumptech.glide.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

final class b implements Closeable {
    final Charset aDV;
    private byte[] buf;
    int end;
    private final InputStream in;
    private int pos;

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private b(InputStream inputStream, Charset charset, byte b2) {
        AppMethodBeat.i(100640);
        if (inputStream == null || charset == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(100640);
            throw nullPointerException;
        } else if (!charset.equals(c.US_ASCII)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported encoding");
            AppMethodBeat.o(100640);
            throw illegalArgumentException;
        } else {
            this.in = inputStream;
            this.aDV = charset;
            this.buf = new byte[8192];
            AppMethodBeat.o(100640);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(100641);
        synchronized (this.in) {
            try {
                if (this.buf != null) {
                    this.buf = null;
                    this.in.close();
                }
            } finally {
                AppMethodBeat.o(100641);
            }
        }
    }

    public final String readLine() {
        int i2;
        String byteArrayOutputStream;
        AppMethodBeat.i(100642);
        synchronized (this.in) {
            try {
                if (this.buf == null) {
                    IOException iOException = new IOException("LineReader is closed");
                    AppMethodBeat.o(100642);
                    throw iOException;
                }
                if (this.pos >= this.end) {
                    oe();
                }
                int i3 = this.pos;
                while (true) {
                    if (i3 == this.end) {
                        AnonymousClass1 r1 = new ByteArrayOutputStream((this.end - this.pos) + 80) {
                            /* class com.bumptech.glide.a.b.AnonymousClass1 */

                            public final String toString() {
                                AppMethodBeat.i(100637);
                                try {
                                    String str = new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + -1] != 13) ? this.count : this.count - 1, b.this.aDV.name());
                                    AppMethodBeat.o(100637);
                                    return str;
                                } catch (UnsupportedEncodingException e2) {
                                    AssertionError assertionError = new AssertionError(e2);
                                    AppMethodBeat.o(100637);
                                    throw assertionError;
                                }
                            }
                        };
                        loop1:
                        while (true) {
                            r1.write(this.buf, this.pos, this.end - this.pos);
                            this.end = -1;
                            oe();
                            i2 = this.pos;
                            while (true) {
                                if (i2 != this.end) {
                                    if (this.buf[i2] == 10) {
                                        break loop1;
                                    }
                                    i2++;
                                }
                            }
                        }
                        if (i2 != this.pos) {
                            r1.write(this.buf, this.pos, i2 - this.pos);
                        }
                        this.pos = i2 + 1;
                        byteArrayOutputStream = r1.toString();
                        AppMethodBeat.o(100642);
                    } else if (this.buf[i3] == 10) {
                        byteArrayOutputStream = new String(this.buf, this.pos, ((i3 == this.pos || this.buf[i3 + -1] != 13) ? i3 : i3 - 1) - this.pos, this.aDV.name());
                        this.pos = i3 + 1;
                    } else {
                        i3++;
                    }
                }
            } finally {
                AppMethodBeat.o(100642);
            }
        }
        return byteArrayOutputStream;
    }

    private void oe() {
        AppMethodBeat.i(100643);
        int read = this.in.read(this.buf, 0, this.buf.length);
        if (read == -1) {
            EOFException eOFException = new EOFException();
            AppMethodBeat.o(100643);
            throw eOFException;
        }
        this.pos = 0;
        this.end = read;
        AppMethodBeat.o(100643);
    }
}
