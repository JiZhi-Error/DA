package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

public class SQLiteDirectCursor extends AbstractCursor {
    public static final SQLiteDatabase.CursorFactory FACTORY = new SQLiteDatabase.CursorFactory() {
        /* class com.tencent.wcdb.database.SQLiteDirectCursor.AnonymousClass1 */

        @Override // com.tencent.wcdb.database.SQLiteDatabase.CursorFactory
        public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteProgram sQLiteProgram) {
            AppMethodBeat.i(3238);
            SQLiteDirectCursor sQLiteDirectCursor = new SQLiteDirectCursor(sQLiteCursorDriver, str, (SQLiteDirectQuery) sQLiteProgram);
            AppMethodBeat.o(3238);
            return sQLiteDirectCursor;
        }

        @Override // com.tencent.wcdb.database.SQLiteDatabase.CursorFactory
        public final SQLiteProgram newQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
            AppMethodBeat.i(3239);
            SQLiteDirectQuery sQLiteDirectQuery = new SQLiteDirectQuery(sQLiteDatabase, str, objArr, cancellationSignal);
            AppMethodBeat.o(3239);
            return sQLiteDirectQuery;
        }
    };
    private static final String TAG = "WCDB.SQLiteDirectCursor";
    private final String[] mColumns;
    private int mCount;
    private boolean mCountFinished;
    private final SQLiteCursorDriver mDriver;
    private final SQLiteDirectQuery mQuery;

    public SQLiteDirectCursor(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteDirectQuery sQLiteDirectQuery) {
        AppMethodBeat.i(3240);
        if (sQLiteDirectQuery == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("query object cannot be null");
            AppMethodBeat.o(3240);
            throw illegalArgumentException;
        }
        this.mQuery = sQLiteDirectQuery;
        this.mDriver = sQLiteCursorDriver;
        this.mColumns = sQLiteDirectQuery.getColumnNames();
        this.mCount = -1;
        this.mCountFinished = false;
        AppMethodBeat.o(3240);
    }

    @Override // java.io.Closeable, com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(3241);
        super.close();
        this.mQuery.close();
        this.mDriver.cursorClosed();
        AppMethodBeat.o(3241);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public void deactivate() {
        AppMethodBeat.i(3242);
        super.deactivate();
        this.mDriver.cursorDeactivated();
        AppMethodBeat.o(3242);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public String[] getColumnNames() {
        return this.mColumns;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public String getString(int i2) {
        AppMethodBeat.i(3243);
        String string = this.mQuery.getString(i2);
        AppMethodBeat.o(3243);
        return string;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public byte[] getBlob(int i2) {
        AppMethodBeat.i(3244);
        byte[] blob = this.mQuery.getBlob(i2);
        AppMethodBeat.o(3244);
        return blob;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public short getShort(int i2) {
        AppMethodBeat.i(3245);
        short s = (short) ((int) this.mQuery.getLong(i2));
        AppMethodBeat.o(3245);
        return s;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public int getInt(int i2) {
        AppMethodBeat.i(3246);
        int i3 = (int) this.mQuery.getLong(i2);
        AppMethodBeat.o(3246);
        return i3;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public long getLong(int i2) {
        AppMethodBeat.i(3247);
        long j2 = this.mQuery.getLong(i2);
        AppMethodBeat.o(3247);
        return j2;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public float getFloat(int i2) {
        AppMethodBeat.i(3248);
        float f2 = (float) this.mQuery.getDouble(i2);
        AppMethodBeat.o(3248);
        return f2;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public double getDouble(int i2) {
        AppMethodBeat.i(3249);
        double d2 = this.mQuery.getDouble(i2);
        AppMethodBeat.o(3249);
        return d2;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public int getType(int i2) {
        AppMethodBeat.i(3250);
        int type = this.mQuery.getType(i2);
        AppMethodBeat.o(3250);
        return type;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public boolean isNull(int i2) {
        AppMethodBeat.i(3251);
        if (getType(i2) == 0) {
            AppMethodBeat.o(3251);
            return true;
        }
        AppMethodBeat.o(3251);
        return false;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public boolean moveToPosition(int i2) {
        int step;
        AppMethodBeat.i(3252);
        if (i2 < 0) {
            this.mQuery.reset(false);
            this.mPos = -1;
            AppMethodBeat.o(3252);
            return false;
        } else if (!this.mCountFinished || i2 < this.mCount) {
            if (i2 < this.mPos) {
                Log.w(TAG, "Moving backward on SQLiteDirectCursor is slow. Get rid of backward movement or use other implementations.");
                this.mQuery.reset(false);
                step = this.mQuery.step(i2 + 1) - 1;
            } else if (i2 == this.mPos) {
                AppMethodBeat.o(3252);
                return true;
            } else {
                step = this.mPos + this.mQuery.step(i2 - this.mPos);
            }
            if (step < i2) {
                this.mCount = step + 1;
                this.mCountFinished = true;
                this.mPos = this.mCount;
            } else {
                this.mPos = step;
                if (step >= this.mCount) {
                    this.mCount = step + 1;
                    this.mCountFinished = false;
                }
            }
            if (this.mPos < this.mCount) {
                AppMethodBeat.o(3252);
                return true;
            }
            AppMethodBeat.o(3252);
            return false;
        } else {
            this.mPos = this.mCount;
            AppMethodBeat.o(3252);
            return false;
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public int getCount() {
        AppMethodBeat.i(3253);
        if (!this.mCountFinished) {
            Log.w(TAG, "Count query on SQLiteDirectCursor is slow. Iterate through the end to get count or use other implementations.");
            this.mCount = this.mPos + this.mQuery.step(Integer.MAX_VALUE) + 1;
            this.mCountFinished = true;
            this.mQuery.reset(false);
            this.mPos = this.mQuery.step(this.mPos + 1) - 1;
        }
        int i2 = this.mCount;
        AppMethodBeat.o(3253);
        return i2;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public boolean requery() {
        boolean z = false;
        AppMethodBeat.i(3254);
        if (isClosed()) {
            AppMethodBeat.o(3254);
        } else {
            synchronized (this) {
                try {
                    if (this.mQuery.getDatabase().isOpen()) {
                        this.mPos = -1;
                        this.mCountFinished = false;
                        this.mCount = -1;
                        this.mDriver.cursorRequeried(this);
                        this.mQuery.reset(false);
                        try {
                            z = super.requery();
                            AppMethodBeat.o(3254);
                        } catch (IllegalStateException e2) {
                            Log.w(TAG, "requery() failed " + e2.getMessage(), e2);
                            AppMethodBeat.o(3254);
                        }
                    }
                } finally {
                    AppMethodBeat.o(3254);
                }
            }
        }
        return z;
    }

    static {
        AppMethodBeat.i(3255);
        AppMethodBeat.o(3255);
    }
}
