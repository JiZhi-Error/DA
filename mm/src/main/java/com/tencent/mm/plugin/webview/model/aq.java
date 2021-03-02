package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class aq extends MAutoStorage<ap> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(ap.info, "WebviewLocalData")};

    static {
        AppMethodBeat.i(79031);
        AppMethodBeat.o(79031);
    }

    public aq(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, ap.info, "WebviewLocalData", null);
    }

    public static int be(String str, String str2, String str3) {
        AppMethodBeat.i(79030);
        int hashCode = (str + str2 + str3).hashCode();
        AppMethodBeat.o(79030);
        return hashCode;
    }
}
