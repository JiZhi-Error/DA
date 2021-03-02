package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class g extends MAutoStorage<f> {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS  shakemessage_status_index ON shakemessage ( status )", "CREATE INDEX IF NOT EXISTS shakemessage_type_index ON shakemessage ( type )"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(f.info, "shakemessage")};
    public ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(f fVar) {
        AppMethodBeat.i(28134);
        boolean a2 = a(fVar);
        AppMethodBeat.o(28134);
        return a2;
    }

    static {
        AppMethodBeat.i(28135);
        AppMethodBeat.o(28135);
    }

    public g(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, f.info, "shakemessage", INDEX_CREATE);
        this.db = iSQLiteDatabase;
    }

    public final boolean a(f fVar) {
        AppMethodBeat.i(28129);
        if (fVar == null) {
            Log.e("MicroMsg.ShakeMessageStorage", "insert fail, shakeMsg is null");
            AppMethodBeat.o(28129);
            return false;
        } else if (super.insert(fVar)) {
            doNotify(new StringBuilder().append(fVar.systemRowid).toString());
            AppMethodBeat.o(28129);
            return true;
        } else {
            AppMethodBeat.o(28129);
            return false;
        }
    }

    public final Cursor Xw(int i2) {
        AppMethodBeat.i(28130);
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM " + getTableName() + " ORDER BY rowid DESC LIMIT " + i2, null);
        AppMethodBeat.o(28130);
        return rawQuery;
    }

    public final int ctM() {
        int i2;
        AppMethodBeat.i(28131);
        Cursor rawQuery = this.db.rawQuery("select count(*) from " + getTableName() + " where status != 1", null, 2);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        } else {
            i2 = 0;
        }
        rawQuery.close();
        if (i2 > 0) {
            AppMethodBeat.o(28131);
            return i2;
        }
        AppMethodBeat.o(28131);
        return 0;
    }

    public final f eUd() {
        f fVar = null;
        AppMethodBeat.i(28132);
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM " + getTableName() + " where status != 1 ORDER BY rowid DESC LIMIT 1", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(28132);
        } else {
            if (rawQuery.moveToFirst()) {
                fVar = new f();
                fVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(28132);
        }
        return fVar;
    }

    public final List<f> eUe() {
        AppMethodBeat.i(28133);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM " + getTableName() + " where status != 1", null, 2);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                f fVar = new f();
                fVar.convertFrom(rawQuery);
                arrayList.add(fVar);
            }
            rawQuery.close();
        }
        AppMethodBeat.o(28133);
        return arrayList;
    }
}
