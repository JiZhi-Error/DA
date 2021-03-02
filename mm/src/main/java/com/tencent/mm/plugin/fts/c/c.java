package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class c extends a {
    private SQLiteStatement wZJ;
    private SQLiteStatement wZK;

    @Override // com.tencent.mm.plugin.fts.a.a
    public final void awY() {
        AppMethodBeat.i(52800);
        if (awZ()) {
            this.wUt.W(-105, 3);
            this.wUt.W(-200, MAlarmHandler.NEXT_FIRE_INTERVAL);
        }
        this.wUt.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", dOt(), dOt()));
        this.wUt.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_talker ON %s(talker);", dOt(), dOt()));
        this.wZJ = this.wUt.compileStatement(String.format("UPDATE %s SET status = ? WHERE aux_index = ? AND status <> ?", dOt()));
        this.wZK = this.wUt.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, talker) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?);", dOt()));
        AppMethodBeat.o(52800);
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final boolean axa() {
        AppMethodBeat.i(52801);
        this.wZJ.close();
        this.wZK.close();
        boolean axa = super.axa();
        AppMethodBeat.o(52801);
        return axa;
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final String getTableName() {
        return "Message";
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final String getName() {
        return "FTS5MessageStorage";
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final int getType() {
        return 4;
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final int getPriority() {
        return 4;
    }

    public final void a(int[] iArr, long j2, long j3) {
        AppMethodBeat.i(52802);
        ArrayList arrayList = new ArrayList(4);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + d.C(iArr) + " AND entity_id=? AND timestamp=?;", dOt());
        Cursor rawQuery = this.wUt.rawQuery(format, new String[]{Long.toString(j2), Long.toString(j3)});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        eN(arrayList);
        AppMethodBeat.o(52802);
    }

    public final Cursor a(h hVar, String str, Set<String> set) {
        String str2;
        AppMethodBeat.i(52803);
        String dOz = hVar.dOz();
        if (!Util.isNullOrNil(str)) {
            str2 = String.format(" AND aux_index = '%s'", str);
        } else {
            str2 = "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str3 : set) {
            stringBuffer.append("'");
            stringBuffer.append(str3);
            stringBuffer.append("'");
            stringBuffer.append(",");
        }
        Cursor rawQuery = this.wUt.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + (stringBuffer.length() > 0 ? " AND talker IN (" + stringBuffer.substring(0, stringBuffer.length() - 1) + ")" : "") + str2 + " AND status >= 0;", dOt(), dOt(), dOu(), dOt(), dOu(), dOu(), dOz), null);
        AppMethodBeat.o(52803);
        return rawQuery;
    }

    public final Cursor a(h hVar, List<String> list) {
        AppMethodBeat.i(52804);
        String dOz = hVar.dOz();
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : list) {
            stringBuffer.append("'");
            stringBuffer.append(str);
            stringBuffer.append("',");
        }
        Cursor rawQuery = this.wUt.rawQuery(String.format("SELECT MessageCount(%d, aux_index) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index IN (%s) AND status >= 0;", Integer.valueOf(list.size()), dOt(), dOu(), dOt(), dOu(), dOu(), dOz, stringBuffer.substring(0, stringBuffer.length() - 1)), null);
        AppMethodBeat.o(52804);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final boolean awZ() {
        AppMethodBeat.i(52805);
        if (!gD(-105, 3)) {
            AppMethodBeat.o(52805);
            return true;
        }
        AppMethodBeat.o(52805);
        return false;
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final String cVp() {
        AppMethodBeat.i(52806);
        String format = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, talker TEXT);", dOt());
        AppMethodBeat.o(52806);
        return format;
    }

    public final Cursor d(int[] iArr, String str) {
        AppMethodBeat.i(187311);
        String concat = Util.isNullOrNil(str) ? "" : "AND aux_index = ".concat(String.valueOf(str));
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 : iArr) {
            stringBuffer.append(i2);
            stringBuffer.append(",");
        }
        Cursor rawQuery = this.wUt.rawQuery(String.format("SELECT type, subtype, entity_id, aux_index, timestamp, talker FROM %s WHERE subtype IN (%s) %s AND status >= 0 ORDER BY timestamp desc;", dOt(), stringBuffer.substring(0, stringBuffer.length() - 1), concat), null);
        AppMethodBeat.o(187311);
        return rawQuery;
    }

    public final void a(int i2, long j2, String str, long j3, String str2, String str3) {
        AppMethodBeat.i(52807);
        try {
            this.wUu.bindString(1, str2);
            this.wUu.execute();
            this.wZK.bindLong(1, 65536);
            this.wZK.bindLong(2, (long) i2);
            this.wZK.bindLong(3, j2);
            this.wZK.bindString(4, str);
            this.wZK.bindLong(5, j3);
            this.wZK.bindString(6, str3);
            this.wZK.execute();
            AppMethodBeat.o(52807);
        } catch (SQLiteException e2) {
            Log.e("MicroMsg.FTS.FTS5MessageStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", 65536, Integer.valueOf(i2), Long.valueOf(j2), str, Long.valueOf(j3)));
            String simpleQueryForString = this.wUB.simpleQueryForString();
            if (simpleQueryForString != null && simpleQueryForString.length() > 0) {
                Log.e("MicroMsg.FTS.FTS5MessageStorage", ">> ".concat(String.valueOf(simpleQueryForString)));
            }
            AppMethodBeat.o(52807);
            throw e2;
        }
    }
}
