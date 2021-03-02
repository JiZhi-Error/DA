package com.tencent.wcdb;

import android.content.res.Resources;
import android.database.CharArrayBuffer;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import com.tencent.wcdb.database.SQLiteClosable;

public class CursorWindow extends SQLiteClosable implements Parcelable {
    public static final Parcelable.Creator<CursorWindow> CREATOR = new Parcelable.Creator<CursorWindow>() {
        /* class com.tencent.wcdb.CursorWindow.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final CursorWindow createFromParcel(Parcel parcel) {
            AppMethodBeat.i(2702);
            CursorWindow cursorWindow = new CursorWindow(parcel);
            AppMethodBeat.o(2702);
            return cursorWindow;
        }

        @Override // android.os.Parcelable.Creator
        public final CursorWindow[] newArray(int i2) {
            return new CursorWindow[i2];
        }
    };
    private static final String STATS_TAG = "WCDB.CursorWindowStats";
    private static int sCursorWindowSize;
    private final String mName;
    private int mStartPos;
    public long mWindowPtr;

    private static native boolean nativeAllocRow(long j2);

    private static native void nativeClear(long j2);

    private static native void nativeCopyStringToBuffer(long j2, int i2, int i3, CharArrayBuffer charArrayBuffer);

    private static native long nativeCreate(String str, int i2);

    private static native void nativeDispose(long j2);

    private static native void nativeFreeLastRow(long j2);

    private static native byte[] nativeGetBlob(long j2, int i2, int i3);

    private static native double nativeGetDouble(long j2, int i2, int i3);

    private static native long nativeGetLong(long j2, int i2, int i3);

    private static native int nativeGetNumRows(long j2);

    private static native String nativeGetString(long j2, int i2, int i3);

    private static native int nativeGetType(long j2, int i2, int i3);

    private static native boolean nativePutBlob(long j2, byte[] bArr, int i2, int i3);

    private static native boolean nativePutDouble(long j2, double d2, int i2, int i3);

    private static native boolean nativePutLong(long j2, long j3, int i2, int i3);

    private static native boolean nativePutNull(long j2, int i2, int i3);

    private static native boolean nativePutString(long j2, String str, int i2, int i3);

    private static native boolean nativeSetNumColumns(long j2, int i2);

    static {
        AppMethodBeat.i(2737);
        int identifier = Resources.getSystem().getIdentifier("config_cursorWindowSize", "integer", "android");
        if (identifier != 0) {
            sCursorWindowSize = Resources.getSystem().getInteger(identifier) * 1024;
        } else {
            sCursorWindowSize = TPMediaCodecProfileLevel.HEVCHighTierLevel6;
        }
        AppMethodBeat.o(2737);
    }

    public static int windowSize(int i2) {
        int i3 = sCursorWindowSize;
        if (i2 > 0) {
            sCursorWindowSize = i2;
        }
        return i3;
    }

    public CursorWindow(String str) {
        AppMethodBeat.i(2705);
        this.mStartPos = 0;
        this.mName = (str == null || str.length() == 0) ? "<unnamed>" : str;
        this.mWindowPtr = nativeCreate(this.mName, sCursorWindowSize);
        if (this.mWindowPtr == 0) {
            CursorWindowAllocationException cursorWindowAllocationException = new CursorWindowAllocationException("Cursor window allocation of " + (sCursorWindowSize / 1024) + " kb failed. ");
            AppMethodBeat.o(2705);
            throw cursorWindowAllocationException;
        }
        AppMethodBeat.o(2705);
    }

    @Deprecated
    public CursorWindow(boolean z) {
        this((String) null);
    }

    private CursorWindow(Parcel parcel) {
        AppMethodBeat.i(2706);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(2706);
        throw unsupportedOperationException;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        AppMethodBeat.i(2707);
        try {
            dispose();
        } finally {
            super.finalize();
            AppMethodBeat.o(2707);
        }
    }

    private void dispose() {
        AppMethodBeat.i(2708);
        if (this.mWindowPtr != 0) {
            nativeDispose(this.mWindowPtr);
            this.mWindowPtr = 0;
        }
        AppMethodBeat.o(2708);
    }

    public String getName() {
        return this.mName;
    }

    public void clear() {
        AppMethodBeat.i(2709);
        acquireReference();
        try {
            this.mStartPos = 0;
            nativeClear(this.mWindowPtr);
        } finally {
            releaseReference();
            AppMethodBeat.o(2709);
        }
    }

    public int getStartPosition() {
        return this.mStartPos;
    }

    public void setStartPosition(int i2) {
        this.mStartPos = i2;
    }

    public int getNumRows() {
        AppMethodBeat.i(2710);
        acquireReference();
        try {
            return nativeGetNumRows(this.mWindowPtr);
        } finally {
            releaseReference();
            AppMethodBeat.o(2710);
        }
    }

    public boolean setNumColumns(int i2) {
        AppMethodBeat.i(2711);
        acquireReference();
        try {
            return nativeSetNumColumns(this.mWindowPtr, i2);
        } finally {
            releaseReference();
            AppMethodBeat.o(2711);
        }
    }

    public boolean allocRow() {
        AppMethodBeat.i(2712);
        acquireReference();
        try {
            return nativeAllocRow(this.mWindowPtr);
        } finally {
            releaseReference();
            AppMethodBeat.o(2712);
        }
    }

    public void freeLastRow() {
        AppMethodBeat.i(2713);
        acquireReference();
        try {
            nativeFreeLastRow(this.mWindowPtr);
        } finally {
            releaseReference();
            AppMethodBeat.o(2713);
        }
    }

    @Deprecated
    public boolean isNull(int i2, int i3) {
        AppMethodBeat.i(2714);
        if (getType(i2, i3) == 0) {
            AppMethodBeat.o(2714);
            return true;
        }
        AppMethodBeat.o(2714);
        return false;
    }

    @Deprecated
    public boolean isBlob(int i2, int i3) {
        AppMethodBeat.i(2715);
        int type = getType(i2, i3);
        if (type == 4 || type == 0) {
            AppMethodBeat.o(2715);
            return true;
        }
        AppMethodBeat.o(2715);
        return false;
    }

    @Deprecated
    public boolean isLong(int i2, int i3) {
        AppMethodBeat.i(2716);
        if (getType(i2, i3) == 1) {
            AppMethodBeat.o(2716);
            return true;
        }
        AppMethodBeat.o(2716);
        return false;
    }

    @Deprecated
    public boolean isFloat(int i2, int i3) {
        AppMethodBeat.i(2717);
        if (getType(i2, i3) == 2) {
            AppMethodBeat.o(2717);
            return true;
        }
        AppMethodBeat.o(2717);
        return false;
    }

    @Deprecated
    public boolean isString(int i2, int i3) {
        AppMethodBeat.i(2718);
        int type = getType(i2, i3);
        if (type == 3 || type == 0) {
            AppMethodBeat.o(2718);
            return true;
        }
        AppMethodBeat.o(2718);
        return false;
    }

    public int getType(int i2, int i3) {
        AppMethodBeat.i(2719);
        acquireReference();
        try {
            return nativeGetType(this.mWindowPtr, i2 - this.mStartPos, i3);
        } finally {
            releaseReference();
            AppMethodBeat.o(2719);
        }
    }

    public byte[] getBlob(int i2, int i3) {
        AppMethodBeat.i(2720);
        acquireReference();
        try {
            return nativeGetBlob(this.mWindowPtr, i2 - this.mStartPos, i3);
        } finally {
            releaseReference();
            AppMethodBeat.o(2720);
        }
    }

    public String getString(int i2, int i3) {
        AppMethodBeat.i(2721);
        acquireReference();
        try {
            return nativeGetString(this.mWindowPtr, i2 - this.mStartPos, i3);
        } finally {
            releaseReference();
            AppMethodBeat.o(2721);
        }
    }

    public void copyStringToBuffer(int i2, int i3, CharArrayBuffer charArrayBuffer) {
        AppMethodBeat.i(2722);
        if (charArrayBuffer == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("CharArrayBuffer should not be null");
            AppMethodBeat.o(2722);
            throw illegalArgumentException;
        }
        acquireReference();
        try {
            nativeCopyStringToBuffer(this.mWindowPtr, i2 - this.mStartPos, i3, charArrayBuffer);
        } finally {
            releaseReference();
            AppMethodBeat.o(2722);
        }
    }

    public long getLong(int i2, int i3) {
        AppMethodBeat.i(2723);
        acquireReference();
        try {
            return nativeGetLong(this.mWindowPtr, i2 - this.mStartPos, i3);
        } finally {
            releaseReference();
            AppMethodBeat.o(2723);
        }
    }

    public double getDouble(int i2, int i3) {
        AppMethodBeat.i(2724);
        acquireReference();
        try {
            return nativeGetDouble(this.mWindowPtr, i2 - this.mStartPos, i3);
        } finally {
            releaseReference();
            AppMethodBeat.o(2724);
        }
    }

    public short getShort(int i2, int i3) {
        AppMethodBeat.i(2725);
        short s = (short) ((int) getLong(i2, i3));
        AppMethodBeat.o(2725);
        return s;
    }

    public int getInt(int i2, int i3) {
        AppMethodBeat.i(2726);
        int i4 = (int) getLong(i2, i3);
        AppMethodBeat.o(2726);
        return i4;
    }

    public float getFloat(int i2, int i3) {
        AppMethodBeat.i(2727);
        float f2 = (float) getDouble(i2, i3);
        AppMethodBeat.o(2727);
        return f2;
    }

    public boolean putBlob(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(2728);
        acquireReference();
        try {
            return nativePutBlob(this.mWindowPtr, bArr, i2 - this.mStartPos, i3);
        } finally {
            releaseReference();
            AppMethodBeat.o(2728);
        }
    }

    public boolean putString(String str, int i2, int i3) {
        AppMethodBeat.i(2729);
        acquireReference();
        try {
            return nativePutString(this.mWindowPtr, str, i2 - this.mStartPos, i3);
        } finally {
            releaseReference();
            AppMethodBeat.o(2729);
        }
    }

    public boolean putLong(long j2, int i2, int i3) {
        AppMethodBeat.i(2730);
        acquireReference();
        try {
            return nativePutLong(this.mWindowPtr, j2, i2 - this.mStartPos, i3);
        } finally {
            releaseReference();
            AppMethodBeat.o(2730);
        }
    }

    public boolean putDouble(double d2, int i2, int i3) {
        AppMethodBeat.i(2731);
        acquireReference();
        try {
            return nativePutDouble(this.mWindowPtr, d2, i2 - this.mStartPos, i3);
        } finally {
            releaseReference();
            AppMethodBeat.o(2731);
        }
    }

    public boolean putNull(int i2, int i3) {
        AppMethodBeat.i(2732);
        acquireReference();
        try {
            return nativePutNull(this.mWindowPtr, i2 - this.mStartPos, i3);
        } finally {
            releaseReference();
            AppMethodBeat.o(2732);
        }
    }

    public static CursorWindow newFromParcel(Parcel parcel) {
        AppMethodBeat.i(2733);
        CursorWindow createFromParcel = CREATOR.createFromParcel(parcel);
        AppMethodBeat.o(2733);
        return createFromParcel;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(2734);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(2734);
        throw unsupportedOperationException;
    }

    @Override // com.tencent.wcdb.database.SQLiteClosable
    public void onAllReferencesReleased() {
        AppMethodBeat.i(2735);
        dispose();
        AppMethodBeat.o(2735);
    }

    public String toString() {
        AppMethodBeat.i(2736);
        String str = getName() + " {" + Long.toHexString(this.mWindowPtr) + "}";
        AppMethodBeat.o(2736);
        return str;
    }
}
