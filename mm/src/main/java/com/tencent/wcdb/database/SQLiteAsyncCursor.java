package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.CursorIndexOutOfBoundsException;
import com.tencent.wcdb.StaleDataException;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.support.CancellationSignal;

public class SQLiteAsyncCursor extends AbstractCursor {
    public static final SQLiteDatabase.CursorFactory FACTORY = new SQLiteDatabase.CursorFactory() {
        /* class com.tencent.wcdb.database.SQLiteAsyncCursor.AnonymousClass1 */

        @Override // com.tencent.wcdb.database.SQLiteDatabase.CursorFactory
        public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteProgram sQLiteProgram) {
            AppMethodBeat.i(2920);
            SQLiteAsyncCursor sQLiteAsyncCursor = new SQLiteAsyncCursor(sQLiteCursorDriver, str, (SQLiteAsyncQuery) sQLiteProgram);
            AppMethodBeat.o(2920);
            return sQLiteAsyncCursor;
        }

        @Override // com.tencent.wcdb.database.SQLiteDatabase.CursorFactory
        public final SQLiteProgram newQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
            AppMethodBeat.i(2921);
            SQLiteAsyncQuery sQLiteAsyncQuery = new SQLiteAsyncQuery(sQLiteDatabase, str, objArr, cancellationSignal);
            AppMethodBeat.o(2921);
            return sQLiteAsyncQuery;
        }
    };
    private static final int MAX_KEEP_CHUNKS = 32;
    private static final int MAX_PREFETCH = 256;
    private static final int MIN_FETCH_ROWS = 32;
    private static final String TAG = "WCDB.SQLiteAsyncCursor";
    private final String[] mColumns;
    private volatile int mCount;
    private long mCurrentRow;
    private final SQLiteCursorDriver mDriver;
    private final SQLiteAsyncQuery mQuery;
    private QueryThread mQueryThread;
    private final Object mWaitLock;
    private ChunkedCursorWindow mWindow;

    public SQLiteAsyncCursor(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteAsyncQuery sQLiteAsyncQuery) {
        AppMethodBeat.i(2925);
        if (sQLiteAsyncQuery == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("query object cannot be null");
            AppMethodBeat.o(2925);
            throw illegalArgumentException;
        }
        this.mQuery = sQLiteAsyncQuery;
        this.mDriver = sQLiteCursorDriver;
        this.mColumns = sQLiteAsyncQuery.getColumnNames();
        this.mCount = -1;
        this.mWaitLock = new Object();
        this.mWindow = new ChunkedCursorWindow(TPMediaCodecProfileLevel.HEVCMainTierLevel62);
        this.mQueryThread = new QueryThread();
        this.mQueryThread.start();
        AppMethodBeat.o(2925);
    }

    @Override // java.io.Closeable, com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(2926);
        super.close();
        this.mQuery.close();
        this.mDriver.cursorClosed();
        AppMethodBeat.o(2926);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public void deactivate() {
        AppMethodBeat.i(2927);
        super.deactivate();
        this.mDriver.cursorDeactivated();
        AppMethodBeat.o(2927);
    }

    @Override // com.tencent.wcdb.AbstractCursor
    public void onDeactivateOrClose() {
        AppMethodBeat.i(2928);
        if (this.mCurrentRow != 0) {
            this.mWindow.endRowUnsafe(this.mCurrentRow);
            this.mCurrentRow = 0;
        }
        if (this.mQueryThread != null) {
            this.mQueryThread.quit();
            try {
                this.mQueryThread.join();
            } catch (InterruptedException e2) {
            }
            this.mQueryThread = null;
        }
        if (this.mWindow != null) {
            this.mWindow.close();
            this.mWindow = null;
        }
        this.mCount = -1;
        this.mPos = -1;
        super.onDeactivateOrClose();
        AppMethodBeat.o(2928);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public String[] getColumnNames() {
        return this.mColumns;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public int getCount() {
        AppMethodBeat.i(2929);
        if (this.mCount >= 0) {
            int i2 = this.mCount;
            AppMethodBeat.o(2929);
            return i2;
        } else if (this.mWindow == null) {
            AppMethodBeat.o(2929);
            return -1;
        } else {
            try {
                synchronized (this.mWaitLock) {
                    while (this.mCount < 0) {
                        try {
                            this.mWaitLock.wait();
                        } catch (Throwable th) {
                            AppMethodBeat.o(2929);
                            throw th;
                        }
                    }
                }
            } catch (InterruptedException e2) {
            }
            int i3 = this.mCount;
            AppMethodBeat.o(2929);
            return i3;
        }
    }

    private boolean isValidPosition(int i2) {
        AppMethodBeat.i(2930);
        if (i2 < 0 || i2 >= getCount()) {
            AppMethodBeat.o(2930);
            return false;
        }
        AppMethodBeat.o(2930);
        return true;
    }

    private long waitForRow(int i2) {
        long rowUnsafe;
        AppMethodBeat.i(2931);
        try {
            synchronized (this.mWaitLock) {
                while (true) {
                    try {
                        rowUnsafe = this.mWindow.getRowUnsafe(i2);
                        if (rowUnsafe == 0) {
                            if (!isValidPosition(i2)) {
                                CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException(this.mPos, this.mCount);
                                AppMethodBeat.o(2931);
                                throw cursorIndexOutOfBoundsException;
                            }
                            this.mWaitLock.wait();
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(2931);
                        throw th;
                    }
                }
            }
            AppMethodBeat.o(2931);
            return rowUnsafe;
        } catch (InterruptedException e2) {
            AppMethodBeat.o(2931);
            return 0;
        }
    }

    private boolean requestRow() {
        AppMethodBeat.i(2932);
        if (this.mWindow == null) {
            AppMethodBeat.o(2932);
            return false;
        } else if (!isValidPosition(this.mPos)) {
            AppMethodBeat.o(2932);
            return false;
        } else {
            this.mQueryThread.requestPos(this.mPos);
            this.mCurrentRow = this.mWindow.getRowUnsafe(this.mPos);
            if (this.mCurrentRow == 0) {
                this.mCurrentRow = waitForRow(this.mPos);
            }
            if (this.mCurrentRow != 0) {
                AppMethodBeat.o(2932);
                return true;
            }
            AppMethodBeat.o(2932);
            return false;
        }
    }

    private void checkValidRow() {
        AppMethodBeat.i(2933);
        if (this.mCurrentRow != 0) {
            AppMethodBeat.o(2933);
        } else if (!isValidPosition(this.mPos)) {
            CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException(this.mPos, this.mCount);
            AppMethodBeat.o(2933);
            throw cursorIndexOutOfBoundsException;
        } else {
            StaleDataException staleDataException = new StaleDataException("Cannot get valid Row object");
            AppMethodBeat.o(2933);
            throw staleDataException;
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public boolean moveToPosition(int i2) {
        AppMethodBeat.i(2934);
        if (i2 < -1) {
            i2 = -1;
        }
        if (i2 != this.mPos) {
            this.mWindow.endRowUnsafe(this.mCurrentRow);
            this.mCurrentRow = 0;
        }
        int count = getCount();
        if (i2 >= count) {
            this.mPos = count;
            AppMethodBeat.o(2934);
            return false;
        }
        this.mPos = i2;
        if (i2 < 0 || !requestRow()) {
            AppMethodBeat.o(2934);
            return false;
        }
        AppMethodBeat.o(2934);
        return true;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public int getType(int i2) {
        AppMethodBeat.i(2935);
        checkValidRow();
        int typeUnsafe = this.mWindow.getTypeUnsafe(this.mCurrentRow, i2);
        AppMethodBeat.o(2935);
        return typeUnsafe;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public byte[] getBlob(int i2) {
        AppMethodBeat.i(2936);
        checkValidRow();
        byte[] blobUnsafe = this.mWindow.getBlobUnsafe(this.mCurrentRow, i2);
        AppMethodBeat.o(2936);
        return blobUnsafe;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public String getString(int i2) {
        AppMethodBeat.i(2937);
        checkValidRow();
        String stringUnsafe = this.mWindow.getStringUnsafe(this.mCurrentRow, i2);
        AppMethodBeat.o(2937);
        return stringUnsafe;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public short getShort(int i2) {
        AppMethodBeat.i(2938);
        short s = (short) ((int) getLong(i2));
        AppMethodBeat.o(2938);
        return s;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public int getInt(int i2) {
        AppMethodBeat.i(2939);
        int i3 = (int) getLong(i2);
        AppMethodBeat.o(2939);
        return i3;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public long getLong(int i2) {
        AppMethodBeat.i(2940);
        checkValidRow();
        long longUnsafe = this.mWindow.getLongUnsafe(this.mCurrentRow, i2);
        AppMethodBeat.o(2940);
        return longUnsafe;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public float getFloat(int i2) {
        AppMethodBeat.i(2941);
        float f2 = (float) getDouble(i2);
        AppMethodBeat.o(2941);
        return f2;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public double getDouble(int i2) {
        AppMethodBeat.i(2942);
        checkValidRow();
        double doubleUnsafe = this.mWindow.getDoubleUnsafe(this.mCurrentRow, i2);
        AppMethodBeat.o(2942);
        return doubleUnsafe;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public boolean isNull(int i2) {
        AppMethodBeat.i(2943);
        if (getType(i2) == 0) {
            AppMethodBeat.o(2943);
            return true;
        }
        AppMethodBeat.o(2943);
        return false;
    }

    /* access modifiers changed from: package-private */
    public class QueryThread extends Thread {
        private int mFetchPos = 0;
        private int mMinPos = 0;
        private volatile int mRequestPos = 0;

        QueryThread() {
            super("SQLiteAsyncCursor.QueryThread");
        }

        public void run() {
            int i2;
            int i3;
            int fillRows;
            AppMethodBeat.i(2922);
            try {
                int count = SQLiteAsyncCursor.this.mQuery.getCount();
                synchronized (SQLiteAsyncCursor.this.mWaitLock) {
                    try {
                        SQLiteAsyncCursor.this.mCount = count;
                        SQLiteAsyncCursor.this.mWaitLock.notifyAll();
                    } finally {
                        AppMethodBeat.o(2922);
                    }
                }
                while (!interrupted()) {
                    synchronized (this) {
                        while (this.mRequestPos + 256 <= this.mFetchPos && this.mRequestPos >= this.mMinPos) {
                            try {
                                wait();
                            } finally {
                                AppMethodBeat.o(2922);
                            }
                        }
                        i2 = this.mRequestPos;
                        i3 = i2 + 256;
                    }
                    if (i2 < this.mMinPos) {
                        SQLiteAsyncCursor.this.mQuery.reset();
                        this.mFetchPos = 0;
                        SQLiteAsyncCursor.this.mWindow.clear();
                        this.mMinPos = 0;
                    }
                    if (this.mFetchPos < i3) {
                        if (SQLiteAsyncCursor.this.mWindow.getNumChunks() > 32) {
                            long removeChunk = SQLiteAsyncCursor.this.mWindow.removeChunk(this.mMinPos);
                            if (removeChunk != -1) {
                                this.mMinPos = (int) removeChunk;
                            }
                        }
                        synchronized (SQLiteAsyncCursor.this.mWaitLock) {
                            try {
                                fillRows = SQLiteAsyncCursor.this.mQuery.fillRows(SQLiteAsyncCursor.this.mWindow, this.mFetchPos, 32);
                                if (this.mFetchPos <= i2 && this.mFetchPos + fillRows > i2) {
                                    SQLiteAsyncCursor.this.mWaitLock.notifyAll();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        this.mFetchPos += fillRows;
                    }
                }
            } catch (InterruptedException e2) {
            } finally {
                SQLiteAsyncCursor.this.mQuery.release();
                AppMethodBeat.o(2922);
            }
        }

        /* access modifiers changed from: package-private */
        public void requestPos(int i2) {
            AppMethodBeat.i(2923);
            synchronized (this) {
                try {
                    this.mRequestPos = i2;
                    notifyAll();
                } finally {
                    AppMethodBeat.o(2923);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void quit() {
            AppMethodBeat.i(2924);
            interrupt();
            AppMethodBeat.o(2924);
        }
    }

    static {
        AppMethodBeat.i(2944);
        AppMethodBeat.o(2944);
    }
}
