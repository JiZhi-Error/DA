package com.tencent.mm.plugin.websearch.widget.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class b extends MAutoStorage<a> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "WidgetSafeMode")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(116653);
        AppMethodBeat.o(116653);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "WidgetSafeMode", null);
        this.db = iSQLiteDatabase;
    }
}
