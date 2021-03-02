package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.io.OutputStream;

public class SFSOutputStream extends OutputStream {
    private StackTraceElement[] jiV = Thread.currentThread().getStackTrace();
    private long mNativePtr;

    private static native int nativeClose(long j2);

    private static native int nativeWrite(long j2, byte[] bArr, int i2, int i3);

    public SFSOutputStream(long j2) {
        AppMethodBeat.i(156032);
        this.mNativePtr = j2;
        AppMethodBeat.o(156032);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(156033);
        if (this.mNativePtr == 0) {
            AppMethodBeat.o(156033);
        } else if (nativeClose(this.mNativePtr) == -1) {
            IOException iOException = new IOException(SFSContext.nativeErrorMessage());
            AppMethodBeat.o(156033);
            throw iOException;
        } else {
            this.mNativePtr = 0;
            AppMethodBeat.o(156033);
        }
    }

    @Override // java.io.OutputStream
    public void write(int i2) {
        AppMethodBeat.i(156034);
        if (this.mNativePtr == 0) {
            IOException iOException = new IOException("Stream already closed.");
            AppMethodBeat.o(156034);
            throw iOException;
        }
        if (nativeWrite(this.mNativePtr, new byte[]{(byte) i2}, 0, 1) != 1) {
            IOException iOException2 = new IOException(SFSContext.nativeErrorMessage());
            AppMethodBeat.o(156034);
            throw iOException2;
        }
        AppMethodBeat.o(156034);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(156035);
        if (this.mNativePtr == 0) {
            IOException iOException = new IOException("Stream already closed.");
            AppMethodBeat.o(156035);
            throw iOException;
        } else if ((i2 | i3) < 0 || i2 > bArr.length || bArr.length - i2 < i3) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException("length = " + bArr.length + "offset = " + i2 + "count = " + i3);
            AppMethodBeat.o(156035);
            throw arrayIndexOutOfBoundsException;
        } else if (nativeWrite(this.mNativePtr, bArr, i2, i3) != i3) {
            IOException iOException2 = new IOException(SFSContext.nativeErrorMessage());
            AppMethodBeat.o(156035);
            throw iOException2;
        } else {
            AppMethodBeat.o(156035);
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        AppMethodBeat.i(156036);
        if (this.mNativePtr != 0) {
            StringBuilder sb = new StringBuilder("SFSOutputStream leaked:\n");
            for (StackTraceElement stackTraceElement : this.jiV) {
                sb.append(stackTraceElement.toString()).append('\n');
            }
            Log.e("MicroMsg.SFSOutputStream", sb.toString());
            close();
        }
        super.finalize();
        AppMethodBeat.o(156036);
    }
}
