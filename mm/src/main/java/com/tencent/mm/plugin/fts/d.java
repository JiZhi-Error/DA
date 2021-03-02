package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d implements h {
    public boolean wTE;
    private SQLiteDatabase wTF;
    private SQLiteStatement wTG;
    private SQLiteStatement wTH;
    private SQLiteStatement wTI;

    public d(String str) {
        AppMethodBeat.i(52528);
        Log.i("MicroMsg.FTS.FTSIndexDB", "Create SearchStorage: %s", str + "FTS5IndexMicroMsg_encrypt.db");
        if (this.wTF != null) {
            Log.w("MicroMsg.FTS.FTSIndexDB", "before initDB, pre DB is not close, why?");
            this.wTF.close();
        }
        String z = aa.z(new o(str, "FTS5IndexMicroMsg_encrypt.db").her());
        long currentTimeMillis = System.currentTimeMillis();
        g.aAi();
        String str2 = (String) g.aAh().azQ().get(ar.a.USERINFO_FTS_MASTER_DB_ENCRYPT_PWD_STRING_SYNC, "");
        if (Util.isNullOrNil(str2)) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            str2 = com.tencent.mm.b.g.getMessageDigest(sb.append(a.ayV()).append(q.dr(true)).append(z.aTY()).toString().getBytes()).substring(0, 7);
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_FTS_MASTER_DB_ENCRYPT_PWD_STRING_SYNC, str2);
        }
        this.wTF = SQLiteDatabase.openOrCreateDatabase(z, str2.getBytes(), (SQLiteDatabase.CursorFactory) null, ((PluginFTS) g.ah(PluginFTS.class)).getDatabaseErrorHandler());
        String dr = q.dr(true);
        g.aAi();
        g.aAf();
        byte[] Q = com.tencent.mm.b.g.Q((dr + ((long) a.getUin())).getBytes());
        SQLiteDatabase sQLiteDatabase = this.wTF;
        long acquireNativeConnectionHandle = sQLiteDatabase.acquireNativeConnectionHandle("initFTS", false, false);
        this.wTE = false;
        dOs();
        FTSJNIUtils.nativeInitFts(acquireNativeConnectionHandle, Q);
        sQLiteDatabase.releaseNativeConnection(acquireNativeConnectionHandle, null);
        this.wTF.rawQuery("PRAGMA journal_mode=WAL;", null).close();
        this.wTF.execSQL("PRAGMA synchronous=NORMAL;");
        this.wTF.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (type INTEGER PRIMARY KEY, version INTEGER);", "FTS5IndexVersion"));
        this.wTG = this.wTF.compileStatement(String.format("SELECT version FROM %s WHERE type=?;", "FTS5IndexVersion"));
        this.wTH = this.wTF.compileStatement(String.format("INSERT OR REPLACE INTO %s (type, version) VALUES (?, ?);", "FTS5IndexVersion"));
        this.wTI = this.wTF.compileStatement(String.format("DELETE FROM %s WHERE type=?", "FTS5IndexVersion"));
        long currentTimeMillis2 = System.currentTimeMillis();
        e.am(18, currentTimeMillis2 - currentTimeMillis);
        Log.i("MicroMsg.FTS.FTSIndexDB", "initDB index params %d %s %s supportICU %b finalStartBuildMessageTimestamp %s finalStartBuildMessageClientVersion %s", Long.valueOf(currentTimeMillis2 - currentTimeMillis), Util.getSizeMB(s.boW(z), 2.0d), q.dr(true), Boolean.valueOf(this.wTE), f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, V(-310, 0) / 1000), Integer.toHexString((int) V(-310, 0)));
        AppMethodBeat.o(52528);
    }

    @Override // com.tencent.mm.plugin.fts.a.h
    public final Cursor rawQuery(String str, String[] strArr) {
        AppMethodBeat.i(52529);
        Log.v("MicroMsg.FTS.FTSIndexDB", "rawQuery: execute sql = %s", str);
        a aVar = new a(this.wTF.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, str, strArr, null));
        AppMethodBeat.o(52529);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.h
    public final Cursor ayh(String str) {
        AppMethodBeat.i(52530);
        Log.v("MicroMsg.FTS.FTSIndexDB", "rawQuery: execute sql = %s", str);
        a aVar = new a(this.wTF.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, str, null, null, null));
        AppMethodBeat.o(52530);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.h
    public final SQLiteStatement compileStatement(String str) {
        AppMethodBeat.i(52531);
        Log.v("MicroMsg.FTS.FTSIndexDB", "compileStatement sql = %s", str);
        SQLiteStatement compileStatement = this.wTF.compileStatement(str);
        AppMethodBeat.o(52531);
        return compileStatement;
    }

    @Override // com.tencent.mm.plugin.fts.a.h
    public final boolean gD(int i2, int i3) {
        int i4;
        AppMethodBeat.i(52532);
        if (!ayi("FTS5IndexVersion") || this.wTG == null) {
            i4 = 0;
        } else {
            i4 = (int) V((long) i2, 0);
        }
        Log.i("MicroMsg.FTS.FTSIndexDB", "dbVersion=%d | targetVersion=%d", Integer.valueOf(i4), Integer.valueOf(i3));
        if (i4 == i3) {
            AppMethodBeat.o(52532);
            return true;
        }
        AppMethodBeat.o(52532);
        return false;
    }

    @Override // com.tencent.mm.plugin.fts.a.h
    public final long V(long j2, long j3) {
        AppMethodBeat.i(52533);
        this.wTG.bindLong(1, j2);
        try {
            j3 = this.wTG.simpleQueryForLong();
            AppMethodBeat.o(52533);
        } catch (SQLiteDoneException e2) {
            AppMethodBeat.o(52533);
        }
        return j3;
    }

    @Override // com.tencent.mm.plugin.fts.a.h
    public final void W(long j2, long j3) {
        AppMethodBeat.i(52534);
        this.wTH.bindLong(1, j2);
        this.wTH.bindLong(2, j3);
        this.wTH.execute();
        AppMethodBeat.o(52534);
    }

    @Override // com.tencent.mm.plugin.fts.a.h
    public final boolean ayi(String str) {
        AppMethodBeat.i(52535);
        com.tencent.wcdb.Cursor rawQuery = this.wTF.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[]{str});
        boolean moveToNext = rawQuery.moveToNext();
        rawQuery.close();
        AppMethodBeat.o(52535);
        return moveToNext;
    }

    @Override // com.tencent.mm.plugin.fts.a.h
    public final void execSQL(String str) {
        AppMethodBeat.i(52536);
        Log.d("MicroMsg.FTS.FTSIndexDB", "execSQL: execute sql = %s", str);
        this.wTF.execSQL(str);
        AppMethodBeat.o(52536);
    }

    @Override // com.tencent.mm.plugin.fts.a.h
    public final void execSQL(String str, Object[] objArr) {
        AppMethodBeat.i(52537);
        Log.d("MicroMsg.FTS.FTSIndexDB", "execSQL: execute sql = %s", str);
        this.wTF.execSQL(str, objArr);
        AppMethodBeat.o(52537);
    }

    public final void close() {
        boolean isOpen;
        AppMethodBeat.i(52538);
        Object[] objArr = new Object[2];
        objArr[0] = this.wTF;
        if (this.wTF == null) {
            isOpen = false;
        } else {
            isOpen = this.wTF.isOpen();
        }
        objArr[1] = Boolean.valueOf(isOpen);
        Log.w("MicroMsg.FTS.FTSIndexDB", "close db:%s isOpen:%b ", objArr);
        if (this.wTF != null && this.wTF.isOpen()) {
            Log.w("MicroMsg.FTS.FTSIndexDB", "close in trans :%b ", Boolean.valueOf(this.wTF.inTransaction()));
            while (this.wTF.inTransaction()) {
                this.wTF.endTransaction();
            }
            this.wTG.close();
            this.wTH.close();
            this.wTF.close();
            this.wTF = null;
        }
        AppMethodBeat.o(52538);
    }

    @Override // com.tencent.mm.plugin.fts.a.h
    public final synchronized void beginTransaction() {
        AppMethodBeat.i(52539);
        if (this.wTF == null || this.wTF.inTransaction()) {
            AppMethodBeat.o(52539);
        } else {
            this.wTF.beginTransaction();
            AppMethodBeat.o(52539);
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.h
    public final boolean inTransaction() {
        AppMethodBeat.i(52540);
        if (this.wTF == null || !this.wTF.inTransaction()) {
            AppMethodBeat.o(52540);
            return false;
        }
        AppMethodBeat.o(52540);
        return true;
    }

    @Override // com.tencent.mm.plugin.fts.a.h
    public final synchronized void commit() {
        AppMethodBeat.i(52541);
        if (this.wTF == null || !this.wTF.inTransaction()) {
            AppMethodBeat.o(52541);
        } else {
            this.wTF.setTransactionSuccessful();
            this.wTF.endTransaction();
            AppMethodBeat.o(52541);
        }
    }

    public final synchronized void rollback() {
        AppMethodBeat.i(52542);
        if (this.wTF == null || !this.wTF.isOpen() || !this.wTF.inTransaction()) {
            AppMethodBeat.o(52542);
        } else {
            Log.i("MicroMsg.FTS.FTSIndexDB", "rollback");
            try {
                this.wTF.endTransaction();
                AppMethodBeat.o(52542);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FTS.FTSIndexDB", e2, "occur error \n%s", e2);
                AppMethodBeat.o(52542);
            }
        }
    }

    protected static final void dOq() {
        AppMethodBeat.i(52543);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        String sb2 = sb.append(g.aAh().cachePath).append("FTS5IndexMicroMsg_encrypt.db").toString();
        String[] strArr = {"", "-journal", "-wal", "-shm"};
        for (int i2 = 0; i2 < 4; i2++) {
            String str = sb2 + strArr[i2];
            Log.i("MicroMsg.FTS.FTSIndexDB", "deleteIndexDB %s %s", str, Boolean.valueOf(s.YS(str)));
            s.deleteFile(str);
        }
        AppMethodBeat.o(52543);
    }

    public static final o dOr() {
        AppMethodBeat.i(176903);
        g.aAi();
        o oVar = new o(g.aAh().cachePath, "FTS5IndexMicroMsg_encrypt.db");
        AppMethodBeat.o(176903);
        return oVar;
    }

    public final void au(String str, long j2) {
        AppMethodBeat.i(52545);
        long currentTimeMillis = System.currentTimeMillis();
        execSQL(String.format("DELETE FROM %s WHERE rowid IN (SELECT docid FROM %s WHERE aux_index=? AND timestamp <= ?);", "FTS5IndexMessage", "FTS5MetaMessage"), new String[]{str, String.valueOf(j2)});
        execSQL(String.format("DELETE FROM %s WHERE aux_index=? AND timestamp <= ?", "FTS5MetaMessage"), new String[]{str, String.valueOf(j2)});
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        Log.i("MicroMsg.FTS.FTSIndexDB", "deleteTalkerMsgByTimestamp use time %d talker %s timestamp %s", Long.valueOf(currentTimeMillis2), str, f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, j2 / 1000));
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(729, 10, 1, false);
        if (currentTimeMillis2 > 500) {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(79, 11, 1, false);
            AppMethodBeat.o(52545);
        } else if (currentTimeMillis2 > 1000) {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(79, 12, 1, false);
            AppMethodBeat.o(52545);
        } else {
            if (currentTimeMillis2 > 10000) {
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(79, 13, 1, false);
            }
            AppMethodBeat.o(52545);
        }
    }

    public final void deleteMsgById(long j2) {
        AppMethodBeat.i(52546);
        long currentTimeMillis = System.currentTimeMillis();
        String format = String.format("UPDATE %s SET status=? WHERE entity_id=?;", "FTS5MetaMessage");
        this.wTF.execSQL(format, new String[]{"-1", String.valueOf(j2)});
        execSQL(String.format("DELETE FROM %s WHERE rowid IN (SELECT docid FROM %s WHERE entity_id=?);", "FTS5IndexMessage", "FTS5MetaMessage"), new String[]{String.valueOf(j2)});
        execSQL(String.format("DELETE FROM %s WHERE entity_id=?", "FTS5MetaMessage"), new String[]{String.valueOf(j2)});
        Log.i("MicroMsg.FTS.FTSIndexDB", "deleteMsgById use time %d msgId %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(j2));
        AppMethodBeat.o(52546);
    }

    private static void dOs() {
        AppMethodBeat.i(52547);
        o[] het = new o("/system/usr/icu").het();
        if (het != null) {
            int length = het.length;
            for (int i2 = 0; i2 < length; i2++) {
                Log.i("MicroMsg.FTS.FTSIndexDB", "icu file %s", het[i2].getName());
            }
        }
        AppMethodBeat.o(52547);
    }
}
