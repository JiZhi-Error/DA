package com.tencent.mm.plugin.fav.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    private SQLiteStatement tbN;

    @Override // com.tencent.mm.plugin.fts.a.a
    public final void awY() {
        AppMethodBeat.i(101557);
        if (awZ()) {
            this.wUt.W(-106, 4);
        }
        this.tbN = this.wUt.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, fav_type) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?);", dOt()));
        AppMethodBeat.o(101557);
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final boolean awZ() {
        AppMethodBeat.i(101558);
        if (!gD(-106, 4)) {
            AppMethodBeat.o(101558);
            return true;
        }
        AppMethodBeat.o(101558);
        return false;
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final String getTableName() {
        return "Favorite";
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final String getName() {
        return "FTS5FavoriteStorage";
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final int getType() {
        return 256;
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final int getPriority() {
        return 256;
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final String cVp() {
        AppMethodBeat.i(101559);
        String format = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, fav_type INT DEFAULT 0);", dOt());
        AppMethodBeat.o(101559);
        return format;
    }

    public final void a(int i2, long j2, String str, long j3, String str2, int i3) {
        AppMethodBeat.i(101560);
        String ayp = d.ayp(str2);
        if (Util.isNullOrNil(ayp)) {
            AppMethodBeat.o(101560);
            return;
        }
        boolean inTransaction = this.wUt.inTransaction();
        if (!inTransaction) {
            this.wUt.beginTransaction();
        }
        try {
            this.wUu.bindString(1, ayp);
            this.wUu.execute();
            this.tbN.bindLong(1, 196608);
            this.tbN.bindLong(2, (long) i2);
            this.tbN.bindLong(3, j2);
            this.tbN.bindString(4, str);
            this.tbN.bindLong(5, j3);
            this.tbN.bindLong(6, (long) i3);
            this.tbN.execute();
            if (!inTransaction) {
                this.wUt.commit();
            }
            AppMethodBeat.o(101560);
        } catch (SQLiteException e2) {
            Log.e("MicroMsg.FTS.FTS5FavoriteStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", 196608, Integer.valueOf(i2), Long.valueOf(j2), str, Long.valueOf(j3)));
            String simpleQueryForString = this.wUB.simpleQueryForString();
            if (simpleQueryForString != null && simpleQueryForString.length() > 0) {
                Log.e("MicroMsg.FTS.FTS5FavoriteStorage", ">> ".concat(String.valueOf(simpleQueryForString)));
            }
            AppMethodBeat.o(101560);
            throw e2;
        }
    }
}
