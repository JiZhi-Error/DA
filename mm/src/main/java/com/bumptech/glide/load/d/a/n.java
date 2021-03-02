package com.bumptech.glide.load.d.a;

import com.bumptech.glide.load.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class n extends FilterInputStream {
    private final b aFo;
    private volatile byte[] buf;
    private int count;
    private int marklimit;
    private int markpos;
    private int pos;

    public n(InputStream inputStream, b bVar) {
        this(inputStream, bVar, (byte) 0);
    }

    private n(InputStream inputStream, b bVar, byte b2) {
        super(inputStream);
        AppMethodBeat.i(77417);
        this.markpos = -1;
        this.aFo = bVar;
        this.buf = (byte[]) bVar.a(65536, byte[].class);
        AppMethodBeat.o(77417);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        int available;
        AppMethodBeat.i(77418);
        InputStream inputStream = this.in;
        if (this.buf == null || inputStream == null) {
            IOException pG = pG();
            AppMethodBeat.o(77418);
            throw pG;
        }
        available = inputStream.available() + (this.count - this.pos);
        AppMethodBeat.o(77418);
        return available;
    }

    private static IOException pG() {
        AppMethodBeat.i(77419);
        IOException iOException = new IOException("BufferedInputStream is closed");
        AppMethodBeat.o(77419);
        throw iOException;
    }

    public final synchronized void pH() {
        this.marklimit = this.buf.length;
    }

    public final synchronized void release() {
        AppMethodBeat.i(77420);
        if (this.buf != null) {
            this.aFo.put(this.buf);
            this.buf = null;
        }
        AppMethodBeat.o(77420);
    }

    @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public final void close() {
        AppMethodBeat.i(77421);
        if (this.buf != null) {
            this.aFo.put(this.buf);
            this.buf = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
        AppMethodBeat.o(77421);
    }

    private int a(InputStream inputStream, byte[] bArr) {
        AppMethodBeat.i(77422);
        if (this.markpos == -1 || this.pos - this.markpos >= this.marklimit) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                this.markpos = -1;
                this.pos = 0;
                this.count = read;
            }
            AppMethodBeat.o(77422);
            return read;
        }
        if (this.markpos == 0 && this.marklimit > bArr.length && this.count == bArr.length) {
            int length = bArr.length * 2;
            if (length > this.marklimit) {
                length = this.marklimit;
            }
            byte[] bArr2 = (byte[]) this.aFo.a(length, byte[].class);
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.buf = bArr2;
            this.aFo.put(bArr);
            bArr = bArr2;
        } else if (this.markpos > 0) {
            System.arraycopy(bArr, this.markpos, bArr, 0, bArr.length - this.markpos);
        }
        this.pos -= this.markpos;
        this.markpos = 0;
        this.count = 0;
        int read2 = inputStream.read(bArr, this.pos, bArr.length - this.pos);
        this.count = read2 <= 0 ? this.pos : this.pos + read2;
        AppMethodBeat.o(77422);
        return read2;
    }

    public final synchronized void mark(int i2) {
        AppMethodBeat.i(77423);
        this.marklimit = Math.max(this.marklimit, i2);
        this.markpos = this.pos;
        AppMethodBeat.o(77423);
    }

    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        int i2 = -1;
        synchronized (this) {
            AppMethodBeat.i(77424);
            byte[] bArr = this.buf;
            InputStream inputStream = this.in;
            if (bArr == null || inputStream == null) {
                IOException pG = pG();
                AppMethodBeat.o(77424);
                throw pG;
            } else if (this.pos >= this.count && a(inputStream, bArr) == -1) {
                AppMethodBeat.o(77424);
            } else if (bArr != this.buf && (bArr = this.buf) == null) {
                IOException pG2 = pG();
                AppMethodBeat.o(77424);
                throw pG2;
            } else if (this.count - this.pos > 0) {
                int i3 = this.pos;
                this.pos = i3 + 1;
                i2 = bArr[i3] & 255;
                AppMethodBeat.o(77424);
            } else {
                AppMethodBeat.o(77424);
            }
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        AppMethodBeat.i(77425);
        byte[] bArr2 = this.buf;
        if (bArr2 == null) {
            IOException pG = pG();
            AppMethodBeat.o(77425);
            throw pG;
        } else if (i3 == 0) {
            i3 = 0;
            AppMethodBeat.o(77425);
        } else {
            InputStream inputStream = this.in;
            if (inputStream == null) {
                IOException pG2 = pG();
                AppMethodBeat.o(77425);
                throw pG2;
            }
            if (this.pos < this.count) {
                int i6 = this.count - this.pos >= i3 ? i3 : this.count - this.pos;
                System.arraycopy(bArr2, this.pos, bArr, i2, i6);
                this.pos += i6;
                if (i6 == i3 || inputStream.available() == 0) {
                    AppMethodBeat.o(77425);
                    i3 = i6;
                } else {
                    i2 += i6;
                    i4 = i3 - i6;
                }
            } else {
                i4 = i3;
            }
            while (true) {
                if (this.markpos == -1 && i4 >= bArr2.length) {
                    i5 = inputStream.read(bArr, i2, i4);
                    if (i5 == -1) {
                        if (i4 == i3) {
                            AppMethodBeat.o(77425);
                            i3 = -1;
                        } else {
                            i3 -= i4;
                            AppMethodBeat.o(77425);
                        }
                    }
                } else if (a(inputStream, bArr2) == -1) {
                    if (i4 == i3) {
                        AppMethodBeat.o(77425);
                        i3 = -1;
                    } else {
                        i3 -= i4;
                        AppMethodBeat.o(77425);
                    }
                } else if (bArr2 == this.buf || (bArr2 = this.buf) != null) {
                    i5 = this.count - this.pos >= i4 ? i4 : this.count - this.pos;
                    System.arraycopy(bArr2, this.pos, bArr, i2, i5);
                    this.pos += i5;
                } else {
                    IOException pG3 = pG();
                    AppMethodBeat.o(77425);
                    throw pG3;
                }
                i4 -= i5;
                if (i4 == 0) {
                    AppMethodBeat.o(77425);
                    break;
                } else if (inputStream.available() == 0) {
                    i3 -= i4;
                    AppMethodBeat.o(77425);
                    break;
                } else {
                    i2 += i5;
                }
            }
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        AppMethodBeat.i(77426);
        if (this.buf == null) {
            IOException iOException = new IOException("Stream is closed");
            AppMethodBeat.o(77426);
            throw iOException;
        } else if (-1 == this.markpos) {
            a aVar = new a("Mark has been invalidated, pos: " + this.pos + " markLimit: " + this.marklimit);
            AppMethodBeat.o(77426);
            throw aVar;
        } else {
            this.pos = this.markpos;
            AppMethodBeat.o(77426);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j2) {
        AppMethodBeat.i(77427);
        if (j2 < 1) {
            j2 = 0;
            AppMethodBeat.o(77427);
        } else {
            byte[] bArr = this.buf;
            if (bArr == null) {
                IOException pG = pG();
                AppMethodBeat.o(77427);
                throw pG;
            }
            InputStream inputStream = this.in;
            if (inputStream == null) {
                IOException pG2 = pG();
                AppMethodBeat.o(77427);
                throw pG2;
            } else if (((long) (this.count - this.pos)) >= j2) {
                this.pos = (int) (((long) this.pos) + j2);
                AppMethodBeat.o(77427);
            } else {
                long j3 = ((long) this.count) - ((long) this.pos);
                this.pos = this.count;
                if (this.markpos == -1 || j2 > ((long) this.marklimit)) {
                    j2 = j3 + inputStream.skip(j2 - j3);
                    AppMethodBeat.o(77427);
                } else if (a(inputStream, bArr) == -1) {
                    AppMethodBeat.o(77427);
                    j2 = j3;
                } else if (((long) (this.count - this.pos)) >= j2 - j3) {
                    this.pos = (int) ((((long) this.pos) + j2) - j3);
                    AppMethodBeat.o(77427);
                } else {
                    j2 = (j3 + ((long) this.count)) - ((long) this.pos);
                    this.pos = this.count;
                    AppMethodBeat.o(77427);
                }
            }
        }
        return j2;
    }

    /* access modifiers changed from: package-private */
    public static class a extends IOException {
        a(String str) {
            super(str);
        }
    }
}
