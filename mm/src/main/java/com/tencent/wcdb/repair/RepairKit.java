package com.tencent.wcdb.repair;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.support.CancellationSignal;

public class RepairKit implements CancellationSignal.OnCancelListener {
    public static final int FLAG_ALL_TABLES = 2;
    public static final int FLAG_CHECK_TABLE_COLUMNS = 4;
    public static final int FLAG_NO_CREATE_TABLES = 1;
    private static final int INTEGRITY_DATA = 2;
    private static final int INTEGRITY_HEADER = 1;
    private static final int INTEGRITY_KDF_SALT = 4;
    public static final int RESULT_CANCELED = 1;
    public static final int RESULT_FAILED = -1;
    public static final int RESULT_IGNORE = 2;
    public static final int RESULT_OK = 0;
    private Callback mCallback;
    private RepairCursor mCurrentCursor;
    private int mIntegrityFlags;
    private MasterInfo mMasterInfo;
    private long mNativePtr;

    public interface Callback {
        int onProgress(String str, int i2, Cursor cursor);
    }

    private static native void nativeCancel(long j2);

    private static native void nativeFini(long j2);

    private static native void nativeFreeMaster(long j2);

    private static native long nativeInit(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, byte[] bArr2);

    private static native int nativeIntegrityFlags(long j2);

    private static native String nativeLastError();

    private static native long nativeLoadMaster(String str, byte[] bArr, String[] strArr, byte[] bArr2);

    private static native long nativeMakeMaster(String[] strArr);

    private native int nativeOutput(long j2, long j3, long j4, int i2);

    private static native boolean nativeSaveMaster(long j2, String str, byte[] bArr);

    static /* synthetic */ long access$300(String[] strArr) {
        AppMethodBeat.i(3371);
        long nativeMakeMaster = nativeMakeMaster(strArr);
        AppMethodBeat.o(3371);
        return nativeMakeMaster;
    }

    static /* synthetic */ long access$400(String str, byte[] bArr, String[] strArr, byte[] bArr2) {
        AppMethodBeat.i(3372);
        long nativeLoadMaster = nativeLoadMaster(str, bArr, strArr, bArr2);
        AppMethodBeat.o(3372);
        return nativeLoadMaster;
    }

    static /* synthetic */ boolean access$500(long j2, String str, byte[] bArr) {
        AppMethodBeat.i(3373);
        boolean nativeSaveMaster = nativeSaveMaster(j2, str, bArr);
        AppMethodBeat.o(3373);
        return nativeSaveMaster;
    }

    static /* synthetic */ void access$600(long j2) {
        AppMethodBeat.i(3374);
        nativeFreeMaster(j2);
        AppMethodBeat.o(3374);
    }

