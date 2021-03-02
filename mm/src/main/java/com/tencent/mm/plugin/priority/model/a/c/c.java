package com.tencent.mm.plugin.priority.model.a.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.protocal.protobuf.ic;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;

public final class c {
    public b AXQ;
    public SQLiteStatement AYG;
    public SQLiteStatement AYH;
    public SQLiteStatement AYI;
    public SQLiteStatement AYJ;
    public SQLiteStatement AYK;
    public SQLiteStatement AYL;
    public SQLiteStatement AYx;

    public c(b bVar) {
        AppMethodBeat.i(87853);
        this.AXQ = bVar;
        if (this.AXQ.ag(1, 0) != 1) {
            if (this.AXQ.ayi("C2CMsgAutoDownloadRes")) {
                this.AXQ.aKd("C2CMsgAutoDownloadRes");
            }
            this.AXQ.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (msgid INTEGER PRIMARY KEY, fromuser TEXT, realuser TEXT, restype INTEGER, createtime INTEGER, reason INTEGER, status INTEGER, downloadtime INTEGER, msgsvrid LONG, imgsize INTEGER, opentime INTEGER, priority FLOAT, prioritytype INTEGER);", "C2CMsgAutoDownloadRes"));
            this.AXQ.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s ON %s(priority, createtime);", "C2CMsgAutoDownloadRes_Priority_CreateTime", "C2CMsgAutoDownloadRes"));
            this.AXQ.ah(1, 1);
        } else {
            Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "Exist Table %s Count %d", "C2CMsgAutoDownloadRes", Integer.valueOf(this.AXQ.aKc("C2CMsgAutoDownloadRes")));
        }
        this.AYx = this.AXQ.compileStatement(String.format("INSERT OR IGNORE INTO %s (msgid, fromuser, realuser, restype, createtime, reason, status, downloadtime, msgsvrid, imgsize, opentime, priority, prioritytype) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);", "C2CMsgAutoDownloadRes"));
        this.AYG = this.AXQ.compileStatement(String.format("DELETE FROM %s WHERE msgid = ?", "C2CMsgAutoDownloadRes"));
        this.AYH = this.AXQ.compileStatement(String.format("DELETE FROM %s WHERE fromuser = ?;", "C2CMsgAutoDownloadRes"));
        this.AYI = this.AXQ.compileStatement(String.format("UPDATE %s SET status = ? WHERE msgid = ?", "C2CMsgAutoDownloadRes"));
        this.AYJ = this.AXQ.compileStatement(String.format("UPDATE %s SET reason = reason | ?, status = ? WHERE msgid = ?", "C2CMsgAutoDownloadRes"));
        this.AYK = this.AXQ.compileStatement(String.format("UPDATE %s SET downloadtime = ?, status = ?, imgsize = ? WHERE msgid = ? AND downloadtime = 0", "C2CMsgAutoDownloadRes"));
        this.AYL = this.AXQ.compileStatement(String.format("UPDATE %s SET opentime = ? WHERE msgid = ? AND opentime = 0", "C2CMsgAutoDownloadRes"));
        AppMethodBeat.o(87853);
    }

    public final void R(long j2, int i2) {
        AppMethodBeat.i(87854);
        this.AYI.bindLong(1, (long) i2);
        this.AYI.bindLong(2, j2);
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateStatus %d res %d %d", Integer.valueOf(this.AYI.executeUpdateDelete()), Long.valueOf(j2), Integer.valueOf(i2));
        AppMethodBeat.o(87854);
    }

    public final void m(long j2, int i2, int i3) {
        AppMethodBeat.i(87855);
        this.AYJ.bindLong(1, (long) i2);
        this.AYJ.bindLong(2, (long) i3);
        this.AYJ.bindLong(3, j2);
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "updateStatusAndReason %d res %d %d %d", Integer.valueOf(this.AYJ.executeUpdateDelete()), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(87855);
    }

    public final boolean HL(long j2) {
        AppMethodBeat.i(87856);
        Cursor rawQuery = this.AXQ.rawQuery(String.format("SELECT 1 FROM %s WHERE msgid = %d", "C2CMsgAutoDownloadRes", Long.valueOf(j2)), null);
        try {
            return rawQuery.moveToNext();
        } finally {
            rawQuery.close();
            AppMethodBeat.o(87856);
        }
    }

    public final ic HM(long j2) {
        ic icVar = null;
        AppMethodBeat.i(87857);
        Cursor rawQuery = this.AXQ.rawQuery(String.format("SELECT * FROM %s WHERE msgid = %d;", "C2CMsgAutoDownloadRes", Long.valueOf(j2)), null);
        try {
            if (rawQuery.moveToNext()) {
                icVar = m(rawQuery);
            } else {
                rawQuery.close();
                AppMethodBeat.o(87857);
            }
            return icVar;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(87857);
        }
    }

    public final ic bG(float f2) {
        AppMethodBeat.i(87858);
        String format = String.format("SELECT * FROM %s WHERE status = %d AND priority >= ? AND createtime > ? ORDER BY priority DESC, createtime DESC LIMIT 1;", "C2CMsgAutoDownloadRes", 1);
        Cursor rawQuery = this.AXQ.rawQuery(format, new String[]{String.valueOf(f2), String.valueOf(System.currentTimeMillis() - 432000000)});
        try {
            if (rawQuery.moveToNext()) {
                return m(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(87858);
            return null;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(87858);
        }
    }

    public final ic bH(float f2) {
        AppMethodBeat.i(87859);
        String format = String.format("SELECT * FROM %s WHERE status = %d AND priority >= ? AND createtime > ? ORDER BY createtime DESC LIMIT 1;", "C2CMsgAutoDownloadRes", 1);
        Cursor rawQuery = this.AXQ.rawQuery(format, new String[]{String.valueOf(f2), String.valueOf(System.currentTimeMillis() - 432000000)});
        try {
            if (rawQuery.moveToNext()) {
                return m(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(87859);
            return null;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(87859);
        }
    }

    public final ic eCZ() {
        AppMethodBeat.i(87860);
        String format = String.format("SELECT * FROM %s WHERE status = %d AND (reason & %d) > 0 AND createtime > ? ORDER BY createtime DESC LIMIT 1;", "C2CMsgAutoDownloadRes", 1, 128);
        Cursor rawQuery = this.AXQ.rawQuery(format, new String[]{String.valueOf(System.currentTimeMillis() - 432000000)});
        try {
            if (rawQuery.moveToNext()) {
                return m(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(87860);
            return null;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(87860);
        }
    }

    public final ic j(String str, float f2) {
        AppMethodBeat.i(87861);
        String format = String.format("SELECT * FROM %s WHERE status = %d AND fromuser = ? AND priority >= ? AND createtime > ? ORDER BY createtime DESC LIMIT 1;", "C2CMsgAutoDownloadRes", 1);
        Cursor rawQuery = this.AXQ.rawQuery(format, new String[]{String.valueOf(str), String.valueOf(f2), String.valueOf(System.currentTimeMillis() - 432000000)});
        try {
            if (rawQuery.moveToNext()) {
                return m(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(87861);
            return null;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(87861);
        }
    }

    private static ic m(Cursor cursor) {
        AppMethodBeat.i(87862);
        ic icVar = new ic();
        icVar.KMm = cursor.getLong(0);
        icVar.KLZ = cursor.getString(1);
        icVar.KMa = cursor.getString(2);
        icVar.KMb = cursor.getInt(3);
        icVar.KMc = cursor.getLong(4);
        icVar.KMd = cursor.getInt(5);
        icVar.oTW = cursor.getInt(6);
        icVar.KMe = cursor.getLong(7);
        icVar.KMf = cursor.getLong(8);
        icVar.KMn = cursor.getInt(9);
        icVar.KMi = cursor.getLong(10);
        icVar.KMj = (double) cursor.getFloat(11);
        icVar.KMk = cursor.getInt(12);
        AppMethodBeat.o(87862);
        return icVar;
    }

    public final ic b(String str, int i2, float f2) {
        AppMethodBeat.i(87863);
        String format = String.format("SELECT * FROM %s Img, %s Chat WHERE Chat.rank <= ? AND Chat.totallsp > ? AND Chat.chat = ? AND Img.fromuser = ? AND Img.createtime > ? AND Img.status = ? ORDER BY Img.createtime DESC LIMIT 1;", "C2CMsgAutoDownloadRes", "C2CChatUsageResult");
        Cursor rawQuery = this.AXQ.rawQuery(format, new String[]{String.valueOf(i2), String.valueOf(f2), str, str, String.valueOf(System.currentTimeMillis() - 432000000), "1"});
        try {
            if (rawQuery.moveToNext()) {
                return m(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(87863);
            return null;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(87863);
        }
    }

    public final ic t(int i2, float f2) {
        AppMethodBeat.i(87864);
        String format = String.format("SELECT * FROM %s Img, %s Chat WHERE Chat.rank <= ? AND Chat.totallsp > ? AND Chat.chat = Img.fromuser AND createtime > ? AND Img.status = ? ORDER BY Img.createtime DESC LIMIT 1;", "C2CMsgAutoDownloadRes", "C2CChatUsageResult");
        Cursor rawQuery = this.AXQ.rawQuery(format, new String[]{String.valueOf(i2), String.valueOf(f2), String.valueOf(System.currentTimeMillis() - 432000000), "1"});
        try {
            if (rawQuery.moveToNext()) {
                return m(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(87864);
            return null;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(87864);
        }
    }
}
