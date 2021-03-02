package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gw;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.concurrent.ConcurrentHashMap;

public final class cq extends MAutoStorage<gw> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(cp.info, "TablesVersion")};
    public h iFy;

    static {
        AppMethodBeat.i(133310);
        AppMethodBeat.o(133310);
    }

    public cq(h hVar) {
        super(hVar, cp.info, "TablesVersion", gw.INDEX_CREATE);
        this.iFy = hVar;
    }

    public final ConcurrentHashMap<Integer, String> gEy() {
        AppMethodBeat.i(133309);
        Cursor rawQuery = this.iFy.rawQuery("select * from TablesVersion", new String[0]);
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        if (rawQuery == null) {
            AppMethodBeat.o(133309);
        } else {
            while (rawQuery.moveToNext()) {
                try {
                    concurrentHashMap.putIfAbsent(Integer.valueOf(rawQuery.getInt(0)), rawQuery.getString(1));
                } finally {
                    rawQuery.close();
                    AppMethodBeat.o(133309);
                }
            }
        }
        return concurrentHashMap;
    }
}
