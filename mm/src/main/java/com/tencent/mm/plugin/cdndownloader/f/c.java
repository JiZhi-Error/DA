package com.tencent.mm.plugin.cdndownloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class c extends MAutoStorage<a> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "CdnDownloadInfo")};

    static {
        AppMethodBeat.i(120815);
        AppMethodBeat.o(120815);
    }

    public c(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "CdnDownloadInfo", null);
    }

    public final boolean akw(String str) {
        AppMethodBeat.i(120814);
        boolean execSQL = execSQL("CdnDownloadInfo", String.format("delete from %s where %s=%s", "CdnDownloadInfo", "downloadUrlHashCode", Integer.valueOf(str.hashCode())));
        AppMethodBeat.o(120814);
        return execSQL;
    }
}
