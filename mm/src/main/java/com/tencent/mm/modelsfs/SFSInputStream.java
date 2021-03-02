package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

public class SFSInputStream extends InputStream {
    private long mMarkPosition = 0;
    private long mNativePtr;

    private static native int nativeClose(long j2);

    private static native int nativeRead(long j2, byte[] bArr, int i2, int i3);

    private static native long nativeSeek(long j2, long j3, int i2);

    private static native long nativeSize(long j2);

    public SFSInputStream(long j2) {
        this.mNativePtr = j2;
    }

    @Override // java.io.InputStream
    public int available() {
        AppMethodBeat.i(156024);
        if (this.mNativePtr == 0) {
            IOException iOException = new IOException("Stream already closed.");
            AppMethodBeat.o(156024);
            throw iOException;
        }
        long nativeSize = nativeSize(this.mNativePtr);
        if (nativeSize < 0) {
            IOException iOException2 = new IOException(SFSContext.nativeErrorMessage());
            AppMethodBeat.o(156024);
            throw iOException2;
        }
        long nativeSeek = nativeSeek(this.mNativePtr, 0, 1);
        if (nativeSeek < 0) {
            IOException iOException3 = new IOException(SFSContext.nativeErrorMessage());
            AppMethodBeat.o(156024);
            throw iOException3;
        }
        int i2 = (int) (nativeSize - nativeSeek);
        AppMethodBeat.o(156024);
        return i2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() {
        AppMethodBeat.i(156025);
        if (this.mNativePtr == 0) {
            AppMethodBeat.o(156025);
        } else if (nativeClose(this.mNativePtr) == -1) {
            IOException iOException = new IOException(SFSContext.nativeErrorMessage());
            AppMethodBeat.o(156025);
            throw iOException;
        } else {
            this.mNativePtr = 0;
            AppMethodBeat.o(156025);
        }
    }

    public boolean markSupported() {
        return true;
    }

    public void mark(int i2) {
        AppMethodBeat.i(156026);
        if (this.mNativePtr == 0) {
            AppMethodBeat.o(156026);
            return;
        }
        this.mMarkPosition = nativeSeek(this.mNativePtr, 0, 1);
        AppMethodBeat.o(156026);
    }

    @Override // java.io.InputStream
    public void reset() {
        AppMethodBeat.i(156027);
        if (this.mNativePtr == 0) {
            IOException iOException = new IOException("Stream already closed.");
            AppMethodBeat.o(156027);
            throw iOException;
        } else if (this.mMarkPosition < 0) {
            IOException iOException2 = new IOException("Previous call to mark() failed.");
            AppMethodBeat.o(156027);
            throw iOException2;
        } else if (nativeSeek(this.mNativePtr, this.mMarkPosition, 0) != this.mMarkPosition) {
            IOException iOException3 = new IOException("Seeking to previous position failed.");
            AppMethodBeat.o(156027);
            throw iOException3;
        } else {
            AppMethodBeat.o(156027);
        }
    }

    @Override // java.io.InputStream
    public int read() {
        int nativeRead;
        AppMethodBeat.i(156028);
        if (this.mNativePtr == 0) {
            IOException iOException = new IOException("Stream already closed.");
            AppMethodBeat.o(156028);
            throw iOException;
        }
        byte[] bArr = new byte[1];
        do {
            nativeRead = nativeRead(this.mNativePtr, bArr, 0, 1);
        } while (nativeRead == 0);
        if (nativeRead == -1) {
            AppMethodBeat.o(156028);
            return -1;
        }
        byte b2 = bArr[0];
        AppMethodBeat.o(156028);
        return b2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(156029);
        if (this.mNativePtr == 0) {
            IOException iOException = new IOException("Stream already closed.");
            AppMethodBeat.o(156029);
            throw iOException;
        } else if ((i2 | i3) < 0 || i2 > bArr.length || bArr.length - i2 < i3) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException("length = " + bArr.length + ", offset = " + i2 + ", count = " + i3);
            AppMethodBeat.o(156029);
            throw arrayIndexOutOfBoundsException;
        } else {
            int nativeRead = nativeRead(this.mNativePtr, bArr, i2, i3);
            if (nativeRead == 0) {
                AppMethodBeat.o(156029);
                return -1;
            } else if (nativeRead == -1) {
                IOException iOException2 = new IOException(SFSContext.nativeErrorMessage());
                AppMethodBeat.o(156029);
                throw iOException2;
            } else {
                AppMethodBeat.o(156029);
                return nativeRead;
            }
        }
    }

    @Override // java.io.InputStream
    public long skip(long j2) {
        AppMethodBeat.i(156030);
        if (this.mNativePtr == 0) {
            IOException iOException = new IOException("Stream already closed.");
            AppMethodBeat.o(156030);
            throw iOException;
        } else if (j2 < 0) {
            IOException iOException2 = new IOException("byteCount < 0: ".concat(String.valueOf(j2)));
            AppMethodBeat.o(156030);
            throw iOException2;
        } else {
            long nativeSeek = nativeSeek(this.mNativePtr, 0, 1);
            long nativeSeek2 = nativeSeek(this.mNativePtr, j2, 1);
            if (nativeSeek == -1 || nativeSeek2 == -1) {
                IOException iOException3 = new IOException(SFSContext.nativeErrorMessage());
                AppMethodBeat.o(156030);
                throw iOException3;
            }
            long j3 = nativeSeek2 - nativeSeek;
            AppMethodBeat.o(156030);
            return j3;
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        AppMethodBeat.i(156031);
        if (this.mNativePtr != 0) {
            close();
        }
        super.finalize();
        AppMethodBeat.o(156031);
    }
}
