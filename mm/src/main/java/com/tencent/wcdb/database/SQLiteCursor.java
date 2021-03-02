package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.AbstractWindowedCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.util.HashMap;
import java.util.Map;

public class SQLiteCursor extends AbstractWindowedCursor {
    public static final SQLiteDatabase.CursorFactory FACTORY = new SQLiteDatabase.CursorFactory() {
        /* class com.tencent.wcdb.database.SQLiteCursor.AnonymousClass1 */

        @Override // com.tencent.wcdb.database.SQLiteDatabase.CursorFactory
        public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteProgram sQLiteProgram) {
            AppMethodBeat.i(3089);
            SQLiteCursor sQLiteCursor = new SQLiteCursor(sQLiteCursorDriver, str, (SQLiteQuery) sQLiteProgram);
            AppMethodBeat.o(3089);
            return sQLiteCursor;
        }

        @Override // com.tencent.wcdb.database.SQLiteDatabase.CursorFactory
        public final SQLiteProgram newQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
            AppMethodBeat.i(3090);
            SQLiteQuery sQLiteQuery = new SQLiteQuery(sQLiteDatabase, str, objArr, cancellationSignal);
            AppMethodBeat.o(3090);
            return sQLiteQuery;
        }
    };
    static final int NO_COUNT = -1;
    static final String TAG = "WCDB.SQLiteCursor";
    private Map<String, Integer> mColumnNameMap;
    private final String[] mColumns;
    private int mCount;
    private int mCursorWindowCapacity;
    private final SQLiteCursorDriver mDriver;
    private final SQLiteQuery mQuery;

    @Deprecated
    public SQLiteCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        this(sQLiteCursorDriver, str, sQLiteQuery);
    }

    public SQLiteCursor(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        AppMethodBeat.i(3091);
        this.mCount = -1;
        if (sQLiteQuery == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("query object cannot be null");
            AppMethodBeat.o(3091);
            throw illegalArgumentException;
        }
        this.mDriver = sQLiteCursorDriver;
        this.mColumnNameMap = null;
        this.mQuery = sQLiteQuery;
        this.mColumns = sQLiteQuery.getColumnNames();
        this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
        AppMethodBeat.o(3091);
    }

    public SQLiteDatabase getDatabase() {
        AppMethodBeat.i(3092);
        SQLiteDatabase database = this.mQuery.getDatabase();
        AppMethodBeat.o(3092);
        return database;
    }

    @Override // com.tencent.wcdb.CrossProcessCursor, com.tencent.wcdb.AbstractCursor
    public boolean onMove(int i2, int i3) {
        AppMethodBeat.i(3093);
        if (this.mWindow == null || i3 < this.mWindow.getStartPosition() || i3 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
            fillWindow(i3);
            int startPosition = this.mWindow.getStartPosition() + this.mWindow.getNumRows();
            if (i3 >= startPosition) {
                this.mCount = startPosition;
            }
        }
        AppMethodBeat.o(3093);
        return true;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public boolean moveToPosition(int i2) {
        AppMethodBeat.i(193937);
        if (!super.moveToPosition(i2)) {
            AppMethodBeat.o(193937);
            return false;
        }
        int count = getCount();
        if (i2 >= count) {
            this.mPos = count;
            AppMethodBeat.o(193937);
            return false;
        }
        AppMethodBeat.o(193937);
        return true;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public int getCount() {
        AppMethodBeat.i(3094);
        if (this.mCount == -1) {
            fillWindow(0);
        }
        int i2 = this.mCount;
        AppMethodBeat.o(3094);
        return i2;
    }

    private void fillWindow(int i2) {
        AppMethodBeat.i(3095);
        clearOrCreateWindow(getDatabase().getPath());
        try {
            if (this.mCount == -1) {
                this.mCount = this.mQuery.fillWindow(this.mWindow, DatabaseUtils.cursorPickFillWindowStartPosition(i2, 0), i2, true);
                this.mCursorWindowCapacity = this.mWindow.getNumRows();
                AppMethodBeat.o(3095);
                return;
            }
            this.mQuery.fillWindow(this.mWindow, DatabaseUtils.cursorPickFillWindowStartPosition(i2, this.mCursorWindowCapacity), i2, false);
            AppMethodBeat.o(3095);
        } catch (RuntimeException e2) {
            closeWindow();
            AppMethodBeat.o(3095);
            throw e2;
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public int getColumnIndex(String str) {
        AppMethodBeat.i(3096);
        if (this.mColumnNameMap == null) {
            String[] strArr = this.mColumns;
            int length = strArr.length;
            HashMap hashMap = new HashMap(length, 1.0f);
            for (int i2 = 0; i2 < length; i2++) {
                hashMap.put(strArr[i2], Integer.valueOf(i2));
            }
            this.mColumnNameMap = hashMap;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            Log.e(TAG, "requesting column name with table name -- ".concat(String.valueOf(str)), new Exception());
            str = str.substring(lastIndexOf + 1);
        }
        Integer num = this.mColumnNameMap.get(str);
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(3096);
            return intValue;
        }
        AppMethodBeat.o(3096);
        return -1;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public String[] getColumnNames() {
        return this.mColumns;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public void deactivate() {
        AppMethodBeat.i(3097);
        super.deactivate();
        this.mDriver.cursorDeactivated();
        AppMethodBeat.o(3097);
    }

    @Override // java.io.Closeable, com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(3098);
        super.close();
        synchronized (this) {
            try {
                this.mQuery.close();
                this.mDriver.cursorClosed();
            } finally {
                AppMethodBeat.o(3098);
            }
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public boolean requery() {
        boolean z = false;
        AppMethodBeat.i(3099);
        if (isClosed()) {
            AppMethodBeat.o(3099);
        } else {
            synchronized (this) {
                try {
                    if (this.mQuery.getDatabase().isOpen()) {
                        if (this.mWindow != null) {
                            this.mWindow.clear();
                        }
                        this.mPos = -1;
                        this.mCount = -1;
                        this.mDriver.cursorRequeried(this);
                        try {
                            z = super.requery();
                            AppMethodBeat.o(3099);
                        } catch (IllegalStateException e2) {
                            Log.w(TAG, "requery() failed " + e2.getMessage(), e2);
                            AppMethodBeat.o(3099);
                        }
                    }
                } finally {
                    AppMethodBeat.o(3099);
                }
            }
        }
        return z;
    }

    @Override // com.tencent.wcdb.AbstractWindowedCursor
    public void setWindow(CursorWindow cursorWindow) {
        AppMethodBeat.i(3100);
        super.setWindow(cursorWindow);
        this.mCount = -1;
        AppMethodBeat.o(3100);
    }

    public void setSelectionArguments(String[] strArr) {
        AppMethodBeat.i(3101);
        this.mDriver.setBindArguments(strArr);
        AppMethodBeat.o(3101);
    }

    @Override // com.tencent.wcdb.AbstractCursor, java.lang.Object
    public void finalize() {
        AppMethodBeat.i(3102);
        try {
            if (this.mWindow != null) {
                close();
            }
        } finally {
            super.finalize();
            AppMethodBeat.o(3102);
        }
    }

    static {
        AppMethodBeat.i(3103);
        AppMethodBeat.o(3103);
    }
}
