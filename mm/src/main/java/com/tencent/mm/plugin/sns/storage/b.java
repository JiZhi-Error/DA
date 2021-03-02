package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b extends MAutoStorage<a> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "CanvasInfo")};

    static {
        AppMethodBeat.i(96282);
        AppMethodBeat.o(96282);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        this(iSQLiteDatabase, a.info, "CanvasInfo");
    }

    private b(ISQLiteDatabase iSQLiteDatabase, IAutoDBItem.MAutoDBInfo mAutoDBInfo, String str) {
        super(iSQLiteDatabase, mAutoDBInfo, str, null);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(96281);
        if (aVar == null) {
            AppMethodBeat.o(96281);
            return;
        }
        aVar.field_createTime = System.currentTimeMillis();
        if (!insert(aVar)) {
            update(aVar, new String[0]);
        }
        AppMethodBeat.o(96281);
    }
}
