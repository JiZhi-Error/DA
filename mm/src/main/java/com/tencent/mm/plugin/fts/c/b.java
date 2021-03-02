package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class b extends com.tencent.mm.plugin.fts.a.a {
    private SQLiteStatement wZH;

    public static class a {
        public long timestamp;
        public int wZI;
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final void awY() {
        AppMethodBeat.i(52794);
        if (awZ()) {
            this.wUt.execSQL(String.format("DROP TABLE IF EXISTS %s", "Feature"));
            W(-101, 3);
        }
        if (!this.wUt.ayi("Feature")) {
            this.wUt.execSQL("CREATE TABLE IF NOT EXISTS Feature ( " + d.info.sql + ");");
        }
        this.wZH = this.wUt.compileStatement(String.format("INSERT INTO %s (featureId, title, titlePY, titleShortPY, tag, actionType, url, helpUrl, updateUrl, androidUrl, iconPath, timestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", "Feature"));
        AppMethodBeat.o(52794);
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final boolean awZ() {
        AppMethodBeat.i(52795);
        if (!gD(-101, 3)) {
            AppMethodBeat.o(52795);
            return true;
        }
        AppMethodBeat.o(52795);
        return false;
    }

    public final List<a> dOY() {
        AppMethodBeat.i(52796);
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Cursor rawQuery = this.wUt.rawQuery(String.format("SELECT entity_id, timestamp FROM %s", dOt()), null);
        while (rawQuery.moveToNext()) {
            int i2 = rawQuery.getInt(0);
            if (hashSet.add(Integer.valueOf(i2))) {
                a aVar = new a();
                aVar.wZI = i2;
                aVar.timestamp = rawQuery.getLong(1);
                arrayList.add(aVar);
            }
        }
        rawQuery.close();
        AppMethodBeat.o(52796);
        return arrayList;
    }

    public final d Np(int i2) {
        AppMethodBeat.i(52798);
        Cursor rawQuery = this.wUt.rawQuery("Select * from Feature where featureId = ".concat(String.valueOf(i2)), null);
        try {
            if (!rawQuery.moveToFirst()) {
                return null;
            }
            d dVar = new d();
            dVar.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(52798);
            return dVar;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(52798);
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final String getTableName() {
        return "Feature";
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final String getName() {
        return "FTS5FeatureStorage";
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final int getType() {
        return 17;
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final int getPriority() {
        return 17;
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final boolean axa() {
        AppMethodBeat.i(52799);
        super.axa();
        this.wZH.close();
        AppMethodBeat.o(52799);
        return true;
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final boolean dOv() {
        return true;
    }

    public final boolean eR(List<d> list) {
        AppMethodBeat.i(52797);
        boolean inTransaction = this.wUt.inTransaction();
        if (!inTransaction) {
            this.wUt.beginTransaction();
        }
        this.wUt.execSQL("Delete from Feature");
        for (d dVar : list) {
            try {
                this.wZH.bindLong(1, (long) dVar.field_featureId);
                this.wZH.bindString(2, dVar.field_title);
                this.wZH.bindString(3, dVar.field_titlePY);
                this.wZH.bindString(4, dVar.field_titleShortPY);
                this.wZH.bindString(5, dVar.field_tag);
                this.wZH.bindLong(6, (long) dVar.field_actionType);
                this.wZH.bindString(7, dVar.field_url);
                this.wZH.bindString(8, dVar.field_helpUrl);
                this.wZH.bindString(9, dVar.field_updateUrl);
                this.wZH.bindString(10, dVar.field_androidUrl);
                this.wZH.bindString(11, dVar.field_iconPath);
                this.wZH.bindLong(12, dVar.field_timestamp);
                Log.d("MicroMsg.FTS.FTS5FeatureStorage", "insertFeatureItem rowid=%d timestamp=%d", Long.valueOf(this.wZH.executeInsert()), Long.valueOf(dVar.field_timestamp));
            } catch (Exception e2) {
            }
        }
        if (!inTransaction) {
            this.wUt.commit();
        }
        AppMethodBeat.o(52797);
        return true;
    }
}
