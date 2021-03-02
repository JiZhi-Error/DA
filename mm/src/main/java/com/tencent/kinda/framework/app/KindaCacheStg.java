package com.tencent.kinda.framework.app;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class KindaCacheStg extends MAutoStorage<KindaCacheItem> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(KindaCacheItem.info, "KindaCacheTable")};
    public static final String TABLE_NAME = "KindaCacheTable";
    public static final String TAG = "MicroMsg.KindaCacheStg";
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(18389);
        AppMethodBeat.o(18389);
    }

    public KindaCacheStg(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, KindaCacheItem.info, "KindaCacheTable", null);
        this.db = iSQLiteDatabase;
    }

    public void save(KindaCacheItem kindaCacheItem) {
        AppMethodBeat.i(18387);
        super.replace(kindaCacheItem);
        AppMethodBeat.o(18387);
    }

    public KindaCacheItem get(String str) {
        AppMethodBeat.i(18388);
        Cursor rawQuery = this.db.rawQuery("select * from KindaCacheTable where key=?", new String[]{str});
        if (rawQuery == null) {
            AppMethodBeat.o(18388);
            return null;
        } else if (rawQuery.getCount() == 0) {
            rawQuery.close();
            AppMethodBeat.o(18388);
            return null;
        } else {
            rawQuery.moveToFirst();
            KindaCacheItem kindaCacheItem = new KindaCacheItem();
            kindaCacheItem.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(18388);
            return kindaCacheItem;
        }
    }
}
