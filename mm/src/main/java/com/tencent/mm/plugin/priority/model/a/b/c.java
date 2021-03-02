package com.tencent.mm.plugin.priority.model.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.protocal.protobuf.ib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;

public final class c {
    private b AXQ;
    public SQLiteStatement AYG;
    public SQLiteStatement AYH;
    private SQLiteStatement AYI;
    private SQLiteStatement AYJ;
    public SQLiteStatement AYK;
    public SQLiteStatement AYL;
    private SQLiteStatement AYx;

    public c(b bVar) {
        AppMethodBeat.i(87834);
        this.AXQ = bVar;
        if (this.AXQ.ag(2, 0) != 4) {
            if (this.AXQ.ayi("C2CMsgAutoDownloadFile")) {
                this.AXQ.aKd("C2CMsgAutoDownloadFile");
            }
            this.AXQ.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (id TEXT, fromuser TEXT, realuser TEXT, restype INTEGER, createtime INTEGER, reason INTEGER, status INTEGER, downloadtime INTEGER, msgsvrid LONG, filesize INTEGER, fileext TEXT, opentime INTEGER, priority FLOAT, prioritytype INTEGER, fileid TEXT, PRIMARY KEY(id, msgsvrid));", "C2CMsgAutoDownloadFile"));
            this.AXQ.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s ON %s(priority, createtime);", "C2CMsgAutoDownloadFile_Priority_CreateTime", "C2CMsgAutoDownloadFile"));
            this.AXQ.ah(2, 4);
        } else {
            Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "Exist Table %s Count %s", "C2CMsgAutoDownloadFile", Integer.valueOf(this.AXQ.aKc("C2CMsgAutoDownloadFile")));
        }
        this.AYx = this.AXQ.compileStatement(String.format("INSERT OR IGNORE INTO %s (id, fromuser, realuser, restype, createtime, reason, status, downloadtime, msgsvrid, filesize, fileext, opentime, priority, prioritytype, fileid) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", "C2CMsgAutoDownloadFile"));
        this.AYG = this.AXQ.compileStatement(String.format("DELETE FROM %s WHERE id = ? AND msgsvrid = ?", "C2CMsgAutoDownloadFile"));
        this.AYH = this.AXQ.compileStatement(String.format("DELETE FROM %s WHERE fromuser = ?;", "C2CMsgAutoDownloadFile"));
        this.AYI = this.AXQ.compileStatement(String.format("UPDATE %s SET status = ? WHERE id = ? AND msgsvrid = ?", "C2CMsgAutoDownloadFile"));
        this.AYJ = this.AXQ.compileStatement(String.format("UPDATE %s SET reason = reason | ?, status = ? WHERE id = ? AND msgsvrid = ?", "C2CMsgAutoDownloadFile"));
        this.AYK = this.AXQ.compileStatement(String.format("UPDATE %s SET downloadtime = ?, status = ? WHERE id = ? AND msgsvrid = ? AND downloadtime = 0", "C2CMsgAutoDownloadFile"));
        this.AYL = this.AXQ.compileStatement(String.format("UPDATE %s SET opentime = ? WHERE id = ? AND msgsvrid = ? AND opentime = 0", "C2CMsgAutoDownloadFile"));
        AppMethodBeat.o(87834);
    }

    public final void a(ib ibVar) {
        AppMethodBeat.i(87835);
        this.AYx.bindString(1, ibVar.Id);
        this.AYx.bindString(2, ibVar.KLZ);
        this.AYx.bindString(3, ibVar.KMa);
        this.AYx.bindLong(4, (long) ibVar.KMb);
        this.AYx.bindLong(5, ibVar.KMc);
        this.AYx.bindLong(6, (long) ibVar.KMd);
        this.AYx.bindLong(7, (long) ibVar.oTW);
        this.AYx.bindLong(8, ibVar.KMe);
        this.AYx.bindLong(9, ibVar.KMf);
        this.AYx.bindLong(10, ibVar.KMg);
        this.AYx.bindString(11, ibVar.KMh);
        this.AYx.bindLong(12, ibVar.KMi);
        this.AYx.bindDouble(13, ibVar.KMj);
        this.AYx.bindLong(14, (long) ibVar.KMk);
        this.AYx.bindString(15, ibVar.KMl);
        this.AYx.execute();
        AppMethodBeat.o(87835);
    }

    public final void l(String str, long j2, int i2) {
        AppMethodBeat.i(87836);
        this.AYI.bindLong(1, (long) i2);
        this.AYI.bindString(2, str);
        this.AYI.bindLong(3, j2);
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateStatus %s res %s %s %s", Integer.valueOf(this.AYI.executeUpdateDelete()), str, Long.valueOf(j2), Integer.valueOf(i2));
        AppMethodBeat.o(87836);
    }

    public final boolean be(String str, long j2) {
        AppMethodBeat.i(87837);
        String format = String.format("SELECT 1 FROM %s WHERE id = ? AND msgsvrid = ?", "C2CMsgAutoDownloadFile");
        Cursor rawQuery = this.AXQ.rawQuery(format, new String[]{str, String.valueOf(j2)});
        try {
            return rawQuery.moveToNext();
        } finally {
            rawQuery.close();
            AppMethodBeat.o(87837);
        }
    }

    public final ib bf(String str, long j2) {
        AppMethodBeat.i(87838);
        String format = String.format("SELECT * FROM %s WHERE id = ? AND msgsvrid = ?;", "C2CMsgAutoDownloadFile");
        Cursor rawQuery = this.AXQ.rawQuery(format, new String[]{str, String.valueOf(j2)});
        try {
            if (rawQuery.moveToNext()) {
                return l(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(87838);
            return null;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(87838);
        }
    }

    public final ib b(float f2, long j2) {
        AppMethodBeat.i(87839);
        String format = String.format("SELECT * FROM %s WHERE status = %s AND priority >= ? AND createtime > ? AND filesize <= ? ORDER BY priority DESC, createtime DESC LIMIT 1;", "C2CMsgAutoDownloadFile", 1);
        Cursor rawQuery = this.AXQ.rawQuery(format, new String[]{String.valueOf(f2), String.valueOf(System.currentTimeMillis() - 432000000), String.valueOf(j2)});
        try {
            if (rawQuery.moveToNext()) {
                return l(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(87839);
            return null;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(87839);
        }
    }

    public final ib s(int i2, float f2) {
        AppMethodBeat.i(161938);
        String format = String.format("SELECT * FROM %s File, %s Chat WHERE Chat.rank <= ? AND Chat.totallsp > ? AND Chat.chat = File.fromuser AND createtime > ? AND File.status = ? ORDER BY File.createtime DESC LIMIT 1;", "C2CMsgAutoDownloadFile", "C2CChatUsageResult");
        Cursor rawQuery = this.AXQ.rawQuery(format, new String[]{String.valueOf(i2), String.valueOf(f2), String.valueOf(System.currentTimeMillis() - 432000000), "1"});
        try {
            if (rawQuery.moveToNext()) {
                return l(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(161938);
            return null;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(161938);
        }
    }

    public final ib eCX() {
        AppMethodBeat.i(87840);
        String format = String.format("SELECT * FROM %s WHERE status = %s AND (reason & %s) > 0 AND createtime > ? ORDER BY createtime DESC LIMIT 1;", "C2CMsgAutoDownloadFile", 1, 1);
        Cursor rawQuery = this.AXQ.rawQuery(format, new String[]{String.valueOf(System.currentTimeMillis() - 432000000)});
        try {
            if (rawQuery.moveToNext()) {
                return l(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(87840);
            return null;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(87840);
        }
    }

    private static ib l(Cursor cursor) {
        AppMethodBeat.i(87841);
        ib ibVar = new ib();
        ibVar.Id = cursor.getString(0);
        ibVar.KLZ = cursor.getString(1);
        ibVar.KMa = cursor.getString(2);
        ibVar.KMb = cursor.getInt(3);
        ibVar.KMc = cursor.getLong(4);
        ibVar.KMd = cursor.getInt(5);
        ibVar.oTW = cursor.getInt(6);
        ibVar.KMe = cursor.getLong(7);
        ibVar.KMf = cursor.getLong(8);
        ibVar.KMg = (long) cursor.getInt(9);
        ibVar.KMh = cursor.getString(10);
        ibVar.KMi = cursor.getLong(11);
        ibVar.KMj = (double) cursor.getFloat(12);
        ibVar.KMk = cursor.getInt(13);
        ibVar.KMl = cursor.getString(14);
        AppMethodBeat.o(87841);
        return ibVar;
    }
}
