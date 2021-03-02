package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;
import java.util.List;

public final class l extends MAutoStorage<j> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(j.info, "SightDraftInfo")};
    ISQLiteDatabase db;

    static {
        AppMethodBeat.i(126894);
        AppMethodBeat.o(126894);
    }

    public l(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, j.info, "SightDraftInfo", null);
        this.db = iSQLiteDatabase;
    }

    public final List<j> bhd() {
        AppMethodBeat.i(126892);
        LinkedList linkedList = new LinkedList();
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC " + new StringBuilder(" LIMIT 5").toString(), new String[]{"7"}, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(126892);
        } else {
            while (rawQuery.moveToNext()) {
                j jVar = new j();
                jVar.convertFrom(rawQuery);
                linkedList.add(jVar);
            }
            rawQuery.close();
            AppMethodBeat.o(126892);
        }
        return linkedList;
    }

    public final Cursor bhe() {
        AppMethodBeat.i(126893);
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC ", new String[]{"1"});
        AppMethodBeat.o(126893);
        return rawQuery;
    }
}
