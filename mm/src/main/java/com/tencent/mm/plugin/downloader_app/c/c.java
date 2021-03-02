package com.tencent.mm.plugin.downloader_app.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class c extends MAutoStorage<a> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "DownloadTaskItem")};

    static {
        AppMethodBeat.i(8965);
        AppMethodBeat.o(8965);
    }

    public c(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "DownloadTaskItem", null);
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(8964);
        boolean update = update(aVar, new String[0]);
        AppMethodBeat.o(8964);
        return update;
    }
}
