package com.tencent.mm.plugin.card.sharecard.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class o extends MAutoStorage<n> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(n.info, "ShareCardSyncItemInfo")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(113027);
        AppMethodBeat.o(113027);
    }

    public o(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, n.info, "ShareCardSyncItemInfo", null);
        this.db = iSQLiteDatabase;
    }

    public final List<n> ctO() {
        AppMethodBeat.i(113026);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.db.rawQuery("select * from ShareCardSyncItemInfo where retryCount < 10", null, 2);
        while (rawQuery.moveToNext()) {
            n nVar = new n();
            nVar.convertFrom(rawQuery);
            arrayList.add(nVar);
        }
        rawQuery.close();
        Log.d("MicroMsg.ShareCardSyncItemInfoStorage", "getAll, share card count = %d", Integer.valueOf(arrayList.size()));
        AppMethodBeat.o(113026);
        return arrayList;
    }
}
