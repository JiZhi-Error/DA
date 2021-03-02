package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.CursorWindowAllocationException;

public class ChunkedCursorWindow extends SQLiteClosable {
    public static final long CHUNK_NOT_FOUND = -1;
    private int mNumColumns = 0;
    long mWindowPtr;

    private static native void nativeClear(long j2);

    private static native long nativeCreate(int i2);

    private static native void nativeDispose(long j2);

    private static native void nativeEndRow(long j2, long j3);

    private static native byte[] nativeGetBlob(long j2, int i2);

    private static native double nativeGetDouble(long j2, int i2);

    private static native long nativeGetLong(long j2, int i2);

    private static native int nativeGetNumChunks(long j2);

    private static native long nativeGetRow(long j2, int i2);

    private static native String nativeGetString(long j2, int i2);

    private static native int nativeGetType(long j2, int i2);

    private static native long nativeRemoveChunk(long j2, int i2);

    private static native boolean nativeSetNumColumns(long j2, int i2);

    public ChunkedCursorWindow(int i2) {
        AppMethodBeat.i(2892);
        this.mWindowPtr = nativeCreate(i2);
        if (this.mWindowPtr == 0) {
            CursorWindowAllocationException cursorWindowAllocationException = new CursorWindowAllocationException("Cursor window allocation failed.");
            AppMethodBeat.o(2892);
            throw cursorWindowAllocationException;
        }
        AppMethodBeat.o(2892);
    }

