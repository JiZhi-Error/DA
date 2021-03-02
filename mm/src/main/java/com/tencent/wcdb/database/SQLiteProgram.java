package com.tencent.wcdb.database;

import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteConnection;
import com.tencent.wcdb.support.CancellationSignal;
import java.util.Arrays;

public abstract class SQLiteProgram extends SQLiteClosable {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final String TAG = "WCDB.SQLiteProgram";
    private final Object[] mBindArgs;
    private SQLiteSession mBoundSession;
    private final String[] mColumnNames;
    private final SQLiteDatabase mDatabase;
    private final int mNumParameters;
    protected SQLiteConnection.PreparedStatement mPreparedStatement;
    private final boolean mReadOnly;
    private final String mSql;

    protected SQLiteProgram(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
        boolean z;
        boolean z2 = true;
        this.mDatabase = sQLiteDatabase;
        this.mSql = str.trim();
        int sqlStatementType = DatabaseUtils.getSqlStatementType(this.mSql);
        switch (sqlStatementType) {
            case 4:
            case 5:
            case 6:
                this.mReadOnly = false;
                this.mColumnNames = EMPTY_STRING_ARRAY;
                this.mNumParameters = 0;
                break;
            default:
                if (sqlStatementType == 1) {
                    z = true;
                } else {
                    z = false;
                }
                SQLiteStatementInfo sQLiteStatementInfo = new SQLiteStatementInfo();
                sQLiteDatabase.getThreadSession().prepare(this.mSql, sQLiteDatabase.getThreadDefaultConnectionFlags(z), cancellationSignal, sQLiteStatementInfo);
                this.mReadOnly = (sqlStatementType == 8 || !sQLiteStatementInfo.readOnly) ? false : z2;
                this.mColumnNames = sQLiteStatementInfo.columnNames;
                this.mNumParameters = sQLiteStatementInfo.numParameters;
                break;
        }
        if (objArr == null || objArr.length <= this.mNumParameters) {
            if (this.mNumParameters != 0) {
                this.mBindArgs = new Object[this.mNumParameters];
                if (objArr != null) {
                    System.arraycopy(objArr, 0, this.mBindArgs, 0, objArr.length);
                }
            } else {
                this.mBindArgs = null;
            }
            this.mPreparedStatement = null;
            this.mBoundSession = null;
            return;
        }
        throw new IllegalArgumentException("Too many bind arguments.  " + objArr.length + " arguments were provided but the statement needs " + this.mNumParameters + " arguments.");
    }

    public final SQLiteDatabase getDatabase() {
        return this.mDatabase;
    }

    /* access modifiers changed from: protected */
    public final String getSql() {
        return this.mSql;
    }

    /* access modifiers changed from: protected */
    public final Object[] getBindArgs() {
        return this.mBindArgs;
    }

    public final String[] getColumnNames() {
        return this.mColumnNames;
    }

    /* access modifiers changed from: protected */
    public final SQLiteSession getSession() {
        return this.mDatabase.getThreadSession();
    }

    /* access modifiers changed from: protected */
    public final int getConnectionFlags() {
        return this.mDatabase.getThreadDefaultConnectionFlags(this.mReadOnly);
    }

    /* access modifiers changed from: protected */
    public final void checkCorruption(SQLiteException sQLiteException) {
        boolean z = true;
        if (!(sQLiteException instanceof SQLiteDatabaseCorruptException) && (!(sQLiteException instanceof SQLiteFullException) || !this.mReadOnly)) {
            z = false;
        }
        if (z) {
            SQLiteDebug.collectLastIOTraceStats(this.mDatabase);
            this.mDatabase.onCorruption();
        }
    }

    @Deprecated
    public final int getUniqueId() {
        return -1;
    }

    public void bindNull(int i2) {
        bind(i2, null);
    }

    public void bindLong(int i2, long j2) {
        bind(i2, Long.valueOf(j2));
    }

    public void bindDouble(int i2, double d2) {
        bind(i2, Double.valueOf(d2));
    }

    public void bindString(int i2, String str) {
        if (str == null) {
            throw new IllegalArgumentException("the bind value at index " + i2 + " is null");
        }
        bind(i2, str);
    }

    public void bindBlob(int i2, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("the bind value at index " + i2 + " is null");
        }
        bind(i2, bArr);
    }

    public void clearBindings() {
        if (this.mBindArgs != null) {
            Arrays.fill(this.mBindArgs, (Object) null);
        }
    }

    public void bindAllArgsAsStrings(String[] strArr) {
        if (strArr != null) {
            for (int length = strArr.length; length != 0; length--) {
                bindString(length, strArr[length - 1]);
            }
        }
    }

    public void bindAllArgs(Object[] objArr) {
        for (int length = objArr.length; length != 0; length--) {
            bind(length, objArr[length - 1]);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.wcdb.database.SQLiteClosable
    public void onAllReferencesReleased() {
        releasePreparedStatement();
        clearBindings();
    }

    private void bind(int i2, Object obj) {
        if (i2 <= 0 || i2 > this.mNumParameters) {
            throw new IllegalArgumentException("Cannot bind argument at index " + i2 + " because the index is out of range.  The statement has " + this.mNumParameters + " parameters.");
        }
        this.mBindArgs[i2 - 1] = obj;
    }

    /* access modifiers changed from: protected */
    public synchronized boolean acquirePreparedStatement(boolean z) {
        boolean z2;
        SQLiteSession threadSession = this.mDatabase.getThreadSession();
        if (threadSession == this.mBoundSession) {
            z2 = false;
        } else if (this.mBoundSession != null) {
            throw new IllegalStateException("SQLiteProgram has bound to another thread.");
        } else {
            this.mPreparedStatement = threadSession.acquirePreparedStatement(this.mSql, this.mDatabase.getThreadDefaultConnectionFlags(this.mReadOnly), z);
            this.mPreparedStatement.bindArguments(this.mBindArgs);
            this.mBoundSession = threadSession;
            z2 = true;
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public synchronized void releasePreparedStatement() {
        if (!(this.mBoundSession == null && this.mPreparedStatement == null)) {
            if (this.mBoundSession == null || this.mPreparedStatement == null) {
                throw new IllegalStateException("Internal state error.");
            } else if (this.mBoundSession != this.mDatabase.getThreadSession()) {
                throw new IllegalStateException("SQLiteProgram has bound to another thread.");
            } else {
                this.mBoundSession.releasePreparedStatement(this.mPreparedStatement);
                this.mPreparedStatement = null;
                this.mBoundSession = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        synchronized (this) {
            if (this.mBoundSession != null || this.mPreparedStatement != null) {
                throw new SQLiteMisuseException("Acquired prepared statement is not released.");
            }
        }
        super.finalize();
    }
}
