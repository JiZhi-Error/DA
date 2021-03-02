package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class m extends MAutoStorage<i> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(i.info, "WebViewHostsFilter")};
    private final ISQLiteDatabase db;

    static {
        AppMethodBeat.i(79224);
        AppMethodBeat.o(79224);
    }

    public m(ISQLiteDatabase iSQLiteDatabase) {
        this(iSQLiteDatabase, i.info, "WebViewHostsFilter");
    }

    private m(ISQLiteDatabase iSQLiteDatabase, IAutoDBItem.MAutoDBInfo mAutoDBInfo, String str) {
        super(iSQLiteDatabase, mAutoDBInfo, str, null);
        this.db = iSQLiteDatabase;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Set<java.lang.String> gdE() {
        /*
        // Method dump skipped, instructions count: 145
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.modeltools.m.gdE():java.util.Set");
    }
}
