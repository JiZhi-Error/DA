package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class al extends MAutoStorage<ak> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(ak.info, "PendingCardId")};
    ISQLiteDatabase db;

    static {
        AppMethodBeat.i(112871);
        AppMethodBeat.o(112871);
    }

    public al(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, ak.info, "PendingCardId", null);
        this.db = iSQLiteDatabase;
    }

    public final List<ak> ctO() {
        AppMethodBeat.i(112870);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.db.rawQuery("select * from PendingCardId where retryCount < 10", null, 2);
        while (rawQuery.moveToNext()) {
            ak akVar = new ak();
            akVar.convertFrom(rawQuery);
            arrayList.add(akVar);
        }
        rawQuery.close();
        Log.d("MicroMsg.PendingCardIdInfoStorage", "getAll, count = %d", Integer.valueOf(arrayList.size()));
        AppMethodBeat.o(112870);
        return arrayList;
    }
}
