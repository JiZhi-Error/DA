package com.tencent.mm.plugin.priority.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.util.c;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;

public final class b {
    public SQLiteDatabase AYk;
    public SQLiteStatement AYl;
    public SQLiteStatement AYm;
    public SQLiteStatement AYn;

    public b(String str) {
        AppMethodBeat.i(87799);
        if (this.AYk != null) {
            Log.w("MicroMsg.Priority.PriorityDB", "before initDB, pre DB is not close, why?");
            this.AYk.close();
        }
        String z = aa.z(new o(str, "MicroMsgPriority.db").her());
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        g.aAf();
        String substring = com.tencent.mm.b.g.getMessageDigest(sb.append(a.ayV()).append(z.aTY()).append(q.dr(true)).toString().getBytes()).substring(0, 7);
        this.AYk = SQLiteDatabase.openOrCreateDatabase(z, substring.getBytes(), (SQLiteDatabase.CursorFactory) null, (DatabaseErrorHandler) null);
        SQLiteDatabase sQLiteDatabase = this.AYk;
        long acquireNativeConnectionHandle = sQLiteDatabase.acquireNativeConnectionHandle("initPriority", false, false);
        PriorityJni.nativeInit(acquireNativeConnectionHandle);
        sQLiteDatabase.releaseNativeConnection(acquireNativeConnectionHandle, null);
        this.AYk.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (type INTEGER PRIMARY KEY, version INTEGER);", "PriorityConfig"));
        this.AYl = this.AYk.compileStatement(String.format("SELECT version FROM %s WHERE type=?;", "PriorityConfig"));
        this.AYm = this.AYk.compileStatement(String.format("INSERT OR REPLACE INTO %s (type, version) VALUES (?, ?);", "PriorityConfig"));
        this.AYn = this.AYk.compileStatement(String.format("DELETE FROM %s WHERE type=?", "PriorityConfig"));
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        objArr[1] = Util.getSizeMB(s.boW(z), 100.0d);
        c cVar = c.QYz;
        objArr[2] = !c.hde() ? "" : substring;
        Log.i("MicroMsg.Priority.PriorityDB", "initDB index params %d %s %s", objArr);
        AppMethodBeat.o(87799);
    }

    public final long ag(long j2, long j3) {
        AppMethodBeat.i(87800);
        this.AYl.bindLong(1, j2);
        try {
            j3 = this.AYl.simpleQueryForLong();
            AppMethodBeat.o(87800);
        } catch (SQLiteDoneException e2) {
            AppMethodBeat.o(87800);
        }
        return j3;
    }

    public final void ah(long j2, long j3) {
        AppMethodBeat.i(87801);
        this.AYm.bindLong(1, j2);
        this.AYm.bindLong(2, j3);
        this.AYm.execute();
        AppMethodBeat.o(87801);
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        AppMethodBeat.i(87802);
        Log.v("MicroMsg.Priority.PriorityDB", "rawQuery: execute sql = %s", str);
        com.tencent.wcdb.Cursor rawQueryWithFactory = this.AYk.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, str, strArr, null);
        AppMethodBeat.o(87802);
        return rawQueryWithFactory;
    }

    public final SQLiteStatement compileStatement(String str) {
        AppMethodBeat.i(87803);
        Log.v("MicroMsg.Priority.PriorityDB", "compileStatement sql = %s", str);
        SQLiteStatement compileStatement = this.AYk.compileStatement(str);
        AppMethodBeat.o(87803);
        return compileStatement;
    }

    public final int aKc(String str) {
        int i2 = 0;
        AppMethodBeat.i(87804);
        com.tencent.wcdb.Cursor rawQuery = this.AYk.rawQuery(String.format("SELECT count(*) FROM %s;", str), null);
        try {
            if (rawQuery.moveToNext()) {
                i2 = rawQuery.getInt(0);
            } else {
                rawQuery.close();
                AppMethodBeat.o(87804);
            }
            return i2;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(87804);
        }
    }

    public final boolean ayi(String str) {
        AppMethodBeat.i(87805);
        com.tencent.wcdb.Cursor rawQuery = this.AYk.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[]{str});
        boolean moveToNext = rawQuery.moveToNext();
        rawQuery.close();
        AppMethodBeat.o(87805);
        return moveToNext;
    }

    public final void aKd(String str) {
        AppMethodBeat.i(87806);
        Log.v("MicroMsg.Priority.PriorityDB", "dropTable: %s", str);
        this.AYk.execSQL(String.format("DROP TABLE %s", str));
        AppMethodBeat.o(87806);
    }

    public final void execSQL(String str) {
        AppMethodBeat.i(87807);
        Log.v("MicroMsg.Priority.PriorityDB", "execSQL: execute sql = %s", str);
        this.AYk.execSQL(str);
        AppMethodBeat.o(87807);
    }

    public final void execSQL(String str, Object[] objArr) {
        AppMethodBeat.i(87808);
        Log.v("MicroMsg.Priority.PriorityDB", "execSQL: execute sql = %s", str);
        this.AYk.execSQL(str, objArr);
        AppMethodBeat.o(87808);
    }
}
