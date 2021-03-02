package com.tencent.mm.plugin.appbrand.appcache.predownload.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ab.c;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class d extends c<c> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(c.iBg, "PredownloadCmdGetCodePersistentInfo2"), "DROP TABLE IF EXISTS PredownloadCmdGetCodePersistentInfo"};
    private final ISQLiteDatabase kLX;

    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.iBg, "PredownloadCmdGetCodePersistentInfo2", c.INDEX_CREATE);
        this.kLX = iSQLiteDatabase;
    }

    static {
        AppMethodBeat.i(44439);
        AppMethodBeat.o(44439);
    }

    public final List<c> c(String str, String... strArr) {
        AppMethodBeat.i(44438);
        Cursor query = this.kLX.query("PredownloadCmdGetCodePersistentInfo2", null, str, strArr, null, null, null);
        if (query == null || query.isClosed()) {
            List<c> emptyList = Collections.emptyList();
            AppMethodBeat.o(44438);
            return emptyList;
        }
        LinkedList linkedList = new LinkedList();
        if (query.moveToFirst()) {
            do {
                c cVar = new c();
                cVar.convertFrom(query);
                linkedList.add(cVar);
            } while (query.moveToNext());
        }
        query.close();
        AppMethodBeat.o(44438);
        return linkedList;
    }
}