    public RepairKit(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, MasterInfo masterInfo) {
        AppMethodBeat.i(3363);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(3363);
            throw illegalArgumentException;
        }
        this.mNativePtr = nativeInit(str, bArr, sQLiteCipherSpec, masterInfo == null ? null : masterInfo.mKDFSalt);
        if (this.mNativePtr == 0) {
            SQLiteException sQLiteException = new SQLiteException("Failed initialize RepairKit.");
            AppMethodBeat.o(3363);
            throw sQLiteException;
        }
        this.mIntegrityFlags = nativeIntegrityFlags(this.mNativePtr);
        this.mMasterInfo = masterInfo;
        AppMethodBeat.o(3363);
    }

    public Callback getCallback() {
        return this.mCallback;
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void release() {
        AppMethodBeat.i(3364);
        if (this.mMasterInfo != null) {
            this.mMasterInfo.release();
            this.mMasterInfo = null;
        }
        if (this.mNativePtr != 0) {
            nativeFini(this.mNativePtr);
            this.mNativePtr = 0;
        }
        AppMethodBeat.o(3364);
    }

    public int output(SQLiteDatabase sQLiteDatabase, int i2) {
        long j2 = 0;
        AppMethodBeat.i(3365);
        if (this.mNativePtr == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(3365);
            throw illegalArgumentException;
        }
        if (this.mMasterInfo != null) {
            j2 = this.mMasterInfo.mMasterPtr;
        }
        long acquireNativeConnectionHandle = sQLiteDatabase.acquireNativeConnectionHandle("repair", false, false);
        int nativeOutput = nativeOutput(this.mNativePtr, acquireNativeConnectionHandle, j2, i2);
        sQLiteDatabase.releaseNativeConnection(acquireNativeConnectionHandle, null);
        this.mCurrentCursor = null;
        this.mIntegrityFlags = nativeIntegrityFlags(this.mNativePtr);
        AppMethodBeat.o(3365);
        return nativeOutput;
    }

    public int output(SQLiteDatabase sQLiteDatabase, int i2, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3366);
        if (cancellationSignal.isCanceled()) {
            AppMethodBeat.o(3366);
            return 1;
        }
        cancellationSignal.setOnCancelListener(this);
        int output = output(sQLiteDatabase, i2);
        cancellationSignal.setOnCancelListener(null);
        AppMethodBeat.o(3366);
        return output;
    }

    @Override // com.tencent.wcdb.support.CancellationSignal.OnCancelListener
    public void onCancel() {
        AppMethodBeat.i(3367);
        if (this.mNativePtr == 0) {
            AppMethodBeat.o(3367);
            return;
        }
        nativeCancel(this.mNativePtr);
        AppMethodBeat.o(3367);
    }

    private int onProgress(String str, int i2, long j2) {
        AppMethodBeat.i(3368);
        if (this.mCallback == null) {
            AppMethodBeat.o(3368);
            return 0;
        }
        if (this.mCurrentCursor == null) {
            this.mCurrentCursor = new RepairCursor();
        }
        this.mCurrentCursor.mPtr = j2;
        int onProgress = this.mCallback.onProgress(str, i2, this.mCurrentCursor);
        AppMethodBeat.o(3368);
        return onProgress;
    }

    public boolean isSaltCorrupted() {
        return (this.mIntegrityFlags & 4) == 0;
    }

    public boolean isHeaderCorrupted() {
        return (this.mIntegrityFlags & 1) == 0;
    }

    public boolean isDataCorrupted() {
        return (this.mIntegrityFlags & 2) == 0;
    }

    public static String lastError() {
        AppMethodBeat.i(3369);
        String nativeLastError = nativeLastError();
        AppMethodBeat.o(3369);
        return nativeLastError;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(3370);
        release();
        super.finalize();
        AppMethodBeat.o(3370);
    }

    public static class MasterInfo {
        private byte[] mKDFSalt;
        private long mMasterPtr;

        private MasterInfo(long j2, byte[] bArr) {
            this.mMasterPtr = j2;
            this.mKDFSalt = bArr;
        }

        public static MasterInfo make(String[] strArr) {
            AppMethodBeat.i(3346);
            long access$300 = RepairKit.access$300(strArr);
            if (access$300 == 0) {
                SQLiteException sQLiteException = new SQLiteException("Cannot create MasterInfo.");
                AppMethodBeat.o(3346);
                throw sQLiteException;
            }
            MasterInfo masterInfo = new MasterInfo(access$300, null);
            AppMethodBeat.o(3346);
            return masterInfo;
        }

        public static MasterInfo load(String str, byte[] bArr, String[] strArr) {
            AppMethodBeat.i(3347);
            if (str == null) {
                MasterInfo make = make(strArr);
                AppMethodBeat.o(3347);
                return make;
            }
            byte[] bArr2 = new byte[16];
            long access$400 = RepairKit.access$400(str, bArr, strArr, bArr2);
            if (access$400 == 0) {
                SQLiteException sQLiteException = new SQLiteException("Cannot create MasterInfo.");
                AppMethodBeat.o(3347);
                throw sQLiteException;
            }
            MasterInfo masterInfo = new MasterInfo(access$400, bArr2);
            AppMethodBeat.o(3347);
            return masterInfo;
        }

        public static boolean save(SQLiteDatabase sQLiteDatabase, String str, byte[] bArr) {
            AppMethodBeat.i(3348);
            long acquireNativeConnectionHandle = sQLiteDatabase.acquireNativeConnectionHandle("backupMaster", true, false);
            boolean access$500 = RepairKit.access$500(acquireNativeConnectionHandle, str, bArr);
            sQLiteDatabase.releaseNativeConnection(acquireNativeConnectionHandle, null);
            AppMethodBeat.o(3348);
            return access$500;
        }

        public void release() {
            AppMethodBeat.i(3349);
            if (this.mMasterPtr == 0) {
                AppMethodBeat.o(3349);
                return;
            }
            RepairKit.access$600(this.mMasterPtr);
            this.mMasterPtr = 0;
            AppMethodBeat.o(3349);
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            AppMethodBeat.i(3350);
            release();
            super.finalize();
            AppMethodBeat.o(3350);
        }
    }

    /* access modifiers changed from: package-private */
    public static class RepairCursor extends AbstractCursor {
        long mPtr;

        private static native byte[] nativeGetBlob(long j2, int i2);

        private static native int nativeGetColumnCount(long j2);

        private static native double nativeGetDouble(long j2, int i2);

        private static native long nativeGetLong(long j2, int i2);

        private static native String nativeGetString(long j2, int i2);

        private static native int nativeGetType(long j2, int i2);

        private RepairCursor() {
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
        public int getCount() {
            AppMethodBeat.i(3351);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(3351);
            throw unsupportedOperationException;
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
        public String[] getColumnNames() {
            AppMethodBeat.i(3352);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(3352);
            throw unsupportedOperationException;
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
        public int getColumnCount() {
            AppMethodBeat.i(3353);
            int nativeGetColumnCount = nativeGetColumnCount(this.mPtr);
            AppMethodBeat.o(3353);
            return nativeGetColumnCount;
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
        public int getType(int i2) {
            AppMethodBeat.i(3354);
            int nativeGetType = nativeGetType(this.mPtr, i2);
            AppMethodBeat.o(3354);
            return nativeGetType;
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
        public String getString(int i2) {
            AppMethodBeat.i(3355);
            String nativeGetString = nativeGetString(this.mPtr, i2);
            AppMethodBeat.o(3355);
            return nativeGetString;
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
        public short getShort(int i2) {
            AppMethodBeat.i(3356);
            short s = (short) ((int) getLong(i2));
            AppMethodBeat.o(3356);
            return s;
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
        public int getInt(int i2) {
            AppMethodBeat.i(3357);
            int i3 = (int) getLong(i2);
            AppMethodBeat.o(3357);
            return i3;
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
        public long getLong(int i2) {
            AppMethodBeat.i(3358);
            long nativeGetLong = nativeGetLong(this.mPtr, i2);
            AppMethodBeat.o(3358);
            return nativeGetLong;
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
        public float getFloat(int i2) {
            AppMethodBeat.i(3359);
            float f2 = (float) getDouble(i2);
            AppMethodBeat.o(3359);
            return f2;
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
        public double getDouble(int i2) {
            AppMethodBeat.i(3360);
            double nativeGetDouble = nativeGetDouble(this.mPtr, i2);
            AppMethodBeat.o(3360);
            return nativeGetDouble;
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
        public byte[] getBlob(int i2) {
            AppMethodBeat.i(3361);
            byte[] nativeGetBlob = nativeGetBlob(this.mPtr, i2);
            AppMethodBeat.o(3361);
            return nativeGetBlob;
        }

        @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
        public boolean isNull(int i2) {
            AppMethodBeat.i(3362);
            if (getType(i2) == 0) {
                AppMethodBeat.o(3362);
                return true;
            }
            AppMethodBeat.o(3362);
            return false;
        }
    }
}