    private void dispose() {
        AppMethodBeat.i(2893);
        if (this.mWindowPtr != 0) {
            nativeDispose(this.mWindowPtr);
            this.mWindowPtr = 0;
        }
        AppMethodBeat.o(2893);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        AppMethodBeat.i(2894);
        try {
            dispose();
        } finally {
            super.finalize();
            AppMethodBeat.o(2894);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.wcdb.database.SQLiteClosable
    public void onAllReferencesReleased() {
        AppMethodBeat.i(2895);
        dispose();
        AppMethodBeat.o(2895);
    }

    public void clear() {
        AppMethodBeat.i(2896);
        acquireReference();
        try {
            nativeClear(this.mWindowPtr);
        } finally {
            releaseReference();
            AppMethodBeat.o(2896);
        }
    }

    public long removeChunk(int i2) {
        AppMethodBeat.i(2897);
        acquireReference();
        try {
            return nativeRemoveChunk(this.mWindowPtr, i2);
        } finally {
            releaseReference();
            AppMethodBeat.o(2897);
        }
    }

    public int getNumChunks() {
        AppMethodBeat.i(2898);
        acquireReference();
        try {
            return nativeGetNumChunks(this.mWindowPtr);
        } finally {
            releaseReference();
            AppMethodBeat.o(2898);
        }
    }

    public int getNumColumns() {
        return this.mNumColumns;
    }

    public boolean setNumColumns(int i2) {
        AppMethodBeat.i(2899);
        acquireReference();
        try {
            boolean nativeSetNumColumns = nativeSetNumColumns(this.mWindowPtr, i2);
            if (nativeSetNumColumns) {
                this.mNumColumns = i2;
            }
            return nativeSetNumColumns;
        } finally {
            releaseReference();
            AppMethodBeat.o(2899);
        }
    }

    /* access modifiers changed from: package-private */
    public long getRowUnsafe(int i2) {
        AppMethodBeat.i(2900);
        acquireReference();
        long nativeGetRow = nativeGetRow(this.mWindowPtr, i2);
        if (nativeGetRow == 0) {
            releaseReference();
        }
        AppMethodBeat.o(2900);
        return nativeGetRow;
    }

    /* access modifiers changed from: package-private */
    public void endRowUnsafe(long j2) {
        AppMethodBeat.i(2901);
        if (j2 == 0) {
            AppMethodBeat.o(2901);
            return;
        }
        nativeEndRow(this.mWindowPtr, j2);
        releaseReference();
        AppMethodBeat.o(2901);
    }

    /* access modifiers changed from: package-private */
    public int getTypeUnsafe(long j2, int i2) {
        AppMethodBeat.i(2902);
        int nativeGetType = nativeGetType(j2, i2);
        AppMethodBeat.o(2902);
        return nativeGetType;
    }

    /* access modifiers changed from: package-private */
    public byte[] getBlobUnsafe(long j2, int i2) {
        AppMethodBeat.i(2903);
        byte[] nativeGetBlob = nativeGetBlob(j2, i2);
        AppMethodBeat.o(2903);
        return nativeGetBlob;
    }

    /* access modifiers changed from: package-private */
    public String getStringUnsafe(long j2, int i2) {
        AppMethodBeat.i(2904);
        String nativeGetString = nativeGetString(j2, i2);
        AppMethodBeat.o(2904);
        return nativeGetString;
    }

    /* access modifiers changed from: package-private */
    public long getLongUnsafe(long j2, int i2) {
        AppMethodBeat.i(2905);
        long nativeGetLong = nativeGetLong(j2, i2);
        AppMethodBeat.o(2905);
        return nativeGetLong;
    }

    /* access modifiers changed from: package-private */
    public double getDoubleUnsafe(long j2, int i2) {
        AppMethodBeat.i(2906);
        double nativeGetDouble = nativeGetDouble(j2, i2);
        AppMethodBeat.o(2906);
        return nativeGetDouble;
    }

    public int getType(int i2, int i3) {
        AppMethodBeat.i(2907);
        long rowUnsafe = getRowUnsafe(i2);
        if (rowUnsafe == 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Couldn't read row " + i2 + ", column " + i3 + " from ChunkedCursorWindow.");
            AppMethodBeat.o(2907);
            throw illegalStateException;
        }
        try {
            return nativeGetType(rowUnsafe, i3);
        } finally {
            endRowUnsafe(rowUnsafe);
            AppMethodBeat.o(2907);
        }
    }

    public byte[] getBlob(int i2, int i3) {
        AppMethodBeat.i(2908);
        long rowUnsafe = getRowUnsafe(i2);
        if (rowUnsafe == 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Couldn't read row " + i2 + ", column " + i3 + " from ChunkedCursorWindow.");
            AppMethodBeat.o(2908);
            throw illegalStateException;
        }
        try {
            return nativeGetBlob(rowUnsafe, i3);
        } finally {
            endRowUnsafe(rowUnsafe);
            AppMethodBeat.o(2908);
        }
    }

    public String getString(int i2, int i3) {
        AppMethodBeat.i(2909);
        long rowUnsafe = getRowUnsafe(i2);
        if (rowUnsafe == 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Couldn't read row " + i2 + ", column " + i3 + " from ChunkedCursorWindow.");
            AppMethodBeat.o(2909);
            throw illegalStateException;
        }
        try {
            return nativeGetString(rowUnsafe, i3);
        } finally {
            endRowUnsafe(rowUnsafe);
            AppMethodBeat.o(2909);
        }
    }

    public long getLong(int i2, int i3) {
        AppMethodBeat.i(2910);
        long rowUnsafe = getRowUnsafe(i2);
        if (rowUnsafe == 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Couldn't read row " + i2 + ", column " + i3 + " from ChunkedCursorWindow.");
            AppMethodBeat.o(2910);
            throw illegalStateException;
        }
        try {
            return nativeGetLong(rowUnsafe, i3);
        } finally {
            endRowUnsafe(rowUnsafe);
            AppMethodBeat.o(2910);
        }
    }

    public double getDouble(int i2, int i3) {
        AppMethodBeat.i(2911);
        long rowUnsafe = getRowUnsafe(i2);
        if (rowUnsafe == 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Couldn't read row " + i2 + ", column " + i3 + " from ChunkedCursorWindow.");
            AppMethodBeat.o(2911);
            throw illegalStateException;
        }
        try {
            return nativeGetDouble(rowUnsafe, i3);
        } finally {
            endRowUnsafe(rowUnsafe);
            AppMethodBeat.o(2911);
        }
    }
}
